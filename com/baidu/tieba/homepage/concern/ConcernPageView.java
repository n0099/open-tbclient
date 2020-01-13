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
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes7.dex */
public class ConcernPageView extends FrameLayout {
    private PbListView ehe;
    private int ejq;
    private g epL;
    private com.baidu.tieba.homepage.personalize.bigday.a gUK;
    private BdTypeRecyclerView gUL;
    private com.baidu.tieba.homepage.concern.a gUM;
    private a gUN;
    private c gUO;
    private ConcernNotLoginLayout gUP;
    private boolean gUQ;
    private ScrollFragmentTabHost gUR;
    ScrollFragmentTabHost.a gUS;
    private BigdaySwipeRefreshLayout gUT;
    private c.a gUU;
    private View.OnClickListener gUV;
    private CustomMessageListener gUW;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes7.dex */
    public interface a {
        void BN(String str);

        void R(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gUR = scrollFragmentTabHost;
        if (this.gUR != null) {
            this.gUR.b(this.gUS);
            this.gUR.a(this.gUS);
        }
    }

    public void completePullRefresh() {
        if (this.gUT != null) {
            this.gUT.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gUM != null) {
            this.gUM.setPageUniqueId(bdUniqueId);
        }
        if (this.gUO != null) {
            this.gUO.q(bdUniqueId);
        }
        if (this.gUK != null) {
            this.gUK.setTag(bdUniqueId);
        }
        if (this.gUW != null) {
            this.gUW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gUW);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.gUQ = false;
        this.mSkinType = 3;
        this.ejq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.ejq != i && ConcernPageView.this.gUR != null) {
                    ConcernPageView.this.ejq = i;
                    if (ConcernPageView.this.ejq == 1) {
                        ConcernPageView.this.gUR.bav();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gUR.baw();
                    } else {
                        ConcernPageView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUS = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bLB() {
                if (ConcernPageView.this.gUR != null) {
                    ConcernPageView.this.ejq = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gUL)) {
                        ConcernPageView.this.gUR.baw();
                    } else {
                        ConcernPageView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUU = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bLC() {
                ConcernPageView.this.baf();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gUL.setSelection(0);
                if (ConcernPageView.this.gUL.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bLy();
                } else {
                    ConcernPageView.this.eF(true);
                }
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void BM(String str) {
                ConcernPageView.this.baf();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bLx();
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.BN(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.R(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gUL.setVisibility(8);
                    ConcernPageView.this.kJ(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Q(boolean z, boolean z2) {
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.R(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.baf();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gUO.bLF()) {
                    ConcernPageView.this.bLy();
                } else {
                    ConcernPageView.this.bLx();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bLD() {
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.R(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.baf();
                ConcernPageView.this.gUL.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gUV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aZN();
            }
        };
        this.gUW = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gUQ = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gUQ = false;
        this.mSkinType = 3;
        this.ejq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.ejq != i && ConcernPageView.this.gUR != null) {
                    ConcernPageView.this.ejq = i;
                    if (ConcernPageView.this.ejq == 1) {
                        ConcernPageView.this.gUR.bav();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gUR.baw();
                    } else {
                        ConcernPageView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUS = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bLB() {
                if (ConcernPageView.this.gUR != null) {
                    ConcernPageView.this.ejq = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gUL)) {
                        ConcernPageView.this.gUR.baw();
                    } else {
                        ConcernPageView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUU = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bLC() {
                ConcernPageView.this.baf();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gUL.setSelection(0);
                if (ConcernPageView.this.gUL.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bLy();
                } else {
                    ConcernPageView.this.eF(true);
                }
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void BM(String str) {
                ConcernPageView.this.baf();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bLx();
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.BN(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.R(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gUL.setVisibility(8);
                    ConcernPageView.this.kJ(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Q(boolean z, boolean z2) {
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.R(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.baf();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gUO.bLF()) {
                    ConcernPageView.this.bLy();
                } else {
                    ConcernPageView.this.bLx();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bLD() {
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.R(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.baf();
                ConcernPageView.this.gUL.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gUV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aZN();
            }
        };
        this.gUW = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gUQ = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gUQ = false;
        this.mSkinType = 3;
        this.ejq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.ejq != i2 && ConcernPageView.this.gUR != null) {
                    ConcernPageView.this.ejq = i2;
                    if (ConcernPageView.this.ejq == 1) {
                        ConcernPageView.this.gUR.bav();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gUR.baw();
                    } else {
                        ConcernPageView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUS = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bLB() {
                if (ConcernPageView.this.gUR != null) {
                    ConcernPageView.this.ejq = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gUL)) {
                        ConcernPageView.this.gUR.baw();
                    } else {
                        ConcernPageView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUU = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bLC() {
                ConcernPageView.this.baf();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gUL.setSelection(0);
                if (ConcernPageView.this.gUL.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bLy();
                } else {
                    ConcernPageView.this.eF(true);
                }
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void BM(String str) {
                ConcernPageView.this.baf();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bLx();
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.BN(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.R(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.gUL.setVisibility(8);
                    ConcernPageView.this.kJ(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Q(boolean z, boolean z2) {
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.R(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.baf();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gUO.bLF()) {
                    ConcernPageView.this.bLy();
                } else {
                    ConcernPageView.this.bLx();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bLD() {
                if (ConcernPageView.this.gUN != null) {
                    ConcernPageView.this.gUN.R(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.baf();
                ConcernPageView.this.gUL.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gUV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aZN();
            }
        };
        this.gUW = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gUQ = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gUL = new BdTypeRecyclerView(context);
        this.gUL.setLayoutManager(new LinearLayoutManager(context));
        this.gUL.setFadingEdgeLength(0);
        this.gUL.setOverScrollMode(2);
        this.gUT = new BigdaySwipeRefreshLayout(context);
        this.gUT.addView(this.gUL);
        this.ehe = new PbListView(context);
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setLineGone();
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ehe.setOnClickListener(this.gUV);
        this.gUL.setNextPage(this.ehe);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.gUT);
        this.gUK = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gUK.setEnable(true);
        this.gUT.setProgressView(this.gUK);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.gUT.setCustomDistances(i, i, i * 2);
        this.gUM = new com.baidu.tieba.homepage.concern.a(context, this.gUL);
        this.gUO = new c(this.pageContext, this.gUL, this.gUM, this.gUT);
        this.gUT.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void initListeners() {
        this.gUO.a(this.gUU);
        this.gUK.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aVo().wt("page_concern");
                    ConcernPageView.this.gUO.update();
                }
            }
        });
        this.gUL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aZN();
            }
        });
        this.gUL.removeOnScrollListener(this.mOnScrollListener);
        this.gUL.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.gUN = aVar;
    }

    public void bLu() {
        if (!TbadkCoreApplication.isLogin()) {
            bLw();
        } else if (this.gUO != null) {
            this.gUO.update();
            eF(true);
        }
    }

    public void bLv() {
        if (!TbadkCoreApplication.isLogin()) {
            bLw();
        } else if (this.gUO != null) {
            this.gUO.bLE();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gUO != null) {
            this.gUO.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gUP != null) {
                this.gUP.onChangeSkinType(i);
            }
            if (this.epL != null) {
                this.epL.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gUK != null) {
                this.gUK.changeSkin(i);
            }
            if (this.ehe != null) {
                this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
                this.ehe.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gUM.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.gUT, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gUL, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bLz();
    }

    public void aG(String str, int i) {
        this.gUO.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.gUO.a(z, dataRes, 0, null);
    }

    public void kJ(boolean z) {
        if (!bxH()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.gUO != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.gUO.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baf() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this);
            this.epL = null;
        }
    }

    private boolean bxH() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bLw() {
        if (this.gUP == null) {
            this.gUP = new ConcernNotLoginLayout(getContext());
            this.gUP.onChangeSkinType(this.mSkinType);
        }
        if (this.gUP.getParent() == null) {
            this.gUT.setVisibility(8);
            this.gUP.setVisibility(0);
            addView(this.gUP);
        }
    }

    public boolean bxG() {
        if (this.epL != null) {
            return this.epL.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(boolean z) {
        if (!bxG()) {
            if (this.epL == null) {
                this.epL = new com.baidu.tbadk.k.g(getContext());
                this.epL.mm(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.epL.aNv();
                this.epL.setWrapStyle(true);
            }
            this.epL.onChangeSkinType();
            this.epL.attachView(this, z);
        }
    }

    public void bLx() {
        this.gUT.setVisibility(0);
        this.gUL.setVisibility(0);
        if (this.gUO.hasMore()) {
            this.ehe.startLoadData();
        } else {
            this.ehe.endLoadDataWithNoMore();
        }
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void bLy() {
        this.gUT.setVisibility(0);
        this.gUL.setVisibility(0);
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.cr(null, getContext().getString(R.string.concern_no_data_title)), null);
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
        if (this.gUO != null) {
            this.gUO.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.gUO != null) {
            this.gUO.lq(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gUO != null) {
            this.gUO.mv(z);
        }
        if (this.gUR != null) {
            this.gUR.b(this.gUS);
            this.gUR.a(this.gUS);
            this.gUS.bLB();
        }
    }

    public void reload() {
        if (this.gUL != null && this.gUT != null) {
            if (this.gUQ && this.gUL.getFirstVisiblePosition() != 0) {
                this.gUQ = false;
                return;
            }
            this.gUL.setSelection(0);
            if (!this.gUT.isRefreshing()) {
                this.gUT.setRefreshing(true);
            }
            if (this.gUS != null) {
                this.gUS.bLB();
            }
        }
    }

    public void onDestroy() {
        if (this.gUR != null) {
            this.gUR.b(this.gUS);
        }
        this.gUL.removeOnScrollListener(this.mOnScrollListener);
        this.gUO.a((c.a) null);
        this.gUK.setListPullRefreshListener(null);
        this.gUK.a((g.d) null);
        this.gUL.setOnSrollToBottomListener(null);
        this.gUK.a((g.b) null);
        this.gUK.release();
        this.gUL.setRecyclerListener(null);
    }

    public void bLz() {
        if (this.gUM != null) {
            this.gUM.notifyDataSetChanged();
        }
    }

    public void bLA() {
        if (this.gUO != null) {
            this.gUO.lq(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZN() {
        if (this.gUO != null) {
            this.gUO.aZN();
        }
    }

    public void rl() {
        if (this.gUM != null) {
            List<m> dataList = this.gUM.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cNc != 0 && kVar.cNb != null) {
                            int[] imageWidthAndHeight = kVar.cNb.getImageWidthAndHeight();
                            kVar.cNc = imageWidthAndHeight[0];
                            kVar.cNd = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gUM != null) {
                            ConcernPageView.this.gUM.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
