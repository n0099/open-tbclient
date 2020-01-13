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
/* loaded from: classes11.dex */
public class a extends c<ForumDetailActivity> {
    public static final int hwG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener cGV;
    private NoNetworkView ehd;
    private ItemInfoView hwA;
    private ItemMsgManage hwB;
    private ItemEmotionView hwC;
    private ItemHotThreadView hwD;
    private ItemFootNavView hwE;
    private com.baidu.tbadk.core.dialog.a hwF;
    private ForumDetailActivity hwu;
    private LinearLayout hwx;
    private CustomScrollView hwy;
    private ItemHeaderView hwz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.hwu = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.hwx = (LinearLayout) this.hwu.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.hwu.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.hwx.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.hwu.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hwu.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.ehd = (NoNetworkView) this.hwu.findViewById(R.id.no_network_view);
        this.hwy = (CustomScrollView) this.hwu.findViewById(R.id.scoll_view);
        this.hwy.setOnTouchListener(new View$OnTouchListenerC0522a());
        this.hwz = (ItemHeaderView) this.hwu.findViewById(R.id.item_header);
        this.hwA = (ItemInfoView) this.hwu.findViewById(R.id.item_info);
        this.hwB = (ItemMsgManage) this.hwu.findViewById(R.id.item_msg_manage);
        this.hwC = (ItemEmotionView) this.hwu.findViewById(R.id.item_emotion_manage);
        this.hwD = (ItemHotThreadView) this.hwu.findViewById(R.id.item_hot_thread);
        this.hwE = (ItemFootNavView) this.hwu.findViewById(R.id.item_foot_nav);
        this.hwE.setClickable(true);
        this.mRootView = this.hwu.findViewById(R.id.root_rl);
        this.hwB.setMsgOnClickListener(this.hwu);
        this.hwC.setEmotionOnClickListener(this.hwu);
        this.hwB.setSwitchChangeListener(this.hwu);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.hwz.setData(recommendForumInfo);
        this.hwA.setData(recommendForumInfo);
        this.hwB.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.hwE.setData(recommendForumInfo, this.hwu);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.hwC.setEmotionData(forumEmotionData);
    }

    public void aT(List<SimpleThreadInfo> list) {
        this.hwD.setData(list);
    }

    public void hideLoading() {
        this.hwu.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.hwu.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.hwu.getLayoutMode().setNightMode(i == 1);
        this.hwu.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ehd.onChangeSkinType(getPageContext(), i);
        this.hwz.a(this.hwu, i);
        this.hwA.a(this.hwu, i);
        this.hwB.a(this.hwu, i);
        this.hwD.a(this.hwu, i);
        this.hwE.a(this.hwu, i);
    }

    public void onResume() {
        this.hwE.e(this.hwu);
    }

    public void bTp() {
        if (this.hwF == null) {
            this.hwF = new com.baidu.tbadk.core.dialog.a(this.hwu.getPageContext().getPageActivity());
            this.hwF.jF(R.string.officical_bar_info_clean_alert);
            this.hwF.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hwF.dismiss();
                    a.this.hwu.clearHistory();
                }
            });
            this.hwF.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hwF.dismiss();
                }
            });
        }
        this.hwF.b(getPageContext()).aCp();
    }

    public NoNetworkView bTq() {
        return this.ehd;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cGV = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.hwB.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hwB.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void wi(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hwu.getPageContext().getPageActivity(), this.hwx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, hwG), NoDataViewFactory.d.cr(null, this.hwu.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.cGV);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, this.hwu.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.hwu.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class View$OnTouchListenerC0522a implements View.OnTouchListener {
        private View$OnTouchListenerC0522a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.hwE.nv(false);
                    break;
                case 1:
                    a.this.hwE.nv(true);
                    break;
                case 2:
                    a.this.hwE.nv(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hwE.nu(z);
        this.hwB.setShowState(recommendForumInfo, z);
    }
}
