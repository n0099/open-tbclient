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
    private BdTypeListView aXC;
    private f bhE;
    private PbListView blz;
    private View cIS;
    private CustomMessageListener cIe;
    private com.baidu.tieba.homepage.concern.a dnM;
    private a dnN;
    private d dnO;
    private g dnP;
    private boolean dnQ;
    private d.a dnR;
    private View.OnClickListener dnS;
    private CustomMessageListener dnT;
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
        if (this.aXC != null) {
            this.aXC.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dnM != null) {
            this.dnM.setPageUniqueId(bdUniqueId);
        }
        if (this.dnO != null) {
            this.dnO.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cIe != null) {
            this.cIe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cIe);
        }
        if (this.dnT != null) {
            this.dnT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dnT);
        }
    }

    public c(Context context) {
        super(context);
        this.dnQ = false;
        this.mSkinType = 3;
        this.dnR = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void atF() {
                if (c.this.dnN == null) {
                    if (c.this.dnP != null) {
                        c.this.dnP.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.x(false, false);
                    return;
                }
                boolean atA = c.this.atA();
                c.this.Pr();
                if (atA) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.dnN.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lW(String str) {
                if (c.this.dnN != null) {
                    c.this.dnN.lX(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.x(false, false);
                c.this.completePullRefresh();
                if (i == 1) {
                    if (c.this.dnO != null) {
                        c.this.fT(c.this.dnO.hasMore());
                    }
                    if (j.hh()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aXC.setVisibility(8);
                if (c.this.dnP != null) {
                    c.this.dnP.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void y(boolean z, boolean z2) {
                c.this.completePullRefresh();
                if (c.this.dnO != null) {
                    c.this.fT(c.this.dnO.hasMore());
                }
                c.this.aXC.setVisibility(0);
                c.this.x(z, z2);
                c.this.Pr();
            }
        };
        this.dnS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.OI();
            }
        };
        this.cIe = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !v.w(c.this.dnO.getDataList()) && (c.this.dnO.getDataList().get(0) instanceof com.baidu.tbadk.data.f) && !v.w(((com.baidu.tbadk.data.f) c.this.dnO.getDataList().get(0)).getList())) {
                        List<com.baidu.adp.widget.ListView.f> list = ((com.baidu.tbadk.data.f) c.this.dnO.getDataList().get(0)).getList();
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
                        gVar.aAv = String.valueOf(0);
                        gVar.aAu = bVar;
                        if (i != -1) {
                            list.set(i, gVar);
                        } else {
                            list.add(1, gVar);
                        }
                        c.this.dnO.atH();
                    }
                }
            }
        };
        this.dnT = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.dnQ = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aXC = new BdTypeListView(context);
        this.aXC.setDividerHeight(0);
        this.aXC.setSelector(17170445);
        this.blz = new PbListView(context);
        this.blz.getView();
        this.blz.dy(d.C0095d.cp_bg_line_e);
        this.blz.setHeight(l.f(context, d.e.tbds182));
        this.blz.ws();
        this.blz.setTextSize(d.e.tbds30);
        this.blz.setTextColor(aj.getColor(d.C0095d.cp_cont_j));
        this.blz.dx(d.C0095d.cp_cont_e);
        this.blz.setOnClickListener(this.dnS);
        this.aXC.setNextPage(this.blz);
        e<?> Y = com.baidu.adp.base.i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new i(this.pageContext);
        this.aXC.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        if (TbadkCoreApplication.isLogin()) {
            this.cIS = BdListViewHelper.a(context, this.aXC, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dnM = new com.baidu.tieba.homepage.concern.a(context, this.aXC);
        this.dnO = new d(this.pageContext, this.aXC, this.dnM);
        addView(this.aXC);
        this.aXC.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.cIS != null && this.cIS.getLayoutParams() != null) {
            this.cIS.getLayoutParams().height = i;
            this.cIS.setLayoutParams(this.cIS.getLayoutParams());
        }
    }

    public void aoZ() {
        this.dnO.a(this.dnR);
        this.mPullView.a(new h.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.dnO.update();
                }
            }
        });
        this.aXC.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.OI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(boolean z) {
        if (this.blz != null) {
            if (z) {
                this.blz.wx();
                this.blz.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.blz.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dnN = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.blz != null) {
            this.blz.ww();
            this.blz.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dnO.a(z, dataRes, 0, null);
    }

    public void atz() {
        if (!TbadkCoreApplication.isLogin()) {
            atB();
        } else if (this.dnO != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dnO.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dnO != null) {
            this.dnO.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dnP != null) {
                this.dnP.onChangeSkinType(i);
            }
            if (this.bhE != null) {
                this.bhE.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.blz != null) {
                this.blz.setTextColor(aj.getColor(d.C0095d.cp_cont_d));
                this.blz.dz(i);
            }
            this.dnM.onChangeSkinType(i);
            aj.k(this, d.C0095d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        atD();
    }

    public void W(String str, int i) {
        if (this.blz != null) {
            this.blz.ww();
            this.blz.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dnO.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dnO != null && TbadkCoreApplication.isLogin()) {
                        c.this.dnO.update();
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
        if (this.bhE != null) {
            this.bhE.P(this);
            this.bhE = null;
            this.aXC.setNextPage(this.blz);
        }
        if (this.dnN != null) {
            this.dnN.z(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atA() {
        if (this.refreshView != null) {
            return this.refreshView.EO();
        }
        return false;
    }

    private void atB() {
        if (this.dnP == null) {
            this.dnP = new g(getContext());
            this.dnP.onChangeSkinType(this.mSkinType);
        }
        if (this.dnP.getParent() == null) {
            this.aXC.setVisibility(8);
            this.dnP.setVisibility(0);
            addView(this.dnP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bhE == null) {
            if (i < 0) {
                this.bhE = new f(getContext());
            } else {
                this.bhE = new f(getContext(), i);
            }
            this.bhE.onChangeSkinType();
        }
        this.bhE.c(this, z);
        this.aXC.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dnO != null) {
            this.dnO.setTabInForeBackgroundState(z);
        }
    }

    public void atC() {
        setViewForeground(false);
        if (this.dnO != null) {
            this.dnO.eX(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dnO != null) {
            this.dnO.fU(z);
        }
    }

    public void reload() {
        if (this.aXC != null) {
            if (this.dnQ && this.aXC.getFirstVisiblePosition() != 0) {
                this.dnQ = false;
                return;
            }
            this.aXC.setSelection(0);
            if (this.aXC.isRefreshDone()) {
                this.aXC.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dnO.a((d.a) null);
        this.mPullView.a((h.b) null);
        this.mPullView.a((h.c) null);
        this.aXC.setOnSrollToBottomListener(null);
        this.mPullView.a((h.a) null);
        this.mPullView.release();
        this.aXC.setRecyclerListener(null);
    }

    public void atD() {
        if (this.dnM != null) {
            this.dnM.notifyDataSetChanged();
        }
    }

    public void atE() {
        if (this.dnO != null) {
            this.dnO.eX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        if (this.blz != null && !this.blz.wA()) {
            this.blz.wv();
            this.blz.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dnO.OI();
    }
}
