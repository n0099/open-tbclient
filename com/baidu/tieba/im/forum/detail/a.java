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
import com.baidu.tieba.f;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener abf;
    private NoNetworkView bvB;
    private ForumDetailActivity eqM;
    private LinearLayout eqP;
    private CustomScrollView eqQ;
    private ItemHeaderView eqR;
    private ItemInfoView eqS;
    private ItemMsgManage eqT;
    private ItemEmotionView eqU;
    private ItemHotThreadView eqV;
    private ItemFootNavView eqW;
    private com.baidu.tbadk.core.dialog.a eqX;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eqM = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eqP = (LinearLayout) this.eqM.findViewById(f.g.scoll_view_ll);
        TextView textView = new TextView(this.eqM.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eqP.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eqM.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eqM.getPageContext().getString(f.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bvB = (NoNetworkView) this.eqM.findViewById(f.g.no_network_view);
        this.eqQ = (CustomScrollView) this.eqM.findViewById(f.g.scoll_view);
        this.eqQ.setOnTouchListener(new View$OnTouchListenerC0173a());
        this.eqR = (ItemHeaderView) this.eqM.findViewById(f.g.item_header);
        this.eqS = (ItemInfoView) this.eqM.findViewById(f.g.item_info);
        this.eqT = (ItemMsgManage) this.eqM.findViewById(f.g.item_msg_manage);
        this.eqU = (ItemEmotionView) this.eqM.findViewById(f.g.item_emotion_manage);
        this.eqV = (ItemHotThreadView) this.eqM.findViewById(f.g.item_hot_thread);
        this.eqW = (ItemFootNavView) this.eqM.findViewById(f.g.item_foot_nav);
        this.eqW.setClickable(true);
        this.mRootView = this.eqM.findViewById(f.g.root_rl);
        aKd();
        this.eqT.setMsgOnClickListener(this.eqM);
        this.eqU.setEmotionOnClickListener(this.eqM);
        this.eqT.setSwitchChangeListener(this.eqM);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eqR.setData(recommendForumInfo);
        this.eqS.setData(recommendForumInfo);
        this.eqT.setData(recommendForumInfo, z, managerApplyInfo);
        this.eqW.setData(recommendForumInfo, this.eqM);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eqU.setEmotionData(forumEmotionData);
    }

    public void R(List<SimpleThreadInfo> list) {
        this.eqV.setData(list);
    }

    public void azg() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aKd() {
        this.mProgressBar = new ProgressBar(this.eqM.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eqM.getPageContext().getResources().getDrawable(f.C0146f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eqM.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eqM.getLayoutMode().setNightMode(i == 1);
        this.eqM.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvB.onChangeSkinType(getPageContext(), i);
        this.eqR.a(this.eqM, i);
        this.eqS.a(this.eqM, i);
        this.eqT.a(this.eqM, i);
        this.eqV.a(this.eqM, i);
        this.eqW.a(this.eqM, i);
    }

    public void onResume() {
        this.eqW.e(this.eqM);
    }

    public void aKe() {
        if (this.eqX == null) {
            this.eqX = new com.baidu.tbadk.core.dialog.a(this.eqM.getPageContext().getPageActivity());
            this.eqX.cf(f.j.officical_bar_info_clean_alert);
            this.eqX.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eqX.dismiss();
                    a.this.eqM.clearHistory();
                }
            });
            this.eqX.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eqX.dismiss();
                }
            });
        }
        this.eqX.b(getPageContext()).xe();
    }

    public NoNetworkView aKf() {
        return this.bvB;
    }

    public void b(View.OnClickListener onClickListener) {
        this.abf = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eqT.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eqT.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void is(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eqM.getPageContext().getPageActivity(), this.eqP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.dt(i), null);
            this.mNoDataView.setOnClickListener(this.abf);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(i));
        this.mNoDataView.onChangeSkinType(this.eqM.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0173a implements View.OnTouchListener {
        private View$OnTouchListenerC0173a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.eqW.hv(false);
                    break;
                case 1:
                    a.this.eqW.hv(true);
                    break;
                case 2:
                    a.this.eqW.hv(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eqW.hu(z);
        this.eqT.setShowState(recommendForumInfo, z);
    }
}
