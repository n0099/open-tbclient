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
    public static final int jYd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener epw;
    private NoNetworkView gdx;
    private ForumDetailActivity jXR;
    private LinearLayout jXU;
    private CustomScrollView jXV;
    private ItemHeaderView jXW;
    private ItemInfoView jXX;
    private ItemMsgManage jXY;
    private ItemEmotionView jXZ;
    private ItemHotThreadView jYa;
    private ItemFootNavView jYb;
    private com.baidu.tbadk.core.dialog.a jYc;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.jXR = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.jXU = (LinearLayout) this.jXR.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.jXR.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jXU.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.jXR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jXR.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gdx = (NoNetworkView) this.jXR.findViewById(R.id.no_network_view);
        this.jXV = (CustomScrollView) this.jXR.findViewById(R.id.scoll_view);
        this.jXV.setOnTouchListener(new View$OnTouchListenerC0745a());
        this.jXW = (ItemHeaderView) this.jXR.findViewById(R.id.item_header);
        this.jXX = (ItemInfoView) this.jXR.findViewById(R.id.item_info);
        this.jXY = (ItemMsgManage) this.jXR.findViewById(R.id.item_msg_manage);
        this.jXZ = (ItemEmotionView) this.jXR.findViewById(R.id.item_emotion_manage);
        this.jYa = (ItemHotThreadView) this.jXR.findViewById(R.id.item_hot_thread);
        this.jYb = (ItemFootNavView) this.jXR.findViewById(R.id.item_foot_nav);
        this.jYb.setClickable(true);
        this.mRootView = this.jXR.findViewById(R.id.root_rl);
        this.jXY.setMsgOnClickListener(this.jXR);
        this.jXZ.setEmotionOnClickListener(this.jXR);
        this.jXY.setSwitchChangeListener(this.jXR);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.jXW.setData(recommendForumInfo);
        this.jXX.setData(recommendForumInfo);
        this.jXY.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.jYb.setData(recommendForumInfo, this.jXR);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.jXZ.setEmotionData(forumEmotionData);
    }

    public void bD(List<SimpleThreadInfo> list) {
        this.jYa.setData(list);
    }

    public void hideLoading() {
        this.jXR.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.jXR.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.jXR.getLayoutMode().setNightMode(i == 1);
        this.jXR.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gdx.onChangeSkinType(getPageContext(), i);
        this.jXW.a(this.jXR, i);
        this.jXX.a(this.jXR, i);
        this.jXY.a(this.jXR, i);
        this.jYa.a(this.jXR, i);
        this.jYb.a(this.jXR, i);
    }

    public void onResume() {
        this.jYb.e(this.jXR);
    }

    public void cPt() {
        if (this.jYc == null) {
            this.jYc = new com.baidu.tbadk.core.dialog.a(this.jXR.getPageContext().getPageActivity());
            this.jYc.om(R.string.officical_bar_info_clean_alert);
            this.jYc.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.jYc.dismiss();
                    a.this.jXR.clearHistory();
                }
            });
            this.jYc.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.jYc.dismiss();
                }
            });
        }
        this.jYc.b(getPageContext()).bmC();
    }

    public NoNetworkView cPu() {
        return this.gdx;
    }

    public void f(View.OnClickListener onClickListener) {
        this.epw = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.jXY.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.jXY.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void CD(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jXR.getPageContext().getPageActivity(), this.jXU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, jYd), NoDataViewFactory.d.dS(null, this.jXR.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.epw);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.jXR.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.jXR.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class View$OnTouchListenerC0745a implements View.OnTouchListener {
        private View$OnTouchListenerC0745a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.jYb.rI(false);
                    break;
                case 1:
                    a.this.jYb.rI(true);
                    break;
                case 2:
                    a.this.jYb.rI(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.jYb.rH(z);
        this.jXY.setShowState(recommendForumInfo, z);
    }
}
