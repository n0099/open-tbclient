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
    public static final int hAt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener cLl;
    private NoNetworkView elL;
    private ForumDetailActivity hAh;
    private LinearLayout hAk;
    private CustomScrollView hAl;
    private ItemHeaderView hAm;
    private ItemInfoView hAn;
    private ItemMsgManage hAo;
    private ItemEmotionView hAp;
    private ItemHotThreadView hAq;
    private ItemFootNavView hAr;
    private com.baidu.tbadk.core.dialog.a hAs;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.hAh = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.hAk = (LinearLayout) this.hAh.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.hAh.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.hAk.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.hAh.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hAh.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.elL = (NoNetworkView) this.hAh.findViewById(R.id.no_network_view);
        this.hAl = (CustomScrollView) this.hAh.findViewById(R.id.scoll_view);
        this.hAl.setOnTouchListener(new View$OnTouchListenerC0530a());
        this.hAm = (ItemHeaderView) this.hAh.findViewById(R.id.item_header);
        this.hAn = (ItemInfoView) this.hAh.findViewById(R.id.item_info);
        this.hAo = (ItemMsgManage) this.hAh.findViewById(R.id.item_msg_manage);
        this.hAp = (ItemEmotionView) this.hAh.findViewById(R.id.item_emotion_manage);
        this.hAq = (ItemHotThreadView) this.hAh.findViewById(R.id.item_hot_thread);
        this.hAr = (ItemFootNavView) this.hAh.findViewById(R.id.item_foot_nav);
        this.hAr.setClickable(true);
        this.mRootView = this.hAh.findViewById(R.id.root_rl);
        this.hAo.setMsgOnClickListener(this.hAh);
        this.hAp.setEmotionOnClickListener(this.hAh);
        this.hAo.setSwitchChangeListener(this.hAh);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.hAm.setData(recommendForumInfo);
        this.hAn.setData(recommendForumInfo);
        this.hAo.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.hAr.setData(recommendForumInfo, this.hAh);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.hAp.setEmotionData(forumEmotionData);
    }

    public void aT(List<SimpleThreadInfo> list) {
        this.hAq.setData(list);
    }

    public void hideLoading() {
        this.hAh.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.hAh.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.hAh.getLayoutMode().setNightMode(i == 1);
        this.hAh.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.elL.onChangeSkinType(getPageContext(), i);
        this.hAm.a(this.hAh, i);
        this.hAn.a(this.hAh, i);
        this.hAo.a(this.hAh, i);
        this.hAq.a(this.hAh, i);
        this.hAr.a(this.hAh, i);
    }

    public void onResume() {
        this.hAr.e(this.hAh);
    }

    public void bVl() {
        if (this.hAs == null) {
            this.hAs = new com.baidu.tbadk.core.dialog.a(this.hAh.getPageContext().getPageActivity());
            this.hAs.jW(R.string.officical_bar_info_clean_alert);
            this.hAs.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hAs.dismiss();
                    a.this.hAh.clearHistory();
                }
            });
            this.hAs.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hAs.dismiss();
                }
            });
        }
        this.hAs.b(getPageContext()).aEG();
    }

    public NoNetworkView bVm() {
        return this.elL;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLl = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.hAo.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hAo.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ww(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hAh.getPageContext().getPageActivity(), this.hAk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, hAt), NoDataViewFactory.d.cz(null, this.hAh.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.cLl);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cz(null, this.hAh.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.hAh.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class View$OnTouchListenerC0530a implements View.OnTouchListener {
        private View$OnTouchListenerC0530a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.hAr.nD(false);
                    break;
                case 1:
                    a.this.hAr.nD(true);
                    break;
                case 2:
                    a.this.hAr.nD(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hAr.nC(z);
        this.hAo.setShowState(recommendForumInfo, z);
    }
}
