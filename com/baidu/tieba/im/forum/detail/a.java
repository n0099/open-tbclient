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
    private NoNetworkView dlX;
    private ForumDetailActivity gyL;
    private LinearLayout gyO;
    private CustomScrollView gyP;
    private ItemHeaderView gyQ;
    private ItemInfoView gyR;
    private ItemMsgManage gyS;
    private ItemEmotionView gyT;
    private ItemHotThreadView gyU;
    private ItemFootNavView gyV;
    private com.baidu.tbadk.core.dialog.a gyW;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.gyL = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.gyO = (LinearLayout) this.gyL.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.gyL.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gyO.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.gyL.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gyL.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dlX = (NoNetworkView) this.gyL.findViewById(R.id.no_network_view);
        this.gyP = (CustomScrollView) this.gyL.findViewById(R.id.scoll_view);
        this.gyP.setOnTouchListener(new View$OnTouchListenerC0331a());
        this.gyQ = (ItemHeaderView) this.gyL.findViewById(R.id.item_header);
        this.gyR = (ItemInfoView) this.gyL.findViewById(R.id.item_info);
        this.gyS = (ItemMsgManage) this.gyL.findViewById(R.id.item_msg_manage);
        this.gyT = (ItemEmotionView) this.gyL.findViewById(R.id.item_emotion_manage);
        this.gyU = (ItemHotThreadView) this.gyL.findViewById(R.id.item_hot_thread);
        this.gyV = (ItemFootNavView) this.gyL.findViewById(R.id.item_foot_nav);
        this.gyV.setClickable(true);
        this.mRootView = this.gyL.findViewById(R.id.root_rl);
        bAA();
        this.gyS.setMsgOnClickListener(this.gyL);
        this.gyT.setEmotionOnClickListener(this.gyL);
        this.gyS.setSwitchChangeListener(this.gyL);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.gyQ.setData(recommendForumInfo);
        this.gyR.setData(recommendForumInfo);
        this.gyS.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.gyV.setData(recommendForumInfo, this.gyL);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.gyT.setEmotionData(forumEmotionData);
    }

    public void av(List<SimpleThreadInfo> list) {
        this.gyU.setData(list);
    }

    public void boL() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bAA() {
        this.mProgressBar = new ProgressBar(this.gyL.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.gyL.getPageContext().getResources().getDrawable(R.drawable.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.gyL.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.gyL.getLayoutMode().setNightMode(i == 1);
        this.gyL.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlX.onChangeSkinType(getPageContext(), i);
        this.gyQ.a(this.gyL, i);
        this.gyR.a(this.gyL, i);
        this.gyS.a(this.gyL, i);
        this.gyU.a(this.gyL, i);
        this.gyV.a(this.gyL, i);
    }

    public void onResume() {
        this.gyV.e(this.gyL);
    }

    public void bAB() {
        if (this.gyW == null) {
            this.gyW = new com.baidu.tbadk.core.dialog.a(this.gyL.getPageContext().getPageActivity());
            this.gyW.ho(R.string.officical_bar_info_clean_alert);
            this.gyW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gyW.dismiss();
                    a.this.gyL.clearHistory();
                }
            });
            this.gyW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gyW.dismiss();
                }
            });
        }
        this.gyW.b(getPageContext()).afG();
    }

    public NoNetworkView bAC() {
        return this.dlX;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bBp = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.gyS.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gyS.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gyL.getPageContext().getPageActivity(), this.gyO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.iH(i), null);
            this.mNoDataView.setOnClickListener(this.bBp);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(i));
        this.mNoDataView.onChangeSkinType(this.gyL.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.gyV.lP(false);
                    break;
                case 1:
                    a.this.gyV.lP(true);
                    break;
                case 2:
                    a.this.gyV.lP(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gyV.lO(z);
        this.gyS.setShowState(recommendForumInfo, z);
    }
}
