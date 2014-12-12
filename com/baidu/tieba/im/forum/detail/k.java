package com.baidu.tieba.im.forum.detail;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.tieba.z;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.g<ForumDetailActivity> {
    private View.OnClickListener aJF;
    private ForumDetailActivity aZf;
    private LinearLayout aZi;
    private CustomScrollView aZj;
    private ItemHeaderView aZk;
    private ItemInfoView aZl;
    private ItemMsgManage aZm;
    private ItemHotThreadView aZn;
    private ItemFootNavView aZo;
    private com.baidu.tbadk.core.dialog.a aZp;
    private NavigationBar mNavigationBar;
    private x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public k(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.aZf = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.aZi = (LinearLayout) this.aZf.findViewById(com.baidu.tieba.w.scoll_view_ll);
        this.mNavigationBar = (NavigationBar) this.aZf.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aZf.getPageContext().getString(z.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNoNetworkView = (NoNetworkView) this.aZf.findViewById(com.baidu.tieba.w.no_network_view);
        this.aZj = (CustomScrollView) this.aZf.findViewById(com.baidu.tieba.w.scoll_view);
        this.aZj.setOnTouchListener(new n(this, null));
        this.aZk = (ItemHeaderView) this.aZf.findViewById(com.baidu.tieba.w.item_header);
        this.aZl = (ItemInfoView) this.aZf.findViewById(com.baidu.tieba.w.item_info);
        this.aZm = (ItemMsgManage) this.aZf.findViewById(com.baidu.tieba.w.item_msg_manage);
        this.aZn = (ItemHotThreadView) this.aZf.findViewById(com.baidu.tieba.w.item_hot_thread);
        this.aZo = (ItemFootNavView) this.aZf.findViewById(com.baidu.tieba.w.item_foot_nav);
        this.mRootView = (ViewGroup) this.aZf.findViewById(com.baidu.tieba.w.root_rl);
        Oe();
        this.aZm.setMsgOnClickListener(this.aZf);
        this.aZm.setSwitchChangeListener(this.aZf);
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        this.aZk.setData(recommendForumInfo);
        this.aZl.setData(recommendForumInfo);
        this.aZm.setData(recommendForumInfo);
        this.aZo.a(recommendForumInfo, this.aZf);
    }

    public void E(List<SimpleThreadInfo> list) {
        this.aZn.setData(list);
    }

    public void Od() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar Oe() {
        this.mProgressBar = new ProgressBar(this.aZf.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.aZf.getPageContext().getResources().getDrawable(com.baidu.tieba.v.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.aZf.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.aZf.getLayoutMode().ab(i == 1);
        this.aZf.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.aZk.a(this.aZf, i);
        this.aZl.a(this.aZf, i);
        this.aZm.a(this.aZf, i);
        this.aZn.a(this.aZf, i);
        this.aZo.a(this.aZf, i);
    }

    public void onResume() {
        this.aZo.e(this.aZf);
    }

    public void Of() {
        if (this.aZp == null) {
            this.aZp = new com.baidu.tbadk.core.dialog.a(this.aZf.getPageContext().getPageActivity());
            this.aZp.bt(z.officical_bar_info_clean_alert);
            this.aZp.a(z.alert_yes_button, new l(this));
            this.aZp.b(z.alert_no_button, new m(this));
            this.aZp.ag(false);
        }
        this.aZp.b(getPageContext()).nU();
    }

    public NoNetworkView HN() {
        return this.mNoNetworkView;
    }

    public void o(View.OnClickListener onClickListener) {
        this.aJF = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.aZm.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.aZm.b(recommendForumInfo, z);
    }

    public void HE() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void fb(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aZf.getPageContext().getPageActivity(), this.aZi, aa.a(NoDataViewFactory.ImgType.NODATA, 100), ab.ci(i), null);
            this.mNoDataView.setOnClickListener(this.aJF);
        }
        this.mNoDataView.setTextOption(ab.ci(i));
        this.mNoDataView.onChangeSkinType(this.aZf.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }
}
