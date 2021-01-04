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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.m.d;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.homepage.tabfeed.model.HomePageTabFeedNetModel;
/* loaded from: classes2.dex */
public class HomePageTabFeedFragment extends BaseFragment implements am, c {
    private HomePageTabFeedNetModel kjt;
    private com.baidu.tieba.homepage.tabfeed.view.a kju;
    private ViewGroup rootView;
    private String tabCode;
    private String tabName;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView != null && (this.rootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
        }
        if (this.rootView == null) {
            this.rootView = (ViewGroup) getLayoutInflater().inflate(getLayoutR(), (ViewGroup) null);
            this.kju = new com.baidu.tieba.homepage.tabfeed.view.a(this, this, this.rootView, this.tabName);
        }
        if (this.kjt == null) {
            this.kjt = new HomePageTabFeedNetModel(getPageContext(), this);
            this.kjt.eS(this.tabCode, this.tabName);
        }
        this.kjt.l(getUniqueId());
        return this.rootView;
    }

    protected int getLayoutR() {
        return R.layout.tab_feed_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.kju != null) {
                this.kju.resume();
            }
            aqH();
        } else if (this.kju != null) {
            this.kju.pause();
        }
    }

    private void aqH() {
        if (isPrimary()) {
            aq aqVar = new aq("c13749");
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.dX("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        s.cva().pv(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        s.cva().pv(false);
        if (this.kjt != null) {
            this.kjt.destory();
        }
        if (this.kju != null) {
            this.kju.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.rootView);
            if (this.kjt != null) {
                this.kjt.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.rootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kju != null) {
            this.kju.onChangeSkinType(i);
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
        if (this.kjt != null && !this.kjt.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.rootView, str, true);
        }
        if (this.kju != null) {
            this.kju.lU(false);
        }
    }

    @Override // com.baidu.tieba.homepage.tabfeed.c
    public void a(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        hideLoadingView(this.rootView);
        if (this.kjt != null && !this.kjt.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.kju != null) {
            this.kju.b(cVar);
        }
    }

    @Override // com.baidu.tieba.homepage.tabfeed.c
    public void czD() {
        if (this.kjt != null) {
            this.kjt.bUp();
        }
    }

    public void pV(boolean z) {
        if (this.kjt != null) {
            if (this.kju != null && z) {
                if (this.kjt.hasData()) {
                    this.kju.czQ();
                    this.kju.lU(true);
                } else {
                    hideNetRefreshView(this.rootView);
                    showLoadingView(this.rootView);
                }
            }
            this.kjt.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        pV(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.rootView);
            showLoadingView(this.rootView);
            pV(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.kju != null) {
            this.kju.pW(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        if (this.kju != null) {
            this.kju.pW(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        if (this.kju != null) {
            this.kju.pW(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        if (this.kju != null) {
            this.kju.pW(false);
        }
        super.showLoadingView(view, false, cTK());
    }

    private int cTK() {
        return (l.getEquipmentHeight(getContext()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        if (this.kju != null) {
            this.kju.pW(true);
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

    @Override // com.baidu.tieba.frs.am
    public void WE() {
        pV(true);
    }

    @Override // com.baidu.tieba.frs.am
    public void bUJ() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bUK() {
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(y yVar) {
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bxO() {
        if (this.kju != null) {
            this.kju.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
