package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernPageView extends FrameLayout {
    private g gGD;
    private PbListView gxy;
    private int gzZ;
    private PublishProgressView jFY;
    private final CustomMessageListener jGi;
    private View.OnClickListener jSA;
    private CustomMessageListener jSB;
    private CustomMessageListener jSC;
    private com.baidu.tieba.homepage.personalize.bigday.a jSp;
    private BdTypeRecyclerView jSq;
    private com.baidu.tieba.homepage.concern.a jSr;
    private a jSs;
    private d jSt;
    private ConcernNotLoginLayout jSu;
    private boolean jSv;
    private ScrollFragmentTabHost jSw;
    ScrollFragmentTabHost.a jSx;
    private BigdaySwipeRefreshLayout jSy;
    private d.a jSz;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void Lb(String str);

        void ai(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jSw = scrollFragmentTabHost;
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
            this.jSw.a(this.jSx);
        }
    }

    public void completePullRefresh() {
        if (this.jSy != null) {
            this.jSy.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jSr != null) {
            this.jSr.setPageUniqueId(bdUniqueId);
        }
        if (this.jSt != null) {
            this.jSt.s(bdUniqueId);
        }
        if (this.jSp != null) {
            this.jSp.setTag(bdUniqueId);
        }
        if (this.jSB != null) {
            this.jSB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jSB);
        }
        MessageManager.getInstance().registerListener(this.jSC);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.jSv = false;
        this.mSkinType = 3;
        this.gzZ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gzZ != i && ConcernPageView.this.jSw != null) {
                    ConcernPageView.this.gzZ = i;
                    if (ConcernPageView.this.gzZ == 1) {
                        ConcernPageView.this.jSw.bRg();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.jSw.bRh();
                    } else {
                        ConcernPageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSx = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cMR() {
                if (ConcernPageView.this.jSw != null) {
                    ConcernPageView.this.gzZ = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.jSq)) {
                        ConcernPageView.this.jSw.bRh();
                    } else {
                        ConcernPageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSz = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cMS() {
                ConcernPageView.this.Vq();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jSq.setSelection(0);
                if (ConcernPageView.this.jSq.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cMO();
                } else {
                    ConcernPageView.this.ip(true);
                }
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void La(String str) {
                ConcernPageView.this.Vq();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cMN();
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.Lb(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jSq.setVisibility(8);
                    ConcernPageView.this.pQ(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Vq();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jSt.cMX()) {
                    ConcernPageView.this.cMO();
                } else {
                    ConcernPageView.this.cMN();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cMT() {
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Vq();
                ConcernPageView.this.jSq.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jSA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bQy();
            }
        };
        this.jSB = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jSv = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jSC = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jSt.cMU();
                    } else {
                        ConcernPageView.this.jSt.cMV();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        this.jGi = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (ConcernPageView.this.jFY != null) {
                        ConcernPageView.this.jFY.b(bgVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jSv = false;
        this.mSkinType = 3;
        this.gzZ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gzZ != i && ConcernPageView.this.jSw != null) {
                    ConcernPageView.this.gzZ = i;
                    if (ConcernPageView.this.gzZ == 1) {
                        ConcernPageView.this.jSw.bRg();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.jSw.bRh();
                    } else {
                        ConcernPageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSx = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cMR() {
                if (ConcernPageView.this.jSw != null) {
                    ConcernPageView.this.gzZ = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.jSq)) {
                        ConcernPageView.this.jSw.bRh();
                    } else {
                        ConcernPageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSz = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cMS() {
                ConcernPageView.this.Vq();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jSq.setSelection(0);
                if (ConcernPageView.this.jSq.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cMO();
                } else {
                    ConcernPageView.this.ip(true);
                }
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void La(String str) {
                ConcernPageView.this.Vq();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cMN();
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.Lb(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jSq.setVisibility(8);
                    ConcernPageView.this.pQ(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Vq();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jSt.cMX()) {
                    ConcernPageView.this.cMO();
                } else {
                    ConcernPageView.this.cMN();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cMT() {
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Vq();
                ConcernPageView.this.jSq.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jSA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bQy();
            }
        };
        this.jSB = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jSv = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jSC = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jSt.cMU();
                    } else {
                        ConcernPageView.this.jSt.cMV();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        this.jGi = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (ConcernPageView.this.jFY != null) {
                        ConcernPageView.this.jFY.b(bgVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jSv = false;
        this.mSkinType = 3;
        this.gzZ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.gzZ != i2 && ConcernPageView.this.jSw != null) {
                    ConcernPageView.this.gzZ = i2;
                    if (ConcernPageView.this.gzZ == 1) {
                        ConcernPageView.this.jSw.bRg();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.jSw.bRh();
                    } else {
                        ConcernPageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSx = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cMR() {
                if (ConcernPageView.this.jSw != null) {
                    ConcernPageView.this.gzZ = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.jSq)) {
                        ConcernPageView.this.jSw.bRh();
                    } else {
                        ConcernPageView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSz = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cMS() {
                ConcernPageView.this.Vq();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jSq.setSelection(0);
                if (ConcernPageView.this.jSq.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cMO();
                } else {
                    ConcernPageView.this.ip(true);
                }
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void La(String str) {
                ConcernPageView.this.Vq();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cMN();
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.Lb(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.jSq.setVisibility(8);
                    ConcernPageView.this.pQ(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Vq();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jSt.cMX()) {
                    ConcernPageView.this.cMO();
                } else {
                    ConcernPageView.this.cMN();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cMT() {
                if (ConcernPageView.this.jSs != null) {
                    ConcernPageView.this.jSs.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Vq();
                ConcernPageView.this.jSq.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jSA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bQy();
            }
        };
        this.jSB = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jSv = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jSC = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jSt.cMU();
                    } else {
                        ConcernPageView.this.jSt.cMV();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        this.jGi = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (ConcernPageView.this.jFY != null) {
                        ConcernPageView.this.jFY.b(bgVar);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jSq = new BdTypeRecyclerView(context);
        this.jSq.setLayoutManager(new LinearLayoutManager(context));
        this.jSq.setFadingEdgeLength(0);
        this.jSq.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jSq.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jSy = new BigdaySwipeRefreshLayout(context);
        this.jSy.addView(this.jSq);
        this.gxy = new PbListView(context);
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.transparent);
        this.gxy.setLineGone();
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.setOnClickListener(this.jSA);
        this.jSq.setNextPage(this.gxy);
        f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        addView(this.jSy);
        this.jSp = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.jSp.setEnable(true);
        this.jSy.setProgressView(this.jSp);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.jSy.setCustomDistances(i, i, i * 2);
        this.jSr = new com.baidu.tieba.homepage.concern.a(context, this.jSq);
        this.jSt = new d(this.pageContext, this.jSq, this.jSr, this.jSy);
        this.jSy.setVisibility(8);
        this.jFY = new PublishProgressView(context);
        addView(this.jFY, new FrameLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds83)));
        this.jFY.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bYg() {
        this.jSt.a(this.jSz);
        this.jSp.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bKv().DZ("page_concern");
                    ConcernPageView.this.jSt.update();
                }
            }
        });
        this.jSq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bQy();
            }
        });
        this.jSq.removeOnScrollListener(this.mOnScrollListener);
        this.jSq.addOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().registerListener(this.jGi);
    }

    public void setCallback(a aVar) {
        this.jSs = aVar;
    }

    public void cMK() {
        if (!TbadkCoreApplication.isLogin()) {
            cMM();
        } else if (this.jSt != null) {
            this.jSt.update();
            ip(true);
        }
    }

    public void cML() {
        if (!TbadkCoreApplication.isLogin()) {
            cMM();
        } else if (this.jSt != null) {
            this.jSt.cMW();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
        if (this.jSt != null) {
            this.jSt.setRecommendFrsNavigationAnimDispatcher(yVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jSu != null) {
                this.jSu.onChangeSkinType(i);
            }
            if (this.gGD != null) {
                this.gGD.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jSp != null) {
                this.jSp.changeSkin(i);
            }
            if (this.gxy != null) {
                this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
                this.gxy.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            }
            if (this.jFY != null) {
                this.jFY.onChangeSkinType();
            }
            this.jSr.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cMP();
    }

    public void bd(String str, int i) {
        this.jSt.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.jSt.a(z, dataRes, 0, null);
    }

    public void aB(bz bzVar) {
        hideNoDataView();
        this.jSt.aB(bzVar);
    }

    public void pQ(boolean z) {
        if (!cpC()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.jSt != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.jSt.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
    }

    private boolean cpC() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cMM() {
        if (this.jSu == null) {
            this.jSu = new ConcernNotLoginLayout(getContext());
            this.jSu.onChangeSkinType(this.mSkinType);
        }
        if (this.jSu.getParent() == null) {
            this.jSy.setVisibility(8);
            this.jSu.setVisibility(0);
            addView(this.jSu);
        }
    }

    public boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ip(boolean z) {
        if (!cpB()) {
            if (this.gGD == null) {
                this.gGD = new g(getContext());
                this.gGD.bt(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gGD.bCA();
                this.gGD.setWrapStyle(true);
            }
            this.gGD.onChangeSkinType();
            this.gGD.attachView(this, z);
        }
    }

    public void cMN() {
        this.jSy.setVisibility(0);
        this.jSq.setVisibility(0);
        if (this.jSt.hasMore()) {
            this.gxy.startLoadData();
        } else {
            this.gxy.endLoadDataWithNoMore();
        }
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cMO() {
        this.jSy.setVisibility(0);
        this.jSq.setVisibility(0);
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_home_concern_all_status", 0);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dX(null, getContext().getString(R.string.concern_no_data_title)), null);
        }
        if (i == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getContext().getString(R.string.concern_person_no_data_title)));
            this.mNoDataView.setImgOption(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getContext().getString(R.string.concern_no_data_title)));
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
        if (this.jSt != null) {
            this.jSt.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jSt != null) {
            this.jSt.qz(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jSt != null) {
            this.jSt.rJ(z);
        }
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
            this.jSw.a(this.jSx);
            this.jSx.cMR();
        }
    }

    public void reload() {
        if (this.jSq != null && this.jSy != null) {
            if (this.jSv && this.jSq.getFirstVisiblePosition() != 0) {
                this.jSv = false;
                return;
            }
            this.jSq.setSelection(0);
            if (!this.jSy.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.jSt.update();
                    }
                } else {
                    this.jSy.setRefreshing(true);
                }
            }
            if (!this.jSy.isRefreshing()) {
                this.jSy.setRefreshing(true);
            }
            if (this.jSx != null) {
                this.jSx.cMR();
            }
        }
    }

    public void onDestroy() {
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
        }
        this.jSq.removeOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().unRegisterListener(this.jGi);
        this.jSt.a((d.a) null);
        this.jSp.setListPullRefreshListener(null);
        this.jSp.a((f.d) null);
        this.jSq.setOnSrollToBottomListener(null);
        this.jSp.a((f.b) null);
        this.jSp.release();
        this.jSq.setRecyclerListener(null);
        this.jSt.onDestroy();
    }

    public void cMP() {
        if (this.jSr != null) {
            this.jSr.notifyDataSetChanged();
        }
    }

    public void cMQ() {
        if (this.jSt != null) {
            this.jSt.qz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQy() {
        if (this.jSt != null) {
            this.jSt.bQy();
        }
    }

    public void Du() {
        if (this.jSr != null) {
            List<n> dataList = this.jSr.getDataList();
            if (!x.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof k) {
                        k kVar = (k) nVar;
                        if (kVar.eNX != 0 && kVar.eHK != null) {
                            int[] imageWidthAndHeight = kVar.eHK.getImageWidthAndHeight();
                            kVar.eNX = imageWidthAndHeight[0];
                            kVar.eNY = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.jSr != null) {
                            ConcernPageView.this.jSr.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
