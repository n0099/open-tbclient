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
    private PbListView fTv;
    private int fVW;
    private g gcx;
    private com.baidu.tieba.homepage.personalize.bigday.a jda;
    private BdTypeRecyclerView jdb;
    private com.baidu.tieba.homepage.concern.a jdc;
    private a jdd;
    private d jde;
    private ConcernNotLoginLayout jdf;
    private boolean jdg;
    private ScrollFragmentTabHost jdh;
    ScrollFragmentTabHost.a jdi;
    private BigdaySwipeRefreshLayout jdj;
    private d.a jdk;
    private View.OnClickListener jdl;
    private CustomMessageListener jdm;
    private CustomMessageListener jdn;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes22.dex */
    public interface a {
        void KM(String str);

        void ad(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jdh = scrollFragmentTabHost;
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
            this.jdh.a(this.jdi);
        }
    }

    public void completePullRefresh() {
        if (this.jdj != null) {
            this.jdj.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jdc != null) {
            this.jdc.setPageUniqueId(bdUniqueId);
        }
        if (this.jde != null) {
            this.jde.s(bdUniqueId);
        }
        if (this.jda != null) {
            this.jda.setTag(bdUniqueId);
        }
        if (this.jdm != null) {
            this.jdm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jdm);
        }
        MessageManager.getInstance().registerListener(this.jdn);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.jdg = false;
        this.mSkinType = 3;
        this.fVW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fVW != i && ConcernPageView.this.jdh != null) {
                    ConcernPageView.this.fVW = i;
                    if (ConcernPageView.this.fVW == 1) {
                        ConcernPageView.this.jdh.bKo();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jdh.bKp();
                    } else {
                        ConcernPageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdi = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cCZ() {
                if (ConcernPageView.this.jdh != null) {
                    ConcernPageView.this.fVW = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jdb)) {
                        ConcernPageView.this.jdh.bKp();
                    } else {
                        ConcernPageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdk = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cDa() {
                ConcernPageView.this.SK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jdb.setSelection(0);
                if (ConcernPageView.this.jdb.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cCW();
                } else {
                    ConcernPageView.this.hn(true);
                }
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void KL(String str) {
                ConcernPageView.this.SK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cCV();
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.KM(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.ad(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jdb.setVisibility(8);
                    ConcernPageView.this.ox(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ac(boolean z, boolean z2) {
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.ad(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.SK();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jde.cDf()) {
                    ConcernPageView.this.cCW();
                } else {
                    ConcernPageView.this.cCV();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cDb() {
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.ad(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.SK();
                ConcernPageView.this.jdb.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jdl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bJG();
            }
        };
        this.jdm = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jdg = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jdn = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jde.cDc();
                    } else {
                        ConcernPageView.this.jde.cDd();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jdg = false;
        this.mSkinType = 3;
        this.fVW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fVW != i && ConcernPageView.this.jdh != null) {
                    ConcernPageView.this.fVW = i;
                    if (ConcernPageView.this.fVW == 1) {
                        ConcernPageView.this.jdh.bKo();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jdh.bKp();
                    } else {
                        ConcernPageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdi = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cCZ() {
                if (ConcernPageView.this.jdh != null) {
                    ConcernPageView.this.fVW = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jdb)) {
                        ConcernPageView.this.jdh.bKp();
                    } else {
                        ConcernPageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdk = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cDa() {
                ConcernPageView.this.SK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jdb.setSelection(0);
                if (ConcernPageView.this.jdb.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cCW();
                } else {
                    ConcernPageView.this.hn(true);
                }
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void KL(String str) {
                ConcernPageView.this.SK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cCV();
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.KM(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.ad(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jdb.setVisibility(8);
                    ConcernPageView.this.ox(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ac(boolean z, boolean z2) {
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.ad(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.SK();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jde.cDf()) {
                    ConcernPageView.this.cCW();
                } else {
                    ConcernPageView.this.cCV();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cDb() {
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.ad(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.SK();
                ConcernPageView.this.jdb.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jdl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bJG();
            }
        };
        this.jdm = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jdg = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jdn = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jde.cDc();
                    } else {
                        ConcernPageView.this.jde.cDd();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jdg = false;
        this.mSkinType = 3;
        this.fVW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.fVW != i2 && ConcernPageView.this.jdh != null) {
                    ConcernPageView.this.fVW = i2;
                    if (ConcernPageView.this.fVW == 1) {
                        ConcernPageView.this.jdh.bKo();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jdh.bKp();
                    } else {
                        ConcernPageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdi = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cCZ() {
                if (ConcernPageView.this.jdh != null) {
                    ConcernPageView.this.fVW = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jdb)) {
                        ConcernPageView.this.jdh.bKp();
                    } else {
                        ConcernPageView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdk = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cDa() {
                ConcernPageView.this.SK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jdb.setSelection(0);
                if (ConcernPageView.this.jdb.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cCW();
                } else {
                    ConcernPageView.this.hn(true);
                }
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void KL(String str) {
                ConcernPageView.this.SK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cCV();
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.KM(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.ad(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.jdb.setVisibility(8);
                    ConcernPageView.this.ox(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ac(boolean z, boolean z2) {
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.ad(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.SK();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jde.cDf()) {
                    ConcernPageView.this.cCW();
                } else {
                    ConcernPageView.this.cCV();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cDb() {
                if (ConcernPageView.this.jdd != null) {
                    ConcernPageView.this.jdd.ad(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.SK();
                ConcernPageView.this.jdb.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jdl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bJG();
            }
        };
        this.jdm = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jdg = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jdn = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jde.cDc();
                    } else {
                        ConcernPageView.this.jde.cDd();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jdb = new BdTypeRecyclerView(context);
        this.jdb.setLayoutManager(new LinearLayoutManager(context));
        this.jdb.setFadingEdgeLength(0);
        this.jdb.setOverScrollMode(2);
        this.jdj = new BigdaySwipeRefreshLayout(context);
        this.jdj.addView(this.jdb);
        this.fTv = new PbListView(context);
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setLineGone();
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.setOnClickListener(this.jdl);
        this.jdb.setNextPage(this.fTv);
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        addView(this.jdj);
        this.jda = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.jda.setEnable(true);
        this.jdj.setProgressView(this.jda);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.jdj.setCustomDistances(i, i, i * 2);
        this.jdc = new com.baidu.tieba.homepage.concern.a(context, this.jdb);
        this.jde = new d(this.pageContext, this.jdb, this.jdc, this.jdj);
        this.jdj.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bQI() {
        this.jde.a(this.jdk);
        this.jda.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bEz().Er("page_concern");
                    ConcernPageView.this.jde.update();
                }
            }
        });
        this.jdb.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bJG();
            }
        });
        this.jdb.removeOnScrollListener(this.mOnScrollListener);
        this.jdb.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.jdd = aVar;
    }

    public void cCS() {
        if (!TbadkCoreApplication.isLogin()) {
            cCU();
        } else if (this.jde != null) {
            this.jde.update();
            hn(true);
        }
    }

    public void cCT() {
        if (!TbadkCoreApplication.isLogin()) {
            cCU();
        } else if (this.jde != null) {
            this.jde.cDe();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.jde != null) {
            this.jde.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jdf != null) {
                this.jdf.onChangeSkinType(i);
            }
            if (this.gcx != null) {
                this.gcx.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jda != null) {
                this.jda.changeSkin(i);
            }
            if (this.fTv != null) {
                this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.fTv.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.jdc.onChangeSkinType(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jdj, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jdb, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cCX();
    }

    public void aR(String str, int i) {
        this.jde.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.jde.a(z, dataRes, 0, null);
    }

    public void ox(boolean z) {
        if (!chb()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.jde != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.jde.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
            this.gcx = null;
        }
    }

    private boolean chb() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cCU() {
        if (this.jdf == null) {
            this.jdf = new ConcernNotLoginLayout(getContext());
            this.jdf.onChangeSkinType(this.mSkinType);
        }
        if (this.jdf.getParent() == null) {
            this.jdj.setVisibility(8);
            this.jdf.setVisibility(0);
            addView(this.jdf);
        }
    }

    public boolean cha() {
        if (this.gcx != null) {
            return this.gcx.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(boolean z) {
        if (!cha()) {
            if (this.gcx == null) {
                this.gcx = new g(getContext());
                this.gcx.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gcx.bwO();
                this.gcx.setWrapStyle(true);
            }
            this.gcx.onChangeSkinType();
            this.gcx.attachView(this, z);
        }
    }

    public void cCV() {
        this.jdj.setVisibility(0);
        this.jdb.setVisibility(0);
        if (this.jde.hasMore()) {
            this.fTv.startLoadData();
        } else {
            this.fTv.endLoadDataWithNoMore();
        }
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cCW() {
        this.jdj.setVisibility(0);
        this.jdb.setVisibility(0);
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_home_concern_all_status", 0);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dL(null, getContext().getString(R.string.concern_no_data_title)), null);
            this.mNoDataView.setTitleContainerMargin(R.dimen.tbds0, R.dimen.tbds0);
        }
        if (i == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, getContext().getString(R.string.concern_person_no_data_title)));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, getContext().getString(R.string.concern_no_data_title)));
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
        if (this.jde != null) {
            this.jde.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jde != null) {
            this.jde.pe(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jde != null) {
            this.jde.ql(z);
        }
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
            this.jdh.a(this.jdi);
            this.jdi.cCZ();
        }
    }

    public void reload() {
        if (this.jdb != null && this.jdj != null) {
            if (this.jdg && this.jdb.getFirstVisiblePosition() != 0) {
                this.jdg = false;
                return;
            }
            this.jdb.setSelection(0);
            if (!this.jdj.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.jde.update();
                    }
                } else {
                    this.jdj.setRefreshing(true);
                }
            }
            if (!this.jdj.isRefreshing()) {
                this.jdj.setRefreshing(true);
            }
            if (this.jdi != null) {
                this.jdi.cCZ();
            }
        }
    }

    public void onDestroy() {
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
        }
        this.jdb.removeOnScrollListener(this.mOnScrollListener);
        this.jde.a((d.a) null);
        this.jda.setListPullRefreshListener(null);
        this.jda.a((f.d) null);
        this.jdb.setOnSrollToBottomListener(null);
        this.jda.a((f.b) null);
        this.jda.release();
        this.jdb.setRecyclerListener(null);
    }

    public void cCX() {
        if (this.jdc != null) {
            this.jdc.notifyDataSetChanged();
        }
    }

    public void cCY() {
        if (this.jde != null) {
            this.jde.pe(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        if (this.jde != null) {
            this.jde.bJG();
        }
    }

    public void FS() {
        if (this.jdc != null) {
            List<q> dataList = this.jdc.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof com.baidu.tieba.card.data.l) {
                        com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                        if (lVar.epi != 0 && lVar.eji != null) {
                            int[] imageWidthAndHeight = lVar.eji.getImageWidthAndHeight();
                            lVar.epi = imageWidthAndHeight[0];
                            lVar.epj = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.jdc != null) {
                            ConcernPageView.this.jdc.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
