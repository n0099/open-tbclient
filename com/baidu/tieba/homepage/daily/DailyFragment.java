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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.model.a;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes6.dex */
public class DailyFragment extends BaseFragment implements BdListView.e, j.b, ah {
    private com.baidu.tieba.homepage.daily.model.a evl;
    private a evm;
    private boolean evn;
    private a.InterfaceC0236a evo = new a.InterfaceC0236a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0236a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.evm.hideLoadingView();
            DailyFragment.this.evm.aLB();
            DailyFragment.this.evm.a(bVar);
            if (!DailyFragment.this.evl.aLK()) {
                DailyFragment.this.evm.abA();
            } else if (z2) {
                DailyFragment.this.evm.aLA();
            } else {
                DailyFragment.this.evm.abz();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0236a
        public void t(int i, String str) {
            DailyFragment.this.evm.hideLoadingView();
            DailyFragment.this.evm.aLB();
            if (DailyFragment.this.evl.Pd()) {
                DailyFragment.this.evm.showNetRefreshView(DailyFragment.this.evm.getRootView(), str);
                return;
            }
            if (com.baidu.adp.lib.util.j.kV()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.evm.aLA();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.evl = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.evm = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.evl.a(this.evo);
        this.evl.setPageUniqueId(getUniqueId());
        this.evm.a(this);
        this.evm.setOnSrollToBottomListener(this);
        this.evm.t(getNetRefreshListener());
        this.evm.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.evm.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.evn) {
            this.evm.showLoadingView();
            this.evl.refresh();
            this.evn = true;
        }
    }

    public void abv() {
        this.evm.abv();
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaZ() {
        if (this.evn) {
            this.evm.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aba() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void abb() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(v vVar) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Fw() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.evm.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        this.evl.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.evl.hasMore()) {
            if (!this.evl.Fv()) {
                this.evm.aby();
                this.evl.aaA();
                return;
            }
            return;
        }
        this.evm.abz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            this.evm.abx();
            this.evm.showLoadingView();
            this.evl.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.evm.onDestroy();
        this.evl.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a033";
    }
}
