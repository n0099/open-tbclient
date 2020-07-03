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
/* loaded from: classes13.dex */
public class a extends c<ForumDetailActivity> {
    public static final int iQN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dDD;
    private NoNetworkView fns;
    private ForumDetailActivity iQB;
    private LinearLayout iQE;
    private CustomScrollView iQF;
    private ItemHeaderView iQG;
    private ItemInfoView iQH;
    private ItemMsgManage iQI;
    private ItemEmotionView iQJ;
    private ItemHotThreadView iQK;
    private ItemFootNavView iQL;
    private com.baidu.tbadk.core.dialog.a iQM;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.iQB = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.iQE = (LinearLayout) this.iQB.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.iQB.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.iQE.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.iQB.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iQB.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fns = (NoNetworkView) this.iQB.findViewById(R.id.no_network_view);
        this.iQF = (CustomScrollView) this.iQB.findViewById(R.id.scoll_view);
        this.iQF.setOnTouchListener(new View$OnTouchListenerC0651a());
        this.iQG = (ItemHeaderView) this.iQB.findViewById(R.id.item_header);
        this.iQH = (ItemInfoView) this.iQB.findViewById(R.id.item_info);
        this.iQI = (ItemMsgManage) this.iQB.findViewById(R.id.item_msg_manage);
        this.iQJ = (ItemEmotionView) this.iQB.findViewById(R.id.item_emotion_manage);
        this.iQK = (ItemHotThreadView) this.iQB.findViewById(R.id.item_hot_thread);
        this.iQL = (ItemFootNavView) this.iQB.findViewById(R.id.item_foot_nav);
        this.iQL.setClickable(true);
        this.mRootView = this.iQB.findViewById(R.id.root_rl);
        this.iQI.setMsgOnClickListener(this.iQB);
        this.iQJ.setEmotionOnClickListener(this.iQB);
        this.iQI.setSwitchChangeListener(this.iQB);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.iQG.setData(recommendForumInfo);
        this.iQH.setData(recommendForumInfo);
        this.iQI.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.iQL.setData(recommendForumInfo, this.iQB);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.iQJ.setEmotionData(forumEmotionData);
    }

    public void bi(List<SimpleThreadInfo> list) {
        this.iQK.setData(list);
    }

    public void hideLoading() {
        this.iQB.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.iQB.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.iQB.getLayoutMode().setNightMode(i == 1);
        this.iQB.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fns.onChangeSkinType(getPageContext(), i);
        this.iQG.a(this.iQB, i);
        this.iQH.a(this.iQB, i);
        this.iQI.a(this.iQB, i);
        this.iQK.a(this.iQB, i);
        this.iQL.a(this.iQB, i);
    }

    public void onResume() {
        this.iQL.e(this.iQB);
    }

    public void cqg() {
        if (this.iQM == null) {
            this.iQM = new com.baidu.tbadk.core.dialog.a(this.iQB.getPageContext().getPageActivity());
            this.iQM.kT(R.string.officical_bar_info_clean_alert);
            this.iQM.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.iQM.dismiss();
                    a.this.iQB.clearHistory();
                }
            });
            this.iQM.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.iQM.dismiss();
                }
            });
        }
        this.iQM.b(getPageContext()).aUN();
    }

    public NoNetworkView cqh() {
        return this.fns;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dDD = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.iQI.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.iQI.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ym(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iQB.getPageContext().getPageActivity(), this.iQE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, iQN), NoDataViewFactory.d.dm(null, this.iQB.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dDD);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, this.iQB.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.iQB.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class View$OnTouchListenerC0651a implements View.OnTouchListener {
        private View$OnTouchListenerC0651a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.iQL.pn(false);
                    break;
                case 1:
                    a.this.iQL.pn(true);
                    break;
                case 2:
                    a.this.iQL.pn(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.iQL.pm(z);
        this.iQI.setShowState(recommendForumInfo, z);
    }
}
