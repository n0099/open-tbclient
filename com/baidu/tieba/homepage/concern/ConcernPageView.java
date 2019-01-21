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
import com.baidu.tieba.a.d;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class ConcernPageView extends FrameLayout {
    private f bLm;
    private PbListView bPn;
    private View dNz;
    private com.baidu.tieba.homepage.concern.a etG;
    private a etH;
    private b etI;
    private ConcernNotLoginLayout etJ;
    private boolean etK;
    private b.a etL;
    private View.OnClickListener etM;
    private CustomMessageListener etN;
    private BdTypeListView etr;
    private int mHeaderViewHeight;
    private NoDataView mNoDataView;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes6.dex */
    public interface a {
        void G(boolean z, boolean z2);

        void onPullToRefresh();

        void pz(String str);
    }

    public void completePullRefresh() {
        if (this.etr != null) {
            this.etr.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.etG != null) {
            this.etG.setPageUniqueId(bdUniqueId);
        }
        if (this.etI != null) {
            this.etI.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.etN != null) {
            this.etN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.etN);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.etK = false;
        this.mSkinType = 3;
        this.etL = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLq() {
                if (ConcernPageView.this.etH == null) {
                    if (ConcernPageView.this.etJ != null) {
                        ConcernPageView.this.etJ.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aLn = ConcernPageView.this.aLn();
                ConcernPageView.this.abx();
                if (aLn) {
                    ConcernPageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                ConcernPageView.this.etH.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void py(String str) {
                if (ConcernPageView.this.etH != null) {
                    ConcernPageView.this.etH.pz(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.etI != null) {
                        ConcernPageView.this.hL(ConcernPageView.this.etI.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.etr.setVisibility(8);
                if (ConcernPageView.this.etJ != null) {
                    ConcernPageView.this.etJ.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.etI != null) {
                    ConcernPageView.this.hL(ConcernPageView.this.etI.hasMore());
                }
                ConcernPageView.this.etr.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.abx();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLr() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.abx();
                if (v.I(ConcernPageView.this.etr.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.etM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aaA();
            }
        };
        this.etN = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.etK = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etK = false;
        this.mSkinType = 3;
        this.etL = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLq() {
                if (ConcernPageView.this.etH == null) {
                    if (ConcernPageView.this.etJ != null) {
                        ConcernPageView.this.etJ.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aLn = ConcernPageView.this.aLn();
                ConcernPageView.this.abx();
                if (aLn) {
                    ConcernPageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                ConcernPageView.this.etH.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void py(String str) {
                if (ConcernPageView.this.etH != null) {
                    ConcernPageView.this.etH.pz(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.etI != null) {
                        ConcernPageView.this.hL(ConcernPageView.this.etI.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.etr.setVisibility(8);
                if (ConcernPageView.this.etJ != null) {
                    ConcernPageView.this.etJ.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.etI != null) {
                    ConcernPageView.this.hL(ConcernPageView.this.etI.hasMore());
                }
                ConcernPageView.this.etr.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.abx();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLr() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.abx();
                if (v.I(ConcernPageView.this.etr.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.etM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aaA();
            }
        };
        this.etN = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.etK = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etK = false;
        this.mSkinType = 3;
        this.etL = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLq() {
                if (ConcernPageView.this.etH == null) {
                    if (ConcernPageView.this.etJ != null) {
                        ConcernPageView.this.etJ.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aLn = ConcernPageView.this.aLn();
                ConcernPageView.this.abx();
                if (aLn) {
                    ConcernPageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                ConcernPageView.this.etH.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void py(String str) {
                if (ConcernPageView.this.etH != null) {
                    ConcernPageView.this.etH.pz(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.etI != null) {
                        ConcernPageView.this.hL(ConcernPageView.this.etI.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.etr.setVisibility(8);
                if (ConcernPageView.this.etJ != null) {
                    ConcernPageView.this.etJ.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.etI != null) {
                    ConcernPageView.this.hL(ConcernPageView.this.etI.hasMore());
                }
                ConcernPageView.this.etr.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.abx();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLr() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.abx();
                if (v.I(ConcernPageView.this.etr.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.etM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aaA();
            }
        };
        this.etN = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.etK = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.etr = new BdTypeListView(context);
        this.etr.setDividerHeight(0);
        this.etr.setSelector(17170445);
        this.bPn = new PbListView(context);
        this.bPn.getView();
        this.bPn.ex(e.d.cp_bg_line_e);
        this.bPn.setHeight(l.h(context, e.C0210e.tbds182));
        this.bPn.Fm();
        this.bPn.setTextSize(e.C0210e.tbfontsize33);
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPn.ew(e.d.cp_cont_e);
        this.bPn.setOnClickListener(this.etM);
        this.etr.setNextPage(this.bPn);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new k(this.pageContext);
        this.etr.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dNz = BdListViewHelper.a(context, this.etr, BdListViewHelper.HeadType.DEFAULT);
        }
        this.etG = new com.baidu.tieba.homepage.concern.a(context, this.etr);
        this.etI = new b(this.pageContext, this.etr, this.etG);
        addView(this.etr);
        this.etr.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dNz != null && this.dNz.getLayoutParams() != null) {
            this.dNz.getLayoutParams().height = i;
            this.dNz.setLayoutParams(this.dNz.getLayoutParams());
        }
        this.mHeaderViewHeight = i;
    }

    public void aGi() {
        this.etI.a(this.etL);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.Wk().ka("page_concern");
                    ConcernPageView.this.etI.update();
                }
            }
        });
        this.etr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aaA();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL(boolean z) {
        if (this.bPn != null) {
            if (z) {
                this.bPn.Fs();
                this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bPn.eA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.etH = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bPn != null) {
            this.bPn.Fq();
            this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.etI.a(z, dataRes, 0, null);
    }

    public void aLl() {
        if (!TbadkCoreApplication.isLogin()) {
            aLo();
        } else if (this.etI != null) {
            i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
            this.etI.update();
        }
    }

    public void aLm() {
        if (!TbadkCoreApplication.isLogin()) {
            aLo();
        } else if (this.etI != null) {
            this.etI.aLs();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.v vVar) {
        if (this.etI != null) {
            this.etI.setRecommendFrsNavigationAnimDispatcher(vVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.etJ != null) {
                this.etJ.onChangeSkinType(i);
            }
            if (this.bLm != null) {
                this.bLm.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.bPn != null) {
                this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bPn.ey(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
            }
            this.etG.onChangeSkinType(i);
            al.j(this, e.d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void ah(String str, int i) {
        if (this.bPn != null) {
            this.bPn.Fq();
            this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.etI.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.etI != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.etI.update();
                    }
                }
            });
        }
        this.refreshView.ge(getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.iC(str);
        this.refreshView.attachView(view, z);
        this.refreshView.Od();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abx() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z, boolean z2) {
        if (this.bLm != null) {
            this.bLm.dettachView(this);
            this.bLm = null;
            this.etr.setNextPage(this.bPn);
        }
        if (this.etH != null) {
            this.etH.G(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLn() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void aLo() {
        if (this.etJ == null) {
            this.etJ = new ConcernNotLoginLayout(getContext());
            this.etJ.onChangeSkinType(this.mSkinType);
        }
        if (this.etJ.getParent() == null) {
            this.etr.setVisibility(8);
            this.etJ.setVisibility(0);
            addView(this.etJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bLm == null) {
            if (i < 0) {
                this.bLm = new f(getContext());
            } else {
                this.bLm = new f(getContext(), i);
            }
            this.bLm.onChangeSkinType();
        }
        this.bLm.attachView(this, z);
        this.etr.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.tbds160) + this.mHeaderViewHeight;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0210e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(e.C0210e.ds320), dimensionPixelSize2), NoDataViewFactory.d.G(e.j.no_context_text, getResources().getDimensionPixelSize(e.C0210e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.h(getContext(), e.C0210e.fontsize42));
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
        if (this.etI != null) {
            this.etI.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.etI != null) {
            this.etI.gJ(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.etI != null) {
            this.etI.hM(z);
        }
    }

    public void reload() {
        if (this.etr != null) {
            if (this.etK && this.etr.getFirstVisiblePosition() != 0) {
                this.etK = false;
                return;
            }
            this.etr.setSelection(0);
            if (this.etr.isRefreshDone()) {
                this.etr.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.etI.a((b.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.etr.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.etr.setRecyclerListener(null);
    }

    public void aLp() {
        if (this.etI != null) {
            this.etI.gJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (this.bPn != null && !this.bPn.Fv()) {
            this.bPn.Fp();
            this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.etI.aaA();
    }
}
