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
    private f bhf;
    private PbListView blq;
    private com.baidu.tieba.homepage.concern.a dBA;
    private a dBB;
    private b dBC;
    private ConcernNotLoginLayout dBD;
    private boolean dBE;
    private b.a dBF;
    private View.OnClickListener dBG;
    private CustomMessageListener dBH;
    private BdTypeListView dBl;
    private View dac;
    private com.baidu.tbadk.core.view.f mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void mI(String str);

        void onPullToRefresh();

        void y(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.dBl != null) {
            this.dBl.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dBA != null) {
            this.dBA.setPageUniqueId(bdUniqueId);
        }
        if (this.dBC != null) {
            this.dBC.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dBH != null) {
            this.dBH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dBH);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.dBE = false;
        this.mSkinType = 3;
        this.dBF = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void axg() {
                if (ConcernPageView.this.dBB == null) {
                    if (ConcernPageView.this.dBD != null) {
                        ConcernPageView.this.dBD.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.w(false, false);
                    return;
                }
                boolean axd = ConcernPageView.this.axd();
                ConcernPageView.this.Qk();
                if (axd) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dBB.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void mH(String str) {
                if (ConcernPageView.this.dBB != null) {
                    ConcernPageView.this.dBB.mI(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.w(false, false);
                if (i == 1) {
                    if (ConcernPageView.this.dBC != null) {
                        ConcernPageView.this.go(ConcernPageView.this.dBC.hasMore());
                    }
                    if (j.gP()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dBl.setVisibility(8);
                if (ConcernPageView.this.dBD != null) {
                    ConcernPageView.this.dBD.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dBC != null) {
                    ConcernPageView.this.go(ConcernPageView.this.dBC.hasMore());
                }
                ConcernPageView.this.dBl.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.Qk();
            }
        };
        this.dBG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConcernPageView.this.Pl();
            }
        };
        this.dBH = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dBE = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dBE = false;
        this.mSkinType = 3;
        this.dBF = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void axg() {
                if (ConcernPageView.this.dBB == null) {
                    if (ConcernPageView.this.dBD != null) {
                        ConcernPageView.this.dBD.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.w(false, false);
                    return;
                }
                boolean axd = ConcernPageView.this.axd();
                ConcernPageView.this.Qk();
                if (axd) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dBB.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void mH(String str) {
                if (ConcernPageView.this.dBB != null) {
                    ConcernPageView.this.dBB.mI(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.w(false, false);
                if (i == 1) {
                    if (ConcernPageView.this.dBC != null) {
                        ConcernPageView.this.go(ConcernPageView.this.dBC.hasMore());
                    }
                    if (j.gP()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dBl.setVisibility(8);
                if (ConcernPageView.this.dBD != null) {
                    ConcernPageView.this.dBD.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dBC != null) {
                    ConcernPageView.this.go(ConcernPageView.this.dBC.hasMore());
                }
                ConcernPageView.this.dBl.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.Qk();
            }
        };
        this.dBG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConcernPageView.this.Pl();
            }
        };
        this.dBH = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dBE = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dBE = false;
        this.mSkinType = 3;
        this.dBF = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void axg() {
                if (ConcernPageView.this.dBB == null) {
                    if (ConcernPageView.this.dBD != null) {
                        ConcernPageView.this.dBD.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.w(false, false);
                    return;
                }
                boolean axd = ConcernPageView.this.axd();
                ConcernPageView.this.Qk();
                if (axd) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dBB.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void mH(String str) {
                if (ConcernPageView.this.dBB != null) {
                    ConcernPageView.this.dBB.mI(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.w(false, false);
                if (i2 == 1) {
                    if (ConcernPageView.this.dBC != null) {
                        ConcernPageView.this.go(ConcernPageView.this.dBC.hasMore());
                    }
                    if (j.gP()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dBl.setVisibility(8);
                if (ConcernPageView.this.dBD != null) {
                    ConcernPageView.this.dBD.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void x(boolean z, boolean z2) {
                if (ConcernPageView.this.dBC != null) {
                    ConcernPageView.this.go(ConcernPageView.this.dBC.hasMore());
                }
                ConcernPageView.this.dBl.setVisibility(0);
                ConcernPageView.this.w(z, z2);
                ConcernPageView.this.Qk();
            }
        };
        this.dBG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConcernPageView.this.Pl();
            }
        };
        this.dBH = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dBE = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dBl = new BdTypeListView(context);
        this.dBl.setDividerHeight(0);
        this.dBl.setSelector(17170445);
        this.blq = new PbListView(context);
        this.blq.getView();
        this.blq.dv(d.C0126d.cp_bg_line_e);
        this.blq.setHeight(l.e(context, d.e.tbds182));
        this.blq.wN();
        this.blq.setTextSize(d.e.tbfontsize33);
        this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blq.du(d.C0126d.cp_cont_e);
        this.blq.setOnClickListener(this.dBG);
        this.dBl.setNextPage(this.blq);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        this.mPullView = new com.baidu.tbadk.core.view.f(this.pageContext);
        this.dBl.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dac = BdListViewHelper.a(context, this.dBl, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dBA = new com.baidu.tieba.homepage.concern.a(context, this.dBl);
        this.dBC = new b(this.pageContext, this.dBl, this.dBA);
        addView(this.dBl);
        this.dBl.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dac != null && this.dac.getLayoutParams() != null) {
            this.dac.getLayoutParams().height = i;
            this.dac.setLayoutParams(this.dac.getLayoutParams());
        }
    }

    public void asU() {
        this.dBC.a(this.dBF);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.MF().hY("page_concern");
                    ConcernPageView.this.dBC.update();
                }
            }
        });
        this.dBl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.Pl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void go(boolean z) {
        if (this.blq != null) {
            if (z) {
                this.blq.wT();
                this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.blq.dy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dBB = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.blq != null) {
            this.blq.wR();
            this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dBC.a(z, dataRes, 0, null);
    }

    public void axb() {
        if (!TbadkCoreApplication.isLogin()) {
            axe();
        } else if (this.dBC != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dBC.update();
        }
    }

    public void axc() {
        if (!TbadkCoreApplication.isLogin()) {
            axe();
        } else if (this.dBC != null) {
            this.dBC.axh();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dBC != null) {
            this.dBC.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dBD != null) {
                this.dBD.onChangeSkinType(i);
            }
            if (this.bhf != null) {
                this.bhf.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dw(i);
            }
            if (this.blq != null) {
                this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
                this.blq.dw(i);
            }
            this.dBA.onChangeSkinType(i);
            ak.j(this, d.C0126d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void Y(String str, int i) {
        if (this.blq != null) {
            this.blq.wR();
            this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dBC.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view2, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (ConcernPageView.this.dBC != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.dBC.update();
                    }
                }
            });
        }
        this.refreshView.fb(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.d(view2, z);
        this.refreshView.Fs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qk() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        if (this.bhf != null) {
            this.bhf.P(this);
            this.bhf = null;
            this.dBl.setNextPage(this.blq);
        }
        if (this.dBB != null) {
            this.dBB.y(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axd() {
        if (this.refreshView != null) {
            return this.refreshView.Fk();
        }
        return false;
    }

    private void axe() {
        if (this.dBD == null) {
            this.dBD = new ConcernNotLoginLayout(getContext());
            this.dBD.onChangeSkinType(this.mSkinType);
        }
        if (this.dBD.getParent() == null) {
            this.dBl.setVisibility(8);
            this.dBD.setVisibility(0);
            addView(this.dBD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bhf == null) {
            if (i < 0) {
                this.bhf = new f(getContext());
            } else {
                this.bhf = new f(getContext(), i);
            }
            this.bhf.onChangeSkinType();
        }
        this.bhf.d(this, z);
        this.dBl.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dBC != null) {
            this.dBC.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dBC != null) {
            this.dBC.fy(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dBC != null) {
            this.dBC.gp(z);
        }
    }

    public void reload() {
        if (this.dBl != null) {
            if (this.dBE && this.dBl.getFirstVisiblePosition() != 0) {
                this.dBE = false;
                return;
            }
            this.dBl.setSelection(0);
            if (this.dBl.isRefreshDone()) {
                this.dBl.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dBC.a((b.a) null);
        this.mPullView.a((e.b) null);
        this.mPullView.a((e.c) null);
        this.dBl.setOnSrollToBottomListener(null);
        this.mPullView.a((e.a) null);
        this.mPullView.release();
        this.dBl.setRecyclerListener(null);
    }

    public void axf() {
        if (this.dBC != null) {
            this.dBC.fy(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pl() {
        if (this.blq != null && !this.blq.wW()) {
            this.blq.wQ();
            this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dBC.Pl();
    }
}
