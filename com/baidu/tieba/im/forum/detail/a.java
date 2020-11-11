package com.baidu.tieba.im.forum.detail;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
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
/* loaded from: classes26.dex */
public class a extends c<ForumDetailActivity> {
    public static final int kea = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener evp;
    private NoNetworkView gjn;
    private ForumDetailActivity kdO;
    private LinearLayout kdR;
    private CustomScrollView kdS;
    private ItemHeaderView kdT;
    private ItemInfoView kdU;
    private ItemMsgManage kdV;
    private ItemEmotionView kdW;
    private ItemHotThreadView kdX;
    private ItemFootNavView kdY;
    private com.baidu.tbadk.core.dialog.a kdZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.kdO = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.kdR = (LinearLayout) this.kdO.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.kdO.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kdR.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.kdO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kdO.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gjn = (NoNetworkView) this.kdO.findViewById(R.id.no_network_view);
        this.kdS = (CustomScrollView) this.kdO.findViewById(R.id.scoll_view);
        this.kdS.setOnTouchListener(new View$OnTouchListenerC0759a());
        this.kdT = (ItemHeaderView) this.kdO.findViewById(R.id.item_header);
        this.kdU = (ItemInfoView) this.kdO.findViewById(R.id.item_info);
        this.kdV = (ItemMsgManage) this.kdO.findViewById(R.id.item_msg_manage);
        this.kdW = (ItemEmotionView) this.kdO.findViewById(R.id.item_emotion_manage);
        this.kdX = (ItemHotThreadView) this.kdO.findViewById(R.id.item_hot_thread);
        this.kdY = (ItemFootNavView) this.kdO.findViewById(R.id.item_foot_nav);
        this.kdY.setClickable(true);
        this.mRootView = this.kdO.findViewById(R.id.root_rl);
        this.kdV.setMsgOnClickListener(this.kdO);
        this.kdW.setEmotionOnClickListener(this.kdO);
        this.kdV.setSwitchChangeListener(this.kdO);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.kdT.setData(recommendForumInfo);
        this.kdU.setData(recommendForumInfo);
        this.kdV.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.kdY.setData(recommendForumInfo, this.kdO);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.kdW.setEmotionData(forumEmotionData);
    }

    public void bK(List<SimpleThreadInfo> list) {
        this.kdX.setData(list);
    }

    public void hideLoading() {
        this.kdO.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.kdO.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.kdO.getLayoutMode().setNightMode(i == 1);
        this.kdO.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gjn.onChangeSkinType(getPageContext(), i);
        this.kdT.a(this.kdO, i);
        this.kdU.a(this.kdO, i);
        this.kdV.a(this.kdO, i);
        this.kdX.a(this.kdO, i);
        this.kdY.a(this.kdO, i);
    }

    public void onResume() {
        this.kdY.e(this.kdO);
    }

    public void cRU() {
        if (this.kdZ == null) {
            this.kdZ = new com.baidu.tbadk.core.dialog.a(this.kdO.getPageContext().getPageActivity());
            this.kdZ.ow(R.string.officical_bar_info_clean_alert);
            this.kdZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kdZ.dismiss();
                    a.this.kdO.clearHistory();
                }
            });
            this.kdZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kdZ.dismiss();
                }
            });
        }
        this.kdZ.b(getPageContext()).bpc();
    }

    public NoNetworkView cRV() {
        return this.gjn;
    }

    public void g(View.OnClickListener onClickListener) {
        this.evp = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.kdV.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kdV.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void CQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kdO.getPageContext().getPageActivity(), this.kdR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, kea), NoDataViewFactory.d.dS(null, this.kdO.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.evp);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.kdO.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.kdO.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class View$OnTouchListenerC0759a implements View.OnTouchListener {
        private View$OnTouchListenerC0759a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.kdY.rR(false);
                    break;
                case 1:
                    a.this.kdY.rR(true);
                    break;
                case 2:
                    a.this.kdY.rR(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kdY.rQ(z);
        this.kdV.setShowState(recommendForumInfo, z);
    }
}
