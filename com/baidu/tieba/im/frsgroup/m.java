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
    private BdListView eOn;
    private MembersActivity eTW;
    private View eUA;
    private l eUp;
    private TextView eUq;
    private NoDataView eUr;
    private ViewGroup eUs;
    private ViewGroup eUt;
    private RelativeLayout eUu;
    private ViewGroup eUv;
    private TextView eUw;
    private TextView eUx;
    private TextView eUy;
    private View eUz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eTW = membersActivity;
        membersActivity.setContentView(e.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eTW.findViewById(e.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eTW.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eTW.getPageContext().getString(e.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eTW.finish();
            }
        });
        this.eUA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eUq = (TextView) this.eUA.findViewById(e.g.right_textview);
        this.eUq.setText(this.eTW.getResources().getString(e.j.members_order));
        this.eUq.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eOn = (BdListView) membersActivity.findViewById(e.g.members_list);
        this.eUr = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(e.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eUp = new l(this.eTW);
        this.eOn.setAdapter((ListAdapter) this.eUp);
        this.eOn.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eUz != null) {
                        m.this.eUz.setVisibility(0);
                    }
                } else if (m.this.eUz != null) {
                    m.this.eUz.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eUs = (ViewGroup) membersActivity.findViewById(e.g.bottom_manager);
        this.eUz = membersActivity.findViewById(e.g.bottom_divider_line);
        this.eUt = (ViewGroup) membersActivity.findViewById(e.g.bottom_edit);
        this.eUu = (RelativeLayout) membersActivity.findViewById(e.g.edit_lay);
        this.eUv = (ViewGroup) membersActivity.findViewById(e.g.bottom_send_edit);
        this.eUw = (TextView) membersActivity.findViewById(e.g.edit_cancel);
        this.eUx = (TextView) membersActivity.findViewById(e.g.edit_num);
        this.eUy = (TextView) membersActivity.findViewById(e.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(e.g.progress_loading);
        qj(0);
    }

    public void iF(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aSE() {
        return this.eUt;
    }

    public void onChangeSkinType(int i) {
        this.eTW.getLayoutMode().setNightMode(i == 1);
        this.eTW.getLayoutMode().onModeChanged(this.mRootView);
        this.eTW.getLayoutMode().onModeChanged(this.eUA);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eUy.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eUp != null) {
            this.eUp.notifyDataSetChanged();
        }
    }

    public TextView aSF() {
        return this.eUw;
    }

    public TextView aSG() {
        return this.eUx;
    }

    public void qj(int i) {
        this.eUx.setText(this.eTW.getPageContext().getPageActivity().getString(e.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eOn.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.eTW.getPageContext().getPageActivity(), e.C0210e.ds150);
            this.eUs.setVisibility(0);
            this.eUu.setVisibility(0);
            this.eUv.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eUs.setVisibility(8);
        }
        this.eOn.requestLayout();
    }

    public void iG(boolean z) {
        if (z) {
            this.eUu.setVisibility(8);
            this.eUv.setVisibility(0);
            return;
        }
        this.eUu.setVisibility(0);
        this.eUv.setVisibility(8);
    }

    public void aIa() {
        this.eOn.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public NoDataView aSH() {
        return this.eUr;
    }

    public l aSI() {
        return this.eUp;
    }

    public void aSJ() {
        this.eUp.notifyDataSetChanged();
    }

    public TextView aSK() {
        return this.eUq;
    }

    public void iH(boolean z) {
        this.eUq.setEnabled(z);
    }

    public BdListView aPX() {
        return this.eOn;
    }
}
