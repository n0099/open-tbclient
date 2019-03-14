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
import com.baidu.tieba.d;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener bui;
    private NoNetworkView dbm;
    private ForumDetailActivity ghK;
    private LinearLayout ghN;
    private CustomScrollView ghO;
    private ItemHeaderView ghP;
    private ItemInfoView ghQ;
    private ItemMsgManage ghR;
    private ItemEmotionView ghS;
    private ItemHotThreadView ghT;
    private ItemFootNavView ghU;
    private com.baidu.tbadk.core.dialog.a ghV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.ghK = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.ghN = (LinearLayout) this.ghK.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.ghK.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ghN.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.ghK.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ghK.getPageContext().getString(d.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dbm = (NoNetworkView) this.ghK.findViewById(d.g.no_network_view);
        this.ghO = (CustomScrollView) this.ghK.findViewById(d.g.scoll_view);
        this.ghO.setOnTouchListener(new View$OnTouchListenerC0314a());
        this.ghP = (ItemHeaderView) this.ghK.findViewById(d.g.item_header);
        this.ghQ = (ItemInfoView) this.ghK.findViewById(d.g.item_info);
        this.ghR = (ItemMsgManage) this.ghK.findViewById(d.g.item_msg_manage);
        this.ghS = (ItemEmotionView) this.ghK.findViewById(d.g.item_emotion_manage);
        this.ghT = (ItemHotThreadView) this.ghK.findViewById(d.g.item_hot_thread);
        this.ghU = (ItemFootNavView) this.ghK.findViewById(d.g.item_foot_nav);
        this.ghU.setClickable(true);
        this.mRootView = this.ghK.findViewById(d.g.root_rl);
        bsO();
        this.ghR.setMsgOnClickListener(this.ghK);
        this.ghS.setEmotionOnClickListener(this.ghK);
        this.ghR.setSwitchChangeListener(this.ghK);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo) {
        this.ghP.setData(recommendForumInfo);
        this.ghQ.setData(recommendForumInfo);
        this.ghR.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo);
        this.ghU.setData(recommendForumInfo, this.ghK);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.ghS.setEmotionData(forumEmotionData);
    }

    public void ao(List<SimpleThreadInfo> list) {
        this.ghT.setData(list);
    }

    public void bhr() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bsO() {
        this.mProgressBar = new ProgressBar(this.ghK.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.ghK.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.ghK.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.ghK.getLayoutMode().setNightMode(i == 1);
        this.ghK.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbm.onChangeSkinType(getPageContext(), i);
        this.ghP.a(this.ghK, i);
        this.ghQ.a(this.ghK, i);
        this.ghR.a(this.ghK, i);
        this.ghT.a(this.ghK, i);
        this.ghU.a(this.ghK, i);
    }

    public void onResume() {
        this.ghU.e(this.ghK);
    }

    public void bsP() {
        if (this.ghV == null) {
            this.ghV = new com.baidu.tbadk.core.dialog.a(this.ghK.getPageContext().getPageActivity());
            this.ghV.gD(d.j.officical_bar_info_clean_alert);
            this.ghV.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ghV.dismiss();
                    a.this.ghK.clearHistory();
                }
            });
            this.ghV.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ghV.dismiss();
                }
            });
        }
        this.ghV.b(getPageContext()).aaZ();
    }

    public NoNetworkView bsQ() {
        return this.dbm;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bui = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.ghR.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ghR.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void nS(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ghK.getPageContext().getPageActivity(), this.ghN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.hU(i), null);
            this.mNoDataView.setOnClickListener(this.bui);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(i));
        this.mNoDataView.onChangeSkinType(this.ghK.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0314a implements View.OnTouchListener {
        private View$OnTouchListenerC0314a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.ghU.la(false);
                    break;
                case 1:
                    a.this.ghU.la(true);
                    break;
                case 2:
                    a.this.ghU.la(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ghU.kZ(z);
        this.ghR.setShowState(recommendForumInfo, z);
    }
}
