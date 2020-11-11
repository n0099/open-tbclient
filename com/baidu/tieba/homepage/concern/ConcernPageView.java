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
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes22.dex */
public class ConcernPageView extends FrameLayout {
    private PbListView gjo;
    private int glP;
    private g gso;
    private ScrollFragmentTabHost jvA;
    ScrollFragmentTabHost.a jvB;
    private BigdaySwipeRefreshLayout jvC;
    private d.a jvD;
    private View.OnClickListener jvE;
    private CustomMessageListener jvF;
    private CustomMessageListener jvG;
    private com.baidu.tieba.homepage.personalize.bigday.a jvt;
    private BdTypeRecyclerView jvu;
    private com.baidu.tieba.homepage.concern.a jvv;
    private a jvw;
    private d jvx;
    private ConcernNotLoginLayout jvy;
    private boolean jvz;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes22.dex */
    public interface a {
        void LB(String str);

        void ag(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jvA = scrollFragmentTabHost;
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
            this.jvA.a(this.jvB);
        }
    }

    public void completePullRefresh() {
        if (this.jvC != null) {
            this.jvC.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jvv != null) {
            this.jvv.setPageUniqueId(bdUniqueId);
        }
        if (this.jvx != null) {
            this.jvx.s(bdUniqueId);
        }
        if (this.jvt != null) {
            this.jvt.setTag(bdUniqueId);
        }
        if (this.jvF != null) {
            this.jvF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jvF);
        }
        MessageManager.getInstance().registerListener(this.jvG);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.jvz = false;
        this.mSkinType = 3;
        this.glP = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.glP != i && ConcernPageView.this.jvA != null) {
                    ConcernPageView.this.glP = i;
                    if (ConcernPageView.this.glP == 1) {
                        ConcernPageView.this.jvA.bPq();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jvA.bPr();
                    } else {
                        ConcernPageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvB = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cIH() {
                if (ConcernPageView.this.jvA != null) {
                    ConcernPageView.this.glP = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jvu)) {
                        ConcernPageView.this.jvA.bPr();
                    } else {
                        ConcernPageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvD = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cII() {
                ConcernPageView.this.Wk();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jvu.setSelection(0);
                if (ConcernPageView.this.jvu.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cIE();
                } else {
                    ConcernPageView.this.hJ(true);
                }
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void LA(String str) {
                ConcernPageView.this.Wk();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cID();
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.LB(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jvu.setVisibility(8);
                    ConcernPageView.this.oY(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Wk();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jvx.cIN()) {
                    ConcernPageView.this.cIE();
                } else {
                    ConcernPageView.this.cID();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cIJ() {
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Wk();
                ConcernPageView.this.jvu.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jvE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bOI();
            }
        };
        this.jvF = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jvz = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jvG = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jvx.cIK();
                    } else {
                        ConcernPageView.this.jvx.cIL();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvz = false;
        this.mSkinType = 3;
        this.glP = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.glP != i && ConcernPageView.this.jvA != null) {
                    ConcernPageView.this.glP = i;
                    if (ConcernPageView.this.glP == 1) {
                        ConcernPageView.this.jvA.bPq();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jvA.bPr();
                    } else {
                        ConcernPageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvB = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cIH() {
                if (ConcernPageView.this.jvA != null) {
                    ConcernPageView.this.glP = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jvu)) {
                        ConcernPageView.this.jvA.bPr();
                    } else {
                        ConcernPageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvD = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cII() {
                ConcernPageView.this.Wk();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jvu.setSelection(0);
                if (ConcernPageView.this.jvu.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cIE();
                } else {
                    ConcernPageView.this.hJ(true);
                }
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void LA(String str) {
                ConcernPageView.this.Wk();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cID();
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.LB(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jvu.setVisibility(8);
                    ConcernPageView.this.oY(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Wk();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jvx.cIN()) {
                    ConcernPageView.this.cIE();
                } else {
                    ConcernPageView.this.cID();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cIJ() {
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Wk();
                ConcernPageView.this.jvu.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jvE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bOI();
            }
        };
        this.jvF = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jvz = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jvG = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jvx.cIK();
                    } else {
                        ConcernPageView.this.jvx.cIL();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvz = false;
        this.mSkinType = 3;
        this.glP = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.glP != i2 && ConcernPageView.this.jvA != null) {
                    ConcernPageView.this.glP = i2;
                    if (ConcernPageView.this.glP == 1) {
                        ConcernPageView.this.jvA.bPq();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jvA.bPr();
                    } else {
                        ConcernPageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvB = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cIH() {
                if (ConcernPageView.this.jvA != null) {
                    ConcernPageView.this.glP = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jvu)) {
                        ConcernPageView.this.jvA.bPr();
                    } else {
                        ConcernPageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvD = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cII() {
                ConcernPageView.this.Wk();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jvu.setSelection(0);
                if (ConcernPageView.this.jvu.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cIE();
                } else {
                    ConcernPageView.this.hJ(true);
                }
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void LA(String str) {
                ConcernPageView.this.Wk();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cID();
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.LB(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.jvu.setVisibility(8);
                    ConcernPageView.this.oY(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Wk();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jvx.cIN()) {
                    ConcernPageView.this.cIE();
                } else {
                    ConcernPageView.this.cID();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cIJ() {
                if (ConcernPageView.this.jvw != null) {
                    ConcernPageView.this.jvw.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Wk();
                ConcernPageView.this.jvu.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jvE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bOI();
            }
        };
        this.jvF = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jvz = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jvG = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jvx.cIK();
                    } else {
                        ConcernPageView.this.jvx.cIL();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jvu = new BdTypeRecyclerView(context);
        this.jvu.setLayoutManager(new LinearLayoutManager(context));
        this.jvu.setFadingEdgeLength(0);
        this.jvu.setOverScrollMode(2);
        this.jvC = new BigdaySwipeRefreshLayout(context);
        this.jvC.addView(this.jvu);
        this.gjo = new PbListView(context);
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setLineGone();
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.setOnClickListener(this.jvE);
        this.jvu.setNextPage(this.gjo);
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        addView(this.jvC);
        this.jvt = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.jvt.setEnable(true);
        this.jvC.setProgressView(this.jvt);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.jvC.setCustomDistances(i, i, i * 2);
        this.jvv = new com.baidu.tieba.homepage.concern.a(context, this.jvu);
        this.jvx = new d(this.pageContext, this.jvu, this.jvv, this.jvC);
        this.jvC.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bWm() {
        this.jvx.a(this.jvD);
        this.jvt.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bIR().EY("page_concern");
                    ConcernPageView.this.jvx.update();
                }
            }
        });
        this.jvu.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bOI();
            }
        });
        this.jvu.removeOnScrollListener(this.mOnScrollListener);
        this.jvu.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.jvw = aVar;
    }

    public void cIA() {
        if (!TbadkCoreApplication.isLogin()) {
            cIC();
        } else if (this.jvx != null) {
            this.jvx.update();
            hJ(true);
        }
    }

    public void cIB() {
        if (!TbadkCoreApplication.isLogin()) {
            cIC();
        } else if (this.jvx != null) {
            this.jvx.cIM();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.jvx != null) {
            this.jvx.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jvy != null) {
                this.jvy.onChangeSkinType(i);
            }
            if (this.gso != null) {
                this.gso.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jvt != null) {
                this.jvt.changeSkin(i);
            }
            if (this.gjo != null) {
                this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.gjo.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.jvv.onChangeSkinType(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jvC, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jvu, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cIF();
    }

    public void aU(String str, int i) {
        this.jvx.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.jvx.a(z, dataRes, 0, null);
    }

    public void oY(boolean z) {
        if (!cmK()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.jvx != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.jvx.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
        }
    }

    private boolean cmK() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cIC() {
        if (this.jvy == null) {
            this.jvy = new ConcernNotLoginLayout(getContext());
            this.jvy.onChangeSkinType(this.mSkinType);
        }
        if (this.jvy.getParent() == null) {
            this.jvC.setVisibility(8);
            this.jvy.setVisibility(0);
            addView(this.jvy);
        }
    }

    public boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(getContext());
                this.gso.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gso.bBg();
                this.gso.setWrapStyle(true);
            }
            this.gso.onChangeSkinType();
            this.gso.attachView(this, z);
        }
    }

    public void cID() {
        this.jvC.setVisibility(0);
        this.jvu.setVisibility(0);
        if (this.jvx.hasMore()) {
            this.gjo.startLoadData();
        } else {
            this.gjo.endLoadDataWithNoMore();
        }
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cIE() {
        this.jvC.setVisibility(0);
        this.jvu.setVisibility(0);
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_home_concern_all_status", 0);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dS(null, getContext().getString(R.string.concern_no_data_title)), null);
            this.mNoDataView.setTitleContainerMargin(R.dimen.tbds0, R.dimen.tbds0);
        }
        if (i == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getContext().getString(R.string.concern_person_no_data_title)));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getContext().getString(R.string.concern_no_data_title)));
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
        if (this.jvx != null) {
            this.jvx.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jvx != null) {
            this.jvx.pF(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jvx != null) {
            this.jvx.qM(z);
        }
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
            this.jvA.a(this.jvB);
            this.jvB.cIH();
        }
    }

    public void reload() {
        if (this.jvu != null && this.jvC != null) {
            if (this.jvz && this.jvu.getFirstVisiblePosition() != 0) {
                this.jvz = false;
                return;
            }
            this.jvu.setSelection(0);
            if (!this.jvC.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.jvx.update();
                    }
                } else {
                    this.jvC.setRefreshing(true);
                }
            }
            if (!this.jvC.isRefreshing()) {
                this.jvC.setRefreshing(true);
            }
            if (this.jvB != null) {
                this.jvB.cIH();
            }
        }
    }

    public void onDestroy() {
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
        }
        this.jvu.removeOnScrollListener(this.mOnScrollListener);
        this.jvx.a((d.a) null);
        this.jvt.setListPullRefreshListener(null);
        this.jvt.a((f.d) null);
        this.jvu.setOnSrollToBottomListener(null);
        this.jvt.a((f.b) null);
        this.jvt.release();
        this.jvu.setRecyclerListener(null);
    }

    public void cIF() {
        if (this.jvv != null) {
            this.jvv.notifyDataSetChanged();
        }
    }

    public void cIG() {
        if (this.jvx != null) {
            this.jvx.pF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOI() {
        if (this.jvx != null) {
            this.jvx.bOI();
        }
    }

    public void GI() {
        if (this.jvv != null) {
            List<q> dataList = this.jvv.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof com.baidu.tieba.card.data.l) {
                        com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                        if (lVar.eDx != 0 && lVar.exA != null) {
                            int[] imageWidthAndHeight = lVar.exA.getImageWidthAndHeight();
                            lVar.eDx = imageWidthAndHeight[0];
                            lVar.eDy = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.jvv != null) {
                            ConcernPageView.this.jvv.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
