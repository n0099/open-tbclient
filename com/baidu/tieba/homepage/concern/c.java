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
    private BdTypeListView aTN;
    private PbListView ber;
    private f bfY;
    private com.baidu.tieba.homepage.concern.a cPQ;
    private a cPR;
    private d cPS;
    private d.a cPT;
    private View.OnClickListener cPU;
    private CustomMessageListener cjO;
    private View ckF;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void ll(String str);

        void onPullToRefresh();

        void v(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aTN != null) {
            this.aTN.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cPQ != null) {
            this.cPQ.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cjO != null) {
            this.cjO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cjO);
        }
    }

    public c(Context context) {
        super(context);
        this.cPT = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void anU() {
                if (c.this.cPR == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.t(false, false);
                    return;
                }
                boolean anR = c.this.anR();
                c.this.Nq();
                if (anR) {
                    c.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cPR.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lk(String str) {
                if (c.this.cPR != null) {
                    c.this.cPR.ll(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.t(false, false);
                if (i == 1) {
                    if (c.this.cPS != null) {
                        c.this.fB(c.this.cPS.hasMore());
                    }
                    if (i.hr()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aTN.setVisibility(8);
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void u(boolean z, boolean z2) {
                if (c.this.cPS != null) {
                    c.this.fB(c.this.cPS.hasMore());
                }
                c.this.aTN.setVisibility(0);
                c.this.t(z, z2);
                c.this.Nq();
            }
        };
        this.cPU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.MS();
            }
        };
        this.cjO = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !u.v(c.this.cPS.getDataList()) && (c.this.cPS.getDataList().get(0) instanceof e) && !u.v(((e) c.this.cPS.getDataList().get(0)).Ct())) {
                        List<com.baidu.adp.widget.ListView.f> Ct = ((e) c.this.cPS.getDataList().get(0)).Ct();
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
                        fVar.aAB = String.valueOf(0);
                        fVar.aAA = bVar;
                        if (i != -1) {
                            Ct.set(i, fVar);
                        } else {
                            Ct.add(1, fVar);
                        }
                        c.this.cPS.anW();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTN = new BdTypeListView(context);
        this.aTN.setDividerHeight(0);
        this.aTN.setSelector(17170445);
        this.ber = new PbListView(context);
        this.ber.lk();
        this.ber.m10do(d.e.cp_bg_line_c);
        this.ber.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.ber.dp(TbadkCoreApplication.getInst().getSkinType());
        this.ber.setOnClickListener(this.cPU);
        this.aTN.setNextPage(this.ber);
        com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(context);
        if (aa instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aa;
        }
        this.mPullView = new l(this.pageContext);
        this.aTN.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.ckF = BdListViewHelper.a(context, this.aTN, BdListViewHelper.HeadType.DEFAULT);
        this.cPQ = new com.baidu.tieba.homepage.concern.a(context, this.aTN);
        this.cPS = new d(this.pageContext, this.aTN, this.cPQ);
        addView(this.aTN);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void anP() {
        this.cPS.a(this.cPT);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.cPS.update();
            }
        });
        this.aTN.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.MS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(boolean z) {
        if (this.ber != null) {
            if (z) {
                this.ber.wY();
                this.ber.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.ber.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.cPR = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.ber != null) {
            this.ber.wX();
            this.ber.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cPS.a(z, dataRes, 0, null);
    }

    public void anQ() {
        if (!TbadkCoreApplication.isLogin()) {
            this.aTN.setNextPage(null);
        } else if (this.cPS != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cPS.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cPS != null) {
            this.cPS.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bfY != null) {
            this.bfY.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
        if (this.ber != null) {
            this.ber.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.ber.dp(i);
        }
        this.cPQ.onChangeSkinType(i);
        ai.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.ber != null) {
            this.ber.wX();
            this.ber.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cPS.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cPS != null) {
                        c.this.cPS.update();
                    }
                }
            });
        }
        this.refreshView.eZ(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gv(str);
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
    public void t(boolean z, boolean z2) {
        if (this.bfY != null) {
            this.bfY.I(this);
            this.bfY = null;
            this.aTN.setNextPage(this.ber);
        }
        if (this.cPR != null) {
            this.cPR.v(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anR() {
        if (this.refreshView != null) {
            return this.refreshView.EK();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bfY == null) {
            if (i < 0) {
                this.bfY = new f(getContext());
            } else {
                this.bfY = new f(getContext(), i);
            }
            this.bfY.onChangeSkinType();
        }
        this.bfY.c(this, z);
        this.aTN.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cPS != null) {
            this.cPS.setTabInForeBackgroundState(z);
        }
    }

    public void anS() {
        setViewForeground(false);
        if (this.cPS != null) {
            this.cPS.eJ(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cPS != null) {
            this.cPS.fC(z);
        }
    }

    public void reload() {
        if (this.aTN != null) {
            this.aTN.setSelection(0);
            if (this.aTN.isRefreshDone()) {
                this.aTN.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cPS.a((d.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aTN.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        this.aTN.setRecyclerListener(null);
    }

    public void anT() {
        if (this.cPS != null) {
            this.cPS.eJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        if (this.ber != null && !this.ber.xc()) {
            this.ber.wW();
            this.ber.dq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cPS.MS();
    }
}
