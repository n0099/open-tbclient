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
    private BdListView iTZ;
    private l jbB;
    private TextView jbC;
    private NoDataView jbD;
    private ViewGroup jbE;
    private ViewGroup jbF;
    private RelativeLayout jbG;
    private ViewGroup jbH;
    private TextView jbI;
    private TextView jbJ;
    private TextView jbK;
    private View jbL;
    private View jbM;
    private MembersActivity jbi;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.jbi = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.jbi.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.jbi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jbi.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.jbi.finish();
            }
        });
        this.jbM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.jbC = (TextView) this.jbM.findViewById(R.id.right_textview);
        this.jbC.setText(this.jbi.getResources().getString(R.string.members_order));
        this.jbC.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.iTZ = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.jbD = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.jbB = new l(this.jbi);
        this.iTZ.setAdapter((ListAdapter) this.jbB);
        this.iTZ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.jbL != null) {
                        m.this.jbL.setVisibility(0);
                    }
                } else if (m.this.jbL != null) {
                    m.this.jbL.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.jbE = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.jbL = membersActivity.findViewById(R.id.bottom_divider_line);
        this.jbF = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.jbG = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.jbH = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.jbI = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.jbJ = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.jbK = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        yR(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cuA() {
        return this.jbF;
    }

    public void onChangeSkinType(int i) {
        this.jbi.getLayoutMode().setNightMode(i == 1);
        this.jbi.getLayoutMode().onModeChanged(this.mRootView);
        this.jbi.getLayoutMode().onModeChanged(this.jbM);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jbK.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.jbB != null) {
            this.jbB.notifyDataSetChanged();
        }
    }

    public TextView cuB() {
        return this.jbI;
    }

    public TextView cuC() {
        return this.jbJ;
    }

    public void yR(int i) {
        this.jbJ.setText(this.jbi.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iTZ.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.jbi.getPageContext().getPageActivity(), R.dimen.ds150);
            this.jbE.setVisibility(0);
            this.jbG.setVisibility(0);
            this.jbH.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.jbE.setVisibility(8);
        }
        this.iTZ.requestLayout();
    }

    public void pZ(boolean z) {
        if (z) {
            this.jbG.setVisibility(8);
            this.jbH.setVisibility(0);
            return;
        }
        this.jbG.setVisibility(0);
        this.jbH.setVisibility(8);
    }

    public void chU() {
        this.iTZ.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cuD() {
        return this.jbD;
    }

    public l cuE() {
        return this.jbB;
    }

    public void cuF() {
        this.jbB.notifyDataSetChanged();
    }

    public TextView cuG() {
        return this.jbC;
    }

    public void qa(boolean z) {
        this.jbC.setEnabled(z);
    }

    public BdListView crz() {
        return this.iTZ;
    }
}
