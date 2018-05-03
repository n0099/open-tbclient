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
    private BdListView dTr;
    private ViewGroup dZA;
    private TextView dZB;
    private TextView dZC;
    private TextView dZD;
    private View dZE;
    private View dZF;
    private MembersActivity dZb;
    private l dZu;
    private TextView dZv;
    private NoDataView dZw;
    private ViewGroup dZx;
    private ViewGroup dZy;
    private RelativeLayout dZz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.dZb = membersActivity;
        membersActivity.setContentView(d.i.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.dZb.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.dZb.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dZb.getPageContext().getString(d.k.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                m.this.dZb.finish();
            }
        });
        this.dZF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.group_member_navi_right_button, (View.OnClickListener) null);
        this.dZv = (TextView) this.dZF.findViewById(d.g.right_textview);
        this.dZv.setText(this.dZb.getResources().getString(d.k.members_order));
        this.dZv.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.dTr = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.dZw = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.dZu = new l(this.dZb);
        this.dTr.setAdapter((ListAdapter) this.dZu);
        this.dTr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.dZE != null) {
                        m.this.dZE.setVisibility(0);
                    }
                } else if (m.this.dZE != null) {
                    m.this.dZE.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.dZx = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.dZE = membersActivity.findViewById(d.g.bottom_divider_line);
        this.dZy = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.dZz = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.dZA = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.dZB = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.dZC = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.dZD = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        nA(0);
    }

    public void hg(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aEa() {
        return this.dZy;
    }

    public void onChangeSkinType(int i) {
        this.dZb.getLayoutMode().setNightMode(i == 1);
        this.dZb.getLayoutMode().u(this.mRootView);
        this.dZb.getLayoutMode().u(this.dZF);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dZD.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.dZu != null) {
            this.dZu.notifyDataSetChanged();
        }
    }

    public TextView aEb() {
        return this.dZB;
    }

    public TextView aEc() {
        return this.dZC;
    }

    public void nA(int i) {
        this.dZC.setText(this.dZb.getPageContext().getPageActivity().getString(d.k.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dTr.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(this.dZb.getPageContext().getPageActivity(), d.e.ds150);
            this.dZx.setVisibility(0);
            this.dZz.setVisibility(0);
            this.dZA.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.dZx.setVisibility(8);
        }
        this.dTr.requestLayout();
    }

    public void hh(boolean z) {
        if (z) {
            this.dZz.setVisibility(8);
            this.dZA.setVisibility(0);
            return;
        }
        this.dZz.setVisibility(0);
        this.dZA.setVisibility(8);
    }

    public void auL() {
        this.dTr.completePullRefreshPostDelayed(2000L);
    }

    public NoDataView aEd() {
        return this.dZw;
    }

    public l aEe() {
        return this.dZu;
    }

    public void aEf() {
        this.dZu.notifyDataSetChanged();
    }

    public TextView aEg() {
        return this.dZv;
    }

    public void hi(boolean z) {
        this.dZv.setEnabled(z);
    }

    public BdListView aBt() {
        return this.dTr;
    }
}
