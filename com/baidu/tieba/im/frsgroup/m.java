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
/* loaded from: classes3.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView efL;
    private l elO;
    private TextView elP;
    private NoDataView elQ;
    private ViewGroup elR;
    private ViewGroup elS;
    private RelativeLayout elT;
    private ViewGroup elU;
    private TextView elV;
    private TextView elW;
    private TextView elX;
    private View elY;
    private View elZ;
    private MembersActivity elv;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.elv = membersActivity;
        membersActivity.setContentView(d.i.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.elv.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.elv.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.elv.getPageContext().getString(d.k.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.elv.finish();
            }
        });
        this.elZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.group_member_navi_right_button, (View.OnClickListener) null);
        this.elP = (TextView) this.elZ.findViewById(d.g.right_textview);
        this.elP.setText(this.elv.getResources().getString(d.k.members_order));
        this.elP.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.efL = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.elQ = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.elO = new l(this.elv);
        this.efL.setAdapter((ListAdapter) this.elO);
        this.efL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.elY != null) {
                        m.this.elY.setVisibility(0);
                    }
                } else if (m.this.elY != null) {
                    m.this.elY.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.elR = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.elY = membersActivity.findViewById(d.g.bottom_divider_line);
        this.elS = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.elT = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.elU = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.elV = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.elW = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.elX = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        nL(0);
    }

    public void hn(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aIT() {
        return this.elS;
    }

    public void onChangeSkinType(int i) {
        this.elv.getLayoutMode().setNightMode(i == 1);
        this.elv.getLayoutMode().onModeChanged(this.mRootView);
        this.elv.getLayoutMode().onModeChanged(this.elZ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.elX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.elO != null) {
            this.elO.notifyDataSetChanged();
        }
    }

    public TextView aIU() {
        return this.elV;
    }

    public TextView aIV() {
        return this.elW;
    }

    public void nL(int i) {
        this.elW.setText(this.elv.getPageContext().getPageActivity().getString(d.k.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.efL.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(this.elv.getPageContext().getPageActivity(), d.e.ds150);
            this.elR.setVisibility(0);
            this.elT.setVisibility(0);
            this.elU.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.elR.setVisibility(8);
        }
        this.efL.requestLayout();
    }

    public void ho(boolean z) {
        if (z) {
            this.elT.setVisibility(8);
            this.elU.setVisibility(0);
            return;
        }
        this.elT.setVisibility(0);
        this.elU.setVisibility(8);
    }

    public void ayU() {
        this.efL.completePullRefreshPostDelayed(2000L);
    }

    public NoDataView aIW() {
        return this.elQ;
    }

    public l aIX() {
        return this.elO;
    }

    public void aIY() {
        this.elO.notifyDataSetChanged();
    }

    public TextView aIZ() {
        return this.elP;
    }

    public void hp(boolean z) {
        this.elP.setEnabled(z);
    }

    public BdListView aGm() {
        return this.efL;
    }
}
