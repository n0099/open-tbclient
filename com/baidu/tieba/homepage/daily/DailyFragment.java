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
    private boolean eEu;
    private com.baidu.tieba.homepage.daily.model.a fHJ;
    private a fHK;
    private a.InterfaceC0250a fHL = new a.InterfaceC0250a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0250a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.fHK.hideLoadingView();
            DailyFragment.this.fHK.aBN();
            DailyFragment.this.fHK.a(bVar);
            if (!DailyFragment.this.fHJ.blN()) {
                DailyFragment.this.fHK.aCx();
            } else if (z2) {
                DailyFragment.this.fHK.blE();
            } else {
                DailyFragment.this.fHK.aCw();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0250a
        public void J(int i, String str) {
            DailyFragment.this.fHK.hideLoadingView();
            DailyFragment.this.fHK.aBN();
            if (DailyFragment.this.fHJ.aoJ()) {
                DailyFragment.this.fHK.showNetRefreshView(DailyFragment.this.fHK.getRootView(), str);
                return;
            }
            if (j.kY()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.fHK.blE();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.fHJ = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.fHK = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fHJ.a(this.fHL);
        this.fHJ.setPageUniqueId(getUniqueId());
        this.fHK.setListPullRefreshListener(this);
        this.fHK.setOnSrollToBottomListener(this);
        this.fHK.u(getNetRefreshListener());
        this.fHK.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.fHK.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eEu) {
            this.fHK.showLoadingView();
            this.fHJ.refresh();
            this.eEu = true;
        }
    }

    public void aCu() {
        this.fHK.aCu();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBv() {
        if (this.eEu) {
            this.fHK.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBw() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBx() {
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
    public void aeK() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fHK.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        this.fHJ.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fHJ.hasMore()) {
            if (!this.fHJ.qz()) {
                this.fHK.aCv();
                this.fHJ.aBd();
                return;
            }
            return;
        }
        this.fHK.aCw();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kY()) {
            this.fHK.aBu();
            this.fHK.showLoadingView();
            this.fHJ.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.fHK.onDestroy();
        this.fHJ.onDestroy();
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
