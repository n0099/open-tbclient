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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.m.d;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.homepage.tabfeed.model.HomePageTabFeedNetModel;
/* loaded from: classes22.dex */
public class HomePageTabFeedFragment extends BaseFragment implements ap, c {
    private HomePageTabFeedNetModel jWf;
    private com.baidu.tieba.homepage.tabfeed.view.a jWg;
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
            this.jWg = new com.baidu.tieba.homepage.tabfeed.view.a(this, this, this.rootView, this.tabName);
        }
        if (this.jWf == null) {
            this.jWf = new HomePageTabFeedNetModel(getPageContext(), this);
            this.jWf.eR(this.tabCode, this.tabName);
        }
        this.jWf.l(getUniqueId());
        return this.rootView;
    }

    protected int getLayoutR() {
        return R.layout.tab_feed_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.jWg != null) {
                this.jWg.resume();
            }
            apv();
        } else if (this.jWg != null) {
            this.jWg.pause();
        }
    }

    private void apv() {
        if (isPrimary()) {
            ar arVar = new ar("c13749");
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.dY("resource_id", this.tabName);
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        t.csg().oX(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t.csg().oX(false);
        if (this.jWf != null) {
            this.jWf.destory();
        }
        if (this.jWg != null) {
            this.jWg.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.rootView);
            if (this.jWf != null) {
                this.jWf.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.rootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jWg != null) {
            this.jWg.onChangeSkinType(i);
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
        if (this.jWf != null && !this.jWf.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.rootView, str, true);
        }
        if (this.jWg != null) {
            this.jWg.lx(false);
        }
    }

    @Override // com.baidu.tieba.homepage.tabfeed.c
    public void a(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        hideLoadingView(this.rootView);
        if (this.jWf != null && !this.jWf.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.jWg != null) {
            this.jWg.b(cVar);
        }
    }

    @Override // com.baidu.tieba.homepage.tabfeed.c
    public void cwJ() {
        if (this.jWf != null) {
            this.jWf.bRM();
        }
    }

    public void py(boolean z) {
        if (this.jWf != null) {
            if (this.jWg != null && z) {
                if (this.jWf.hasData()) {
                    this.jWg.cwW();
                    this.jWg.lx(true);
                } else {
                    hideNetRefreshView(this.rootView);
                    showLoadingView(this.rootView);
                }
            }
            this.jWf.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        py(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.rootView);
            showLoadingView(this.rootView);
            py(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.jWg != null) {
            this.jWg.pz(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        if (this.jWg != null) {
            this.jWg.pz(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        if (this.jWg != null) {
            this.jWg.pz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        if (this.jWg != null) {
            this.jWg.pz(false);
        }
        super.showLoadingView(view, false, cQD());
    }

    private int cQD() {
        return (l.getEquipmentHeight(getContext()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        if (this.jWg != null) {
            this.jWg.pz(true);
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

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        py(true);
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSg() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.ap
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bvt() {
        if (this.jWg != null) {
            this.jWg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
