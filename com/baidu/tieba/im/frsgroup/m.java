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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView iTX;
    private TextView jbA;
    private NoDataView jbB;
    private ViewGroup jbC;
    private ViewGroup jbD;
    private RelativeLayout jbE;
    private ViewGroup jbF;
    private TextView jbG;
    private TextView jbH;
    private TextView jbI;
    private View jbJ;
    private View jbK;
    private MembersActivity jbg;
    private l jbz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.jbg = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.jbg.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.jbg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jbg.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.jbg.finish();
            }
        });
        this.jbK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.jbA = (TextView) this.jbK.findViewById(R.id.right_textview);
        this.jbA.setText(this.jbg.getResources().getString(R.string.members_order));
        this.jbA.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.iTX = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.jbB = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.jbz = new l(this.jbg);
        this.iTX.setAdapter((ListAdapter) this.jbz);
        this.iTX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.jbJ != null) {
                        m.this.jbJ.setVisibility(0);
                    }
                } else if (m.this.jbJ != null) {
                    m.this.jbJ.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.jbC = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.jbJ = membersActivity.findViewById(R.id.bottom_divider_line);
        this.jbD = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.jbE = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.jbF = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.jbG = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.jbH = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.jbI = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        yR(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cuA() {
        return this.jbD;
    }

    public void onChangeSkinType(int i) {
        this.jbg.getLayoutMode().setNightMode(i == 1);
        this.jbg.getLayoutMode().onModeChanged(this.mRootView);
        this.jbg.getLayoutMode().onModeChanged(this.jbK);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jbI.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.jbz != null) {
            this.jbz.notifyDataSetChanged();
        }
    }

    public TextView cuB() {
        return this.jbG;
    }

    public TextView cuC() {
        return this.jbH;
    }

    public void yR(int i) {
        this.jbH.setText(this.jbg.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iTX.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.jbg.getPageContext().getPageActivity(), R.dimen.ds150);
            this.jbC.setVisibility(0);
            this.jbE.setVisibility(0);
            this.jbF.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.jbC.setVisibility(8);
        }
        this.iTX.requestLayout();
    }

    public void pZ(boolean z) {
        if (z) {
            this.jbE.setVisibility(8);
            this.jbF.setVisibility(0);
            return;
        }
        this.jbE.setVisibility(0);
        this.jbF.setVisibility(8);
    }

    public void chU() {
        this.iTX.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cuD() {
        return this.jbB;
    }

    public l cuE() {
        return this.jbz;
    }

    public void cuF() {
        this.jbz.notifyDataSetChanged();
    }

    public TextView cuG() {
        return this.jbA;
    }

    public void qa(boolean z) {
        this.jbA.setEnabled(z);
    }

    public BdListView crz() {
        return this.iTX;
    }
}
