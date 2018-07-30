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
    private com.baidu.tieba.homepage.daily.model.a dUq;
    private a dUr;
    private boolean dUs;
    private a.InterfaceC0163a dUt = new a.InterfaceC0163a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0163a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.dUr.hideLoadingView();
            DailyFragment.this.dUr.aDx();
            DailyFragment.this.dUr.a(bVar);
            if (!DailyFragment.this.dUq.aDG()) {
                DailyFragment.this.dUr.Un();
            } else if (z2) {
                DailyFragment.this.dUr.aDw();
            } else {
                DailyFragment.this.dUr.Um();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0163a
        public void s(int i, String str) {
            DailyFragment.this.dUr.hideLoadingView();
            DailyFragment.this.dUr.aDx();
            if (DailyFragment.this.dUq.Kf()) {
                DailyFragment.this.dUr.showNetRefreshView(DailyFragment.this.dUr.getRootView(), str);
                return;
            }
            if (j.jE()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.dUr.aDw();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.dUq = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.dUr = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dUq.a(this.dUt);
        this.dUq.setPageUniqueId(getUniqueId());
        this.dUr.a(this);
        this.dUr.setOnSrollToBottomListener(this);
        this.dUr.r(getNetRefreshListener());
        this.dUr.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.dUr.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.dUs) {
            this.dUr.showLoadingView();
            this.dUq.refresh();
            this.dUs = true;
        }
    }

    public void Ui() {
        this.dUr.Ui();
    }

    @Override // com.baidu.tieba.frs.ah
    public void TM() {
        if (this.dUs) {
            this.dUr.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TN() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void TO() {
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
    public void AG() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dUr.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aS(boolean z) {
        this.dUq.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dUq.hasMore()) {
            if (!this.dUq.AE()) {
                this.dUr.Ul();
                this.dUq.Tn();
                return;
            }
            return;
        }
        this.dUr.Um();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jE()) {
            this.dUr.Uk();
            this.dUr.showLoadingView();
            this.dUq.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.dUr.onDestroy();
        this.dUq.onDestroy();
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
