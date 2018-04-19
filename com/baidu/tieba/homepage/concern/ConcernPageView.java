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
    private View cYY;
    private boolean dAA;
    private b.a dAB;
    private View.OnClickListener dAC;
    private CustomMessageListener dAD;
    private BdTypeListView dAh;
    private com.baidu.tieba.homepage.concern.a dAw;
    private a dAx;
    private b dAy;
    private ConcernNotLoginLayout dAz;
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
        if (this.dAh != null) {
            this.dAh.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dAw != null) {
            this.dAw.setPageUniqueId(bdUniqueId);
        }
        if (this.dAy != null) {
            this.dAy.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dAD != null) {
            this.dAD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dAD);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.dAA = false;
        this.mSkinType = 3;
        this.dAB = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void axh() {
                if (ConcernPageView.this.dAx == null) {
                    if (ConcernPageView.this.dAz != null) {
                        ConcernPageView.this.dAz.setVisibility(8);
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
                ConcernPageView.this.dAx.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void mE(String str) {
                if (ConcernPageView.this.dAx != null) {
                    ConcernPageView.this.dAx.mF(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.w(false, false);
                if (i == 1) {
                    if (ConcernPageView.this.dAy != null) {
                        ConcernPageView.this.gn(ConcernPageView.this.dAy.hasMore());
                    }
                    if (j.gP()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dAh.setVisibility(8);
                if (ConcernPageView.this.dAz != null) {
                    ConcernPageView.this.dAz.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dAy != null) {
                    ConcernPageView.this.gn(ConcernPageView.this.dAy.hasMore());
                }
                ConcernPageView.this.dAh.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.Qn();
            }
        };
        this.dAC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConcernPageView.this.Po();
            }
        };
        this.dAD = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dAA = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAA = false;
        this.mSkinType = 3;
        this.dAB = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void axh() {
                if (ConcernPageView.this.dAx == null) {
                    if (ConcernPageView.this.dAz != null) {
                        ConcernPageView.this.dAz.setVisibility(8);
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
                ConcernPageView.this.dAx.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void mE(String str) {
                if (ConcernPageView.this.dAx != null) {
                    ConcernPageView.this.dAx.mF(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.w(false, false);
                if (i == 1) {
                    if (ConcernPageView.this.dAy != null) {
                        ConcernPageView.this.gn(ConcernPageView.this.dAy.hasMore());
                    }
                    if (j.gP()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dAh.setVisibility(8);
                if (ConcernPageView.this.dAz != null) {
                    ConcernPageView.this.dAz.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dAy != null) {
                    ConcernPageView.this.gn(ConcernPageView.this.dAy.hasMore());
                }
                ConcernPageView.this.dAh.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.Qn();
            }
        };
        this.dAC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConcernPageView.this.Po();
            }
        };
        this.dAD = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dAA = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dAA = false;
        this.mSkinType = 3;
        this.dAB = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void axh() {
                if (ConcernPageView.this.dAx == null) {
                    if (ConcernPageView.this.dAz != null) {
                        ConcernPageView.this.dAz.setVisibility(8);
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
                ConcernPageView.this.dAx.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void mE(String str) {
                if (ConcernPageView.this.dAx != null) {
                    ConcernPageView.this.dAx.mF(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.w(false, false);
                if (i2 == 1) {
                    if (ConcernPageView.this.dAy != null) {
                        ConcernPageView.this.gn(ConcernPageView.this.dAy.hasMore());
                    }
                    if (j.gP()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dAh.setVisibility(8);
                if (ConcernPageView.this.dAz != null) {
                    ConcernPageView.this.dAz.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dAy != null) {
                    ConcernPageView.this.gn(ConcernPageView.this.dAy.hasMore());
                }
                ConcernPageView.this.dAh.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.Qn();
            }
        };
        this.dAC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConcernPageView.this.Po();
            }
        };
        this.dAD = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dAA = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dAh = new BdTypeListView(context);
        this.dAh.setDividerHeight(0);
        this.dAh.setSelector(17170445);
        this.blb = new PbListView(context);
        this.blb.getView();
        this.blb.du(d.C0126d.cp_bg_line_e);
        this.blb.setHeight(l.e(context, d.e.tbds182));
        this.blb.wO();
        this.blb.setTextSize(d.e.tbfontsize33);
        this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blb.dt(d.C0126d.cp_cont_e);
        this.blb.setOnClickListener(this.dAC);
        this.dAh.setNextPage(this.blb);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        this.mPullView = new com.baidu.tbadk.core.view.f(this.pageContext);
        this.dAh.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.cYY = BdListViewHelper.a(context, this.dAh, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dAw = new com.baidu.tieba.homepage.concern.a(context, this.dAh);
        this.dAy = new b(this.pageContext, this.dAh, this.dAw);
        addView(this.dAh);
        this.dAh.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.cYY != null && this.cYY.getLayoutParams() != null) {
            this.cYY.getLayoutParams().height = i;
            this.cYY.setLayoutParams(this.cYY.getLayoutParams());
        }
    }

    public void asV() {
        this.dAy.a(this.dAB);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.MH().hX("page_concern");
                    ConcernPageView.this.dAy.update();
                }
            }
        });
        this.dAh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
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
        this.dAx = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.blb != null) {
            this.blb.wS();
            this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dAy.a(z, dataRes, 0, null);
    }

    public void axc() {
        if (!TbadkCoreApplication.isLogin()) {
            axf();
        } else if (this.dAy != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dAy.update();
        }
    }

    public void axd() {
        if (!TbadkCoreApplication.isLogin()) {
            axf();
        } else if (this.dAy != null) {
            this.dAy.axi();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dAy != null) {
            this.dAy.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dAz != null) {
                this.dAz.onChangeSkinType(i);
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
            this.dAw.onChangeSkinType(i);
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
        this.dAy.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view2, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (ConcernPageView.this.dAy != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.dAy.update();
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
            this.dAh.setNextPage(this.blb);
        }
        if (this.dAx != null) {
            this.dAx.y(z, z2);
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
        if (this.dAz == null) {
            this.dAz = new ConcernNotLoginLayout(getContext());
            this.dAz.onChangeSkinType(this.mSkinType);
        }
        if (this.dAz.getParent() == null) {
            this.dAh.setVisibility(8);
            this.dAz.setVisibility(0);
            addView(this.dAz);
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
        this.dAh.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dAy != null) {
            this.dAy.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dAy != null) {
            this.dAy.fx(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dAy != null) {
            this.dAy.go(z);
        }
    }

    public void reload() {
        if (this.dAh != null) {
            if (this.dAA && this.dAh.getFirstVisiblePosition() != 0) {
                this.dAA = false;
                return;
            }
            this.dAh.setSelection(0);
            if (this.dAh.isRefreshDone()) {
                this.dAh.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dAy.a((b.a) null);
        this.mPullView.a((e.b) null);
        this.mPullView.a((e.c) null);
        this.dAh.setOnSrollToBottomListener(null);
        this.mPullView.a((e.a) null);
        this.mPullView.release();
        this.dAh.setRecyclerListener(null);
    }

    public void axg() {
        if (this.dAy != null) {
            this.dAy.fx(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        if (this.blb != null && !this.blb.wX()) {
            this.blb.wR();
            this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dAy.Po();
    }
}
