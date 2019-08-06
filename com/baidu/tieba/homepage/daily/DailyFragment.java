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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.model.a;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class DailyFragment extends BaseFragment implements BdListView.e, h.c, ae {
    private boolean eZm;
    private com.baidu.tieba.homepage.daily.model.a gei;
    private a gej;
    private a.InterfaceC0324a gek = new a.InterfaceC0324a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0324a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.gej.hideLoadingView();
            DailyFragment.this.gej.aJD();
            DailyFragment.this.gej.a(bVar);
            if (!DailyFragment.this.gei.bvy()) {
                DailyFragment.this.gej.aKm();
            } else if (z2) {
                DailyFragment.this.gej.bvp();
            } else {
                DailyFragment.this.gej.aKl();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0324a
        public void M(int i, String str) {
            DailyFragment.this.gej.hideLoadingView();
            DailyFragment.this.gej.aJD();
            if (DailyFragment.this.gei.auT()) {
                DailyFragment.this.gej.showNetRefreshView(DailyFragment.this.gej.getRootView(), str);
                return;
            }
            if (j.kc()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.gej.bvp();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.gei = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.gej = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gei.a(this.gek);
        this.gei.setPageUniqueId(getUniqueId());
        this.gej.setListPullRefreshListener(this);
        this.gej.setOnSrollToBottomListener(this);
        this.gej.w(getNetRefreshListener());
        this.gej.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.gej.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eZm) {
            this.gej.showLoadingView();
            this.gei.refresh();
            this.eZm = true;
        }
    }

    public void aKj() {
        this.gej.aKj();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJk() {
        if (this.eZm) {
            this.gej.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJl() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJm() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void akN() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gej.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        this.gei.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gei.hasMore()) {
            if (!this.gei.pP()) {
                this.gej.aKk();
                this.gei.aIS();
                return;
            }
            return;
        }
        this.gej.aKl();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc()) {
            this.gej.aJj();
            this.gej.showLoadingView();
            this.gei.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gej.onDestroy();
        this.gei.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a033";
    }
}
