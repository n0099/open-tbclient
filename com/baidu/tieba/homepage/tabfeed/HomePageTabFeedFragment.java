package com.baidu.tieba.homepage.tabfeed;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.m.d;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.tabfeed.model.HomePageTabFeedNetModel;
/* loaded from: classes22.dex */
public class HomePageTabFeedFragment extends BaseFragment implements aq, c {
    private HomePageTabFeedNetModel jBU;
    private com.baidu.tieba.homepage.tabfeed.view.a jBV;
    private ViewGroup rootView;
    private String tabCode;
    private String tabName;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null && TextUtils.isEmpty(this.tabName) && TextUtils.isEmpty(this.tabCode)) {
            this.tabName = bundle.getString("tab_name");
            this.tabCode = bundle.getString("tab_code");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView != null && (this.rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
        }
        if (this.rootView == null) {
            this.rootView = (ViewGroup) getLayoutInflater().inflate(getLayoutR(), (ViewGroup) null);
            this.jBV = new com.baidu.tieba.homepage.tabfeed.view.a(this, this, this.rootView, this.tabName);
        }
        if (this.jBU == null) {
            this.jBU = new HomePageTabFeedNetModel(getPageContext(), this);
            this.jBU.eM(this.tabCode, this.tabName);
        }
        this.jBU.l(getUniqueId());
        return this.rootView;
    }

    protected int getLayoutR() {
        return R.layout.tab_feed_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.jBV != null) {
                this.jBV.resume();
            }
            aku();
        } else if (this.jBV != null) {
            this.jBV.pause();
        }
    }

    private void aku() {
        if (isPrimary()) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13749");
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.dR("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        t.clQ().op(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t.clQ().op(false);
        if (this.jBU != null) {
            this.jBU.destory();
        }
        if (this.jBV != null) {
            this.jBV.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.rootView);
            if (this.jBU != null) {
                this.jBU.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.rootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jBV != null) {
            this.jBV.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.homepage.tabfeed.c
    public void a(ErrorData errorData) {
        hideLoadingView(this.rootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (this.jBU != null && !this.jBU.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.rootView, str, true);
        }
        if (this.jBV != null) {
            this.jBV.kT(false);
        }
    }

    @Override // com.baidu.tieba.homepage.tabfeed.c
    public void a(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        hideLoadingView(this.rootView);
        if (this.jBU != null && !this.jBU.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.jBV != null) {
            this.jBV.b(cVar);
        }
    }

    @Override // com.baidu.tieba.homepage.tabfeed.c
    public void cqq() {
        if (this.jBU != null) {
            this.jBU.bMi();
        }
    }

    public void oQ(boolean z) {
        if (this.jBU != null) {
            if (this.jBV != null && z) {
                if (this.jBU.hasData()) {
                    this.jBV.cqD();
                    this.jBV.kT(true);
                } else {
                    hideNetRefreshView(this.rootView);
                    showLoadingView(this.rootView);
                }
            }
            this.jBU.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        oQ(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.rootView);
            showLoadingView(this.rootView);
            oQ(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.jBV != null) {
            this.jBV.oR(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        if (this.jBV != null) {
            this.jBV.oR(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        if (this.jBV != null) {
            this.jBV.oR(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        if (this.jBV != null) {
            this.jBV.oR(false);
        }
        super.showLoadingView(view, false, cJh());
    }

    private int cJh() {
        return (l.getEquipmentHeight(getContext()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        if (this.jBV != null) {
            this.jBV.oR(true);
        }
    }

    public String getTabName() {
        return this.tabName;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.resourceId = this.tabName;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.aq
    public void Rd() {
        oQ(true);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bMC() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bMD() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bqd() {
        if (this.jBV != null) {
            this.jBV.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
