package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
/* loaded from: classes4.dex */
public class ConcernPageView extends FrameLayout {
    private int aIP;
    private g cXq;
    private PbListView dbs;
    private BdTypeListView fFB;
    private com.baidu.tieba.homepage.concern.a fFQ;
    private a fFR;
    private b fFS;
    private ConcernNotLoginLayout fFT;
    private View fFU;
    private boolean fFV;
    private b.a fFW;
    private View.OnClickListener fFX;
    private CustomMessageListener fFY;
    private NoDataView mNoDataView;
    private i mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void L(boolean z, boolean z2);

        void onPullToRefresh();

        void wa(String str);
    }

    public void completePullRefresh() {
        if (this.fFB != null) {
            this.fFB.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fFQ != null) {
            this.fFQ.setPageUniqueId(bdUniqueId);
        }
        if (this.fFS != null) {
            this.fFS.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fFY != null) {
            this.fFY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fFY);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.fFV = false;
        this.mSkinType = 3;
        this.fFW = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void blr() {
                if (ConcernPageView.this.fFR == null) {
                    if (ConcernPageView.this.fFT != null) {
                        ConcernPageView.this.fFT.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.J(false, false);
                    return;
                }
                boolean aXp = ConcernPageView.this.aXp();
                ConcernPageView.this.aBq();
                if (aXp) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.fFR.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void vZ(String str) {
                if (ConcernPageView.this.fFR != null) {
                    ConcernPageView.this.fFR.wa(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void K(boolean z, boolean z2) {
                if (ConcernPageView.this.fFS != null) {
                    ConcernPageView.this.kf(ConcernPageView.this.fFS.hasMore());
                }
                ConcernPageView.this.fFB.setVisibility(0);
                ConcernPageView.this.J(z, z2);
                ConcernPageView.this.aBq();
                ConcernPageView.this.hideNoDataView();
            }
        };
        this.fFX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aAZ();
            }
        };
        this.fFY = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fFV = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFV = false;
        this.mSkinType = 3;
        this.fFW = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void blr() {
                if (ConcernPageView.this.fFR == null) {
                    if (ConcernPageView.this.fFT != null) {
                        ConcernPageView.this.fFT.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.J(false, false);
                    return;
                }
                boolean aXp = ConcernPageView.this.aXp();
                ConcernPageView.this.aBq();
                if (aXp) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.fFR.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void vZ(String str) {
                if (ConcernPageView.this.fFR != null) {
                    ConcernPageView.this.fFR.wa(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void K(boolean z, boolean z2) {
                if (ConcernPageView.this.fFS != null) {
                    ConcernPageView.this.kf(ConcernPageView.this.fFS.hasMore());
                }
                ConcernPageView.this.fFB.setVisibility(0);
                ConcernPageView.this.J(z, z2);
                ConcernPageView.this.aBq();
                ConcernPageView.this.hideNoDataView();
            }
        };
        this.fFX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aAZ();
            }
        };
        this.fFY = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fFV = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFV = false;
        this.mSkinType = 3;
        this.fFW = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void blr() {
                if (ConcernPageView.this.fFR == null) {
                    if (ConcernPageView.this.fFT != null) {
                        ConcernPageView.this.fFT.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.J(false, false);
                    return;
                }
                boolean aXp = ConcernPageView.this.aXp();
                ConcernPageView.this.aBq();
                if (aXp) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.fFR.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void vZ(String str) {
                if (ConcernPageView.this.fFR != null) {
                    ConcernPageView.this.fFR.wa(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void K(boolean z, boolean z2) {
                if (ConcernPageView.this.fFS != null) {
                    ConcernPageView.this.kf(ConcernPageView.this.fFS.hasMore());
                }
                ConcernPageView.this.fFB.setVisibility(0);
                ConcernPageView.this.J(z, z2);
                ConcernPageView.this.aBq();
                ConcernPageView.this.hideNoDataView();
            }
        };
        this.fFX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aAZ();
            }
        };
        this.fFY = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fFV = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fFB = new BdTypeListView(context);
        this.fFB.setDividerHeight(0);
        this.fFB.setSelector(17170445);
        this.dbs = new PbListView(context);
        this.dbs.getView();
        this.dbs.ia(d.C0277d.cp_bg_line_e);
        this.dbs.setHeight(l.h(context, d.e.tbds182));
        this.dbs.aew();
        this.dbs.setTextSize(d.e.tbfontsize33);
        this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbs.hZ(d.C0277d.cp_cont_e);
        this.dbs.setOnClickListener(this.fFX);
        this.fFB.setNextPage(this.dbs);
        e<?> aK = com.baidu.adp.base.i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new i(this.pageContext);
        this.fFB.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.fFU = BdListViewHelper.a(context, this.fFB, BdListViewHelper.HeadType.DEFAULT);
        }
        this.fFQ = new com.baidu.tieba.homepage.concern.a(context, this.fFB);
        this.fFS = new b(this.pageContext, this.fFB, this.fFQ);
        addView(this.fFB);
        this.fFB.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.fFU != null && this.fFU.getLayoutParams() != null) {
            this.fFU.getLayoutParams().height = i;
            this.fFU.setLayoutParams(this.fFU.getLayoutParams());
        }
        this.aIP = i;
    }

    public void bgy() {
        this.fFS.a(this.fFW);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.awh().qL("page_concern");
                    ConcernPageView.this.fFS.update();
                }
            }
        });
        this.fFB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aAZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(boolean z) {
        if (this.dbs != null) {
            if (z) {
                this.dbs.aeC();
                this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.dbs.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.fFR = aVar;
    }

    public void blo() {
        if (!TbadkCoreApplication.isLogin()) {
            blp();
        } else if (this.fFS != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.fFS.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fFS != null) {
            this.fFS.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fFT != null) {
                this.fFT.onChangeSkinType(i);
            }
            if (this.cXq != null) {
                this.cXq.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ib(i);
            }
            if (this.dbs != null) {
                this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
                this.dbs.ib(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(d.C0277d.cp_cont_b);
            }
            this.fFQ.onChangeSkinType(i);
            al.l(this, d.C0277d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.fFS != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.fFS.update();
                    }
                }
            });
        }
        this.refreshView.jQ(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.pp(str);
        this.refreshView.attachView(view, z);
        this.refreshView.any();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z, boolean z2) {
        if (this.cXq != null) {
            this.cXq.dettachView(this);
            this.cXq = null;
            this.fFB.setNextPage(this.dbs);
        }
        if (this.fFR != null) {
            this.fFR.L(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXp() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void blp() {
        if (this.fFT == null) {
            this.fFT = new ConcernNotLoginLayout(getContext());
            this.fFT.onChangeSkinType(this.mSkinType);
        }
        if (this.fFT.getParent() == null) {
            this.fFB.setVisibility(8);
            this.fFT.setVisibility(0);
            addView(this.fFT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.cXq == null) {
            if (i < 0) {
                this.cXq = new g(getContext());
            } else {
                this.cXq = new g(getContext(), i);
            }
            this.cXq.onChangeSkinType();
        }
        this.cXq.attachView(this, z);
        this.fFB.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.fFS != null) {
            this.fFS.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.fFS != null) {
            this.fFS.ji(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.fFS != null) {
            this.fFS.kg(z);
        }
    }

    public void reload() {
        if (this.fFB != null) {
            if (this.fFV && this.fFB.getFirstVisiblePosition() != 0) {
                this.fFV = false;
                return;
            }
            this.fFB.setSelection(0);
            if (this.fFB.isRefreshDone()) {
                this.fFB.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.fFS.a((b.a) null);
        this.mPullView.setListPullRefreshListener(null);
        this.mPullView.a((h.d) null);
        this.fFB.setOnSrollToBottomListener(null);
        this.mPullView.a((h.b) null);
        this.mPullView.release();
        this.fFB.setRecyclerListener(null);
    }

    public void blq() {
        if (this.fFS != null) {
            this.fFS.ji(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAZ() {
        if (this.dbs != null && !this.dbs.qz()) {
            this.dbs.aez();
            this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fFS.aAZ();
    }
}
