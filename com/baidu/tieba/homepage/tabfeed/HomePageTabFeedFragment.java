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
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.tabfeed.model.HomePageTabFeedNetModel;
/* loaded from: classes21.dex */
public class HomePageTabFeedFragment extends BaseFragment implements aq, c {
    private HomePageTabFeedNetModel jav;
    private com.baidu.tieba.homepage.tabfeed.view.a jaw;
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
            this.jaw = new com.baidu.tieba.homepage.tabfeed.view.a(this, this, this.rootView, this.tabName);
        }
        if (this.jav == null) {
            this.jav = new HomePageTabFeedNetModel(getPageContext(), this);
            this.jav.eA(this.tabCode, this.tabName);
        }
        this.jav.l(getUniqueId());
        return this.rootView;
    }

    protected int getLayoutR() {
        return R.layout.tab_feed_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.jaw != null) {
                this.jaw.resume();
            }
            afP();
        } else if (this.jaw != null) {
            this.jaw.pause();
        }
    }

    private void afP() {
        if (isPrimary()) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13749");
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.dF("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        s.cfn().ns(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        s.cfn().ns(false);
        if (this.jav != null) {
            this.jav.destory();
        }
        if (this.jaw != null) {
            this.jaw.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.rootView);
            if (this.jav != null) {
                this.jav.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.rootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jaw != null) {
            this.jaw.onChangeSkinType(i);
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
        if (this.jav != null && !this.jav.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.rootView, str, true);
        }
        if (this.jaw != null) {
            this.jaw.ki(false);
        }
    }

    @Override // com.baidu.tieba.homepage.tabfeed.c
    public void a(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        hideLoadingView(this.rootView);
        if (this.jav != null && !this.jav.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.jaw != null) {
            this.jaw.b(cVar);
        }
    }

    @Override // com.baidu.tieba.homepage.tabfeed.c
    public void cjN() {
        if (this.jav != null) {
            this.jav.bGU();
        }
    }

    public void nT(boolean z) {
        if (this.jav != null) {
            if (this.jaw != null && z) {
                if (this.jav.hasData()) {
                    this.jaw.cka();
                    this.jaw.ki(true);
                } else {
                    hideNetRefreshView(this.rootView);
                    showLoadingView(this.rootView);
                }
            }
            this.jav.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        nT(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.rootView);
            showLoadingView(this.rootView);
            nT(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.jaw != null) {
            this.jaw.nU(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        if (this.jaw != null) {
            this.jaw.nU(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        if (this.jaw != null) {
            this.jaw.nU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        if (this.jaw != null) {
            this.jaw.nU(false);
        }
        super.showLoadingView(view, false, cCr());
    }

    private int cCr() {
        return (l.getEquipmentHeight(getContext()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        if (this.jaw != null) {
            this.jaw.nU(true);
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
    public void Pd() {
        nT(true);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bHp() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bHq() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void blA() {
        if (this.jaw != null) {
            this.jaw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
