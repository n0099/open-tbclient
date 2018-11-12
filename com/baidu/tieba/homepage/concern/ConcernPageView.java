package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.a.d;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class ConcernPageView extends FrameLayout {
    private f bGG;
    private PbListView bKJ;
    private View dDC;
    private BdTypeListView eiY;
    private com.baidu.tieba.homepage.concern.a ejn;
    private a ejo;
    private b ejp;
    private ConcernNotLoginLayout ejq;
    private boolean ejr;
    private b.a ejs;
    private View.OnClickListener ejt;
    private CustomMessageListener eju;
    private int mHeaderViewHeight;
    private NoDataView mNoDataView;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes6.dex */
    public interface a {
        void G(boolean z, boolean z2);

        void oE(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.eiY != null) {
            this.eiY.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ejn != null) {
            this.ejn.setPageUniqueId(bdUniqueId);
        }
        if (this.ejp != null) {
            this.ejp.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.eju != null) {
            this.eju.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eju);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.ejr = false;
        this.mSkinType = 3;
        this.ejs = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIm() {
                if (ConcernPageView.this.ejo == null) {
                    if (ConcernPageView.this.ejq != null) {
                        ConcernPageView.this.ejq.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aIj = ConcernPageView.this.aIj();
                ConcernPageView.this.ZS();
                if (aIj) {
                    ConcernPageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds520));
                }
                ConcernPageView.this.ejo.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void oD(String str) {
                if (ConcernPageView.this.ejo != null) {
                    ConcernPageView.this.ejo.oE(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.ejp != null) {
                        ConcernPageView.this.hG(ConcernPageView.this.ejp.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.eiY.setVisibility(8);
                if (ConcernPageView.this.ejq != null) {
                    ConcernPageView.this.ejq.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.ejp != null) {
                    ConcernPageView.this.hG(ConcernPageView.this.ejp.hasMore());
                }
                ConcernPageView.this.eiY.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.ZS();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIn() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.ZS();
                if (v.I(ConcernPageView.this.eiY.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.ejt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.YV();
            }
        };
        this.eju = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ejr = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ejr = false;
        this.mSkinType = 3;
        this.ejs = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIm() {
                if (ConcernPageView.this.ejo == null) {
                    if (ConcernPageView.this.ejq != null) {
                        ConcernPageView.this.ejq.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aIj = ConcernPageView.this.aIj();
                ConcernPageView.this.ZS();
                if (aIj) {
                    ConcernPageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds520));
                }
                ConcernPageView.this.ejo.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void oD(String str) {
                if (ConcernPageView.this.ejo != null) {
                    ConcernPageView.this.ejo.oE(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.ejp != null) {
                        ConcernPageView.this.hG(ConcernPageView.this.ejp.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.eiY.setVisibility(8);
                if (ConcernPageView.this.ejq != null) {
                    ConcernPageView.this.ejq.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.ejp != null) {
                    ConcernPageView.this.hG(ConcernPageView.this.ejp.hasMore());
                }
                ConcernPageView.this.eiY.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.ZS();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIn() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.ZS();
                if (v.I(ConcernPageView.this.eiY.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.ejt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.YV();
            }
        };
        this.eju = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ejr = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ejr = false;
        this.mSkinType = 3;
        this.ejs = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIm() {
                if (ConcernPageView.this.ejo == null) {
                    if (ConcernPageView.this.ejq != null) {
                        ConcernPageView.this.ejq.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aIj = ConcernPageView.this.aIj();
                ConcernPageView.this.ZS();
                if (aIj) {
                    ConcernPageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds520));
                }
                ConcernPageView.this.ejo.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void oD(String str) {
                if (ConcernPageView.this.ejo != null) {
                    ConcernPageView.this.ejo.oE(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.ejp != null) {
                        ConcernPageView.this.hG(ConcernPageView.this.ejp.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.eiY.setVisibility(8);
                if (ConcernPageView.this.ejq != null) {
                    ConcernPageView.this.ejq.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.ejp != null) {
                    ConcernPageView.this.hG(ConcernPageView.this.ejp.hasMore());
                }
                ConcernPageView.this.eiY.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.ZS();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIn() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.ZS();
                if (v.I(ConcernPageView.this.eiY.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.ejt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.YV();
            }
        };
        this.eju = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ejr = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.eiY = new BdTypeListView(context);
        this.eiY.setDividerHeight(0);
        this.eiY.setSelector(17170445);
        this.bKJ = new PbListView(context);
        this.bKJ.getView();
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.setHeight(l.h(context, e.C0200e.tbds182));
        this.bKJ.DV();
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bKJ.ei(e.d.cp_cont_e);
        this.bKJ.setOnClickListener(this.ejt);
        this.eiY.setNextPage(this.bKJ);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new k(this.pageContext);
        this.eiY.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dDC = BdListViewHelper.a(context, this.eiY, BdListViewHelper.HeadType.DEFAULT);
        }
        this.ejn = new com.baidu.tieba.homepage.concern.a(context, this.eiY);
        this.ejp = new b(this.pageContext, this.eiY, this.ejn);
        addView(this.eiY);
        this.eiY.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dDC != null && this.dDC.getLayoutParams() != null) {
            this.dDC.getLayoutParams().height = i;
            this.dDC.setLayoutParams(this.dDC.getLayoutParams());
        }
        this.mHeaderViewHeight = i;
    }

    public void aDk() {
        this.ejp.a(this.ejs);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.UG().jr("page_concern");
                    ConcernPageView.this.ejp.update();
                }
            }
        });
        this.eiY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.YV();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hG(boolean z) {
        if (this.bKJ != null) {
            if (z) {
                this.bKJ.Eb();
                this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bKJ.em(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.ejo = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bKJ != null) {
            this.bKJ.DZ();
            this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ejp.a(z, dataRes, 0, null);
    }

    public void aIh() {
        if (!TbadkCoreApplication.isLogin()) {
            aIk();
        } else if (this.ejp != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds520));
            this.ejp.update();
        }
    }

    public void aIi() {
        if (!TbadkCoreApplication.isLogin()) {
            aIk();
        } else if (this.ejp != null) {
            this.ejp.aIo();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.ejp != null) {
            this.ejp.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ejq != null) {
                this.ejq.onChangeSkinType(i);
            }
            if (this.bGG != null) {
                this.bGG.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ek(i);
            }
            if (this.bKJ != null) {
                this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bKJ.ek(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
            }
            this.ejn.onChangeSkinType(i);
            al.j(this, e.d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void af(String str, int i) {
        if (this.bKJ != null) {
            this.bKJ.DZ();
            this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ejp.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.ejp != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.ejp.update();
                    }
                }
            });
        }
        this.refreshView.fP(getContext().getResources().getDimensionPixelSize(e.C0200e.ds280));
        this.refreshView.hV(str);
        this.refreshView.attachView(view, z);
        this.refreshView.MH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZS() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z, boolean z2) {
        if (this.bGG != null) {
            this.bGG.dettachView(this);
            this.bGG = null;
            this.eiY.setNextPage(this.bKJ);
        }
        if (this.ejo != null) {
            this.ejo.G(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aIj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void aIk() {
        if (this.ejq == null) {
            this.ejq = new ConcernNotLoginLayout(getContext());
            this.ejq.onChangeSkinType(this.mSkinType);
        }
        if (this.ejq.getParent() == null) {
            this.eiY.setVisibility(8);
            this.ejq.setVisibility(0);
            addView(this.ejq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bGG == null) {
            if (i < 0) {
                this.bGG = new f(getContext());
            } else {
                this.bGG = new f(getContext(), i);
            }
            this.bGG.onChangeSkinType();
        }
        this.bGG.attachView(this, z);
        this.eiY.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0200e.tbds160) + this.mHeaderViewHeight;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0200e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(e.C0200e.ds320), dimensionPixelSize2), NoDataViewFactory.d.F(e.j.no_context_text, getResources().getDimensionPixelSize(e.C0200e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.h(getContext(), e.C0200e.fontsize42));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
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
        if (this.ejp != null) {
            this.ejp.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.ejp != null) {
            this.ejp.gC(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ejp != null) {
            this.ejp.hH(z);
        }
    }

    public void reload() {
        if (this.eiY != null) {
            if (this.ejr && this.eiY.getFirstVisiblePosition() != 0) {
                this.ejr = false;
                return;
            }
            this.eiY.setSelection(0);
            if (this.eiY.isRefreshDone()) {
                this.eiY.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.ejp.a((b.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.eiY.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.eiY.setRecyclerListener(null);
    }

    public void aIl() {
        if (this.ejp != null) {
            this.ejp.gC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YV() {
        if (this.bKJ != null && !this.bKJ.Ee()) {
            this.bKJ.DY();
            this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ejp.YV();
    }
}
