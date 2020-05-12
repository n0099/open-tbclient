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
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView igL;
    private l imQ;
    private TextView imR;
    private NoDataView imS;
    private ViewGroup imT;
    private ViewGroup imU;
    private RelativeLayout imV;
    private ViewGroup imW;
    private TextView imX;
    private TextView imY;
    private TextView imZ;
    private MembersActivity imx;
    private View ina;
    private View inb;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.imx = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.imx.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.imx.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.imx.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.imx.finish();
            }
        });
        this.inb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.imR = (TextView) this.inb.findViewById(R.id.right_textview);
        this.imR.setText(this.imx.getResources().getString(R.string.members_order));
        this.imR.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.igL = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.imS = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.imQ = new l(this.imx);
        this.igL.setAdapter((ListAdapter) this.imQ);
        this.igL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.ina != null) {
                        m.this.ina.setVisibility(0);
                    }
                } else if (m.this.ina != null) {
                    m.this.ina.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.imT = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.ina = membersActivity.findViewById(R.id.bottom_divider_line);
        this.imU = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.imV = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.imW = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.imX = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.imY = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.imZ = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        xb(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cgg() {
        return this.imU;
    }

    public void onChangeSkinType(int i) {
        this.imx.getLayoutMode().setNightMode(i == 1);
        this.imx.getLayoutMode().onModeChanged(this.mRootView);
        this.imx.getLayoutMode().onModeChanged(this.inb);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.imZ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.imQ != null) {
            this.imQ.notifyDataSetChanged();
        }
    }

    public TextView cgh() {
        return this.imX;
    }

    public TextView cgi() {
        return this.imY;
    }

    public void xb(int i) {
        this.imY.setText(this.imx.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.igL.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.imx.getPageContext().getPageActivity(), R.dimen.ds150);
            this.imT.setVisibility(0);
            this.imV.setVisibility(0);
            this.imW.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.imT.setVisibility(8);
        }
        this.igL.requestLayout();
    }

    public void oM(boolean z) {
        if (z) {
            this.imV.setVisibility(8);
            this.imW.setVisibility(0);
            return;
        }
        this.imV.setVisibility(0);
        this.imW.setVisibility(8);
    }

    public void bUx() {
        this.igL.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cgj() {
        return this.imS;
    }

    public l cgk() {
        return this.imQ;
    }

    public void cgl() {
        this.imQ.notifyDataSetChanged();
    }

    public TextView cgm() {
        return this.imR;
    }

    public void oN(boolean z) {
        this.imR.setEnabled(z);
    }

    public BdListView cdz() {
        return this.igL;
    }
}
