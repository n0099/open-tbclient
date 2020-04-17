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
import com.baidu.tieba.card.r;
import com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel;
/* loaded from: classes9.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {
    private EnterForumTabFeedNetModel gGB;
    private com.baidu.tieba.enterForum.tabfeed.view.a gGC;
    private int gGD;
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
        if (this.gGB == null) {
            this.gGB = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
            this.gGB.dw(this.tabCode, this.tabName);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (ViewGroup) layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.gGC = new com.baidu.tieba.enterForum.tabfeed.view.a(this, this, this.rootView, this.tabName);
        this.gGD = (l.getEquipmentHeight(getContext()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2;
        return this.rootView;
    }

    protected int getLayoutR() {
        return R.layout.enter_forum_tab_feed_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gGC != null) {
                this.gGC.resume();
            }
        } else if (this.gGC != null) {
            this.gGC.pause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        r.bEY().lx(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        r.bEY().lx(false);
        if (this.gGB != null) {
            this.gGB.destory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.rootView);
            if (this.gGB != null) {
                this.gGB.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.rootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gGC != null) {
            this.gGC.onChangeSkinType(i);
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
        if (!this.gGB.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.rootView, str, true);
        }
        if (this.gGC != null) {
            this.gGC.it(false);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void a(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        hideLoadingView(this.rootView);
        if (!this.gGB.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.gGC != null) {
            this.gGC.b(bVar);
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void bJv() {
        if (this.gGB != null) {
            this.gGB.blb();
        }
    }

    public void lW(boolean z) {
        if (this.gGB != null) {
            if (this.gGC != null && z) {
                if (this.gGB.hasData()) {
                    this.gGC.bJG();
                    this.gGC.it(true);
                } else {
                    hideNetRefreshView(this.rootView);
                    showLoadingView(this.rootView);
                }
            }
            this.gGB.refresh();
        }
    }

    @Override // com.baidu.tieba.enterForum.tabfeed.b
    public void bI(int i, int i2) {
        if (!this.gGB.hasData()) {
            showNoDataRefreshView(this.rootView, false);
        } else if (this.gGC != null) {
            this.gGC.bI(i, i2);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        lW(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.rootView);
            showLoadingView(this.rootView);
            lW(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.gGC != null) {
            this.gGC.lX(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        if (this.gGC != null) {
            this.gGC.lX(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        if (this.gGC != null) {
            this.gGC.lX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        if (this.gGC != null) {
            this.gGC.lX(false);
        }
        super.showLoadingView(view, false, this.gGD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        if (this.gGC != null) {
            this.gGC.lX(true);
        }
    }

    public boolean bIu() {
        if (this.gGC != null) {
            return this.gGC.bJH();
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
