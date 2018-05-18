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
    private BdListView dUy;
    private l eaB;
    private TextView eaC;
    private NoDataView eaD;
    private ViewGroup eaE;
    private ViewGroup eaF;
    private RelativeLayout eaG;
    private ViewGroup eaH;
    private TextView eaI;
    private TextView eaJ;
    private TextView eaK;
    private View eaL;
    private View eaM;
    private MembersActivity eai;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eai = membersActivity;
        membersActivity.setContentView(d.i.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eai.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eai.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eai.getPageContext().getString(d.k.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                m.this.eai.finish();
            }
        });
        this.eaM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.group_member_navi_right_button, (View.OnClickListener) null);
        this.eaC = (TextView) this.eaM.findViewById(d.g.right_textview);
        this.eaC.setText(this.eai.getResources().getString(d.k.members_order));
        this.eaC.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.dUy = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.eaD = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eaB = new l(this.eai);
        this.dUy.setAdapter((ListAdapter) this.eaB);
        this.dUy.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eaL != null) {
                        m.this.eaL.setVisibility(0);
                    }
                } else if (m.this.eaL != null) {
                    m.this.eaL.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eaE = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.eaL = membersActivity.findViewById(d.g.bottom_divider_line);
        this.eaF = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.eaG = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.eaH = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.eaI = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.eaJ = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.eaK = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        nz(0);
    }

    public void hh(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aDY() {
        return this.eaF;
    }

    public void onChangeSkinType(int i) {
        this.eai.getLayoutMode().setNightMode(i == 1);
        this.eai.getLayoutMode().u(this.mRootView);
        this.eai.getLayoutMode().u(this.eaM);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eaK.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eaB != null) {
            this.eaB.notifyDataSetChanged();
        }
    }

    public TextView aDZ() {
        return this.eaI;
    }

    public TextView aEa() {
        return this.eaJ;
    }

    public void nz(int i) {
        this.eaJ.setText(this.eai.getPageContext().getPageActivity().getString(d.k.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dUy.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(this.eai.getPageContext().getPageActivity(), d.e.ds150);
            this.eaE.setVisibility(0);
            this.eaG.setVisibility(0);
            this.eaH.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eaE.setVisibility(8);
        }
        this.dUy.requestLayout();
    }

    public void hi(boolean z) {
        if (z) {
            this.eaG.setVisibility(8);
            this.eaH.setVisibility(0);
            return;
        }
        this.eaG.setVisibility(0);
        this.eaH.setVisibility(8);
    }

    public void auK() {
        this.dUy.completePullRefreshPostDelayed(2000L);
    }

    public NoDataView aEb() {
        return this.eaD;
    }

    public l aEc() {
        return this.eaB;
    }

    public void aEd() {
        this.eaB.notifyDataSetChanged();
    }

    public TextView aEe() {
        return this.eaC;
    }

    public void hj(boolean z) {
        this.eaC.setEnabled(z);
    }

    public BdListView aBr() {
        return this.dUy;
    }
}
