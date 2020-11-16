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
/* loaded from: classes22.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView jZJ;
    private MembersActivity kgT;
    private l khm;
    private TextView khn;
    private NoDataView kho;
    private ViewGroup khp;
    private ViewGroup khq;
    private RelativeLayout khr;
    private ViewGroup khs;
    private TextView kht;
    private TextView khu;
    private TextView khv;
    private View khw;
    private View khx;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.kgT = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.kgT.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.kgT.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kgT.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.kgT.finish();
            }
        });
        this.khx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.khn = (TextView) this.khx.findViewById(R.id.right_textview);
        this.khn.setText(this.kgT.getResources().getString(R.string.members_order));
        this.khn.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.jZJ = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.kho = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.khm = new l(this.kgT);
        this.jZJ.setAdapter((ListAdapter) this.khm);
        this.jZJ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.khw != null) {
                        m.this.khw.setVisibility(0);
                    }
                } else if (m.this.khw != null) {
                    m.this.khw.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.khp = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.khw = membersActivity.findViewById(R.id.bottom_divider_line);
        this.khq = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.khr = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.khs = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.kht = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.khu = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.khv = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        Dv(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cRV() {
        return this.khq;
    }

    public void onChangeSkinType(int i) {
        this.kgT.getLayoutMode().setNightMode(i == 1);
        this.kgT.getLayoutMode().onModeChanged(this.mRootView);
        this.kgT.getLayoutMode().onModeChanged(this.khx);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.khv.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.khm != null) {
            this.khm.notifyDataSetChanged();
        }
    }

    public TextView cRW() {
        return this.kht;
    }

    public TextView cRX() {
        return this.khu;
    }

    public void Dv(int i) {
        this.khu.setText(this.kgT.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jZJ.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.kgT.getPageContext().getPageActivity(), R.dimen.ds150);
            this.khp.setVisibility(0);
            this.khr.setVisibility(0);
            this.khs.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.khp.setVisibility(8);
        }
        this.jZJ.requestLayout();
    }

    public void rZ(boolean z) {
        if (z) {
            this.khr.setVisibility(8);
            this.khs.setVisibility(0);
            return;
        }
        this.khr.setVisibility(0);
        this.khs.setVisibility(8);
    }

    public void cEy() {
        this.jZJ.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cRY() {
        return this.kho;
    }

    public l cRZ() {
        return this.khm;
    }

    public void cSa() {
        this.khm.notifyDataSetChanged();
    }

    public TextView cSb() {
        return this.khn;
    }

    public void sa(boolean z) {
        this.khn.setEnabled(z);
    }

    public BdListView cOV() {
        return this.jZJ;
    }
}
