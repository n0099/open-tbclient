package com.baidu.tieba.im.forum.detail;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener bUp;
    private NoNetworkView dvR;
    private ForumDetailActivity gEO;
    private LinearLayout gER;
    private CustomScrollView gES;
    private ItemHeaderView gET;
    private ItemInfoView gEU;
    private ItemMsgManage gEV;
    private ItemEmotionView gEW;
    private ItemHotThreadView gEX;
    private ItemFootNavView gEY;
    private com.baidu.tbadk.core.dialog.a gEZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.gEO = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.gER = (LinearLayout) this.gEO.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.gEO.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gER.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.gEO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gEO.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dvR = (NoNetworkView) this.gEO.findViewById(R.id.no_network_view);
        this.gES = (CustomScrollView) this.gEO.findViewById(R.id.scoll_view);
        this.gES.setOnTouchListener(new View$OnTouchListenerC0431a());
        this.gET = (ItemHeaderView) this.gEO.findViewById(R.id.item_header);
        this.gEU = (ItemInfoView) this.gEO.findViewById(R.id.item_info);
        this.gEV = (ItemMsgManage) this.gEO.findViewById(R.id.item_msg_manage);
        this.gEW = (ItemEmotionView) this.gEO.findViewById(R.id.item_emotion_manage);
        this.gEX = (ItemHotThreadView) this.gEO.findViewById(R.id.item_hot_thread);
        this.gEY = (ItemFootNavView) this.gEO.findViewById(R.id.item_foot_nav);
        this.gEY.setClickable(true);
        this.mRootView = this.gEO.findViewById(R.id.root_rl);
        bAT();
        this.gEV.setMsgOnClickListener(this.gEO);
        this.gEW.setEmotionOnClickListener(this.gEO);
        this.gEV.setSwitchChangeListener(this.gEO);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.gET.setData(recommendForumInfo);
        this.gEU.setData(recommendForumInfo);
        this.gEV.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.gEY.setData(recommendForumInfo, this.gEO);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.gEW.setEmotionData(forumEmotionData);
    }

    public void aN(List<SimpleThreadInfo> list) {
        this.gEX.setData(list);
    }

    public void boO() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bAT() {
        this.mProgressBar = new ProgressBar(this.gEO.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.gEO.getPageContext().getResources().getDrawable(R.drawable.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.gEO.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.gEO.getLayoutMode().setNightMode(i == 1);
        this.gEO.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dvR.onChangeSkinType(getPageContext(), i);
        this.gET.a(this.gEO, i);
        this.gEU.a(this.gEO, i);
        this.gEV.a(this.gEO, i);
        this.gEX.a(this.gEO, i);
        this.gEY.a(this.gEO, i);
    }

    public void onResume() {
        this.gEY.e(this.gEO);
    }

    public void bAU() {
        if (this.gEZ == null) {
            this.gEZ = new com.baidu.tbadk.core.dialog.a(this.gEO.getPageContext().getPageActivity());
            this.gEZ.hT(R.string.officical_bar_info_clean_alert);
            this.gEZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gEZ.dismiss();
                    a.this.gEO.bAL();
                }
            });
            this.gEZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gEZ.dismiss();
                }
            });
        }
        this.gEZ.b(getPageContext()).akM();
    }

    public NoNetworkView bAV() {
        return this.dvR;
    }

    public void e(View.OnClickListener onClickListener) {
        this.bUp = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.gEV.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gEV.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ub(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gEO.getPageContext().getPageActivity(), this.gER, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.iK(i), null);
            this.mNoDataView.setOnClickListener(this.bUp);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(i));
        this.mNoDataView.onChangeSkinType(this.gEO.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0431a implements View.OnTouchListener {
        private View$OnTouchListenerC0431a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.gEY.lV(false);
                    break;
                case 1:
                    a.this.gEY.lV(true);
                    break;
                case 2:
                    a.this.gEY.lV(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gEY.lU(z);
        this.gEV.setShowState(recommendForumInfo, z);
    }
}
