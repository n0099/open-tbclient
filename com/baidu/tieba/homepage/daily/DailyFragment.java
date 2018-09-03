package com.baidu.tieba.homepage.daily;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.model.a;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class DailyFragment extends BaseFragment implements BdListView.e, g.b, ah {
    private com.baidu.tieba.homepage.daily.model.a dUl;
    private a dUm;
    private boolean dUn;
    private a.InterfaceC0163a dUo = new a.InterfaceC0163a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0163a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.dUm.hideLoadingView();
            DailyFragment.this.dUm.aDu();
            DailyFragment.this.dUm.a(bVar);
            if (!DailyFragment.this.dUl.aDD()) {
                DailyFragment.this.dUm.Uq();
            } else if (z2) {
                DailyFragment.this.dUm.aDt();
            } else {
                DailyFragment.this.dUm.Up();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0163a
        public void s(int i, String str) {
            DailyFragment.this.dUm.hideLoadingView();
            DailyFragment.this.dUm.aDu();
            if (DailyFragment.this.dUl.Kj()) {
                DailyFragment.this.dUm.showNetRefreshView(DailyFragment.this.dUm.getRootView(), str);
                return;
            }
            if (j.jE()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.dUm.aDt();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.dUl = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.dUm = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dUl.a(this.dUo);
        this.dUl.setPageUniqueId(getUniqueId());
        this.dUm.a(this);
        this.dUm.setOnSrollToBottomListener(this);
        this.dUm.r(getNetRefreshListener());
        this.dUm.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.dUm.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.dUn) {
            this.dUm.showLoadingView();
            this.dUl.refresh();
            this.dUn = true;
        }
    }

    public void Ul() {
        this.dUm.Ul();
    }

    @Override // com.baidu.tieba.frs.ah
    public void TP() {
        if (this.dUn) {
            this.dUm.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TQ() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void TR() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void AD() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dUm.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aT(boolean z) {
        this.dUl.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dUl.hasMore()) {
            if (!this.dUl.AB()) {
                this.dUm.Uo();
                this.dUl.Tq();
                return;
            }
            return;
        }
        this.dUm.Up();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jE()) {
            this.dUm.Un();
            this.dUm.showLoadingView();
            this.dUl.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.dUm.onDestroy();
        this.dUl.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(w.d(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a033";
    }
}
