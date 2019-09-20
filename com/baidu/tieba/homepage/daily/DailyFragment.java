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
import com.baidu.tbadk.util.w;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.model.a;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class DailyFragment extends BaseFragment implements BdListView.e, h.c, ae {
    private boolean faS;
    private com.baidu.tieba.homepage.daily.model.a gga;
    private a ggb;
    private a.InterfaceC0335a ggc = new a.InterfaceC0335a() { // from class: com.baidu.tieba.homepage.daily.DailyFragment.1
        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0335a
        public void a(b bVar, boolean z, boolean z2) {
            DailyFragment.this.ggb.hideLoadingView();
            DailyFragment.this.ggb.aKh();
            DailyFragment.this.ggb.a(bVar);
            if (!DailyFragment.this.gga.bwm()) {
                DailyFragment.this.ggb.aKQ();
            } else if (z2) {
                DailyFragment.this.ggb.bwd();
            } else {
                DailyFragment.this.ggb.aKP();
            }
        }

        @Override // com.baidu.tieba.homepage.daily.model.a.InterfaceC0335a
        public void M(int i, String str) {
            DailyFragment.this.ggb.hideLoadingView();
            DailyFragment.this.ggb.aKh();
            if (DailyFragment.this.gga.avf()) {
                DailyFragment.this.ggb.showNetRefreshView(DailyFragment.this.ggb.getRootView(), str);
                return;
            }
            if (j.kc()) {
                DailyFragment.this.showToast(str);
            }
            DailyFragment.this.ggb.bwd();
        }
    };

    public DailyFragment() {
    }

    public DailyFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.gga = new com.baidu.tieba.homepage.daily.model.a(pageContext);
        this.ggb = new a(pageContext);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gga.a(this.ggc);
        this.gga.setPageUniqueId(getUniqueId());
        this.ggb.setListPullRefreshListener(this);
        this.ggb.setOnSrollToBottomListener(this);
        this.ggb.w(getNetRefreshListener());
        this.ggb.setPageUniqueId(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View rootView = this.ggb.getRootView();
        if (rootView != null && (rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.faS) {
            this.ggb.showLoadingView();
            this.gga.refresh();
            this.faS = true;
        }
    }

    public void aKN() {
        this.ggb.aKN();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJO() {
        if (this.faS) {
            this.ggb.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJP() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJQ() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void akZ() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ggb.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void eu(boolean z) {
        this.gga.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gga.hasMore()) {
            if (!this.gga.pQ()) {
                this.ggb.aKO();
                this.gga.aJw();
                return;
            }
            return;
        }
        this.ggb.aKP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc()) {
            this.ggb.aJN();
            this.ggb.showLoadingView();
            this.gga.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.ggb.onDestroy();
        this.gga.onDestroy();
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
