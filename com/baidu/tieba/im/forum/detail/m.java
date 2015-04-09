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
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.g<ForumDetailActivity> {
    private View.OnClickListener Nw;
    private ForumDetailActivity bcU;
    private LinearLayout bcX;
    private CustomScrollView bcY;
    private ItemHeaderView bcZ;
    private ItemInfoView bda;
    private ItemMsgManage bdb;
    private ItemHotThreadView bdc;
    private ItemFootNavView bdd;
    private com.baidu.tbadk.core.dialog.a bde;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public m(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.bcU = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.bcX = (LinearLayout) this.bcU.findViewById(com.baidu.tieba.v.scoll_view_ll);
        this.mNavigationBar = (NavigationBar) this.bcU.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bcU.getPageContext().getString(com.baidu.tieba.y.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNoNetworkView = (NoNetworkView) this.bcU.findViewById(com.baidu.tieba.v.no_network_view);
        this.bcY = (CustomScrollView) this.bcU.findViewById(com.baidu.tieba.v.scoll_view);
        this.bcY.setOnTouchListener(new p(this, null));
        this.bcZ = (ItemHeaderView) this.bcU.findViewById(com.baidu.tieba.v.item_header);
        this.bda = (ItemInfoView) this.bcU.findViewById(com.baidu.tieba.v.item_info);
        this.bdb = (ItemMsgManage) this.bcU.findViewById(com.baidu.tieba.v.item_msg_manage);
        this.bdc = (ItemHotThreadView) this.bcU.findViewById(com.baidu.tieba.v.item_hot_thread);
        this.bdd = (ItemFootNavView) this.bcU.findViewById(com.baidu.tieba.v.item_foot_nav);
        this.mRootView = (ViewGroup) this.bcU.findViewById(com.baidu.tieba.v.root_rl);
        Qx();
        this.bdb.setMsgOnClickListener(this.bcU);
        this.bdb.setSwitchChangeListener(this.bcU);
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        this.bcZ.setData(recommendForumInfo);
        this.bda.setData(recommendForumInfo);
        this.bdb.setData(recommendForumInfo);
        this.bdd.a(recommendForumInfo, this.bcU);
    }

    public void R(List<SimpleThreadInfo> list) {
        this.bdc.setData(list);
    }

    public void Qw() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar Qx() {
        this.mProgressBar = new ProgressBar(this.bcU.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.bcU.getPageContext().getResources().getDrawable(com.baidu.tieba.u.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.bcU.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.bcU.getLayoutMode().X(i == 1);
        this.bcU.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.bcZ.a(this.bcU, i);
        this.bda.a(this.bcU, i);
        this.bdb.a(this.bcU, i);
        this.bdc.a(this.bcU, i);
        this.bdd.a(this.bcU, i);
    }

    public void onResume() {
        this.bdd.e(this.bcU);
    }

    public void Qy() {
        if (this.bde == null) {
            this.bde = new com.baidu.tbadk.core.dialog.a(this.bcU.getPageContext().getPageActivity());
            this.bde.bx(com.baidu.tieba.y.officical_bar_info_clean_alert);
            this.bde.a(com.baidu.tieba.y.alert_yes_button, new n(this));
            this.bde.b(com.baidu.tieba.y.alert_no_button, new o(this));
            this.bde.ad(false);
        }
        this.bde.b(getPageContext()).re();
    }

    public NoNetworkView Mh() {
        return this.mNoNetworkView;
    }

    public void c(View.OnClickListener onClickListener) {
        this.Nw = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.bdb.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.bdb.b(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void fh(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bcU.getPageContext().getPageActivity(), this.bcX, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, 100), com.baidu.tbadk.core.view.w.cq(i), null);
            this.mNoDataView.setOnClickListener(this.Nw);
        }
        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(i));
        this.mNoDataView.onChangeSkinType(this.bcU.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }
}
