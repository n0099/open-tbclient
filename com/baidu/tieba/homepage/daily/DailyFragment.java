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
    private com.baidu.tieba.homepage.daily.model.a ekS;
    private a ekT;
    private boolean ekU;
    private a.InterfaceC0225a ekV = new a.InterfaceC0225a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0225a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.ekT.hideLoadingView();
            DailyFragment.this.ekT.aIx();
            DailyFragment.this.ekT.a(bVar);
            if (!DailyFragment.this.ekS.aIG()) {
                DailyFragment.this.ekT.ZV();
            } else if (z2) {
                DailyFragment.this.ekT.aIw();
            } else {
                DailyFragment.this.ekT.ZU();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0225a
        public void r(int i, String str) {
            DailyFragment.this.ekT.hideLoadingView();
            DailyFragment.this.ekT.aIx();
            if (DailyFragment.this.ekS.NG()) {
                DailyFragment.this.ekT.showNetRefreshView(DailyFragment.this.ekT.getRootView(), str);
                return;
            }
            if (com.baidu.adp.lib.util.j.kV()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.ekT.aIw();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.ekS = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.ekT = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ekS.a(this.ekV);
        this.ekS.setPageUniqueId(getUniqueId());
        this.ekT.a(this);
        this.ekT.setOnSrollToBottomListener(this);
        this.ekT.t(getNetRefreshListener());
        this.ekT.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.ekT.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ekU) {
            this.ekT.showLoadingView();
            this.ekS.refresh();
            this.ekU = true;
        }
    }

    public void ZQ() {
        this.ekT.ZQ();
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zu() {
        if (this.ekU) {
            this.ekT.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zv() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zw() {
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
    public void Ef() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ekT.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bG(boolean z) {
        this.ekS.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ekS.hasMore()) {
            if (!this.ekS.Ee()) {
                this.ekT.ZT();
                this.ekS.YV();
                return;
            }
            return;
        }
        this.ekT.ZU();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            this.ekT.ZS();
            this.ekT.showLoadingView();
            this.ekS.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.ekT.onDestroy();
        this.ekS.onDestroy();
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
