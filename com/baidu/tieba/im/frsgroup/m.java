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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView igF;
    private l imK;
    private TextView imL;
    private NoDataView imM;
    private ViewGroup imN;
    private ViewGroup imO;
    private RelativeLayout imP;
    private ViewGroup imQ;
    private TextView imR;
    private TextView imS;
    private TextView imT;
    private View imU;
    private View imV;
    private MembersActivity imr;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.imr = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.imr.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.imr.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.imr.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.imr.finish();
            }
        });
        this.imV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.imL = (TextView) this.imV.findViewById(R.id.right_textview);
        this.imL.setText(this.imr.getResources().getString(R.string.members_order));
        this.imL.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.igF = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.imM = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.imK = new l(this.imr);
        this.igF.setAdapter((ListAdapter) this.imK);
        this.igF.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.imU != null) {
                        m.this.imU.setVisibility(0);
                    }
                } else if (m.this.imU != null) {
                    m.this.imU.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.imN = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.imU = membersActivity.findViewById(R.id.bottom_divider_line);
        this.imO = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.imP = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.imQ = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.imR = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.imS = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.imT = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        xb(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cgh() {
        return this.imO;
    }

    public void onChangeSkinType(int i) {
        this.imr.getLayoutMode().setNightMode(i == 1);
        this.imr.getLayoutMode().onModeChanged(this.mRootView);
        this.imr.getLayoutMode().onModeChanged(this.imV);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.imT.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.imK != null) {
            this.imK.notifyDataSetChanged();
        }
    }

    public TextView cgi() {
        return this.imR;
    }

    public TextView cgj() {
        return this.imS;
    }

    public void xb(int i) {
        this.imS.setText(this.imr.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.igF.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.imr.getPageContext().getPageActivity(), R.dimen.ds150);
            this.imN.setVisibility(0);
            this.imP.setVisibility(0);
            this.imQ.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.imN.setVisibility(8);
        }
        this.igF.requestLayout();
    }

    public void oM(boolean z) {
        if (z) {
            this.imP.setVisibility(8);
            this.imQ.setVisibility(0);
            return;
        }
        this.imP.setVisibility(0);
        this.imQ.setVisibility(8);
    }

    public void bUy() {
        this.igF.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cgk() {
        return this.imM;
    }

    public l cgl() {
        return this.imK;
    }

    public void cgm() {
        this.imK.notifyDataSetChanged();
    }

    public TextView cgn() {
        return this.imL;
    }

    public void oN(boolean z) {
        this.imL.setEnabled(z);
    }

    public BdListView cdA() {
        return this.igF;
    }
}
