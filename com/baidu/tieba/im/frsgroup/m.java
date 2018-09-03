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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView ens;
    private TextView etA;
    private NoDataView etB;
    private ViewGroup etC;
    private ViewGroup etD;
    private RelativeLayout etE;
    private ViewGroup etF;
    private TextView etG;
    private TextView etH;
    private TextView etI;
    private View etJ;
    private View etK;
    private MembersActivity etg;
    private l etz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.etg = membersActivity;
        membersActivity.setContentView(f.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.etg.findViewById(f.g.rootView);
        this.mNavigationBar = (NavigationBar) this.etg.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.etg.getPageContext().getString(f.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.etg.finish();
            }
        });
        this.etK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.etA = (TextView) this.etK.findViewById(f.g.right_textview);
        this.etA.setText(this.etg.getResources().getString(f.j.members_order));
        this.etA.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.ens = (BdListView) membersActivity.findViewById(f.g.members_list);
        this.etB = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(f.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.etz = new l(this.etg);
        this.ens.setAdapter((ListAdapter) this.etz);
        this.ens.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.etJ != null) {
                        m.this.etJ.setVisibility(0);
                    }
                } else if (m.this.etJ != null) {
                    m.this.etJ.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.etC = (ViewGroup) membersActivity.findViewById(f.g.bottom_manager);
        this.etJ = membersActivity.findViewById(f.g.bottom_divider_line);
        this.etD = (ViewGroup) membersActivity.findViewById(f.g.bottom_edit);
        this.etE = (RelativeLayout) membersActivity.findViewById(f.g.edit_lay);
        this.etF = (ViewGroup) membersActivity.findViewById(f.g.bottom_send_edit);
        this.etG = (TextView) membersActivity.findViewById(f.g.edit_cancel);
        this.etH = (TextView) membersActivity.findViewById(f.g.edit_num);
        this.etI = (TextView) membersActivity.findViewById(f.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(f.g.progress_loading);
        og(0);
    }

    public void hA(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aKy() {
        return this.etD;
    }

    public void onChangeSkinType(int i) {
        this.etg.getLayoutMode().setNightMode(i == 1);
        this.etg.getLayoutMode().onModeChanged(this.mRootView);
        this.etg.getLayoutMode().onModeChanged(this.etK);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.etI.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.etz != null) {
            this.etz.notifyDataSetChanged();
        }
    }

    public TextView aKz() {
        return this.etG;
    }

    public TextView aKA() {
        return this.etH;
    }

    public void og(int i) {
        this.etH.setText(this.etg.getPageContext().getPageActivity().getString(f.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ens.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(this.etg.getPageContext().getPageActivity(), f.e.ds150);
            this.etC.setVisibility(0);
            this.etE.setVisibility(0);
            this.etF.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.etC.setVisibility(8);
        }
        this.ens.requestLayout();
    }

    public void hB(boolean z) {
        if (z) {
            this.etE.setVisibility(8);
            this.etF.setVisibility(0);
            return;
        }
        this.etE.setVisibility(0);
        this.etF.setVisibility(8);
    }

    public void aAe() {
        this.ens.completePullRefreshPostDelayed(2000L);
    }

    public NoDataView aKB() {
        return this.etB;
    }

    public l aKC() {
        return this.etz;
    }

    public void aKD() {
        this.etz.notifyDataSetChanged();
    }

    public TextView aKE() {
        return this.etA;
    }

    public void hC(boolean z) {
        this.etA.setEnabled(z);
    }

    public BdListView aHQ() {
        return this.ens;
    }
}
