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
    private boolean fcM;
    private com.baidu.tieba.homepage.daily.model.a geG;
    private a geH;
    private a.InterfaceC0424a geI = new a.InterfaceC0424a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0424a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.geH.hideLoadingView();
            DailyFragment.this.geH.aJF();
            DailyFragment.this.geH.a(bVar);
            if (!DailyFragment.this.geG.btp()) {
                DailyFragment.this.geH.aKi();
            } else if (z2) {
                DailyFragment.this.geH.btg();
            } else {
                DailyFragment.this.geH.aKh();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0424a
        public void O(int i, String str) {
            DailyFragment.this.geH.hideLoadingView();
            DailyFragment.this.geH.aJF();
            if (DailyFragment.this.geG.we()) {
                DailyFragment.this.geH.showNetRefreshView(DailyFragment.this.geH.getRootView(), str);
                return;
            }
            if (j.isNetWorkAvailable()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.geH.btg();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.geG = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.geH = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.geG.a(this.geI);
        this.geG.setPageUniqueId(getUniqueId());
        this.geH.setListPullRefreshListener(this);
        this.geH.setOnSrollToBottomListener(this);
        this.geH.x(getNetRefreshListener());
        this.geH.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.geH.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fcM) {
            this.geH.showLoadingView();
            this.geG.refresh();
            this.fcM = true;
        }
    }

    public void aKf() {
        this.geH.aKf();
    }

    @Override // com.baidu.tieba.frs.ae
    public void vV() {
        if (this.fcM) {
            this.geH.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJn() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJo() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void anM() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.geH.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        this.geG.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.geG.hasMore()) {
            if (!this.geG.isLoading()) {
                this.geH.aKg();
                this.geG.aIU();
                return;
            }
            return;
        }
        this.geH.aKh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            this.geH.aJm();
            this.geH.showLoadingView();
            this.geG.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.geH.onDestroy();
        this.geG.onDestroy();
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
