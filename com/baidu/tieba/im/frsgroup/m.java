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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView eCA;
    private l eIC;
    private TextView eID;
    private NoDataView eIE;
    private ViewGroup eIF;
    private ViewGroup eIG;
    private RelativeLayout eIH;
    private ViewGroup eII;
    private TextView eIJ;
    private TextView eIK;
    private TextView eIL;
    private View eIM;
    private View eIN;
    private MembersActivity eIj;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eIj = membersActivity;
        membersActivity.setContentView(e.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eIj.findViewById(e.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eIj.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eIj.getPageContext().getString(e.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eIj.finish();
            }
        });
        this.eIN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eID = (TextView) this.eIN.findViewById(e.g.right_textview);
        this.eID.setText(this.eIj.getResources().getString(e.j.members_order));
        this.eID.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eCA = (BdListView) membersActivity.findViewById(e.g.members_list);
        this.eIE = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(e.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eIC = new l(this.eIj);
        this.eCA.setAdapter((ListAdapter) this.eIC);
        this.eCA.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eIM != null) {
                        m.this.eIM.setVisibility(0);
                    }
                } else if (m.this.eIM != null) {
                    m.this.eIM.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eIF = (ViewGroup) membersActivity.findViewById(e.g.bottom_manager);
        this.eIM = membersActivity.findViewById(e.g.bottom_divider_line);
        this.eIG = (ViewGroup) membersActivity.findViewById(e.g.bottom_edit);
        this.eIH = (RelativeLayout) membersActivity.findViewById(e.g.edit_lay);
        this.eII = (ViewGroup) membersActivity.findViewById(e.g.bottom_send_edit);
        this.eIJ = (TextView) membersActivity.findViewById(e.g.edit_cancel);
        this.eIK = (TextView) membersActivity.findViewById(e.g.edit_num);
        this.eIL = (TextView) membersActivity.findViewById(e.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(e.g.progress_loading);
        pi(0);
    }

    public void iq(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aQc() {
        return this.eIG;
    }

    public void onChangeSkinType(int i) {
        this.eIj.getLayoutMode().setNightMode(i == 1);
        this.eIj.getLayoutMode().onModeChanged(this.mRootView);
        this.eIj.getLayoutMode().onModeChanged(this.eIN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eIL.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eIC != null) {
            this.eIC.notifyDataSetChanged();
        }
    }

    public TextView aQd() {
        return this.eIJ;
    }

    public TextView aQe() {
        return this.eIK;
    }

    public void pi(int i) {
        this.eIK.setText(this.eIj.getPageContext().getPageActivity().getString(e.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eCA.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.eIj.getPageContext().getPageActivity(), e.C0175e.ds150);
            this.eIF.setVisibility(0);
            this.eIH.setVisibility(0);
            this.eII.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eIF.setVisibility(8);
        }
        this.eCA.requestLayout();
    }

    public void ir(boolean z) {
        if (z) {
            this.eIH.setVisibility(8);
            this.eII.setVisibility(0);
            return;
        }
        this.eIH.setVisibility(0);
        this.eII.setVisibility(8);
    }

    public void aFG() {
        this.eCA.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public NoDataView aQf() {
        return this.eIE;
    }

    public l aQg() {
        return this.eIC;
    }

    public void aQh() {
        this.eIC.notifyDataSetChanged();
    }

    public TextView aQi() {
        return this.eID;
    }

    public void is(boolean z) {
        this.eID.setEnabled(z);
    }

    public BdListView aNv() {
        return this.eCA;
    }
}
