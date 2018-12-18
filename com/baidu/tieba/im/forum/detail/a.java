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
    private View.OnClickListener amU;
    private NoNetworkView bOx;
    private ForumDetailActivity eOa;
    private LinearLayout eOd;
    private CustomScrollView eOe;
    private ItemHeaderView eOf;
    private ItemInfoView eOg;
    private ItemMsgManage eOh;
    private ItemEmotionView eOi;
    private ItemHotThreadView eOj;
    private ItemFootNavView eOk;
    private com.baidu.tbadk.core.dialog.a eOl;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eOa = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eOd = (LinearLayout) this.eOa.findViewById(e.g.scoll_view_ll);
        TextView textView = new TextView(this.eOa.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eOd.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eOa.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eOa.getPageContext().getString(e.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bOx = (NoNetworkView) this.eOa.findViewById(e.g.no_network_view);
        this.eOe = (CustomScrollView) this.eOa.findViewById(e.g.scoll_view);
        this.eOe.setOnTouchListener(new View$OnTouchListenerC0246a());
        this.eOf = (ItemHeaderView) this.eOa.findViewById(e.g.item_header);
        this.eOg = (ItemInfoView) this.eOa.findViewById(e.g.item_info);
        this.eOh = (ItemMsgManage) this.eOa.findViewById(e.g.item_msg_manage);
        this.eOi = (ItemEmotionView) this.eOa.findViewById(e.g.item_emotion_manage);
        this.eOj = (ItemHotThreadView) this.eOa.findViewById(e.g.item_hot_thread);
        this.eOk = (ItemFootNavView) this.eOa.findViewById(e.g.item_foot_nav);
        this.eOk.setClickable(true);
        this.mRootView = this.eOa.findViewById(e.g.root_rl);
        aQV();
        this.eOh.setMsgOnClickListener(this.eOa);
        this.eOi.setEmotionOnClickListener(this.eOa);
        this.eOh.setSwitchChangeListener(this.eOa);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eOf.setData(recommendForumInfo);
        this.eOg.setData(recommendForumInfo);
        this.eOh.setData(recommendForumInfo, z, managerApplyInfo);
        this.eOk.setData(recommendForumInfo, this.eOa);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eOi.setEmotionData(forumEmotionData);
    }

    public void aa(List<SimpleThreadInfo> list) {
        this.eOj.setData(list);
    }

    public void aFP() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aQV() {
        this.mProgressBar = new ProgressBar(this.eOa.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eOa.getPageContext().getResources().getDrawable(e.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eOa.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eOa.getLayoutMode().setNightMode(i == 1);
        this.eOa.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bOx.onChangeSkinType(getPageContext(), i);
        this.eOf.a(this.eOa, i);
        this.eOg.a(this.eOa, i);
        this.eOh.a(this.eOa, i);
        this.eOj.a(this.eOa, i);
        this.eOk.a(this.eOa, i);
    }

    public void onResume() {
        this.eOk.e(this.eOa);
    }

    public void aQW() {
        if (this.eOl == null) {
            this.eOl = new com.baidu.tbadk.core.dialog.a(this.eOa.getPageContext().getPageActivity());
            this.eOl.db(e.j.officical_bar_info_clean_alert);
            this.eOl.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eOl.dismiss();
                    a.this.eOa.clearHistory();
                }
            });
            this.eOl.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eOl.dismiss();
                }
            });
        }
        this.eOl.b(getPageContext()).BF();
    }

    public NoNetworkView aQX() {
        return this.bOx;
    }

    public void c(View.OnClickListener onClickListener) {
        this.amU = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eOh.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eOh.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void jX(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eOa.getPageContext().getPageActivity(), this.eOd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.eq(i), null);
            this.mNoDataView.setOnClickListener(this.amU);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.onChangeSkinType(this.eOa.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0246a implements View.OnTouchListener {
        private View$OnTouchListenerC0246a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.eOk.ix(false);
                    break;
                case 1:
                    a.this.eOk.ix(true);
                    break;
                case 2:
                    a.this.eOk.ix(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eOk.iw(z);
        this.eOh.setShowState(recommendForumInfo, z);
    }
}
