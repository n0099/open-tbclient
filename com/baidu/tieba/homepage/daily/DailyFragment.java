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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.model.a;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class DailyFragment extends BaseFragment implements BdListView.e, h.c, ae {
    private boolean fdD;
    private com.baidu.tieba.homepage.daily.model.a gfx;
    private a gfy;
    private a.InterfaceC0424a gfz = new a.InterfaceC0424a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0424a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.gfy.hideLoadingView();
            DailyFragment.this.gfy.aJH();
            DailyFragment.this.gfy.a(bVar);
            if (!DailyFragment.this.gfx.btr()) {
                DailyFragment.this.gfy.aKk();
            } else if (z2) {
                DailyFragment.this.gfy.bti();
            } else {
                DailyFragment.this.gfy.aKj();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0424a
        public void P(int i, String str) {
            DailyFragment.this.gfy.hideLoadingView();
            DailyFragment.this.gfy.aJH();
            if (DailyFragment.this.gfx.wd()) {
                DailyFragment.this.gfy.showNetRefreshView(DailyFragment.this.gfy.getRootView(), str);
                return;
            }
            if (j.isNetWorkAvailable()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.gfy.bti();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.gfx = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.gfy = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gfx.a(this.gfz);
        this.gfx.setPageUniqueId(getUniqueId());
        this.gfy.setListPullRefreshListener(this);
        this.gfy.setOnSrollToBottomListener(this);
        this.gfy.x(getNetRefreshListener());
        this.gfy.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.gfy.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fdD) {
            this.gfy.showLoadingView();
            this.gfx.refresh();
            this.fdD = true;
        }
    }

    public void aKh() {
        this.gfy.aKh();
    }

    @Override // com.baidu.tieba.frs.ae
    public void vU() {
        if (this.fdD) {
            this.gfy.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJp() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJq() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void anO() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gfy.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        this.gfx.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gfx.hasMore()) {
            if (!this.gfx.isLoading()) {
                this.gfy.aKi();
                this.gfx.aIW();
                return;
            }
            return;
        }
        this.gfy.aKj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            this.gfy.aJo();
            this.gfy.showLoadingView();
            this.gfx.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gfy.onDestroy();
        this.gfx.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(v.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.DISCOVER;
    }
}
