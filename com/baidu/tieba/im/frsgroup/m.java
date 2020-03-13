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
    private RelativeLayout hBA;
    private ViewGroup hBB;
    private TextView hBC;
    private TextView hBD;
    private TextView hBE;
    private View hBF;
    private View hBG;
    private MembersActivity hBc;
    private l hBv;
    private TextView hBw;
    private NoDataView hBx;
    private ViewGroup hBy;
    private ViewGroup hBz;
    private BdListView hvs;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.hBc = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.hBc.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.hBc.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hBc.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.hBc.finish();
            }
        });
        this.hBG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.hBw = (TextView) this.hBG.findViewById(R.id.right_textview);
        this.hBw.setText(this.hBc.getResources().getString(R.string.members_order));
        this.hBw.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.hvs = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.hBx = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.hBv = new l(this.hBc);
        this.hvs.setAdapter((ListAdapter) this.hBv);
        this.hvs.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.hBF != null) {
                        m.this.hBF.setVisibility(0);
                    }
                } else if (m.this.hBF != null) {
                    m.this.hBF.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.hBy = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.hBF = membersActivity.findViewById(R.id.bottom_divider_line);
        this.hBz = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.hBA = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.hBB = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.hBC = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.hBD = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.hBE = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        wv(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bVo() {
        return this.hBz;
    }

    public void onChangeSkinType(int i) {
        this.hBc.getLayoutMode().setNightMode(i == 1);
        this.hBc.getLayoutMode().onModeChanged(this.mRootView);
        this.hBc.getLayoutMode().onModeChanged(this.hBG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hBE.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.hBv != null) {
            this.hBv.notifyDataSetChanged();
        }
    }

    public TextView bVp() {
        return this.hBC;
    }

    public TextView bVq() {
        return this.hBD;
    }

    public void wv(int i) {
        this.hBD.setText(this.hBc.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvs.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.hBc.getPageContext().getPageActivity(), R.dimen.ds150);
            this.hBy.setVisibility(0);
            this.hBA.setVisibility(0);
            this.hBB.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.hBy.setVisibility(8);
        }
        this.hvs.requestLayout();
    }

    public void nC(boolean z) {
        if (z) {
            this.hBA.setVisibility(8);
            this.hBB.setVisibility(0);
            return;
        }
        this.hBA.setVisibility(0);
        this.hBB.setVisibility(8);
    }

    public void bJO() {
        this.hvs.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bVr() {
        return this.hBx;
    }

    public l bVs() {
        return this.hBv;
    }

    public void bVt() {
        this.hBv.notifyDataSetChanged();
    }

    public TextView bVu() {
        return this.hBw;
    }

    public void nD(boolean z) {
        this.hBw.setEnabled(z);
    }

    public BdListView bSI() {
        return this.hvs;
    }
}
