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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private ViewGroup gBA;
    private ViewGroup gBB;
    private RelativeLayout gBC;
    private ViewGroup gBD;
    private TextView gBE;
    private TextView gBF;
    private TextView gBG;
    private View gBH;
    private View gBI;
    private MembersActivity gBe;
    private l gBx;
    private TextView gBy;
    private NoDataView gBz;
    private BdListView gvr;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gBe = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gBe.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.gBe.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gBe.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gBe.finish();
            }
        });
        this.gBI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.gBy = (TextView) this.gBI.findViewById(R.id.right_textview);
        this.gBy.setText(this.gBe.getResources().getString(R.string.members_order));
        this.gBy.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gvr = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.gBz = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gBx = new l(this.gBe);
        this.gvr.setAdapter((ListAdapter) this.gBx);
        this.gvr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gBH != null) {
                        m.this.gBH.setVisibility(0);
                    }
                } else if (m.this.gBH != null) {
                    m.this.gBH.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gBA = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.gBH = membersActivity.findViewById(R.id.bottom_divider_line);
        this.gBB = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.gBC = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.gBD = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.gBE = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.gBF = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.gBG = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        uW(0);
    }

    public void lU(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bAS() {
        return this.gBB;
    }

    public void onChangeSkinType(int i) {
        this.gBe.getLayoutMode().setNightMode(i == 1);
        this.gBe.getLayoutMode().onModeChanged(this.mRootView);
        this.gBe.getLayoutMode().onModeChanged(this.gBI);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gBG.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gBx != null) {
            this.gBx.notifyDataSetChanged();
        }
    }

    public TextView bAT() {
        return this.gBE;
    }

    public TextView bAU() {
        return this.gBF;
    }

    public void uW(int i) {
        this.gBF.setText(this.gBe.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvr.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.g(this.gBe.getPageContext().getPageActivity(), R.dimen.ds150);
            this.gBA.setVisibility(0);
            this.gBC.setVisibility(0);
            this.gBD.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gBA.setVisibility(8);
        }
        this.gvr.requestLayout();
    }

    public void lV(boolean z) {
        if (z) {
            this.gBC.setVisibility(8);
            this.gBD.setVisibility(0);
            return;
        }
        this.gBC.setVisibility(0);
        this.gBD.setVisibility(8);
    }

    public void bpD() {
        this.gvr.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bAV() {
        return this.gBz;
    }

    public l bAW() {
        return this.gBx;
    }

    public void bAX() {
        this.gBx.notifyDataSetChanged();
    }

    public TextView bAY() {
        return this.gBy;
    }

    public void lW(boolean z) {
        this.gBy.setEnabled(z);
    }

    public BdListView byl() {
        return this.gvr;
    }
}
