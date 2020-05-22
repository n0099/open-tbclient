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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes9.dex */
public class ConcernPageView extends FrameLayout {
    private PbListView fbY;
    private int feq;
    private g fkQ;
    private com.baidu.tieba.homepage.personalize.bigday.a hWN;
    private BdTypeRecyclerView hWO;
    private com.baidu.tieba.homepage.concern.a hWP;
    private a hWQ;
    private c hWR;
    private ConcernNotLoginLayout hWS;
    private boolean hWT;
    private ScrollFragmentTabHost hWU;
    ScrollFragmentTabHost.a hWV;
    private BigdaySwipeRefreshLayout hWW;
    private c.a hWX;
    private View.OnClickListener hWY;
    private CustomMessageListener hWZ;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void Fy(String str);

        void W(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hWU = scrollFragmentTabHost;
        if (this.hWU != null) {
            this.hWU.b(this.hWV);
            this.hWU.a(this.hWV);
        }
    }

    public void completePullRefresh() {
        if (this.hWW != null) {
            this.hWW.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hWP != null) {
            this.hWP.setPageUniqueId(bdUniqueId);
        }
        if (this.hWR != null) {
            this.hWR.s(bdUniqueId);
        }
        if (this.hWN != null) {
            this.hWN.setTag(bdUniqueId);
        }
        if (this.hWZ != null) {
            this.hWZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hWZ);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.hWT = false;
        this.mSkinType = 3;
        this.feq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.feq != i && ConcernPageView.this.hWU != null) {
                    ConcernPageView.this.feq = i;
                    if (ConcernPageView.this.feq == 1) {
                        ConcernPageView.this.hWU.bre();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hWU.brf();
                    } else {
                        ConcernPageView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cet() {
                if (ConcernPageView.this.hWU != null) {
                    ConcernPageView.this.feq = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hWO)) {
                        ConcernPageView.this.hWU.brf();
                    } else {
                        ConcernPageView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWX = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ceu() {
                ConcernPageView.this.bqO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hWO.setSelection(0);
                if (ConcernPageView.this.hWO.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.ceq();
                } else {
                    ConcernPageView.this.fV(true);
                }
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Fx(String str) {
                ConcernPageView.this.bqO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cep();
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.Fy(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.W(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.hWO.setVisibility(8);
                    ConcernPageView.this.mq(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void V(boolean z, boolean z2) {
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.W(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqO();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hWR.cex()) {
                    ConcernPageView.this.ceq();
                } else {
                    ConcernPageView.this.cep();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cev() {
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.W(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqO();
                ConcernPageView.this.hWO.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bqv();
            }
        };
        this.hWZ = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hWT = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWT = false;
        this.mSkinType = 3;
        this.feq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.feq != i && ConcernPageView.this.hWU != null) {
                    ConcernPageView.this.feq = i;
                    if (ConcernPageView.this.feq == 1) {
                        ConcernPageView.this.hWU.bre();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hWU.brf();
                    } else {
                        ConcernPageView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cet() {
                if (ConcernPageView.this.hWU != null) {
                    ConcernPageView.this.feq = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hWO)) {
                        ConcernPageView.this.hWU.brf();
                    } else {
                        ConcernPageView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWX = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ceu() {
                ConcernPageView.this.bqO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hWO.setSelection(0);
                if (ConcernPageView.this.hWO.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.ceq();
                } else {
                    ConcernPageView.this.fV(true);
                }
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Fx(String str) {
                ConcernPageView.this.bqO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cep();
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.Fy(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.W(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.hWO.setVisibility(8);
                    ConcernPageView.this.mq(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void V(boolean z, boolean z2) {
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.W(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqO();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hWR.cex()) {
                    ConcernPageView.this.ceq();
                } else {
                    ConcernPageView.this.cep();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cev() {
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.W(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqO();
                ConcernPageView.this.hWO.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bqv();
            }
        };
        this.hWZ = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hWT = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWT = false;
        this.mSkinType = 3;
        this.feq = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.feq != i2 && ConcernPageView.this.hWU != null) {
                    ConcernPageView.this.feq = i2;
                    if (ConcernPageView.this.feq == 1) {
                        ConcernPageView.this.hWU.bre();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hWU.brf();
                    } else {
                        ConcernPageView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cet() {
                if (ConcernPageView.this.hWU != null) {
                    ConcernPageView.this.feq = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hWO)) {
                        ConcernPageView.this.hWU.brf();
                    } else {
                        ConcernPageView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWX = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ceu() {
                ConcernPageView.this.bqO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hWO.setSelection(0);
                if (ConcernPageView.this.hWO.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.ceq();
                } else {
                    ConcernPageView.this.fV(true);
                }
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Fx(String str) {
                ConcernPageView.this.bqO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cep();
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.Fy(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.W(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.hWO.setVisibility(8);
                    ConcernPageView.this.mq(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void V(boolean z, boolean z2) {
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.W(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqO();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hWR.cex()) {
                    ConcernPageView.this.ceq();
                } else {
                    ConcernPageView.this.cep();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cev() {
                if (ConcernPageView.this.hWQ != null) {
                    ConcernPageView.this.hWQ.W(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqO();
                ConcernPageView.this.hWO.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bqv();
            }
        };
        this.hWZ = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hWT = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hWO = new BdTypeRecyclerView(context);
        this.hWO.setLayoutManager(new LinearLayoutManager(context));
        this.hWO.setFadingEdgeLength(0);
        this.hWO.setOverScrollMode(2);
        this.hWW = new BigdaySwipeRefreshLayout(context);
        this.hWW.addView(this.hWO);
        this.fbY = new PbListView(context);
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setLineGone();
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.setOnClickListener(this.hWY);
        this.hWO.setNextPage(this.fbY);
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        addView(this.hWW);
        this.hWN = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.hWN.setEnable(true);
        this.hWW.setProgressView(this.hWN);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.hWW.setCustomDistances(i, i, i * 2);
        this.hWP = new com.baidu.tieba.homepage.concern.a(context, this.hWO);
        this.hWR = new c(this.pageContext, this.hWO, this.hWP, this.hWW);
        this.hWW.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bwA() {
        this.hWR.a(this.hWX);
        this.hWN.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.blZ().zK("page_concern");
                    ConcernPageView.this.hWR.update();
                }
            }
        });
        this.hWO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bqv();
            }
        });
        this.hWO.removeOnScrollListener(this.mOnScrollListener);
        this.hWO.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.hWQ = aVar;
    }

    public void cem() {
        if (!TbadkCoreApplication.isLogin()) {
            ceo();
        } else if (this.hWR != null) {
            this.hWR.update();
            fV(true);
        }
    }

    public void cen() {
        if (!TbadkCoreApplication.isLogin()) {
            ceo();
        } else if (this.hWR != null) {
            this.hWR.cew();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.hWR != null) {
            this.hWR.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hWS != null) {
                this.hWS.onChangeSkinType(i);
            }
            if (this.fkQ != null) {
                this.fkQ.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hWN != null) {
                this.hWN.changeSkin(i);
            }
            if (this.fbY != null) {
                this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
                this.fbY.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.hWP.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.hWW, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hWO, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cer();
    }

    public void aP(String str, int i) {
        this.hWR.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.hWR.a(z, dataRes, 0, null);
    }

    public void mq(boolean z) {
        if (!bPM()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.hWR != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.hWR.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqO() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this);
            this.fkQ = null;
        }
    }

    private boolean bPM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void ceo() {
        if (this.hWS == null) {
            this.hWS = new ConcernNotLoginLayout(getContext());
            this.hWS.onChangeSkinType(this.mSkinType);
        }
        if (this.hWS.getParent() == null) {
            this.hWW.setVisibility(8);
            this.hWS.setVisibility(0);
            addView(this.hWS);
        }
    }

    public boolean bPL() {
        if (this.fkQ != null) {
            return this.fkQ.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(boolean z) {
        if (!bPL()) {
            if (this.fkQ == null) {
                this.fkQ = new g(getContext());
                this.fkQ.ba(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.fkQ.bew();
                this.fkQ.setWrapStyle(true);
            }
            this.fkQ.onChangeSkinType();
            this.fkQ.attachView(this, z);
        }
    }

    public void cep() {
        this.hWW.setVisibility(0);
        this.hWO.setVisibility(0);
        if (this.hWR.hasMore()) {
            this.fbY.startLoadData();
        } else {
            this.fbY.endLoadDataWithNoMore();
        }
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fbY.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void ceq() {
        this.hWW.setVisibility(0);
        this.hWO.setVisibility(0);
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fbY.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dj(null, getContext().getString(R.string.concern_no_data_title)), null);
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
        if (this.hWR != null) {
            this.hWR.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.hWR != null) {
            this.hWR.mX(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hWR != null) {
            this.hWR.oc(z);
        }
        if (this.hWU != null) {
            this.hWU.b(this.hWV);
            this.hWU.a(this.hWV);
            this.hWV.cet();
        }
    }

    public void reload() {
        if (this.hWO != null && this.hWW != null) {
            if (this.hWT && this.hWO.getFirstVisiblePosition() != 0) {
                this.hWT = false;
                return;
            }
            this.hWO.setSelection(0);
            if (!this.hWW.isRefreshing()) {
                this.hWW.setRefreshing(true);
            }
            if (this.hWV != null) {
                this.hWV.cet();
            }
        }
    }

    public void onDestroy() {
        if (this.hWU != null) {
            this.hWU.b(this.hWV);
        }
        this.hWO.removeOnScrollListener(this.mOnScrollListener);
        this.hWR.a((c.a) null);
        this.hWN.setListPullRefreshListener(null);
        this.hWN.a((f.d) null);
        this.hWO.setOnSrollToBottomListener(null);
        this.hWN.a((f.b) null);
        this.hWN.release();
        this.hWO.setRecyclerListener(null);
    }

    public void cer() {
        if (this.hWP != null) {
            this.hWP.notifyDataSetChanged();
        }
    }

    public void ces() {
        if (this.hWR != null) {
            this.hWR.mX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqv() {
        if (this.hWR != null) {
            this.hWR.bqv();
        }
    }

    public void ya() {
        if (this.hWP != null) {
            List<o> dataList = this.hWP.getDataList();
            if (!v.isEmpty(dataList)) {
                for (o oVar : dataList) {
                    if (oVar instanceof k) {
                        k kVar = (k) oVar;
                        if (kVar.dEB != 0 && kVar.dEA != null) {
                            int[] imageWidthAndHeight = kVar.dEA.getImageWidthAndHeight();
                            kVar.dEB = imageWidthAndHeight[0];
                            kVar.dEC = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.hWP != null) {
                            ConcernPageView.this.hWP.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
