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
    private PbListView gCf;
    private int gEG;
    private g gLj;
    private PublishProgressView jKE;
    private final CustomMessageListener jKO;
    private com.baidu.tieba.homepage.personalize.bigday.a jWU;
    private BdTypeRecyclerView jWV;
    private com.baidu.tieba.homepage.concern.a jWW;
    private a jWX;
    private d jWY;
    private ConcernNotLoginLayout jWZ;
    private boolean jXa;
    private ScrollFragmentTabHost jXb;
    ScrollFragmentTabHost.a jXc;
    private BigdaySwipeRefreshLayout jXd;
    private d.a jXe;
    private View.OnClickListener jXf;
    private CustomMessageListener jXg;
    private CustomMessageListener jXh;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void Mj(String str);

        void ai(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jXb = scrollFragmentTabHost;
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
            this.jXb.a(this.jXc);
        }
    }

    public void completePullRefresh() {
        if (this.jXd != null) {
            this.jXd.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jWW != null) {
            this.jWW.setPageUniqueId(bdUniqueId);
        }
        if (this.jWY != null) {
            this.jWY.s(bdUniqueId);
        }
        if (this.jWU != null) {
            this.jWU.setTag(bdUniqueId);
        }
        if (this.jXg != null) {
            this.jXg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jXg);
        }
        MessageManager.getInstance().registerListener(this.jXh);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.jXa = false;
        this.mSkinType = 3;
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gEG != i && ConcernPageView.this.jXb != null) {
                    ConcernPageView.this.gEG = i;
                    if (ConcernPageView.this.gEG == 1) {
                        ConcernPageView.this.jXb.bUX();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.jXb.bUY();
                    } else {
                        ConcernPageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.jXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cQI() {
                if (ConcernPageView.this.jXb != null) {
                    ConcernPageView.this.gEG = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.jWV)) {
                        ConcernPageView.this.jXb.bUY();
                    } else {
                        ConcernPageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.jXe = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cQJ() {
                ConcernPageView.this.Zi();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jWV.setSelection(0);
                if (ConcernPageView.this.jWV.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cQF();
                } else {
                    ConcernPageView.this.it(true);
                }
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Mi(String str) {
                ConcernPageView.this.Zi();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cQE();
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.Mj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jWV.setVisibility(8);
                    ConcernPageView.this.pU(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Zi();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jWY.cQO()) {
                    ConcernPageView.this.cQF();
                } else {
                    ConcernPageView.this.cQE();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cQK() {
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Zi();
                ConcernPageView.this.jWV.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bUp();
            }
        };
        this.jXg = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jXa = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jXh = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jWY.cQL();
                    } else {
                        ConcernPageView.this.jWY.cQM();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        this.jKO = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (ConcernPageView.this.jKE != null) {
                        ConcernPageView.this.jKE.b(bgVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jXa = false;
        this.mSkinType = 3;
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gEG != i && ConcernPageView.this.jXb != null) {
                    ConcernPageView.this.gEG = i;
                    if (ConcernPageView.this.gEG == 1) {
                        ConcernPageView.this.jXb.bUX();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.jXb.bUY();
                    } else {
                        ConcernPageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.jXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cQI() {
                if (ConcernPageView.this.jXb != null) {
                    ConcernPageView.this.gEG = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.jWV)) {
                        ConcernPageView.this.jXb.bUY();
                    } else {
                        ConcernPageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.jXe = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cQJ() {
                ConcernPageView.this.Zi();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jWV.setSelection(0);
                if (ConcernPageView.this.jWV.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cQF();
                } else {
                    ConcernPageView.this.it(true);
                }
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Mi(String str) {
                ConcernPageView.this.Zi();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cQE();
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.Mj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jWV.setVisibility(8);
                    ConcernPageView.this.pU(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Zi();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jWY.cQO()) {
                    ConcernPageView.this.cQF();
                } else {
                    ConcernPageView.this.cQE();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cQK() {
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Zi();
                ConcernPageView.this.jWV.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bUp();
            }
        };
        this.jXg = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jXa = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jXh = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jWY.cQL();
                    } else {
                        ConcernPageView.this.jWY.cQM();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        this.jKO = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (ConcernPageView.this.jKE != null) {
                        ConcernPageView.this.jKE.b(bgVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jXa = false;
        this.mSkinType = 3;
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.gEG != i2 && ConcernPageView.this.jXb != null) {
                    ConcernPageView.this.gEG = i2;
                    if (ConcernPageView.this.gEG == 1) {
                        ConcernPageView.this.jXb.bUX();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.jXb.bUY();
                    } else {
                        ConcernPageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.jXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cQI() {
                if (ConcernPageView.this.jXb != null) {
                    ConcernPageView.this.gEG = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.jWV)) {
                        ConcernPageView.this.jXb.bUY();
                    } else {
                        ConcernPageView.this.jXb.bUX();
                    }
                }
            }
        };
        this.jXe = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cQJ() {
                ConcernPageView.this.Zi();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jWV.setSelection(0);
                if (ConcernPageView.this.jWV.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cQF();
                } else {
                    ConcernPageView.this.it(true);
                }
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Mi(String str) {
                ConcernPageView.this.Zi();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cQE();
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.Mj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.jWV.setVisibility(8);
                    ConcernPageView.this.pU(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Zi();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jWY.cQO()) {
                    ConcernPageView.this.cQF();
                } else {
                    ConcernPageView.this.cQE();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cQK() {
                if (ConcernPageView.this.jWX != null) {
                    ConcernPageView.this.jWX.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Zi();
                ConcernPageView.this.jWV.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bUp();
            }
        };
        this.jXg = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jXa = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jXh = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jWY.cQL();
                    } else {
                        ConcernPageView.this.jWY.cQM();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        this.jKO = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (ConcernPageView.this.jKE != null) {
                        ConcernPageView.this.jKE.b(bgVar);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jWV = new BdTypeRecyclerView(context);
        this.jWV.setLayoutManager(new LinearLayoutManager(context));
        this.jWV.setFadingEdgeLength(0);
        this.jWV.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jWV.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jXd = new BigdaySwipeRefreshLayout(context);
        this.jXd.addView(this.jWV);
        this.gCf = new PbListView(context);
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setOnClickListener(this.jXf);
        this.jWV.setNextPage(this.gCf);
        f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        addView(this.jXd);
        this.jWU = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.jWU.setEnable(true);
        this.jXd.setProgressView(this.jWU);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.jXd.setCustomDistances(i, i, i * 2);
        this.jWW = new com.baidu.tieba.homepage.concern.a(context, this.jWV);
        this.jWY = new d(this.pageContext, this.jWV, this.jWW, this.jXd);
        this.jXd.setVisibility(8);
        this.jKE = new PublishProgressView(context);
        addView(this.jKE, new FrameLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds83)));
        this.jKE.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void cbX() {
        this.jWY.a(this.jXe);
        this.jWU.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bOm().Fl("page_concern");
                    ConcernPageView.this.jWY.update();
                }
            }
        });
        this.jWV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bUp();
            }
        });
        this.jWV.removeOnScrollListener(this.mOnScrollListener);
        this.jWV.addOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().registerListener(this.jKO);
    }

    public void setCallback(a aVar) {
        this.jWX = aVar;
    }

    public void cQB() {
        if (!TbadkCoreApplication.isLogin()) {
            cQD();
        } else if (this.jWY != null) {
            this.jWY.update();
            it(true);
        }
    }

    public void cQC() {
        if (!TbadkCoreApplication.isLogin()) {
            cQD();
        } else if (this.jWY != null) {
            this.jWY.cQN();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
        if (this.jWY != null) {
            this.jWY.setRecommendFrsNavigationAnimDispatcher(yVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jWZ != null) {
                this.jWZ.onChangeSkinType(i);
            }
            if (this.gLj != null) {
                this.gLj.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jWU != null) {
                this.jWU.changeSkin(i);
            }
            if (this.gCf != null) {
                this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
                this.gCf.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            }
            if (this.jKE != null) {
                this.jKE.onChangeSkinType();
            }
            this.jWW.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cQG();
    }

    public void bc(String str, int i) {
        this.jWY.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.jWY.a(z, dataRes, 0, null);
    }

    public void aB(bz bzVar) {
        hideNoDataView();
        this.jWY.aB(bzVar);
    }

    public void pU(boolean z) {
        if (!ctt()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.jWY != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.jWY.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
    }

    private boolean ctt() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cQD() {
        if (this.jWZ == null) {
            this.jWZ = new ConcernNotLoginLayout(getContext());
            this.jWZ.onChangeSkinType(this.mSkinType);
        }
        if (this.jWZ.getParent() == null) {
            this.jXd.setVisibility(8);
            this.jWZ.setVisibility(0);
            addView(this.jWZ);
        }
    }

    public boolean cts() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void it(boolean z) {
        if (!cts()) {
            if (this.gLj == null) {
                this.gLj = new g(getContext());
                this.gLj.bv(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gLj.bGs();
                this.gLj.setWrapStyle(true);
            }
            this.gLj.onChangeSkinType();
            this.gLj.attachView(this, z);
        }
    }

    public void cQE() {
        this.jXd.setVisibility(0);
        this.jWV.setVisibility(0);
        if (this.jWY.hasMore()) {
            this.gCf.startLoadData();
        } else {
            this.gCf.endLoadDataWithNoMore();
        }
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cQF() {
        this.jXd.setVisibility(0);
        this.jWV.setVisibility(0);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_home_concern_all_status", 0);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dY(null, getContext().getString(R.string.concern_no_data_title)), null);
        }
        if (i == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getContext().getString(R.string.concern_person_no_data_title)));
            this.mNoDataView.setImgOption(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getContext().getString(R.string.concern_no_data_title)));
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
        if (this.jWY != null) {
            this.jWY.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jWY != null) {
            this.jWY.qD(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jWY != null) {
            this.jWY.rN(z);
        }
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
            this.jXb.a(this.jXc);
            this.jXc.cQI();
        }
    }

    public void reload() {
        if (this.jWV != null && this.jXd != null) {
            if (this.jXa && this.jWV.getFirstVisiblePosition() != 0) {
                this.jXa = false;
                return;
            }
            this.jWV.setSelection(0);
            if (!this.jXd.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.jWY.update();
                    }
                } else {
                    this.jXd.setRefreshing(true);
                }
            }
            if (!this.jXd.isRefreshing()) {
                this.jXd.setRefreshing(true);
            }
            if (this.jXc != null) {
                this.jXc.cQI();
            }
        }
    }

    public void onDestroy() {
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
        }
        this.jWV.removeOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().unRegisterListener(this.jKO);
        this.jWY.a((d.a) null);
        this.jWU.setListPullRefreshListener(null);
        this.jWU.a((f.d) null);
        this.jWV.setOnSrollToBottomListener(null);
        this.jWU.a((f.b) null);
        this.jWU.release();
        this.jWV.setRecyclerListener(null);
        this.jWY.onDestroy();
    }

    public void cQG() {
        if (this.jWW != null) {
            this.jWW.notifyDataSetChanged();
        }
    }

    public void cQH() {
        if (this.jWY != null) {
            this.jWY.qD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUp() {
        if (this.jWY != null) {
            this.jWY.bUp();
        }
    }

    public void Hp() {
        if (this.jWW != null) {
            List<n> dataList = this.jWW.getDataList();
            if (!x.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof k) {
                        k kVar = (k) nVar;
                        if (kVar.eSI != 0 && kVar.eMv != null) {
                            int[] imageWidthAndHeight = kVar.eMv.getImageWidthAndHeight();
                            kVar.eSI = imageWidthAndHeight[0];
                            kVar.eSJ = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.jWW != null) {
                            ConcernPageView.this.jWW.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
