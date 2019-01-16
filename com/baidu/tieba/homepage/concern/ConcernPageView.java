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
    private f bLl;
    private PbListView bPm;
    private View dNy;
    private com.baidu.tieba.homepage.concern.a etF;
    private a etG;
    private b etH;
    private ConcernNotLoginLayout etI;
    private boolean etJ;
    private b.a etK;
    private View.OnClickListener etL;
    private CustomMessageListener etM;
    private BdTypeListView etq;
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
        if (this.etq != null) {
            this.etq.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.etF != null) {
            this.etF.setPageUniqueId(bdUniqueId);
        }
        if (this.etH != null) {
            this.etH.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.etM != null) {
            this.etM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.etM);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.etJ = false;
        this.mSkinType = 3;
        this.etK = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLq() {
                if (ConcernPageView.this.etG == null) {
                    if (ConcernPageView.this.etI != null) {
                        ConcernPageView.this.etI.setVisibility(8);
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
                ConcernPageView.this.etG.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void py(String str) {
                if (ConcernPageView.this.etG != null) {
                    ConcernPageView.this.etG.pz(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.etH != null) {
                        ConcernPageView.this.hL(ConcernPageView.this.etH.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.etq.setVisibility(8);
                if (ConcernPageView.this.etI != null) {
                    ConcernPageView.this.etI.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.etH != null) {
                    ConcernPageView.this.hL(ConcernPageView.this.etH.hasMore());
                }
                ConcernPageView.this.etq.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.abx();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLr() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.abx();
                if (v.I(ConcernPageView.this.etq.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.etL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aaA();
            }
        };
        this.etM = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.etJ = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etJ = false;
        this.mSkinType = 3;
        this.etK = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLq() {
                if (ConcernPageView.this.etG == null) {
                    if (ConcernPageView.this.etI != null) {
                        ConcernPageView.this.etI.setVisibility(8);
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
                ConcernPageView.this.etG.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void py(String str) {
                if (ConcernPageView.this.etG != null) {
                    ConcernPageView.this.etG.pz(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.etH != null) {
                        ConcernPageView.this.hL(ConcernPageView.this.etH.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.etq.setVisibility(8);
                if (ConcernPageView.this.etI != null) {
                    ConcernPageView.this.etI.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.etH != null) {
                    ConcernPageView.this.hL(ConcernPageView.this.etH.hasMore());
                }
                ConcernPageView.this.etq.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.abx();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLr() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.abx();
                if (v.I(ConcernPageView.this.etq.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.etL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aaA();
            }
        };
        this.etM = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.etJ = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etJ = false;
        this.mSkinType = 3;
        this.etK = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLq() {
                if (ConcernPageView.this.etG == null) {
                    if (ConcernPageView.this.etI != null) {
                        ConcernPageView.this.etI.setVisibility(8);
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
                ConcernPageView.this.etG.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void py(String str) {
                if (ConcernPageView.this.etG != null) {
                    ConcernPageView.this.etG.pz(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.etH != null) {
                        ConcernPageView.this.hL(ConcernPageView.this.etH.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.etq.setVisibility(8);
                if (ConcernPageView.this.etI != null) {
                    ConcernPageView.this.etI.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.etH != null) {
                    ConcernPageView.this.hL(ConcernPageView.this.etH.hasMore());
                }
                ConcernPageView.this.etq.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.abx();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aLr() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.abx();
                if (v.I(ConcernPageView.this.etq.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.etL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aaA();
            }
        };
        this.etM = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.etJ = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.etq = new BdTypeListView(context);
        this.etq.setDividerHeight(0);
        this.etq.setSelector(17170445);
        this.bPm = new PbListView(context);
        this.bPm.getView();
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.setHeight(l.h(context, e.C0210e.tbds182));
        this.bPm.Fm();
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPm.ew(e.d.cp_cont_e);
        this.bPm.setOnClickListener(this.etL);
        this.etq.setNextPage(this.bPm);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new k(this.pageContext);
        this.etq.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dNy = BdListViewHelper.a(context, this.etq, BdListViewHelper.HeadType.DEFAULT);
        }
        this.etF = new com.baidu.tieba.homepage.concern.a(context, this.etq);
        this.etH = new b(this.pageContext, this.etq, this.etF);
        addView(this.etq);
        this.etq.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dNy != null && this.dNy.getLayoutParams() != null) {
            this.dNy.getLayoutParams().height = i;
            this.dNy.setLayoutParams(this.dNy.getLayoutParams());
        }
        this.mHeaderViewHeight = i;
    }

    public void aGi() {
        this.etH.a(this.etK);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.Wk().ka("page_concern");
                    ConcernPageView.this.etH.update();
                }
            }
        });
        this.etq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aaA();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL(boolean z) {
        if (this.bPm != null) {
            if (z) {
                this.bPm.Fs();
                this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bPm.eA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.etG = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bPm != null) {
            this.bPm.Fq();
            this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.etH.a(z, dataRes, 0, null);
    }

    public void aLl() {
        if (!TbadkCoreApplication.isLogin()) {
            aLo();
        } else if (this.etH != null) {
            i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
            this.etH.update();
        }
    }

    public void aLm() {
        if (!TbadkCoreApplication.isLogin()) {
            aLo();
        } else if (this.etH != null) {
            this.etH.aLs();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.v vVar) {
        if (this.etH != null) {
            this.etH.setRecommendFrsNavigationAnimDispatcher(vVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.etI != null) {
                this.etI.onChangeSkinType(i);
            }
            if (this.bLl != null) {
                this.bLl.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.bPm != null) {
                this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bPm.ey(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
            }
            this.etF.onChangeSkinType(i);
            al.j(this, e.d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void ah(String str, int i) {
        if (this.bPm != null) {
            this.bPm.Fq();
            this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.etH.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.etH != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.etH.update();
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
        if (this.bLl != null) {
            this.bLl.dettachView(this);
            this.bLl = null;
            this.etq.setNextPage(this.bPm);
        }
        if (this.etG != null) {
            this.etG.G(z, z2);
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
        if (this.etI == null) {
            this.etI = new ConcernNotLoginLayout(getContext());
            this.etI.onChangeSkinType(this.mSkinType);
        }
        if (this.etI.getParent() == null) {
            this.etq.setVisibility(8);
            this.etI.setVisibility(0);
            addView(this.etI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bLl == null) {
            if (i < 0) {
                this.bLl = new f(getContext());
            } else {
                this.bLl = new f(getContext(), i);
            }
            this.bLl.onChangeSkinType();
        }
        this.bLl.attachView(this, z);
        this.etq.setNextPage(null);
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
        if (this.etH != null) {
            this.etH.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.etH != null) {
            this.etH.gJ(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.etH != null) {
            this.etH.hM(z);
        }
    }

    public void reload() {
        if (this.etq != null) {
            if (this.etJ && this.etq.getFirstVisiblePosition() != 0) {
                this.etJ = false;
                return;
            }
            this.etq.setSelection(0);
            if (this.etq.isRefreshDone()) {
                this.etq.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.etH.a((b.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.etq.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.etq.setRecyclerListener(null);
    }

    public void aLp() {
        if (this.etH != null) {
            this.etH.gJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (this.bPm != null && !this.bPm.Fv()) {
            this.bPm.Fp();
            this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.etH.aaA();
    }
}
