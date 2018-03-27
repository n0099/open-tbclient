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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private MembersActivity eEA;
    private l eES;
    private TextView eET;
    private com.baidu.tbadk.core.view.h eEU;
    private ViewGroup eEV;
    private ViewGroup eEW;
    private RelativeLayout eEX;
    private ViewGroup eEY;
    private TextView eEZ;
    private TextView eFa;
    private TextView eFb;
    private View eFc;
    private View eFd;
    private BdListView eyR;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eEA = membersActivity;
        membersActivity.setContentView(d.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eEA.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eEA.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eEA.getPageContext().getString(d.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eEA.finish();
            }
        });
        this.eFd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eET = (TextView) this.eFd.findViewById(d.g.right_textview);
        this.eET.setText(this.eEA.getResources().getString(d.j.members_order));
        this.eET.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eyR = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.eEU = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eES = new l(this.eEA);
        this.eyR.setAdapter((ListAdapter) this.eES);
        this.eyR.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eFc != null) {
                        m.this.eFc.setVisibility(0);
                    }
                } else if (m.this.eFc != null) {
                    m.this.eFc.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eEV = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.eFc = membersActivity.findViewById(d.g.bottom_divider_line);
        this.eEW = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.eEX = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.eEY = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.eEZ = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.eFa = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.eFb = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        qd(0);
    }

    public void hG(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aJd() {
        return this.eEW;
    }

    public void onChangeSkinType(int i) {
        this.eEA.getLayoutMode().aQ(i == 1);
        this.eEA.getLayoutMode().aM(this.mRootView);
        this.eEA.getLayoutMode().aM(this.eFd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eFb.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eES != null) {
            this.eES.notifyDataSetChanged();
        }
    }

    public TextView aJe() {
        return this.eEZ;
    }

    public TextView aJf() {
        return this.eFa;
    }

    public void qd(int i) {
        this.eFa.setText(this.eEA.getPageContext().getPageActivity().getString(d.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eyR.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.t(this.eEA.getPageContext().getPageActivity(), d.e.ds150);
            this.eEV.setVisibility(0);
            this.eEX.setVisibility(0);
            this.eEY.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eEV.setVisibility(8);
        }
        this.eyR.requestLayout();
    }

    public void hH(boolean z) {
        if (z) {
            this.eEX.setVisibility(8);
            this.eEY.setVisibility(0);
            return;
        }
        this.eEX.setVisibility(0);
        this.eEY.setVisibility(8);
    }

    public void azU() {
        this.eyR.completePullRefreshPostDelayed(2000L);
    }

    public com.baidu.tbadk.core.view.h aJg() {
        return this.eEU;
    }

    public l aJh() {
        return this.eES;
    }

    public void aJi() {
        this.eES.notifyDataSetChanged();
    }

    public TextView aJj() {
        return this.eET;
    }

    public void hI(boolean z) {
        this.eET.setEnabled(z);
    }

    public BdListView aGt() {
        return this.eyR;
    }
}
