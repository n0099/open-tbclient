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
    private MembersActivity gjR;
    private l gkk;
    private TextView gkl;
    private NoDataView gkm;
    private ViewGroup gkn;
    private ViewGroup gko;
    private RelativeLayout gkp;
    private ViewGroup gkq;
    private TextView gkr;
    private TextView gks;
    private TextView gkt;
    private View gku;
    private View gkv;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gjR = membersActivity;
        membersActivity.setContentView(d.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gjR.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.gjR.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gjR.getPageContext().getString(d.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gjR.finish();
            }
        });
        this.gkv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.gkl = (TextView) this.gkv.findViewById(d.g.right_textview);
        this.gkl.setText(this.gjR.getResources().getString(d.j.members_order));
        this.gkl.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gee = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.gkm = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gkk = new l(this.gjR);
        this.gee.setAdapter((ListAdapter) this.gkk);
        this.gee.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gku != null) {
                        m.this.gku.setVisibility(0);
                    }
                } else if (m.this.gku != null) {
                    m.this.gku.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gkn = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.gku = membersActivity.findViewById(d.g.bottom_divider_line);
        this.gko = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.gkp = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.gkq = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.gkr = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.gks = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.gkt = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        tP(0);
    }

    public void lf(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup btg() {
        return this.gko;
    }

    public void onChangeSkinType(int i) {
        this.gjR.getLayoutMode().setNightMode(i == 1);
        this.gjR.getLayoutMode().onModeChanged(this.mRootView);
        this.gjR.getLayoutMode().onModeChanged(this.gkv);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gkt.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gkk != null) {
            this.gkk.notifyDataSetChanged();
        }
    }

    public TextView bth() {
        return this.gkr;
    }

    public TextView bti() {
        return this.gks;
    }

    public void tP(int i) {
        this.gks.setText(this.gjR.getPageContext().getPageActivity().getString(d.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gee.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.gjR.getPageContext().getPageActivity(), d.e.ds150);
            this.gkn.setVisibility(0);
            this.gkp.setVisibility(0);
            this.gkq.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gkn.setVisibility(8);
        }
        this.gee.requestLayout();
    }

    public void lg(boolean z) {
        if (z) {
            this.gkp.setVisibility(8);
            this.gkq.setVisibility(0);
            return;
        }
        this.gkp.setVisibility(0);
        this.gkq.setVisibility(8);
    }

    public void bin() {
        this.gee.completePullRefreshPostDelayed(0L);
    }

    public NoDataView btj() {
        return this.gkm;
    }

    public l btk() {
        return this.gkk;
    }

    public void btl() {
        this.gkk.notifyDataSetChanged();
    }

    public TextView btm() {
        return this.gkl;
    }

    public void lh(boolean z) {
        this.gkl.setEnabled(z);
    }

    public BdListView bqz() {
        return this.gee;
    }
}
