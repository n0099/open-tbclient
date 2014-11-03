package com.baidu.tieba.forumdetail;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    private ForumDetailData axi;
    private ItemHeaderView axj;
    private ItemInfoView axk;
    private ItemHotThreadView axl;
    private ItemFootNavView axm;
    BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public e(BaseActivity baseActivity) {
        super(baseActivity);
        this.mActivity = null;
        this.axi = null;
        this.mRootView = null;
        this.mActivity = baseActivity;
        initUI();
    }

    public void d(ForumDetailData forumDetailData) {
        this.axi = forumDetailData;
        this.mProgressBar.setVisibility(8);
        Ea();
        Eb();
        Ec();
        Ed();
    }

    private void initUI() {
        this.mActivity.setContentView(w.forum_detail_activity);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mActivity.getString(y.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.axj = (ItemHeaderView) this.mActivity.findViewById(v.item_header);
        this.axk = (ItemInfoView) this.mActivity.findViewById(v.item_info);
        this.axl = (ItemHotThreadView) this.mActivity.findViewById(v.item_hot_thread);
        this.axm = (ItemFootNavView) this.mActivity.findViewById(v.item_foot_nav);
        this.mRootView = (ViewGroup) this.mActivity.findViewById(v.parent);
        DZ().setVisibility(0);
    }

    private ProgressBar DZ() {
        this.mProgressBar = new ProgressBar(this.mActivity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.mActivity.getResources().getDrawable(u.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.mActivity.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    private void Ea() {
        if (this.axj.e(this.axi)) {
            this.axj.setVisibility(0);
        }
    }

    private void Eb() {
        if (this.axk.a(this.axi, this.mActivity)) {
            this.axk.setVisibility(0);
        }
    }

    private void Ec() {
        if (this.axl.e(this.axi)) {
            this.axl.setVisibility(0);
        }
    }

    private void Ed() {
        if (this.axm.a(this.axi, this.mActivity)) {
            this.axm.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(i);
        this.axj.a(this.mActivity, i);
        this.axk.a(this.mActivity, i);
        this.axl.a(this.mActivity, i);
        this.axm.a(this.mActivity, i);
    }

    public void onResume() {
        this.axm.b(this.mActivity);
    }
}
