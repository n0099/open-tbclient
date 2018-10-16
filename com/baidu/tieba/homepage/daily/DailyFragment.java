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
    private a.InterfaceC0199a ejA = new a.InterfaceC0199a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0199a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.ejy.hideLoadingView();
            DailyFragment.this.ejy.aIZ();
            DailyFragment.this.ejy.a(bVar);
            if (!DailyFragment.this.ejx.aJi()) {
                DailyFragment.this.ejy.ZK();
            } else if (z2) {
                DailyFragment.this.ejy.aIY();
            } else {
                DailyFragment.this.ejy.ZJ();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0199a
        public void s(int i, String str) {
            DailyFragment.this.ejy.hideLoadingView();
            DailyFragment.this.ejy.aIZ();
            if (DailyFragment.this.ejx.Nx()) {
                DailyFragment.this.ejy.showNetRefreshView(DailyFragment.this.ejy.getRootView(), str);
                return;
            }
            if (com.baidu.adp.lib.util.j.kX()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.ejy.aIY();
        }
    };
    private com.baidu.tieba.homepage.daily.model.a ejx;
    private a ejy;
    private boolean ejz;

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.ejx = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.ejy = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ejx.a(this.ejA);
        this.ejx.setPageUniqueId(getUniqueId());
        this.ejy.a(this);
        this.ejy.setOnSrollToBottomListener(this);
        this.ejy.r(getNetRefreshListener());
        this.ejy.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.ejy.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ejz) {
            this.ejy.showLoadingView();
            this.ejx.refresh();
            this.ejz = true;
        }
    }

    public void ZF() {
        this.ejy.ZF();
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zj() {
        if (this.ejz) {
            this.ejy.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zk() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zl() {
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
    public void DV() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ejy.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        this.ejx.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ejx.hasMore()) {
            if (!this.ejx.DU()) {
                this.ejy.ZI();
                this.ejx.YK();
                return;
            }
            return;
        }
        this.ejy.ZJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kX()) {
            this.ejy.ZH();
            this.ejy.showLoadingView();
            this.ejx.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.ejy.onDestroy();
        this.ejx.onDestroy();
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
