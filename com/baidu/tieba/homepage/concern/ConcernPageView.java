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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes22.dex */
public class ConcernPageView extends FrameLayout {
    private g gAg;
    private PbListView grg;
    private int gtH;
    private com.baidu.tieba.homepage.personalize.bigday.a jJI;
    private BdTypeRecyclerView jJJ;
    private com.baidu.tieba.homepage.concern.a jJK;
    private a jJL;
    private d jJM;
    private ConcernNotLoginLayout jJN;
    private boolean jJO;
    private ScrollFragmentTabHost jJP;
    ScrollFragmentTabHost.a jJQ;
    private BigdaySwipeRefreshLayout jJR;
    private d.a jJS;
    private View.OnClickListener jJT;
    private CustomMessageListener jJU;
    private CustomMessageListener jJV;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes22.dex */
    public interface a {
        void Mj(String str);

        void ag(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jJP = scrollFragmentTabHost;
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
            this.jJP.a(this.jJQ);
        }
    }

    public void completePullRefresh() {
        if (this.jJR != null) {
            this.jJR.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jJK != null) {
            this.jJK.setPageUniqueId(bdUniqueId);
        }
        if (this.jJM != null) {
            this.jJM.s(bdUniqueId);
        }
        if (this.jJI != null) {
            this.jJI.setTag(bdUniqueId);
        }
        if (this.jJU != null) {
            this.jJU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jJU);
        }
        MessageManager.getInstance().registerListener(this.jJV);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.jJO = false;
        this.mSkinType = 3;
        this.gtH = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gtH != i && ConcernPageView.this.jJP != null) {
                    ConcernPageView.this.gtH = i;
                    if (ConcernPageView.this.gtH == 1) {
                        ConcernPageView.this.jJP.bSv();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jJP.bSw();
                    } else {
                        ConcernPageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJQ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNC() {
                if (ConcernPageView.this.jJP != null) {
                    ConcernPageView.this.gtH = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jJJ)) {
                        ConcernPageView.this.jJP.bSw();
                    } else {
                        ConcernPageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJS = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cND() {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jJJ.setSelection(0);
                if (ConcernPageView.this.jJJ.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cNz();
                } else {
                    ConcernPageView.this.ib(true);
                }
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Mi(String str) {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cNy();
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.Mj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jJJ.setVisibility(8);
                    ConcernPageView.this.px(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jJM.cNI()) {
                    ConcernPageView.this.cNz();
                } else {
                    ConcernPageView.this.cNy();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cNE() {
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.jJJ.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jJT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRN();
            }
        };
        this.jJU = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jJO = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jJV = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jJM.cNF();
                    } else {
                        ConcernPageView.this.jJM.cNG();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jJO = false;
        this.mSkinType = 3;
        this.gtH = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gtH != i && ConcernPageView.this.jJP != null) {
                    ConcernPageView.this.gtH = i;
                    if (ConcernPageView.this.gtH == 1) {
                        ConcernPageView.this.jJP.bSv();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jJP.bSw();
                    } else {
                        ConcernPageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJQ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNC() {
                if (ConcernPageView.this.jJP != null) {
                    ConcernPageView.this.gtH = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jJJ)) {
                        ConcernPageView.this.jJP.bSw();
                    } else {
                        ConcernPageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJS = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cND() {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jJJ.setSelection(0);
                if (ConcernPageView.this.jJJ.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cNz();
                } else {
                    ConcernPageView.this.ib(true);
                }
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Mi(String str) {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cNy();
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.Mj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jJJ.setVisibility(8);
                    ConcernPageView.this.px(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jJM.cNI()) {
                    ConcernPageView.this.cNz();
                } else {
                    ConcernPageView.this.cNy();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cNE() {
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.jJJ.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jJT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRN();
            }
        };
        this.jJU = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jJO = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jJV = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jJM.cNF();
                    } else {
                        ConcernPageView.this.jJM.cNG();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jJO = false;
        this.mSkinType = 3;
        this.gtH = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.gtH != i2 && ConcernPageView.this.jJP != null) {
                    ConcernPageView.this.gtH = i2;
                    if (ConcernPageView.this.gtH == 1) {
                        ConcernPageView.this.jJP.bSv();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jJP.bSw();
                    } else {
                        ConcernPageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJQ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNC() {
                if (ConcernPageView.this.jJP != null) {
                    ConcernPageView.this.gtH = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jJJ)) {
                        ConcernPageView.this.jJP.bSw();
                    } else {
                        ConcernPageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJS = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cND() {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jJJ.setSelection(0);
                if (ConcernPageView.this.jJJ.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cNz();
                } else {
                    ConcernPageView.this.ib(true);
                }
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Mi(String str) {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cNy();
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.Mj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.jJJ.setVisibility(8);
                    ConcernPageView.this.px(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jJM.cNI()) {
                    ConcernPageView.this.cNz();
                } else {
                    ConcernPageView.this.cNy();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cNE() {
                if (ConcernPageView.this.jJL != null) {
                    ConcernPageView.this.jJL.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.jJJ.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jJT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRN();
            }
        };
        this.jJU = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jJO = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jJV = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jJM.cNF();
                    } else {
                        ConcernPageView.this.jJM.cNG();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jJJ = new BdTypeRecyclerView(context);
        this.jJJ.setLayoutManager(new LinearLayoutManager(context));
        this.jJJ.setFadingEdgeLength(0);
        this.jJJ.setOverScrollMode(2);
        if (!com.baidu.tbadk.a.d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.jJJ.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        this.jJR = new BigdaySwipeRefreshLayout(context);
        this.jJR.addView(this.jJJ);
        this.grg = new PbListView(context);
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.transparent);
        this.grg.setLineGone();
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.setOnClickListener(this.jJT);
        this.jJJ.setNextPage(this.grg);
        e<?> J = i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        addView(this.jJR);
        this.jJI = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.jJI.setEnable(true);
        this.jJR.setProgressView(this.jJI);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.jJR.setCustomDistances(i, i, i * 2);
        this.jJK = new com.baidu.tieba.homepage.concern.a(context, this.jJJ);
        this.jJM = new d(this.pageContext, this.jJJ, this.jJK, this.jJR);
        this.jJR.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bZq() {
        this.jJM.a(this.jJS);
        this.jJI.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bLU().Fn("page_concern");
                    ConcernPageView.this.jJM.update();
                }
            }
        });
        this.jJJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bRN();
            }
        });
        this.jJJ.removeOnScrollListener(this.mOnScrollListener);
        this.jJJ.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.jJL = aVar;
    }

    public void cNv() {
        if (!TbadkCoreApplication.isLogin()) {
            cNx();
        } else if (this.jJM != null) {
            this.jJM.update();
            ib(true);
        }
    }

    public void cNw() {
        if (!TbadkCoreApplication.isLogin()) {
            cNx();
        } else if (this.jJM != null) {
            this.jJM.cNH();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.jJM != null) {
            this.jJM.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jJN != null) {
                this.jJN.onChangeSkinType(i);
            }
            if (this.gAg != null) {
                this.gAg.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jJI != null) {
                this.jJI.changeSkin(i);
            }
            if (this.grg != null) {
                this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.grg.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            }
            this.jJK.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cNA();
    }

    public void aU(String str, int i) {
        this.jJM.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.jJM.a(z, dataRes, 0, null);
    }

    public void px(boolean z) {
        if (!cqA()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.jJM != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.jJM.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yb() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this);
            this.gAg = null;
        }
    }

    private boolean cqA() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cNx() {
        if (this.jJN == null) {
            this.jJN = new ConcernNotLoginLayout(getContext());
            this.jJN.onChangeSkinType(this.mSkinType);
        }
        if (this.jJN.getParent() == null) {
            this.jJR.setVisibility(8);
            this.jJN.setVisibility(0);
            addView(this.jJN);
        }
    }

    public boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib(boolean z) {
        if (!cqz()) {
            if (this.gAg == null) {
                this.gAg = new g(getContext());
                this.gAg.bv(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gAg.bDY();
                this.gAg.setWrapStyle(true);
            }
            this.gAg.onChangeSkinType();
            this.gAg.attachView(this, z);
        }
    }

    public void cNy() {
        this.jJR.setVisibility(0);
        this.jJJ.setVisibility(0);
        if (this.jJM.hasMore()) {
            this.grg.startLoadData();
        } else {
            this.grg.endLoadDataWithNoMore();
        }
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cNz() {
        this.jJR.setVisibility(0);
        this.jJJ.setVisibility(0);
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_home_concern_all_status", 0);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dZ(null, getContext().getString(R.string.concern_no_data_title)), null);
        }
        if (i == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getContext().getString(R.string.concern_person_no_data_title)));
            this.mNoDataView.setImgOption(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getContext().getString(R.string.concern_no_data_title)));
            this.mNoDataView.setImgOption(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL));
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
        if (this.jJM != null) {
            this.jJM.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jJM != null) {
            this.jJM.qf(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jJM != null) {
            this.jJM.rq(z);
        }
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
            this.jJP.a(this.jJQ);
            this.jJQ.cNC();
        }
    }

    public void reload() {
        if (this.jJJ != null && this.jJR != null) {
            if (this.jJO && this.jJJ.getFirstVisiblePosition() != 0) {
                this.jJO = false;
                return;
            }
            this.jJJ.setSelection(0);
            if (!this.jJR.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.jJM.update();
                    }
                } else {
                    this.jJR.setRefreshing(true);
                }
            }
            if (!this.jJR.isRefreshing()) {
                this.jJR.setRefreshing(true);
            }
            if (this.jJQ != null) {
                this.jJQ.cNC();
            }
        }
    }

    public void onDestroy() {
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
        }
        this.jJJ.removeOnScrollListener(this.mOnScrollListener);
        this.jJM.a((d.a) null);
        this.jJI.setListPullRefreshListener(null);
        this.jJI.a((f.d) null);
        this.jJJ.setOnSrollToBottomListener(null);
        this.jJI.a((f.b) null);
        this.jJI.release();
        this.jJJ.setRecyclerListener(null);
        this.jJM.onDestroy();
    }

    public void cNA() {
        if (this.jJK != null) {
            this.jJK.notifyDataSetChanged();
        }
    }

    public void cNB() {
        if (this.jJM != null) {
            this.jJM.qf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        if (this.jJM != null) {
            this.jJM.bRN();
        }
    }

    public void HO() {
        if (this.jJK != null) {
            List<q> dataList = this.jJK.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof k) {
                        k kVar = (k) qVar;
                        if (kVar.eIP != 0 && kVar.eCR != null) {
                            int[] imageWidthAndHeight = kVar.eCR.getImageWidthAndHeight();
                            kVar.eIP = imageWidthAndHeight[0];
                            kVar.eIQ = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.jJK != null) {
                            ConcernPageView.this.jJK.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
