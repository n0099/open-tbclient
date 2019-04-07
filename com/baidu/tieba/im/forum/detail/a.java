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
    private View.OnClickListener bul;
    private NoNetworkView dbq;
    private LinearLayout ghA;
    private CustomScrollView ghB;
    private ItemHeaderView ghC;
    private ItemInfoView ghD;
    private ItemMsgManage ghE;
    private ItemEmotionView ghF;
    private ItemHotThreadView ghG;
    private ItemFootNavView ghH;
    private com.baidu.tbadk.core.dialog.a ghI;
    private ForumDetailActivity ghx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.ghx = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.ghA = (LinearLayout) this.ghx.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.ghx.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ghA.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.ghx.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ghx.getPageContext().getString(d.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dbq = (NoNetworkView) this.ghx.findViewById(d.g.no_network_view);
        this.ghB = (CustomScrollView) this.ghx.findViewById(d.g.scoll_view);
        this.ghB.setOnTouchListener(new View$OnTouchListenerC0314a());
        this.ghC = (ItemHeaderView) this.ghx.findViewById(d.g.item_header);
        this.ghD = (ItemInfoView) this.ghx.findViewById(d.g.item_info);
        this.ghE = (ItemMsgManage) this.ghx.findViewById(d.g.item_msg_manage);
        this.ghF = (ItemEmotionView) this.ghx.findViewById(d.g.item_emotion_manage);
        this.ghG = (ItemHotThreadView) this.ghx.findViewById(d.g.item_hot_thread);
        this.ghH = (ItemFootNavView) this.ghx.findViewById(d.g.item_foot_nav);
        this.ghH.setClickable(true);
        this.mRootView = this.ghx.findViewById(d.g.root_rl);
        bsL();
        this.ghE.setMsgOnClickListener(this.ghx);
        this.ghF.setEmotionOnClickListener(this.ghx);
        this.ghE.setSwitchChangeListener(this.ghx);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo) {
        this.ghC.setData(recommendForumInfo);
        this.ghD.setData(recommendForumInfo);
        this.ghE.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo);
        this.ghH.setData(recommendForumInfo, this.ghx);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.ghF.setEmotionData(forumEmotionData);
    }

    public void ao(List<SimpleThreadInfo> list) {
        this.ghG.setData(list);
    }

    public void bhp() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bsL() {
        this.mProgressBar = new ProgressBar(this.ghx.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.ghx.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.ghx.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.ghx.getLayoutMode().setNightMode(i == 1);
        this.ghx.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbq.onChangeSkinType(getPageContext(), i);
        this.ghC.a(this.ghx, i);
        this.ghD.a(this.ghx, i);
        this.ghE.a(this.ghx, i);
        this.ghG.a(this.ghx, i);
        this.ghH.a(this.ghx, i);
    }

    public void onResume() {
        this.ghH.e(this.ghx);
    }

    public void bsM() {
        if (this.ghI == null) {
            this.ghI = new com.baidu.tbadk.core.dialog.a(this.ghx.getPageContext().getPageActivity());
            this.ghI.gC(d.j.officical_bar_info_clean_alert);
            this.ghI.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ghI.dismiss();
                    a.this.ghx.clearHistory();
                }
            });
            this.ghI.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ghI.dismiss();
                }
            });
        }
        this.ghI.b(getPageContext()).aaW();
    }

    public NoNetworkView bsN() {
        return this.dbq;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bul = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.ghE.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ghE.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void nQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ghx.getPageContext().getPageActivity(), this.ghA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.hT(i), null);
            this.mNoDataView.setOnClickListener(this.bul);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(i));
        this.mNoDataView.onChangeSkinType(this.ghx.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.ghH.la(false);
                    break;
                case 1:
                    a.this.ghH.la(true);
                    break;
                case 2:
                    a.this.ghH.la(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ghH.kZ(z);
        this.ghE.setShowState(recommendForumInfo, z);
    }
}
