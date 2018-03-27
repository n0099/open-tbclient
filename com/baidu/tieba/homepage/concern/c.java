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
    private f bXd;
    private PbListView cbb;
    private View dGb;
    private BdTypeListView efB;
    private com.baidu.tieba.homepage.concern.a efQ;
    private a efR;
    private d efS;
    private g efT;
    private boolean efU;
    private d.a efV;
    private View.OnClickListener efW;
    private CustomMessageListener efX;
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
        if (this.efB != null) {
            this.efB.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.efQ != null) {
            this.efQ.setPageUniqueId(bdUniqueId);
        }
        if (this.efS != null) {
            this.efS.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.efX != null) {
            this.efX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.efX);
        }
    }

    public c(Context context) {
        super(context);
        this.efU = false;
        this.mSkinType = 3;
        this.efV = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aCk() {
                if (c.this.efR == null) {
                    if (c.this.efT != null) {
                        c.this.efT.setVisibility(8);
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
                c.this.efR.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void mB(String str) {
                if (c.this.efR != null) {
                    c.this.efR.mC(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.A(false, false);
                if (i == 1) {
                    if (c.this.efS != null) {
                        c.this.gN(c.this.efS.hasMore());
                    }
                    if (j.oJ()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.efB.setVisibility(8);
                if (c.this.efT != null) {
                    c.this.efT.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void B(boolean z, boolean z2) {
                if (c.this.efS != null) {
                    c.this.gN(c.this.efS.hasMore());
                }
                c.this.efB.setVisibility(0);
                c.this.A(z, z2);
                c.this.XN();
            }
        };
        this.efW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.WO();
            }
        };
        this.efX = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.efU = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.efB = new BdTypeListView(context);
        this.efB.setDividerHeight(0);
        this.efB.setSelector(17170445);
        this.cbb = new PbListView(context);
        this.cbb.getView();
        this.cbb.gw(d.C0141d.cp_bg_line_e);
        this.cbb.setHeight(l.t(context, d.e.tbds182));
        this.cbb.Ed();
        this.cbb.setTextSize(d.e.tbfontsize33);
        this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
        this.cbb.gv(d.C0141d.cp_cont_e);
        this.cbb.setOnClickListener(this.efW);
        this.efB.setNextPage(this.cbb);
        e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.efB.setPullRefresh(this.mPullView);
        this.mPullView.aG(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dGb = BdListViewHelper.a(context, this.efB, BdListViewHelper.HeadType.DEFAULT);
        }
        this.efQ = new com.baidu.tieba.homepage.concern.a(context, this.efB);
        this.efQ.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        this.efS = new d(this.pageContext, this.efB, this.efQ);
        addView(this.efB);
        this.efB.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dGb != null && this.dGb.getLayoutParams() != null) {
            this.dGb.getLayoutParams().height = i;
            this.dGb.setLayoutParams(this.dGb.getLayoutParams());
        }
    }

    public void ayg() {
        this.efS.a(this.efV);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.efQ.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                    c.this.efS.update();
                }
            }
        });
        this.efB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.WO();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gN(boolean z) {
        if (this.cbb != null) {
            if (z) {
                this.cbb.Ei();
                this.cbb.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.cbb.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.efR = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.cbb != null) {
            this.cbb.Eh();
            this.cbb.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.efS.a(z, dataRes, 0, null);
    }

    public void aCf() {
        if (!TbadkCoreApplication.isLogin()) {
            aCh();
        } else if (this.efS != null) {
            k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.efS.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.efS != null) {
            this.efS.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.efT != null) {
                this.efT.onChangeSkinType(i);
            }
            if (this.bXd != null) {
                this.bXd.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.cbb != null) {
                this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
                this.cbb.gx(i);
            }
            this.efQ.onChangeSkinType(i);
            aj.t(this, d.C0141d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void Y(String str, int i) {
        if (this.cbb != null) {
            this.cbb.Eh();
            this.cbb.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.efS.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.efS != null && TbadkCoreApplication.isLogin()) {
                        c.this.efS.update();
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
        if (this.bXd != null) {
            this.bXd.bk(this);
            this.bXd = null;
            this.efB.setNextPage(this.cbb);
        }
        if (this.efR != null) {
            this.efR.C(z, z2);
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
        if (this.efT == null) {
            this.efT = new g(getContext());
            this.efT.onChangeSkinType(this.mSkinType);
        }
        if (this.efT.getParent() == null) {
            this.efB.setVisibility(8);
            this.efT.setVisibility(0);
            addView(this.efT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z, int i) {
        if (this.bXd == null) {
            if (i < 0) {
                this.bXd = new f(getContext());
            } else {
                this.bXd = new f(getContext(), i);
            }
            this.bXd.onChangeSkinType();
        }
        this.bXd.j(this, z);
        this.efB.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.efS != null) {
            this.efS.setTabInForeBackgroundState(z);
        }
    }

    public void aCi() {
        setViewForeground(false);
        if (this.efS != null) {
            this.efS.fS(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.efS != null) {
            this.efS.gO(z);
        }
    }

    public void reload() {
        if (this.efB != null) {
            if (this.efU && this.efB.getFirstVisiblePosition() != 0) {
                this.efU = false;
                return;
            }
            this.efB.setSelection(0);
            if (this.efB.isRefreshDone()) {
                this.efB.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.efS.a((d.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.efB.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.efB.setRecyclerListener(null);
    }

    public void aCj() {
        if (this.efS != null) {
            this.efS.fS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WO() {
        if (this.cbb != null && !this.cbb.El()) {
            this.cbb.Eg();
            this.cbb.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.efS.WO();
    }
}
