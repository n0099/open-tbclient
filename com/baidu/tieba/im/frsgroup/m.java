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
    private l eEO;
    private TextView eEP;
    private com.baidu.tbadk.core.view.h eEQ;
    private ViewGroup eER;
    private ViewGroup eES;
    private RelativeLayout eET;
    private ViewGroup eEU;
    private TextView eEV;
    private TextView eEW;
    private TextView eEX;
    private View eEY;
    private View eEZ;
    private MembersActivity eEw;
    private BdListView eyN;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eEw = membersActivity;
        membersActivity.setContentView(d.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eEw.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eEw.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eEw.getPageContext().getString(d.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eEw.finish();
            }
        });
        this.eEZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eEP = (TextView) this.eEZ.findViewById(d.g.right_textview);
        this.eEP.setText(this.eEw.getResources().getString(d.j.members_order));
        this.eEP.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.eyN = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.eEQ = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eEO = new l(this.eEw);
        this.eyN.setAdapter((ListAdapter) this.eEO);
        this.eyN.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eEY != null) {
                        m.this.eEY.setVisibility(0);
                    }
                } else if (m.this.eEY != null) {
                    m.this.eEY.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eER = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.eEY = membersActivity.findViewById(d.g.bottom_divider_line);
        this.eES = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.eET = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.eEU = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.eEV = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.eEW = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.eEX = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        qc(0);
    }

    public void hB(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aJd() {
        return this.eES;
    }

    public void onChangeSkinType(int i) {
        this.eEw.getLayoutMode().aQ(i == 1);
        this.eEw.getLayoutMode().aM(this.mRootView);
        this.eEw.getLayoutMode().aM(this.eEZ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eEX.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eEO != null) {
            this.eEO.notifyDataSetChanged();
        }
    }

    public TextView aJe() {
        return this.eEV;
    }

    public TextView aJf() {
        return this.eEW;
    }

    public void qc(int i) {
        this.eEW.setText(this.eEw.getPageContext().getPageActivity().getString(d.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eyN.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.t(this.eEw.getPageContext().getPageActivity(), d.e.ds150);
            this.eER.setVisibility(0);
            this.eET.setVisibility(0);
            this.eEU.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eER.setVisibility(8);
        }
        this.eyN.requestLayout();
    }

    public void hC(boolean z) {
        if (z) {
            this.eET.setVisibility(8);
            this.eEU.setVisibility(0);
            return;
        }
        this.eET.setVisibility(0);
        this.eEU.setVisibility(8);
    }

    public void azT() {
        this.eyN.completePullRefreshPostDelayed(2000L);
    }

    public com.baidu.tbadk.core.view.h aJg() {
        return this.eEQ;
    }

    public l aJh() {
        return this.eEO;
    }

    public void aJi() {
        this.eEO.notifyDataSetChanged();
    }

    public TextView aJj() {
        return this.eEP;
    }

    public void hD(boolean z) {
        this.eEP.setEnabled(z);
    }

    public BdListView aGt() {
        return this.eyN;
    }
}
