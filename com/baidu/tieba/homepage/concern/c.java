package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.view.l;
import com.baidu.tbadk.data.e;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.d;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aTP;
    private PbListView beu;
    private f bfZ;
    private com.baidu.tieba.d.a cAr;
    private com.baidu.tieba.homepage.concern.a cRN;
    private a cRO;
    private d cRP;
    private boolean cRQ;
    private boolean cRR;
    private d.a cRS;
    private View.OnClickListener cRT;
    private CustomMessageListener ckC;
    private View clr;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void ls(String str);

        void onPullToRefresh();

        void w(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aTP != null) {
            this.aTP.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cRN != null) {
            this.cRN.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ckC != null) {
            this.ckC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ckC);
        }
    }

    public c(Context context) {
        super(context);
        this.cRR = false;
        this.cRS = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aov() {
                if (c.this.cRO == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.u(false, false);
                    return;
                }
                boolean aos = c.this.aos();
                c.this.Nq();
                if (aos) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cRO.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lr(String str) {
                if (c.this.cRO != null) {
                    c.this.cRO.ls(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.u(false, false);
                if (i == 1) {
                    if (c.this.cRP != null) {
                        c.this.fE(c.this.cRP.hasMore());
                    }
                    if (i.hr()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aTP.setVisibility(8);
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void v(boolean z, boolean z2) {
                if (c.this.cRP != null) {
                    c.this.fE(c.this.cRP.hasMore());
                }
                c.this.aTP.setVisibility(0);
                c.this.u(z, z2);
                c.this.Nq();
            }
        };
        this.cRT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.MS();
            }
        };
        this.ckC = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !u.v(c.this.cRP.getDataList()) && (c.this.cRP.getDataList().get(0) instanceof e) && !u.v(((e) c.this.cRP.getDataList().get(0)).Ct())) {
                        List<com.baidu.adp.widget.ListView.f> Ct = ((e) c.this.cRP.getDataList().get(0)).Ct();
                        int size = Ct.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = -1;
                                break;
                            } else if ((Ct.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) Ct.get(i2)).user_id))) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        com.baidu.tbadk.data.f fVar = new com.baidu.tbadk.data.f();
                        fVar.user_id = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        fVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                        fVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                        fVar.mStatus = 3;
                        fVar.aAD = String.valueOf(0);
                        fVar.aAC = bVar;
                        if (i != -1) {
                            Ct.set(i, fVar);
                        } else {
                            Ct.add(1, fVar);
                        }
                        c.this.cRP.aox();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTP = new BdTypeListView(context);
        this.aTP.setDividerHeight(0);
        this.aTP.setSelector(17170445);
        this.beu = new PbListView(context);
        this.beu.lj();
        this.beu.m10do(d.e.cp_bg_line_c);
        this.beu.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.beu.dp(TbadkCoreApplication.getInst().getSkinType());
        this.beu.setOnClickListener(this.cRT);
        this.aTP.setNextPage(this.beu);
        com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(context);
        if (aa instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aa;
        }
        this.mPullView = new l(this.pageContext);
        this.aTP.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.clr = BdListViewHelper.a(context, this.aTP, BdListViewHelper.HeadType.DEFAULT);
        this.cRN = new com.baidu.tieba.homepage.concern.a(context, this.aTP);
        this.cRP = new d(this.pageContext, this.aTP, this.cRN);
        addView(this.aTP);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aop() {
        this.cRP.a(this.cRS);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.cRP.update();
            }
        });
        this.mPullView.a(new k.a() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (c.this.cRR && TbadkCoreApplication.isLogin() && z && !c.this.cRQ && c.this.aTP.getVisibility() == 0 && !u.v(c.this.aTP.getData())) {
                    c.this.aoq();
                    c.this.cRR = false;
                }
            }
        });
        this.aTP.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.4
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.MS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoq() {
        if (this.cAr == null) {
            this.cAr = new com.baidu.tieba.d.a(this.pageContext, this);
            this.cAr.hJ(d.g.story_home_guide_bg);
            this.cAr.hM(1);
            this.cAr.hL(500);
            this.cAr.hK(-1);
            this.cAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cAr != null) {
                        c.this.cAr.YA();
                    }
                }
            });
        }
        this.cAr.jt("story_home_page_guide_mask");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(boolean z) {
        if (this.beu != null) {
            if (z) {
                this.beu.wZ();
                this.beu.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.beu.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.cRO = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.beu != null) {
            this.beu.wY();
            this.beu.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cRP.a(z, dataRes, 0, null);
    }

    public void aor() {
        if (!TbadkCoreApplication.isLogin()) {
            this.aTP.setNextPage(null);
        } else if (this.cRP != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cRP.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cRP != null) {
            this.cRP.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bfZ != null) {
            this.bfZ.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
        if (this.beu != null) {
            this.beu.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.beu.dp(i);
        }
        this.cRN.onChangeSkinType(i);
        ai.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.beu != null) {
            this.beu.wY();
            this.beu.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cRP.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cRP != null) {
                        c.this.cRP.update();
                    }
                }
            });
        }
        this.refreshView.eZ(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gz(str);
        this.refreshView.c(view, z);
        this.refreshView.ET();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nq() {
        if (this.refreshView != null) {
            this.refreshView.I(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z, boolean z2) {
        if (this.bfZ != null) {
            this.bfZ.I(this);
            this.bfZ = null;
            this.aTP.setNextPage(this.beu);
        }
        if (this.cRO != null) {
            this.cRO.w(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aos() {
        if (this.refreshView != null) {
            return this.refreshView.EK();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bfZ == null) {
            if (i < 0) {
                this.bfZ = new f(getContext());
            } else {
                this.bfZ = new f(getContext(), i);
            }
            this.bfZ.onChangeSkinType();
        }
        this.bfZ.c(this, z);
        this.aTP.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cRP != null) {
            this.cRP.setTabInForeBackgroundState(z);
        }
    }

    public void aot() {
        this.cRQ = false;
        setViewForeground(false);
        if (this.cRP != null) {
            this.cRP.eL(false);
        }
    }

    public void onLazyLoad() {
        this.cRR = true;
    }

    public void setViewForeground(boolean z) {
        if (this.cRP != null) {
            this.cRP.fF(z);
        }
    }

    public void reload() {
        if (this.aTP != null) {
            this.aTP.setSelection(0);
            if (this.aTP.isRefreshDone()) {
                this.aTP.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cRP.a((d.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aTP.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        this.aTP.setRecyclerListener(null);
        if (this.cAr != null) {
            this.cAr.YA();
            this.cAr = null;
        }
    }

    public void aou() {
        this.cRQ = true;
        if (this.cRP != null) {
            this.cRP.eL(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        if (this.beu != null && !this.beu.xc()) {
            this.beu.wX();
            this.beu.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cRP.MS();
    }
}
