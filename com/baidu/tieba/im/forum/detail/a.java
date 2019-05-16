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
    private View.OnClickListener bBp;
    private NoNetworkView dlW;
    private ForumDetailActivity gyK;
    private LinearLayout gyN;
    private CustomScrollView gyO;
    private ItemHeaderView gyP;
    private ItemInfoView gyQ;
    private ItemMsgManage gyR;
    private ItemEmotionView gyS;
    private ItemHotThreadView gyT;
    private ItemFootNavView gyU;
    private com.baidu.tbadk.core.dialog.a gyV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.gyK = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.gyN = (LinearLayout) this.gyK.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.gyK.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gyN.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.gyK.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gyK.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dlW = (NoNetworkView) this.gyK.findViewById(R.id.no_network_view);
        this.gyO = (CustomScrollView) this.gyK.findViewById(R.id.scoll_view);
        this.gyO.setOnTouchListener(new View$OnTouchListenerC0331a());
        this.gyP = (ItemHeaderView) this.gyK.findViewById(R.id.item_header);
        this.gyQ = (ItemInfoView) this.gyK.findViewById(R.id.item_info);
        this.gyR = (ItemMsgManage) this.gyK.findViewById(R.id.item_msg_manage);
        this.gyS = (ItemEmotionView) this.gyK.findViewById(R.id.item_emotion_manage);
        this.gyT = (ItemHotThreadView) this.gyK.findViewById(R.id.item_hot_thread);
        this.gyU = (ItemFootNavView) this.gyK.findViewById(R.id.item_foot_nav);
        this.gyU.setClickable(true);
        this.mRootView = this.gyK.findViewById(R.id.root_rl);
        bAx();
        this.gyR.setMsgOnClickListener(this.gyK);
        this.gyS.setEmotionOnClickListener(this.gyK);
        this.gyR.setSwitchChangeListener(this.gyK);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.gyP.setData(recommendForumInfo);
        this.gyQ.setData(recommendForumInfo);
        this.gyR.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.gyU.setData(recommendForumInfo, this.gyK);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.gyS.setEmotionData(forumEmotionData);
    }

    public void av(List<SimpleThreadInfo> list) {
        this.gyT.setData(list);
    }

    public void boI() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bAx() {
        this.mProgressBar = new ProgressBar(this.gyK.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.gyK.getPageContext().getResources().getDrawable(R.drawable.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.gyK.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.gyK.getLayoutMode().setNightMode(i == 1);
        this.gyK.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlW.onChangeSkinType(getPageContext(), i);
        this.gyP.a(this.gyK, i);
        this.gyQ.a(this.gyK, i);
        this.gyR.a(this.gyK, i);
        this.gyT.a(this.gyK, i);
        this.gyU.a(this.gyK, i);
    }

    public void onResume() {
        this.gyU.e(this.gyK);
    }

    public void bAy() {
        if (this.gyV == null) {
            this.gyV = new com.baidu.tbadk.core.dialog.a(this.gyK.getPageContext().getPageActivity());
            this.gyV.ho(R.string.officical_bar_info_clean_alert);
            this.gyV.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gyV.dismiss();
                    a.this.gyK.clearHistory();
                }
            });
            this.gyV.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gyV.dismiss();
                }
            });
        }
        this.gyV.b(getPageContext()).afG();
    }

    public NoNetworkView bAz() {
        return this.dlW;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bBp = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.gyR.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gyR.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gyK.getPageContext().getPageActivity(), this.gyN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.iH(i), null);
            this.mNoDataView.setOnClickListener(this.bBp);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(i));
        this.mNoDataView.onChangeSkinType(this.gyK.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.gyU.lP(false);
                    break;
                case 1:
                    a.this.gyU.lP(true);
                    break;
                case 2:
                    a.this.gyU.lP(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gyU.lO(z);
        this.gyR.setShowState(recommendForumInfo, z);
    }
}
