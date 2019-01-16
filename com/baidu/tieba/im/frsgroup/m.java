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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView eOm;
    private MembersActivity eTV;
    private l eUo;
    private TextView eUp;
    private NoDataView eUq;
    private ViewGroup eUr;
    private ViewGroup eUs;
    private RelativeLayout eUt;
    private ViewGroup eUu;
    private TextView eUv;
    private TextView eUw;
    private TextView eUx;
    private View eUy;
    private View eUz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eTV = membersActivity;
        membersActivity.setContentView(e.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eTV.findViewById(e.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eTV.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eTV.getPageContext().getString(e.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eTV.finish();
            }
        });
        this.eUz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eUp = (TextView) this.eUz.findViewById(e.g.right_textview);
        this.eUp.setText(this.eTV.getResources().getString(e.j.members_order));
        this.eUp.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eOm = (BdListView) membersActivity.findViewById(e.g.members_list);
        this.eUq = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(e.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eUo = new l(this.eTV);
        this.eOm.setAdapter((ListAdapter) this.eUo);
        this.eOm.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eUy != null) {
                        m.this.eUy.setVisibility(0);
                    }
                } else if (m.this.eUy != null) {
                    m.this.eUy.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eUr = (ViewGroup) membersActivity.findViewById(e.g.bottom_manager);
        this.eUy = membersActivity.findViewById(e.g.bottom_divider_line);
        this.eUs = (ViewGroup) membersActivity.findViewById(e.g.bottom_edit);
        this.eUt = (RelativeLayout) membersActivity.findViewById(e.g.edit_lay);
        this.eUu = (ViewGroup) membersActivity.findViewById(e.g.bottom_send_edit);
        this.eUv = (TextView) membersActivity.findViewById(e.g.edit_cancel);
        this.eUw = (TextView) membersActivity.findViewById(e.g.edit_num);
        this.eUx = (TextView) membersActivity.findViewById(e.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(e.g.progress_loading);
        qj(0);
    }

    public void iF(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aSE() {
        return this.eUs;
    }

    public void onChangeSkinType(int i) {
        this.eTV.getLayoutMode().setNightMode(i == 1);
        this.eTV.getLayoutMode().onModeChanged(this.mRootView);
        this.eTV.getLayoutMode().onModeChanged(this.eUz);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eUx.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eUo != null) {
            this.eUo.notifyDataSetChanged();
        }
    }

    public TextView aSF() {
        return this.eUv;
    }

    public TextView aSG() {
        return this.eUw;
    }

    public void qj(int i) {
        this.eUw.setText(this.eTV.getPageContext().getPageActivity().getString(e.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eOm.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.eTV.getPageContext().getPageActivity(), e.C0210e.ds150);
            this.eUr.setVisibility(0);
            this.eUt.setVisibility(0);
            this.eUu.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eUr.setVisibility(8);
        }
        this.eOm.requestLayout();
    }

    public void iG(boolean z) {
        if (z) {
            this.eUt.setVisibility(8);
            this.eUu.setVisibility(0);
            return;
        }
        this.eUt.setVisibility(0);
        this.eUu.setVisibility(8);
    }

    public void aIa() {
        this.eOm.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public NoDataView aSH() {
        return this.eUq;
    }

    public l aSI() {
        return this.eUo;
    }

    public void aSJ() {
        this.eUo.notifyDataSetChanged();
    }

    public TextView aSK() {
        return this.eUp;
    }

    public void iH(boolean z) {
        this.eUp.setEnabled(z);
    }

    public BdListView aPX() {
        return this.eOm;
    }
}
