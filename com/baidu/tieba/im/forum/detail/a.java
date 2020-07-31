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
    public static final int iYX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dJA;
    private NoNetworkView fsB;
    private ForumDetailActivity iYL;
    private LinearLayout iYO;
    private CustomScrollView iYP;
    private ItemHeaderView iYQ;
    private ItemInfoView iYR;
    private ItemMsgManage iYS;
    private ItemEmotionView iYT;
    private ItemHotThreadView iYU;
    private ItemFootNavView iYV;
    private com.baidu.tbadk.core.dialog.a iYW;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.iYL = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.iYO = (LinearLayout) this.iYL.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.iYL.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.iYO.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.iYL.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iYL.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fsB = (NoNetworkView) this.iYL.findViewById(R.id.no_network_view);
        this.iYP = (CustomScrollView) this.iYL.findViewById(R.id.scoll_view);
        this.iYP.setOnTouchListener(new View$OnTouchListenerC0662a());
        this.iYQ = (ItemHeaderView) this.iYL.findViewById(R.id.item_header);
        this.iYR = (ItemInfoView) this.iYL.findViewById(R.id.item_info);
        this.iYS = (ItemMsgManage) this.iYL.findViewById(R.id.item_msg_manage);
        this.iYT = (ItemEmotionView) this.iYL.findViewById(R.id.item_emotion_manage);
        this.iYU = (ItemHotThreadView) this.iYL.findViewById(R.id.item_hot_thread);
        this.iYV = (ItemFootNavView) this.iYL.findViewById(R.id.item_foot_nav);
        this.iYV.setClickable(true);
        this.mRootView = this.iYL.findViewById(R.id.root_rl);
        this.iYS.setMsgOnClickListener(this.iYL);
        this.iYT.setEmotionOnClickListener(this.iYL);
        this.iYS.setSwitchChangeListener(this.iYL);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.iYQ.setData(recommendForumInfo);
        this.iYR.setData(recommendForumInfo);
        this.iYS.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.iYV.setData(recommendForumInfo, this.iYL);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.iYT.setEmotionData(forumEmotionData);
    }

    public void bm(List<SimpleThreadInfo> list) {
        this.iYU.setData(list);
    }

    public void hideLoading() {
        this.iYL.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.iYL.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.iYL.getLayoutMode().setNightMode(i == 1);
        this.iYL.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fsB.onChangeSkinType(getPageContext(), i);
        this.iYQ.a(this.iYL, i);
        this.iYR.a(this.iYL, i);
        this.iYS.a(this.iYL, i);
        this.iYU.a(this.iYL, i);
        this.iYV.a(this.iYL, i);
    }

    public void onResume() {
        this.iYV.e(this.iYL);
    }

    public void cuf() {
        if (this.iYW == null) {
            this.iYW = new com.baidu.tbadk.core.dialog.a(this.iYL.getPageContext().getPageActivity());
            this.iYW.ln(R.string.officical_bar_info_clean_alert);
            this.iYW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.iYW.dismiss();
                    a.this.iYL.clearHistory();
                }
            });
            this.iYW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.iYW.dismiss();
                }
            });
        }
        this.iYW.b(getPageContext()).aYL();
    }

    public NoNetworkView cug() {
        return this.fsB;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dJA = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.iYS.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.iYS.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void yK(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iYL.getPageContext().getPageActivity(), this.iYO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, iYX), NoDataViewFactory.d.m31do(null, this.iYL.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dJA);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, this.iYL.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.iYL.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.iYV.pU(false);
                    break;
                case 1:
                    a.this.iYV.pU(true);
                    break;
                case 2:
                    a.this.iYV.pU(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.iYV.pT(z);
        this.iYS.setShowState(recommendForumInfo, z);
    }
}
