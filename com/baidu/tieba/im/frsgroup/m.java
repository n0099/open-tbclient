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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView ejE;
    private l epK;
    private TextView epL;
    private NoDataView epM;
    private ViewGroup epN;
    private ViewGroup epO;
    private RelativeLayout epP;
    private ViewGroup epQ;
    private TextView epR;
    private TextView epS;
    private TextView epT;
    private View epU;
    private View epV;
    private MembersActivity epr;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.epr = membersActivity;
        membersActivity.setContentView(d.i.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.epr.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.epr.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.epr.getPageContext().getString(d.k.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.epr.finish();
            }
        });
        this.epV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.group_member_navi_right_button, (View.OnClickListener) null);
        this.epL = (TextView) this.epV.findViewById(d.g.right_textview);
        this.epL.setText(this.epr.getResources().getString(d.k.members_order));
        this.epL.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.ejE = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.epM = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.epK = new l(this.epr);
        this.ejE.setAdapter((ListAdapter) this.epK);
        this.ejE.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.epU != null) {
                        m.this.epU.setVisibility(0);
                    }
                } else if (m.this.epU != null) {
                    m.this.epU.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.epN = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.epU = membersActivity.findViewById(d.g.bottom_divider_line);
        this.epO = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.epP = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.epQ = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.epR = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.epS = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.epT = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        nS(0);
    }

    public void hx(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aJA() {
        return this.epO;
    }

    public void onChangeSkinType(int i) {
        this.epr.getLayoutMode().setNightMode(i == 1);
        this.epr.getLayoutMode().onModeChanged(this.mRootView);
        this.epr.getLayoutMode().onModeChanged(this.epV);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.epT.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.epK != null) {
            this.epK.notifyDataSetChanged();
        }
    }

    public TextView aJB() {
        return this.epR;
    }

    public TextView aJC() {
        return this.epS;
    }

    public void nS(int i) {
        this.epS.setText(this.epr.getPageContext().getPageActivity().getString(d.k.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ejE.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(this.epr.getPageContext().getPageActivity(), d.e.ds150);
            this.epN.setVisibility(0);
            this.epP.setVisibility(0);
            this.epQ.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.epN.setVisibility(8);
        }
        this.ejE.requestLayout();
    }

    public void hy(boolean z) {
        if (z) {
            this.epP.setVisibility(8);
            this.epQ.setVisibility(0);
            return;
        }
        this.epP.setVisibility(0);
        this.epQ.setVisibility(8);
    }

    public void azA() {
        this.ejE.completePullRefreshPostDelayed(2000L);
    }

    public NoDataView aJD() {
        return this.epM;
    }

    public l aJE() {
        return this.epK;
    }

    public void aJF() {
        this.epK.notifyDataSetChanged();
    }

    public TextView aJG() {
        return this.epL;
    }

    public void hz(boolean z) {
        this.epL.setEnabled(z);
    }

    public BdListView aGT() {
        return this.ejE;
    }
}
