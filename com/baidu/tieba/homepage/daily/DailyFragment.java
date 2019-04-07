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
    private boolean eEb;
    private com.baidu.tieba.homepage.daily.model.a fHw;
    private a fHx;
    private a.InterfaceC0303a fHy = new a.InterfaceC0303a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0303a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.fHx.hideLoadingView();
            DailyFragment.this.fHx.aBJ();
            DailyFragment.this.fHx.a(bVar);
            if (!DailyFragment.this.fHw.blJ()) {
                DailyFragment.this.fHx.aCt();
            } else if (z2) {
                DailyFragment.this.fHx.blA();
            } else {
                DailyFragment.this.fHx.aCs();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0303a
        public void J(int i, String str) {
            DailyFragment.this.fHx.hideLoadingView();
            DailyFragment.this.fHx.aBJ();
            if (DailyFragment.this.fHw.aoF()) {
                DailyFragment.this.fHx.showNetRefreshView(DailyFragment.this.fHx.getRootView(), str);
                return;
            }
            if (j.kY()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.fHx.blA();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.fHw = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.fHx = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fHw.a(this.fHy);
        this.fHw.setPageUniqueId(getUniqueId());
        this.fHx.setListPullRefreshListener(this);
        this.fHx.setOnSrollToBottomListener(this);
        this.fHx.u(getNetRefreshListener());
        this.fHx.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.fHx.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eEb) {
            this.fHx.showLoadingView();
            this.fHw.refresh();
            this.eEb = true;
        }
    }

    public void aCq() {
        this.fHx.aCq();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBr() {
        if (this.eEb) {
            this.fHx.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBs() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBt() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aeH() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fHx.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        this.fHw.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fHw.hasMore()) {
            if (!this.fHw.qz()) {
                this.fHx.aCr();
                this.fHw.aAZ();
                return;
            }
            return;
        }
        this.fHx.aCs();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kY()) {
            this.fHx.aBq();
            this.fHx.showLoadingView();
            this.fHw.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.fHx.onDestroy();
        this.fHw.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a033";
    }
}
