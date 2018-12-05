package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.a.d;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class ConcernPageView extends FrameLayout {
    private f bKv;
    private PbListView bOy;
    private View dKb;
    private BdTypeListView epS;
    private com.baidu.tieba.homepage.concern.a eqh;
    private a eqi;
    private b eqj;
    private ConcernNotLoginLayout eqk;
    private boolean eql;
    private b.a eqm;
    private View.OnClickListener eqn;
    private CustomMessageListener eqo;
    private int mHeaderViewHeight;
    private NoDataView mNoDataView;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes6.dex */
    public interface a {
        void G(boolean z, boolean z2);

        void onPullToRefresh();

        void pg(String str);
    }

    public void completePullRefresh() {
        if (this.epS != null) {
            this.epS.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eqh != null) {
            this.eqh.setPageUniqueId(bdUniqueId);
        }
        if (this.eqj != null) {
            this.eqj.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.eqo != null) {
            this.eqo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eqo);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.eql = false;
        this.mSkinType = 3;
        this.eqm = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKd() {
                if (ConcernPageView.this.eqi == null) {
                    if (ConcernPageView.this.eqk != null) {
                        ConcernPageView.this.eqk.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aKa = ConcernPageView.this.aKa();
                ConcernPageView.this.aaY();
                if (aKa) {
                    ConcernPageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                ConcernPageView.this.eqi.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void pf(String str) {
                if (ConcernPageView.this.eqi != null) {
                    ConcernPageView.this.eqi.pg(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.eqj != null) {
                        ConcernPageView.this.hI(ConcernPageView.this.eqj.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.epS.setVisibility(8);
                if (ConcernPageView.this.eqk != null) {
                    ConcernPageView.this.eqk.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.eqj != null) {
                    ConcernPageView.this.hI(ConcernPageView.this.eqj.hasMore());
                }
                ConcernPageView.this.epS.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.aaY();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKe() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.aaY();
                if (v.I(ConcernPageView.this.epS.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.eqn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aab();
            }
        };
        this.eqo = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.eql = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eql = false;
        this.mSkinType = 3;
        this.eqm = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKd() {
                if (ConcernPageView.this.eqi == null) {
                    if (ConcernPageView.this.eqk != null) {
                        ConcernPageView.this.eqk.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aKa = ConcernPageView.this.aKa();
                ConcernPageView.this.aaY();
                if (aKa) {
                    ConcernPageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                ConcernPageView.this.eqi.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void pf(String str) {
                if (ConcernPageView.this.eqi != null) {
                    ConcernPageView.this.eqi.pg(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.eqj != null) {
                        ConcernPageView.this.hI(ConcernPageView.this.eqj.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.epS.setVisibility(8);
                if (ConcernPageView.this.eqk != null) {
                    ConcernPageView.this.eqk.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.eqj != null) {
                    ConcernPageView.this.hI(ConcernPageView.this.eqj.hasMore());
                }
                ConcernPageView.this.epS.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.aaY();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKe() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.aaY();
                if (v.I(ConcernPageView.this.epS.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.eqn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aab();
            }
        };
        this.eqo = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.eql = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eql = false;
        this.mSkinType = 3;
        this.eqm = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKd() {
                if (ConcernPageView.this.eqi == null) {
                    if (ConcernPageView.this.eqk != null) {
                        ConcernPageView.this.eqk.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aKa = ConcernPageView.this.aKa();
                ConcernPageView.this.aaY();
                if (aKa) {
                    ConcernPageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                ConcernPageView.this.eqi.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void pf(String str) {
                if (ConcernPageView.this.eqi != null) {
                    ConcernPageView.this.eqi.pg(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.eqj != null) {
                        ConcernPageView.this.hI(ConcernPageView.this.eqj.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.epS.setVisibility(8);
                if (ConcernPageView.this.eqk != null) {
                    ConcernPageView.this.eqk.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.eqj != null) {
                    ConcernPageView.this.hI(ConcernPageView.this.eqj.hasMore());
                }
                ConcernPageView.this.epS.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.aaY();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKe() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.aaY();
                if (v.I(ConcernPageView.this.epS.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.eqn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aab();
            }
        };
        this.eqo = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.eql = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.epS = new BdTypeListView(context);
        this.epS.setDividerHeight(0);
        this.epS.setSelector(17170445);
        this.bOy = new PbListView(context);
        this.bOy.getView();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.setHeight(l.h(context, e.C0210e.tbds182));
        this.bOy.EZ();
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOy.ew(e.d.cp_cont_e);
        this.bOy.setOnClickListener(this.eqn);
        this.epS.setNextPage(this.bOy);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new k(this.pageContext);
        this.epS.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dKb = BdListViewHelper.a(context, this.epS, BdListViewHelper.HeadType.DEFAULT);
        }
        this.eqh = new com.baidu.tieba.homepage.concern.a(context, this.epS);
        this.eqj = new b(this.pageContext, this.epS, this.eqh);
        addView(this.epS);
        this.epS.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dKb != null && this.dKb.getLayoutParams() != null) {
            this.dKb.getLayoutParams().height = i;
            this.dKb.setLayoutParams(this.dKb.getLayoutParams());
        }
        this.mHeaderViewHeight = i;
    }

    public void aEW() {
        this.eqj.a(this.eqm);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.VM().jJ("page_concern");
                    ConcernPageView.this.eqj.update();
                }
            }
        });
        this.epS.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aab();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(boolean z) {
        if (this.bOy != null) {
            if (z) {
                this.bOy.Ff();
                this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bOy.eA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.eqi = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bOy != null) {
            this.bOy.Fd();
            this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eqj.a(z, dataRes, 0, null);
    }

    public void aJY() {
        if (!TbadkCoreApplication.isLogin()) {
            aKb();
        } else if (this.eqj != null) {
            i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
            this.eqj.update();
        }
    }

    public void aJZ() {
        if (!TbadkCoreApplication.isLogin()) {
            aKb();
        } else if (this.eqj != null) {
            this.eqj.aKf();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.eqj != null) {
            this.eqj.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eqk != null) {
                this.eqk.onChangeSkinType(i);
            }
            if (this.bKv != null) {
                this.bKv.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.bOy != null) {
                this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bOy.ey(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
            }
            this.eqh.onChangeSkinType(i);
            al.j(this, e.d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void ag(String str, int i) {
        if (this.bOy != null) {
            this.bOy.Fd();
            this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eqj.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.eqj != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.eqj.update();
                    }
                }
            });
        }
        this.refreshView.gd(getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.in(str);
        this.refreshView.attachView(view, z);
        this.refreshView.NL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaY() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z, boolean z2) {
        if (this.bKv != null) {
            this.bKv.dettachView(this);
            this.bKv = null;
            this.epS.setNextPage(this.bOy);
        }
        if (this.eqi != null) {
            this.eqi.G(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKa() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void aKb() {
        if (this.eqk == null) {
            this.eqk = new ConcernNotLoginLayout(getContext());
            this.eqk.onChangeSkinType(this.mSkinType);
        }
        if (this.eqk.getParent() == null) {
            this.epS.setVisibility(8);
            this.eqk.setVisibility(0);
            addView(this.eqk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bKv == null) {
            if (i < 0) {
                this.bKv = new f(getContext());
            } else {
                this.bKv = new f(getContext(), i);
            }
            this.bKv.onChangeSkinType();
        }
        this.bKv.attachView(this, z);
        this.epS.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.tbds160) + this.mHeaderViewHeight;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0210e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(e.C0210e.ds320), dimensionPixelSize2), NoDataViewFactory.d.G(e.j.no_context_text, getResources().getDimensionPixelSize(e.C0210e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.h(getContext(), e.C0210e.fontsize42));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
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
        if (this.eqj != null) {
            this.eqj.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.eqj != null) {
            this.eqj.gD(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eqj != null) {
            this.eqj.hJ(z);
        }
    }

    public void reload() {
        if (this.epS != null) {
            if (this.eql && this.epS.getFirstVisiblePosition() != 0) {
                this.eql = false;
                return;
            }
            this.epS.setSelection(0);
            if (this.epS.isRefreshDone()) {
                this.epS.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.eqj.a((b.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.epS.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.epS.setRecyclerListener(null);
    }

    public void aKc() {
        if (this.eqj != null) {
            this.eqj.gD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        if (this.bOy != null && !this.bOy.Fi()) {
            this.bOy.Fc();
            this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eqj.aab();
    }
}
