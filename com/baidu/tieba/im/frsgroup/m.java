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
    private BdListView eNA;
    private l eTB;
    private TextView eTC;
    private NoDataView eTD;
    private ViewGroup eTE;
    private ViewGroup eTF;
    private RelativeLayout eTG;
    private ViewGroup eTH;
    private TextView eTI;
    private TextView eTJ;
    private TextView eTK;
    private View eTL;
    private View eTM;
    private MembersActivity eTi;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eTi = membersActivity;
        membersActivity.setContentView(e.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eTi.findViewById(e.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eTi.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eTi.getPageContext().getString(e.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eTi.finish();
            }
        });
        this.eTM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eTC = (TextView) this.eTM.findViewById(e.g.right_textview);
        this.eTC.setText(this.eTi.getResources().getString(e.j.members_order));
        this.eTC.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eNA = (BdListView) membersActivity.findViewById(e.g.members_list);
        this.eTD = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(e.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eTB = new l(this.eTi);
        this.eNA.setAdapter((ListAdapter) this.eTB);
        this.eNA.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eTL != null) {
                        m.this.eTL.setVisibility(0);
                    }
                } else if (m.this.eTL != null) {
                    m.this.eTL.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eTE = (ViewGroup) membersActivity.findViewById(e.g.bottom_manager);
        this.eTL = membersActivity.findViewById(e.g.bottom_divider_line);
        this.eTF = (ViewGroup) membersActivity.findViewById(e.g.bottom_edit);
        this.eTG = (RelativeLayout) membersActivity.findViewById(e.g.edit_lay);
        this.eTH = (ViewGroup) membersActivity.findViewById(e.g.bottom_send_edit);
        this.eTI = (TextView) membersActivity.findViewById(e.g.edit_cancel);
        this.eTJ = (TextView) membersActivity.findViewById(e.g.edit_num);
        this.eTK = (TextView) membersActivity.findViewById(e.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(e.g.progress_loading);
        qi(0);
    }

    public void iF(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aSe() {
        return this.eTF;
    }

    public void onChangeSkinType(int i) {
        this.eTi.getLayoutMode().setNightMode(i == 1);
        this.eTi.getLayoutMode().onModeChanged(this.mRootView);
        this.eTi.getLayoutMode().onModeChanged(this.eTM);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eTK.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eTB != null) {
            this.eTB.notifyDataSetChanged();
        }
    }

    public TextView aSf() {
        return this.eTI;
    }

    public TextView aSg() {
        return this.eTJ;
    }

    public void qi(int i) {
        this.eTJ.setText(this.eTi.getPageContext().getPageActivity().getString(e.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eNA.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.eTi.getPageContext().getPageActivity(), e.C0210e.ds150);
            this.eTE.setVisibility(0);
            this.eTG.setVisibility(0);
            this.eTH.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eTE.setVisibility(8);
        }
        this.eNA.requestLayout();
    }

    public void iG(boolean z) {
        if (z) {
            this.eTG.setVisibility(8);
            this.eTH.setVisibility(0);
            return;
        }
        this.eTG.setVisibility(0);
        this.eTH.setVisibility(8);
    }

    public void aHD() {
        this.eNA.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public NoDataView aSh() {
        return this.eTD;
    }

    public l aSi() {
        return this.eTB;
    }

    public void aSj() {
        this.eTB.notifyDataSetChanged();
    }

    public TextView aSk() {
        return this.eTC;
    }

    public void iH(boolean z) {
        this.eTC.setEnabled(z);
    }

    public BdListView aPx() {
        return this.eNA;
    }
}
