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
    private boolean eTX;
    private com.baidu.tieba.homepage.daily.model.a fYv;
    private a fYw;
    private a.InterfaceC0321a fYx = new a.InterfaceC0321a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0321a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.fYw.hideLoadingView();
            DailyFragment.this.fYw.aIc();
            DailyFragment.this.fYw.a(bVar);
            if (!DailyFragment.this.fYv.btj()) {
                DailyFragment.this.fYw.aIJ();
            } else if (z2) {
                DailyFragment.this.fYw.bta();
            } else {
                DailyFragment.this.fYw.aII();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0321a
        public void M(int i, String str) {
            DailyFragment.this.fYw.hideLoadingView();
            DailyFragment.this.fYw.aIc();
            if (DailyFragment.this.fYv.atJ()) {
                DailyFragment.this.fYw.showNetRefreshView(DailyFragment.this.fYw.getRootView(), str);
                return;
            }
            if (j.jS()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.fYw.bta();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.fYv = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.fYw = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fYv.a(this.fYx);
        this.fYv.setPageUniqueId(getUniqueId());
        this.fYw.setListPullRefreshListener(this);
        this.fYw.setOnSrollToBottomListener(this);
        this.fYw.w(getNetRefreshListener());
        this.fYw.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.fYw.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eTX) {
            this.fYw.showLoadingView();
            this.fYv.refresh();
            this.eTX = true;
        }
    }

    public void aIG() {
        this.fYw.aIG();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHL() {
        if (this.eTX) {
            this.fYw.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHM() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHN() {
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
        this.fYw.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        this.fYv.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fYv.hasMore()) {
            if (!this.fYv.pu()) {
                this.fYw.aIH();
                this.fYv.aHt();
                return;
            }
            return;
        }
        this.fYw.aII();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jS()) {
            this.fYw.aHK();
            this.fYw.showLoadingView();
            this.fYv.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.fYw.onDestroy();
        this.fYv.onDestroy();
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
