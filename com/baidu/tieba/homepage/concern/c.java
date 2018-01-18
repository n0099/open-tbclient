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
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.g;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class c extends FrameLayout {
    private f bUV;
    private PbListView bYR;
    private View dCQ;
    private BdTypeListView eaQ;
    private com.baidu.tieba.homepage.concern.a ebf;
    private a ebg;
    private d ebh;
    private g ebi;
    private boolean ebj;
    private d.a ebk;
    private View.OnClickListener ebl;
    private CustomMessageListener ebm;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void B(boolean z, boolean z2);

        void ml(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.eaQ != null) {
            this.eaQ.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ebf != null) {
            this.ebf.setPageUniqueId(bdUniqueId);
        }
        if (this.ebh != null) {
            this.ebh.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ebm != null) {
            this.ebm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ebm);
        }
    }

    public c(Context context) {
        super(context);
        this.ebj = false;
        this.mSkinType = 3;
        this.ebk = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aAL() {
                if (c.this.ebg == null) {
                    if (c.this.ebi != null) {
                        c.this.ebi.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.z(false, false);
                    return;
                }
                boolean aAH = c.this.aAH();
                c.this.WE();
                if (aAH) {
                    c.this.j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.ebg.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void mk(String str) {
                if (c.this.ebg != null) {
                    c.this.ebg.ml(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.z(false, false);
                if (i == 1) {
                    if (c.this.ebh != null) {
                        c.this.gv(c.this.ebh.hasMore());
                    }
                    if (j.oI()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.eaQ.setVisibility(8);
                if (c.this.ebi != null) {
                    c.this.ebi.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void A(boolean z, boolean z2) {
                if (c.this.ebh != null) {
                    c.this.gv(c.this.ebh.hasMore());
                }
                c.this.eaQ.setVisibility(0);
                c.this.z(z, z2);
                c.this.WE();
            }
        };
        this.ebl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.VV();
            }
        };
        this.ebm = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.ebj = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.eaQ = new BdTypeListView(context);
        this.eaQ.setDividerHeight(0);
        this.eaQ.setSelector(17170445);
        this.bYR = new PbListView(context);
        this.bYR.getView();
        this.bYR.gu(d.C0107d.cp_bg_line_e);
        this.bYR.setHeight(l.s(context, d.e.tbds182));
        this.bYR.DH();
        this.bYR.setTextSize(d.e.tbfontsize33);
        this.bYR.setTextColor(aj.getColor(d.C0107d.cp_cont_j));
        this.bYR.gt(d.C0107d.cp_cont_e);
        this.bYR.setOnClickListener(this.ebl);
        this.eaQ.setNextPage(this.bYR);
        e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.eaQ.setPullRefresh(this.mPullView);
        this.mPullView.aC(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dCQ = BdListViewHelper.a(context, this.eaQ, BdListViewHelper.HeadType.DEFAULT);
        }
        this.ebf = new com.baidu.tieba.homepage.concern.a(context, this.eaQ);
        this.ebh = new d(this.pageContext, this.eaQ, this.ebf);
        addView(this.eaQ);
        this.eaQ.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dCQ != null && this.dCQ.getLayoutParams() != null) {
            this.dCQ.getLayoutParams().height = i;
            this.dCQ.setLayoutParams(this.dCQ.getLayoutParams());
        }
    }

    public void axc() {
        this.ebh.a(this.ebk);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.ebh.update();
                }
            }
        });
        this.eaQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.VV();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gv(boolean z) {
        if (this.bYR != null) {
            if (z) {
                this.bYR.DM();
                this.bYR.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bYR.gx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.ebg = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bYR != null) {
            this.bYR.DL();
            this.bYR.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ebh.a(z, dataRes, 0, null);
    }

    public void aAG() {
        if (!TbadkCoreApplication.isLogin()) {
            aAI();
        } else if (this.ebh != null) {
            j(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.ebh.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.ebh != null) {
            this.ebh.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ebi != null) {
                this.ebi.onChangeSkinType(i);
            }
            if (this.bUV != null) {
                this.bUV.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gv(i);
            }
            if (this.bYR != null) {
                this.bYR.setTextColor(aj.getColor(d.C0107d.cp_cont_d));
                this.bYR.gv(i);
            }
            this.ebf.onChangeSkinType(i);
            aj.t(this, d.C0107d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void aa(String str, int i) {
        if (this.bYR != null) {
            this.bYR.DL();
            this.bYR.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ebh.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.ebh != null && TbadkCoreApplication.isLogin()) {
                        c.this.ebh.update();
                    }
                }
            });
        }
        this.refreshView.id(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gF(str);
        this.refreshView.j(view, z);
        this.refreshView.Mj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE() {
        if (this.refreshView != null) {
            this.refreshView.bk(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        if (this.bUV != null) {
            this.bUV.bk(this);
            this.bUV = null;
            this.eaQ.setNextPage(this.bYR);
        }
        if (this.ebg != null) {
            this.ebg.B(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAH() {
        if (this.refreshView != null) {
            return this.refreshView.Mb();
        }
        return false;
    }

    private void aAI() {
        if (this.ebi == null) {
            this.ebi = new g(getContext());
            this.ebi.onChangeSkinType(this.mSkinType);
        }
        if (this.ebi.getParent() == null) {
            this.eaQ.setVisibility(8);
            this.ebi.setVisibility(0);
            addView(this.ebi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.bUV == null) {
            if (i < 0) {
                this.bUV = new f(getContext());
            } else {
                this.bUV = new f(getContext(), i);
            }
            this.bUV.onChangeSkinType();
        }
        this.bUV.j(this, z);
        this.eaQ.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ebh != null) {
            this.ebh.setTabInForeBackgroundState(z);
        }
    }

    public void aAJ() {
        setViewForeground(false);
        if (this.ebh != null) {
            this.ebh.fH(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ebh != null) {
            this.ebh.gw(z);
        }
    }

    public void reload() {
        if (this.eaQ != null) {
            if (this.ebj && this.eaQ.getFirstVisiblePosition() != 0) {
                this.ebj = false;
                return;
            }
            this.eaQ.setSelection(0);
            if (this.eaQ.isRefreshDone()) {
                this.eaQ.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.ebh.a((d.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.eaQ.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.eaQ.setRecyclerListener(null);
    }

    public void aAK() {
        if (this.ebh != null) {
            this.ebh.fH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VV() {
        if (this.bYR != null && !this.bYR.DP()) {
            this.bYR.DK();
            this.bYR.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ebh.VV();
    }
}
