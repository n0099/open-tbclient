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
/* loaded from: classes7.dex */
public class a extends d<ForumDetailActivity> {
    public static final int kIR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener eJh;
    private NoNetworkView gCe;
    private ForumDetailActivity kIF;
    private LinearLayout kII;
    private CustomScrollView kIJ;
    private ItemHeaderView kIK;
    private ItemInfoView kIL;
    private ItemMsgManage kIM;
    private ItemEmotionView kIN;
    private ItemHotThreadView kIO;
    private ItemFootNavView kIP;
    private com.baidu.tbadk.core.dialog.a kIQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.kIF = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.kII = (LinearLayout) this.kIF.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.kIF.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kII.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.kIF.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kIF.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gCe = (NoNetworkView) this.kIF.findViewById(R.id.no_network_view);
        this.kIJ = (CustomScrollView) this.kIF.findViewById(R.id.scoll_view);
        this.kIJ.setOnTouchListener(new View$OnTouchListenerC0764a());
        this.kIK = (ItemHeaderView) this.kIF.findViewById(R.id.item_header);
        this.kIL = (ItemInfoView) this.kIF.findViewById(R.id.item_info);
        this.kIM = (ItemMsgManage) this.kIF.findViewById(R.id.item_msg_manage);
        this.kIN = (ItemEmotionView) this.kIF.findViewById(R.id.item_emotion_manage);
        this.kIO = (ItemHotThreadView) this.kIF.findViewById(R.id.item_hot_thread);
        this.kIP = (ItemFootNavView) this.kIF.findViewById(R.id.item_foot_nav);
        this.kIP.setClickable(true);
        this.mRootView = this.kIF.findViewById(R.id.root_rl);
        this.kIM.setMsgOnClickListener(this.kIF);
        this.kIN.setEmotionOnClickListener(this.kIF);
        this.kIM.setSwitchChangeListener(this.kIF);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.kIK.setData(recommendForumInfo);
        this.kIL.setData(recommendForumInfo);
        this.kIM.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.kIP.setData(recommendForumInfo, this.kIF);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.kIN.setEmotionData(forumEmotionData);
    }

    public void bQ(List<SimpleThreadInfo> list) {
        this.kIO.setData(list);
    }

    public void hideLoading() {
        this.kIF.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.kIF.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.kIF.getLayoutMode().setNightMode(i == 1);
        this.kIF.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gCe.onChangeSkinType(getPageContext(), i);
        this.kIK.a(this.kIF, i);
        this.kIL.a(this.kIF, i);
        this.kIM.a(this.kIF, i);
        this.kIO.a(this.kIF, i);
        this.kIP.a(this.kIF, i);
    }

    public void onResume() {
        this.kIP.e(this.kIF);
    }

    public void cWE() {
        if (this.kIQ == null) {
            this.kIQ = new com.baidu.tbadk.core.dialog.a(this.kIF.getPageContext().getPageActivity());
            this.kIQ.ny(R.string.officical_bar_info_clean_alert);
            this.kIQ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kIQ.dismiss();
                    a.this.kIF.clearHistory();
                }
            });
            this.kIQ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kIQ.dismiss();
                }
            });
        }
        this.kIQ.b(getPageContext()).bqz();
    }

    public NoNetworkView cWF() {
        return this.gCe;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eJh = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.kIM.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kIM.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Db(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kIF.getPageContext().getPageActivity(), this.kII, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, kIR), NoDataViewFactory.d.dS(null, this.kIF.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.eJh);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.kIF.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.kIF.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnTouchListenerC0764a implements View.OnTouchListener {
        private View$OnTouchListenerC0764a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.kIP.sU(false);
                    break;
                case 1:
                    a.this.kIP.sU(true);
                    break;
                case 2:
                    a.this.kIP.sU(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kIP.sT(z);
        this.kIM.setShowState(recommendForumInfo, z);
    }
}
