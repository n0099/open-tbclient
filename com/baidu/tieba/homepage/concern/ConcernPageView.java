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
    private PbListView fDW;
    private int fGp;
    private g fMN;
    ScrollFragmentTabHost.a iGA;
    private BigdaySwipeRefreshLayout iGB;
    private c.a iGC;
    private View.OnClickListener iGD;
    private CustomMessageListener iGE;
    private com.baidu.tieba.homepage.personalize.bigday.a iGs;
    private BdTypeRecyclerView iGt;
    private com.baidu.tieba.homepage.concern.a iGu;
    private a iGv;
    private c iGw;
    private ConcernNotLoginLayout iGx;
    private boolean iGy;
    private ScrollFragmentTabHost iGz;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes16.dex */
    public interface a {
        void JA(String str);

        void ac(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iGz = scrollFragmentTabHost;
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
            this.iGz.a(this.iGA);
        }
    }

    public void completePullRefresh() {
        if (this.iGB != null) {
            this.iGB.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iGu != null) {
            this.iGu.setPageUniqueId(bdUniqueId);
        }
        if (this.iGw != null) {
            this.iGw.t(bdUniqueId);
        }
        if (this.iGs != null) {
            this.iGs.setTag(bdUniqueId);
        }
        if (this.iGE != null) {
            this.iGE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iGE);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.iGy = false;
        this.mSkinType = 3;
        this.fGp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fGp != i && ConcernPageView.this.iGz != null) {
                    ConcernPageView.this.fGp = i;
                    if (ConcernPageView.this.fGp == 1) {
                        ConcernPageView.this.iGz.bGl();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.iGz.bGm();
                    } else {
                        ConcernPageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGA = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwh() {
                if (ConcernPageView.this.iGz != null) {
                    ConcernPageView.this.fGp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.iGt)) {
                        ConcernPageView.this.iGz.bGm();
                    } else {
                        ConcernPageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGC = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwi() {
                ConcernPageView.this.bFW();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.iGt.setSelection(0);
                if (ConcernPageView.this.iGt.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cwe();
                } else {
                    ConcernPageView.this.gS(true);
                }
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Jz(String str) {
                ConcernPageView.this.bFW();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cwd();
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.JA(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.ac(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.iGt.setVisibility(8);
                    ConcernPageView.this.nK(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ab(boolean z, boolean z2) {
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.ac(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFW();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.iGw.cwl()) {
                    ConcernPageView.this.cwe();
                } else {
                    ConcernPageView.this.cwd();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwj() {
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.ac(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFW();
                ConcernPageView.this.iGt.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iGD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bFD();
            }
        };
        this.iGE = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.iGy = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iGy = false;
        this.mSkinType = 3;
        this.fGp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fGp != i && ConcernPageView.this.iGz != null) {
                    ConcernPageView.this.fGp = i;
                    if (ConcernPageView.this.fGp == 1) {
                        ConcernPageView.this.iGz.bGl();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.iGz.bGm();
                    } else {
                        ConcernPageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGA = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwh() {
                if (ConcernPageView.this.iGz != null) {
                    ConcernPageView.this.fGp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.iGt)) {
                        ConcernPageView.this.iGz.bGm();
                    } else {
                        ConcernPageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGC = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwi() {
                ConcernPageView.this.bFW();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.iGt.setSelection(0);
                if (ConcernPageView.this.iGt.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cwe();
                } else {
                    ConcernPageView.this.gS(true);
                }
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Jz(String str) {
                ConcernPageView.this.bFW();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cwd();
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.JA(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.ac(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.iGt.setVisibility(8);
                    ConcernPageView.this.nK(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ab(boolean z, boolean z2) {
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.ac(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFW();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.iGw.cwl()) {
                    ConcernPageView.this.cwe();
                } else {
                    ConcernPageView.this.cwd();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwj() {
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.ac(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFW();
                ConcernPageView.this.iGt.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iGD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bFD();
            }
        };
        this.iGE = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.iGy = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iGy = false;
        this.mSkinType = 3;
        this.fGp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.fGp != i2 && ConcernPageView.this.iGz != null) {
                    ConcernPageView.this.fGp = i2;
                    if (ConcernPageView.this.fGp == 1) {
                        ConcernPageView.this.iGz.bGl();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.iGz.bGm();
                    } else {
                        ConcernPageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGA = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwh() {
                if (ConcernPageView.this.iGz != null) {
                    ConcernPageView.this.fGp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.iGt)) {
                        ConcernPageView.this.iGz.bGm();
                    } else {
                        ConcernPageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGC = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwi() {
                ConcernPageView.this.bFW();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.iGt.setSelection(0);
                if (ConcernPageView.this.iGt.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cwe();
                } else {
                    ConcernPageView.this.gS(true);
                }
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Jz(String str) {
                ConcernPageView.this.bFW();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cwd();
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.JA(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.ac(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.iGt.setVisibility(8);
                    ConcernPageView.this.nK(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ab(boolean z, boolean z2) {
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.ac(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFW();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.iGw.cwl()) {
                    ConcernPageView.this.cwe();
                } else {
                    ConcernPageView.this.cwd();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cwj() {
                if (ConcernPageView.this.iGv != null) {
                    ConcernPageView.this.iGv.ac(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bFW();
                ConcernPageView.this.iGt.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iGD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bFD();
            }
        };
        this.iGE = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.iGy = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.iGt = new BdTypeRecyclerView(context);
        this.iGt.setLayoutManager(new LinearLayoutManager(context));
        this.iGt.setFadingEdgeLength(0);
        this.iGt.setOverScrollMode(2);
        this.iGB = new BigdaySwipeRefreshLayout(context);
        this.iGB.addView(this.iGt);
        this.fDW = new PbListView(context);
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setLineGone();
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.setOnClickListener(this.iGD);
        this.iGt.setNextPage(this.fDW);
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        addView(this.iGB);
        this.iGs = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.iGs.setEnable(true);
        this.iGB.setProgressView(this.iGs);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.iGB.setCustomDistances(i, i, i * 2);
        this.iGu = new com.baidu.tieba.homepage.concern.a(context, this.iGt);
        this.iGw = new c(this.pageContext, this.iGt, this.iGu, this.iGB);
        this.iGB.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bMg() {
        this.iGw.a(this.iGC);
        this.iGs.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.bAA().Di("page_concern");
                    ConcernPageView.this.iGw.update();
                }
            }
        });
        this.iGt.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bFD();
            }
        });
        this.iGt.removeOnScrollListener(this.mOnScrollListener);
        this.iGt.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.iGv = aVar;
    }

    public void cwa() {
        if (!TbadkCoreApplication.isLogin()) {
            cwc();
        } else if (this.iGw != null) {
            this.iGw.update();
            gS(true);
        }
    }

    public void cwb() {
        if (!TbadkCoreApplication.isLogin()) {
            cwc();
        } else if (this.iGw != null) {
            this.iGw.cwk();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.iGw != null) {
            this.iGw.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iGx != null) {
                this.iGx.onChangeSkinType(i);
            }
            if (this.fMN != null) {
                this.fMN.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.iGs != null) {
                this.iGs.changeSkin(i);
            }
            if (this.fDW != null) {
                this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.fDW.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.iGu.onChangeSkinType(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.iGB, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.iGt, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cwf();
    }

    public void aQ(String str, int i) {
        this.iGw.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.iGw.a(z, dataRes, 0, null);
    }

    public void nK(boolean z) {
        if (!cgw()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.iGw != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.iGw.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFW() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
            this.fMN = null;
        }
    }

    private boolean cgw() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cwc() {
        if (this.iGx == null) {
            this.iGx = new ConcernNotLoginLayout(getContext());
            this.iGx.onChangeSkinType(this.mSkinType);
        }
        if (this.iGx.getParent() == null) {
            this.iGB.setVisibility(8);
            this.iGx.setVisibility(0);
            addView(this.iGx);
        }
    }

    public boolean cgv() {
        if (this.fMN != null) {
            return this.fMN.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gS(boolean z) {
        if (!cgv()) {
            if (this.fMN == null) {
                this.fMN = new g(getContext());
                this.fMN.bn(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.fMN.bsZ();
                this.fMN.setWrapStyle(true);
            }
            this.fMN.onChangeSkinType();
            this.fMN.attachView(this, z);
        }
    }

    public void cwd() {
        this.iGB.setVisibility(0);
        this.iGt.setVisibility(0);
        if (this.iGw.hasMore()) {
            this.fDW.startLoadData();
        } else {
            this.fDW.endLoadDataWithNoMore();
        }
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cwe() {
        this.iGB.setVisibility(0);
        this.iGt.setVisibility(0);
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.setHeight(0);
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
        if (this.iGw != null) {
            this.iGw.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.iGw != null) {
            this.iGw.or(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.iGw != null) {
            this.iGw.py(z);
        }
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
            this.iGz.a(this.iGA);
            this.iGA.cwh();
        }
    }

    public void reload() {
        if (this.iGt != null && this.iGB != null) {
            if (this.iGy && this.iGt.getFirstVisiblePosition() != 0) {
                this.iGy = false;
                return;
            }
            this.iGt.setSelection(0);
            if (!this.iGB.isRefreshing()) {
                this.iGB.setRefreshing(true);
            }
            if (this.iGA != null) {
                this.iGA.cwh();
            }
        }
    }

    public void onDestroy() {
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
        }
        this.iGt.removeOnScrollListener(this.mOnScrollListener);
        this.iGw.a((c.a) null);
        this.iGs.setListPullRefreshListener(null);
        this.iGs.a((f.d) null);
        this.iGt.setOnSrollToBottomListener(null);
        this.iGs.a((f.b) null);
        this.iGs.release();
        this.iGt.setRecyclerListener(null);
    }

    public void cwf() {
        if (this.iGu != null) {
            this.iGu.notifyDataSetChanged();
        }
    }

    public void cwg() {
        if (this.iGw != null) {
            this.iGw.or(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFD() {
        if (this.iGw != null) {
            this.iGw.bFD();
        }
    }

    public void EF() {
        if (this.iGu != null) {
            List<q> dataList = this.iGu.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof com.baidu.tieba.card.data.l) {
                        com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                        if (lVar.eaP != 0 && lVar.dUS != null) {
                            int[] imageWidthAndHeight = lVar.dUS.getImageWidthAndHeight();
                            lVar.eaP = imageWidthAndHeight[0];
                            lVar.eaQ = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.iGu != null) {
                            ConcernPageView.this.iGu.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
