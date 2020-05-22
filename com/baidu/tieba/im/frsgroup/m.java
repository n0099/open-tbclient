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
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private ViewGroup iBA;
    private ViewGroup iBB;
    private RelativeLayout iBC;
    private ViewGroup iBD;
    private TextView iBE;
    private TextView iBF;
    private TextView iBG;
    private View iBH;
    private View iBI;
    private MembersActivity iBe;
    private l iBx;
    private TextView iBy;
    private NoDataView iBz;
    private BdListView ivu;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.iBe = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.iBe.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.iBe.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iBe.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.iBe.finish();
            }
        });
        this.iBI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.iBy = (TextView) this.iBI.findViewById(R.id.right_textview);
        this.iBy.setText(this.iBe.getResources().getString(R.string.members_order));
        this.iBy.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.ivu = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.iBz = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.iBx = new l(this.iBe);
        this.ivu.setAdapter((ListAdapter) this.iBx);
        this.ivu.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.iBH != null) {
                        m.this.iBH.setVisibility(0);
                    }
                } else if (m.this.iBH != null) {
                    m.this.iBH.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.iBA = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.iBH = membersActivity.findViewById(R.id.bottom_divider_line);
        this.iBB = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.iBC = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.iBD = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.iBE = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.iBF = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.iBG = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        xH(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cmD() {
        return this.iBB;
    }

    public void onChangeSkinType(int i) {
        this.iBe.getLayoutMode().setNightMode(i == 1);
        this.iBe.getLayoutMode().onModeChanged(this.mRootView);
        this.iBe.getLayoutMode().onModeChanged(this.iBI);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iBG.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.iBx != null) {
            this.iBx.notifyDataSetChanged();
        }
    }

    public TextView cmE() {
        return this.iBE;
    }

    public TextView cmF() {
        return this.iBF;
    }

    public void xH(int i) {
        this.iBF.setText(this.iBe.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ivu.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.iBe.getPageContext().getPageActivity(), R.dimen.ds150);
            this.iBA.setVisibility(0);
            this.iBC.setVisibility(0);
            this.iBD.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.iBA.setVisibility(8);
        }
        this.ivu.requestLayout();
    }

    public void pi(boolean z) {
        if (z) {
            this.iBC.setVisibility(8);
            this.iBD.setVisibility(0);
            return;
        }
        this.iBC.setVisibility(0);
        this.iBD.setVisibility(8);
    }

    public void caU() {
        this.ivu.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cmG() {
        return this.iBz;
    }

    public l cmH() {
        return this.iBx;
    }

    public void cmI() {
        this.iBx.notifyDataSetChanged();
    }

    public TextView cmJ() {
        return this.iBy;
    }

    public void pj(boolean z) {
        this.iBy.setEnabled(z);
    }

    public BdListView cjX() {
        return this.ivu;
    }
}
