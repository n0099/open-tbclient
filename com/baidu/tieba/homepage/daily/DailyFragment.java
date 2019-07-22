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
    private boolean eYY;
    private com.baidu.tieba.homepage.daily.model.a gds;
    private a gdt;
    private a.InterfaceC0318a gdu = new a.InterfaceC0318a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0318a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.gdt.hideLoadingView();
            DailyFragment.this.gdt.aJB();
            DailyFragment.this.gdt.a(bVar);
            if (!DailyFragment.this.gds.bvl()) {
                DailyFragment.this.gdt.aKk();
            } else if (z2) {
                DailyFragment.this.gdt.bvc();
            } else {
                DailyFragment.this.gdt.aKj();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0318a
        public void M(int i, String str) {
            DailyFragment.this.gdt.hideLoadingView();
            DailyFragment.this.gdt.aJB();
            if (DailyFragment.this.gds.auR()) {
                DailyFragment.this.gdt.showNetRefreshView(DailyFragment.this.gdt.getRootView(), str);
                return;
            }
            if (j.kc()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.gdt.bvc();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.gds = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.gdt = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gds.a(this.gdu);
        this.gds.setPageUniqueId(getUniqueId());
        this.gdt.setListPullRefreshListener(this);
        this.gdt.setOnSrollToBottomListener(this);
        this.gdt.w(getNetRefreshListener());
        this.gdt.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.gdt.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eYY) {
            this.gdt.showLoadingView();
            this.gds.refresh();
            this.eYY = true;
        }
    }

    public void aKh() {
        this.gdt.aKh();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJi() {
        if (this.eYY) {
            this.gdt.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJj() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJk() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void akL() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gdt.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        this.gds.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gds.hasMore()) {
            if (!this.gds.pP()) {
                this.gdt.aKi();
                this.gds.aIQ();
                return;
            }
            return;
        }
        this.gdt.aKj();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc()) {
            this.gdt.aJh();
            this.gdt.showLoadingView();
            this.gds.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gdt.onDestroy();
        this.gds.onDestroy();
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
