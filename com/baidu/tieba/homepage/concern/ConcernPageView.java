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
/* loaded from: classes21.dex */
public class ConcernPageView extends FrameLayout {
    private PbListView fHm;
    private int fJF;
    private g fQf;
    private com.baidu.tieba.homepage.personalize.bigday.a iOi;
    private BdTypeRecyclerView iOj;
    private com.baidu.tieba.homepage.concern.a iOk;
    private a iOl;
    private d iOm;
    private ConcernNotLoginLayout iOn;
    private boolean iOo;
    private ScrollFragmentTabHost iOp;
    ScrollFragmentTabHost.a iOq;
    private BigdaySwipeRefreshLayout iOr;
    private d.a iOs;
    private View.OnClickListener iOt;
    private CustomMessageListener iOu;
    private CustomMessageListener iOv;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes21.dex */
    public interface a {
        void JZ(String str);

        void ae(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iOp = scrollFragmentTabHost;
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
            this.iOp.a(this.iOq);
        }
    }

    public void completePullRefresh() {
        if (this.iOr != null) {
            this.iOr.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iOk != null) {
            this.iOk.setPageUniqueId(bdUniqueId);
        }
        if (this.iOm != null) {
            this.iOm.s(bdUniqueId);
        }
        if (this.iOi != null) {
            this.iOi.setTag(bdUniqueId);
        }
        if (this.iOu != null) {
            this.iOu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iOu);
        }
        MessageManager.getInstance().registerListener(this.iOv);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.iOo = false;
        this.mSkinType = 3;
        this.fJF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fJF != i && ConcernPageView.this.iOp != null) {
                    ConcernPageView.this.fJF = i;
                    if (ConcernPageView.this.fJF == 1) {
                        ConcernPageView.this.iOp.bHC();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.iOp.bHD();
                    } else {
                        ConcernPageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOq = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void czC() {
                if (ConcernPageView.this.iOp != null) {
                    ConcernPageView.this.fJF = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.iOj)) {
                        ConcernPageView.this.iOp.bHD();
                    } else {
                        ConcernPageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOs = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void czD() {
                ConcernPageView.this.bHn();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.iOj.setSelection(0);
                if (ConcernPageView.this.iOj.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.czz();
                } else {
                    ConcernPageView.this.gR(true);
                }
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void JY(String str) {
                ConcernPageView.this.bHn();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.czy();
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.JZ(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.ae(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.iOj.setVisibility(8);
                    ConcernPageView.this.nS(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ad(boolean z, boolean z2) {
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.ae(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bHn();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.iOm.czG()) {
                    ConcernPageView.this.czz();
                } else {
                    ConcernPageView.this.czy();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void czE() {
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.ae(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bHn();
                ConcernPageView.this.iOj.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iOt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bGU();
            }
        };
        this.iOu = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.iOo = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.iOv = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ConcernPageView.this.mNoDataView != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                        ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                    } else {
                        ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iOo = false;
        this.mSkinType = 3;
        this.fJF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fJF != i && ConcernPageView.this.iOp != null) {
                    ConcernPageView.this.fJF = i;
                    if (ConcernPageView.this.fJF == 1) {
                        ConcernPageView.this.iOp.bHC();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.iOp.bHD();
                    } else {
                        ConcernPageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOq = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void czC() {
                if (ConcernPageView.this.iOp != null) {
                    ConcernPageView.this.fJF = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.iOj)) {
                        ConcernPageView.this.iOp.bHD();
                    } else {
                        ConcernPageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOs = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void czD() {
                ConcernPageView.this.bHn();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.iOj.setSelection(0);
                if (ConcernPageView.this.iOj.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.czz();
                } else {
                    ConcernPageView.this.gR(true);
                }
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void JY(String str) {
                ConcernPageView.this.bHn();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.czy();
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.JZ(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.ae(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.iOj.setVisibility(8);
                    ConcernPageView.this.nS(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ad(boolean z, boolean z2) {
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.ae(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bHn();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.iOm.czG()) {
                    ConcernPageView.this.czz();
                } else {
                    ConcernPageView.this.czy();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void czE() {
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.ae(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bHn();
                ConcernPageView.this.iOj.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iOt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bGU();
            }
        };
        this.iOu = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.iOo = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.iOv = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ConcernPageView.this.mNoDataView != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                        ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                    } else {
                        ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iOo = false;
        this.mSkinType = 3;
        this.fJF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.fJF != i2 && ConcernPageView.this.iOp != null) {
                    ConcernPageView.this.fJF = i2;
                    if (ConcernPageView.this.fJF == 1) {
                        ConcernPageView.this.iOp.bHC();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.iOp.bHD();
                    } else {
                        ConcernPageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOq = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void czC() {
                if (ConcernPageView.this.iOp != null) {
                    ConcernPageView.this.fJF = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.iOj)) {
                        ConcernPageView.this.iOp.bHD();
                    } else {
                        ConcernPageView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOs = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void czD() {
                ConcernPageView.this.bHn();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.iOj.setSelection(0);
                if (ConcernPageView.this.iOj.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.czz();
                } else {
                    ConcernPageView.this.gR(true);
                }
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void JY(String str) {
                ConcernPageView.this.bHn();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.czy();
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.JZ(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.ae(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.iOj.setVisibility(8);
                    ConcernPageView.this.nS(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ad(boolean z, boolean z2) {
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.ae(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bHn();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.iOm.czG()) {
                    ConcernPageView.this.czz();
                } else {
                    ConcernPageView.this.czy();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void czE() {
                if (ConcernPageView.this.iOl != null) {
                    ConcernPageView.this.iOl.ae(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bHn();
                ConcernPageView.this.iOj.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iOt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bGU();
            }
        };
        this.iOu = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.iOo = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.iOv = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ConcernPageView.this.mNoDataView != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                        ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                    } else {
                        ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.iOj = new BdTypeRecyclerView(context);
        this.iOj.setLayoutManager(new LinearLayoutManager(context));
        this.iOj.setFadingEdgeLength(0);
        this.iOj.setOverScrollMode(2);
        this.iOr = new BigdaySwipeRefreshLayout(context);
        this.iOr.addView(this.iOj);
        this.fHm = new PbListView(context);
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setLineGone();
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.setOnClickListener(this.iOt);
        this.iOj.setNextPage(this.fHm);
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        addView(this.iOr);
        this.iOi = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.iOi.setEnable(true);
        this.iOr.setProgressView(this.iOi);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.iOr.setCustomDistances(i, i, i * 2);
        this.iOk = new com.baidu.tieba.homepage.concern.a(context, this.iOj);
        this.iOm = new d(this.pageContext, this.iOj, this.iOk, this.iOr);
        this.iOr.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bNr() {
        this.iOm.a(this.iOs);
        this.iOi.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bBN().DG("page_concern");
                    ConcernPageView.this.iOm.update();
                }
            }
        });
        this.iOj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bGU();
            }
        });
        this.iOj.removeOnScrollListener(this.mOnScrollListener);
        this.iOj.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.iOl = aVar;
    }

    public void czv() {
        if (!TbadkCoreApplication.isLogin()) {
            czx();
        } else if (this.iOm != null) {
            this.iOm.update();
            gR(true);
        }
    }

    public void czw() {
        if (!TbadkCoreApplication.isLogin()) {
            czx();
        } else if (this.iOm != null) {
            this.iOm.czF();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.iOm != null) {
            this.iOm.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iOn != null) {
                this.iOn.onChangeSkinType(i);
            }
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.iOi != null) {
                this.iOi.changeSkin(i);
            }
            if (this.fHm != null) {
                this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.fHm.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.iOk.onChangeSkinType(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.iOr, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.iOj, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        czA();
    }

    public void aQ(String str, int i) {
        this.iOm.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.iOm.a(z, dataRes, 0, null);
    }

    public void nS(boolean z) {
        if (!cdF()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.iOm != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.iOm.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHn() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
        }
    }

    private boolean cdF() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void czx() {
        if (this.iOn == null) {
            this.iOn = new ConcernNotLoginLayout(getContext());
            this.iOn.onChangeSkinType(this.mSkinType);
        }
        if (this.iOn.getParent() == null) {
            this.iOr.setVisibility(8);
            this.iOn.setVisibility(0);
            addView(this.iOn);
        }
    }

    public boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(getContext());
                this.fQf.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.fQf.bue();
                this.fQf.setWrapStyle(true);
            }
            this.fQf.onChangeSkinType();
            this.fQf.attachView(this, z);
        }
    }

    public void czy() {
        this.iOr.setVisibility(0);
        this.iOj.setVisibility(0);
        if (this.iOm.hasMore()) {
            this.fHm.startLoadData();
        } else {
            this.fHm.endLoadDataWithNoMore();
        }
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void czz() {
        this.iOr.setVisibility(0);
        this.iOj.setVisibility(0);
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_home_concern_all_status", 0);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dG(null, getContext().getString(R.string.concern_no_data_title)), null);
            this.mNoDataView.setTitleContainerMargin(R.dimen.tbds0, R.dimen.tbds0);
        }
        if (i == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getContext().getString(R.string.concern_person_no_data_title)));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getContext().getString(R.string.concern_no_data_title)));
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
        if (this.iOm != null) {
            this.iOm.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.iOm != null) {
            this.iOm.oz(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.iOm != null) {
            this.iOm.pG(z);
        }
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
            this.iOp.a(this.iOq);
            this.iOq.czC();
        }
    }

    public void reload() {
        if (this.iOj != null && this.iOr != null) {
            if (this.iOo && this.iOj.getFirstVisiblePosition() != 0) {
                this.iOo = false;
                return;
            }
            this.iOj.setSelection(0);
            if (!this.iOr.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.iOm.update();
                    }
                } else {
                    this.iOr.setRefreshing(true);
                }
            }
            if (!this.iOr.isRefreshing()) {
                this.iOr.setRefreshing(true);
            }
            if (this.iOq != null) {
                this.iOq.czC();
            }
        }
    }

    public void onDestroy() {
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
        }
        this.iOj.removeOnScrollListener(this.mOnScrollListener);
        this.iOm.a((d.a) null);
        this.iOi.setListPullRefreshListener(null);
        this.iOi.a((f.d) null);
        this.iOj.setOnSrollToBottomListener(null);
        this.iOi.a((f.b) null);
        this.iOi.release();
        this.iOj.setRecyclerListener(null);
    }

    public void czA() {
        if (this.iOk != null) {
            this.iOk.notifyDataSetChanged();
        }
    }

    public void czB() {
        if (this.iOm != null) {
            this.iOm.oz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGU() {
        if (this.iOm != null) {
            this.iOm.bGU();
        }
    }

    public void EW() {
        if (this.iOk != null) {
            List<q> dataList = this.iOk.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof com.baidu.tieba.card.data.l) {
                        com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                        if (lVar.edd != 0 && lVar.dXg != null) {
                            int[] imageWidthAndHeight = lVar.dXg.getImageWidthAndHeight();
                            lVar.edd = imageWidthAndHeight[0];
                            lVar.ede = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.iOk != null) {
                            ConcernPageView.this.iOk.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
