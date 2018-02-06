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
    private View.OnClickListener aIl;
    private NoNetworkView cbj;
    private ForumDetailActivity eCf;
    private LinearLayout eCi;
    private CustomScrollView eCj;
    private ItemHeaderView eCk;
    private ItemInfoView eCl;
    private ItemMsgManage eCm;
    private ItemEmotionView eCn;
    private ItemHotThreadView eCo;
    private ItemFootNavView eCp;
    private com.baidu.tbadk.core.dialog.a eCq;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eCf = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eCi = (LinearLayout) this.eCf.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.eCf.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eCi.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eCf.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eCf.getPageContext().getString(d.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cbj = (NoNetworkView) this.eCf.findViewById(d.g.no_network_view);
        this.eCj = (CustomScrollView) this.eCf.findViewById(d.g.scoll_view);
        this.eCj.setOnTouchListener(new View$OnTouchListenerC0172a());
        this.eCk = (ItemHeaderView) this.eCf.findViewById(d.g.item_header);
        this.eCl = (ItemInfoView) this.eCf.findViewById(d.g.item_info);
        this.eCm = (ItemMsgManage) this.eCf.findViewById(d.g.item_msg_manage);
        this.eCn = (ItemEmotionView) this.eCf.findViewById(d.g.item_emotion_manage);
        this.eCo = (ItemHotThreadView) this.eCf.findViewById(d.g.item_hot_thread);
        this.eCp = (ItemFootNavView) this.eCf.findViewById(d.g.item_foot_nav);
        this.eCp.setClickable(true);
        this.mRootView = this.eCf.findViewById(d.g.root_rl);
        aII();
        this.eCm.setMsgOnClickListener(this.eCf);
        this.eCn.setEmotionOnClickListener(this.eCf);
        this.eCm.setSwitchChangeListener(this.eCf);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eCk.setData(recommendForumInfo);
        this.eCl.setData(recommendForumInfo);
        this.eCm.b(recommendForumInfo, z, managerApplyInfo);
        this.eCp.a(recommendForumInfo, this.eCf);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eCn.setEmotionData(forumEmotionData);
    }

    public void X(List<SimpleThreadInfo> list) {
        this.eCo.setData(list);
    }

    public void aIH() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aII() {
        this.mProgressBar = new ProgressBar(this.eCf.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eCf.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eCf.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eCf.getLayoutMode().aQ(i == 1);
        this.eCf.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cbj.onChangeSkinType(getPageContext(), i);
        this.eCk.a(this.eCf, i);
        this.eCl.a(this.eCf, i);
        this.eCm.a(this.eCf, i);
        this.eCo.a(this.eCf, i);
        this.eCp.a(this.eCf, i);
    }

    public void onResume() {
        this.eCp.e(this.eCf);
    }

    public void aIJ() {
        if (this.eCq == null) {
            this.eCq = new com.baidu.tbadk.core.dialog.a(this.eCf.getPageContext().getPageActivity());
            this.eCq.fb(d.j.officical_bar_info_clean_alert);
            this.eCq.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eCq.dismiss();
                    a.this.eCf.clearHistory();
                }
            });
            this.eCq.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eCq.dismiss();
                }
            });
        }
        this.eCq.b(getPageContext()).AU();
    }

    public NoNetworkView aIK() {
        return this.cbj;
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIl = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eCm.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eCm.c(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void lc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eCf.getPageContext().getPageActivity(), this.eCi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.gp(i), null);
            this.mNoDataView.setOnClickListener(this.aIl);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(i));
        this.mNoDataView.onChangeSkinType(this.eCf.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0172a implements View.OnTouchListener {
        private View$OnTouchListenerC0172a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.eCp.hw(false);
                    break;
                case 1:
                    a.this.eCp.hw(true);
                    break;
                case 2:
                    a.this.eCp.hw(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eCp.hv(z);
        this.eCm.c(recommendForumInfo, z);
    }
}
