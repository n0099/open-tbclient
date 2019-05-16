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
    private boolean eTW;
    private com.baidu.tieba.homepage.daily.model.a fYs;
    private a fYt;
    private a.InterfaceC0321a fYu = new a.InterfaceC0321a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0321a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.fYt.hideLoadingView();
            DailyFragment.this.fYt.aHZ();
            DailyFragment.this.fYt.a(bVar);
            if (!DailyFragment.this.fYs.btf()) {
                DailyFragment.this.fYt.aIG();
            } else if (z2) {
                DailyFragment.this.fYt.bsW();
            } else {
                DailyFragment.this.fYt.aIF();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0321a
        public void M(int i, String str) {
            DailyFragment.this.fYt.hideLoadingView();
            DailyFragment.this.fYt.aHZ();
            if (DailyFragment.this.fYs.atJ()) {
                DailyFragment.this.fYt.showNetRefreshView(DailyFragment.this.fYt.getRootView(), str);
                return;
            }
            if (j.jS()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.fYt.bsW();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.fYs = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.fYt = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fYs.a(this.fYu);
        this.fYs.setPageUniqueId(getUniqueId());
        this.fYt.setListPullRefreshListener(this);
        this.fYt.setOnSrollToBottomListener(this);
        this.fYt.w(getNetRefreshListener());
        this.fYt.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.fYt.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eTW) {
            this.fYt.showLoadingView();
            this.fYs.refresh();
            this.eTW = true;
        }
    }

    public void aID() {
        this.fYt.aID();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHI() {
        if (this.eTW) {
            this.fYt.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHJ() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHK() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void ajG() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fYt.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        this.fYs.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fYs.hasMore()) {
            if (!this.fYs.pu()) {
                this.fYt.aIE();
                this.fYs.aHq();
                return;
            }
            return;
        }
        this.fYt.aIF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jS()) {
            this.fYt.aHH();
            this.fYt.showLoadingView();
            this.fYs.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.fYt.onDestroy();
        this.fYs.onDestroy();
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
