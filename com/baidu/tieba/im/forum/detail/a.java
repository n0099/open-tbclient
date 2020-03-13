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
    public static final int hyT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener cLa;
    private NoNetworkView elv;
    private ForumDetailActivity hyH;
    private LinearLayout hyK;
    private CustomScrollView hyL;
    private ItemHeaderView hyM;
    private ItemInfoView hyN;
    private ItemMsgManage hyO;
    private ItemEmotionView hyP;
    private ItemHotThreadView hyQ;
    private ItemFootNavView hyR;
    private com.baidu.tbadk.core.dialog.a hyS;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.hyH = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.hyK = (LinearLayout) this.hyH.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.hyH.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.hyK.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.hyH.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hyH.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.elv = (NoNetworkView) this.hyH.findViewById(R.id.no_network_view);
        this.hyL = (CustomScrollView) this.hyH.findViewById(R.id.scoll_view);
        this.hyL.setOnTouchListener(new View$OnTouchListenerC0529a());
        this.hyM = (ItemHeaderView) this.hyH.findViewById(R.id.item_header);
        this.hyN = (ItemInfoView) this.hyH.findViewById(R.id.item_info);
        this.hyO = (ItemMsgManage) this.hyH.findViewById(R.id.item_msg_manage);
        this.hyP = (ItemEmotionView) this.hyH.findViewById(R.id.item_emotion_manage);
        this.hyQ = (ItemHotThreadView) this.hyH.findViewById(R.id.item_hot_thread);
        this.hyR = (ItemFootNavView) this.hyH.findViewById(R.id.item_foot_nav);
        this.hyR.setClickable(true);
        this.mRootView = this.hyH.findViewById(R.id.root_rl);
        this.hyO.setMsgOnClickListener(this.hyH);
        this.hyP.setEmotionOnClickListener(this.hyH);
        this.hyO.setSwitchChangeListener(this.hyH);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.hyM.setData(recommendForumInfo);
        this.hyN.setData(recommendForumInfo);
        this.hyO.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.hyR.setData(recommendForumInfo, this.hyH);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.hyP.setEmotionData(forumEmotionData);
    }

    public void aT(List<SimpleThreadInfo> list) {
        this.hyQ.setData(list);
    }

    public void hideLoading() {
        this.hyH.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.hyH.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.hyH.getLayoutMode().setNightMode(i == 1);
        this.hyH.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.elv.onChangeSkinType(getPageContext(), i);
        this.hyM.a(this.hyH, i);
        this.hyN.a(this.hyH, i);
        this.hyO.a(this.hyH, i);
        this.hyQ.a(this.hyH, i);
        this.hyR.a(this.hyH, i);
    }

    public void onResume() {
        this.hyR.e(this.hyH);
    }

    public void bUT() {
        if (this.hyS == null) {
            this.hyS = new com.baidu.tbadk.core.dialog.a(this.hyH.getPageContext().getPageActivity());
            this.hyS.jW(R.string.officical_bar_info_clean_alert);
            this.hyS.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hyS.dismiss();
                    a.this.hyH.clearHistory();
                }
            });
            this.hyS.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hyS.dismiss();
                }
            });
        }
        this.hyS.b(getPageContext()).aEC();
    }

    public NoNetworkView bUU() {
        return this.elv;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLa = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.hyO.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hyO.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hyH.getPageContext().getPageActivity(), this.hyK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, hyT), NoDataViewFactory.d.cA(null, this.hyH.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.cLa);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, this.hyH.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.hyH.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class View$OnTouchListenerC0529a implements View.OnTouchListener {
        private View$OnTouchListenerC0529a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.hyR.nx(false);
                    break;
                case 1:
                    a.this.hyR.nx(true);
                    break;
                case 2:
                    a.this.hyR.nx(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hyR.nw(z);
        this.hyO.setShowState(recommendForumInfo, z);
    }
}
