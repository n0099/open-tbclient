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
    private com.baidu.tieba.homepage.daily.model.a evk;
    private a evl;
    private boolean evm;
    private a.InterfaceC0236a evn = new a.InterfaceC0236a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0236a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.evl.hideLoadingView();
            DailyFragment.this.evl.aLB();
            DailyFragment.this.evl.a(bVar);
            if (!DailyFragment.this.evk.aLK()) {
                DailyFragment.this.evl.abA();
            } else if (z2) {
                DailyFragment.this.evl.aLA();
            } else {
                DailyFragment.this.evl.abz();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0236a
        public void t(int i, String str) {
            DailyFragment.this.evl.hideLoadingView();
            DailyFragment.this.evl.aLB();
            if (DailyFragment.this.evk.Pd()) {
                DailyFragment.this.evl.showNetRefreshView(DailyFragment.this.evl.getRootView(), str);
                return;
            }
            if (com.baidu.adp.lib.util.j.kV()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.evl.aLA();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.evk = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.evl = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.evk.a(this.evn);
        this.evk.setPageUniqueId(getUniqueId());
        this.evl.a(this);
        this.evl.setOnSrollToBottomListener(this);
        this.evl.t(getNetRefreshListener());
        this.evl.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.evl.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.evm) {
            this.evl.showLoadingView();
            this.evk.refresh();
            this.evm = true;
        }
    }

    public void abv() {
        this.evl.abv();
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaZ() {
        if (this.evm) {
            this.evl.reload();
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
        this.evl.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        this.evk.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.evk.hasMore()) {
            if (!this.evk.Fv()) {
                this.evl.aby();
                this.evk.aaA();
                return;
            }
            return;
        }
        this.evl.abz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            this.evl.abx();
            this.evl.showLoadingView();
            this.evk.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.evl.onDestroy();
        this.evk.onDestroy();
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
