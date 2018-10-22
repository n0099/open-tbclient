package com.baidu.tieba.frs.commontab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class FrsCommonTabFragment extends BaseFragment implements j.b {
    private b dGR;
    private c dGS;
    public boolean dGT;
    public boolean dGU;
    public String forumId;
    public boolean isBrandForum;
    private View mRootView;
    public int tabId;
    private int dGV = 3;
    private CustomMessageListener dBh = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.dGR != null) {
                        FrsCommonTabFragment.this.dGR.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.mRefreshView == null || !FrsCommonTabFragment.this.mRefreshView.Mq()) {
                        FrsCommonTabFragment.this.dGR.cQ(true);
                        FrsCommonTabFragment.this.bp(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        return;
                    }
                    FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.tabId = bundle.getInt(MyBookrackActivityConfig.TAB_ID);
            this.forumId = bundle.getString("forum_id");
            this.dGU = bundle.getBoolean("can_auto_play_video");
            this.dGT = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
                this.forumId = arguments.getString("forum_id");
                this.dGU = arguments.getBoolean("can_auto_play_video");
                this.dGT = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
            }
        }
        this.dGS = new c(this, Integer.parseInt(this.forumId), this.tabId);
        setNetRefreshViewTextAndPicDistance(getResources().getDimensionPixelSize(e.C0175e.ds_102));
        registerListener(this.dBh);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(e.h.frs_common_tab_fragment, (ViewGroup) null);
        this.dGR = new b(this, this.mRootView);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.kX()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(e.C0175e.ds250));
            aCc();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.dGR.gN(false);
        super.showNetRefreshView(view, str, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.dGR.gN(true);
        super.hideNetRefreshView(view);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.dGR != null) {
                this.dGR.cQ(false);
                this.dGR.a(dVar);
            }
        }
    }

    public void a(ErrorData errorData) {
        hideLoadingView(this.mRootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(e.j.im_error_default);
            }
        }
        if (!this.dGS.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(e.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.dGR != null) {
            this.dGR.cQ(false);
        }
    }

    public void aCb() {
        if (l.lo() && this.dGS != null) {
            this.dGS.YL();
        }
    }

    private void aCc() {
        if (l.lo() && this.dGS != null) {
            this.dGS.aCc();
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        if (com.baidu.adp.lib.util.j.kX()) {
            hideNetRefreshView(this.mRootView);
            if (this.dGS.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(e.C0175e.ds250));
            }
            aCc();
            return;
        }
        this.dGR.cQ(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kX()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(e.C0175e.ds250));
            aCc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        v.aop().fh(false);
        super.onDestroy();
        if (this.dGR != null) {
            this.dGR.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.dGR != null) {
                this.dGR.resume();
            }
        } else if (this.dGR != null) {
            this.dGR.pause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dGR != null) {
            this.dGR.resume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dGR != null) {
            this.dGR.pause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dGV != 3 || this.dGR != null) {
            this.dGV = i;
            super.onChangeSkinType(i);
            this.dGR.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MyBookrackActivityConfig.TAB_ID, this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.dGU);
        bundle.putBoolean("need_log", this.dGT);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
    }
}
