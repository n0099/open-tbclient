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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView enw;
    private l etD;
    private TextView etE;
    private NoDataView etF;
    private ViewGroup etG;
    private ViewGroup etH;
    private RelativeLayout etI;
    private ViewGroup etJ;
    private TextView etK;
    private TextView etL;
    private TextView etM;
    private View etN;
    private View etO;
    private MembersActivity etk;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.etk = membersActivity;
        membersActivity.setContentView(d.h.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.etk.findViewById(d.g.rootView);
        this.mNavigationBar = (NavigationBar) this.etk.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.etk.getPageContext().getString(d.j.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.etk.finish();
            }
        });
        this.etO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_member_navi_right_button, (View.OnClickListener) null);
        this.etE = (TextView) this.etO.findViewById(d.g.right_textview);
        this.etE.setText(this.etk.getResources().getString(d.j.members_order));
        this.etE.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.enw = (BdListView) membersActivity.findViewById(d.g.members_list);
        this.etF = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(d.g.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.etD = new l(this.etk);
        this.enw.setAdapter((ListAdapter) this.etD);
        this.enw.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.etN != null) {
                        m.this.etN.setVisibility(0);
                    }
                } else if (m.this.etN != null) {
                    m.this.etN.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.etG = (ViewGroup) membersActivity.findViewById(d.g.bottom_manager);
        this.etN = membersActivity.findViewById(d.g.bottom_divider_line);
        this.etH = (ViewGroup) membersActivity.findViewById(d.g.bottom_edit);
        this.etI = (RelativeLayout) membersActivity.findViewById(d.g.edit_lay);
        this.etJ = (ViewGroup) membersActivity.findViewById(d.g.bottom_send_edit);
        this.etK = (TextView) membersActivity.findViewById(d.g.edit_cancel);
        this.etL = (TextView) membersActivity.findViewById(d.g.edit_num);
        this.etM = (TextView) membersActivity.findViewById(d.g.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(d.g.progress_loading);
        og(0);
    }

    public void hA(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup aKB() {
        return this.etH;
    }

    public void onChangeSkinType(int i) {
        this.etk.getLayoutMode().setNightMode(i == 1);
        this.etk.getLayoutMode().onModeChanged(this.mRootView);
        this.etk.getLayoutMode().onModeChanged(this.etO);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.etM.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.etD != null) {
            this.etD.notifyDataSetChanged();
        }
    }

    public TextView aKC() {
        return this.etK;
    }

    public TextView aKD() {
        return this.etL;
    }

    public void og(int i) {
        this.etL.setText(this.etk.getPageContext().getPageActivity().getString(d.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.enw.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(this.etk.getPageContext().getPageActivity(), d.e.ds150);
            this.etG.setVisibility(0);
            this.etI.setVisibility(0);
            this.etJ.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.etG.setVisibility(8);
        }
        this.enw.requestLayout();
    }

    public void hB(boolean z) {
        if (z) {
            this.etI.setVisibility(8);
            this.etJ.setVisibility(0);
            return;
        }
        this.etI.setVisibility(0);
        this.etJ.setVisibility(8);
    }

    public void aAh() {
        this.enw.completePullRefreshPostDelayed(2000L);
    }

    public NoDataView aKE() {
        return this.etF;
    }

    public l aKF() {
        return this.etD;
    }

    public void aKG() {
        this.etD.notifyDataSetChanged();
    }

    public TextView aKH() {
        return this.etE;
    }

    public void hC(boolean z) {
        this.etE.setEnabled(z);
    }

    public BdListView aHT() {
        return this.enw;
    }
}
