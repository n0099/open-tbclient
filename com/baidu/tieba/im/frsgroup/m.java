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
    private BdListView ger;
    private ViewGroup gkA;
    private RelativeLayout gkB;
    private ViewGroup gkC;
    private TextView gkD;
    private TextView gkE;
    private TextView gkF;
    private View gkG;
    private View gkH;
    private MembersActivity gkd;
    private l gkw;
    private TextView gkx;
    private NoDataView gky;
    private ViewGroup gkz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gkd = membersActivity;
        membersActivity.setContentView(d.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gkd.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.gkd.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gkd.getPageContext().getString(d.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gkd.finish();
            }
        });
        this.gkH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.gkx = (TextView) this.gkH.findViewById(d.g.right_textview);
        this.gkx.setText(this.gkd.getResources().getString(d.j.members_order));
        this.gkx.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.ger = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.gky = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gkw = new l(this.gkd);
        this.ger.setAdapter((ListAdapter) this.gkw);
        this.ger.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gkG != null) {
                        m.this.gkG.setVisibility(0);
                    }
                } else if (m.this.gkG != null) {
                    m.this.gkG.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gkz = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.gkG = membersActivity.findViewById(d.g.bottom_divider_line);
        this.gkA = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.gkB = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.gkC = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.gkD = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.gkE = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.gkF = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        tT(0);
    }

    public void lf(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup btj() {
        return this.gkA;
    }

    public void onChangeSkinType(int i) {
        this.gkd.getLayoutMode().setNightMode(i == 1);
        this.gkd.getLayoutMode().onModeChanged(this.mRootView);
        this.gkd.getLayoutMode().onModeChanged(this.gkH);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gkF.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gkw != null) {
            this.gkw.notifyDataSetChanged();
        }
    }

    public TextView btk() {
        return this.gkD;
    }

    public TextView btl() {
        return this.gkE;
    }

    public void tT(int i) {
        this.gkE.setText(this.gkd.getPageContext().getPageActivity().getString(d.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ger.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.gkd.getPageContext().getPageActivity(), d.e.ds150);
            this.gkz.setVisibility(0);
            this.gkB.setVisibility(0);
            this.gkC.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gkz.setVisibility(8);
        }
        this.ger.requestLayout();
    }

    public void lg(boolean z) {
        if (z) {
            this.gkB.setVisibility(8);
            this.gkC.setVisibility(0);
            return;
        }
        this.gkB.setVisibility(0);
        this.gkC.setVisibility(8);
    }

    public void bip() {
        this.ger.completePullRefreshPostDelayed(0L);
    }

    public NoDataView btm() {
        return this.gky;
    }

    public l btn() {
        return this.gkw;
    }

    public void bto() {
        this.gkw.notifyDataSetChanged();
    }

    public TextView btp() {
        return this.gkx;
    }

    public void lh(boolean z) {
        this.gkx.setEnabled(z);
    }

    public BdListView bqC() {
        return this.ger;
    }
}
