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
    public static final int jnZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dSI;
    private NoNetworkView fDV;
    private ForumDetailActivity jnN;
    private LinearLayout jnQ;
    private CustomScrollView jnR;
    private ItemHeaderView jnS;
    private ItemInfoView jnT;
    private ItemMsgManage jnU;
    private ItemEmotionView jnV;
    private ItemHotThreadView jnW;
    private ItemFootNavView jnX;
    private com.baidu.tbadk.core.dialog.a jnY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.jnN = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.jnQ = (LinearLayout) this.jnN.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.jnN.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jnQ.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.jnN.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jnN.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fDV = (NoNetworkView) this.jnN.findViewById(R.id.no_network_view);
        this.jnR = (CustomScrollView) this.jnN.findViewById(R.id.scoll_view);
        this.jnR.setOnTouchListener(new View$OnTouchListenerC0714a());
        this.jnS = (ItemHeaderView) this.jnN.findViewById(R.id.item_header);
        this.jnT = (ItemInfoView) this.jnN.findViewById(R.id.item_info);
        this.jnU = (ItemMsgManage) this.jnN.findViewById(R.id.item_msg_manage);
        this.jnV = (ItemEmotionView) this.jnN.findViewById(R.id.item_emotion_manage);
        this.jnW = (ItemHotThreadView) this.jnN.findViewById(R.id.item_hot_thread);
        this.jnX = (ItemFootNavView) this.jnN.findViewById(R.id.item_foot_nav);
        this.jnX.setClickable(true);
        this.mRootView = this.jnN.findViewById(R.id.root_rl);
        this.jnU.setMsgOnClickListener(this.jnN);
        this.jnV.setEmotionOnClickListener(this.jnN);
        this.jnU.setSwitchChangeListener(this.jnN);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.jnS.setData(recommendForumInfo);
        this.jnT.setData(recommendForumInfo);
        this.jnU.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.jnX.setData(recommendForumInfo, this.jnN);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.jnV.setEmotionData(forumEmotionData);
    }

    public void bm(List<SimpleThreadInfo> list) {
        this.jnW.setData(list);
    }

    public void hideLoading() {
        this.jnN.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.jnN.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.jnN.getLayoutMode().setNightMode(i == 1);
        this.jnN.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fDV.onChangeSkinType(getPageContext(), i);
        this.jnS.a(this.jnN, i);
        this.jnT.a(this.jnN, i);
        this.jnU.a(this.jnN, i);
        this.jnW.a(this.jnN, i);
        this.jnX.a(this.jnN, i);
    }

    public void onResume() {
        this.jnX.e(this.jnN);
    }

    public void cEW() {
        if (this.jnY == null) {
            this.jnY = new com.baidu.tbadk.core.dialog.a(this.jnN.getPageContext().getPageActivity());
            this.jnY.nt(R.string.officical_bar_info_clean_alert);
            this.jnY.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.jnY.dismiss();
                    a.this.jnN.clearHistory();
                }
            });
            this.jnY.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.jnY.dismiss();
                }
            });
        }
        this.jnY.b(getPageContext()).bhg();
    }

    public NoNetworkView cEX() {
        return this.fDV;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSI = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.jnU.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.jnU.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Bd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jnN.getPageContext().getPageActivity(), this.jnQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, jnZ), NoDataViewFactory.d.dE(null, this.jnN.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dSI);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, this.jnN.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.jnN.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.jnX.qA(false);
                    break;
                case 1:
                    a.this.jnX.qA(true);
                    break;
                case 2:
                    a.this.jnX.qA(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.jnX.qz(z);
        this.jnU.setShowState(recommendForumInfo, z);
    }
}
