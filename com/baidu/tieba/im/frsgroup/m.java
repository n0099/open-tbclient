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
    private MembersActivity hAQ;
    private l hBj;
    private TextView hBk;
    private NoDataView hBl;
    private ViewGroup hBm;
    private ViewGroup hBn;
    private RelativeLayout hBo;
    private ViewGroup hBp;
    private TextView hBq;
    private TextView hBr;
    private TextView hBs;
    private View hBt;
    private View hBu;
    private BdListView hvg;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.hAQ = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.hAQ.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.hAQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hAQ.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.hAQ.finish();
            }
        });
        this.hBu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.hBk = (TextView) this.hBu.findViewById(R.id.right_textview);
        this.hBk.setText(this.hAQ.getResources().getString(R.string.members_order));
        this.hBk.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.hvg = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.hBl = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.hBj = new l(this.hAQ);
        this.hvg.setAdapter((ListAdapter) this.hBj);
        this.hvg.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.hBt != null) {
                        m.this.hBt.setVisibility(0);
                    }
                } else if (m.this.hBt != null) {
                    m.this.hBt.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.hBm = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.hBt = membersActivity.findViewById(R.id.bottom_divider_line);
        this.hBn = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.hBo = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.hBp = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.hBq = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.hBr = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.hBs = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        wv(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bVn() {
        return this.hBn;
    }

    public void onChangeSkinType(int i) {
        this.hAQ.getLayoutMode().setNightMode(i == 1);
        this.hAQ.getLayoutMode().onModeChanged(this.mRootView);
        this.hAQ.getLayoutMode().onModeChanged(this.hBu);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hBs.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.hBj != null) {
            this.hBj.notifyDataSetChanged();
        }
    }

    public TextView bVo() {
        return this.hBq;
    }

    public TextView bVp() {
        return this.hBr;
    }

    public void wv(int i) {
        this.hBr.setText(this.hAQ.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvg.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.hAQ.getPageContext().getPageActivity(), R.dimen.ds150);
            this.hBm.setVisibility(0);
            this.hBo.setVisibility(0);
            this.hBp.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.hBm.setVisibility(8);
        }
        this.hvg.requestLayout();
    }

    public void nC(boolean z) {
        if (z) {
            this.hBo.setVisibility(8);
            this.hBp.setVisibility(0);
            return;
        }
        this.hBo.setVisibility(0);
        this.hBp.setVisibility(8);
    }

    public void bJN() {
        this.hvg.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bVq() {
        return this.hBl;
    }

    public l bVr() {
        return this.hBj;
    }

    public void bVs() {
        this.hBj.notifyDataSetChanged();
    }

    public TextView bVt() {
        return this.hBk;
    }

    public void nD(boolean z) {
        this.hBk.setEnabled(z);
    }

    public BdListView bSH() {
        return this.hvg;
    }
}
