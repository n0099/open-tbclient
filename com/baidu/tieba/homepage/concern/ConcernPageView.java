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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernPageView extends FrameLayout {
    private int auC;
    private f bqL;
    private PbListView buU;
    private BdTypeListView dPL;
    private com.baidu.tieba.homepage.concern.a dQa;
    private a dQb;
    private b dQc;
    private ConcernNotLoginLayout dQd;
    private boolean dQe;
    private b.a dQf;
    private View.OnClickListener dQg;
    private CustomMessageListener dQh;
    private View dlx;
    private NoDataView mNoDataView;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void B(boolean z, boolean z2);

        void nu(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.dPL != null) {
            this.dPL.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dQa != null) {
            this.dQa.setPageUniqueId(bdUniqueId);
        }
        if (this.dQc != null) {
            this.dQc.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dQh != null) {
            this.dQh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dQh);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.dQe = false;
        this.mSkinType = 3;
        this.dQf = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aCE() {
                if (ConcernPageView.this.dQb == null) {
                    if (ConcernPageView.this.dQd != null) {
                        ConcernPageView.this.dQd.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.z(false, false);
                    return;
                }
                boolean aCB = ConcernPageView.this.aCB();
                ConcernPageView.this.Uc();
                if (aCB) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dQb.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nt(String str) {
                if (ConcernPageView.this.dQb != null) {
                    ConcernPageView.this.dQb.nu(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.z(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.dQc != null) {
                        ConcernPageView.this.gE(ConcernPageView.this.dQc.hasMore());
                    }
                    if (j.jD()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dPL.setVisibility(8);
                if (ConcernPageView.this.dQd != null) {
                    ConcernPageView.this.dQd.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void A(boolean z, boolean z2) {
                if (ConcernPageView.this.dQc != null) {
                    ConcernPageView.this.gE(ConcernPageView.this.dQc.hasMore());
                }
                ConcernPageView.this.dPL.setVisibility(0);
                ConcernPageView.this.z(z, z2);
                ConcernPageView.this.Uc();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aCF() {
                ConcernPageView.this.z(true, false);
                ConcernPageView.this.Uc();
                if (w.A(ConcernPageView.this.dPL.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dQg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Tf();
            }
        };
        this.dQh = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dQe = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dQe = false;
        this.mSkinType = 3;
        this.dQf = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aCE() {
                if (ConcernPageView.this.dQb == null) {
                    if (ConcernPageView.this.dQd != null) {
                        ConcernPageView.this.dQd.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.z(false, false);
                    return;
                }
                boolean aCB = ConcernPageView.this.aCB();
                ConcernPageView.this.Uc();
                if (aCB) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dQb.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nt(String str) {
                if (ConcernPageView.this.dQb != null) {
                    ConcernPageView.this.dQb.nu(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.z(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.dQc != null) {
                        ConcernPageView.this.gE(ConcernPageView.this.dQc.hasMore());
                    }
                    if (j.jD()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dPL.setVisibility(8);
                if (ConcernPageView.this.dQd != null) {
                    ConcernPageView.this.dQd.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void A(boolean z, boolean z2) {
                if (ConcernPageView.this.dQc != null) {
                    ConcernPageView.this.gE(ConcernPageView.this.dQc.hasMore());
                }
                ConcernPageView.this.dPL.setVisibility(0);
                ConcernPageView.this.z(z, z2);
                ConcernPageView.this.Uc();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aCF() {
                ConcernPageView.this.z(true, false);
                ConcernPageView.this.Uc();
                if (w.A(ConcernPageView.this.dPL.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dQg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Tf();
            }
        };
        this.dQh = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dQe = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dQe = false;
        this.mSkinType = 3;
        this.dQf = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aCE() {
                if (ConcernPageView.this.dQb == null) {
                    if (ConcernPageView.this.dQd != null) {
                        ConcernPageView.this.dQd.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    ConcernPageView.this.z(false, false);
                    return;
                }
                boolean aCB = ConcernPageView.this.aCB();
                ConcernPageView.this.Uc();
                if (aCB) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dQb.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nt(String str) {
                if (ConcernPageView.this.dQb != null) {
                    ConcernPageView.this.dQb.nu(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.z(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.dQc != null) {
                        ConcernPageView.this.gE(ConcernPageView.this.dQc.hasMore());
                    }
                    if (j.jD()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dPL.setVisibility(8);
                if (ConcernPageView.this.dQd != null) {
                    ConcernPageView.this.dQd.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void A(boolean z, boolean z2) {
                if (ConcernPageView.this.dQc != null) {
                    ConcernPageView.this.gE(ConcernPageView.this.dQc.hasMore());
                }
                ConcernPageView.this.dPL.setVisibility(0);
                ConcernPageView.this.z(z, z2);
                ConcernPageView.this.Uc();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aCF() {
                ConcernPageView.this.z(true, false);
                ConcernPageView.this.Uc();
                if (w.A(ConcernPageView.this.dPL.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dQg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Tf();
            }
        };
        this.dQh = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dQe = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dPL = new BdTypeListView(context);
        this.dPL.setDividerHeight(0);
        this.dPL.setSelector(17170445);
        this.buU = new PbListView(context);
        this.buU.getView();
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.setHeight(l.e(context, d.e.tbds182));
        this.buU.AE();
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
        this.buU.dx(d.C0142d.cp_cont_e);
        this.buU.setOnClickListener(this.dQg);
        this.dPL.setNextPage(this.buU);
        e<?> ad = i.ad(context);
        if (ad instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ad;
        }
        this.mPullView = new h(this.pageContext);
        this.dPL.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dlx = BdListViewHelper.a(context, this.dPL, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dQa = new com.baidu.tieba.homepage.concern.a(context, this.dPL);
        this.dQc = new b(this.pageContext, this.dPL, this.dQa);
        addView(this.dPL);
        this.dPL.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dlx != null && this.dlx.getLayoutParams() != null) {
            this.dlx.getLayoutParams().height = i;
            this.dlx.setLayoutParams(this.dlx.getLayoutParams());
        }
        this.auC = i;
    }

    public void axE() {
        this.dQc.a(this.dQf);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.QB().iC("page_concern");
                    ConcernPageView.this.dQc.update();
                }
            }
        });
        this.dPL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.Tf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(boolean z) {
        if (this.buU != null) {
            if (z) {
                this.buU.AK();
                this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.buU.dB(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dQb = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.buU != null) {
            this.buU.AI();
            this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dQc.a(z, dataRes, 0, null);
    }

    public void aCz() {
        if (!TbadkCoreApplication.isLogin()) {
            aCC();
        } else if (this.dQc != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dQc.update();
        }
    }

    public void aCA() {
        if (!TbadkCoreApplication.isLogin()) {
            aCC();
        } else if (this.dQc != null) {
            this.dQc.aCG();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (this.dQc != null) {
            this.dQc.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dQd != null) {
                this.dQd.onChangeSkinType(i);
            }
            if (this.bqL != null) {
                this.bqL.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.buU != null) {
                this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
                this.buU.dz(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(d.C0142d.cp_cont_b);
            }
            this.dQa.onChangeSkinType(i);
            am.j(this, d.C0142d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void aa(String str, int i) {
        if (this.buU != null) {
            this.buU.AI();
            this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dQc.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.dQc != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.dQc.update();
                    }
                }
            });
        }
        this.refreshView.fg(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.d(view, z);
        this.refreshView.Jp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uc() {
        if (this.refreshView != null) {
            this.refreshView.Q(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        if (this.bqL != null) {
            this.bqL.Q(this);
            this.bqL = null;
            this.dPL.setNextPage(this.buU);
        }
        if (this.dQb != null) {
            this.dQb.B(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCB() {
        if (this.refreshView != null) {
            return this.refreshView.Jh();
        }
        return false;
    }

    private void aCC() {
        if (this.dQd == null) {
            this.dQd = new ConcernNotLoginLayout(getContext());
            this.dQd.onChangeSkinType(this.mSkinType);
        }
        if (this.dQd.getParent() == null) {
            this.dPL.setVisibility(8);
            this.dQd.setVisibility(0);
            addView(this.dQd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bqL == null) {
            if (i < 0) {
                this.bqL = new f(getContext());
            } else {
                this.bqL = new f(getContext(), i);
            }
            this.bqL.onChangeSkinType();
        }
        this.bqL.d(this, z);
        this.dPL.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.tbds160) + this.auC;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(d.e.ds320), dimensionPixelSize2), NoDataViewFactory.d.C(d.k.no_context_text, getResources().getDimensionPixelSize(d.e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.e(getContext(), d.e.fontsize42));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setSubTitleTextColor(d.C0142d.cp_cont_b);
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
        if (this.dQc != null) {
            this.dQc.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dQc != null) {
            this.dQc.fH(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dQc != null) {
            this.dQc.gF(z);
        }
    }

    public void reload() {
        if (this.dPL != null) {
            if (this.dQe && this.dPL.getFirstVisiblePosition() != 0) {
                this.dQe = false;
                return;
            }
            this.dPL.setSelection(0);
            if (this.dPL.isRefreshDone()) {
                this.dPL.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dQc.a((b.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.dPL.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        this.dPL.setRecyclerListener(null);
    }

    public void aCD() {
        if (this.dQc != null) {
            this.dQc.fH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        if (this.buU != null && !this.buU.AO()) {
            this.buU.AH();
            this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dQc.Tf();
    }
}
