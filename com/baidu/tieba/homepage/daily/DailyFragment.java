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
/* loaded from: classes6.dex */
public class DailyFragment extends BaseFragment implements BdListView.e, j.b, ah {
    private com.baidu.tieba.homepage.daily.model.a euE;
    private a euF;
    private boolean euG;
    private a.InterfaceC0236a euH = new a.InterfaceC0236a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0236a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.euF.hideLoadingView();
            DailyFragment.this.euF.aLd();
            DailyFragment.this.euF.a(bVar);
            if (!DailyFragment.this.euE.aLm()) {
                DailyFragment.this.euF.abd();
            } else if (z2) {
                DailyFragment.this.euF.aLc();
            } else {
                DailyFragment.this.euF.abc();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0236a
        public void r(int i, String str) {
            DailyFragment.this.euF.hideLoadingView();
            DailyFragment.this.euF.aLd();
            if (DailyFragment.this.euE.OL()) {
                DailyFragment.this.euF.showNetRefreshView(DailyFragment.this.euF.getRootView(), str);
                return;
            }
            if (com.baidu.adp.lib.util.j.kV()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.euF.aLc();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.euE = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.euF = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.euE.a(this.euH);
        this.euE.setPageUniqueId(getUniqueId());
        this.euF.a(this);
        this.euF.setOnSrollToBottomListener(this);
        this.euF.t(getNetRefreshListener());
        this.euF.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.euF.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.euG) {
            this.euF.showLoadingView();
            this.euE.refresh();
            this.euG = true;
        }
    }

    public void aaY() {
        this.euF.aaY();
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaC() {
        if (this.euG) {
            this.euF.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaD() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaE() {
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
    public void Fj() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.euF.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        this.euE.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.euE.hasMore()) {
            if (!this.euE.Fi()) {
                this.euF.abb();
                this.euE.aad();
                return;
            }
            return;
        }
        this.euF.abc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            this.euF.aba();
            this.euF.showLoadingView();
            this.euE.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.euF.onDestroy();
        this.euE.onDestroy();
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
