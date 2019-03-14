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
    private boolean eEq;
    private com.baidu.tieba.homepage.daily.model.a fHI;
    private a fHJ;
    private a.InterfaceC0303a fHK = new a.InterfaceC0303a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0303a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.fHJ.hideLoadingView();
            DailyFragment.this.fHJ.aBM();
            DailyFragment.this.fHJ.a(bVar);
            if (!DailyFragment.this.fHI.blM()) {
                DailyFragment.this.fHJ.aCw();
            } else if (z2) {
                DailyFragment.this.fHJ.blD();
            } else {
                DailyFragment.this.fHJ.aCv();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0303a
        public void J(int i, String str) {
            DailyFragment.this.fHJ.hideLoadingView();
            DailyFragment.this.fHJ.aBM();
            if (DailyFragment.this.fHI.aoI()) {
                DailyFragment.this.fHJ.showNetRefreshView(DailyFragment.this.fHJ.getRootView(), str);
                return;
            }
            if (j.kY()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.fHJ.blD();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.fHI = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.fHJ = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fHI.a(this.fHK);
        this.fHI.setPageUniqueId(getUniqueId());
        this.fHJ.setListPullRefreshListener(this);
        this.fHJ.setOnSrollToBottomListener(this);
        this.fHJ.u(getNetRefreshListener());
        this.fHJ.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.fHJ.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eEq) {
            this.fHJ.showLoadingView();
            this.fHI.refresh();
            this.eEq = true;
        }
    }

    public void aCt() {
        this.fHJ.aCt();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBu() {
        if (this.eEq) {
            this.fHJ.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBv() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBw() {
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
        this.fHJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        this.fHI.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fHI.hasMore()) {
            if (!this.fHI.qz()) {
                this.fHJ.aCu();
                this.fHI.aBc();
                return;
            }
            return;
        }
        this.fHJ.aCv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kY()) {
            this.fHJ.aBt();
            this.fHJ.showLoadingView();
            this.fHI.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.fHJ.onDestroy();
        this.fHI.onDestroy();
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
