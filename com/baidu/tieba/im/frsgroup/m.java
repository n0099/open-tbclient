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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView gee;
    private MembersActivity gjQ;
    private l gkj;
    private TextView gkk;
    private NoDataView gkl;
    private ViewGroup gkm;
    private ViewGroup gkn;
    private RelativeLayout gko;
    private ViewGroup gkp;
    private TextView gkq;
    private TextView gkr;
    private TextView gks;
    private View gkt;
    private View gku;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gjQ = membersActivity;
        membersActivity.setContentView(d.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gjQ.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.gjQ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gjQ.getPageContext().getString(d.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gjQ.finish();
            }
        });
        this.gku = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.gkk = (TextView) this.gku.findViewById(d.g.right_textview);
        this.gkk.setText(this.gjQ.getResources().getString(d.j.members_order));
        this.gkk.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gee = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.gkl = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gkj = new l(this.gjQ);
        this.gee.setAdapter((ListAdapter) this.gkj);
        this.gee.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gkt != null) {
                        m.this.gkt.setVisibility(0);
                    }
                } else if (m.this.gkt != null) {
                    m.this.gkt.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gkm = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.gkt = membersActivity.findViewById(d.g.bottom_divider_line);
        this.gkn = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.gko = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.gkp = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.gkq = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.gkr = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.gks = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        tP(0);
    }

    public void lf(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup btg() {
        return this.gkn;
    }

    public void onChangeSkinType(int i) {
        this.gjQ.getLayoutMode().setNightMode(i == 1);
        this.gjQ.getLayoutMode().onModeChanged(this.mRootView);
        this.gjQ.getLayoutMode().onModeChanged(this.gku);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gks.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gkj != null) {
            this.gkj.notifyDataSetChanged();
        }
    }

    public TextView bth() {
        return this.gkq;
    }

    public TextView bti() {
        return this.gkr;
    }

    public void tP(int i) {
        this.gkr.setText(this.gjQ.getPageContext().getPageActivity().getString(d.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gee.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.gjQ.getPageContext().getPageActivity(), d.e.ds150);
            this.gkm.setVisibility(0);
            this.gko.setVisibility(0);
            this.gkp.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gkm.setVisibility(8);
        }
        this.gee.requestLayout();
    }

    public void lg(boolean z) {
        if (z) {
            this.gko.setVisibility(8);
            this.gkp.setVisibility(0);
            return;
        }
        this.gko.setVisibility(0);
        this.gkp.setVisibility(8);
    }

    public void bin() {
        this.gee.completePullRefreshPostDelayed(0L);
    }

    public NoDataView btj() {
        return this.gkl;
    }

    public l btk() {
        return this.gkj;
    }

    public void btl() {
        this.gkj.notifyDataSetChanged();
    }

    public TextView btm() {
        return this.gkk;
    }

    public void lh(boolean z) {
        this.gkk.setEnabled(z);
    }

    public BdListView bqz() {
        return this.gee;
    }
}
