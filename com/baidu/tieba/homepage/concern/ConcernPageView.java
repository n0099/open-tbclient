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
    private int aIK;
    private g cXq;
    private PbListView dbr;
    private BdTypeListView fFO;
    private com.baidu.tieba.homepage.concern.a fGd;
    private a fGe;
    private b fGf;
    private ConcernNotLoginLayout fGg;
    private View fGh;
    private boolean fGi;
    private b.a fGj;
    private View.OnClickListener fGk;
    private CustomMessageListener fGl;
    private NoDataView mNoDataView;
    private i mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void N(boolean z, boolean z2);

        void onPullToRefresh();

        void wd(String str);
    }

    public void completePullRefresh() {
        if (this.fFO != null) {
            this.fFO.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fGd != null) {
            this.fGd.setPageUniqueId(bdUniqueId);
        }
        if (this.fGf != null) {
            this.fGf.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fGl != null) {
            this.fGl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fGl);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.fGi = false;
        this.mSkinType = 3;
        this.fGj = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void blv() {
                if (ConcernPageView.this.fGe == null) {
                    if (ConcernPageView.this.fGg != null) {
                        ConcernPageView.this.fGg.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.L(false, false);
                    return;
                }
                boolean aXs = ConcernPageView.this.aXs();
                ConcernPageView.this.aBu();
                if (aXs) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.fGe.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void wc(String str) {
                if (ConcernPageView.this.fGe != null) {
                    ConcernPageView.this.fGe.wd(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void M(boolean z, boolean z2) {
                if (ConcernPageView.this.fGf != null) {
                    ConcernPageView.this.kf(ConcernPageView.this.fGf.hasMore());
                }
                ConcernPageView.this.fFO.setVisibility(0);
                ConcernPageView.this.L(z, z2);
                ConcernPageView.this.aBu();
                ConcernPageView.this.hideNoDataView();
            }
        };
        this.fGk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aBd();
            }
        };
        this.fGl = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fGi = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGi = false;
        this.mSkinType = 3;
        this.fGj = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void blv() {
                if (ConcernPageView.this.fGe == null) {
                    if (ConcernPageView.this.fGg != null) {
                        ConcernPageView.this.fGg.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.L(false, false);
                    return;
                }
                boolean aXs = ConcernPageView.this.aXs();
                ConcernPageView.this.aBu();
                if (aXs) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.fGe.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void wc(String str) {
                if (ConcernPageView.this.fGe != null) {
                    ConcernPageView.this.fGe.wd(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void M(boolean z, boolean z2) {
                if (ConcernPageView.this.fGf != null) {
                    ConcernPageView.this.kf(ConcernPageView.this.fGf.hasMore());
                }
                ConcernPageView.this.fFO.setVisibility(0);
                ConcernPageView.this.L(z, z2);
                ConcernPageView.this.aBu();
                ConcernPageView.this.hideNoDataView();
            }
        };
        this.fGk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aBd();
            }
        };
        this.fGl = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fGi = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGi = false;
        this.mSkinType = 3;
        this.fGj = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void blv() {
                if (ConcernPageView.this.fGe == null) {
                    if (ConcernPageView.this.fGg != null) {
                        ConcernPageView.this.fGg.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.L(false, false);
                    return;
                }
                boolean aXs = ConcernPageView.this.aXs();
                ConcernPageView.this.aBu();
                if (aXs) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.fGe.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void wc(String str) {
                if (ConcernPageView.this.fGe != null) {
                    ConcernPageView.this.fGe.wd(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void M(boolean z, boolean z2) {
                if (ConcernPageView.this.fGf != null) {
                    ConcernPageView.this.kf(ConcernPageView.this.fGf.hasMore());
                }
                ConcernPageView.this.fFO.setVisibility(0);
                ConcernPageView.this.L(z, z2);
                ConcernPageView.this.aBu();
                ConcernPageView.this.hideNoDataView();
            }
        };
        this.fGk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aBd();
            }
        };
        this.fGl = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fGi = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fFO = new BdTypeListView(context);
        this.fFO.setDividerHeight(0);
        this.fFO.setSelector(17170445);
        this.dbr = new PbListView(context);
        this.dbr.getView();
        this.dbr.ib(d.C0236d.cp_bg_line_e);
        this.dbr.setHeight(l.h(context, d.e.tbds182));
        this.dbr.aez();
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
        this.dbr.ia(d.C0236d.cp_cont_e);
        this.dbr.setOnClickListener(this.fGk);
        this.fFO.setNextPage(this.dbr);
        e<?> aK = com.baidu.adp.base.i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new i(this.pageContext);
        this.fFO.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.fGh = BdListViewHelper.a(context, this.fFO, BdListViewHelper.HeadType.DEFAULT);
        }
        this.fGd = new com.baidu.tieba.homepage.concern.a(context, this.fFO);
        this.fGf = new b(this.pageContext, this.fFO, this.fGd);
        addView(this.fFO);
        this.fFO.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.fGh != null && this.fGh.getLayoutParams() != null) {
            this.fGh.getLayoutParams().height = i;
            this.fGh.setLayoutParams(this.fGh.getLayoutParams());
        }
        this.aIK = i;
    }

    public void bgB() {
        this.fGf.a(this.fGj);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.awl().qM("page_concern");
                    ConcernPageView.this.fGf.update();
                }
            }
        });
        this.fFO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aBd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(boolean z) {
        if (this.dbr != null) {
            if (z) {
                this.dbr.aeF();
                this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.dbr.ie(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.fGe = aVar;
    }

    public void bls() {
        if (!TbadkCoreApplication.isLogin()) {
            blt();
        } else if (this.fGf != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.fGf.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fGf != null) {
            this.fGf.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fGg != null) {
                this.fGg.onChangeSkinType(i);
            }
            if (this.cXq != null) {
                this.cXq.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ic(i);
            }
            if (this.dbr != null) {
                this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_d));
                this.dbr.ic(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(d.C0236d.cp_cont_b);
            }
            this.fGd.onChangeSkinType(i);
            al.l(this, d.C0236d.cp_bg_line_d);
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
                    if (ConcernPageView.this.fGf != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.fGf.update();
                    }
                }
            });
        }
        this.refreshView.jR(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.po(str);
        this.refreshView.attachView(view, z);
        this.refreshView.anC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z, boolean z2) {
        if (this.cXq != null) {
            this.cXq.dettachView(this);
            this.cXq = null;
            this.fFO.setNextPage(this.dbr);
        }
        if (this.fGe != null) {
            this.fGe.N(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void blt() {
        if (this.fGg == null) {
            this.fGg = new ConcernNotLoginLayout(getContext());
            this.fGg.onChangeSkinType(this.mSkinType);
        }
        if (this.fGg.getParent() == null) {
            this.fFO.setVisibility(8);
            this.fGg.setVisibility(0);
            addView(this.fGg);
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
        this.fFO.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.fGf != null) {
            this.fGf.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.fGf != null) {
            this.fGf.ji(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.fGf != null) {
            this.fGf.kg(z);
        }
    }

    public void reload() {
        if (this.fFO != null) {
            if (this.fGi && this.fFO.getFirstVisiblePosition() != 0) {
                this.fGi = false;
                return;
            }
            this.fFO.setSelection(0);
            if (this.fFO.isRefreshDone()) {
                this.fFO.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.fGf.a((b.a) null);
        this.mPullView.setListPullRefreshListener(null);
        this.mPullView.a((h.d) null);
        this.fFO.setOnSrollToBottomListener(null);
        this.mPullView.a((h.b) null);
        this.mPullView.release();
        this.fFO.setRecyclerListener(null);
    }

    public void blu() {
        if (this.fGf != null) {
            this.fGf.ji(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBd() {
        if (this.dbr != null && !this.dbr.qz()) {
            this.dbr.aeC();
            this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fGf.aBd();
    }
}
