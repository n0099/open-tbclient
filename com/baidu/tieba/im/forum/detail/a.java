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
/* loaded from: classes20.dex */
public class a extends c<ForumDetailActivity> {
    public static final int jof = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dSM;
    private NoNetworkView fDZ;
    private ForumDetailActivity jnT;
    private LinearLayout jnW;
    private CustomScrollView jnX;
    private ItemHeaderView jnY;
    private ItemInfoView jnZ;
    private ItemMsgManage joa;
    private ItemEmotionView job;
    private ItemHotThreadView joc;
    private ItemFootNavView jod;
    private com.baidu.tbadk.core.dialog.a joe;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.jnT = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.jnW = (LinearLayout) this.jnT.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.jnT.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jnW.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.jnT.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jnT.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fDZ = (NoNetworkView) this.jnT.findViewById(R.id.no_network_view);
        this.jnX = (CustomScrollView) this.jnT.findViewById(R.id.scoll_view);
        this.jnX.setOnTouchListener(new View$OnTouchListenerC0714a());
        this.jnY = (ItemHeaderView) this.jnT.findViewById(R.id.item_header);
        this.jnZ = (ItemInfoView) this.jnT.findViewById(R.id.item_info);
        this.joa = (ItemMsgManage) this.jnT.findViewById(R.id.item_msg_manage);
        this.job = (ItemEmotionView) this.jnT.findViewById(R.id.item_emotion_manage);
        this.joc = (ItemHotThreadView) this.jnT.findViewById(R.id.item_hot_thread);
        this.jod = (ItemFootNavView) this.jnT.findViewById(R.id.item_foot_nav);
        this.jod.setClickable(true);
        this.mRootView = this.jnT.findViewById(R.id.root_rl);
        this.joa.setMsgOnClickListener(this.jnT);
        this.job.setEmotionOnClickListener(this.jnT);
        this.joa.setSwitchChangeListener(this.jnT);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.jnY.setData(recommendForumInfo);
        this.jnZ.setData(recommendForumInfo);
        this.joa.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.jod.setData(recommendForumInfo, this.jnT);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.job.setEmotionData(forumEmotionData);
    }

    public void bm(List<SimpleThreadInfo> list) {
        this.joc.setData(list);
    }

    public void hideLoading() {
        this.jnT.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.jnT.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.jnT.getLayoutMode().setNightMode(i == 1);
        this.jnT.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fDZ.onChangeSkinType(getPageContext(), i);
        this.jnY.a(this.jnT, i);
        this.jnZ.a(this.jnT, i);
        this.joa.a(this.jnT, i);
        this.joc.a(this.jnT, i);
        this.jod.a(this.jnT, i);
    }

    public void onResume() {
        this.jod.e(this.jnT);
    }

    public void cEX() {
        if (this.joe == null) {
            this.joe = new com.baidu.tbadk.core.dialog.a(this.jnT.getPageContext().getPageActivity());
            this.joe.nt(R.string.officical_bar_info_clean_alert);
            this.joe.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.joe.dismiss();
                    a.this.jnT.clearHistory();
                }
            });
            this.joe.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.joe.dismiss();
                }
            });
        }
        this.joe.b(getPageContext()).bhg();
    }

    public NoNetworkView cEY() {
        return this.fDZ;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSM = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.joa.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.joa.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Bd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jnT.getPageContext().getPageActivity(), this.jnW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, jof), NoDataViewFactory.d.dE(null, this.jnT.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dSM);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, this.jnT.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.jnT.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class View$OnTouchListenerC0714a implements View.OnTouchListener {
        private View$OnTouchListenerC0714a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.jod.qC(false);
                    break;
                case 1:
                    a.this.jod.qC(true);
                    break;
                case 2:
                    a.this.jod.qC(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.jod.qB(z);
        this.joa.setShowState(recommendForumInfo, z);
    }
}
