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
    private f bXm;
    private PbListView cbk;
    private View dGi;
    private com.baidu.tieba.homepage.concern.a efM;
    private a efN;
    private d efO;
    private g efP;
    private boolean efQ;
    private d.a efR;
    private View.OnClickListener efS;
    private CustomMessageListener efT;
    private BdTypeListView efx;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void C(boolean z, boolean z2);

        void mC(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.efx != null) {
            this.efx.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.efM != null) {
            this.efM.setPageUniqueId(bdUniqueId);
        }
        if (this.efO != null) {
            this.efO.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.efT != null) {
            this.efT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.efT);
        }
    }

    public c(Context context) {
        super(context);
        this.efQ = false;
        this.mSkinType = 3;
        this.efR = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aCk() {
                if (c.this.efN == null) {
                    if (c.this.efP != null) {
                        c.this.efP.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.A(false, false);
                    return;
                }
                boolean aCg = c.this.aCg();
                c.this.XN();
                if (aCg) {
                    c.this.k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.efN.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void mB(String str) {
                if (c.this.efN != null) {
                    c.this.efN.mC(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.A(false, false);
                if (i == 1) {
                    if (c.this.efO != null) {
                        c.this.gI(c.this.efO.hasMore());
                    }
                    if (j.oJ()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.efx.setVisibility(8);
                if (c.this.efP != null) {
                    c.this.efP.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void B(boolean z, boolean z2) {
                if (c.this.efO != null) {
                    c.this.gI(c.this.efO.hasMore());
                }
                c.this.efx.setVisibility(0);
                c.this.A(z, z2);
                c.this.XN();
            }
        };
        this.efS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.WO();
            }
        };
        this.efT = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.efQ = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.efx = new BdTypeListView(context);
        this.efx.setDividerHeight(0);
        this.efx.setSelector(17170445);
        this.cbk = new PbListView(context);
        this.cbk.getView();
        this.cbk.gw(d.C0140d.cp_bg_line_e);
        this.cbk.setHeight(l.t(context, d.e.tbds182));
        this.cbk.Ed();
        this.cbk.setTextSize(d.e.tbfontsize33);
        this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_j));
        this.cbk.gv(d.C0140d.cp_cont_e);
        this.cbk.setOnClickListener(this.efS);
        this.efx.setNextPage(this.cbk);
        e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.efx.setPullRefresh(this.mPullView);
        this.mPullView.aG(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dGi = BdListViewHelper.a(context, this.efx, BdListViewHelper.HeadType.DEFAULT);
        }
        this.efM = new com.baidu.tieba.homepage.concern.a(context, this.efx);
        this.efM.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        this.efO = new d(this.pageContext, this.efx, this.efM);
        addView(this.efx);
        this.efx.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dGi != null && this.dGi.getLayoutParams() != null) {
            this.dGi.getLayoutParams().height = i;
            this.dGi.setLayoutParams(this.dGi.getLayoutParams());
        }
    }

    public void ayf() {
        this.efO.a(this.efR);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.efM.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                    c.this.efO.update();
                }
            }
        });
        this.efx.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.WO();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(boolean z) {
        if (this.cbk != null) {
            if (z) {
                this.cbk.Ei();
                this.cbk.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.cbk.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.efN = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.cbk != null) {
            this.cbk.Eh();
            this.cbk.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.efO.a(z, dataRes, 0, null);
    }

    public void aCf() {
        if (!TbadkCoreApplication.isLogin()) {
            aCh();
        } else if (this.efO != null) {
            k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.efO.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.efO != null) {
            this.efO.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.efP != null) {
                this.efP.onChangeSkinType(i);
            }
            if (this.bXm != null) {
                this.bXm.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.cbk != null) {
                this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
                this.cbk.gx(i);
            }
            this.efM.onChangeSkinType(i);
            aj.t(this, d.C0140d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void Y(String str, int i) {
        if (this.cbk != null) {
            this.cbk.Eh();
            this.cbk.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.efO.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.efO != null && TbadkCoreApplication.isLogin()) {
                        c.this.efO.update();
                    }
                }
            });
        }
        this.refreshView.ib(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gW(str);
        this.refreshView.j(view, z);
        this.refreshView.MR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XN() {
        if (this.refreshView != null) {
            this.refreshView.bk(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        if (this.bXm != null) {
            this.bXm.bk(this);
            this.bXm = null;
            this.efx.setNextPage(this.cbk);
        }
        if (this.efN != null) {
            this.efN.C(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCg() {
        if (this.refreshView != null) {
            return this.refreshView.MJ();
        }
        return false;
    }

    private void aCh() {
        if (this.efP == null) {
            this.efP = new g(getContext());
            this.efP.onChangeSkinType(this.mSkinType);
        }
        if (this.efP.getParent() == null) {
            this.efx.setVisibility(8);
            this.efP.setVisibility(0);
            addView(this.efP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z, int i) {
        if (this.bXm == null) {
            if (i < 0) {
                this.bXm = new f(getContext());
            } else {
                this.bXm = new f(getContext(), i);
            }
            this.bXm.onChangeSkinType();
        }
        this.bXm.j(this, z);
        this.efx.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.efO != null) {
            this.efO.setTabInForeBackgroundState(z);
        }
    }

    public void aCi() {
        setViewForeground(false);
        if (this.efO != null) {
            this.efO.fS(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.efO != null) {
            this.efO.gJ(z);
        }
    }

    public void reload() {
        if (this.efx != null) {
            if (this.efQ && this.efx.getFirstVisiblePosition() != 0) {
                this.efQ = false;
                return;
            }
            this.efx.setSelection(0);
            if (this.efx.isRefreshDone()) {
                this.efx.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.efO.a((d.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.efx.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.efx.setRecyclerListener(null);
    }

    public void aCj() {
        if (this.efO != null) {
            this.efO.fS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WO() {
        if (this.cbk != null && !this.cbk.El()) {
            this.cbk.Eg();
            this.cbk.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.efO.WO();
    }
}
