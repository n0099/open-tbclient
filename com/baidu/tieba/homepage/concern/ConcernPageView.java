package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes16.dex */
public class ConcernPageView extends FrameLayout {
    private PbListView fEa;
    private int fGt;
    private g fMR;
    private com.baidu.tieba.homepage.concern.a iGA;
    private a iGB;
    private c iGC;
    private ConcernNotLoginLayout iGD;
    private boolean iGE;
    private ScrollFragmentTabHost iGF;
    ScrollFragmentTabHost.a iGG;
    private BigdaySwipeRefreshLayout iGH;
    private c.a iGI;
    private View.OnClickListener iGJ;
    private CustomMessageListener iGK;
    private com.baidu.tieba.homepage.personalize.bigday.a iGy;
    private BdTypeRecyclerView iGz;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes16.dex */
    public interface a {
        void JB(String str);

        void ac(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iGF = scrollFragmentTabHost;
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
            this.iGF.a(this.iGG);
        }
    }

    public void completePullRefresh() {
        if (this.iGH != null) {
            this.iGH.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iGA != null) {
            this.iGA.setPageUniqueId(bdUniqueId);
        }
        if (this.iGC != null) {
            this.iGC.t(bdUniqueId);
        }
        if (this.iGy != null) {
            this.iGy.setTag(bdUniqueId);
        }
        if (this.iGK != null) {
            this.iGK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iGK);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.iGE = false;
        this.mSkinType = 3;
        this.fGt = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fGt != i && ConcernPageView.this.iGF != null) {
                    ConcernPageView.this.fGt = i;
                    if (ConcernPageView.this.fGt == 1) {
                        ConcernPageView.this.iGF.bGm();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.iGF.bGn();
                    } else {
                        ConcernPageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGG = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwi() {
                if (ConcernPageView.this.iGF != null) {
                    ConcernPageView.this.fGt = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.iGz)) {
                        ConcernPageView.this.iGF.bGn();
                    } else {
                        ConcernPageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGI = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwj() {
                ConcernPageView.this.bFX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.iGz.setSelection(0);
                if (ConcernPageView.this.iGz.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cwf();
                } else {
                    ConcernPageView.this.gT(true);
                }
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void JA(String str) {
                ConcernPageView.this.bFX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cwe();
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.JB(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.ac(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.iGz.setVisibility(8);
                    ConcernPageView.this.nM(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ab(boolean z, boolean z2) {
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.ac(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFX();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.iGC.cwm()) {
                    ConcernPageView.this.cwf();
                } else {
                    ConcernPageView.this.cwe();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwk() {
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.ac(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFX();
                ConcernPageView.this.iGz.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iGJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bFE();
            }
        };
        this.iGK = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.iGE = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iGE = false;
        this.mSkinType = 3;
        this.fGt = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fGt != i && ConcernPageView.this.iGF != null) {
                    ConcernPageView.this.fGt = i;
                    if (ConcernPageView.this.fGt == 1) {
                        ConcernPageView.this.iGF.bGm();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.iGF.bGn();
                    } else {
                        ConcernPageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGG = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwi() {
                if (ConcernPageView.this.iGF != null) {
                    ConcernPageView.this.fGt = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.iGz)) {
                        ConcernPageView.this.iGF.bGn();
                    } else {
                        ConcernPageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGI = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwj() {
                ConcernPageView.this.bFX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.iGz.setSelection(0);
                if (ConcernPageView.this.iGz.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cwf();
                } else {
                    ConcernPageView.this.gT(true);
                }
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void JA(String str) {
                ConcernPageView.this.bFX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cwe();
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.JB(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.ac(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.iGz.setVisibility(8);
                    ConcernPageView.this.nM(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ab(boolean z, boolean z2) {
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.ac(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFX();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.iGC.cwm()) {
                    ConcernPageView.this.cwf();
                } else {
                    ConcernPageView.this.cwe();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwk() {
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.ac(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFX();
                ConcernPageView.this.iGz.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iGJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bFE();
            }
        };
        this.iGK = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.iGE = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iGE = false;
        this.mSkinType = 3;
        this.fGt = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.fGt != i2 && ConcernPageView.this.iGF != null) {
                    ConcernPageView.this.fGt = i2;
                    if (ConcernPageView.this.fGt == 1) {
                        ConcernPageView.this.iGF.bGm();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.iGF.bGn();
                    } else {
                        ConcernPageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGG = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwi() {
                if (ConcernPageView.this.iGF != null) {
                    ConcernPageView.this.fGt = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.iGz)) {
                        ConcernPageView.this.iGF.bGn();
                    } else {
                        ConcernPageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGI = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwj() {
                ConcernPageView.this.bFX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.iGz.setSelection(0);
                if (ConcernPageView.this.iGz.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cwf();
                } else {
                    ConcernPageView.this.gT(true);
                }
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void JA(String str) {
                ConcernPageView.this.bFX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cwe();
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.JB(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.ac(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.iGz.setVisibility(8);
                    ConcernPageView.this.nM(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ab(boolean z, boolean z2) {
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.ac(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFX();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.iGC.cwm()) {
                    ConcernPageView.this.cwf();
                } else {
                    ConcernPageView.this.cwe();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwk() {
                if (ConcernPageView.this.iGB != null) {
                    ConcernPageView.this.iGB.ac(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFX();
                ConcernPageView.this.iGz.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iGJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bFE();
            }
        };
        this.iGK = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.iGE = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.iGz = new BdTypeRecyclerView(context);
        this.iGz.setLayoutManager(new LinearLayoutManager(context));
        this.iGz.setFadingEdgeLength(0);
        this.iGz.setOverScrollMode(2);
        this.iGH = new BigdaySwipeRefreshLayout(context);
        this.iGH.addView(this.iGz);
        this.fEa = new PbListView(context);
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setLineGone();
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.setOnClickListener(this.iGJ);
        this.iGz.setNextPage(this.fEa);
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        addView(this.iGH);
        this.iGy = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.iGy.setEnable(true);
        this.iGH.setProgressView(this.iGy);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.iGH.setCustomDistances(i, i, i * 2);
        this.iGA = new com.baidu.tieba.homepage.concern.a(context, this.iGz);
        this.iGC = new c(this.pageContext, this.iGz, this.iGA, this.iGH);
        this.iGH.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bMh() {
        this.iGC.a(this.iGI);
        this.iGy.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.bAB().Dj("page_concern");
                    ConcernPageView.this.iGC.update();
                }
            }
        });
        this.iGz.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bFE();
            }
        });
        this.iGz.removeOnScrollListener(this.mOnScrollListener);
        this.iGz.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.iGB = aVar;
    }

    public void cwb() {
        if (!TbadkCoreApplication.isLogin()) {
            cwd();
        } else if (this.iGC != null) {
            this.iGC.update();
            gT(true);
        }
    }

    public void cwc() {
        if (!TbadkCoreApplication.isLogin()) {
            cwd();
        } else if (this.iGC != null) {
            this.iGC.cwl();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.iGC != null) {
            this.iGC.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iGD != null) {
                this.iGD.onChangeSkinType(i);
            }
            if (this.fMR != null) {
                this.fMR.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.iGy != null) {
                this.iGy.changeSkin(i);
            }
            if (this.fEa != null) {
                this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.fEa.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.iGA.onChangeSkinType(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.iGH, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.iGz, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cwg();
    }

    public void aQ(String str, int i) {
        this.iGC.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.iGC.a(z, dataRes, 0, null);
    }

    public void nM(boolean z) {
        if (!cgx()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.iGC != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.iGC.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this);
            this.fMR = null;
        }
    }

    private boolean cgx() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cwd() {
        if (this.iGD == null) {
            this.iGD = new ConcernNotLoginLayout(getContext());
            this.iGD.onChangeSkinType(this.mSkinType);
        }
        if (this.iGD.getParent() == null) {
            this.iGH.setVisibility(8);
            this.iGD.setVisibility(0);
            addView(this.iGD);
        }
    }

    public boolean cgw() {
        if (this.fMR != null) {
            return this.fMR.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gT(boolean z) {
        if (!cgw()) {
            if (this.fMR == null) {
                this.fMR = new g(getContext());
                this.fMR.bn(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.fMR.bta();
                this.fMR.setWrapStyle(true);
            }
            this.fMR.onChangeSkinType();
            this.fMR.attachView(this, z);
        }
    }

    public void cwe() {
        this.iGH.setVisibility(0);
        this.iGz.setVisibility(0);
        if (this.iGC.hasMore()) {
            this.fEa.startLoadData();
        } else {
            this.fEa.endLoadDataWithNoMore();
        }
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cwf() {
        this.iGH.setVisibility(0);
        this.iGz.setVisibility(0);
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dE(null, getContext().getString(R.string.concern_no_data_title)), null);
            this.mNoDataView.setTitleContainerMargin(R.dimen.tbds0, R.dimen.tbds0);
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
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
        if (this.iGC != null) {
            this.iGC.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.iGC != null) {
            this.iGC.ot(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.iGC != null) {
            this.iGC.pA(z);
        }
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
            this.iGF.a(this.iGG);
            this.iGG.cwi();
        }
    }

    public void reload() {
        if (this.iGz != null && this.iGH != null) {
            if (this.iGE && this.iGz.getFirstVisiblePosition() != 0) {
                this.iGE = false;
                return;
            }
            this.iGz.setSelection(0);
            if (!this.iGH.isRefreshing()) {
                this.iGH.setRefreshing(true);
            }
            if (this.iGG != null) {
                this.iGG.cwi();
            }
        }
    }

    public void onDestroy() {
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
        }
        this.iGz.removeOnScrollListener(this.mOnScrollListener);
        this.iGC.a((c.a) null);
        this.iGy.setListPullRefreshListener(null);
        this.iGy.a((f.d) null);
        this.iGz.setOnSrollToBottomListener(null);
        this.iGy.a((f.b) null);
        this.iGy.release();
        this.iGz.setRecyclerListener(null);
    }

    public void cwg() {
        if (this.iGA != null) {
            this.iGA.notifyDataSetChanged();
        }
    }

    public void cwh() {
        if (this.iGC != null) {
            this.iGC.ot(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFE() {
        if (this.iGC != null) {
            this.iGC.bFE();
        }
    }

    public void EF() {
        if (this.iGA != null) {
            List<q> dataList = this.iGA.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof com.baidu.tieba.card.data.l) {
                        com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                        if (lVar.eaT != 0 && lVar.dUW != null) {
                            int[] imageWidthAndHeight = lVar.dUW.getImageWidthAndHeight();
                            lVar.eaT = imageWidthAndHeight[0];
                            lVar.eaU = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.iGA != null) {
                            ConcernPageView.this.iGA.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
