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
/* loaded from: classes5.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView gCx;
    private l gIC;
    private TextView gID;
    private NoDataView gIE;
    private ViewGroup gIF;
    private ViewGroup gIG;
    private RelativeLayout gIH;
    private ViewGroup gII;
    private TextView gIJ;
    private TextView gIK;
    private TextView gIL;
    private View gIM;
    private View gIN;
    private MembersActivity gIj;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gIj = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gIj.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.gIj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gIj.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gIj.finish();
            }
        });
        this.gIN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.gID = (TextView) this.gIN.findViewById(R.id.right_textview);
        this.gID.setText(this.gIj.getResources().getString(R.string.members_order));
        this.gID.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gCx = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.gIE = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gIC = new l(this.gIj);
        this.gCx.setAdapter((ListAdapter) this.gIC);
        this.gCx.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gIM != null) {
                        m.this.gIM.setVisibility(0);
                    }
                } else if (m.this.gIM != null) {
                    m.this.gIM.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gIF = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.gIM = membersActivity.findViewById(R.id.bottom_divider_line);
        this.gIG = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.gIH = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.gII = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.gIJ = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.gIK = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.gIL = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        vz(0);
    }

    public void mj(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bDR() {
        return this.gIG;
    }

    public void onChangeSkinType(int i) {
        this.gIj.getLayoutMode().setNightMode(i == 1);
        this.gIj.getLayoutMode().onModeChanged(this.mRootView);
        this.gIj.getLayoutMode().onModeChanged(this.gIN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gIL.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gIC != null) {
            this.gIC.notifyDataSetChanged();
        }
    }

    public TextView bDS() {
        return this.gIJ;
    }

    public TextView bDT() {
        return this.gIK;
    }

    public void vz(int i) {
        this.gIK.setText(this.gIj.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gCx.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.g(this.gIj.getPageContext().getPageActivity(), R.dimen.ds150);
            this.gIF.setVisibility(0);
            this.gIH.setVisibility(0);
            this.gII.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gIF.setVisibility(8);
        }
        this.gCx.requestLayout();
    }

    public void mk(boolean z) {
        if (z) {
            this.gIH.setVisibility(8);
            this.gII.setVisibility(0);
            return;
        }
        this.gIH.setVisibility(0);
        this.gII.setVisibility(8);
    }

    public void brW() {
        this.gCx.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bDU() {
        return this.gIE;
    }

    public l bDV() {
        return this.gIC;
    }

    public void bDW() {
        this.gIC.notifyDataSetChanged();
    }

    public TextView bDX() {
        return this.gID;
    }

    public void ml(boolean z) {
        this.gID.setEnabled(z);
    }

    public BdListView bBh() {
        return this.gCx;
    }
}
