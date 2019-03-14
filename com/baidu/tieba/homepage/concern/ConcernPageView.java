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
    private int aIL;
    private g cXm;
    private PbListView dbn;
    private BdTypeListView fFN;
    private com.baidu.tieba.homepage.concern.a fGc;
    private a fGd;
    private b fGe;
    private ConcernNotLoginLayout fGf;
    private View fGg;
    private boolean fGh;
    private b.a fGi;
    private View.OnClickListener fGj;
    private CustomMessageListener fGk;
    private NoDataView mNoDataView;
    private i mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void N(boolean z, boolean z2);

        void onPullToRefresh();

        void wb(String str);
    }

    public void completePullRefresh() {
        if (this.fFN != null) {
            this.fFN.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fGc != null) {
            this.fGc.setPageUniqueId(bdUniqueId);
        }
        if (this.fGe != null) {
            this.fGe.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fGk != null) {
            this.fGk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fGk);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.fGh = false;
        this.mSkinType = 3;
        this.fGi = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void blu() {
                if (ConcernPageView.this.fGd == null) {
                    if (ConcernPageView.this.fGf != null) {
                        ConcernPageView.this.fGf.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.L(false, false);
                    return;
                }
                boolean aXr = ConcernPageView.this.aXr();
                ConcernPageView.this.aBt();
                if (aXr) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.fGd.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void wa(String str) {
                if (ConcernPageView.this.fGd != null) {
                    ConcernPageView.this.fGd.wb(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void M(boolean z, boolean z2) {
                if (ConcernPageView.this.fGe != null) {
                    ConcernPageView.this.kf(ConcernPageView.this.fGe.hasMore());
                }
                ConcernPageView.this.fFN.setVisibility(0);
                ConcernPageView.this.L(z, z2);
                ConcernPageView.this.aBt();
                ConcernPageView.this.hideNoDataView();
            }
        };
        this.fGj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aBc();
            }
        };
        this.fGk = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fGh = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGh = false;
        this.mSkinType = 3;
        this.fGi = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void blu() {
                if (ConcernPageView.this.fGd == null) {
                    if (ConcernPageView.this.fGf != null) {
                        ConcernPageView.this.fGf.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.L(false, false);
                    return;
                }
                boolean aXr = ConcernPageView.this.aXr();
                ConcernPageView.this.aBt();
                if (aXr) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.fGd.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void wa(String str) {
                if (ConcernPageView.this.fGd != null) {
                    ConcernPageView.this.fGd.wb(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void M(boolean z, boolean z2) {
                if (ConcernPageView.this.fGe != null) {
                    ConcernPageView.this.kf(ConcernPageView.this.fGe.hasMore());
                }
                ConcernPageView.this.fFN.setVisibility(0);
                ConcernPageView.this.L(z, z2);
                ConcernPageView.this.aBt();
                ConcernPageView.this.hideNoDataView();
            }
        };
        this.fGj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aBc();
            }
        };
        this.fGk = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fGh = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGh = false;
        this.mSkinType = 3;
        this.fGi = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void blu() {
                if (ConcernPageView.this.fGd == null) {
                    if (ConcernPageView.this.fGf != null) {
                        ConcernPageView.this.fGf.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.L(false, false);
                    return;
                }
                boolean aXr = ConcernPageView.this.aXr();
                ConcernPageView.this.aBt();
                if (aXr) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.fGd.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void wa(String str) {
                if (ConcernPageView.this.fGd != null) {
                    ConcernPageView.this.fGd.wb(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void M(boolean z, boolean z2) {
                if (ConcernPageView.this.fGe != null) {
                    ConcernPageView.this.kf(ConcernPageView.this.fGe.hasMore());
                }
                ConcernPageView.this.fFN.setVisibility(0);
                ConcernPageView.this.L(z, z2);
                ConcernPageView.this.aBt();
                ConcernPageView.this.hideNoDataView();
            }
        };
        this.fGj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aBc();
            }
        };
        this.fGk = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fGh = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fFN = new BdTypeListView(context);
        this.fFN.setDividerHeight(0);
        this.fFN.setSelector(17170445);
        this.dbn = new PbListView(context);
        this.dbn.getView();
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.setHeight(l.h(context, d.e.tbds182));
        this.dbn.aez();
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.dbn.setOnClickListener(this.fGj);
        this.fFN.setNextPage(this.dbn);
        e<?> aK = com.baidu.adp.base.i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new i(this.pageContext);
        this.fFN.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.fGg = BdListViewHelper.a(context, this.fFN, BdListViewHelper.HeadType.DEFAULT);
        }
        this.fGc = new com.baidu.tieba.homepage.concern.a(context, this.fFN);
        this.fGe = new b(this.pageContext, this.fFN, this.fGc);
        addView(this.fFN);
        this.fFN.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.fGg != null && this.fGg.getLayoutParams() != null) {
            this.fGg.getLayoutParams().height = i;
            this.fGg.setLayoutParams(this.fGg.getLayoutParams());
        }
        this.aIL = i;
    }

    public void bgA() {
        this.fGe.a(this.fGi);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.awk().qK("page_concern");
                    ConcernPageView.this.fGe.update();
                }
            }
        });
        this.fFN.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aBc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(boolean z) {
        if (this.dbn != null) {
            if (z) {
                this.dbn.aeF();
                this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.dbn.ie(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.fGd = aVar;
    }

    public void blr() {
        if (!TbadkCoreApplication.isLogin()) {
            bls();
        } else if (this.fGe != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.fGe.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fGe != null) {
            this.fGe.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fGf != null) {
                this.fGf.onChangeSkinType(i);
            }
            if (this.cXm != null) {
                this.cXm.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ic(i);
            }
            if (this.dbn != null) {
                this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
                this.dbn.ic(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(d.C0277d.cp_cont_b);
            }
            this.fGc.onChangeSkinType(i);
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
                    if (ConcernPageView.this.fGe != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.fGe.update();
                    }
                }
            });
        }
        this.refreshView.jR(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.po(str);
        this.refreshView.attachView(view, z);
        this.refreshView.anB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z, boolean z2) {
        if (this.cXm != null) {
            this.cXm.dettachView(this);
            this.cXm = null;
            this.fFN.setNextPage(this.dbn);
        }
        if (this.fGd != null) {
            this.fGd.N(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXr() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bls() {
        if (this.fGf == null) {
            this.fGf = new ConcernNotLoginLayout(getContext());
            this.fGf.onChangeSkinType(this.mSkinType);
        }
        if (this.fGf.getParent() == null) {
            this.fFN.setVisibility(8);
            this.fGf.setVisibility(0);
            addView(this.fGf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.cXm == null) {
            if (i < 0) {
                this.cXm = new g(getContext());
            } else {
                this.cXm = new g(getContext(), i);
            }
            this.cXm.onChangeSkinType();
        }
        this.cXm.attachView(this, z);
        this.fFN.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.fGe != null) {
            this.fGe.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.fGe != null) {
            this.fGe.ji(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.fGe != null) {
            this.fGe.kg(z);
        }
    }

    public void reload() {
        if (this.fFN != null) {
            if (this.fGh && this.fFN.getFirstVisiblePosition() != 0) {
                this.fGh = false;
                return;
            }
            this.fFN.setSelection(0);
            if (this.fFN.isRefreshDone()) {
                this.fFN.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.fGe.a((b.a) null);
        this.mPullView.setListPullRefreshListener(null);
        this.mPullView.a((h.d) null);
        this.fFN.setOnSrollToBottomListener(null);
        this.mPullView.a((h.b) null);
        this.mPullView.release();
        this.fFN.setRecyclerListener(null);
    }

    public void blt() {
        if (this.fGe != null) {
            this.fGe.ji(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBc() {
        if (this.dbn != null && !this.dbn.qz()) {
            this.dbn.aeC();
            this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fGe.aBc();
    }
}
