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
    private boolean ejA;
    private a.InterfaceC0199a ejB = new a.InterfaceC0199a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0199a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.ejz.hideLoadingView();
            DailyFragment.this.ejz.aIZ();
            DailyFragment.this.ejz.a(bVar);
            if (!DailyFragment.this.ejy.aJi()) {
                DailyFragment.this.ejz.ZL();
            } else if (z2) {
                DailyFragment.this.ejz.aIY();
            } else {
                DailyFragment.this.ejz.ZK();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0199a
        public void s(int i, String str) {
            DailyFragment.this.ejz.hideLoadingView();
            DailyFragment.this.ejz.aIZ();
            if (DailyFragment.this.ejy.Nx()) {
                DailyFragment.this.ejz.showNetRefreshView(DailyFragment.this.ejz.getRootView(), str);
                return;
            }
            if (com.baidu.adp.lib.util.j.kX()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.ejz.aIY();
        }
    };
    private com.baidu.tieba.homepage.daily.model.a ejy;
    private a ejz;

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.ejy = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.ejz = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ejy.a(this.ejB);
        this.ejy.setPageUniqueId(getUniqueId());
        this.ejz.a(this);
        this.ejz.setOnSrollToBottomListener(this);
        this.ejz.r(getNetRefreshListener());
        this.ejz.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.ejz.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ejA) {
            this.ejz.showLoadingView();
            this.ejy.refresh();
            this.ejA = true;
        }
    }

    public void ZG() {
        this.ejz.ZG();
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zk() {
        if (this.ejA) {
            this.ejz.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zl() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zm() {
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
        this.ejz.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        this.ejy.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ejy.hasMore()) {
            if (!this.ejy.DU()) {
                this.ejz.ZJ();
                this.ejy.YL();
                return;
            }
            return;
        }
        this.ejz.ZK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kX()) {
            this.ejz.ZI();
            this.ejz.showLoadingView();
            this.ejy.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.ejz.onDestroy();
        this.ejy.onDestroy();
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
