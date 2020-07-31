package com.baidu.tieba.enterForum.tabfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.m.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel;
/* loaded from: classes16.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {
    private EnterForumTabFeedNetModel hnV;
    private com.baidu.tieba.enterForum.tabfeed.view.a hnW;
    private int hnX;
    private ViewGroup rootView;
    private String tabCode;
    private String tabName;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.tabName = bundle.getString("tab_name");
            this.tabCode = bundle.getString("tab_code");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hnV == null) {
            this.hnV = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
            this.hnV.ee(this.tabCode, this.tabName);
            this.hnV.bWt();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (ViewGroup) layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.hnW = new com.baidu.tieba.enterForum.tabfeed.view.a(this, this, this.rootView, this.tabName);
        this.hnX = (l.getEquipmentHeight(getContext()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2;
        return this.rootView;
    }

    protected int getLayoutR() {
        return R.layout.enter_forum_tab_feed_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.hnW != null) {
                this.hnW.resume();
            }
        } else if (this.hnW != null) {
            this.hnW.pause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        s.bRL().mH(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        s.bRL().mH(false);
        if (this.hnV != null) {
            this.hnV.destory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.rootView);
            if (this.hnV != null) {
                this.hnV.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.rootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hnW != null) {
            this.hnW.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void a(ErrorData errorData) {
        hideLoadingView(this.rootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (!this.hnV.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.rootView, str, true);
        }
        if (this.hnW != null) {
            this.hnW.jH(false);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void a(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        hideLoadingView(this.rootView);
        if (!this.hnV.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.hnW != null) {
            this.hnW.b(bVar);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void bWk() {
        if (this.hnV != null) {
            this.hnV.bwE();
        }
    }

    public void nh(boolean z) {
        if (this.hnV != null) {
            if (this.hnW != null && z) {
                if (this.hnV.hasData()) {
                    this.hnW.bWx();
                    this.hnW.jH(true);
                } else {
                    hideNetRefreshView(this.rootView);
                    showLoadingView(this.rootView);
                }
            }
            this.hnV.refresh();
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void bT(int i, int i2) {
        if (!this.hnV.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.hnW != null) {
            this.hnW.bT(i, i2);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        nh(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.rootView);
            showLoadingView(this.rootView);
            nh(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.hnW != null) {
            this.hnW.ni(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        if (this.hnW != null) {
            this.hnW.ni(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        if (this.hnW != null) {
            this.hnW.ni(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        if (this.hnW != null) {
            this.hnW.ni(false);
        }
        super.showLoadingView(view, false, this.hnX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        if (this.hnW != null) {
            this.hnW.ni(true);
        }
    }

    public boolean bVj() {
        if (this.hnW != null) {
            return this.hnW.bWy();
        }
        return true;
    }

    public String getTabName() {
        return this.tabName;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a068";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.resourceId = this.tabName;
        }
        return pageStayDurationItem;
    }
}
