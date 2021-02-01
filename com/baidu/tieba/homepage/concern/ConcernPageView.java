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
    private PbListView gAi;
    private int gCJ;
    private g gJn;
    private PublishProgressView jLC;
    private final CustomMessageListener jLM;
    private com.baidu.tieba.homepage.personalize.bigday.a jZQ;
    private BdTypeRecyclerView jZR;
    private com.baidu.tieba.homepage.concern.a jZS;
    private a jZT;
    private d jZU;
    private ConcernNotLoginLayout jZV;
    private boolean jZW;
    private ScrollFragmentTabHost jZX;
    ScrollFragmentTabHost.a jZY;
    private BigdaySwipeRefreshLayout jZZ;
    private d.a kaa;
    private View.OnClickListener kab;
    private CustomMessageListener kac;
    private CustomMessageListener kad;
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
        this.jZX = scrollFragmentTabHost;
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
            this.jZX.a(this.jZY);
        }
    }

    public void completePullRefresh() {
        if (this.jZZ != null) {
            this.jZZ.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jZS != null) {
            this.jZS.setPageUniqueId(bdUniqueId);
        }
        if (this.jZU != null) {
            this.jZU.s(bdUniqueId);
        }
        if (this.jZQ != null) {
            this.jZQ.setTag(bdUniqueId);
        }
        if (this.kac != null) {
            this.kac.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kac);
        }
        MessageManager.getInstance().registerListener(this.kad);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.jZW = false;
        this.mSkinType = 3;
        this.gCJ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gCJ != i && ConcernPageView.this.jZX != null) {
                    ConcernPageView.this.gCJ = i;
                    if (ConcernPageView.this.gCJ == 1) {
                        ConcernPageView.this.jZX.bRJ();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.jZX.bRK();
                    } else {
                        ConcernPageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.jZY = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOO() {
                if (ConcernPageView.this.jZX != null) {
                    ConcernPageView.this.gCJ = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.jZR)) {
                        ConcernPageView.this.jZX.bRK();
                    } else {
                        ConcernPageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.kaa = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jZR.setSelection(0);
                if (ConcernPageView.this.jZR.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cOL();
                } else {
                    ConcernPageView.this.ir(true);
                }
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.b(cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(String str, com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cOK();
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.b(str, cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jZR.setVisibility(8);
                    ConcernPageView.this.qa(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jZU.cOT()) {
                    ConcernPageView.this.cOL();
                } else {
                    ConcernPageView.this.cOK();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cOP() {
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.jZR.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.kab = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRc();
            }
        };
        this.kac = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jZW = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.kad = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jZU.cOQ();
                    } else {
                        ConcernPageView.this.jZU.cOR();
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
        this.jLM = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                    bi biVar = (bi) customResponsedMessage.getData();
                    if (ConcernPageView.this.jLC != null) {
                        ConcernPageView.this.jLC.b(biVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZW = false;
        this.mSkinType = 3;
        this.gCJ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gCJ != i && ConcernPageView.this.jZX != null) {
                    ConcernPageView.this.gCJ = i;
                    if (ConcernPageView.this.gCJ == 1) {
                        ConcernPageView.this.jZX.bRJ();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.jZX.bRK();
                    } else {
                        ConcernPageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.jZY = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOO() {
                if (ConcernPageView.this.jZX != null) {
                    ConcernPageView.this.gCJ = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.jZR)) {
                        ConcernPageView.this.jZX.bRK();
                    } else {
                        ConcernPageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.kaa = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jZR.setSelection(0);
                if (ConcernPageView.this.jZR.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cOL();
                } else {
                    ConcernPageView.this.ir(true);
                }
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.b(cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(String str, com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cOK();
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.b(str, cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jZR.setVisibility(8);
                    ConcernPageView.this.qa(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jZU.cOT()) {
                    ConcernPageView.this.cOL();
                } else {
                    ConcernPageView.this.cOK();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cOP() {
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.jZR.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.kab = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRc();
            }
        };
        this.kac = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jZW = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.kad = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jZU.cOQ();
                    } else {
                        ConcernPageView.this.jZU.cOR();
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
        this.jLM = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                    bi biVar = (bi) customResponsedMessage.getData();
                    if (ConcernPageView.this.jLC != null) {
                        ConcernPageView.this.jLC.b(biVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZW = false;
        this.mSkinType = 3;
        this.gCJ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.gCJ != i2 && ConcernPageView.this.jZX != null) {
                    ConcernPageView.this.gCJ = i2;
                    if (ConcernPageView.this.gCJ == 1) {
                        ConcernPageView.this.jZX.bRJ();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.jZX.bRK();
                    } else {
                        ConcernPageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.jZY = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOO() {
                if (ConcernPageView.this.jZX != null) {
                    ConcernPageView.this.gCJ = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.jZR)) {
                        ConcernPageView.this.jZX.bRK();
                    } else {
                        ConcernPageView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.kaa = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jZR.setSelection(0);
                if (ConcernPageView.this.jZR.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cOL();
                } else {
                    ConcernPageView.this.ir(true);
                }
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.b(cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(String str, com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cOK();
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.b(str, cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.jZR.setVisibility(8);
                    ConcernPageView.this.qa(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jZU.cOT()) {
                    ConcernPageView.this.cOL();
                } else {
                    ConcernPageView.this.cOK();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cOP() {
                if (ConcernPageView.this.jZT != null) {
                    ConcernPageView.this.jZT.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.jZR.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.kab = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRc();
            }
        };
        this.kac = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jZW = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.kad = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jZU.cOQ();
                    } else {
                        ConcernPageView.this.jZU.cOR();
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
        this.jLM = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                    bi biVar = (bi) customResponsedMessage.getData();
                    if (ConcernPageView.this.jLC != null) {
                        ConcernPageView.this.jLC.b(biVar);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jZR = new BdTypeRecyclerView(context);
        this.jZR.setLayoutManager(new LinearLayoutManager(context));
        this.jZR.setFadingEdgeLength(0);
        this.jZR.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jZR.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jZZ = new BigdaySwipeRefreshLayout(context);
        this.jZZ.addView(this.jZR);
        this.gAi = new PbListView(context);
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.transparent);
        this.gAi.setLineGone();
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.setOnClickListener(this.kab);
        this.jZR.setNextPage(this.gAi);
        f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        addView(this.jZZ);
        this.jZQ = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.jZQ.setEnable(true);
        this.jZZ.setProgressView(this.jZQ);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.jZZ.setCustomDistances(i, i, i * 2);
        this.jZS = new com.baidu.tieba.homepage.concern.a(context, this.jZR);
        this.jZU = new d(this.pageContext, this.jZR, this.jZS, this.jZZ);
        this.jZZ.setVisibility(8);
        this.jLC = new PublishProgressView(context);
        addView(this.jLC, new FrameLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds83)));
        this.jLC.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bZe() {
        this.jZU.a(this.kaa);
        this.jZQ.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bKP().Ex("page_concern");
                    ConcernPageView.this.jZU.update();
                }
            }
        });
        this.jZR.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bRc();
            }
        });
        this.jZR.removeOnScrollListener(this.mOnScrollListener);
        this.jZR.addOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().registerListener(this.jLM);
    }

    public void setCallback(a aVar) {
        this.jZT = aVar;
    }

    public void cOH() {
        if (!TbadkCoreApplication.isLogin()) {
            cOJ();
        } else if (this.jZU != null) {
            this.jZU.update();
            ir(true);
        }
    }

    public void cOI() {
        if (!TbadkCoreApplication.isLogin()) {
            cOJ();
        } else if (this.jZU != null) {
            this.jZU.cOS();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.jZU != null) {
            this.jZU.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jZV != null) {
                this.jZV.onChangeSkinType(i);
            }
            if (this.gJn != null) {
                this.gJn.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jZQ != null) {
                this.jZQ.changeSkin(i);
            }
            if (this.gAi != null) {
                this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.gAi.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            }
            if (this.jLC != null) {
                this.jLC.onChangeSkinType();
            }
            this.jZS.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cOM();
    }

    public void bd(String str, int i) {
        this.jZU.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.jZU.a(z, dataRes, 0, null);
    }

    public void aC(cb cbVar) {
        hideNoDataView();
        this.jZU.aC(cbVar);
    }

    public void qa(boolean z) {
        if (!cqM()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.jZU != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.jZU.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
        }
    }

    private boolean cqM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cOJ() {
        if (this.jZV == null) {
            this.jZV = new ConcernNotLoginLayout(getContext());
            this.jZV.onChangeSkinType(this.mSkinType);
        }
        if (this.jZV.getParent() == null) {
            this.jZZ.setVisibility(8);
            this.jZV.setVisibility(0);
            addView(this.jZV);
        }
    }

    public boolean cqL() {
        if (this.gJn != null) {
            return this.gJn.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir(boolean z) {
        if (!cqL()) {
            if (this.gJn == null) {
                this.gJn = new g(getContext());
                this.gJn.bt(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gJn.bCS();
                this.gJn.setWrapStyle(true);
            }
            this.gJn.onChangeSkinType();
            this.gJn.attachView(this, z);
        }
    }

    public void cOK() {
        this.jZZ.setVisibility(0);
        this.jZR.setVisibility(0);
        if (this.jZU.hasMore()) {
            this.gAi.startLoadData();
        } else {
            this.gAi.endLoadDataWithNoMore();
        }
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cOL() {
        this.jZZ.setVisibility(0);
        this.jZR.setVisibility(0);
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_home_concern_all_status", 0);
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
        if (this.jZU != null) {
            this.jZU.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jZU != null) {
            this.jZU.qJ(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jZU != null) {
            this.jZU.rV(z);
        }
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
            this.jZX.a(this.jZY);
            this.jZY.cOO();
        }
    }

    public void reload() {
        if (this.jZR != null && this.jZZ != null) {
            if (this.jZW && this.jZR.getFirstVisiblePosition() != 0) {
                this.jZW = false;
                return;
            }
            this.jZR.setSelection(0);
            if (!this.jZZ.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.jZU.update();
                    }
                } else {
                    this.jZZ.setRefreshing(true);
                }
            }
            if (!this.jZZ.isRefreshing()) {
                this.jZZ.setRefreshing(true);
            }
            if (this.jZY != null) {
                this.jZY.cOO();
            }
        }
    }

    public void onDestroy() {
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
        }
        this.jZR.removeOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().unRegisterListener(this.jLM);
        this.jZU.a((d.a) null);
        this.jZQ.setListPullRefreshListener(null);
        this.jZQ.a((f.d) null);
        this.jZR.setOnSrollToBottomListener(null);
        this.jZQ.a((f.b) null);
        this.jZQ.release();
        this.jZR.setRecyclerListener(null);
        this.jZU.onDestroy();
    }

    public void cOM() {
        if (this.jZS != null) {
            this.jZS.notifyDataSetChanged();
        }
    }

    public void cON() {
        if (this.jZU != null) {
            this.jZU.qJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRc() {
        if (this.jZU != null) {
            this.jZU.bRc();
        }
    }

    public void EK() {
        if (this.jZS != null) {
            List<n> dataList = this.jZS.getDataList();
            if (!y.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof k) {
                        k kVar = (k) nVar;
                        if (kVar.eQj != 0 && kVar.eJQ != null) {
                            int[] imageWidthAndHeight = kVar.eJQ.getImageWidthAndHeight();
                            kVar.eQj = imageWidthAndHeight[0];
                            kVar.eQk = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.jZS != null) {
                            ConcernPageView.this.jZS.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
