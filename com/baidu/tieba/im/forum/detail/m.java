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
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.tieba.z;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.g<ForumDetailActivity> {
    private View.OnClickListener aKM;
    private ForumDetailActivity baB;
    private LinearLayout baE;
    private CustomScrollView baF;
    private ItemHeaderView baG;
    private ItemInfoView baH;
    private ItemMsgManage baI;
    private ItemHotThreadView baJ;
    private ItemFootNavView baK;
    private com.baidu.tbadk.core.dialog.a baL;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public m(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.baB = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.baE = (LinearLayout) this.baB.findViewById(com.baidu.tieba.w.scoll_view_ll);
        this.mNavigationBar = (NavigationBar) this.baB.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.baB.getPageContext().getString(z.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNoNetworkView = (NoNetworkView) this.baB.findViewById(com.baidu.tieba.w.no_network_view);
        this.baF = (CustomScrollView) this.baB.findViewById(com.baidu.tieba.w.scoll_view);
        this.baF.setOnTouchListener(new p(this, null));
        this.baG = (ItemHeaderView) this.baB.findViewById(com.baidu.tieba.w.item_header);
        this.baH = (ItemInfoView) this.baB.findViewById(com.baidu.tieba.w.item_info);
        this.baI = (ItemMsgManage) this.baB.findViewById(com.baidu.tieba.w.item_msg_manage);
        this.baJ = (ItemHotThreadView) this.baB.findViewById(com.baidu.tieba.w.item_hot_thread);
        this.baK = (ItemFootNavView) this.baB.findViewById(com.baidu.tieba.w.item_foot_nav);
        this.mRootView = (ViewGroup) this.baB.findViewById(com.baidu.tieba.w.root_rl);
        Ov();
        this.baI.setMsgOnClickListener(this.baB);
        this.baI.setSwitchChangeListener(this.baB);
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        this.baG.setData(recommendForumInfo);
        this.baH.setData(recommendForumInfo);
        this.baI.setData(recommendForumInfo);
        this.baK.a(recommendForumInfo, this.baB);
    }

    public void G(List<SimpleThreadInfo> list) {
        this.baJ.setData(list);
    }

    public void Ou() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar Ov() {
        this.mProgressBar = new ProgressBar(this.baB.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.baB.getPageContext().getResources().getDrawable(com.baidu.tieba.v.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.baB.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.baB.getLayoutMode().ab(i == 1);
        this.baB.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.baG.a(this.baB, i);
        this.baH.a(this.baB, i);
        this.baI.a(this.baB, i);
        this.baJ.a(this.baB, i);
        this.baK.a(this.baB, i);
    }

    public void onResume() {
        this.baK.e(this.baB);
    }

    public void Ow() {
        if (this.baL == null) {
            this.baL = new com.baidu.tbadk.core.dialog.a(this.baB.getPageContext().getPageActivity());
            this.baL.by(z.officical_bar_info_clean_alert);
            this.baL.a(z.alert_yes_button, new n(this));
            this.baL.b(z.alert_no_button, new o(this));
            this.baL.ai(false);
        }
        this.baL.b(getPageContext()).nQ();
    }

    public NoNetworkView Ie() {
        return this.mNoNetworkView;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aKM = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.baI.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.baI.b(recommendForumInfo, z);
    }

    public void HW() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void fg(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.baB.getPageContext().getPageActivity(), this.baE, aa.a(NoDataViewFactory.ImgType.NODATA, 100), ab.cp(i), null);
            this.mNoDataView.setOnClickListener(this.aKM);
        }
        this.mNoDataView.setTextOption(ab.cp(i));
        this.mNoDataView.onChangeSkinType(this.baB.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }
}
