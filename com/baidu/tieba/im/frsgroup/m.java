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
/* loaded from: classes23.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView jGE;
    private MembersActivity jNN;
    private l jOg;
    private TextView jOh;
    private NoDataView jOi;
    private ViewGroup jOj;
    private ViewGroup jOk;
    private RelativeLayout jOl;
    private ViewGroup jOm;
    private TextView jOn;
    private TextView jOo;
    private TextView jOp;
    private View jOq;
    private View jOr;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.jNN = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.jNN.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.jNN.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jNN.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.jNN.finish();
            }
        });
        this.jOr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.jOh = (TextView) this.jOr.findViewById(R.id.right_textview);
        this.jOh.setText(this.jNN.getResources().getString(R.string.members_order));
        this.jOh.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.jGE = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.jOi = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.jOg = new l(this.jNN);
        this.jGE.setAdapter((ListAdapter) this.jOg);
        this.jGE.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.jOq != null) {
                        m.this.jOq.setVisibility(0);
                    }
                } else if (m.this.jOq != null) {
                    m.this.jOq.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.jOj = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.jOq = membersActivity.findViewById(R.id.bottom_divider_line);
        this.jOk = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.jOl = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.jOm = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.jOn = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.jOo = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.jOp = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        Cr(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cMH() {
        return this.jOk;
    }

    public void onChangeSkinType(int i) {
        this.jNN.getLayoutMode().setNightMode(i == 1);
        this.jNN.getLayoutMode().onModeChanged(this.mRootView);
        this.jNN.getLayoutMode().onModeChanged(this.jOr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jOp.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.jOg != null) {
            this.jOg.notifyDataSetChanged();
        }
    }

    public TextView cMI() {
        return this.jOn;
    }

    public TextView cMJ() {
        return this.jOo;
    }

    public void Cr(int i) {
        this.jOo.setText(this.jNN.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jGE.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.jNN.getPageContext().getPageActivity(), R.dimen.ds150);
            this.jOj.setVisibility(0);
            this.jOl.setVisibility(0);
            this.jOm.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.jOj.setVisibility(8);
        }
        this.jGE.requestLayout();
    }

    public void rv(boolean z) {
        if (z) {
            this.jOl.setVisibility(8);
            this.jOm.setVisibility(0);
            return;
        }
        this.jOl.setVisibility(0);
        this.jOm.setVisibility(8);
    }

    public void czl() {
        this.jGE.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cMK() {
        return this.jOi;
    }

    public l cML() {
        return this.jOg;
    }

    public void cMM() {
        this.jOg.notifyDataSetChanged();
    }

    public TextView cMN() {
        return this.jOh;
    }

    public void rw(boolean z) {
        this.jOh.setEnabled(z);
    }

    public BdListView cJH() {
        return this.jGE;
    }
}
