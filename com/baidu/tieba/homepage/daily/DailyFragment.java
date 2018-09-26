package com.baidu.tieba.homepage.daily;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.model.a;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class DailyFragment extends BaseFragment implements BdListView.e, j.b, ah {
    private com.baidu.tieba.homepage.daily.model.a ebE;
    private a ebF;
    private boolean ebG;
    private a.InterfaceC0165a ebH = new a.InterfaceC0165a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0165a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.ebF.hideLoadingView();
            DailyFragment.this.ebF.aFH();
            DailyFragment.this.ebF.a(bVar);
            if (!DailyFragment.this.ebE.aFQ()) {
                DailyFragment.this.ebF.Wd();
            } else if (z2) {
                DailyFragment.this.ebF.aFG();
            } else {
                DailyFragment.this.ebF.Wc();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0165a
        public void s(int i, String str) {
            DailyFragment.this.ebF.hideLoadingView();
            DailyFragment.this.ebF.aFH();
            if (DailyFragment.this.ebE.Lz()) {
                DailyFragment.this.ebF.showNetRefreshView(DailyFragment.this.ebF.getRootView(), str);
                return;
            }
            if (com.baidu.adp.lib.util.j.kK()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.ebF.aFG();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.ebE = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.ebF = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ebE.a(this.ebH);
        this.ebE.setPageUniqueId(getUniqueId());
        this.ebF.a(this);
        this.ebF.setOnSrollToBottomListener(this);
        this.ebF.r(getNetRefreshListener());
        this.ebF.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.ebF.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ebG) {
            this.ebF.showLoadingView();
            this.ebE.refresh();
            this.ebG = true;
        }
    }

    public void VY() {
        this.ebF.VY();
    }

    @Override // com.baidu.tieba.frs.ah
    public void VC() {
        if (this.ebG) {
            this.ebF.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void VD() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void VE() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void BQ() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ebF.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bf(boolean z) {
        this.ebE.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ebE.hasMore()) {
            if (!this.ebE.BO()) {
                this.ebF.Wb();
                this.ebE.Vd();
                return;
            }
            return;
        }
        this.ebF.Wc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.ebF.Wa();
            this.ebF.showLoadingView();
            this.ebE.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.ebF.onDestroy();
        this.ebE.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.d(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a033";
    }
}
