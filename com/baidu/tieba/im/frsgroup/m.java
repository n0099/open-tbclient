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
    private BdListView gBF;
    private l gHK;
    private TextView gHL;
    private NoDataView gHM;
    private ViewGroup gHN;
    private ViewGroup gHO;
    private RelativeLayout gHP;
    private ViewGroup gHQ;
    private TextView gHR;
    private TextView gHS;
    private TextView gHT;
    private View gHU;
    private View gHV;
    private MembersActivity gHr;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gHr = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gHr.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.gHr.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gHr.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gHr.finish();
            }
        });
        this.gHV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.gHL = (TextView) this.gHV.findViewById(R.id.right_textview);
        this.gHL.setText(this.gHr.getResources().getString(R.string.members_order));
        this.gHL.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gBF = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.gHM = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gHK = new l(this.gHr);
        this.gBF.setAdapter((ListAdapter) this.gHK);
        this.gBF.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gHU != null) {
                        m.this.gHU.setVisibility(0);
                    }
                } else if (m.this.gHU != null) {
                    m.this.gHU.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gHN = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.gHU = membersActivity.findViewById(R.id.bottom_divider_line);
        this.gHO = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.gHP = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.gHQ = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.gHR = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.gHS = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.gHT = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        vx(0);
    }

    public void mj(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bDD() {
        return this.gHO;
    }

    public void onChangeSkinType(int i) {
        this.gHr.getLayoutMode().setNightMode(i == 1);
        this.gHr.getLayoutMode().onModeChanged(this.mRootView);
        this.gHr.getLayoutMode().onModeChanged(this.gHV);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gHT.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gHK != null) {
            this.gHK.notifyDataSetChanged();
        }
    }

    public TextView bDE() {
        return this.gHR;
    }

    public TextView bDF() {
        return this.gHS;
    }

    public void vx(int i) {
        this.gHS.setText(this.gHr.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBF.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.g(this.gHr.getPageContext().getPageActivity(), R.dimen.ds150);
            this.gHN.setVisibility(0);
            this.gHP.setVisibility(0);
            this.gHQ.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gHN.setVisibility(8);
        }
        this.gBF.requestLayout();
    }

    public void mk(boolean z) {
        if (z) {
            this.gHP.setVisibility(8);
            this.gHQ.setVisibility(0);
            return;
        }
        this.gHP.setVisibility(0);
        this.gHQ.setVisibility(8);
    }

    public void brJ() {
        this.gBF.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bDG() {
        return this.gHM;
    }

    public l bDH() {
        return this.gHK;
    }

    public void bDI() {
        this.gHK.notifyDataSetChanged();
    }

    public TextView bDJ() {
        return this.gHL;
    }

    public void ml(boolean z) {
        this.gHL.setEnabled(z);
    }

    public BdListView bAT() {
        return this.gBF;
    }
}
