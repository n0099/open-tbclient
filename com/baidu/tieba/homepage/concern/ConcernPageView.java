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
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernPageView extends FrameLayout {
    private View.OnClickListener bBp;
    private g dhX;
    private PbListView dlX;
    private int dno;
    private com.baidu.tieba.homepage.personalize.bigday.a fWT;
    private BdTypeRecyclerView fWU;
    private com.baidu.tieba.homepage.concern.a fWV;
    private a fWW;
    private c fWX;
    private ConcernNotLoginLayout fWY;
    private boolean fWZ;
    private ScrollFragmentTabHost fXa;
    ScrollFragmentTabHost.a fXb;
    private BigdaySwipeRefreshLayout fXc;
    private c.a fXd;
    private View.OnClickListener fXe;
    private CustomMessageListener fXf;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void M(boolean z, boolean z2);

        void onPullToRefresh();

        void xp(String str);
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fXa = scrollFragmentTabHost;
        if (this.fXa != null) {
            this.fXa.b(this.fXb);
            this.fXa.a(this.fXb);
        }
    }

    public void completePullRefresh() {
        if (this.fXc != null) {
            this.fXc.oz();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fWV != null) {
            this.fWV.setPageUniqueId(bdUniqueId);
        }
        if (this.fWX != null) {
            this.fWX.n(bdUniqueId);
        }
        if (this.fWT != null) {
            this.fWT.setTag(bdUniqueId);
        }
        if (this.fXf != null) {
            this.fXf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fXf);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.fWZ = false;
        this.mSkinType = 3;
        this.dno = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dno != i && ConcernPageView.this.fXa != null) {
                    ConcernPageView.this.dno = i;
                    if (ConcernPageView.this.dno == 1) {
                        ConcernPageView.this.fXa.aHR();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.fXa.aHS();
                    } else {
                        ConcernPageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.bBp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jG()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.fXb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsO() {
                if (ConcernPageView.this.fXa != null) {
                    ConcernPageView.this.dno = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.fWU)) {
                        ConcernPageView.this.fXa.aHS();
                    } else {
                        ConcernPageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.fXd = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsP() {
                if (ConcernPageView.this.fWW == null) {
                    if (ConcernPageView.this.fWY != null) {
                        ConcernPageView.this.fWY.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.K(false, false);
                    return;
                }
                boolean beD = ConcernPageView.this.beD();
                ConcernPageView.this.aHH();
                if (beD) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.fWW.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xo(String str) {
                if (ConcernPageView.this.fWW != null) {
                    ConcernPageView.this.fWW.xp(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.K(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.fWX != null) {
                        ConcernPageView.this.kU(ConcernPageView.this.fWX.hasMore());
                    }
                    if (j.jS()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.fXc.setVisibility(8);
                if (ConcernPageView.this.fWY != null) {
                    ConcernPageView.this.fWY.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void L(boolean z, boolean z2) {
                if (ConcernPageView.this.fWX != null) {
                    ConcernPageView.this.kU(ConcernPageView.this.fWX.hasMore());
                }
                ConcernPageView.this.fXc.setVisibility(0);
                ConcernPageView.this.K(z, z2);
                ConcernPageView.this.aHH();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsQ() {
                ConcernPageView.this.K(true, false);
                ConcernPageView.this.aHH();
                if (v.aa(ConcernPageView.this.fWU.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.fXe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aHq();
            }
        };
        this.fXf = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fWZ = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fWZ = false;
        this.mSkinType = 3;
        this.dno = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dno != i && ConcernPageView.this.fXa != null) {
                    ConcernPageView.this.dno = i;
                    if (ConcernPageView.this.dno == 1) {
                        ConcernPageView.this.fXa.aHR();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.fXa.aHS();
                    } else {
                        ConcernPageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.bBp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jG()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.fXb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsO() {
                if (ConcernPageView.this.fXa != null) {
                    ConcernPageView.this.dno = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.fWU)) {
                        ConcernPageView.this.fXa.aHS();
                    } else {
                        ConcernPageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.fXd = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsP() {
                if (ConcernPageView.this.fWW == null) {
                    if (ConcernPageView.this.fWY != null) {
                        ConcernPageView.this.fWY.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.K(false, false);
                    return;
                }
                boolean beD = ConcernPageView.this.beD();
                ConcernPageView.this.aHH();
                if (beD) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.fWW.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xo(String str) {
                if (ConcernPageView.this.fWW != null) {
                    ConcernPageView.this.fWW.xp(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.K(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.fWX != null) {
                        ConcernPageView.this.kU(ConcernPageView.this.fWX.hasMore());
                    }
                    if (j.jS()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.fXc.setVisibility(8);
                if (ConcernPageView.this.fWY != null) {
                    ConcernPageView.this.fWY.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void L(boolean z, boolean z2) {
                if (ConcernPageView.this.fWX != null) {
                    ConcernPageView.this.kU(ConcernPageView.this.fWX.hasMore());
                }
                ConcernPageView.this.fXc.setVisibility(0);
                ConcernPageView.this.K(z, z2);
                ConcernPageView.this.aHH();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsQ() {
                ConcernPageView.this.K(true, false);
                ConcernPageView.this.aHH();
                if (v.aa(ConcernPageView.this.fWU.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.fXe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aHq();
            }
        };
        this.fXf = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fWZ = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fWZ = false;
        this.mSkinType = 3;
        this.dno = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.dno != i2 && ConcernPageView.this.fXa != null) {
                    ConcernPageView.this.dno = i2;
                    if (ConcernPageView.this.dno == 1) {
                        ConcernPageView.this.fXa.aHR();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.fXa.aHS();
                    } else {
                        ConcernPageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.bBp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jG()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.fXb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsO() {
                if (ConcernPageView.this.fXa != null) {
                    ConcernPageView.this.dno = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.fWU)) {
                        ConcernPageView.this.fXa.aHS();
                    } else {
                        ConcernPageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.fXd = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsP() {
                if (ConcernPageView.this.fWW == null) {
                    if (ConcernPageView.this.fWY != null) {
                        ConcernPageView.this.fWY.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.K(false, false);
                    return;
                }
                boolean beD = ConcernPageView.this.beD();
                ConcernPageView.this.aHH();
                if (beD) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.fWW.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xo(String str) {
                if (ConcernPageView.this.fWW != null) {
                    ConcernPageView.this.fWW.xp(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                ConcernPageView.this.K(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.fWX != null) {
                        ConcernPageView.this.kU(ConcernPageView.this.fWX.hasMore());
                    }
                    if (j.jS()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.fXc.setVisibility(8);
                if (ConcernPageView.this.fWY != null) {
                    ConcernPageView.this.fWY.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void L(boolean z, boolean z2) {
                if (ConcernPageView.this.fWX != null) {
                    ConcernPageView.this.kU(ConcernPageView.this.fWX.hasMore());
                }
                ConcernPageView.this.fXc.setVisibility(0);
                ConcernPageView.this.K(z, z2);
                ConcernPageView.this.aHH();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsQ() {
                ConcernPageView.this.K(true, false);
                ConcernPageView.this.aHH();
                if (v.aa(ConcernPageView.this.fWU.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.fXe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aHq();
            }
        };
        this.fXf = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fWZ = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fWU = new BdTypeRecyclerView(context);
        this.fWU.setLayoutManager(new LinearLayoutManager(context));
        this.fWU.setFadingEdgeLength(0);
        this.fWU.setOverScrollMode(2);
        this.fXc = new BigdaySwipeRefreshLayout(context);
        this.fXc.addView(this.fWU);
        this.dlX = new PbListView(context);
        this.dlX.getView();
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.ajv();
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.iN(R.color.cp_cont_e);
        this.dlX.setHeight(l.g(context, R.dimen.tbds182));
        this.dlX.setOnClickListener(this.fXe);
        this.fWU.setNextPage(this.dlX);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.fXc);
        ((FrameLayout.LayoutParams) this.fXc.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.fWT = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.fWT.setEnable(true);
        this.fXc.setProgressView(this.fWT);
        int i = (int) (61.0f * getResources().getDisplayMetrics().density);
        this.fXc.setCustomDistances(i, i, i * 2);
        this.fWV = new com.baidu.tieba.homepage.concern.a(context, this.fWU);
        this.fWX = new c(this.pageContext, this.fWU, this.fWV, this.fXc);
        this.fXc.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bnP() {
        this.fWX.a(this.fXd);
        this.fWT.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aBn().rU("page_concern");
                    ConcernPageView.this.fWX.update();
                }
            }
        });
        this.fWU.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aHq();
            }
        });
        this.fWU.removeOnScrollListener(this.mOnScrollListener);
        this.fWU.addOnScrollListener(this.mOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU(boolean z) {
        if (this.dlX != null) {
            if (z) {
                this.dlX.ajB();
                this.dlX.iQ(0);
                return;
            }
            this.dlX.iR(0);
        }
    }

    public void setCallback(a aVar) {
        this.fWW = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dlX != null) {
            this.dlX.ajz();
            this.dlX.iQ(0);
        }
        this.fWX.a(z, dataRes, 0, null);
    }

    public void bsJ() {
        if (!TbadkCoreApplication.isLogin()) {
            bsL();
        } else if (this.fWX != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.fWX.update();
        }
    }

    public void bsK() {
        if (!TbadkCoreApplication.isLogin()) {
            bsL();
        } else if (this.fWX != null) {
            this.fWX.bsR();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fWX != null) {
            this.fWX.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fWY != null) {
                this.fWY.onChangeSkinType(i);
            }
            if (this.dhX != null) {
                this.dhX.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.fWT != null) {
                this.fWT.iP(i);
            }
            if (this.dlX != null) {
                this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
                this.dlX.iP(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.fWV.onChangeSkinType(i);
            al.l(this, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bsM();
    }

    public void ay(String str, int i) {
        if (this.dlX != null) {
            this.dlX.ajz();
            this.dlX.iQ(0);
        }
        this.fWX.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.fWX != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.fWX.update();
                    }
                }
            });
        }
        this.refreshView.kE(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.qx(str);
        this.refreshView.attachView(view, z);
        this.refreshView.asB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHH() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z, boolean z2) {
        if (this.dhX != null) {
            this.dhX.dettachView(this);
            this.dhX = null;
            this.fWU.setNextPage(this.dlX);
        }
        if (this.fWW != null) {
            this.fWW.M(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beD() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bsL() {
        if (this.fWY == null) {
            this.fWY = new ConcernNotLoginLayout(getContext());
            this.fWY.onChangeSkinType(this.mSkinType);
        }
        if (this.fWY.getParent() == null) {
            this.fXc.setVisibility(8);
            this.fWY.setVisibility(0);
            addView(this.fWY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.dhX == null) {
            if (i < 0) {
                this.dhX = new g(getContext());
            } else {
                this.dhX = new g(getContext(), i);
            }
            this.dhX.onChangeSkinType();
        }
        this.dhX.attachView(this, z);
        this.fWU.setNextPage(null);
        if (this.fXc != null) {
            this.fXc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds160);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.ds320), dimensionPixelSize2), NoDataViewFactory.d.ac(R.string.no_context_text_click_refresh, getResources().getDimensionPixelSize(R.dimen.tbds50)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getResources().getString(R.string.refresh), this.bBp)));
            this.mNoDataView.setSubTitleTextSize(l.g(getContext(), R.dimen.fontsize42));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
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
        if (this.fWX != null) {
            this.fWX.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.fWX != null) {
            this.fWX.jS(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.fWX != null) {
            this.fWX.kV(z);
        }
        if (this.fXa != null) {
            this.fXa.b(this.fXb);
            this.fXa.a(this.fXb);
            this.fXb.bsO();
        }
    }

    public void reload() {
        if (this.fWU != null && this.fXc != null) {
            if (this.fWZ && this.fWU.getFirstVisiblePosition() != 0) {
                this.fWZ = false;
                return;
            }
            this.fWU.setSelection(0);
            if (!this.fXc.isRefreshing()) {
                this.fXc.setRefreshing(true);
            }
            if (this.fXb != null) {
                this.fXb.bsO();
            }
        }
    }

    public void onDestroy() {
        if (this.fXa != null) {
            this.fXa.b(this.fXb);
        }
        this.fWU.removeOnScrollListener(this.mOnScrollListener);
        this.fWX.a((c.a) null);
        this.fWT.setListPullRefreshListener(null);
        this.fWT.a((h.d) null);
        this.fWU.setOnSrollToBottomListener(null);
        this.fWT.a((h.b) null);
        this.fWT.release();
        this.fWU.setRecyclerListener(null);
    }

    public void bsM() {
        if (this.fWV != null) {
            this.fWV.notifyDataSetChanged();
        }
    }

    public void bsN() {
        if (this.fWX != null) {
            this.fWX.jS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHq() {
        if (this.dlX != null && !this.dlX.pu()) {
            this.dlX.ajy();
            this.dlX.iQ(0);
        }
        this.fWX.aHq();
    }

    public void blk() {
        if (this.fWV != null) {
            List<m> dataList = this.fWV.getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bIf != 0 && kVar.threadData != null) {
                            int[] afo = kVar.threadData.afo();
                            kVar.bIf = afo[0];
                            kVar.bIg = afo[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.fWV != null) {
                            ConcernPageView.this.fWV.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
