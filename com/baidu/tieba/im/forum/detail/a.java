package com.baidu.tieba.im.forum.detail;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.tbadk.TbadkApplication;
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
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener bBr;
    private NoNetworkView dlX;
    private ForumDetailActivity gyN;
    private LinearLayout gyQ;
    private CustomScrollView gyR;
    private ItemHeaderView gyS;
    private ItemInfoView gyT;
    private ItemMsgManage gyU;
    private ItemEmotionView gyV;
    private ItemHotThreadView gyW;
    private ItemFootNavView gyX;
    private com.baidu.tbadk.core.dialog.a gyY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.gyN = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.gyQ = (LinearLayout) this.gyN.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.gyN.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gyQ.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.gyN.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gyN.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dlX = (NoNetworkView) this.gyN.findViewById(R.id.no_network_view);
        this.gyR = (CustomScrollView) this.gyN.findViewById(R.id.scoll_view);
        this.gyR.setOnTouchListener(new View$OnTouchListenerC0331a());
        this.gyS = (ItemHeaderView) this.gyN.findViewById(R.id.item_header);
        this.gyT = (ItemInfoView) this.gyN.findViewById(R.id.item_info);
        this.gyU = (ItemMsgManage) this.gyN.findViewById(R.id.item_msg_manage);
        this.gyV = (ItemEmotionView) this.gyN.findViewById(R.id.item_emotion_manage);
        this.gyW = (ItemHotThreadView) this.gyN.findViewById(R.id.item_hot_thread);
        this.gyX = (ItemFootNavView) this.gyN.findViewById(R.id.item_foot_nav);
        this.gyX.setClickable(true);
        this.mRootView = this.gyN.findViewById(R.id.root_rl);
        bAB();
        this.gyU.setMsgOnClickListener(this.gyN);
        this.gyV.setEmotionOnClickListener(this.gyN);
        this.gyU.setSwitchChangeListener(this.gyN);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.gyS.setData(recommendForumInfo);
        this.gyT.setData(recommendForumInfo);
        this.gyU.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.gyX.setData(recommendForumInfo, this.gyN);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.gyV.setEmotionData(forumEmotionData);
    }

    public void av(List<SimpleThreadInfo> list) {
        this.gyW.setData(list);
    }

    public void boN() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bAB() {
        this.mProgressBar = new ProgressBar(this.gyN.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.gyN.getPageContext().getResources().getDrawable(R.drawable.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.gyN.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.gyN.getLayoutMode().setNightMode(i == 1);
        this.gyN.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlX.onChangeSkinType(getPageContext(), i);
        this.gyS.a(this.gyN, i);
        this.gyT.a(this.gyN, i);
        this.gyU.a(this.gyN, i);
        this.gyW.a(this.gyN, i);
        this.gyX.a(this.gyN, i);
    }

    public void onResume() {
        this.gyX.e(this.gyN);
    }

    public void bAC() {
        if (this.gyY == null) {
            this.gyY = new com.baidu.tbadk.core.dialog.a(this.gyN.getPageContext().getPageActivity());
            this.gyY.ho(R.string.officical_bar_info_clean_alert);
            this.gyY.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gyY.dismiss();
                    a.this.gyN.clearHistory();
                }
            });
            this.gyY.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gyY.dismiss();
                }
            });
        }
        this.gyY.b(getPageContext()).afG();
    }

    public NoNetworkView bAD() {
        return this.dlX;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bBr = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.gyU.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gyU.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gyN.getPageContext().getPageActivity(), this.gyQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.iH(i), null);
            this.mNoDataView.setOnClickListener(this.bBr);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(i));
        this.mNoDataView.onChangeSkinType(this.gyN.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0331a implements View.OnTouchListener {
        private View$OnTouchListenerC0331a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.gyX.lQ(false);
                    break;
                case 1:
                    a.this.gyX.lQ(true);
                    break;
                case 2:
                    a.this.gyX.lQ(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gyX.lP(z);
        this.gyU.setShowState(recommendForumInfo, z);
    }
}
