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
/* loaded from: classes2.dex */
public class ConcernPageView extends FrameLayout {
    private int axu;
    private PbListView bBr;
    private f bxm;
    private BdTypeListView dZK;
    private com.baidu.tieba.homepage.concern.a dZZ;
    private View duk;
    private a eaa;
    private b eab;
    private ConcernNotLoginLayout eac;
    private boolean ead;
    private b.a eae;
    private View.OnClickListener eaf;
    private CustomMessageListener eag;
    private NoDataView mNoDataView;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void D(boolean z, boolean z2);

        void nZ(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.dZK != null) {
            this.dZK.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dZZ != null) {
            this.dZZ.setPageUniqueId(bdUniqueId);
        }
        if (this.eab != null) {
            this.eab.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.eag != null) {
            this.eag.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eag);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.ead = false;
        this.mSkinType = 3;
        this.eae = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aFw() {
                if (ConcernPageView.this.eaa == null) {
                    if (ConcernPageView.this.eac != null) {
                        ConcernPageView.this.eac.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.B(false, false);
                    return;
                }
                boolean aFt = ConcernPageView.this.aFt();
                ConcernPageView.this.Wa();
                if (aFt) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds520));
                }
                ConcernPageView.this.eaa.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nY(String str) {
                if (ConcernPageView.this.eaa != null) {
                    ConcernPageView.this.eaa.nZ(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.B(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.eab != null) {
                        ConcernPageView.this.he(ConcernPageView.this.eab.hasMore());
                    }
                    if (j.kK()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dZK.setVisibility(8);
                if (ConcernPageView.this.eac != null) {
                    ConcernPageView.this.eac.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void C(boolean z, boolean z2) {
                if (ConcernPageView.this.eab != null) {
                    ConcernPageView.this.he(ConcernPageView.this.eab.hasMore());
                }
                ConcernPageView.this.dZK.setVisibility(0);
                ConcernPageView.this.B(z, z2);
                ConcernPageView.this.Wa();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aFx() {
                ConcernPageView.this.B(true, false);
                ConcernPageView.this.Wa();
                if (v.z(ConcernPageView.this.dZK.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.eaf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Vd();
            }
        };
        this.eag = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ead = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ead = false;
        this.mSkinType = 3;
        this.eae = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aFw() {
                if (ConcernPageView.this.eaa == null) {
                    if (ConcernPageView.this.eac != null) {
                        ConcernPageView.this.eac.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.B(false, false);
                    return;
                }
                boolean aFt = ConcernPageView.this.aFt();
                ConcernPageView.this.Wa();
                if (aFt) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds520));
                }
                ConcernPageView.this.eaa.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nY(String str) {
                if (ConcernPageView.this.eaa != null) {
                    ConcernPageView.this.eaa.nZ(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.B(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.eab != null) {
                        ConcernPageView.this.he(ConcernPageView.this.eab.hasMore());
                    }
                    if (j.kK()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dZK.setVisibility(8);
                if (ConcernPageView.this.eac != null) {
                    ConcernPageView.this.eac.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void C(boolean z, boolean z2) {
                if (ConcernPageView.this.eab != null) {
                    ConcernPageView.this.he(ConcernPageView.this.eab.hasMore());
                }
                ConcernPageView.this.dZK.setVisibility(0);
                ConcernPageView.this.B(z, z2);
                ConcernPageView.this.Wa();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aFx() {
                ConcernPageView.this.B(true, false);
                ConcernPageView.this.Wa();
                if (v.z(ConcernPageView.this.dZK.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.eaf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Vd();
            }
        };
        this.eag = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ead = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ead = false;
        this.mSkinType = 3;
        this.eae = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aFw() {
                if (ConcernPageView.this.eaa == null) {
                    if (ConcernPageView.this.eac != null) {
                        ConcernPageView.this.eac.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.B(false, false);
                    return;
                }
                boolean aFt = ConcernPageView.this.aFt();
                ConcernPageView.this.Wa();
                if (aFt) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds520));
                }
                ConcernPageView.this.eaa.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nY(String str) {
                if (ConcernPageView.this.eaa != null) {
                    ConcernPageView.this.eaa.nZ(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.B(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.eab != null) {
                        ConcernPageView.this.he(ConcernPageView.this.eab.hasMore());
                    }
                    if (j.kK()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dZK.setVisibility(8);
                if (ConcernPageView.this.eac != null) {
                    ConcernPageView.this.eac.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void C(boolean z, boolean z2) {
                if (ConcernPageView.this.eab != null) {
                    ConcernPageView.this.he(ConcernPageView.this.eab.hasMore());
                }
                ConcernPageView.this.dZK.setVisibility(0);
                ConcernPageView.this.B(z, z2);
                ConcernPageView.this.Wa();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aFx() {
                ConcernPageView.this.B(true, false);
                ConcernPageView.this.Wa();
                if (v.z(ConcernPageView.this.dZK.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.eaf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Vd();
            }
        };
        this.eag = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ead = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dZK = new BdTypeListView(context);
        this.dZK.setDividerHeight(0);
        this.dZK.setSelector(17170445);
        this.bBr = new PbListView(context);
        this.bBr.getView();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.setHeight(l.h(context, e.C0141e.tbds182));
        this.bBr.BF();
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bBr.dK(e.d.cp_cont_e);
        this.bBr.setOnClickListener(this.eaf);
        this.dZK.setNextPage(this.bBr);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new k(this.pageContext);
        this.dZK.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.duk = BdListViewHelper.a(context, this.dZK, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dZZ = new com.baidu.tieba.homepage.concern.a(context, this.dZK);
        this.eab = new b(this.pageContext, this.dZK, this.dZZ);
        addView(this.dZK);
        this.dZK.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.duk != null && this.duk.getLayoutParams() != null) {
            this.duk.getLayoutParams().height = i;
            this.duk.setLayoutParams(this.duk.getLayoutParams());
        }
        this.axu = i;
    }

    public void aAw() {
        this.eab.a(this.eae);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.SB().jc("page_concern");
                    ConcernPageView.this.eab.update();
                }
            }
        });
        this.dZK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.Vd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(boolean z) {
        if (this.bBr != null) {
            if (z) {
                this.bBr.BL();
                this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bBr.dO(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.eaa = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bBr != null) {
            this.bBr.BJ();
            this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eab.a(z, dataRes, 0, null);
    }

    public void aFr() {
        if (!TbadkCoreApplication.isLogin()) {
            aFu();
        } else if (this.eab != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds520));
            this.eab.update();
        }
    }

    public void aFs() {
        if (!TbadkCoreApplication.isLogin()) {
            aFu();
        } else if (this.eab != null) {
            this.eab.aFy();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.eab != null) {
            this.eab.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eac != null) {
                this.eac.onChangeSkinType(i);
            }
            if (this.bxm != null) {
                this.bxm.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dM(i);
            }
            if (this.bBr != null) {
                this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bBr.dM(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
            }
            this.dZZ.onChangeSkinType(i);
            al.j(this, e.d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void ab(String str, int i) {
        if (this.bBr != null) {
            this.bBr.BJ();
            this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eab.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.eab != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.eab.update();
                    }
                }
            });
        }
        this.refreshView.fs(getContext().getResources().getDimensionPixelSize(e.C0141e.ds280));
        this.refreshView.hG(str);
        this.refreshView.c(view, z);
        this.refreshView.KA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        if (this.refreshView != null) {
            this.refreshView.ad(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(boolean z, boolean z2) {
        if (this.bxm != null) {
            this.bxm.ad(this);
            this.bxm = null;
            this.dZK.setNextPage(this.bBr);
        }
        if (this.eaa != null) {
            this.eaa.D(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFt() {
        if (this.refreshView != null) {
            return this.refreshView.Ks();
        }
        return false;
    }

    private void aFu() {
        if (this.eac == null) {
            this.eac = new ConcernNotLoginLayout(getContext());
            this.eac.onChangeSkinType(this.mSkinType);
        }
        if (this.eac.getParent() == null) {
            this.dZK.setVisibility(8);
            this.eac.setVisibility(0);
            addView(this.eac);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bxm == null) {
            if (i < 0) {
                this.bxm = new f(getContext());
            } else {
                this.bxm = new f(getContext(), i);
            }
            this.bxm.onChangeSkinType();
        }
        this.bxm.c(this, z);
        this.dZK.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.tbds160) + this.axu;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0141e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(e.C0141e.ds320), dimensionPixelSize2), NoDataViewFactory.d.F(e.j.no_context_text, getResources().getDimensionPixelSize(e.C0141e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.h(getContext(), e.C0141e.fontsize42));
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
        if (this.eab != null) {
            this.eab.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.eab != null) {
            this.eab.ga(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eab != null) {
            this.eab.hf(z);
        }
    }

    public void reload() {
        if (this.dZK != null) {
            if (this.ead && this.dZK.getFirstVisiblePosition() != 0) {
                this.ead = false;
                return;
            }
            this.dZK.setSelection(0);
            if (this.dZK.isRefreshDone()) {
                this.dZK.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.eab.a((b.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.dZK.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.dZK.setRecyclerListener(null);
    }

    public void aFv() {
        if (this.eab != null) {
            this.eab.ga(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        if (this.bBr != null && !this.bBr.BO()) {
            this.bBr.BI();
            this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eab.Vd();
    }
}
