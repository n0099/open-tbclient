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
    private View.OnClickListener bCL;
    private NoNetworkView dpy;
    private ForumDetailActivity gHH;
    private LinearLayout gHK;
    private CustomScrollView gHL;
    private ItemHeaderView gHM;
    private ItemInfoView gHN;
    private ItemMsgManage gHO;
    private ItemEmotionView gHP;
    private ItemHotThreadView gHQ;
    private ItemFootNavView gHR;
    private com.baidu.tbadk.core.dialog.a gHS;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.gHH = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.gHK = (LinearLayout) this.gHH.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.gHH.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gHK.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.gHH.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gHH.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dpy = (NoNetworkView) this.gHH.findViewById(R.id.no_network_view);
        this.gHL = (CustomScrollView) this.gHH.findViewById(R.id.scoll_view);
        this.gHL.setOnTouchListener(new View$OnTouchListenerC0347a());
        this.gHM = (ItemHeaderView) this.gHH.findViewById(R.id.item_header);
        this.gHN = (ItemInfoView) this.gHH.findViewById(R.id.item_info);
        this.gHO = (ItemMsgManage) this.gHH.findViewById(R.id.item_msg_manage);
        this.gHP = (ItemEmotionView) this.gHH.findViewById(R.id.item_emotion_manage);
        this.gHQ = (ItemHotThreadView) this.gHH.findViewById(R.id.item_hot_thread);
        this.gHR = (ItemFootNavView) this.gHH.findViewById(R.id.item_foot_nav);
        this.gHR.setClickable(true);
        this.mRootView = this.gHH.findViewById(R.id.root_rl);
        bEk();
        this.gHO.setMsgOnClickListener(this.gHH);
        this.gHP.setEmotionOnClickListener(this.gHH);
        this.gHO.setSwitchChangeListener(this.gHH);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.gHM.setData(recommendForumInfo);
        this.gHN.setData(recommendForumInfo);
        this.gHO.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.gHR.setData(recommendForumInfo, this.gHH);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.gHP.setEmotionData(forumEmotionData);
    }

    public void av(List<SimpleThreadInfo> list) {
        this.gHQ.setData(list);
    }

    public void brM() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bEk() {
        this.mProgressBar = new ProgressBar(this.gHH.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.gHH.getPageContext().getResources().getDrawable(R.drawable.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.gHH.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.gHH.getLayoutMode().setNightMode(i == 1);
        this.gHH.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dpy.onChangeSkinType(getPageContext(), i);
        this.gHM.a(this.gHH, i);
        this.gHN.a(this.gHH, i);
        this.gHO.a(this.gHH, i);
        this.gHQ.a(this.gHH, i);
        this.gHR.a(this.gHH, i);
    }

    public void onResume() {
        this.gHR.e(this.gHH);
    }

    public void bEl() {
        if (this.gHS == null) {
            this.gHS = new com.baidu.tbadk.core.dialog.a(this.gHH.getPageContext().getPageActivity());
            this.gHS.hv(R.string.officical_bar_info_clean_alert);
            this.gHS.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gHS.dismiss();
                    a.this.gHH.bEc();
                }
            });
            this.gHS.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gHS.dismiss();
                }
            });
        }
        this.gHS.b(getPageContext()).agO();
    }

    public NoNetworkView bEm() {
        return this.dpy;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCL = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.gHO.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gHO.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void pb(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gHH.getPageContext().getPageActivity(), this.gHK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.iQ(i), null);
            this.mNoDataView.setOnClickListener(this.bCL);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(i));
        this.mNoDataView.onChangeSkinType(this.gHH.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0347a implements View.OnTouchListener {
        private View$OnTouchListenerC0347a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.gHR.mh(false);
                    break;
                case 1:
                    a.this.gHR.mh(true);
                    break;
                case 2:
                    a.this.gHR.mh(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gHR.mg(z);
        this.gHO.setShowState(recommendForumInfo, z);
    }
}
