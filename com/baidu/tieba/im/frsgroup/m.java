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
    private BdListView knq;
    private l kuL;
    private TextView kuM;
    private NoDataView kuN;
    private ViewGroup kuO;
    private ViewGroup kuP;
    private RelativeLayout kuQ;
    private ViewGroup kuR;
    private TextView kuS;
    private TextView kuT;
    private TextView kuU;
    private View kuV;
    private View kuW;
    private MembersActivity kut;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.kut = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.kut.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.kut.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kut.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.kut.finish();
            }
        });
        this.kuW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.kuM = (TextView) this.kuW.findViewById(R.id.right_textview);
        this.kuM.setText(this.kut.getResources().getString(R.string.members_order));
        this.kuM.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.knq = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.kuN = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.kuL = new l(this.kut);
        this.knq.setAdapter((ListAdapter) this.kuL);
        this.knq.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.kuV != null) {
                        m.this.kuV.setVisibility(0);
                    }
                } else if (m.this.kuV != null) {
                    m.this.kuV.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.kuO = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.kuV = membersActivity.findViewById(R.id.bottom_divider_line);
        this.kuP = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.kuQ = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.kuR = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.kuS = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.kuT = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.kuU = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        Ek(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cXi() {
        return this.kuP;
    }

    public void onChangeSkinType(int i) {
        this.kut.getLayoutMode().setNightMode(i == 1);
        this.kut.getLayoutMode().onModeChanged(this.mRootView);
        this.kut.getLayoutMode().onModeChanged(this.kuW);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kuU.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.kuL != null) {
            this.kuL.notifyDataSetChanged();
        }
    }

    public TextView cXj() {
        return this.kuS;
    }

    public TextView cXk() {
        return this.kuT;
    }

    public void Ek(int i) {
        this.kuT.setText(this.kut.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.knq.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.kut.getPageContext().getPageActivity(), R.dimen.ds150);
            this.kuO.setVisibility(0);
            this.kuQ.setVisibility(0);
            this.kuR.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.kuO.setVisibility(8);
        }
        this.knq.requestLayout();
    }

    public void sB(boolean z) {
        if (z) {
            this.kuQ.setVisibility(8);
            this.kuR.setVisibility(0);
            return;
        }
        this.kuQ.setVisibility(0);
        this.kuR.setVisibility(8);
    }

    public void cJM() {
        this.knq.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cXl() {
        return this.kuN;
    }

    public l cXm() {
        return this.kuL;
    }

    public void cXn() {
        this.kuL.notifyDataSetChanged();
    }

    public TextView cXo() {
        return this.kuM;
    }

    public void sC(boolean z) {
        this.kuM.setEnabled(z);
    }

    public BdListView cUk() {
        return this.knq;
    }
}
