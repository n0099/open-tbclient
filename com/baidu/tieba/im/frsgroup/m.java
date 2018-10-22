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
    private BdListView eCB;
    private l eID;
    private TextView eIE;
    private NoDataView eIF;
    private ViewGroup eIG;
    private ViewGroup eIH;
    private RelativeLayout eII;
    private ViewGroup eIJ;
    private TextView eIK;
    private TextView eIL;
    private TextView eIM;
    private View eIN;
    private View eIO;
    private MembersActivity eIk;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eIk = membersActivity;
        membersActivity.setContentView(e.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eIk.findViewById(e.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eIk.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eIk.getPageContext().getString(e.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eIk.finish();
            }
        });
        this.eIO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eIE = (TextView) this.eIO.findViewById(e.g.right_textview);
        this.eIE.setText(this.eIk.getResources().getString(e.j.members_order));
        this.eIE.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eCB = (BdListView) membersActivity.findViewById(e.g.members_list);
        this.eIF = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(e.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eID = new l(this.eIk);
        this.eCB.setAdapter((ListAdapter) this.eID);
        this.eCB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eIN != null) {
                        m.this.eIN.setVisibility(0);
                    }
                } else if (m.this.eIN != null) {
                    m.this.eIN.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eIG = (ViewGroup) membersActivity.findViewById(e.g.bottom_manager);
        this.eIN = membersActivity.findViewById(e.g.bottom_divider_line);
        this.eIH = (ViewGroup) membersActivity.findViewById(e.g.bottom_edit);
        this.eII = (RelativeLayout) membersActivity.findViewById(e.g.edit_lay);
        this.eIJ = (ViewGroup) membersActivity.findViewById(e.g.bottom_send_edit);
        this.eIK = (TextView) membersActivity.findViewById(e.g.edit_cancel);
        this.eIL = (TextView) membersActivity.findViewById(e.g.edit_num);
        this.eIM = (TextView) membersActivity.findViewById(e.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(e.g.progress_loading);
        pi(0);
    }

    public void iq(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aQc() {
        return this.eIH;
    }

    public void onChangeSkinType(int i) {
        this.eIk.getLayoutMode().setNightMode(i == 1);
        this.eIk.getLayoutMode().onModeChanged(this.mRootView);
        this.eIk.getLayoutMode().onModeChanged(this.eIO);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eIM.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eID != null) {
            this.eID.notifyDataSetChanged();
        }
    }

    public TextView aQd() {
        return this.eIK;
    }

    public TextView aQe() {
        return this.eIL;
    }

    public void pi(int i) {
        this.eIL.setText(this.eIk.getPageContext().getPageActivity().getString(e.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eCB.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.eIk.getPageContext().getPageActivity(), e.C0175e.ds150);
            this.eIG.setVisibility(0);
            this.eII.setVisibility(0);
            this.eIJ.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eIG.setVisibility(8);
        }
        this.eCB.requestLayout();
    }

    public void ir(boolean z) {
        if (z) {
            this.eII.setVisibility(8);
            this.eIJ.setVisibility(0);
            return;
        }
        this.eII.setVisibility(0);
        this.eIJ.setVisibility(8);
    }

    public void aFG() {
        this.eCB.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public NoDataView aQf() {
        return this.eIF;
    }

    public l aQg() {
        return this.eID;
    }

    public void aQh() {
        this.eID.notifyDataSetChanged();
    }

    public TextView aQi() {
        return this.eIE;
    }

    public void is(boolean z) {
        this.eIE.setEnabled(z);
    }

    public BdListView aNv() {
        return this.eCB;
    }
}
