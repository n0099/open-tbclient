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
    private View.OnClickListener ajs;
    private NoNetworkView bKI;
    private ForumDetailActivity eHl;
    private LinearLayout eHo;
    private CustomScrollView eHp;
    private ItemHeaderView eHq;
    private ItemInfoView eHr;
    private ItemMsgManage eHs;
    private ItemEmotionView eHt;
    private ItemHotThreadView eHu;
    private ItemFootNavView eHv;
    private com.baidu.tbadk.core.dialog.a eHw;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eHl = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eHo = (LinearLayout) this.eHl.findViewById(e.g.scoll_view_ll);
        TextView textView = new TextView(this.eHl.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eHo.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eHl.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eHl.getPageContext().getString(e.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bKI = (NoNetworkView) this.eHl.findViewById(e.g.no_network_view);
        this.eHp = (CustomScrollView) this.eHl.findViewById(e.g.scoll_view);
        this.eHp.setOnTouchListener(new View$OnTouchListenerC0235a());
        this.eHq = (ItemHeaderView) this.eHl.findViewById(e.g.item_header);
        this.eHr = (ItemInfoView) this.eHl.findViewById(e.g.item_info);
        this.eHs = (ItemMsgManage) this.eHl.findViewById(e.g.item_msg_manage);
        this.eHt = (ItemEmotionView) this.eHl.findViewById(e.g.item_emotion_manage);
        this.eHu = (ItemHotThreadView) this.eHl.findViewById(e.g.item_hot_thread);
        this.eHv = (ItemFootNavView) this.eHl.findViewById(e.g.item_foot_nav);
        this.eHv.setClickable(true);
        this.mRootView = this.eHl.findViewById(e.g.root_rl);
        aPe();
        this.eHs.setMsgOnClickListener(this.eHl);
        this.eHt.setEmotionOnClickListener(this.eHl);
        this.eHs.setSwitchChangeListener(this.eHl);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eHq.setData(recommendForumInfo);
        this.eHr.setData(recommendForumInfo);
        this.eHs.setData(recommendForumInfo, z, managerApplyInfo);
        this.eHv.setData(recommendForumInfo, this.eHl);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eHt.setEmotionData(forumEmotionData);
    }

    public void aa(List<SimpleThreadInfo> list) {
        this.eHu.setData(list);
    }

    public void aEd() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aPe() {
        this.mProgressBar = new ProgressBar(this.eHl.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eHl.getPageContext().getResources().getDrawable(e.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eHl.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eHl.getLayoutMode().setNightMode(i == 1);
        this.eHl.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bKI.onChangeSkinType(getPageContext(), i);
        this.eHq.a(this.eHl, i);
        this.eHr.a(this.eHl, i);
        this.eHs.a(this.eHl, i);
        this.eHu.a(this.eHl, i);
        this.eHv.a(this.eHl, i);
    }

    public void onResume() {
        this.eHv.e(this.eHl);
    }

    public void aPf() {
        if (this.eHw == null) {
            this.eHw = new com.baidu.tbadk.core.dialog.a(this.eHl.getPageContext().getPageActivity());
            this.eHw.cN(e.j.officical_bar_info_clean_alert);
            this.eHw.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eHw.dismiss();
                    a.this.eHl.clearHistory();
                }
            });
            this.eHw.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eHw.dismiss();
                }
            });
        }
        this.eHw.b(getPageContext()).AB();
    }

    public NoNetworkView aPg() {
        return this.bKI;
    }

    public void c(View.OnClickListener onClickListener) {
        this.ajs = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eHs.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eHs.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void jJ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eHl.getPageContext().getPageActivity(), this.eHo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.ec(i), null);
            this.mNoDataView.setOnClickListener(this.ajs);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(i));
        this.mNoDataView.onChangeSkinType(this.eHl.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0235a implements View.OnTouchListener {
        private View$OnTouchListenerC0235a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.eHv.iu(false);
                    break;
                case 1:
                    a.this.eHv.iu(true);
                    break;
                case 2:
                    a.this.eHv.iu(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eHv.it(z);
        this.eHs.setShowState(recommendForumInfo, z);
    }
}
