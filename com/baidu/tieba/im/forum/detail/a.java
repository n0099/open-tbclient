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
    public static final int iYZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dJA;
    private NoNetworkView fsB;
    private ForumDetailActivity iYN;
    private LinearLayout iYQ;
    private CustomScrollView iYR;
    private ItemHeaderView iYS;
    private ItemInfoView iYT;
    private ItemMsgManage iYU;
    private ItemEmotionView iYV;
    private ItemHotThreadView iYW;
    private ItemFootNavView iYX;
    private com.baidu.tbadk.core.dialog.a iYY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.iYN = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.iYQ = (LinearLayout) this.iYN.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.iYN.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.iYQ.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.iYN.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iYN.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fsB = (NoNetworkView) this.iYN.findViewById(R.id.no_network_view);
        this.iYR = (CustomScrollView) this.iYN.findViewById(R.id.scoll_view);
        this.iYR.setOnTouchListener(new View$OnTouchListenerC0662a());
        this.iYS = (ItemHeaderView) this.iYN.findViewById(R.id.item_header);
        this.iYT = (ItemInfoView) this.iYN.findViewById(R.id.item_info);
        this.iYU = (ItemMsgManage) this.iYN.findViewById(R.id.item_msg_manage);
        this.iYV = (ItemEmotionView) this.iYN.findViewById(R.id.item_emotion_manage);
        this.iYW = (ItemHotThreadView) this.iYN.findViewById(R.id.item_hot_thread);
        this.iYX = (ItemFootNavView) this.iYN.findViewById(R.id.item_foot_nav);
        this.iYX.setClickable(true);
        this.mRootView = this.iYN.findViewById(R.id.root_rl);
        this.iYU.setMsgOnClickListener(this.iYN);
        this.iYV.setEmotionOnClickListener(this.iYN);
        this.iYU.setSwitchChangeListener(this.iYN);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.iYS.setData(recommendForumInfo);
        this.iYT.setData(recommendForumInfo);
        this.iYU.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.iYX.setData(recommendForumInfo, this.iYN);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.iYV.setEmotionData(forumEmotionData);
    }

    public void bm(List<SimpleThreadInfo> list) {
        this.iYW.setData(list);
    }

    public void hideLoading() {
        this.iYN.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.iYN.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.iYN.getLayoutMode().setNightMode(i == 1);
        this.iYN.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fsB.onChangeSkinType(getPageContext(), i);
        this.iYS.a(this.iYN, i);
        this.iYT.a(this.iYN, i);
        this.iYU.a(this.iYN, i);
        this.iYW.a(this.iYN, i);
        this.iYX.a(this.iYN, i);
    }

    public void onResume() {
        this.iYX.e(this.iYN);
    }

    public void cuf() {
        if (this.iYY == null) {
            this.iYY = new com.baidu.tbadk.core.dialog.a(this.iYN.getPageContext().getPageActivity());
            this.iYY.ln(R.string.officical_bar_info_clean_alert);
            this.iYY.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.iYY.dismiss();
                    a.this.iYN.clearHistory();
                }
            });
            this.iYY.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.iYY.dismiss();
                }
            });
        }
        this.iYY.b(getPageContext()).aYL();
    }

    public NoNetworkView cug() {
        return this.fsB;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dJA = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.iYU.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.iYU.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void yK(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iYN.getPageContext().getPageActivity(), this.iYQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, iYZ), NoDataViewFactory.d.m31do(null, this.iYN.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dJA);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, this.iYN.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.iYN.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class View$OnTouchListenerC0662a implements View.OnTouchListener {
        private View$OnTouchListenerC0662a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.iYX.pU(false);
                    break;
                case 1:
                    a.this.iYX.pU(true);
                    break;
                case 2:
                    a.this.iYX.pU(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.iYX.pT(z);
        this.iYU.setShowState(recommendForumInfo, z);
    }
}
