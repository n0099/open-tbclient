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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener aIb;
    private NoNetworkView cba;
    private ForumDetailActivity eCj;
    private LinearLayout eCm;
    private CustomScrollView eCn;
    private ItemHeaderView eCo;
    private ItemInfoView eCp;
    private ItemMsgManage eCq;
    private ItemEmotionView eCr;
    private ItemHotThreadView eCs;
    private ItemFootNavView eCt;
    private com.baidu.tbadk.core.dialog.a eCu;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eCj = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eCm = (LinearLayout) this.eCj.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.eCj.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eCm.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eCj.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eCj.getPageContext().getString(d.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cba = (NoNetworkView) this.eCj.findViewById(d.g.no_network_view);
        this.eCn = (CustomScrollView) this.eCj.findViewById(d.g.scoll_view);
        this.eCn.setOnTouchListener(new View$OnTouchListenerC0173a());
        this.eCo = (ItemHeaderView) this.eCj.findViewById(d.g.item_header);
        this.eCp = (ItemInfoView) this.eCj.findViewById(d.g.item_info);
        this.eCq = (ItemMsgManage) this.eCj.findViewById(d.g.item_msg_manage);
        this.eCr = (ItemEmotionView) this.eCj.findViewById(d.g.item_emotion_manage);
        this.eCs = (ItemHotThreadView) this.eCj.findViewById(d.g.item_hot_thread);
        this.eCt = (ItemFootNavView) this.eCj.findViewById(d.g.item_foot_nav);
        this.eCt.setClickable(true);
        this.mRootView = this.eCj.findViewById(d.g.root_rl);
        aII();
        this.eCq.setMsgOnClickListener(this.eCj);
        this.eCr.setEmotionOnClickListener(this.eCj);
        this.eCq.setSwitchChangeListener(this.eCj);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eCo.setData(recommendForumInfo);
        this.eCp.setData(recommendForumInfo);
        this.eCq.b(recommendForumInfo, z, managerApplyInfo);
        this.eCt.a(recommendForumInfo, this.eCj);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eCr.setEmotionData(forumEmotionData);
    }

    public void X(List<SimpleThreadInfo> list) {
        this.eCs.setData(list);
    }

    public void aIH() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aII() {
        this.mProgressBar = new ProgressBar(this.eCj.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eCj.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eCj.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eCj.getLayoutMode().aQ(i == 1);
        this.eCj.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cba.onChangeSkinType(getPageContext(), i);
        this.eCo.a(this.eCj, i);
        this.eCp.a(this.eCj, i);
        this.eCq.a(this.eCj, i);
        this.eCs.a(this.eCj, i);
        this.eCt.a(this.eCj, i);
    }

    public void onResume() {
        this.eCt.e(this.eCj);
    }

    public void aIJ() {
        if (this.eCu == null) {
            this.eCu = new com.baidu.tbadk.core.dialog.a(this.eCj.getPageContext().getPageActivity());
            this.eCu.fb(d.j.officical_bar_info_clean_alert);
            this.eCu.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eCu.dismiss();
                    a.this.eCj.clearHistory();
                }
            });
            this.eCu.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eCu.dismiss();
                }
            });
        }
        this.eCu.b(getPageContext()).AV();
    }

    public NoNetworkView aIK() {
        return this.cba;
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIb = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eCq.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eCq.c(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void lc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eCj.getPageContext().getPageActivity(), this.eCm, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.gp(i), null);
            this.mNoDataView.setOnClickListener(this.aIb);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(i));
        this.mNoDataView.onChangeSkinType(this.eCj.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.eCt.hB(false);
                    break;
                case 1:
                    a.this.eCt.hB(true);
                    break;
                case 2:
                    a.this.eCt.hB(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eCt.hA(z);
        this.eCq.c(recommendForumInfo, z);
    }
}
