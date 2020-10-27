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
    private PbListView gdy;
    private int gga;
    private g gmB;
    private d jpA;
    private ConcernNotLoginLayout jpB;
    private boolean jpC;
    private ScrollFragmentTabHost jpD;
    ScrollFragmentTabHost.a jpE;
    private BigdaySwipeRefreshLayout jpF;
    private d.a jpG;
    private View.OnClickListener jpH;
    private CustomMessageListener jpI;
    private CustomMessageListener jpJ;
    private com.baidu.tieba.homepage.personalize.bigday.a jpw;
    private BdTypeRecyclerView jpx;
    private com.baidu.tieba.homepage.concern.a jpy;
    private a jpz;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes22.dex */
    public interface a {
        void Lk(String str);

        void ag(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jpD = scrollFragmentTabHost;
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
            this.jpD.a(this.jpE);
        }
    }

    public void completePullRefresh() {
        if (this.jpF != null) {
            this.jpF.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jpy != null) {
            this.jpy.setPageUniqueId(bdUniqueId);
        }
        if (this.jpA != null) {
            this.jpA.s(bdUniqueId);
        }
        if (this.jpw != null) {
            this.jpw.setTag(bdUniqueId);
        }
        if (this.jpI != null) {
            this.jpI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jpI);
        }
        MessageManager.getInstance().registerListener(this.jpJ);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.jpC = false;
        this.mSkinType = 3;
        this.gga = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gga != i && ConcernPageView.this.jpD != null) {
                    ConcernPageView.this.gga = i;
                    if (ConcernPageView.this.gga == 1) {
                        ConcernPageView.this.jpD.bMQ();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jpD.bMR();
                    } else {
                        ConcernPageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpE = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cGg() {
                if (ConcernPageView.this.jpD != null) {
                    ConcernPageView.this.gga = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jpx)) {
                        ConcernPageView.this.jpD.bMR();
                    } else {
                        ConcernPageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpG = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cGh() {
                ConcernPageView.this.TK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jpx.setSelection(0);
                if (ConcernPageView.this.jpx.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cGd();
                } else {
                    ConcernPageView.this.hA(true);
                }
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Lj(String str) {
                ConcernPageView.this.TK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cGc();
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.Lk(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jpx.setVisibility(8);
                    ConcernPageView.this.oP(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.TK();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jpA.cGm()) {
                    ConcernPageView.this.cGd();
                } else {
                    ConcernPageView.this.cGc();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cGi() {
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.TK();
                ConcernPageView.this.jpx.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jpH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bMi();
            }
        };
        this.jpI = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jpC = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jpJ = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jpA.cGj();
                    } else {
                        ConcernPageView.this.jpA.cGk();
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
        this.jpC = false;
        this.mSkinType = 3;
        this.gga = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gga != i && ConcernPageView.this.jpD != null) {
                    ConcernPageView.this.gga = i;
                    if (ConcernPageView.this.gga == 1) {
                        ConcernPageView.this.jpD.bMQ();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jpD.bMR();
                    } else {
                        ConcernPageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpE = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cGg() {
                if (ConcernPageView.this.jpD != null) {
                    ConcernPageView.this.gga = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jpx)) {
                        ConcernPageView.this.jpD.bMR();
                    } else {
                        ConcernPageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpG = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cGh() {
                ConcernPageView.this.TK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jpx.setSelection(0);
                if (ConcernPageView.this.jpx.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cGd();
                } else {
                    ConcernPageView.this.hA(true);
                }
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Lj(String str) {
                ConcernPageView.this.TK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cGc();
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.Lk(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jpx.setVisibility(8);
                    ConcernPageView.this.oP(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.TK();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jpA.cGm()) {
                    ConcernPageView.this.cGd();
                } else {
                    ConcernPageView.this.cGc();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cGi() {
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.TK();
                ConcernPageView.this.jpx.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jpH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bMi();
            }
        };
        this.jpI = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jpC = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jpJ = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jpA.cGj();
                    } else {
                        ConcernPageView.this.jpA.cGk();
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
        this.jpC = false;
        this.mSkinType = 3;
        this.gga = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.gga != i2 && ConcernPageView.this.jpD != null) {
                    ConcernPageView.this.gga = i2;
                    if (ConcernPageView.this.gga == 1) {
                        ConcernPageView.this.jpD.bMQ();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jpD.bMR();
                    } else {
                        ConcernPageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpE = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cGg() {
                if (ConcernPageView.this.jpD != null) {
                    ConcernPageView.this.gga = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jpx)) {
                        ConcernPageView.this.jpD.bMR();
                    } else {
                        ConcernPageView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpG = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cGh() {
                ConcernPageView.this.TK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jpx.setSelection(0);
                if (ConcernPageView.this.jpx.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cGd();
                } else {
                    ConcernPageView.this.hA(true);
                }
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Lj(String str) {
                ConcernPageView.this.TK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cGc();
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.Lk(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.jpx.setVisibility(8);
                    ConcernPageView.this.oP(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.TK();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jpA.cGm()) {
                    ConcernPageView.this.cGd();
                } else {
                    ConcernPageView.this.cGc();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cGi() {
                if (ConcernPageView.this.jpz != null) {
                    ConcernPageView.this.jpz.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.TK();
                ConcernPageView.this.jpx.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jpH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bMi();
            }
        };
        this.jpI = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jpC = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jpJ = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jpA.cGj();
                    } else {
                        ConcernPageView.this.jpA.cGk();
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
        this.jpx = new BdTypeRecyclerView(context);
        this.jpx.setLayoutManager(new LinearLayoutManager(context));
        this.jpx.setFadingEdgeLength(0);
        this.jpx.setOverScrollMode(2);
        this.jpF = new BigdaySwipeRefreshLayout(context);
        this.jpF.addView(this.jpx);
        this.gdy = new PbListView(context);
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setLineGone();
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.setOnClickListener(this.jpH);
        this.jpx.setNextPage(this.gdy);
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        addView(this.jpF);
        this.jpw = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.jpw.setEnable(true);
        this.jpF.setProgressView(this.jpw);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.jpF.setCustomDistances(i, i, i * 2);
        this.jpy = new com.baidu.tieba.homepage.concern.a(context, this.jpx);
        this.jpA = new d(this.pageContext, this.jpx, this.jpy, this.jpF);
        this.jpF.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bTF() {
        this.jpA.a(this.jpG);
        this.jpw.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bGs().EK("page_concern");
                    ConcernPageView.this.jpA.update();
                }
            }
        });
        this.jpx.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bMi();
            }
        });
        this.jpx.removeOnScrollListener(this.mOnScrollListener);
        this.jpx.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.jpz = aVar;
    }

    public void cFZ() {
        if (!TbadkCoreApplication.isLogin()) {
            cGb();
        } else if (this.jpA != null) {
            this.jpA.update();
            hA(true);
        }
    }

    public void cGa() {
        if (!TbadkCoreApplication.isLogin()) {
            cGb();
        } else if (this.jpA != null) {
            this.jpA.cGl();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.jpA != null) {
            this.jpA.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jpB != null) {
                this.jpB.onChangeSkinType(i);
            }
            if (this.gmB != null) {
                this.gmB.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jpw != null) {
                this.jpw.changeSkin(i);
            }
            if (this.gdy != null) {
                this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.gdy.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.jpy.onChangeSkinType(i);
            ap.setBackgroundColor(this, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.jpF, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jpx, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cGe();
    }

    public void aS(String str, int i) {
        this.jpA.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.jpA.a(z, dataRes, 0, null);
    }

    public void oP(boolean z) {
        if (!cki()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.jpA != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.jpA.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this);
            this.gmB = null;
        }
    }

    private boolean cki() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cGb() {
        if (this.jpB == null) {
            this.jpB = new ConcernNotLoginLayout(getContext());
            this.jpB.onChangeSkinType(this.mSkinType);
        }
        if (this.jpB.getParent() == null) {
            this.jpF.setVisibility(8);
            this.jpB.setVisibility(0);
            addView(this.jpB);
        }
    }

    public boolean ckh() {
        if (this.gmB != null) {
            return this.gmB.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hA(boolean z) {
        if (!ckh()) {
            if (this.gmB == null) {
                this.gmB = new g(getContext());
                this.gmB.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gmB.byH();
                this.gmB.setWrapStyle(true);
            }
            this.gmB.onChangeSkinType();
            this.gmB.attachView(this, z);
        }
    }

    public void cGc() {
        this.jpF.setVisibility(0);
        this.jpx.setVisibility(0);
        if (this.jpA.hasMore()) {
            this.gdy.startLoadData();
        } else {
            this.gdy.endLoadDataWithNoMore();
        }
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cGd() {
        this.jpF.setVisibility(0);
        this.jpx.setVisibility(0);
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_home_concern_all_status", 0);
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
        if (this.jpA != null) {
            this.jpA.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jpA != null) {
            this.jpA.pw(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jpA != null) {
            this.jpA.qD(z);
        }
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
            this.jpD.a(this.jpE);
            this.jpE.cGg();
        }
    }

    public void reload() {
        if (this.jpx != null && this.jpF != null) {
            if (this.jpC && this.jpx.getFirstVisiblePosition() != 0) {
                this.jpC = false;
                return;
            }
            this.jpx.setSelection(0);
            if (!this.jpF.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.jpA.update();
                    }
                } else {
                    this.jpF.setRefreshing(true);
                }
            }
            if (!this.jpF.isRefreshing()) {
                this.jpF.setRefreshing(true);
            }
            if (this.jpE != null) {
                this.jpE.cGg();
            }
        }
    }

    public void onDestroy() {
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
        }
        this.jpx.removeOnScrollListener(this.mOnScrollListener);
        this.jpA.a((d.a) null);
        this.jpw.setListPullRefreshListener(null);
        this.jpw.a((f.d) null);
        this.jpx.setOnSrollToBottomListener(null);
        this.jpw.a((f.b) null);
        this.jpw.release();
        this.jpx.setRecyclerListener(null);
    }

    public void cGe() {
        if (this.jpy != null) {
            this.jpy.notifyDataSetChanged();
        }
    }

    public void cGf() {
        if (this.jpA != null) {
            this.jpA.pw(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMi() {
        if (this.jpA != null) {
            this.jpA.bMi();
        }
    }

    public void Gh() {
        if (this.jpy != null) {
            List<q> dataList = this.jpy.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof com.baidu.tieba.card.data.l) {
                        com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                        if (lVar.exG != 0 && lVar.erH != null) {
                            int[] imageWidthAndHeight = lVar.erH.getImageWidthAndHeight();
                            lVar.exG = imageWidthAndHeight[0];
                            lVar.exH = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.jpy != null) {
                            ConcernPageView.this.jpy.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
