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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private l eAS;
    private TextView eAT;
    private NoDataView eAU;
    private ViewGroup eAV;
    private ViewGroup eAW;
    private RelativeLayout eAX;
    private ViewGroup eAY;
    private TextView eAZ;
    private MembersActivity eAz;
    private TextView eBa;
    private TextView eBb;
    private View eBc;
    private View eBd;
    private BdListView euM;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.eAz = membersActivity;
        membersActivity.setContentView(e.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.eAz.findViewById(e.g.rootView);
        this.mNavigationBar = (NavigationBar) this.eAz.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eAz.getPageContext().getString(e.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.eAz.finish();
            }
        });
        this.eBd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.eAT = (TextView) this.eBd.findViewById(e.g.right_textview);
        this.eAT.setText(this.eAz.getResources().getString(e.j.members_order));
        this.eAT.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.euM = (BdListView) membersActivity.findViewById(e.g.members_list);
        this.eAU = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(e.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.eAS = new l(this.eAz);
        this.euM.setAdapter((ListAdapter) this.eAS);
        this.euM.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.eBc != null) {
                        m.this.eBc.setVisibility(0);
                    }
                } else if (m.this.eBc != null) {
                    m.this.eBc.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.eAV = (ViewGroup) membersActivity.findViewById(e.g.bottom_manager);
        this.eBc = membersActivity.findViewById(e.g.bottom_divider_line);
        this.eAW = (ViewGroup) membersActivity.findViewById(e.g.bottom_edit);
        this.eAX = (RelativeLayout) membersActivity.findViewById(e.g.edit_lay);
        this.eAY = (ViewGroup) membersActivity.findViewById(e.g.bottom_send_edit);
        this.eAZ = (TextView) membersActivity.findViewById(e.g.edit_cancel);
        this.eBa = (TextView) membersActivity.findViewById(e.g.edit_num);
        this.eBb = (TextView) membersActivity.findViewById(e.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(e.g.progress_loading);
        oK(0);
    }

    public void hY(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aMN() {
        return this.eAW;
    }

    public void onChangeSkinType(int i) {
        this.eAz.getLayoutMode().setNightMode(i == 1);
        this.eAz.getLayoutMode().onModeChanged(this.mRootView);
        this.eAz.getLayoutMode().onModeChanged(this.eBd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eBb.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.eAS != null) {
            this.eAS.notifyDataSetChanged();
        }
    }

    public TextView aMO() {
        return this.eAZ;
    }

    public TextView aMP() {
        return this.eBa;
    }

    public void oK(int i) {
        this.eBa.setText(this.eAz.getPageContext().getPageActivity().getString(e.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.euM.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.eAz.getPageContext().getPageActivity(), e.C0141e.ds150);
            this.eAV.setVisibility(0);
            this.eAX.setVisibility(0);
            this.eAY.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.eAV.setVisibility(8);
        }
        this.euM.requestLayout();
    }

    public void hZ(boolean z) {
        if (z) {
            this.eAX.setVisibility(8);
            this.eAY.setVisibility(0);
            return;
        }
        this.eAX.setVisibility(0);
        this.eAY.setVisibility(8);
    }

    public void aCn() {
        this.euM.completePullRefreshPostDelayed(2000L);
    }

    public NoDataView aMQ() {
        return this.eAU;
    }

    public l aMR() {
        return this.eAS;
    }

    public void aMS() {
        this.eAS.notifyDataSetChanged();
    }

    public TextView aMT() {
        return this.eAT;
    }

    public void ia(boolean z) {
        this.eAT.setEnabled(z);
    }

    public BdListView aKf() {
        return this.euM;
    }
}
