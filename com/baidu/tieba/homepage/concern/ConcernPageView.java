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
    private PbListView gAw;
    private int gCX;
    private g gJB;
    private PublishProgressView jLQ;
    private final CustomMessageListener jMa;
    private com.baidu.tieba.homepage.personalize.bigday.a kae;
    private BdTypeRecyclerView kaf;
    private com.baidu.tieba.homepage.concern.a kag;
    private a kah;
    private d kai;
    private ConcernNotLoginLayout kaj;
    private boolean kak;
    private ScrollFragmentTabHost kal;
    ScrollFragmentTabHost.a kam;
    private BigdaySwipeRefreshLayout kan;
    private d.a kao;
    private View.OnClickListener kap;
    private CustomMessageListener kaq;
    private CustomMessageListener kar;
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
        this.kal = scrollFragmentTabHost;
        if (this.kal != null) {
            this.kal.b(this.kam);
            this.kal.a(this.kam);
        }
    }

    public void completePullRefresh() {
        if (this.kan != null) {
            this.kan.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kag != null) {
            this.kag.setPageUniqueId(bdUniqueId);
        }
        if (this.kai != null) {
            this.kai.s(bdUniqueId);
        }
        if (this.kae != null) {
            this.kae.setTag(bdUniqueId);
        }
        if (this.kaq != null) {
            this.kaq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kaq);
        }
        MessageManager.getInstance().registerListener(this.kar);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.kak = false;
        this.mSkinType = 3;
        this.gCX = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gCX != i && ConcernPageView.this.kal != null) {
                    ConcernPageView.this.gCX = i;
                    if (ConcernPageView.this.gCX == 1) {
                        ConcernPageView.this.kal.bRQ();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.kal.bRR();
                    } else {
                        ConcernPageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kam = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOV() {
                if (ConcernPageView.this.kal != null) {
                    ConcernPageView.this.gCX = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.kaf)) {
                        ConcernPageView.this.kal.bRR();
                    } else {
                        ConcernPageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kao = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.kaf.setSelection(0);
                if (ConcernPageView.this.kaf.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cOS();
                } else {
                    ConcernPageView.this.ir(true);
                }
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.b(cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(String str, com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cOR();
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.b(str, cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.kaf.setVisibility(8);
                    ConcernPageView.this.qa(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.kai.cPa()) {
                    ConcernPageView.this.cOS();
                } else {
                    ConcernPageView.this.cOR();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cOW() {
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.kaf.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.kap = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRj();
            }
        };
        this.kaq = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.kak = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.kar = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.kai.cOX();
                    } else {
                        ConcernPageView.this.kai.cOY();
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
        this.jMa = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                    bi biVar = (bi) customResponsedMessage.getData();
                    if (ConcernPageView.this.jLQ != null) {
                        ConcernPageView.this.jLQ.b(biVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kak = false;
        this.mSkinType = 3;
        this.gCX = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.gCX != i && ConcernPageView.this.kal != null) {
                    ConcernPageView.this.gCX = i;
                    if (ConcernPageView.this.gCX == 1) {
                        ConcernPageView.this.kal.bRQ();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.kal.bRR();
                    } else {
                        ConcernPageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kam = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOV() {
                if (ConcernPageView.this.kal != null) {
                    ConcernPageView.this.gCX = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.kaf)) {
                        ConcernPageView.this.kal.bRR();
                    } else {
                        ConcernPageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kao = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.kaf.setSelection(0);
                if (ConcernPageView.this.kaf.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cOS();
                } else {
                    ConcernPageView.this.ir(true);
                }
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.b(cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(String str, com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cOR();
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.b(str, cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.kaf.setVisibility(8);
                    ConcernPageView.this.qa(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.kai.cPa()) {
                    ConcernPageView.this.cOS();
                } else {
                    ConcernPageView.this.cOR();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cOW() {
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.kaf.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.kap = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRj();
            }
        };
        this.kaq = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.kak = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.kar = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.kai.cOX();
                    } else {
                        ConcernPageView.this.kai.cOY();
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
        this.jMa = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                    bi biVar = (bi) customResponsedMessage.getData();
                    if (ConcernPageView.this.jLQ != null) {
                        ConcernPageView.this.jLQ.b(biVar);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kak = false;
        this.mSkinType = 3;
        this.gCX = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.gCX != i2 && ConcernPageView.this.kal != null) {
                    ConcernPageView.this.gCX = i2;
                    if (ConcernPageView.this.gCX == 1) {
                        ConcernPageView.this.kal.bRQ();
                    } else if (ConcernPageView.this.c(recyclerView)) {
                        ConcernPageView.this.kal.bRR();
                    } else {
                        ConcernPageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kam = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOV() {
                if (ConcernPageView.this.kal != null) {
                    ConcernPageView.this.gCX = -1;
                    if (ConcernPageView.this.c(ConcernPageView.this.kaf)) {
                        ConcernPageView.this.kal.bRR();
                    } else {
                        ConcernPageView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kao = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.kaf.setSelection(0);
                if (ConcernPageView.this.kaf.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cOS();
                } else {
                    ConcernPageView.this.ir(true);
                }
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.b(cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void a(String str, com.baidu.tbadk.util.c cVar) {
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cOR();
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.b(str, cVar);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.ai(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.kaf.setVisibility(8);
                    ConcernPageView.this.qa(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ah(boolean z, boolean z2) {
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.ai(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.kai.cPa()) {
                    ConcernPageView.this.cOS();
                } else {
                    ConcernPageView.this.cOR();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cOW() {
                if (ConcernPageView.this.kah != null) {
                    ConcernPageView.this.kah.ai(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.WZ();
                ConcernPageView.this.kaf.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.kap = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bRj();
            }
        };
        this.kaq = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.kak = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.kar = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.kai.cOX();
                    } else {
                        ConcernPageView.this.kai.cOY();
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
        this.jMa = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                    bi biVar = (bi) customResponsedMessage.getData();
                    if (ConcernPageView.this.jLQ != null) {
                        ConcernPageView.this.jLQ.b(biVar);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.kaf = new BdTypeRecyclerView(context);
        this.kaf.setLayoutManager(new LinearLayoutManager(context));
        this.kaf.setFadingEdgeLength(0);
        this.kaf.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.kaf.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.kan = new BigdaySwipeRefreshLayout(context);
        this.kan.addView(this.kaf);
        this.gAw = new PbListView(context);
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setLineGone();
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.setOnClickListener(this.kap);
        this.kaf.setNextPage(this.gAw);
        f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        addView(this.kan);
        this.kae = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.kae.setEnable(true);
        this.kan.setProgressView(this.kae);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.kan.setCustomDistances(i, i, i * 2);
        this.kag = new com.baidu.tieba.homepage.concern.a(context, this.kaf);
        this.kai = new d(this.pageContext, this.kaf, this.kag, this.kan);
        this.kan.setVisibility(8);
        this.jLQ = new PublishProgressView(context);
        addView(this.jLQ, new FrameLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds83)));
        this.jLQ.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bZl() {
        this.kai.a(this.kao);
        this.kae.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bKU().Ev("page_concern");
                    ConcernPageView.this.kai.update();
                }
            }
        });
        this.kaf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bRj();
            }
        });
        this.kaf.removeOnScrollListener(this.mOnScrollListener);
        this.kaf.addOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().registerListener(this.jMa);
    }

    public void setCallback(a aVar) {
        this.kah = aVar;
    }

    public void cOO() {
        if (!TbadkCoreApplication.isLogin()) {
            cOQ();
        } else if (this.kai != null) {
            this.kai.update();
            ir(true);
        }
    }

    public void cOP() {
        if (!TbadkCoreApplication.isLogin()) {
            cOQ();
        } else if (this.kai != null) {
            this.kai.cOZ();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.kai != null) {
            this.kai.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kaj != null) {
                this.kaj.onChangeSkinType(i);
            }
            if (this.gJB != null) {
                this.gJB.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.kae != null) {
                this.kae.changeSkin(i);
            }
            if (this.gAw != null) {
                this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.gAw.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            }
            if (this.jLQ != null) {
                this.jLQ.onChangeSkinType();
            }
            this.kag.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cOT();
    }

    public void bd(String str, int i) {
        this.kai.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.kai.a(z, dataRes, 0, null);
    }

    public void aC(cb cbVar) {
        hideNoDataView();
        this.kai.aC(cbVar);
    }

    public void qa(boolean z) {
        if (!cqT()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.kai != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.kai.update();
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
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
    }

    private boolean cqT() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cOQ() {
        if (this.kaj == null) {
            this.kaj = new ConcernNotLoginLayout(getContext());
            this.kaj.onChangeSkinType(this.mSkinType);
        }
        if (this.kaj.getParent() == null) {
            this.kan.setVisibility(8);
            this.kaj.setVisibility(0);
            addView(this.kaj);
        }
    }

    public boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir(boolean z) {
        if (!cqS()) {
            if (this.gJB == null) {
                this.gJB = new g(getContext());
                this.gJB.bt(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.gJB.bCS();
                this.gJB.setWrapStyle(true);
            }
            this.gJB.onChangeSkinType();
            this.gJB.attachView(this, z);
        }
    }

    public void cOR() {
        this.kan.setVisibility(0);
        this.kaf.setVisibility(0);
        if (this.kai.hasMore()) {
            this.gAw.startLoadData();
        } else {
            this.gAw.endLoadDataWithNoMore();
        }
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cOS() {
        this.kan.setVisibility(0);
        this.kaf.setVisibility(0);
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.setHeight(0);
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
        if (this.kai != null) {
            this.kai.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.kai != null) {
            this.kai.qJ(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.kai != null) {
            this.kai.rV(z);
        }
        if (this.kal != null) {
            this.kal.b(this.kam);
            this.kal.a(this.kam);
            this.kam.cOV();
        }
    }

    public void reload() {
        if (this.kaf != null && this.kan != null) {
            if (this.kak && this.kaf.getFirstVisiblePosition() != 0) {
                this.kak = false;
                return;
            }
            this.kaf.setSelection(0);
            if (!this.kan.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.kai.update();
                    }
                } else {
                    this.kan.setRefreshing(true);
                }
            }
            if (!this.kan.isRefreshing()) {
                this.kan.setRefreshing(true);
            }
            if (this.kam != null) {
                this.kam.cOV();
            }
        }
    }

    public void onDestroy() {
        if (this.kal != null) {
            this.kal.b(this.kam);
        }
        this.kaf.removeOnScrollListener(this.mOnScrollListener);
        MessageManager.getInstance().unRegisterListener(this.jMa);
        this.kai.a((d.a) null);
        this.kae.setListPullRefreshListener(null);
        this.kae.a((f.d) null);
        this.kaf.setOnSrollToBottomListener(null);
        this.kae.a((f.b) null);
        this.kae.release();
        this.kaf.setRecyclerListener(null);
        this.kai.onDestroy();
    }

    public void cOT() {
        if (this.kag != null) {
            this.kag.notifyDataSetChanged();
        }
    }

    public void cOU() {
        if (this.kai != null) {
            this.kai.qJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRj() {
        if (this.kai != null) {
            this.kai.bRj();
        }
    }

    public void EK() {
        if (this.kag != null) {
            List<n> dataList = this.kag.getDataList();
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
                        if (ConcernPageView.this.kag != null) {
                            ConcernPageView.this.kag.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
