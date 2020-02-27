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
    private MembersActivity hAO;
    private l hBh;
    private TextView hBi;
    private NoDataView hBj;
    private ViewGroup hBk;
    private ViewGroup hBl;
    private RelativeLayout hBm;
    private ViewGroup hBn;
    private TextView hBo;
    private TextView hBp;
    private TextView hBq;
    private View hBr;
    private View hBs;
    private BdListView hve;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.hAO = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.hAO.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.hAO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hAO.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.hAO.finish();
            }
        });
        this.hBs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.hBi = (TextView) this.hBs.findViewById(R.id.right_textview);
        this.hBi.setText(this.hAO.getResources().getString(R.string.members_order));
        this.hBi.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.hve = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.hBj = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.hBh = new l(this.hAO);
        this.hve.setAdapter((ListAdapter) this.hBh);
        this.hve.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.hBr != null) {
                        m.this.hBr.setVisibility(0);
                    }
                } else if (m.this.hBr != null) {
                    m.this.hBr.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.hBk = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.hBr = membersActivity.findViewById(R.id.bottom_divider_line);
        this.hBl = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.hBm = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.hBn = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.hBo = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.hBp = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.hBq = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        wv(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bVl() {
        return this.hBl;
    }

    public void onChangeSkinType(int i) {
        this.hAO.getLayoutMode().setNightMode(i == 1);
        this.hAO.getLayoutMode().onModeChanged(this.mRootView);
        this.hAO.getLayoutMode().onModeChanged(this.hBs);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hBq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.hBh != null) {
            this.hBh.notifyDataSetChanged();
        }
    }

    public TextView bVm() {
        return this.hBo;
    }

    public TextView bVn() {
        return this.hBp;
    }

    public void wv(int i) {
        this.hBp.setText(this.hAO.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hve.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.hAO.getPageContext().getPageActivity(), R.dimen.ds150);
            this.hBk.setVisibility(0);
            this.hBm.setVisibility(0);
            this.hBn.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.hBk.setVisibility(8);
        }
        this.hve.requestLayout();
    }

    public void nC(boolean z) {
        if (z) {
            this.hBm.setVisibility(8);
            this.hBn.setVisibility(0);
            return;
        }
        this.hBm.setVisibility(0);
        this.hBn.setVisibility(8);
    }

    public void bJL() {
        this.hve.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bVo() {
        return this.hBj;
    }

    public l bVp() {
        return this.hBh;
    }

    public void bVq() {
        this.hBh.notifyDataSetChanged();
    }

    public TextView bVr() {
        return this.hBi;
    }

    public void nD(boolean z) {
        this.hBi.setEnabled(z);
    }

    public BdListView bSF() {
        return this.hve;
    }
}
