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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.aa;
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
    private g gLk;
    private final CustomMessageListener jNJ;
    private PublishProgressView jNz;
    private com.baidu.tieba.homepage.personalize.bigday.a kcg;
    private BdTypeRecyclerView kch;
    private com.baidu.tieba.homepage.concern.a kci;
    private a kcj;
    private d kck;
    private ConcernNotLoginLayout kcl;
    private boolean kcm;
    private ScrollFragmentTabHost kcn;
    ScrollFragmentTabHost.a kco;
    private BigdaySwipeRefreshLayout kcp;
    private d.a kcq;
    private View.OnClickListener kcr;
    private CustomMessageListener kcs;
    private CustomMessageListener kct;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void ai(boolean z, boolean z2);

        void b(com.baidu.tbadk.util.c cVar);

        void b(String str, com.baidu.tbadk.util.c cVar);
    }

    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kcn = scrollFragmentTabHost;
        if (this.kcn != null) {
            this.kcn.b(this.kco);
            this.kcn.a(this.kco);
        }
    }

    public void completePullRefresh() {
        if (this.kcp != null) {
            this.kcp.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kci != null) {
            this.kci.setPageUniqueId(bdUniqueId);
        }
        if (this.kck != null) {
            this.kck.t(bdUniqueId);
        }
        if (this.kcg != null) {
            this.kcg.setTag(bdUniqueId);
        }
        if (this.kcs != null) {
            this.kcs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kcs);
        }
        MessageManager.getInstance().registerListener(this.kct);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.kcm = false;
        this.mSkinType = 3;
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gEG != i && ConcernPageView.this.kcn != null) {
                    ConcernPageView.this.gEG = i;
                    if (ConcernPageView.this.gEG == 1) {
                        ConcernPageView.this.kcn.bRW();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.kcn.bRX();
                    } else {
                        ConcernPageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kco = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPc() {
                if (ConcernPageView.this.kcn != null) {
                    ConcernPageView.this.gEG = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.kch)) {
                        ConcernPageView.this.kcn.bRX();
                    } else {
                        ConcernPageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kcq = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.Xc();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.kch.setSelection(0);
                if (ConcernPageView.this.kch.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cOZ();
                } else {
                    ConcernPageView.this.ir(true);
                }
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.b(cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(String str, com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.Xc();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cOY();
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.b(str, cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.kch.setVisibility(8);
                    ConcernPageView.this.qa(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Xc();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.kck.cPh()) {
                    ConcernPageView.this.cOZ();
                } else {
                    ConcernPageView.this.cOY();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cPd() {
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Xc();
                ConcernPageView.this.kch.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.kcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRp();
            }
        };
        this.kcs = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.kcm = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.kct = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.kck.cPe();
                    } else {
                        ConcernPageView.this.kck.cPf();
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
        this.jNJ = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                    bi biVar = (bi) customResponsedMessage.getData();
                    if (ConcernPageView.this.jNz != null) {
                        ConcernPageView.this.jNz.b(biVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kcm = false;
        this.mSkinType = 3;
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gEG != i && ConcernPageView.this.kcn != null) {
                    ConcernPageView.this.gEG = i;
                    if (ConcernPageView.this.gEG == 1) {
                        ConcernPageView.this.kcn.bRW();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.kcn.bRX();
                    } else {
                        ConcernPageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kco = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPc() {
                if (ConcernPageView.this.kcn != null) {
                    ConcernPageView.this.gEG = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.kch)) {
                        ConcernPageView.this.kcn.bRX();
                    } else {
                        ConcernPageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kcq = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.Xc();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.kch.setSelection(0);
                if (ConcernPageView.this.kch.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cOZ();
                } else {
                    ConcernPageView.this.ir(true);
                }
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.b(cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(String str, com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.Xc();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cOY();
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.b(str, cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.kch.setVisibility(8);
                    ConcernPageView.this.qa(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Xc();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.kck.cPh()) {
                    ConcernPageView.this.cOZ();
                } else {
                    ConcernPageView.this.cOY();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cPd() {
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Xc();
                ConcernPageView.this.kch.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.kcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRp();
            }
        };
        this.kcs = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.kcm = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.kct = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.kck.cPe();
                    } else {
                        ConcernPageView.this.kck.cPf();
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
        this.jNJ = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                    bi biVar = (bi) customResponsedMessage.getData();
                    if (ConcernPageView.this.jNz != null) {
                        ConcernPageView.this.jNz.b(biVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kcm = false;
        this.mSkinType = 3;
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.gEG != i2 && ConcernPageView.this.kcn != null) {
                    ConcernPageView.this.gEG = i2;
                    if (ConcernPageView.this.gEG == 1) {
                        ConcernPageView.this.kcn.bRW();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.kcn.bRX();
                    } else {
                        ConcernPageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kco = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPc() {
                if (ConcernPageView.this.kcn != null) {
                    ConcernPageView.this.gEG = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.kch)) {
                        ConcernPageView.this.kcn.bRX();
                    } else {
                        ConcernPageView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kcq = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.Xc();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.kch.setSelection(0);
                if (ConcernPageView.this.kch.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cOZ();
                } else {
                    ConcernPageView.this.ir(true);
                }
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.b(cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(String str, com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.Xc();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cOY();
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.b(str, cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.kch.setVisibility(8);
                    ConcernPageView.this.qa(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Xc();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.kck.cPh()) {
                    ConcernPageView.this.cOZ();
                } else {
                    ConcernPageView.this.cOY();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cPd() {
                if (ConcernPageView.this.kcj != null) {
                    ConcernPageView.this.kcj.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.Xc();
                ConcernPageView.this.kch.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.kcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRp();
            }
        };
        this.kcs = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.kcm = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.kct = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.kck.cPe();
                    } else {
                        ConcernPageView.this.kck.cPf();
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
        this.jNJ = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                    bi biVar = (bi) customResponsedMessage.getData();
                    if (ConcernPageView.this.jNz != null) {
                        ConcernPageView.this.jNz.b(biVar);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.kch = new BdTypeRecyclerView(context);
        this.kch.setLayoutManager(new LinearLayoutManager(context));
        this.kch.setFadingEdgeLength(0);
        this.kch.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.kch.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.kcp = new BigdaySwipeRefreshLayout(context);
        this.kcp.addView(this.kch);
        this.gCf = new PbListView(context);
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setOnClickListener(this.kcr);
        this.kch.setNextPage(this.gCf);
        f<?> J = com.baidu.adp.base.j.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        addView(this.kcp);
        this.kcg = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.kcg.setEnable(true);
        this.kcp.setProgressView(this.kcg);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.kcp.setCustomDistances(i, i, i * 2);
        this.kci = new com.baidu.tieba.homepage.concern.a(context, this.kch);
        this.kck = new d(this.pageContext, this.kch, this.kci, this.kcp);
        this.kcp.setVisibility(8);
        this.jNz = new PublishProgressView(context);
        addView(this.jNz, new FrameLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds83)));
        this.jNz.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bZr() {
        this.kck.a(this.kcq);
        this.kcg.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bKY().EC("page_concern");
                    ConcernPageView.this.kck.update();
                }
            }
        });
        this.kch.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bRp();
            }
        });
        this.kch.removeOnScrollListener(this.mOnScrollListener);
        this.kch.addOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().registerListener(this.jNJ);
    }

    public void setCallback(a aVar) {
        this.kcj = aVar;
    }

    public void cOV() {
        if (!TbadkCoreApplication.isLogin()) {
            cOX();
        } else if (this.kck != null) {
            this.kck.update();
            ir(true);
        }
    }

    public void cOW() {
        if (!TbadkCoreApplication.isLogin()) {
            cOX();
        } else if (this.kck != null) {
            this.kck.cPg();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.kck != null) {
            this.kck.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kcl != null) {
                this.kcl.onChangeSkinType(i);
            }
            if (this.gLk != null) {
                this.gLk.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.kcg != null) {
                this.kcg.changeSkin(i);
            }
            if (this.gCf != null) {
                this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.gCf.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            }
            if (this.jNz != null) {
                this.jNz.onChangeSkinType();
            }
            this.kci.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cPa();
    }

    public void bd(String str, int i) {
        this.kck.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.kck.a(z, dataRes, 0, null);
    }

    public void aC(cb cbVar) {
        hideNoDataView();
        this.kck.aC(cbVar);
    }

    public void qa(boolean z) {
        if (!cqZ()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.kck != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.kck.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
        }
    }

    private boolean cqZ() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cOX() {
        if (this.kcl == null) {
            this.kcl = new ConcernNotLoginLayout(getContext());
            this.kcl.onChangeSkinType(this.mSkinType);
        }
        if (this.kcl.getParent() == null) {
            this.kcp.setVisibility(8);
            this.kcl.setVisibility(0);
            addView(this.kcl);
        }
    }

    public boolean cqY() {
        if (this.gLk != null) {
            return this.gLk.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir(boolean z) {
        if (!cqY()) {
            if (this.gLk == null) {
                this.gLk = new g(getContext());
                this.gLk.bu(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gLk.bCV();
                this.gLk.setWrapStyle(true);
            }
            this.gLk.onChangeSkinType();
            this.gLk.attachView(this, z);
        }
    }

    public void cOY() {
        this.kcp.setVisibility(0);
        this.kch.setVisibility(0);
        if (this.kck.hasMore()) {
            this.gCf.startLoadData();
        } else {
            this.gCf.endLoadDataWithNoMore();
        }
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cOZ() {
        this.kcp.setVisibility(0);
        this.kch.setVisibility(0);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_home_concern_all_status", 0);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dS(null, getContext().getString(R.string.concern_no_data_title)), null);
        }
        if (i == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getContext().getString(R.string.concern_person_no_data_title)));
            this.mNoDataView.setImgOption(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getContext().getString(R.string.concern_no_data_title)));
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
        if (this.kck != null) {
            this.kck.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.kck != null) {
            this.kck.qJ(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.kck != null) {
            this.kck.rV(z);
        }
        if (this.kcn != null) {
            this.kcn.b(this.kco);
            this.kcn.a(this.kco);
            this.kco.cPc();
        }
    }

    public void reload() {
        if (this.kch != null && this.kcp != null) {
            if (this.kcm && this.kch.getFirstVisiblePosition() != 0) {
                this.kcm = false;
                return;
            }
            this.kch.setSelection(0);
            if (!this.kcp.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.kck.update();
                    }
                } else {
                    this.kcp.setRefreshing(true);
                }
            }
            if (!this.kcp.isRefreshing()) {
                this.kcp.setRefreshing(true);
            }
            if (this.kco != null) {
                this.kco.cPc();
            }
        }
    }

    public void onDestroy() {
        if (this.kcn != null) {
            this.kcn.b(this.kco);
        }
        this.kch.removeOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().unRegisterListener(this.jNJ);
        this.kck.a((d.a) null);
        this.kcg.setListPullRefreshListener(null);
        this.kcg.a((f.d) null);
        this.kch.setOnSrollToBottomListener(null);
        this.kcg.a((f.b) null);
        this.kcg.release();
        this.kch.setRecyclerListener(null);
        this.kck.onDestroy();
    }

    public void cPa() {
        if (this.kci != null) {
            this.kci.notifyDataSetChanged();
        }
    }

    public void cPb() {
        if (this.kck != null) {
            this.kck.qJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRp() {
        if (this.kck != null) {
            this.kck.bRp();
        }
    }

    public void EN() {
        if (this.kci != null) {
            List<n> dataList = this.kci.getDataList();
            if (!y.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof k) {
                        k kVar = (k) nVar;
                        if (kVar.eRK != 0 && kVar.eLr != null) {
                            int[] imageWidthAndHeight = kVar.eLr.getImageWidthAndHeight();
                            kVar.eRK = imageWidthAndHeight[0];
                            kVar.eRL = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.kci != null) {
                            ConcernPageView.this.kci.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
