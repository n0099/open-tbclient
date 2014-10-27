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
    private ForumDetailData awZ;
    private ItemHeaderView axa;
    private ItemInfoView axb;
    private ItemHotThreadView axc;
    private ItemFootNavView axd;
    BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public e(BaseActivity baseActivity) {
        super(baseActivity);
        this.mActivity = null;
        this.awZ = null;
        this.mRootView = null;
        this.mActivity = baseActivity;
        initUI();
    }

    public void d(ForumDetailData forumDetailData) {
        this.awZ = forumDetailData;
        this.mProgressBar.setVisibility(8);
        DY();
        DZ();
        Ea();
        Eb();
    }

    private void initUI() {
        this.mActivity.setContentView(w.forum_detail_activity);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mActivity.getString(y.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.axa = (ItemHeaderView) this.mActivity.findViewById(v.item_header);
        this.axb = (ItemInfoView) this.mActivity.findViewById(v.item_info);
        this.axc = (ItemHotThreadView) this.mActivity.findViewById(v.item_hot_thread);
        this.axd = (ItemFootNavView) this.mActivity.findViewById(v.item_foot_nav);
        this.mRootView = (ViewGroup) this.mActivity.findViewById(v.parent);
        DX().setVisibility(0);
    }

    private ProgressBar DX() {
        this.mProgressBar = new ProgressBar(this.mActivity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.mActivity.getResources().getDrawable(u.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.mActivity.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    private void DY() {
        if (this.axa.e(this.awZ)) {
            this.axa.setVisibility(0);
        }
    }

    private void DZ() {
        if (this.axb.a(this.awZ, this.mActivity)) {
            this.axb.setVisibility(0);
        }
    }

    private void Ea() {
        if (this.axc.e(this.awZ)) {
            this.axc.setVisibility(0);
        }
    }

    private void Eb() {
        if (this.axd.a(this.awZ, this.mActivity)) {
            this.axd.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(i);
        this.axa.a(this.mActivity, i);
        this.axb.a(this.mActivity, i);
        this.axc.a(this.mActivity, i);
        this.axd.a(this.mActivity, i);
    }

    public void onResume() {
        this.axd.b(this.mActivity);
    }
}
