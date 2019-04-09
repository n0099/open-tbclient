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
    private View.OnClickListener bum;
    private NoNetworkView dbr;
    private LinearLayout ghB;
    private CustomScrollView ghC;
    private ItemHeaderView ghD;
    private ItemInfoView ghE;
    private ItemMsgManage ghF;
    private ItemEmotionView ghG;
    private ItemHotThreadView ghH;
    private ItemFootNavView ghI;
    private com.baidu.tbadk.core.dialog.a ghJ;
    private ForumDetailActivity ghy;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.ghy = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.ghB = (LinearLayout) this.ghy.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.ghy.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ghB.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.ghy.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ghy.getPageContext().getString(d.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dbr = (NoNetworkView) this.ghy.findViewById(d.g.no_network_view);
        this.ghC = (CustomScrollView) this.ghy.findViewById(d.g.scoll_view);
        this.ghC.setOnTouchListener(new View$OnTouchListenerC0314a());
        this.ghD = (ItemHeaderView) this.ghy.findViewById(d.g.item_header);
        this.ghE = (ItemInfoView) this.ghy.findViewById(d.g.item_info);
        this.ghF = (ItemMsgManage) this.ghy.findViewById(d.g.item_msg_manage);
        this.ghG = (ItemEmotionView) this.ghy.findViewById(d.g.item_emotion_manage);
        this.ghH = (ItemHotThreadView) this.ghy.findViewById(d.g.item_hot_thread);
        this.ghI = (ItemFootNavView) this.ghy.findViewById(d.g.item_foot_nav);
        this.ghI.setClickable(true);
        this.mRootView = this.ghy.findViewById(d.g.root_rl);
        bsL();
        this.ghF.setMsgOnClickListener(this.ghy);
        this.ghG.setEmotionOnClickListener(this.ghy);
        this.ghF.setSwitchChangeListener(this.ghy);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo) {
        this.ghD.setData(recommendForumInfo);
        this.ghE.setData(recommendForumInfo);
        this.ghF.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo);
        this.ghI.setData(recommendForumInfo, this.ghy);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.ghG.setEmotionData(forumEmotionData);
    }

    public void ao(List<SimpleThreadInfo> list) {
        this.ghH.setData(list);
    }

    public void bhp() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bsL() {
        this.mProgressBar = new ProgressBar(this.ghy.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.ghy.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.ghy.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.ghy.getLayoutMode().setNightMode(i == 1);
        this.ghy.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbr.onChangeSkinType(getPageContext(), i);
        this.ghD.a(this.ghy, i);
        this.ghE.a(this.ghy, i);
        this.ghF.a(this.ghy, i);
        this.ghH.a(this.ghy, i);
        this.ghI.a(this.ghy, i);
    }

    public void onResume() {
        this.ghI.e(this.ghy);
    }

    public void bsM() {
        if (this.ghJ == null) {
            this.ghJ = new com.baidu.tbadk.core.dialog.a(this.ghy.getPageContext().getPageActivity());
            this.ghJ.gC(d.j.officical_bar_info_clean_alert);
            this.ghJ.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ghJ.dismiss();
                    a.this.ghy.clearHistory();
                }
            });
            this.ghJ.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ghJ.dismiss();
                }
            });
        }
        this.ghJ.b(getPageContext()).aaW();
    }

    public NoNetworkView bsN() {
        return this.dbr;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bum = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.ghF.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ghF.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void nQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ghy.getPageContext().getPageActivity(), this.ghB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.hT(i), null);
            this.mNoDataView.setOnClickListener(this.bum);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(i));
        this.mNoDataView.onChangeSkinType(this.ghy.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.ghI.la(false);
                    break;
                case 1:
                    a.this.ghI.la(true);
                    break;
                case 2:
                    a.this.ghI.la(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ghI.kZ(z);
        this.ghF.setShowState(recommendForumInfo, z);
    }
}
