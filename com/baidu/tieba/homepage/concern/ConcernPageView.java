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
    private g gAe;
    private PbListView gre;
    private int gtF;
    private com.baidu.tieba.homepage.personalize.bigday.a jJG;
    private BdTypeRecyclerView jJH;
    private com.baidu.tieba.homepage.concern.a jJI;
    private a jJJ;
    private d jJK;
    private ConcernNotLoginLayout jJL;
    private boolean jJM;
    private ScrollFragmentTabHost jJN;
    ScrollFragmentTabHost.a jJO;
    private BigdaySwipeRefreshLayout jJP;
    private d.a jJQ;
    private View.OnClickListener jJR;
    private CustomMessageListener jJS;
    private CustomMessageListener jJT;
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
        this.jJN = scrollFragmentTabHost;
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
            this.jJN.a(this.jJO);
        }
    }

    public void completePullRefresh() {
        if (this.jJP != null) {
            this.jJP.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jJI != null) {
            this.jJI.setPageUniqueId(bdUniqueId);
        }
        if (this.jJK != null) {
            this.jJK.s(bdUniqueId);
        }
        if (this.jJG != null) {
            this.jJG.setTag(bdUniqueId);
        }
        if (this.jJS != null) {
            this.jJS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jJS);
        }
        MessageManager.getInstance().registerListener(this.jJT);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.jJM = false;
        this.mSkinType = 3;
        this.gtF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gtF != i && ConcernPageView.this.jJN != null) {
                    ConcernPageView.this.gtF = i;
                    if (ConcernPageView.this.gtF == 1) {
                        ConcernPageView.this.jJN.bSu();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jJN.bSv();
                    } else {
                        ConcernPageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJO = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNB() {
                if (ConcernPageView.this.jJN != null) {
                    ConcernPageView.this.gtF = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jJH)) {
                        ConcernPageView.this.jJN.bSv();
                    } else {
                        ConcernPageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJQ = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cNC() {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jJH.setSelection(0);
                if (ConcernPageView.this.jJH.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cNy();
                } else {
                    ConcernPageView.this.ib(true);
                }
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Mi(String str) {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cNx();
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.Mj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jJH.setVisibility(8);
                    ConcernPageView.this.px(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jJK.cNH()) {
                    ConcernPageView.this.cNy();
                } else {
                    ConcernPageView.this.cNx();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cND() {
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.jJH.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jJR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRM();
            }
        };
        this.jJS = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jJM = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jJT = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jJK.cNE();
                    } else {
                        ConcernPageView.this.jJK.cNF();
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
        this.jJM = false;
        this.mSkinType = 3;
        this.gtF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gtF != i && ConcernPageView.this.jJN != null) {
                    ConcernPageView.this.gtF = i;
                    if (ConcernPageView.this.gtF == 1) {
                        ConcernPageView.this.jJN.bSu();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jJN.bSv();
                    } else {
                        ConcernPageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJO = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNB() {
                if (ConcernPageView.this.jJN != null) {
                    ConcernPageView.this.gtF = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jJH)) {
                        ConcernPageView.this.jJN.bSv();
                    } else {
                        ConcernPageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJQ = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cNC() {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jJH.setSelection(0);
                if (ConcernPageView.this.jJH.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cNy();
                } else {
                    ConcernPageView.this.ib(true);
                }
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Mi(String str) {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cNx();
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.Mj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jJH.setVisibility(8);
                    ConcernPageView.this.px(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jJK.cNH()) {
                    ConcernPageView.this.cNy();
                } else {
                    ConcernPageView.this.cNx();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cND() {
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.jJH.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jJR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRM();
            }
        };
        this.jJS = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jJM = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jJT = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jJK.cNE();
                    } else {
                        ConcernPageView.this.jJK.cNF();
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
        this.jJM = false;
        this.mSkinType = 3;
        this.gtF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.gtF != i2 && ConcernPageView.this.jJN != null) {
                    ConcernPageView.this.gtF = i2;
                    if (ConcernPageView.this.gtF == 1) {
                        ConcernPageView.this.jJN.bSu();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jJN.bSv();
                    } else {
                        ConcernPageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJO = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNB() {
                if (ConcernPageView.this.jJN != null) {
                    ConcernPageView.this.gtF = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jJH)) {
                        ConcernPageView.this.jJN.bSv();
                    } else {
                        ConcernPageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJQ = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cNC() {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jJH.setSelection(0);
                if (ConcernPageView.this.jJH.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cNy();
                } else {
                    ConcernPageView.this.ib(true);
                }
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Mi(String str) {
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cNx();
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.Mj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.jJH.setVisibility(8);
                    ConcernPageView.this.px(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jJK.cNH()) {
                    ConcernPageView.this.cNy();
                } else {
                    ConcernPageView.this.cNx();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cND() {
                if (ConcernPageView.this.jJJ != null) {
                    ConcernPageView.this.jJJ.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Yb();
                ConcernPageView.this.jJH.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jJR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRM();
            }
        };
        this.jJS = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jJM = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jJT = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jJK.cNE();
                    } else {
                        ConcernPageView.this.jJK.cNF();
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
        this.jJH = new BdTypeRecyclerView(context);
        this.jJH.setLayoutManager(new LinearLayoutManager(context));
        this.jJH.setFadingEdgeLength(0);
        this.jJH.setOverScrollMode(2);
        if (!com.baidu.tbadk.a.d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.jJH.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        this.jJP = new BigdaySwipeRefreshLayout(context);
        this.jJP.addView(this.jJH);
        this.gre = new PbListView(context);
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.transparent);
        this.gre.setLineGone();
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.setOnClickListener(this.jJR);
        this.jJH.setNextPage(this.gre);
        e<?> J = i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        addView(this.jJP);
        this.jJG = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.jJG.setEnable(true);
        this.jJP.setProgressView(this.jJG);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.jJP.setCustomDistances(i, i, i * 2);
        this.jJI = new com.baidu.tieba.homepage.concern.a(context, this.jJH);
        this.jJK = new d(this.pageContext, this.jJH, this.jJI, this.jJP);
        this.jJP.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bZp() {
        this.jJK.a(this.jJQ);
        this.jJG.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bLT().Fn("page_concern");
                    ConcernPageView.this.jJK.update();
                }
            }
        });
        this.jJH.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bRM();
            }
        });
        this.jJH.removeOnScrollListener(this.mOnScrollListener);
        this.jJH.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.jJJ = aVar;
    }

    public void cNu() {
        if (!TbadkCoreApplication.isLogin()) {
            cNw();
        } else if (this.jJK != null) {
            this.jJK.update();
            ib(true);
        }
    }

    public void cNv() {
        if (!TbadkCoreApplication.isLogin()) {
            cNw();
        } else if (this.jJK != null) {
            this.jJK.cNG();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.jJK != null) {
            this.jJK.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jJL != null) {
                this.jJL.onChangeSkinType(i);
            }
            if (this.gAe != null) {
                this.gAe.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jJG != null) {
                this.jJG.changeSkin(i);
            }
            if (this.gre != null) {
                this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.gre.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            }
            this.jJI.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cNz();
    }

    public void aU(String str, int i) {
        this.jJK.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.jJK.a(z, dataRes, 0, null);
    }

    public void px(boolean z) {
        if (!cqz()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.jJK != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.jJK.update();
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
        if (this.gAe != null) {
            this.gAe.dettachView(this);
            this.gAe = null;
        }
    }

    private boolean cqz() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cNw() {
        if (this.jJL == null) {
            this.jJL = new ConcernNotLoginLayout(getContext());
            this.jJL.onChangeSkinType(this.mSkinType);
        }
        if (this.jJL.getParent() == null) {
            this.jJP.setVisibility(8);
            this.jJL.setVisibility(0);
            addView(this.jJL);
        }
    }

    public boolean cqy() {
        if (this.gAe != null) {
            return this.gAe.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib(boolean z) {
        if (!cqy()) {
            if (this.gAe == null) {
                this.gAe = new g(getContext());
                this.gAe.bv(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gAe.bDY();
                this.gAe.setWrapStyle(true);
            }
            this.gAe.onChangeSkinType();
            this.gAe.attachView(this, z);
        }
    }

    public void cNx() {
        this.jJP.setVisibility(0);
        this.jJH.setVisibility(0);
        if (this.jJK.hasMore()) {
            this.gre.startLoadData();
        } else {
            this.gre.endLoadDataWithNoMore();
        }
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cNy() {
        this.jJP.setVisibility(0);
        this.jJH.setVisibility(0);
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.setHeight(0);
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
        if (this.jJK != null) {
            this.jJK.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jJK != null) {
            this.jJK.qf(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jJK != null) {
            this.jJK.rq(z);
        }
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
            this.jJN.a(this.jJO);
            this.jJO.cNB();
        }
    }

    public void reload() {
        if (this.jJH != null && this.jJP != null) {
            if (this.jJM && this.jJH.getFirstVisiblePosition() != 0) {
                this.jJM = false;
                return;
            }
            this.jJH.setSelection(0);
            if (!this.jJP.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.jJK.update();
                    }
                } else {
                    this.jJP.setRefreshing(true);
                }
            }
            if (!this.jJP.isRefreshing()) {
                this.jJP.setRefreshing(true);
            }
            if (this.jJO != null) {
                this.jJO.cNB();
            }
        }
    }

    public void onDestroy() {
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
        }
        this.jJH.removeOnScrollListener(this.mOnScrollListener);
        this.jJK.a((d.a) null);
        this.jJG.setListPullRefreshListener(null);
        this.jJG.a((f.d) null);
        this.jJH.setOnSrollToBottomListener(null);
        this.jJG.a((f.b) null);
        this.jJG.release();
        this.jJH.setRecyclerListener(null);
        this.jJK.onDestroy();
    }

    public void cNz() {
        if (this.jJI != null) {
            this.jJI.notifyDataSetChanged();
        }
    }

    public void cNA() {
        if (this.jJK != null) {
            this.jJK.qf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRM() {
        if (this.jJK != null) {
            this.jJK.bRM();
        }
    }

    public void HO() {
        if (this.jJI != null) {
            List<q> dataList = this.jJI.getDataList();
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
                        if (ConcernPageView.this.jJI != null) {
                            ConcernPageView.this.jJI.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
