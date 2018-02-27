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
    private f bXa;
    private PbListView caY;
    private View dFW;
    private com.baidu.tieba.homepage.concern.a efA;
    private a efB;
    private d efC;
    private g efD;
    private boolean efE;
    private d.a efF;
    private View.OnClickListener efG;
    private CustomMessageListener efH;
    private BdTypeListView efl;
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
        if (this.efl != null) {
            this.efl.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.efA != null) {
            this.efA.setPageUniqueId(bdUniqueId);
        }
        if (this.efC != null) {
            this.efC.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.efH != null) {
            this.efH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.efH);
        }
    }

    public c(Context context) {
        super(context);
        this.efE = false;
        this.mSkinType = 3;
        this.efF = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aCj() {
                if (c.this.efB == null) {
                    if (c.this.efD != null) {
                        c.this.efD.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    c.this.A(false, false);
                    return;
                }
                boolean aCf = c.this.aCf();
                c.this.XM();
                if (aCf) {
                    c.this.k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                c.this.efB.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void mB(String str) {
                if (c.this.efB != null) {
                    c.this.efB.mC(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.A(false, false);
                if (i == 1) {
                    if (c.this.efC != null) {
                        c.this.gI(c.this.efC.hasMore());
                    }
                    if (j.oJ()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.efl.setVisibility(8);
                if (c.this.efD != null) {
                    c.this.efD.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void B(boolean z, boolean z2) {
                if (c.this.efC != null) {
                    c.this.gI(c.this.efC.hasMore());
                }
                c.this.efl.setVisibility(0);
                c.this.A(z, z2);
                c.this.XM();
            }
        };
        this.efG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.WN();
            }
        };
        this.efH = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.efE = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.efl = new BdTypeListView(context);
        this.efl.setDividerHeight(0);
        this.efl.setSelector(17170445);
        this.caY = new PbListView(context);
        this.caY.getView();
        this.caY.gw(d.C0141d.cp_bg_line_e);
        this.caY.setHeight(l.t(context, d.e.tbds182));
        this.caY.Ec();
        this.caY.setTextSize(d.e.tbfontsize33);
        this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
        this.caY.gv(d.C0141d.cp_cont_e);
        this.caY.setOnClickListener(this.efG);
        this.efl.setNextPage(this.caY);
        e<?> ak = i.ak(context);
        if (ak instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ak;
        }
        this.mPullView = new k(this.pageContext);
        this.efl.setPullRefresh(this.mPullView);
        this.mPullView.aG(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dFW = BdListViewHelper.a(context, this.efl, BdListViewHelper.HeadType.DEFAULT);
        }
        this.efA = new com.baidu.tieba.homepage.concern.a(context, this.efl);
        this.efA.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        this.efC = new d(this.pageContext, this.efl, this.efA);
        addView(this.efl);
        this.efl.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dFW != null && this.dFW.getLayoutParams() != null) {
            this.dFW.getLayoutParams().height = i;
            this.dFW.setLayoutParams(this.dFW.getLayoutParams());
        }
    }

    public void aye() {
        this.efC.a(this.efF);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.efA.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                    c.this.efC.update();
                }
            }
        });
        this.efl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.WN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(boolean z) {
        if (this.caY != null) {
            if (z) {
                this.caY.Eh();
                this.caY.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.caY.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.efB = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.caY != null) {
            this.caY.Eg();
            this.caY.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.efC.a(z, dataRes, 0, null);
    }

    public void aCe() {
        if (!TbadkCoreApplication.isLogin()) {
            aCg();
        } else if (this.efC != null) {
            k(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.efC.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.efC != null) {
            this.efC.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.efD != null) {
                this.efD.onChangeSkinType(i);
            }
            if (this.bXa != null) {
                this.bXa.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
            if (this.caY != null) {
                this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
                this.caY.gx(i);
            }
            this.efA.onChangeSkinType(i);
            aj.t(this, d.C0141d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void Y(String str, int i) {
        if (this.caY != null) {
            this.caY.Eg();
            this.caY.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.efC.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.efC != null && TbadkCoreApplication.isLogin()) {
                        c.this.efC.update();
                    }
                }
            });
        }
        this.refreshView.ib(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gW(str);
        this.refreshView.j(view, z);
        this.refreshView.MQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XM() {
        if (this.refreshView != null) {
            this.refreshView.bk(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        if (this.bXa != null) {
            this.bXa.bk(this);
            this.bXa = null;
            this.efl.setNextPage(this.caY);
        }
        if (this.efB != null) {
            this.efB.C(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCf() {
        if (this.refreshView != null) {
            return this.refreshView.MI();
        }
        return false;
    }

    private void aCg() {
        if (this.efD == null) {
            this.efD = new g(getContext());
            this.efD.onChangeSkinType(this.mSkinType);
        }
        if (this.efD.getParent() == null) {
            this.efl.setVisibility(8);
            this.efD.setVisibility(0);
            addView(this.efD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z, int i) {
        if (this.bXa == null) {
            if (i < 0) {
                this.bXa = new f(getContext());
            } else {
                this.bXa = new f(getContext(), i);
            }
            this.bXa.onChangeSkinType();
        }
        this.bXa.j(this, z);
        this.efl.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.efC != null) {
            this.efC.setTabInForeBackgroundState(z);
        }
    }

    public void aCh() {
        setViewForeground(false);
        if (this.efC != null) {
            this.efC.fS(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.efC != null) {
            this.efC.gJ(z);
        }
    }

    public void reload() {
        if (this.efl != null) {
            if (this.efE && this.efl.getFirstVisiblePosition() != 0) {
                this.efE = false;
                return;
            }
            this.efl.setSelection(0);
            if (this.efl.isRefreshDone()) {
                this.efl.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.efC.a((d.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.efl.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.efl.setRecyclerListener(null);
    }

    public void aCi() {
        if (this.efC != null) {
            this.efC.fS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        if (this.caY != null && !this.caY.Ek()) {
            this.caY.Ef();
            this.caY.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.efC.WN();
    }
}
