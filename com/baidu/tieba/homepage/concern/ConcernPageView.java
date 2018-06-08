package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernPageView extends FrameLayout {
    private int atQ;
    private f bpl;
    private PbListView btv;
    private com.baidu.tieba.homepage.concern.a dMK;
    private a dML;
    private b dMM;
    private ConcernNotLoginLayout dMN;
    private boolean dMO;
    private b.a dMP;
    private View.OnClickListener dMQ;
    private CustomMessageListener dMR;
    private BdTypeListView dMv;
    private View dju;
    private NoDataView mNoDataView;
    private g mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void nt(String str);

        void onPullToRefresh();

        void y(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.dMv != null) {
            this.dMv.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dMK != null) {
            this.dMK.setPageUniqueId(bdUniqueId);
        }
        if (this.dMM != null) {
            this.dMM.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dMR != null) {
            this.dMR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dMR);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.dMO = false;
        this.mSkinType = 3;
        this.dMP = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aBY() {
                if (ConcernPageView.this.dML == null) {
                    if (ConcernPageView.this.dMN != null) {
                        ConcernPageView.this.dMN.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.w(false, false);
                    return;
                }
                boolean aBV = ConcernPageView.this.aBV();
                ConcernPageView.this.TI();
                if (aBV) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dML.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void ns(String str) {
                if (ConcernPageView.this.dML != null) {
                    ConcernPageView.this.dML.nt(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.w(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.dMM != null) {
                        ConcernPageView.this.gu(ConcernPageView.this.dMM.hasMore());
                    }
                    if (j.jD()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dMv.setVisibility(8);
                if (ConcernPageView.this.dMN != null) {
                    ConcernPageView.this.dMN.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dMM != null) {
                    ConcernPageView.this.gu(ConcernPageView.this.dMM.hasMore());
                }
                ConcernPageView.this.dMv.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.TI();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aBZ() {
                ConcernPageView.this.w(true, false);
                ConcernPageView.this.TI();
                if (w.z(ConcernPageView.this.dMv.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dMQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.SJ();
            }
        };
        this.dMR = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dMO = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dMO = false;
        this.mSkinType = 3;
        this.dMP = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aBY() {
                if (ConcernPageView.this.dML == null) {
                    if (ConcernPageView.this.dMN != null) {
                        ConcernPageView.this.dMN.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.w(false, false);
                    return;
                }
                boolean aBV = ConcernPageView.this.aBV();
                ConcernPageView.this.TI();
                if (aBV) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dML.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void ns(String str) {
                if (ConcernPageView.this.dML != null) {
                    ConcernPageView.this.dML.nt(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.w(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.dMM != null) {
                        ConcernPageView.this.gu(ConcernPageView.this.dMM.hasMore());
                    }
                    if (j.jD()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dMv.setVisibility(8);
                if (ConcernPageView.this.dMN != null) {
                    ConcernPageView.this.dMN.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dMM != null) {
                    ConcernPageView.this.gu(ConcernPageView.this.dMM.hasMore());
                }
                ConcernPageView.this.dMv.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.TI();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aBZ() {
                ConcernPageView.this.w(true, false);
                ConcernPageView.this.TI();
                if (w.z(ConcernPageView.this.dMv.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dMQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.SJ();
            }
        };
        this.dMR = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dMO = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dMO = false;
        this.mSkinType = 3;
        this.dMP = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aBY() {
                if (ConcernPageView.this.dML == null) {
                    if (ConcernPageView.this.dMN != null) {
                        ConcernPageView.this.dMN.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.w(false, false);
                    return;
                }
                boolean aBV = ConcernPageView.this.aBV();
                ConcernPageView.this.TI();
                if (aBV) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dML.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void ns(String str) {
                if (ConcernPageView.this.dML != null) {
                    ConcernPageView.this.dML.nt(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.w(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.dMM != null) {
                        ConcernPageView.this.gu(ConcernPageView.this.dMM.hasMore());
                    }
                    if (j.jD()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dMv.setVisibility(8);
                if (ConcernPageView.this.dMN != null) {
                    ConcernPageView.this.dMN.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dMM != null) {
                    ConcernPageView.this.gu(ConcernPageView.this.dMM.hasMore());
                }
                ConcernPageView.this.dMv.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.TI();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aBZ() {
                ConcernPageView.this.w(true, false);
                ConcernPageView.this.TI();
                if (w.z(ConcernPageView.this.dMv.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dMQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.SJ();
            }
        };
        this.dMR = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dMO = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dMv = new BdTypeListView(context);
        this.dMv.setDividerHeight(0);
        this.dMv.setSelector(17170445);
        this.btv = new PbListView(context);
        this.btv.getView();
        this.btv.dx(d.C0141d.cp_bg_line_e);
        this.btv.setHeight(l.e(context, d.e.tbds182));
        this.btv.Ao();
        this.btv.setTextSize(d.e.tbfontsize33);
        this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_j));
        this.btv.dw(d.C0141d.cp_cont_e);
        this.btv.setOnClickListener(this.dMQ);
        this.dMv.setNextPage(this.btv);
        e<?> ad = i.ad(context);
        if (ad instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ad;
        }
        this.mPullView = new g(this.pageContext);
        this.dMv.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dju = BdListViewHelper.a(context, this.dMv, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dMK = new com.baidu.tieba.homepage.concern.a(context, this.dMv);
        this.dMM = new b(this.pageContext, this.dMv, this.dMK);
        addView(this.dMv);
        this.dMv.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dju != null && this.dju.getLayoutParams() != null) {
            this.dju.getLayoutParams().height = i;
            this.dju.setLayoutParams(this.dju.getLayoutParams());
        }
        this.atQ = i;
    }

    public void axa() {
        this.dMM.a(this.dMP);
        this.mPullView.a(new f.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.Qe().ix("page_concern");
                    ConcernPageView.this.dMM.update();
                }
            }
        });
        this.dMv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.SJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gu(boolean z) {
        if (this.btv != null) {
            if (z) {
                this.btv.Au();
                this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.btv.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dML = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.btv != null) {
            this.btv.As();
            this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dMM.a(z, dataRes, 0, null);
    }

    public void aBT() {
        if (!TbadkCoreApplication.isLogin()) {
            aBW();
        } else if (this.dMM != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dMM.update();
        }
    }

    public void aBU() {
        if (!TbadkCoreApplication.isLogin()) {
            aBW();
        } else if (this.dMM != null) {
            this.dMM.aCa();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (this.dMM != null) {
            this.dMM.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dMN != null) {
                this.dMN.onChangeSkinType(i);
            }
            if (this.bpl != null) {
                this.bpl.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dy(i);
            }
            if (this.btv != null) {
                this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
                this.btv.dy(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(d.C0141d.cp_cont_b);
            }
            this.dMK.onChangeSkinType(i);
            al.j(this, d.C0141d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void ab(String str, int i) {
        if (this.btv != null) {
            this.btv.As();
            this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dMM.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.dMM != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.dMM.update();
                    }
                }
            });
        }
        this.refreshView.ff(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.d(view, z);
        this.refreshView.IX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TI() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        if (this.bpl != null) {
            this.bpl.P(this);
            this.bpl = null;
            this.dMv.setNextPage(this.btv);
        }
        if (this.dML != null) {
            this.dML.y(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBV() {
        if (this.refreshView != null) {
            return this.refreshView.IP();
        }
        return false;
    }

    private void aBW() {
        if (this.dMN == null) {
            this.dMN = new ConcernNotLoginLayout(getContext());
            this.dMN.onChangeSkinType(this.mSkinType);
        }
        if (this.dMN.getParent() == null) {
            this.dMv.setVisibility(8);
            this.dMN.setVisibility(0);
            addView(this.dMN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bpl == null) {
            if (i < 0) {
                this.bpl = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bpl = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bpl.onChangeSkinType();
        }
        this.bpl.d(this, z);
        this.dMv.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.tbds160) + this.atQ;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(d.e.ds320), dimensionPixelSize2), NoDataViewFactory.d.C(d.k.no_context_text, getResources().getDimensionPixelSize(d.e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.e(getContext(), d.e.fontsize42));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setSubTitleTextColor(d.C0141d.cp_cont_b);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dMM != null) {
            this.dMM.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dMM != null) {
            this.dMM.fD(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dMM != null) {
            this.dMM.gv(z);
        }
    }

    public void reload() {
        if (this.dMv != null) {
            if (this.dMO && this.dMv.getFirstVisiblePosition() != 0) {
                this.dMO = false;
                return;
            }
            this.dMv.setSelection(0);
            if (this.dMv.isRefreshDone()) {
                this.dMv.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dMM.a((b.a) null);
        this.mPullView.a((f.b) null);
        this.mPullView.a((f.c) null);
        this.dMv.setOnSrollToBottomListener(null);
        this.mPullView.a((f.a) null);
        this.mPullView.release();
        this.dMv.setRecyclerListener(null);
    }

    public void aBX() {
        if (this.dMM != null) {
            this.dMM.fD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ() {
        if (this.btv != null && !this.btv.Ax()) {
            this.btv.Ar();
            this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dMM.SJ();
    }
}
