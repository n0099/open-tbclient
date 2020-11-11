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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView jYZ;
    private l kgC;
    private TextView kgD;
    private NoDataView kgE;
    private ViewGroup kgF;
    private ViewGroup kgG;
    private RelativeLayout kgH;
    private ViewGroup kgI;
    private TextView kgJ;
    private TextView kgK;
    private TextView kgL;
    private View kgM;
    private View kgN;
    private MembersActivity kgj;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.kgj = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.kgj.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.kgj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kgj.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.kgj.finish();
            }
        });
        this.kgN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.kgD = (TextView) this.kgN.findViewById(R.id.right_textview);
        this.kgD.setText(this.kgj.getResources().getString(R.string.members_order));
        this.kgD.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.jYZ = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.kgE = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.kgC = new l(this.kgj);
        this.jYZ.setAdapter((ListAdapter) this.kgC);
        this.jYZ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.kgM != null) {
                        m.this.kgM.setVisibility(0);
                    }
                } else if (m.this.kgM != null) {
                    m.this.kgM.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.kgF = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.kgM = membersActivity.findViewById(R.id.bottom_divider_line);
        this.kgG = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.kgH = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.kgI = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.kgJ = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.kgK = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.kgL = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        CX(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cSp() {
        return this.kgG;
    }

    public void onChangeSkinType(int i) {
        this.kgj.getLayoutMode().setNightMode(i == 1);
        this.kgj.getLayoutMode().onModeChanged(this.mRootView);
        this.kgj.getLayoutMode().onModeChanged(this.kgN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kgL.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.kgC != null) {
            this.kgC.notifyDataSetChanged();
        }
    }

    public TextView cSq() {
        return this.kgJ;
    }

    public TextView cSr() {
        return this.kgK;
    }

    public void CX(int i) {
        this.kgK.setText(this.kgj.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jYZ.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.kgj.getPageContext().getPageActivity(), R.dimen.ds150);
            this.kgF.setVisibility(0);
            this.kgH.setVisibility(0);
            this.kgI.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.kgF.setVisibility(8);
        }
        this.jYZ.requestLayout();
    }

    public void rW(boolean z) {
        if (z) {
            this.kgH.setVisibility(8);
            this.kgI.setVisibility(0);
            return;
        }
        this.kgH.setVisibility(0);
        this.kgI.setVisibility(8);
    }

    public void cET() {
        this.jYZ.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cSs() {
        return this.kgE;
    }

    public l cSt() {
        return this.kgC;
    }

    public void cSu() {
        this.kgC.notifyDataSetChanged();
    }

    public TextView cSv() {
        return this.kgD;
    }

    public void rX(boolean z) {
        this.kgD.setEnabled(z);
    }

    public BdListView cPp() {
        return this.jYZ;
    }
}
