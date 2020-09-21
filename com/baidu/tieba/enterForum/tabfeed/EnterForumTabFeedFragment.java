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
/* loaded from: classes21.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {
    private EnterForumTabFeedNetModel hHU;
    private com.baidu.tieba.enterForum.tabfeed.view.a hHV;
    private int hHW;
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
        if (this.hHU == null) {
            this.hHU = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
            this.hHU.eA(this.tabCode, this.tabName);
            this.hHU.cjW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (ViewGroup) layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.hHV = new com.baidu.tieba.enterForum.tabfeed.view.a(this, this, this.rootView, this.tabName);
        this.hHW = (l.getEquipmentHeight(getContext()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2;
        return this.rootView;
    }

    protected int getLayoutR() {
        return R.layout.enter_forum_tab_feed_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.hHV != null) {
                this.hHV.resume();
            }
        } else if (this.hHV != null) {
            this.hHV.pause();
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
        if (this.hHU != null) {
            this.hHU.destory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.rootView);
            if (this.hHU != null) {
                this.hHU.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.rootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hHV != null) {
            this.hHV.onChangeSkinType(i);
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
        if (!this.hHU.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.rootView, str, true);
        }
        if (this.hHV != null) {
            this.hHV.ki(false);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void a(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        hideLoadingView(this.rootView);
        if (!this.hHU.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.hHV != null) {
            this.hHV.b(bVar);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void cjN() {
        if (this.hHU != null) {
            this.hHU.bGU();
        }
    }

    public void nT(boolean z) {
        if (this.hHU != null) {
            if (this.hHV != null && z) {
                if (this.hHU.hasData()) {
                    this.hHV.cka();
                    this.hHV.ki(true);
                } else {
                    hideNetRefreshView(this.rootView);
                    showLoadingView(this.rootView);
                }
            }
            this.hHU.refresh();
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void ce(int i, int i2) {
        if (!this.hHU.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.hHV != null) {
            this.hHV.ce(i, i2);
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
        if (this.hHV != null) {
            this.hHV.nU(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        if (this.hHV != null) {
            this.hHV.nU(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        if (this.hHV != null) {
            this.hHV.nU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        if (this.hHV != null) {
            this.hHV.nU(false);
        }
        super.showLoadingView(view, false, this.hHW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        if (this.hHV != null) {
            this.hHV.nU(true);
        }
    }

    public boolean ciS() {
        if (this.hHV != null) {
            return this.hHV.ckb();
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
