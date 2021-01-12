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
/* loaded from: classes7.dex */
public class a extends d<ForumDetailActivity> {
    public static final int kyv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener eFA;
    private NoNetworkView gxx;
    private ForumDetailActivity kyj;
    private LinearLayout kym;
    private CustomScrollView kyn;
    private ItemHeaderView kyo;
    private ItemInfoView kyp;
    private ItemMsgManage kyq;
    private ItemEmotionView kyr;
    private ItemHotThreadView kys;
    private ItemFootNavView kyt;
    private com.baidu.tbadk.core.dialog.a kyu;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.kyj = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.kym = (LinearLayout) this.kyj.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.kyj.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.kym.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.kyj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kyj.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gxx = (NoNetworkView) this.kyj.findViewById(R.id.no_network_view);
        this.kyn = (CustomScrollView) this.kyj.findViewById(R.id.scoll_view);
        this.kyn.setOnTouchListener(new View$OnTouchListenerC0755a());
        this.kyo = (ItemHeaderView) this.kyj.findViewById(R.id.item_header);
        this.kyp = (ItemInfoView) this.kyj.findViewById(R.id.item_info);
        this.kyq = (ItemMsgManage) this.kyj.findViewById(R.id.item_msg_manage);
        this.kyr = (ItemEmotionView) this.kyj.findViewById(R.id.item_emotion_manage);
        this.kys = (ItemHotThreadView) this.kyj.findViewById(R.id.item_hot_thread);
        this.kyt = (ItemFootNavView) this.kyj.findViewById(R.id.item_foot_nav);
        this.kyt.setClickable(true);
        this.mRootView = this.kyj.findViewById(R.id.root_rl);
        this.kyq.setMsgOnClickListener(this.kyj);
        this.kyr.setEmotionOnClickListener(this.kyj);
        this.kyq.setSwitchChangeListener(this.kyj);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.kyo.setData(recommendForumInfo);
        this.kyp.setData(recommendForumInfo);
        this.kyq.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.kyt.setData(recommendForumInfo, this.kyj);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.kyr.setEmotionData(forumEmotionData);
    }

    public void bV(List<SimpleThreadInfo> list) {
        this.kys.setData(list);
    }

    public void hideLoading() {
        this.kyj.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.kyj.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.kyj.getLayoutMode().setNightMode(i == 1);
        this.kyj.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gxx.onChangeSkinType(getPageContext(), i);
        this.kyo.a(this.kyj, i);
        this.kyp.a(this.kyj, i);
        this.kyq.a(this.kyj, i);
        this.kys.a(this.kyj, i);
        this.kyt.a(this.kyj, i);
    }

    public void onResume() {
        this.kyt.e(this.kyj);
    }

    public void cUs() {
        if (this.kyu == null) {
            this.kyu = new com.baidu.tbadk.core.dialog.a(this.kyj.getPageContext().getPageActivity());
            this.kyu.nu(R.string.officical_bar_info_clean_alert);
            this.kyu.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kyu.dismiss();
                    a.this.kyj.clearHistory();
                }
            });
            this.kyu.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.kyu.dismiss();
                }
            });
        }
        this.kyu.b(getPageContext()).bqe();
    }

    public NoNetworkView cUt() {
        return this.gxx;
    }

    public void h(View.OnClickListener onClickListener) {
        this.eFA = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.kyq.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kyq.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void CH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kyj.getPageContext().getPageActivity(), this.kym, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, kyv), NoDataViewFactory.d.dX(null, this.kyj.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.eFA);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, this.kyj.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.kyj.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnTouchListenerC0755a implements View.OnTouchListener {
        private View$OnTouchListenerC0755a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.kyt.sH(false);
                    break;
                case 1:
                    a.this.kyt.sH(true);
                    break;
                case 2:
                    a.this.kyt.sH(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.kyt.sG(z);
        this.kyq.setShowState(recommendForumInfo, z);
    }
}
