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
    public static final int jLF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener egY;
    private NoNetworkView fTu;
    private ItemMsgManage jLA;
    private ItemEmotionView jLB;
    private ItemHotThreadView jLC;
    private ItemFootNavView jLD;
    private com.baidu.tbadk.core.dialog.a jLE;
    private ForumDetailActivity jLt;
    private LinearLayout jLw;
    private CustomScrollView jLx;
    private ItemHeaderView jLy;
    private ItemInfoView jLz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.jLt = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.jLw = (LinearLayout) this.jLt.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.jLt.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.jLw.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.jLt.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jLt.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fTu = (NoNetworkView) this.jLt.findViewById(R.id.no_network_view);
        this.jLx = (CustomScrollView) this.jLt.findViewById(R.id.scoll_view);
        this.jLx.setOnTouchListener(new View$OnTouchListenerC0729a());
        this.jLy = (ItemHeaderView) this.jLt.findViewById(R.id.item_header);
        this.jLz = (ItemInfoView) this.jLt.findViewById(R.id.item_info);
        this.jLA = (ItemMsgManage) this.jLt.findViewById(R.id.item_msg_manage);
        this.jLB = (ItemEmotionView) this.jLt.findViewById(R.id.item_emotion_manage);
        this.jLC = (ItemHotThreadView) this.jLt.findViewById(R.id.item_hot_thread);
        this.jLD = (ItemFootNavView) this.jLt.findViewById(R.id.item_foot_nav);
        this.jLD.setClickable(true);
        this.mRootView = this.jLt.findViewById(R.id.root_rl);
        this.jLA.setMsgOnClickListener(this.jLt);
        this.jLB.setEmotionOnClickListener(this.jLt);
        this.jLA.setSwitchChangeListener(this.jLt);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.jLy.setData(recommendForumInfo);
        this.jLz.setData(recommendForumInfo);
        this.jLA.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.jLD.setData(recommendForumInfo, this.jLt);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.jLB.setEmotionData(forumEmotionData);
    }

    public void bu(List<SimpleThreadInfo> list) {
        this.jLC.setData(list);
    }

    public void hideLoading() {
        this.jLt.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.jLt.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.jLt.getLayoutMode().setNightMode(i == 1);
        this.jLt.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fTu.onChangeSkinType(getPageContext(), i);
        this.jLy.a(this.jLt, i);
        this.jLz.a(this.jLt, i);
        this.jLA.a(this.jLt, i);
        this.jLC.a(this.jLt, i);
        this.jLD.a(this.jLt, i);
    }

    public void onResume() {
        this.jLD.e(this.jLt);
    }

    public void cMm() {
        if (this.jLE == null) {
            this.jLE = new com.baidu.tbadk.core.dialog.a(this.jLt.getPageContext().getPageActivity());
            this.jLE.ob(R.string.officical_bar_info_clean_alert);
            this.jLE.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.jLE.dismiss();
                    a.this.jLt.clearHistory();
                }
            });
            this.jLE.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.jLE.dismiss();
                }
            });
        }
        this.jLE.b(getPageContext()).bkJ();
    }

    public NoNetworkView cMn() {
        return this.fTu;
    }

    public void f(View.OnClickListener onClickListener) {
        this.egY = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.jLA.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.jLA.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Ck(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jLt.getPageContext().getPageActivity(), this.jLw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, jLF), NoDataViewFactory.d.dL(null, this.jLt.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.egY);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, this.jLt.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.jLt.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class View$OnTouchListenerC0729a implements View.OnTouchListener {
        private View$OnTouchListenerC0729a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.jLD.rq(false);
                    break;
                case 1:
                    a.this.jLD.rq(true);
                    break;
                case 2:
                    a.this.jLD.rq(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.jLD.rp(z);
        this.jLA.setShowState(recommendForumInfo, z);
    }
}
