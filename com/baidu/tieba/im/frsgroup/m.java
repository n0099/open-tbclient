package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView iNm;
    private MembersActivity iSW;
    private View iTA;
    private l iTp;
    private TextView iTq;
    private NoDataView iTr;
    private ViewGroup iTs;
    private ViewGroup iTt;
    private RelativeLayout iTu;
    private ViewGroup iTv;
    private TextView iTw;
    private TextView iTx;
    private TextView iTy;
    private View iTz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.iSW = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.iSW.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.iSW.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iSW.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.iSW.finish();
            }
        });
        this.iTA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.iTq = (TextView) this.iTA.findViewById(R.id.right_textview);
        this.iTq.setText(this.iSW.getResources().getString(R.string.members_order));
        this.iTq.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.iNm = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.iTr = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.iTp = new l(this.iSW);
        this.iNm.setAdapter((ListAdapter) this.iTp);
        this.iNm.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.iTz != null) {
                        m.this.iTz.setVisibility(0);
                    }
                } else if (m.this.iTz != null) {
                    m.this.iTz.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.iTs = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.iTz = membersActivity.findViewById(R.id.bottom_divider_line);
        this.iTt = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.iTu = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.iTv = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.iTw = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.iTx = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.iTy = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        yt(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cqC() {
        return this.iTt;
    }

    public void onChangeSkinType(int i) {
        this.iSW.getLayoutMode().setNightMode(i == 1);
        this.iSW.getLayoutMode().onModeChanged(this.mRootView);
        this.iSW.getLayoutMode().onModeChanged(this.iTA);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iTy.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.iTp != null) {
            this.iTp.notifyDataSetChanged();
        }
    }

    public TextView cqD() {
        return this.iTw;
    }

    public TextView cqE() {
        return this.iTx;
    }

    public void yt(int i) {
        this.iTx.setText(this.iSW.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iNm.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.iSW.getPageContext().getPageActivity(), R.dimen.ds150);
            this.iTs.setVisibility(0);
            this.iTu.setVisibility(0);
            this.iTv.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.iTs.setVisibility(8);
        }
        this.iNm.requestLayout();
    }

    public void ps(boolean z) {
        if (z) {
            this.iTu.setVisibility(8);
            this.iTv.setVisibility(0);
            return;
        }
        this.iTu.setVisibility(0);
        this.iTv.setVisibility(8);
    }

    public void cev() {
        this.iNm.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cqF() {
        return this.iTr;
    }

    public l cqG() {
        return this.iTp;
    }

    public void cqH() {
        this.iTp.notifyDataSetChanged();
    }

    public TextView cqI() {
        return this.iTq;
    }

    public void pt(boolean z) {
        this.iTq.setEnabled(z);
    }

    public BdListView cnW() {
        return this.iNm;
    }
}
