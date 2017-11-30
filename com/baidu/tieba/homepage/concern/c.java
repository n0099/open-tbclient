package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.g;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aXw;
    private f bhz;
    private PbListView blu;
    private CustomMessageListener cHR;
    private View cIF;
    private com.baidu.tieba.homepage.concern.a dmD;
    private a dmE;
    private d dmF;
    private g dmG;
    private boolean dmH;
    private d.a dmI;
    private View.OnClickListener dmJ;
    private CustomMessageListener dmK;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void lX(String str);

        void onPullToRefresh();

        void z(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aXw != null) {
            this.aXw.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dmD != null) {
            this.dmD.setPageUniqueId(bdUniqueId);
        }
        if (this.dmF != null) {
            this.dmF.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cHR != null) {
            this.cHR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cHR);
        }
        if (this.dmK != null) {
            this.dmK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dmK);
        }
    }

    public c(Context context) {
        super(context);
        this.dmH = false;
        this.mSkinType = 3;
        this.dmI = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void atw() {
                if (c.this.dmE == null) {
                    if (c.this.dmG != null) {
                        c.this.dmG.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.x(false, false);
                    return;
                }
                boolean atr = c.this.atr();
                c.this.Pr();
                if (atr) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.dmE.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lW(String str) {
                if (c.this.dmE != null) {
                    c.this.dmE.lX(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.x(false, false);
                if (i == 1) {
                    if (c.this.dmF != null) {
                        c.this.fS(c.this.dmF.hasMore());
                    }
                    if (j.hh()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aXw.setVisibility(8);
                if (c.this.dmG != null) {
                    c.this.dmG.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void y(boolean z, boolean z2) {
                if (c.this.dmF != null) {
                    c.this.fS(c.this.dmF.hasMore());
                }
                c.this.aXw.setVisibility(0);
                c.this.x(z, z2);
                c.this.Pr();
            }
        };
        this.dmJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.OI();
            }
        };
        this.cHR = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !v.w(c.this.dmF.getDataList()) && (c.this.dmF.getDataList().get(0) instanceof com.baidu.tbadk.data.f) && !v.w(((com.baidu.tbadk.data.f) c.this.dmF.getDataList().get(0)).getList())) {
                        List<com.baidu.adp.widget.ListView.f> list = ((com.baidu.tbadk.data.f) c.this.dmF.getDataList().get(0)).getList();
                        int size = list.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = -1;
                                break;
                            } else if ((list.get(i2) instanceof com.baidu.tbadk.data.g) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.g) list.get(i2)).user_id))) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        com.baidu.tbadk.data.g gVar = new com.baidu.tbadk.data.g();
                        gVar.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        gVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                        gVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                        gVar.mStatus = 3;
                        gVar.aAn = String.valueOf(0);
                        gVar.aAm = bVar;
                        if (i != -1) {
                            list.set(i, gVar);
                        } else {
                            list.add(1, gVar);
                        }
                        c.this.dmF.aty();
                    }
                }
            }
        };
        this.dmK = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.dmH = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aXw = new BdTypeListView(context);
        this.aXw.setDividerHeight(0);
        this.aXw.setSelector(17170445);
        this.blu = new PbListView(context);
        this.blu.getView();
        this.blu.dy(d.C0082d.cp_bg_line_e);
        this.blu.setHeight(l.f(context, d.e.tbds182));
        this.blu.wu();
        this.blu.setTextSize(d.e.tbds30);
        this.blu.setTextColor(aj.getColor(d.C0082d.cp_cont_j));
        this.blu.dx(d.C0082d.cp_cont_e);
        this.blu.setOnClickListener(this.dmJ);
        this.aXw.setNextPage(this.blu);
        e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aXw.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        if (TbadkCoreApplication.isLogin()) {
            this.cIF = BdListViewHelper.a(context, this.aXw, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dmD = new com.baidu.tieba.homepage.concern.a(context, this.aXw);
        this.dmF = new d(this.pageContext, this.aXw, this.dmD);
        addView(this.aXw);
        this.aXw.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.cIF != null && this.cIF.getLayoutParams() != null) {
            this.cIF.getLayoutParams().height = i;
            this.cIF.setLayoutParams(this.cIF.getLayoutParams());
        }
    }

    public void aoQ() {
        this.dmF.a(this.dmI);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.dmF.update();
                }
            }
        });
        this.aXw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.OI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(boolean z) {
        if (this.blu != null) {
            if (z) {
                this.blu.wz();
                this.blu.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.blu.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dmE = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.blu != null) {
            this.blu.wy();
            this.blu.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dmF.a(z, dataRes, 0, null);
    }

    public void atq() {
        if (!TbadkCoreApplication.isLogin()) {
            ats();
        } else if (this.dmF != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dmF.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dmF != null) {
            this.dmF.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dmG != null) {
                this.dmG.onChangeSkinType(i);
            }
            if (this.bhz != null) {
                this.bhz.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.blu != null) {
                this.blu.setTextColor(aj.getColor(d.C0082d.cp_cont_d));
                this.blu.dz(i);
            }
            this.dmD.onChangeSkinType(i);
            aj.k(this, d.C0082d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        atu();
    }

    public void V(String str, int i) {
        if (this.blu != null) {
            this.blu.wy();
            this.blu.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dmF.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dmF != null && TbadkCoreApplication.isLogin()) {
                        c.this.dmF.update();
                    }
                }
            });
        }
        this.refreshView.fi(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gC(str);
        this.refreshView.c(view, z);
        this.refreshView.EV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pr() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        if (this.bhz != null) {
            this.bhz.O(this);
            this.bhz = null;
            this.aXw.setNextPage(this.blu);
        }
        if (this.dmE != null) {
            this.dmE.z(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atr() {
        if (this.refreshView != null) {
            return this.refreshView.EN();
        }
        return false;
    }

    private void ats() {
        if (this.dmG == null) {
            this.dmG = new com.baidu.tieba.homepage.concern.view.g(getContext());
            this.dmG.onChangeSkinType(this.mSkinType);
        }
        if (this.dmG.getParent() == null) {
            this.aXw.setVisibility(8);
            this.dmG.setVisibility(0);
            addView(this.dmG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bhz == null) {
            if (i < 0) {
                this.bhz = new f(getContext());
            } else {
                this.bhz = new f(getContext(), i);
            }
            this.bhz.onChangeSkinType();
        }
        this.bhz.c(this, z);
        this.aXw.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dmF != null) {
            this.dmF.setTabInForeBackgroundState(z);
        }
    }

    public void att() {
        setViewForeground(false);
        if (this.dmF != null) {
            this.dmF.eW(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dmF != null) {
            this.dmF.fT(z);
        }
    }

    public void reload() {
        if (this.aXw != null) {
            if (this.dmH && this.aXw.getFirstVisiblePosition() != 0) {
                this.dmH = false;
                return;
            }
            this.aXw.setSelection(0);
            if (this.aXw.isRefreshDone()) {
                this.aXw.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dmF.a((d.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aXw.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        this.aXw.setRecyclerListener(null);
    }

    public void atu() {
        if (this.dmD != null) {
            this.dmD.notifyDataSetChanged();
        }
    }

    public void atv() {
        if (this.dmF != null) {
            this.dmF.eW(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        if (this.blu != null && !this.blu.wC()) {
            this.blu.wx();
            this.blu.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dmF.OI();
    }
}
