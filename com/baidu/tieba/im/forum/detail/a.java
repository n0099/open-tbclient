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
    public static final int iyV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dyx;
    private NoNetworkView fbX;
    private ForumDetailActivity iyJ;
    private LinearLayout iyM;
    private CustomScrollView iyN;
    private ItemHeaderView iyO;
    private ItemInfoView iyP;
    private ItemMsgManage iyQ;
    private ItemEmotionView iyR;
    private ItemHotThreadView iyS;
    private ItemFootNavView iyT;
    private com.baidu.tbadk.core.dialog.a iyU;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.iyJ = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.iyM = (LinearLayout) this.iyJ.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.iyJ.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.iyM.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.iyJ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iyJ.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fbX = (NoNetworkView) this.iyJ.findViewById(R.id.no_network_view);
        this.iyN = (CustomScrollView) this.iyJ.findViewById(R.id.scoll_view);
        this.iyN.setOnTouchListener(new View$OnTouchListenerC0638a());
        this.iyO = (ItemHeaderView) this.iyJ.findViewById(R.id.item_header);
        this.iyP = (ItemInfoView) this.iyJ.findViewById(R.id.item_info);
        this.iyQ = (ItemMsgManage) this.iyJ.findViewById(R.id.item_msg_manage);
        this.iyR = (ItemEmotionView) this.iyJ.findViewById(R.id.item_emotion_manage);
        this.iyS = (ItemHotThreadView) this.iyJ.findViewById(R.id.item_hot_thread);
        this.iyT = (ItemFootNavView) this.iyJ.findViewById(R.id.item_foot_nav);
        this.iyT.setClickable(true);
        this.mRootView = this.iyJ.findViewById(R.id.root_rl);
        this.iyQ.setMsgOnClickListener(this.iyJ);
        this.iyR.setEmotionOnClickListener(this.iyJ);
        this.iyQ.setSwitchChangeListener(this.iyJ);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.iyO.setData(recommendForumInfo);
        this.iyP.setData(recommendForumInfo);
        this.iyQ.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.iyT.setData(recommendForumInfo, this.iyJ);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.iyR.setEmotionData(forumEmotionData);
    }

    public void aY(List<SimpleThreadInfo> list) {
        this.iyS.setData(list);
    }

    public void hideLoading() {
        this.iyJ.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.iyJ.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.iyJ.getLayoutMode().setNightMode(i == 1);
        this.iyJ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fbX.onChangeSkinType(getPageContext(), i);
        this.iyO.a(this.iyJ, i);
        this.iyP.a(this.iyJ, i);
        this.iyQ.a(this.iyJ, i);
        this.iyS.a(this.iyJ, i);
        this.iyT.a(this.iyJ, i);
    }

    public void onResume() {
        this.iyT.e(this.iyJ);
    }

    public void cmi() {
        if (this.iyU == null) {
            this.iyU = new com.baidu.tbadk.core.dialog.a(this.iyJ.getPageContext().getPageActivity());
            this.iyU.kD(R.string.officical_bar_info_clean_alert);
            this.iyU.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.iyU.dismiss();
                    a.this.iyJ.clearHistory();
                }
            });
            this.iyU.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.iyU.dismiss();
                }
            });
        }
        this.iyU.b(getPageContext()).aST();
    }

    public NoNetworkView cmj() {
        return this.fbX;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dyx = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.iyQ.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.iyQ.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void xA(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iyJ.getPageContext().getPageActivity(), this.iyM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, iyV), NoDataViewFactory.d.dj(null, this.iyJ.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dyx);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, this.iyJ.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.iyJ.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class View$OnTouchListenerC0638a implements View.OnTouchListener {
        private View$OnTouchListenerC0638a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.iyT.pd(false);
                    break;
                case 1:
                    a.this.iyT.pd(true);
                    break;
                case 2:
                    a.this.iyT.pd(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.iyT.pc(z);
        this.iyQ.setShowState(recommendForumInfo, z);
    }
}
