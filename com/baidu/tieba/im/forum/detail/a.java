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
    public static final int ksl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener eAI;
    private NoNetworkView grf;
    private ForumDetailActivity krZ;
    private LinearLayout ksc;
    private CustomScrollView ksd;
    private ItemHeaderView kse;
    private ItemInfoView ksf;
    private ItemMsgManage ksg;
    private ItemEmotionView ksh;
    private ItemHotThreadView ksi;
    private ItemFootNavView ksj;
    private com.baidu.tbadk.core.dialog.a ksk;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.krZ = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.ksc = (LinearLayout) this.krZ.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.krZ.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ksc.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.krZ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.krZ.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.grf = (NoNetworkView) this.krZ.findViewById(R.id.no_network_view);
        this.ksd = (CustomScrollView) this.krZ.findViewById(R.id.scoll_view);
        this.ksd.setOnTouchListener(new View$OnTouchListenerC0777a());
        this.kse = (ItemHeaderView) this.krZ.findViewById(R.id.item_header);
        this.ksf = (ItemInfoView) this.krZ.findViewById(R.id.item_info);
        this.ksg = (ItemMsgManage) this.krZ.findViewById(R.id.item_msg_manage);
        this.ksh = (ItemEmotionView) this.krZ.findViewById(R.id.item_emotion_manage);
        this.ksi = (ItemHotThreadView) this.krZ.findViewById(R.id.item_hot_thread);
        this.ksj = (ItemFootNavView) this.krZ.findViewById(R.id.item_foot_nav);
        this.ksj.setClickable(true);
        this.mRootView = this.krZ.findViewById(R.id.root_rl);
        this.ksg.setMsgOnClickListener(this.krZ);
        this.ksh.setEmotionOnClickListener(this.krZ);
        this.ksg.setSwitchChangeListener(this.krZ);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.kse.setData(recommendForumInfo);
        this.ksf.setData(recommendForumInfo);
        this.ksg.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.ksj.setData(recommendForumInfo, this.krZ);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.ksh.setEmotionData(forumEmotionData);
    }

    public void bO(List<SimpleThreadInfo> list) {
        this.ksi.setData(list);
    }

    public void hideLoading() {
        this.krZ.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.krZ.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.krZ.getLayoutMode().setNightMode(i == 1);
        this.krZ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.grf.onChangeSkinType(getPageContext(), i);
        this.kse.a(this.krZ, i);
        this.ksf.a(this.krZ, i);
        this.ksg.a(this.krZ, i);
        this.ksi.a(this.krZ, i);
        this.ksj.a(this.krZ, i);
    }

    public void onResume() {
        this.ksj.e(this.krZ);
    }

    public void cWN() {
        if (this.ksk == null) {
            this.ksk = new com.baidu.tbadk.core.dialog.a(this.krZ.getPageContext().getPageActivity());
            this.ksk.oQ(R.string.officical_bar_info_clean_alert);
            this.ksk.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ksk.dismiss();
                    a.this.krZ.clearHistory();
                }
            });
            this.ksk.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ksk.dismiss();
                }
            });
        }
        this.ksk.b(getPageContext()).brv();
    }

    public NoNetworkView cWO() {
        return this.grf;
    }

    public void g(View.OnClickListener onClickListener) {
        this.eAI = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.ksg.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ksg.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Ed(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.krZ.getPageContext().getPageActivity(), this.ksc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, ksl), NoDataViewFactory.d.dZ(null, this.krZ.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.eAI);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, this.krZ.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.krZ.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.ksj.sw(false);
                    break;
                case 1:
                    a.this.ksj.sw(true);
                    break;
                case 2:
                    a.this.ksj.sw(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ksj.sv(z);
        this.ksg.setShowState(recommendForumInfo, z);
    }
}
