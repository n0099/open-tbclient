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
/* loaded from: classes26.dex */
public class a extends c<ForumDetailActivity> {
    public static final int ksj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener eAI;
    private NoNetworkView grd;
    private ForumDetailActivity krX;
    private LinearLayout ksa;
    private CustomScrollView ksb;
    private ItemHeaderView ksc;
    private ItemInfoView ksd;
    private ItemMsgManage kse;
    private ItemEmotionView ksf;
    private ItemHotThreadView ksg;
    private ItemFootNavView ksh;
    private com.baidu.tbadk.core.dialog.a ksi;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.krX = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.ksa = (LinearLayout) this.krX.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.krX.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ksa.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.krX.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.krX.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.grd = (NoNetworkView) this.krX.findViewById(R.id.no_network_view);
        this.ksb = (CustomScrollView) this.krX.findViewById(R.id.scoll_view);
        this.ksb.setOnTouchListener(new View$OnTouchListenerC0777a());
        this.ksc = (ItemHeaderView) this.krX.findViewById(R.id.item_header);
        this.ksd = (ItemInfoView) this.krX.findViewById(R.id.item_info);
        this.kse = (ItemMsgManage) this.krX.findViewById(R.id.item_msg_manage);
        this.ksf = (ItemEmotionView) this.krX.findViewById(R.id.item_emotion_manage);
        this.ksg = (ItemHotThreadView) this.krX.findViewById(R.id.item_hot_thread);
        this.ksh = (ItemFootNavView) this.krX.findViewById(R.id.item_foot_nav);
        this.ksh.setClickable(true);
        this.mRootView = this.krX.findViewById(R.id.root_rl);
        this.kse.setMsgOnClickListener(this.krX);
        this.ksf.setEmotionOnClickListener(this.krX);
        this.kse.setSwitchChangeListener(this.krX);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.ksc.setData(recommendForumInfo);
        this.ksd.setData(recommendForumInfo);
        this.kse.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.ksh.setData(recommendForumInfo, this.krX);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.ksf.setEmotionData(forumEmotionData);
    }

    public void bO(List<SimpleThreadInfo> list) {
        this.ksg.setData(list);
    }

    public void hideLoading() {
        this.krX.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.krX.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.krX.getLayoutMode().setNightMode(i == 1);
        this.krX.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.grd.onChangeSkinType(getPageContext(), i);
        this.ksc.a(this.krX, i);
        this.ksd.a(this.krX, i);
        this.kse.a(this.krX, i);
        this.ksg.a(this.krX, i);
        this.ksh.a(this.krX, i);
    }

    public void onResume() {
        this.ksh.e(this.krX);
    }

    public void cWM() {
        if (this.ksi == null) {
            this.ksi = new com.baidu.tbadk.core.dialog.a(this.krX.getPageContext().getPageActivity());
            this.ksi.oQ(R.string.officical_bar_info_clean_alert);
            this.ksi.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ksi.dismiss();
                    a.this.krX.clearHistory();
                }
            });
            this.ksi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ksi.dismiss();
                }
            });
        }
        this.ksi.b(getPageContext()).brv();
    }

    public NoNetworkView cWN() {
        return this.grd;
    }

    public void g(View.OnClickListener onClickListener) {
        this.eAI = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.kse.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kse.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Ed(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.krX.getPageContext().getPageActivity(), this.ksa, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, ksj), NoDataViewFactory.d.dZ(null, this.krX.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.eAI);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, this.krX.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.krX.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class View$OnTouchListenerC0777a implements View.OnTouchListener {
        private View$OnTouchListenerC0777a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.ksh.sw(false);
                    break;
                case 1:
                    a.this.ksh.sw(true);
                    break;
                case 2:
                    a.this.ksh.sw(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ksh.sv(z);
        this.kse.setShowState(recommendForumInfo, z);
    }
}
