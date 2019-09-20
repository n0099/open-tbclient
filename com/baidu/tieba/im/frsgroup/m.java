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
    private BdListView gEo;
    private ViewGroup gKA;
    private TextView gKB;
    private TextView gKC;
    private TextView gKD;
    private View gKE;
    private View gKF;
    private MembersActivity gKb;
    private l gKu;
    private TextView gKv;
    private NoDataView gKw;
    private ViewGroup gKx;
    private ViewGroup gKy;
    private RelativeLayout gKz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gKb = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gKb.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.gKb.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gKb.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gKb.finish();
            }
        });
        this.gKF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.gKv = (TextView) this.gKF.findViewById(R.id.right_textview);
        this.gKv.setText(this.gKb.getResources().getString(R.string.members_order));
        this.gKv.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gEo = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.gKw = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gKu = new l(this.gKb);
        this.gEo.setAdapter((ListAdapter) this.gKu);
        this.gEo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gKE != null) {
                        m.this.gKE.setVisibility(0);
                    }
                } else if (m.this.gKE != null) {
                    m.this.gKE.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gKx = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.gKE = membersActivity.findViewById(R.id.bottom_divider_line);
        this.gKy = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.gKz = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.gKA = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.gKB = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.gKC = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.gKD = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        vD(0);
    }

    public void mm(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bEF() {
        return this.gKy;
    }

    public void onChangeSkinType(int i) {
        this.gKb.getLayoutMode().setNightMode(i == 1);
        this.gKb.getLayoutMode().onModeChanged(this.mRootView);
        this.gKb.getLayoutMode().onModeChanged(this.gKF);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gKD.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gKu != null) {
            this.gKu.notifyDataSetChanged();
        }
    }

    public TextView bEG() {
        return this.gKB;
    }

    public TextView bEH() {
        return this.gKC;
    }

    public void vD(int i) {
        this.gKC.setText(this.gKb.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gEo.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.g(this.gKb.getPageContext().getPageActivity(), R.dimen.ds150);
            this.gKx.setVisibility(0);
            this.gKz.setVisibility(0);
            this.gKA.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gKx.setVisibility(8);
        }
        this.gEo.requestLayout();
    }

    public void mn(boolean z) {
        if (z) {
            this.gKz.setVisibility(8);
            this.gKA.setVisibility(0);
            return;
        }
        this.gKz.setVisibility(0);
        this.gKA.setVisibility(8);
    }

    public void bsJ() {
        this.gEo.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bEI() {
        return this.gKw;
    }

    public l bEJ() {
        return this.gKu;
    }

    public void bEK() {
        this.gKu.notifyDataSetChanged();
    }

    public TextView bEL() {
        return this.gKv;
    }

    public void mo(boolean z) {
        this.gKv.setEnabled(z);
    }

    public BdListView bBV() {
        return this.gEo;
    }
}
