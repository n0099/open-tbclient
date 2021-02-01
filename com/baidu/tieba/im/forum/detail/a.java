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
    public static final int kGB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener eHG;
    private NoNetworkView gAh;
    private com.baidu.tbadk.core.dialog.a kGA;
    private ForumDetailActivity kGp;
    private LinearLayout kGs;
    private CustomScrollView kGt;
    private ItemHeaderView kGu;
    private ItemInfoView kGv;
    private ItemMsgManage kGw;
    private ItemEmotionView kGx;
    private ItemHotThreadView kGy;
    private ItemFootNavView kGz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.kGp = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.kGs = (LinearLayout) this.kGp.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.kGp.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kGs.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.kGp.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kGp.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gAh = (NoNetworkView) this.kGp.findViewById(R.id.no_network_view);
        this.kGt = (CustomScrollView) this.kGp.findViewById(R.id.scoll_view);
        this.kGt.setOnTouchListener(new View$OnTouchListenerC0757a());
        this.kGu = (ItemHeaderView) this.kGp.findViewById(R.id.item_header);
        this.kGv = (ItemInfoView) this.kGp.findViewById(R.id.item_info);
        this.kGw = (ItemMsgManage) this.kGp.findViewById(R.id.item_msg_manage);
        this.kGx = (ItemEmotionView) this.kGp.findViewById(R.id.item_emotion_manage);
        this.kGy = (ItemHotThreadView) this.kGp.findViewById(R.id.item_hot_thread);
        this.kGz = (ItemFootNavView) this.kGp.findViewById(R.id.item_foot_nav);
        this.kGz.setClickable(true);
        this.mRootView = this.kGp.findViewById(R.id.root_rl);
        this.kGw.setMsgOnClickListener(this.kGp);
        this.kGx.setEmotionOnClickListener(this.kGp);
        this.kGw.setSwitchChangeListener(this.kGp);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.kGu.setData(recommendForumInfo);
        this.kGv.setData(recommendForumInfo);
        this.kGw.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.kGz.setData(recommendForumInfo, this.kGp);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.kGx.setEmotionData(forumEmotionData);
    }

    public void bQ(List<SimpleThreadInfo> list) {
        this.kGy.setData(list);
    }

    public void hideLoading() {
        this.kGp.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.kGp.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.kGp.getLayoutMode().setNightMode(i == 1);
        this.kGp.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gAh.onChangeSkinType(getPageContext(), i);
        this.kGu.a(this.kGp, i);
        this.kGv.a(this.kGp, i);
        this.kGw.a(this.kGp, i);
        this.kGy.a(this.kGp, i);
        this.kGz.a(this.kGp, i);
    }

    public void onResume() {
        this.kGz.e(this.kGp);
    }

    public void cWq() {
        if (this.kGA == null) {
            this.kGA = new com.baidu.tbadk.core.dialog.a(this.kGp.getPageContext().getPageActivity());
            this.kGA.nx(R.string.officical_bar_info_clean_alert);
            this.kGA.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kGA.dismiss();
                    a.this.kGp.clearHistory();
                }
            });
            this.kGA.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kGA.dismiss();
                }
            });
        }
        this.kGA.b(getPageContext()).bqx();
    }

    public NoNetworkView cWr() {
        return this.gAh;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eHG = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.kGw.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kGw.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void CY(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kGp.getPageContext().getPageActivity(), this.kGs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, kGB), NoDataViewFactory.d.dS(null, this.kGp.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.eHG);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.kGp.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.kGp.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC0757a implements View.OnTouchListener {
        private View$OnTouchListenerC0757a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.kGz.sU(false);
                    break;
                case 1:
                    a.this.kGz.sU(true);
                    break;
                case 2:
                    a.this.kGz.sU(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kGz.sT(z);
        this.kGw.setShowState(recommendForumInfo, z);
    }
}
