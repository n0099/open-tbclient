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
/* loaded from: classes2.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {
    private EnterForumTabFeedNetModel iIB;
    private com.baidu.tieba.enterForum.tabfeed.view.a iIC;
    private int iID;
    private ViewGroup rootView;
    private String tabCode;
    private String tabName;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iIB == null) {
            this.iIB = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
            this.iIB.eR(this.tabCode, this.tabName);
            this.iIB.cvV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (ViewGroup) layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.iIC = new com.baidu.tieba.enterForum.tabfeed.view.a(this, this, this.rootView, this.tabName);
        this.iID = (l.getEquipmentHeight(getContext()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2;
        return this.rootView;
    }

    protected int getLayoutR() {
        return R.layout.enter_forum_tab_feed_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.iIC != null) {
                this.iIC.resume();
            }
        } else if (this.iIC != null) {
            this.iIC.pause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        s.crj().pr(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        s.crj().pr(false);
        if (this.iIB != null) {
            this.iIB.destory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.rootView);
            if (this.iIB != null) {
                this.iIB.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.rootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iIC != null) {
            this.iIC.onChangeSkinType(i);
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
        if (!this.iIB.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.rootView, str, true);
        }
        if (this.iIC != null) {
            this.iIC.lQ(false);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void a(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        hideLoadingView(this.rootView);
        if (!this.iIB.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.iIC != null) {
            this.iIC.b(bVar);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void cvM() {
        if (this.iIB != null) {
            this.iIB.bQy();
        }
    }

    public void pR(boolean z) {
        if (this.iIB != null) {
            if (this.iIC != null && z) {
                if (this.iIB.hasData()) {
                    this.iIC.cvZ();
                    this.iIC.lQ(true);
                } else {
                    hideNetRefreshView(this.rootView);
                    showLoadingView(this.rootView);
                }
            }
            this.iIB.refresh();
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void cl(int i, int i2) {
        if (!this.iIB.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.iIC != null) {
            this.iIC.cl(i, i2);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        pR(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.rootView);
            showLoadingView(this.rootView);
            pR(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.iIC != null) {
            this.iIC.pS(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        if (this.iIC != null) {
            this.iIC.pS(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        if (this.iIC != null) {
            this.iIC.pS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        if (this.iIC != null) {
            this.iIC.pS(false);
        }
        super.showLoadingView(view, false, this.iID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        if (this.iIC != null) {
            this.iIC.pS(true);
        }
    }

    public boolean cuR() {
        if (this.iIC != null) {
            return this.iIC.cwa();
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
