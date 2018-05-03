package com.baidu.tieba.homepage.concern;

import android.content.Context;
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
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernPageView extends FrameLayout {
    private f bha;
    private PbListView blb;
    private View cYV;
    private CustomMessageListener dAA;
    private BdTypeListView dAe;
    private com.baidu.tieba.homepage.concern.a dAt;
    private a dAu;
    private b dAv;
    private ConcernNotLoginLayout dAw;
    private boolean dAx;
    private b.a dAy;
    private View.OnClickListener dAz;
    private com.baidu.tbadk.core.view.f mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void mF(String str);

        void onPullToRefresh();

        void y(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.dAe != null) {
            this.dAe.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dAt != null) {
            this.dAt.setPageUniqueId(bdUniqueId);
        }
        if (this.dAv != null) {
            this.dAv.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dAA != null) {
            this.dAA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dAA);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.dAx = false;
        this.mSkinType = 3;
        this.dAy = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void axh() {
                if (ConcernPageView.this.dAu == null) {
                    if (ConcernPageView.this.dAw != null) {
                        ConcernPageView.this.dAw.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.w(false, false);
                    return;
                }
                boolean axe = ConcernPageView.this.axe();
                ConcernPageView.this.Qn();
                if (axe) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dAu.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void mE(String str) {
                if (ConcernPageView.this.dAu != null) {
                    ConcernPageView.this.dAu.mF(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.w(false, false);
                if (i == 1) {
                    if (ConcernPageView.this.dAv != null) {
                        ConcernPageView.this.gn(ConcernPageView.this.dAv.hasMore());
                    }
                    if (j.gP()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dAe.setVisibility(8);
                if (ConcernPageView.this.dAw != null) {
                    ConcernPageView.this.dAw.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dAv != null) {
                    ConcernPageView.this.gn(ConcernPageView.this.dAv.hasMore());
                }
                ConcernPageView.this.dAe.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.Qn();
            }
        };
        this.dAz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConcernPageView.this.Po();
            }
        };
        this.dAA = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dAx = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAx = false;
        this.mSkinType = 3;
        this.dAy = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void axh() {
                if (ConcernPageView.this.dAu == null) {
                    if (ConcernPageView.this.dAw != null) {
                        ConcernPageView.this.dAw.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.w(false, false);
                    return;
                }
                boolean axe = ConcernPageView.this.axe();
                ConcernPageView.this.Qn();
                if (axe) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dAu.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void mE(String str) {
                if (ConcernPageView.this.dAu != null) {
                    ConcernPageView.this.dAu.mF(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.w(false, false);
                if (i == 1) {
                    if (ConcernPageView.this.dAv != null) {
                        ConcernPageView.this.gn(ConcernPageView.this.dAv.hasMore());
                    }
                    if (j.gP()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dAe.setVisibility(8);
                if (ConcernPageView.this.dAw != null) {
                    ConcernPageView.this.dAw.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dAv != null) {
                    ConcernPageView.this.gn(ConcernPageView.this.dAv.hasMore());
                }
                ConcernPageView.this.dAe.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.Qn();
            }
        };
        this.dAz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConcernPageView.this.Po();
            }
        };
        this.dAA = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dAx = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dAx = false;
        this.mSkinType = 3;
        this.dAy = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void axh() {
                if (ConcernPageView.this.dAu == null) {
                    if (ConcernPageView.this.dAw != null) {
                        ConcernPageView.this.dAw.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.w(false, false);
                    return;
                }
                boolean axe = ConcernPageView.this.axe();
                ConcernPageView.this.Qn();
                if (axe) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dAu.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void mE(String str) {
                if (ConcernPageView.this.dAu != null) {
                    ConcernPageView.this.dAu.mF(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.w(false, false);
                if (i2 == 1) {
                    if (ConcernPageView.this.dAv != null) {
                        ConcernPageView.this.gn(ConcernPageView.this.dAv.hasMore());
                    }
                    if (j.gP()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dAe.setVisibility(8);
                if (ConcernPageView.this.dAw != null) {
                    ConcernPageView.this.dAw.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dAv != null) {
                    ConcernPageView.this.gn(ConcernPageView.this.dAv.hasMore());
                }
                ConcernPageView.this.dAe.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.Qn();
            }
        };
        this.dAz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConcernPageView.this.Po();
            }
        };
        this.dAA = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dAx = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dAe = new BdTypeListView(context);
        this.dAe.setDividerHeight(0);
        this.dAe.setSelector(17170445);
        this.blb = new PbListView(context);
        this.blb.getView();
        this.blb.du(d.C0126d.cp_bg_line_e);
        this.blb.setHeight(l.e(context, d.e.tbds182));
        this.blb.wO();
        this.blb.setTextSize(d.e.tbfontsize33);
        this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blb.dt(d.C0126d.cp_cont_e);
        this.blb.setOnClickListener(this.dAz);
        this.dAe.setNextPage(this.blb);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        this.mPullView = new com.baidu.tbadk.core.view.f(this.pageContext);
        this.dAe.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.cYV = BdListViewHelper.a(context, this.dAe, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dAt = new com.baidu.tieba.homepage.concern.a(context, this.dAe);
        this.dAv = new b(this.pageContext, this.dAe, this.dAt);
        addView(this.dAe);
        this.dAe.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.cYV != null && this.cYV.getLayoutParams() != null) {
            this.cYV.getLayoutParams().height = i;
            this.cYV.setLayoutParams(this.cYV.getLayoutParams());
        }
    }

    public void asV() {
        this.dAv.a(this.dAy);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.MH().hX("page_concern");
                    ConcernPageView.this.dAv.update();
                }
            }
        });
        this.dAe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.Po();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gn(boolean z) {
        if (this.blb != null) {
            if (z) {
                this.blb.wU();
                this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.blb.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dAu = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.blb != null) {
            this.blb.wS();
            this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dAv.a(z, dataRes, 0, null);
    }

    public void axc() {
        if (!TbadkCoreApplication.isLogin()) {
            axf();
        } else if (this.dAv != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dAv.update();
        }
    }

    public void axd() {
        if (!TbadkCoreApplication.isLogin()) {
            axf();
        } else if (this.dAv != null) {
            this.dAv.axi();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dAv != null) {
            this.dAv.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dAw != null) {
                this.dAw.onChangeSkinType(i);
            }
            if (this.bha != null) {
                this.bha.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dv(i);
            }
            if (this.blb != null) {
                this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
                this.blb.dv(i);
            }
            this.dAt.onChangeSkinType(i);
            ak.j(this, d.C0126d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void Y(String str, int i) {
        if (this.blb != null) {
            this.blb.wS();
            this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dAv.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view2, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (ConcernPageView.this.dAv != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.dAv.update();
                    }
                }
            });
        }
        this.refreshView.fa(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.d(view2, z);
        this.refreshView.Fu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qn() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        if (this.bha != null) {
            this.bha.P(this);
            this.bha = null;
            this.dAe.setNextPage(this.blb);
        }
        if (this.dAu != null) {
            this.dAu.y(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axe() {
        if (this.refreshView != null) {
            return this.refreshView.Fm();
        }
        return false;
    }

    private void axf() {
        if (this.dAw == null) {
            this.dAw = new ConcernNotLoginLayout(getContext());
            this.dAw.onChangeSkinType(this.mSkinType);
        }
        if (this.dAw.getParent() == null) {
            this.dAe.setVisibility(8);
            this.dAw.setVisibility(0);
            addView(this.dAw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bha == null) {
            if (i < 0) {
                this.bha = new f(getContext());
            } else {
                this.bha = new f(getContext(), i);
            }
            this.bha.onChangeSkinType();
        }
        this.bha.d(this, z);
        this.dAe.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dAv != null) {
            this.dAv.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dAv != null) {
            this.dAv.fx(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dAv != null) {
            this.dAv.go(z);
        }
    }

    public void reload() {
        if (this.dAe != null) {
            if (this.dAx && this.dAe.getFirstVisiblePosition() != 0) {
                this.dAx = false;
                return;
            }
            this.dAe.setSelection(0);
            if (this.dAe.isRefreshDone()) {
                this.dAe.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dAv.a((b.a) null);
        this.mPullView.a((e.b) null);
        this.mPullView.a((e.c) null);
        this.dAe.setOnSrollToBottomListener(null);
        this.mPullView.a((e.a) null);
        this.mPullView.release();
        this.dAe.setRecyclerListener(null);
    }

    public void axg() {
        if (this.dAv != null) {
            this.dAv.fx(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        if (this.blb != null && !this.blb.wX()) {
            this.blb.wR();
            this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dAv.Po();
    }
}
