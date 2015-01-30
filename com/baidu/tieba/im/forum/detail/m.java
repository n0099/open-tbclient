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
    private View.OnClickListener aKP;
    private ForumDetailActivity baC;
    private LinearLayout baF;
    private CustomScrollView baG;
    private ItemHeaderView baH;
    private ItemInfoView baI;
    private ItemMsgManage baJ;
    private ItemHotThreadView baK;
    private ItemFootNavView baL;
    private com.baidu.tbadk.core.dialog.a baM;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public m(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.baC = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.baF = (LinearLayout) this.baC.findViewById(com.baidu.tieba.w.scoll_view_ll);
        this.mNavigationBar = (NavigationBar) this.baC.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.baC.getPageContext().getString(z.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNoNetworkView = (NoNetworkView) this.baC.findViewById(com.baidu.tieba.w.no_network_view);
        this.baG = (CustomScrollView) this.baC.findViewById(com.baidu.tieba.w.scoll_view);
        this.baG.setOnTouchListener(new p(this, null));
        this.baH = (ItemHeaderView) this.baC.findViewById(com.baidu.tieba.w.item_header);
        this.baI = (ItemInfoView) this.baC.findViewById(com.baidu.tieba.w.item_info);
        this.baJ = (ItemMsgManage) this.baC.findViewById(com.baidu.tieba.w.item_msg_manage);
        this.baK = (ItemHotThreadView) this.baC.findViewById(com.baidu.tieba.w.item_hot_thread);
        this.baL = (ItemFootNavView) this.baC.findViewById(com.baidu.tieba.w.item_foot_nav);
        this.mRootView = (ViewGroup) this.baC.findViewById(com.baidu.tieba.w.root_rl);
        OA();
        this.baJ.setMsgOnClickListener(this.baC);
        this.baJ.setSwitchChangeListener(this.baC);
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        this.baH.setData(recommendForumInfo);
        this.baI.setData(recommendForumInfo);
        this.baJ.setData(recommendForumInfo);
        this.baL.a(recommendForumInfo, this.baC);
    }

    public void G(List<SimpleThreadInfo> list) {
        this.baK.setData(list);
    }

    public void Oz() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar OA() {
        this.mProgressBar = new ProgressBar(this.baC.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.baC.getPageContext().getResources().getDrawable(com.baidu.tieba.v.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.baC.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.baC.getLayoutMode().ab(i == 1);
        this.baC.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        this.baH.a(this.baC, i);
        this.baI.a(this.baC, i);
        this.baJ.a(this.baC, i);
        this.baK.a(this.baC, i);
        this.baL.a(this.baC, i);
    }

    public void onResume() {
        this.baL.e(this.baC);
    }

    public void OB() {
        if (this.baM == null) {
            this.baM = new com.baidu.tbadk.core.dialog.a(this.baC.getPageContext().getPageActivity());
            this.baM.by(z.officical_bar_info_clean_alert);
            this.baM.a(z.alert_yes_button, new n(this));
            this.baM.b(z.alert_no_button, new o(this));
            this.baM.ai(false);
        }
        this.baM.b(getPageContext()).nX();
    }

    public NoNetworkView Ik() {
        return this.mNoNetworkView;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aKP = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.baJ.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.baJ.b(recommendForumInfo, z);
    }

    public void Ic() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void fg(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.baC.getPageContext().getPageActivity(), this.baF, aa.a(NoDataViewFactory.ImgType.NODATA, 100), ab.cp(i), null);
            this.mNoDataView.setOnClickListener(this.aKP);
        }
        this.mNoDataView.setTextOption(ab.cp(i));
        this.mNoDataView.onChangeSkinType(this.baC.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }
}
