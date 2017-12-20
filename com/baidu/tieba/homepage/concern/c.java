package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
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
    private BdTypeListView aXy;
    private f bhA;
    private PbListView blv;
    private View cIO;
    private CustomMessageListener cIa;
    private com.baidu.tieba.homepage.concern.a dnI;
    private a dnJ;
    private d dnK;
    private g dnL;
    private boolean dnM;
    private d.a dnN;
    private View.OnClickListener dnO;
    private CustomMessageListener dnP;
    private i mPullView;
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
        if (this.aXy != null) {
            this.aXy.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dnI != null) {
            this.dnI.setPageUniqueId(bdUniqueId);
        }
        if (this.dnK != null) {
            this.dnK.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cIa != null) {
            this.cIa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cIa);
        }
        if (this.dnP != null) {
            this.dnP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dnP);
        }
    }

    public c(Context context) {
        super(context);
        this.dnM = false;
        this.mSkinType = 3;
        this.dnN = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void atE() {
                if (c.this.dnJ == null) {
                    if (c.this.dnL != null) {
                        c.this.dnL.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.x(false, false);
                    return;
                }
                boolean atz = c.this.atz();
                c.this.Pr();
                if (atz) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.dnJ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lW(String str) {
                if (c.this.dnJ != null) {
                    c.this.dnJ.lX(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.x(false, false);
                c.this.completePullRefresh();
                if (i == 1) {
                    if (c.this.dnK != null) {
                        c.this.fT(c.this.dnK.hasMore());
                    }
                    if (j.hh()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aXy.setVisibility(8);
                if (c.this.dnL != null) {
                    c.this.dnL.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void y(boolean z, boolean z2) {
                c.this.completePullRefresh();
                if (c.this.dnK != null) {
                    c.this.fT(c.this.dnK.hasMore());
                }
                c.this.aXy.setVisibility(0);
                c.this.x(z, z2);
                c.this.Pr();
            }
        };
        this.dnO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.OI();
            }
        };
        this.cIa = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !v.w(c.this.dnK.getDataList()) && (c.this.dnK.getDataList().get(0) instanceof com.baidu.tbadk.data.f) && !v.w(((com.baidu.tbadk.data.f) c.this.dnK.getDataList().get(0)).getList())) {
                        List<com.baidu.adp.widget.ListView.f> list = ((com.baidu.tbadk.data.f) c.this.dnK.getDataList().get(0)).getList();
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
                        gVar.aAs = String.valueOf(0);
                        gVar.aAr = bVar;
                        if (i != -1) {
                            list.set(i, gVar);
                        } else {
                            list.add(1, gVar);
                        }
                        c.this.dnK.atG();
                    }
                }
            }
        };
        this.dnP = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.dnM = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aXy = new BdTypeListView(context);
        this.aXy.setDividerHeight(0);
        this.aXy.setSelector(17170445);
        this.blv = new PbListView(context);
        this.blv.getView();
        this.blv.dy(d.C0096d.cp_bg_line_e);
        this.blv.setHeight(l.f(context, d.e.tbds182));
        this.blv.ws();
        this.blv.setTextSize(d.e.tbds30);
        this.blv.setTextColor(aj.getColor(d.C0096d.cp_cont_j));
        this.blv.dx(d.C0096d.cp_cont_e);
        this.blv.setOnClickListener(this.dnO);
        this.aXy.setNextPage(this.blv);
        e<?> Y = com.baidu.adp.base.i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new i(this.pageContext);
        this.aXy.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        if (TbadkCoreApplication.isLogin()) {
            this.cIO = BdListViewHelper.a(context, this.aXy, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dnI = new com.baidu.tieba.homepage.concern.a(context, this.aXy);
        this.dnK = new d(this.pageContext, this.aXy, this.dnI);
        addView(this.aXy);
        this.aXy.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.cIO != null && this.cIO.getLayoutParams() != null) {
            this.cIO.getLayoutParams().height = i;
            this.cIO.setLayoutParams(this.cIO.getLayoutParams());
        }
    }

    public void aoY() {
        this.dnK.a(this.dnN);
        this.mPullView.a(new h.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.dnK.update();
                }
            }
        });
        this.aXy.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.OI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(boolean z) {
        if (this.blv != null) {
            if (z) {
                this.blv.wx();
                this.blv.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.blv.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dnJ = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.blv != null) {
            this.blv.ww();
            this.blv.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dnK.a(z, dataRes, 0, null);
    }

    public void aty() {
        if (!TbadkCoreApplication.isLogin()) {
            atA();
        } else if (this.dnK != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dnK.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dnK != null) {
            this.dnK.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dnL != null) {
                this.dnL.onChangeSkinType(i);
            }
            if (this.bhA != null) {
                this.bhA.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.blv != null) {
                this.blv.setTextColor(aj.getColor(d.C0096d.cp_cont_d));
                this.blv.dz(i);
            }
            this.dnI.onChangeSkinType(i);
            aj.k(this, d.C0096d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        atC();
    }

    public void W(String str, int i) {
        if (this.blv != null) {
            this.blv.ww();
            this.blv.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dnK.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dnK != null && TbadkCoreApplication.isLogin()) {
                        c.this.dnK.update();
                    }
                }
            });
        }
        this.refreshView.fi(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gB(str);
        this.refreshView.c(view, z);
        this.refreshView.EW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pr() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        if (this.bhA != null) {
            this.bhA.P(this);
            this.bhA = null;
            this.aXy.setNextPage(this.blv);
        }
        if (this.dnJ != null) {
            this.dnJ.z(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atz() {
        if (this.refreshView != null) {
            return this.refreshView.EO();
        }
        return false;
    }

    private void atA() {
        if (this.dnL == null) {
            this.dnL = new g(getContext());
            this.dnL.onChangeSkinType(this.mSkinType);
        }
        if (this.dnL.getParent() == null) {
            this.aXy.setVisibility(8);
            this.dnL.setVisibility(0);
            addView(this.dnL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bhA == null) {
            if (i < 0) {
                this.bhA = new f(getContext());
            } else {
                this.bhA = new f(getContext(), i);
            }
            this.bhA.onChangeSkinType();
        }
        this.bhA.c(this, z);
        this.aXy.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dnK != null) {
            this.dnK.setTabInForeBackgroundState(z);
        }
    }

    public void atB() {
        setViewForeground(false);
        if (this.dnK != null) {
            this.dnK.eX(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dnK != null) {
            this.dnK.fU(z);
        }
    }

    public void reload() {
        if (this.aXy != null) {
            if (this.dnM && this.aXy.getFirstVisiblePosition() != 0) {
                this.dnM = false;
                return;
            }
            this.aXy.setSelection(0);
            if (this.aXy.isRefreshDone()) {
                this.aXy.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dnK.a((d.a) null);
        this.mPullView.a((h.b) null);
        this.mPullView.a((h.c) null);
        this.aXy.setOnSrollToBottomListener(null);
        this.mPullView.a((h.a) null);
        this.mPullView.release();
        this.aXy.setRecyclerListener(null);
    }

    public void atC() {
        if (this.dnI != null) {
            this.dnI.notifyDataSetChanged();
        }
    }

    public void atD() {
        if (this.dnK != null) {
            this.dnK.eX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        if (this.blv != null && !this.blv.wA()) {
            this.blv.wv();
            this.blv.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dnK.OI();
    }
}
