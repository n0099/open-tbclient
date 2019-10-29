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
    private View.OnClickListener bVg;
    private NoNetworkView dwI;
    private ForumDetailActivity gFF;
    private LinearLayout gFI;
    private CustomScrollView gFJ;
    private ItemHeaderView gFK;
    private ItemInfoView gFL;
    private ItemMsgManage gFM;
    private ItemEmotionView gFN;
    private ItemHotThreadView gFO;
    private ItemFootNavView gFP;
    private com.baidu.tbadk.core.dialog.a gFQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.gFF = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.gFI = (LinearLayout) this.gFF.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.gFF.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gFI.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.gFF.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gFF.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dwI = (NoNetworkView) this.gFF.findViewById(R.id.no_network_view);
        this.gFJ = (CustomScrollView) this.gFF.findViewById(R.id.scoll_view);
        this.gFJ.setOnTouchListener(new View$OnTouchListenerC0436a());
        this.gFK = (ItemHeaderView) this.gFF.findViewById(R.id.item_header);
        this.gFL = (ItemInfoView) this.gFF.findViewById(R.id.item_info);
        this.gFM = (ItemMsgManage) this.gFF.findViewById(R.id.item_msg_manage);
        this.gFN = (ItemEmotionView) this.gFF.findViewById(R.id.item_emotion_manage);
        this.gFO = (ItemHotThreadView) this.gFF.findViewById(R.id.item_hot_thread);
        this.gFP = (ItemFootNavView) this.gFF.findViewById(R.id.item_foot_nav);
        this.gFP.setClickable(true);
        this.mRootView = this.gFF.findViewById(R.id.root_rl);
        bAV();
        this.gFM.setMsgOnClickListener(this.gFF);
        this.gFN.setEmotionOnClickListener(this.gFF);
        this.gFM.setSwitchChangeListener(this.gFF);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.gFK.setData(recommendForumInfo);
        this.gFL.setData(recommendForumInfo);
        this.gFM.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.gFP.setData(recommendForumInfo, this.gFF);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.gFN.setEmotionData(forumEmotionData);
    }

    public void aN(List<SimpleThreadInfo> list) {
        this.gFO.setData(list);
    }

    public void boQ() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bAV() {
        this.mProgressBar = new ProgressBar(this.gFF.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.gFF.getPageContext().getResources().getDrawable(R.drawable.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.gFF.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.gFF.getLayoutMode().setNightMode(i == 1);
        this.gFF.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dwI.onChangeSkinType(getPageContext(), i);
        this.gFK.a(this.gFF, i);
        this.gFL.a(this.gFF, i);
        this.gFM.a(this.gFF, i);
        this.gFO.a(this.gFF, i);
        this.gFP.a(this.gFF, i);
    }

    public void onResume() {
        this.gFP.e(this.gFF);
    }

    public void bAW() {
        if (this.gFQ == null) {
            this.gFQ = new com.baidu.tbadk.core.dialog.a(this.gFF.getPageContext().getPageActivity());
            this.gFQ.hU(R.string.officical_bar_info_clean_alert);
            this.gFQ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gFQ.dismiss();
                    a.this.gFF.bAN();
                }
            });
            this.gFQ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gFQ.dismiss();
                }
            });
        }
        this.gFQ.b(getPageContext()).akO();
    }

    public NoNetworkView bAX() {
        return this.dwI;
    }

    public void e(View.OnClickListener onClickListener) {
        this.bVg = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.gFM.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gFM.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void uc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gFF.getPageContext().getPageActivity(), this.gFI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.iL(i), null);
            this.mNoDataView.setOnClickListener(this.bVg);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iL(i));
        this.mNoDataView.onChangeSkinType(this.gFF.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0436a implements View.OnTouchListener {
        private View$OnTouchListenerC0436a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.gFP.lV(false);
                    break;
                case 1:
                    a.this.gFP.lV(true);
                    break;
                case 2:
                    a.this.gFP.lV(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gFP.lU(z);
        this.gFM.setShowState(recommendForumInfo, z);
    }
}
