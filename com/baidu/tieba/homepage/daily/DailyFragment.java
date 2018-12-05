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
    private com.baidu.tieba.homepage.daily.model.a erN;
    private a erO;
    private boolean erP;
    private a.InterfaceC0236a erQ = new a.InterfaceC0236a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0236a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.erO.hideLoadingView();
            DailyFragment.this.erO.aKo();
            DailyFragment.this.erO.a(bVar);
            if (!DailyFragment.this.erN.aKx()) {
                DailyFragment.this.erO.abb();
            } else if (z2) {
                DailyFragment.this.erO.aKn();
            } else {
                DailyFragment.this.erO.aba();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0236a
        public void r(int i, String str) {
            DailyFragment.this.erO.hideLoadingView();
            DailyFragment.this.erO.aKo();
            if (DailyFragment.this.erN.OK()) {
                DailyFragment.this.erO.showNetRefreshView(DailyFragment.this.erO.getRootView(), str);
                return;
            }
            if (com.baidu.adp.lib.util.j.kV()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.erO.aKn();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.erN = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.erO = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.erN.a(this.erQ);
        this.erN.setPageUniqueId(getUniqueId());
        this.erO.a(this);
        this.erO.setOnSrollToBottomListener(this);
        this.erO.t(getNetRefreshListener());
        this.erO.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.erO.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.erP) {
            this.erO.showLoadingView();
            this.erN.refresh();
            this.erP = true;
        }
    }

    public void aaW() {
        this.erO.aaW();
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaA() {
        if (this.erP) {
            this.erO.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaB() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaC() {
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
        this.erO.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        this.erN.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.erN.hasMore()) {
            if (!this.erN.Fi()) {
                this.erO.aaZ();
                this.erN.aab();
                return;
            }
            return;
        }
        this.erO.aba();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            this.erO.aaY();
            this.erO.showLoadingView();
            this.erN.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.erO.onDestroy();
        this.erN.onDestroy();
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
