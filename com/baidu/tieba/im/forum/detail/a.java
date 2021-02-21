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
    public static final int kGP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener eHG;
    private NoNetworkView gAv;
    private ForumDetailActivity kGD;
    private LinearLayout kGG;
    private CustomScrollView kGH;
    private ItemHeaderView kGI;
    private ItemInfoView kGJ;
    private ItemMsgManage kGK;
    private ItemEmotionView kGL;
    private ItemHotThreadView kGM;
    private ItemFootNavView kGN;
    private com.baidu.tbadk.core.dialog.a kGO;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.kGD = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.kGG = (LinearLayout) this.kGD.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.kGD.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kGG.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.kGD.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kGD.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gAv = (NoNetworkView) this.kGD.findViewById(R.id.no_network_view);
        this.kGH = (CustomScrollView) this.kGD.findViewById(R.id.scoll_view);
        this.kGH.setOnTouchListener(new View$OnTouchListenerC0758a());
        this.kGI = (ItemHeaderView) this.kGD.findViewById(R.id.item_header);
        this.kGJ = (ItemInfoView) this.kGD.findViewById(R.id.item_info);
        this.kGK = (ItemMsgManage) this.kGD.findViewById(R.id.item_msg_manage);
        this.kGL = (ItemEmotionView) this.kGD.findViewById(R.id.item_emotion_manage);
        this.kGM = (ItemHotThreadView) this.kGD.findViewById(R.id.item_hot_thread);
        this.kGN = (ItemFootNavView) this.kGD.findViewById(R.id.item_foot_nav);
        this.kGN.setClickable(true);
        this.mRootView = this.kGD.findViewById(R.id.root_rl);
        this.kGK.setMsgOnClickListener(this.kGD);
        this.kGL.setEmotionOnClickListener(this.kGD);
        this.kGK.setSwitchChangeListener(this.kGD);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.kGI.setData(recommendForumInfo);
        this.kGJ.setData(recommendForumInfo);
        this.kGK.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.kGN.setData(recommendForumInfo, this.kGD);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.kGL.setEmotionData(forumEmotionData);
    }

    public void bQ(List<SimpleThreadInfo> list) {
        this.kGM.setData(list);
    }

    public void hideLoading() {
        this.kGD.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.kGD.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.kGD.getLayoutMode().setNightMode(i == 1);
        this.kGD.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gAv.onChangeSkinType(getPageContext(), i);
        this.kGI.a(this.kGD, i);
        this.kGJ.a(this.kGD, i);
        this.kGK.a(this.kGD, i);
        this.kGM.a(this.kGD, i);
        this.kGN.a(this.kGD, i);
    }

    public void onResume() {
        this.kGN.e(this.kGD);
    }

    public void cWx() {
        if (this.kGO == null) {
            this.kGO = new com.baidu.tbadk.core.dialog.a(this.kGD.getPageContext().getPageActivity());
            this.kGO.nx(R.string.officical_bar_info_clean_alert);
            this.kGO.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kGO.dismiss();
                    a.this.kGD.clearHistory();
                }
            });
            this.kGO.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kGO.dismiss();
                }
            });
        }
        this.kGO.b(getPageContext()).bqx();
    }

    public NoNetworkView cWy() {
        return this.gAv;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eHG = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.kGK.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kGK.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void CY(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kGD.getPageContext().getPageActivity(), this.kGG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, kGP), NoDataViewFactory.d.dS(null, this.kGD.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.eHG);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.kGD.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.kGD.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC0758a implements View.OnTouchListener {
        private View$OnTouchListenerC0758a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.kGN.sU(false);
                    break;
                case 1:
                    a.this.kGN.sU(true);
                    break;
                case 2:
                    a.this.kGN.sU(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kGN.sT(z);
        this.kGK.setShowState(recommendForumInfo, z);
    }
}
