package com.baidu.tieba.im.forum.detail;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes8.dex */
public class a extends d<ForumDetailActivity> {
    public static final int kDa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener eKl;
    private NoNetworkView gCe;
    private ForumDetailActivity kCO;
    private LinearLayout kCR;
    private CustomScrollView kCS;
    private ItemHeaderView kCT;
    private ItemInfoView kCU;
    private ItemMsgManage kCV;
    private ItemEmotionView kCW;
    private ItemHotThreadView kCX;
    private ItemFootNavView kCY;
    private com.baidu.tbadk.core.dialog.a kCZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.kCO = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.kCR = (LinearLayout) this.kCO.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.kCO.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kCR.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.kCO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kCO.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gCe = (NoNetworkView) this.kCO.findViewById(R.id.no_network_view);
        this.kCS = (CustomScrollView) this.kCO.findViewById(R.id.scoll_view);
        this.kCS.setOnTouchListener(new View$OnTouchListenerC0772a());
        this.kCT = (ItemHeaderView) this.kCO.findViewById(R.id.item_header);
        this.kCU = (ItemInfoView) this.kCO.findViewById(R.id.item_info);
        this.kCV = (ItemMsgManage) this.kCO.findViewById(R.id.item_msg_manage);
        this.kCW = (ItemEmotionView) this.kCO.findViewById(R.id.item_emotion_manage);
        this.kCX = (ItemHotThreadView) this.kCO.findViewById(R.id.item_hot_thread);
        this.kCY = (ItemFootNavView) this.kCO.findViewById(R.id.item_foot_nav);
        this.kCY.setClickable(true);
        this.mRootView = this.kCO.findViewById(R.id.root_rl);
        this.kCV.setMsgOnClickListener(this.kCO);
        this.kCW.setEmotionOnClickListener(this.kCO);
        this.kCV.setSwitchChangeListener(this.kCO);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.kCT.setData(recommendForumInfo);
        this.kCU.setData(recommendForumInfo);
        this.kCV.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.kCY.setData(recommendForumInfo, this.kCO);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.kCW.setEmotionData(forumEmotionData);
    }

    public void bV(List<SimpleThreadInfo> list) {
        this.kCX.setData(list);
    }

    public void hideLoading() {
        this.kCO.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.kCO.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.kCO.getLayoutMode().setNightMode(i == 1);
        this.kCO.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gCe.onChangeSkinType(getPageContext(), i);
        this.kCT.a(this.kCO, i);
        this.kCU.a(this.kCO, i);
        this.kCV.a(this.kCO, i);
        this.kCX.a(this.kCO, i);
        this.kCY.a(this.kCO, i);
    }

    public void onResume() {
        this.kCY.e(this.kCO);
    }

    public void cYk() {
        if (this.kCZ == null) {
            this.kCZ = new com.baidu.tbadk.core.dialog.a(this.kCO.getPageContext().getPageActivity());
            this.kCZ.pa(R.string.officical_bar_info_clean_alert);
            this.kCZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kCZ.dismiss();
                    a.this.kCO.clearHistory();
                }
            });
            this.kCZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kCZ.dismiss();
                }
            });
        }
        this.kCZ.b(getPageContext()).btY();
    }

    public NoNetworkView cYl() {
        return this.gCe;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eKl = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.kCV.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kCV.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void En(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kCO.getPageContext().getPageActivity(), this.kCR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, kDa), NoDataViewFactory.d.dY(null, this.kCO.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.eKl);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, this.kCO.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.kCO.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC0772a implements View.OnTouchListener {
        private View$OnTouchListenerC0772a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.kCY.sL(false);
                    break;
                case 1:
                    a.this.kCY.sL(true);
                    break;
                case 2:
                    a.this.kCY.sL(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kCY.sK(z);
        this.kCV.setShowState(recommendForumInfo, z);
    }
}
