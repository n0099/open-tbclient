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
/* loaded from: classes25.dex */
public class a extends c<ForumDetailActivity> {
    public static final int jwI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dUW;
    private NoNetworkView fHl;
    private CustomScrollView jwA;
    private ItemHeaderView jwB;
    private ItemInfoView jwC;
    private ItemMsgManage jwD;
    private ItemEmotionView jwE;
    private ItemHotThreadView jwF;
    private ItemFootNavView jwG;
    private com.baidu.tbadk.core.dialog.a jwH;
    private ForumDetailActivity jww;
    private LinearLayout jwz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.jww = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.jwz = (LinearLayout) this.jww.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.jww.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jwz.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.jww.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jww.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fHl = (NoNetworkView) this.jww.findViewById(R.id.no_network_view);
        this.jwA = (CustomScrollView) this.jww.findViewById(R.id.scoll_view);
        this.jwA.setOnTouchListener(new View$OnTouchListenerC0711a());
        this.jwB = (ItemHeaderView) this.jww.findViewById(R.id.item_header);
        this.jwC = (ItemInfoView) this.jww.findViewById(R.id.item_info);
        this.jwD = (ItemMsgManage) this.jww.findViewById(R.id.item_msg_manage);
        this.jwE = (ItemEmotionView) this.jww.findViewById(R.id.item_emotion_manage);
        this.jwF = (ItemHotThreadView) this.jww.findViewById(R.id.item_hot_thread);
        this.jwG = (ItemFootNavView) this.jww.findViewById(R.id.item_foot_nav);
        this.jwG.setClickable(true);
        this.mRootView = this.jww.findViewById(R.id.root_rl);
        this.jwD.setMsgOnClickListener(this.jww);
        this.jwE.setEmotionOnClickListener(this.jww);
        this.jwD.setSwitchChangeListener(this.jww);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.jwB.setData(recommendForumInfo);
        this.jwC.setData(recommendForumInfo);
        this.jwD.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.jwG.setData(recommendForumInfo, this.jww);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.jwE.setEmotionData(forumEmotionData);
    }

    public void br(List<SimpleThreadInfo> list) {
        this.jwF.setData(list);
    }

    public void hideLoading() {
        this.jww.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.jww.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.jww.getLayoutMode().setNightMode(i == 1);
        this.jww.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fHl.onChangeSkinType(getPageContext(), i);
        this.jwB.a(this.jww, i);
        this.jwC.a(this.jww, i);
        this.jwD.a(this.jww, i);
        this.jwF.a(this.jww, i);
        this.jwG.a(this.jww, i);
    }

    public void onResume() {
        this.jwG.e(this.jww);
    }

    public void cID() {
        if (this.jwH == null) {
            this.jwH = new com.baidu.tbadk.core.dialog.a(this.jww.getPageContext().getPageActivity());
            this.jwH.nE(R.string.officical_bar_info_clean_alert);
            this.jwH.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.jwH.dismiss();
                    a.this.jww.clearHistory();
                }
            });
            this.jwH.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.jwH.dismiss();
                }
            });
        }
        this.jwH.b(getPageContext()).bia();
    }

    public NoNetworkView cIE() {
        return this.fHl;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dUW = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.jwD.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.jwD.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void BE(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jww.getPageContext().getPageActivity(), this.jwz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, jwI), NoDataViewFactory.d.dG(null, this.jww.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dUW);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, this.jww.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.jww.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class View$OnTouchListenerC0711a implements View.OnTouchListener {
        private View$OnTouchListenerC0711a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.jwG.qK(false);
                    break;
                case 1:
                    a.this.jwG.qK(true);
                    break;
                case 2:
                    a.this.jwG.qK(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.jwG.qJ(z);
        this.jwD.setShowState(recommendForumInfo, z);
    }
}
