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
    private l eEC;
    private TextView eED;
    private com.baidu.tbadk.core.view.h eEE;
    private ViewGroup eEF;
    private ViewGroup eEG;
    private RelativeLayout eEH;
    private ViewGroup eEI;
    private TextView eEJ;
    private TextView eEK;
    private TextView eEL;
    private View eEM;
    private View eEN;
    private MembersActivity eEk;
    private BdListView eyB;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eEk = membersActivity;
        membersActivity.setContentView(d.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eEk.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eEk.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eEk.getPageContext().getString(d.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eEk.finish();
            }
        });
        this.eEN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eED = (TextView) this.eEN.findViewById(d.g.right_textview);
        this.eED.setText(this.eEk.getResources().getString(d.j.members_order));
        this.eED.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eyB = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.eEE = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eEC = new l(this.eEk);
        this.eyB.setAdapter((ListAdapter) this.eEC);
        this.eyB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eEM != null) {
                        m.this.eEM.setVisibility(0);
                    }
                } else if (m.this.eEM != null) {
                    m.this.eEM.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eEF = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.eEM = membersActivity.findViewById(d.g.bottom_divider_line);
        this.eEG = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.eEH = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.eEI = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.eEJ = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.eEK = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.eEL = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        qc(0);
    }

    public void hB(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aJc() {
        return this.eEG;
    }

    public void onChangeSkinType(int i) {
        this.eEk.getLayoutMode().aQ(i == 1);
        this.eEk.getLayoutMode().aM(this.mRootView);
        this.eEk.getLayoutMode().aM(this.eEN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eEL.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eEC != null) {
            this.eEC.notifyDataSetChanged();
        }
    }

    public TextView aJd() {
        return this.eEJ;
    }

    public TextView aJe() {
        return this.eEK;
    }

    public void qc(int i) {
        this.eEK.setText(this.eEk.getPageContext().getPageActivity().getString(d.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eyB.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.t(this.eEk.getPageContext().getPageActivity(), d.e.ds150);
            this.eEF.setVisibility(0);
            this.eEH.setVisibility(0);
            this.eEI.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eEF.setVisibility(8);
        }
        this.eyB.requestLayout();
    }

    public void hC(boolean z) {
        if (z) {
            this.eEH.setVisibility(8);
            this.eEI.setVisibility(0);
            return;
        }
        this.eEH.setVisibility(0);
        this.eEI.setVisibility(8);
    }

    public void azS() {
        this.eyB.completePullRefreshPostDelayed(2000L);
    }

    public com.baidu.tbadk.core.view.h aJf() {
        return this.eEE;
    }

    public l aJg() {
        return this.eEC;
    }

    public void aJh() {
        this.eEC.notifyDataSetChanged();
    }

    public TextView aJi() {
        return this.eED;
    }

    public void hD(boolean z) {
        this.eED.setEnabled(z);
    }

    public BdListView aGs() {
        return this.eyB;
    }
}
