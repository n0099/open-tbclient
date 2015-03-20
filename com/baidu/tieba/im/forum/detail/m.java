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
    private View.OnClickListener Nu;
    private ForumDetailActivity bcE;
    private LinearLayout bcH;
    private CustomScrollView bcI;
    private ItemHeaderView bcJ;
    private ItemInfoView bcK;
    private ItemMsgManage bcL;
    private ItemHotThreadView bcM;
    private ItemFootNavView bcN;
    private com.baidu.tbadk.core.dialog.a bcO;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public m(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.bcE = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.bcH = (LinearLayout) this.bcE.findViewById(com.baidu.tieba.v.scoll_view_ll);
        this.mNavigationBar = (NavigationBar) this.bcE.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bcE.getPageContext().getString(com.baidu.tieba.y.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNoNetworkView = (NoNetworkView) this.bcE.findViewById(com.baidu.tieba.v.no_network_view);
        this.bcI = (CustomScrollView) this.bcE.findViewById(com.baidu.tieba.v.scoll_view);
        this.bcI.setOnTouchListener(new p(this, null));
        this.bcJ = (ItemHeaderView) this.bcE.findViewById(com.baidu.tieba.v.item_header);
        this.bcK = (ItemInfoView) this.bcE.findViewById(com.baidu.tieba.v.item_info);
        this.bcL = (ItemMsgManage) this.bcE.findViewById(com.baidu.tieba.v.item_msg_manage);
        this.bcM = (ItemHotThreadView) this.bcE.findViewById(com.baidu.tieba.v.item_hot_thread);
        this.bcN = (ItemFootNavView) this.bcE.findViewById(com.baidu.tieba.v.item_foot_nav);
        this.mRootView = (ViewGroup) this.bcE.findViewById(com.baidu.tieba.v.root_rl);
        Qk();
        this.bcL.setMsgOnClickListener(this.bcE);
        this.bcL.setSwitchChangeListener(this.bcE);
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        this.bcJ.setData(recommendForumInfo);
        this.bcK.setData(recommendForumInfo);
        this.bcL.setData(recommendForumInfo);
        this.bcN.a(recommendForumInfo, this.bcE);
    }

    public void R(List<SimpleThreadInfo> list) {
        this.bcM.setData(list);
    }

    public void Qj() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar Qk() {
        this.mProgressBar = new ProgressBar(this.bcE.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.bcE.getPageContext().getResources().getDrawable(com.baidu.tieba.u.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.bcE.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.bcE.getLayoutMode().X(i == 1);
        this.bcE.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.bcJ.a(this.bcE, i);
        this.bcK.a(this.bcE, i);
        this.bcL.a(this.bcE, i);
        this.bcM.a(this.bcE, i);
        this.bcN.a(this.bcE, i);
    }

    public void onResume() {
        this.bcN.e(this.bcE);
    }

    public void Ql() {
        if (this.bcO == null) {
            this.bcO = new com.baidu.tbadk.core.dialog.a(this.bcE.getPageContext().getPageActivity());
            this.bcO.bx(com.baidu.tieba.y.officical_bar_info_clean_alert);
            this.bcO.a(com.baidu.tieba.y.alert_yes_button, new n(this));
            this.bcO.b(com.baidu.tieba.y.alert_no_button, new o(this));
            this.bcO.ad(false);
        }
        this.bcO.b(getPageContext()).re();
    }

    public NoNetworkView LU() {
        return this.mNoNetworkView;
    }

    public void c(View.OnClickListener onClickListener) {
        this.Nu = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.bcL.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.bcL.b(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void fg(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bcE.getPageContext().getPageActivity(), this.bcH, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, 100), com.baidu.tbadk.core.view.w.cq(i), null);
            this.mNoDataView.setOnClickListener(this.Nu);
        }
        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(i));
        this.mNoDataView.onChangeSkinType(this.bcE.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }
}
