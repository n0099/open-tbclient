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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView dTu;
    private ViewGroup dZA;
    private ViewGroup dZB;
    private RelativeLayout dZC;
    private ViewGroup dZD;
    private TextView dZE;
    private TextView dZF;
    private TextView dZG;
    private View dZH;
    private View dZI;
    private MembersActivity dZe;
    private l dZx;
    private TextView dZy;
    private NoDataView dZz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.dZe = membersActivity;
        membersActivity.setContentView(d.i.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.dZe.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.dZe.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dZe.getPageContext().getString(d.k.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                m.this.dZe.finish();
            }
        });
        this.dZI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.group_member_navi_right_button, (View.OnClickListener) null);
        this.dZy = (TextView) this.dZI.findViewById(d.g.right_textview);
        this.dZy.setText(this.dZe.getResources().getString(d.k.members_order));
        this.dZy.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.dTu = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.dZz = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.dZx = new l(this.dZe);
        this.dTu.setAdapter((ListAdapter) this.dZx);
        this.dTu.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.dZH != null) {
                        m.this.dZH.setVisibility(0);
                    }
                } else if (m.this.dZH != null) {
                    m.this.dZH.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.dZA = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.dZH = membersActivity.findViewById(d.g.bottom_divider_line);
        this.dZB = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.dZC = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.dZD = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.dZE = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.dZF = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.dZG = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        nB(0);
    }

    public void hg(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aEa() {
        return this.dZB;
    }

    public void onChangeSkinType(int i) {
        this.dZe.getLayoutMode().setNightMode(i == 1);
        this.dZe.getLayoutMode().u(this.mRootView);
        this.dZe.getLayoutMode().u(this.dZI);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dZG.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.dZx != null) {
            this.dZx.notifyDataSetChanged();
        }
    }

    public TextView aEb() {
        return this.dZE;
    }

    public TextView aEc() {
        return this.dZF;
    }

    public void nB(int i) {
        this.dZF.setText(this.dZe.getPageContext().getPageActivity().getString(d.k.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dTu.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(this.dZe.getPageContext().getPageActivity(), d.e.ds150);
            this.dZA.setVisibility(0);
            this.dZC.setVisibility(0);
            this.dZD.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.dZA.setVisibility(8);
        }
        this.dTu.requestLayout();
    }

    public void hh(boolean z) {
        if (z) {
            this.dZC.setVisibility(8);
            this.dZD.setVisibility(0);
            return;
        }
        this.dZC.setVisibility(0);
        this.dZD.setVisibility(8);
    }

    public void auL() {
        this.dTu.completePullRefreshPostDelayed(2000L);
    }

    public NoDataView aEd() {
        return this.dZz;
    }

    public l aEe() {
        return this.dZx;
    }

    public void aEf() {
        this.dZx.notifyDataSetChanged();
    }

    public TextView aEg() {
        return this.dZy;
    }

    public void hi(boolean z) {
        this.dZy.setEnabled(z);
    }

    public BdListView aBt() {
        return this.dTu;
    }
}
