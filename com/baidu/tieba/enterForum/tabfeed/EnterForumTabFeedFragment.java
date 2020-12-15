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
import com.baidu.tieba.card.t;
import com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel;
/* loaded from: classes22.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {
    private EnterForumTabFeedNetModel iAW;
    private com.baidu.tieba.enterForum.tabfeed.view.a iAX;
    private int iAY;
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
        if (this.iAW == null) {
            this.iAW = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
            this.iAW.eR(this.tabCode, this.tabName);
            this.iAW.cwT();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (ViewGroup) layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.iAX = new com.baidu.tieba.enterForum.tabfeed.view.a(this, this, this.rootView, this.tabName);
        this.iAY = (l.getEquipmentHeight(getContext()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2;
        return this.rootView;
    }

    protected int getLayoutR() {
        return R.layout.enter_forum_tab_feed_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.iAX != null) {
                this.iAX.resume();
            }
        } else if (this.iAX != null) {
            this.iAX.pause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        t.csh().oX(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t.csh().oX(false);
        if (this.iAW != null) {
            this.iAW.destory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.rootView);
            if (this.iAW != null) {
                this.iAW.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.rootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iAX != null) {
            this.iAX.onChangeSkinType(i);
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
        if (!this.iAW.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.rootView, str, true);
        }
        if (this.iAX != null) {
            this.iAX.lx(false);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void a(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        hideLoadingView(this.rootView);
        if (!this.iAW.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.iAX != null) {
            this.iAX.b(bVar);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void cwK() {
        if (this.iAW != null) {
            this.iAW.bRN();
        }
    }

    public void py(boolean z) {
        if (this.iAW != null) {
            if (this.iAX != null && z) {
                if (this.iAW.hasData()) {
                    this.iAX.cwX();
                    this.iAX.lx(true);
                } else {
                    hideNetRefreshView(this.rootView);
                    showLoadingView(this.rootView);
                }
            }
            this.iAW.refresh();
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void cm(int i, int i2) {
        if (!this.iAW.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.iAX != null) {
            this.iAX.cm(i, i2);
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
        if (this.iAX != null) {
            this.iAX.pz(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        if (this.iAX != null) {
            this.iAX.pz(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        if (this.iAX != null) {
            this.iAX.pz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        if (this.iAX != null) {
            this.iAX.pz(false);
        }
        super.showLoadingView(view, false, this.iAY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        if (this.iAX != null) {
            this.iAX.pz(true);
        }
    }

    public boolean cvP() {
        if (this.iAX != null) {
            return this.iAX.cwY();
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
