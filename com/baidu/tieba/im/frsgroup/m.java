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
    private BdListView eDU;
    private MembersActivity eJC;
    private l eJV;
    private TextView eJW;
    private NoDataView eJX;
    private ViewGroup eJY;
    private ViewGroup eJZ;
    private RelativeLayout eKa;
    private ViewGroup eKb;
    private TextView eKc;
    private TextView eKd;
    private TextView eKe;
    private View eKf;
    private View eKg;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eJC = membersActivity;
        membersActivity.setContentView(e.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eJC.findViewById(e.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eJC.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eJC.getPageContext().getString(e.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eJC.finish();
            }
        });
        this.eKg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eJW = (TextView) this.eKg.findViewById(e.g.right_textview);
        this.eJW.setText(this.eJC.getResources().getString(e.j.members_order));
        this.eJW.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eDU = (BdListView) membersActivity.findViewById(e.g.members_list);
        this.eJX = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(e.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eJV = new l(this.eJC);
        this.eDU.setAdapter((ListAdapter) this.eJV);
        this.eDU.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eKf != null) {
                        m.this.eKf.setVisibility(0);
                    }
                } else if (m.this.eKf != null) {
                    m.this.eKf.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eJY = (ViewGroup) membersActivity.findViewById(e.g.bottom_manager);
        this.eKf = membersActivity.findViewById(e.g.bottom_divider_line);
        this.eJZ = (ViewGroup) membersActivity.findViewById(e.g.bottom_edit);
        this.eKa = (RelativeLayout) membersActivity.findViewById(e.g.edit_lay);
        this.eKb = (ViewGroup) membersActivity.findViewById(e.g.bottom_send_edit);
        this.eKc = (TextView) membersActivity.findViewById(e.g.edit_cancel);
        this.eKd = (TextView) membersActivity.findViewById(e.g.edit_num);
        this.eKe = (TextView) membersActivity.findViewById(e.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(e.g.progress_loading);
        pB(0);
    }

    public void iz(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aPz() {
        return this.eJZ;
    }

    public void onChangeSkinType(int i) {
        this.eJC.getLayoutMode().setNightMode(i == 1);
        this.eJC.getLayoutMode().onModeChanged(this.mRootView);
        this.eJC.getLayoutMode().onModeChanged(this.eKg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eKe.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eJV != null) {
            this.eJV.notifyDataSetChanged();
        }
    }

    public TextView aPA() {
        return this.eKc;
    }

    public TextView aPB() {
        return this.eKd;
    }

    public void pB(int i) {
        this.eKd.setText(this.eJC.getPageContext().getPageActivity().getString(e.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eDU.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.eJC.getPageContext().getPageActivity(), e.C0200e.ds150);
            this.eJY.setVisibility(0);
            this.eKa.setVisibility(0);
            this.eKb.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eJY.setVisibility(8);
        }
        this.eDU.requestLayout();
    }

    public void iA(boolean z) {
        if (z) {
            this.eKa.setVisibility(8);
            this.eKb.setVisibility(0);
            return;
        }
        this.eKa.setVisibility(0);
        this.eKb.setVisibility(8);
    }

    public void aFc() {
        this.eDU.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public NoDataView aPC() {
        return this.eJX;
    }

    public l aPD() {
        return this.eJV;
    }

    public void aPE() {
        this.eJV.notifyDataSetChanged();
    }

    public TextView aPF() {
        return this.eJW;
    }

    public void iB(boolean z) {
        this.eJW.setEnabled(z);
    }

    public BdListView aMS() {
        return this.eDU;
    }
}
