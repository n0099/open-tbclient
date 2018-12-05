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
    private BdListView eKJ;
    private l eQK;
    private TextView eQL;
    private NoDataView eQM;
    private ViewGroup eQN;
    private ViewGroup eQO;
    private RelativeLayout eQP;
    private ViewGroup eQQ;
    private TextView eQR;
    private TextView eQS;
    private TextView eQT;
    private View eQU;
    private View eQV;
    private MembersActivity eQr;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eQr = membersActivity;
        membersActivity.setContentView(e.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eQr.findViewById(e.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eQr.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eQr.getPageContext().getString(e.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eQr.finish();
            }
        });
        this.eQV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eQL = (TextView) this.eQV.findViewById(e.g.right_textview);
        this.eQL.setText(this.eQr.getResources().getString(e.j.members_order));
        this.eQL.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eKJ = (BdListView) membersActivity.findViewById(e.g.members_list);
        this.eQM = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(e.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eQK = new l(this.eQr);
        this.eKJ.setAdapter((ListAdapter) this.eQK);
        this.eKJ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eQU != null) {
                        m.this.eQU.setVisibility(0);
                    }
                } else if (m.this.eQU != null) {
                    m.this.eQU.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eQN = (ViewGroup) membersActivity.findViewById(e.g.bottom_manager);
        this.eQU = membersActivity.findViewById(e.g.bottom_divider_line);
        this.eQO = (ViewGroup) membersActivity.findViewById(e.g.bottom_edit);
        this.eQP = (RelativeLayout) membersActivity.findViewById(e.g.edit_lay);
        this.eQQ = (ViewGroup) membersActivity.findViewById(e.g.bottom_send_edit);
        this.eQR = (TextView) membersActivity.findViewById(e.g.edit_cancel);
        this.eQS = (TextView) membersActivity.findViewById(e.g.edit_num);
        this.eQT = (TextView) membersActivity.findViewById(e.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(e.g.progress_loading);
        pV(0);
    }

    public void iC(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aRr() {
        return this.eQO;
    }

    public void onChangeSkinType(int i) {
        this.eQr.getLayoutMode().setNightMode(i == 1);
        this.eQr.getLayoutMode().onModeChanged(this.mRootView);
        this.eQr.getLayoutMode().onModeChanged(this.eQV);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eQT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eQK != null) {
            this.eQK.notifyDataSetChanged();
        }
    }

    public TextView aRs() {
        return this.eQR;
    }

    public TextView aRt() {
        return this.eQS;
    }

    public void pV(int i) {
        this.eQS.setText(this.eQr.getPageContext().getPageActivity().getString(e.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eKJ.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.eQr.getPageContext().getPageActivity(), e.C0210e.ds150);
            this.eQN.setVisibility(0);
            this.eQP.setVisibility(0);
            this.eQQ.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eQN.setVisibility(8);
        }
        this.eKJ.requestLayout();
    }

    public void iD(boolean z) {
        if (z) {
            this.eQP.setVisibility(8);
            this.eQQ.setVisibility(0);
            return;
        }
        this.eQP.setVisibility(0);
        this.eQQ.setVisibility(8);
    }

    public void aGO() {
        this.eKJ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public NoDataView aRu() {
        return this.eQM;
    }

    public l aRv() {
        return this.eQK;
    }

    public void aRw() {
        this.eQK.notifyDataSetChanged();
    }

    public TextView aRx() {
        return this.eQL;
    }

    public void iE(boolean z) {
        this.eQL.setEnabled(z);
    }

    public BdListView aOK() {
        return this.eKJ;
    }
}
