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
import com.baidu.tieba.e;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener adI;
    private NoNetworkView bBq;
    private ForumDetailActivity eyg;
    private LinearLayout eyj;
    private CustomScrollView eyk;
    private ItemHeaderView eyl;
    private ItemInfoView eyn;
    private ItemMsgManage eyo;
    private ItemEmotionView eyp;
    private ItemHotThreadView eyq;
    private ItemFootNavView eyr;
    private com.baidu.tbadk.core.dialog.a eys;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eyg = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eyj = (LinearLayout) this.eyg.findViewById(e.g.scoll_view_ll);
        TextView textView = new TextView(this.eyg.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eyj.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eyg.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eyg.getPageContext().getString(e.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bBq = (NoNetworkView) this.eyg.findViewById(e.g.no_network_view);
        this.eyk = (CustomScrollView) this.eyg.findViewById(e.g.scoll_view);
        this.eyk.setOnTouchListener(new View$OnTouchListenerC0175a());
        this.eyl = (ItemHeaderView) this.eyg.findViewById(e.g.item_header);
        this.eyn = (ItemInfoView) this.eyg.findViewById(e.g.item_info);
        this.eyo = (ItemMsgManage) this.eyg.findViewById(e.g.item_msg_manage);
        this.eyp = (ItemEmotionView) this.eyg.findViewById(e.g.item_emotion_manage);
        this.eyq = (ItemHotThreadView) this.eyg.findViewById(e.g.item_hot_thread);
        this.eyr = (ItemFootNavView) this.eyg.findViewById(e.g.item_foot_nav);
        this.eyr.setClickable(true);
        this.mRootView = this.eyg.findViewById(e.g.root_rl);
        aMs();
        this.eyo.setMsgOnClickListener(this.eyg);
        this.eyp.setEmotionOnClickListener(this.eyg);
        this.eyo.setSwitchChangeListener(this.eyg);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eyl.setData(recommendForumInfo);
        this.eyn.setData(recommendForumInfo);
        this.eyo.setData(recommendForumInfo, z, managerApplyInfo);
        this.eyr.setData(recommendForumInfo, this.eyg);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eyp.setEmotionData(forumEmotionData);
    }

    public void S(List<SimpleThreadInfo> list) {
        this.eyq.setData(list);
    }

    public void aBo() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aMs() {
        this.mProgressBar = new ProgressBar(this.eyg.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eyg.getPageContext().getResources().getDrawable(e.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eyg.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eyg.getLayoutMode().setNightMode(i == 1);
        this.eyg.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bBq.onChangeSkinType(getPageContext(), i);
        this.eyl.a(this.eyg, i);
        this.eyn.a(this.eyg, i);
        this.eyo.a(this.eyg, i);
        this.eyq.a(this.eyg, i);
        this.eyr.a(this.eyg, i);
    }

    public void onResume() {
        this.eyr.e(this.eyg);
    }

    public void aMt() {
        if (this.eys == null) {
            this.eys = new com.baidu.tbadk.core.dialog.a(this.eyg.getPageContext().getPageActivity());
            this.eys.cp(e.j.officical_bar_info_clean_alert);
            this.eys.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eys.dismiss();
                    a.this.eyg.clearHistory();
                }
            });
            this.eys.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eys.dismiss();
                }
            });
        }
        this.eys.b(getPageContext()).yl();
    }

    public NoNetworkView aMu() {
        return this.bBq;
    }

    public void b(View.OnClickListener onClickListener) {
        this.adI = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eyo.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eyo.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void iR(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eyg.getPageContext().getPageActivity(), this.eyj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.dE(i), null);
            this.mNoDataView.setOnClickListener(this.adI);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(i));
        this.mNoDataView.onChangeSkinType(this.eyg.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0175a implements View.OnTouchListener {
        private View$OnTouchListenerC0175a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.eyr.hT(false);
                    break;
                case 1:
                    a.this.eyr.hT(true);
                    break;
                case 2:
                    a.this.eyr.hT(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eyr.hS(z);
        this.eyo.setShowState(recommendForumInfo, z);
    }
}
