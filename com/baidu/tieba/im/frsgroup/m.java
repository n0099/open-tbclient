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
    private BdListView kno;
    private l kuJ;
    private TextView kuK;
    private NoDataView kuL;
    private ViewGroup kuM;
    private ViewGroup kuN;
    private RelativeLayout kuO;
    private ViewGroup kuP;
    private TextView kuQ;
    private TextView kuR;
    private TextView kuS;
    private View kuT;
    private View kuU;
    private MembersActivity kur;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.kur = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.kur.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.kur.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kur.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.kur.finish();
            }
        });
        this.kuU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.kuK = (TextView) this.kuU.findViewById(R.id.right_textview);
        this.kuK.setText(this.kur.getResources().getString(R.string.members_order));
        this.kuK.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.kno = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.kuL = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.kuJ = new l(this.kur);
        this.kno.setAdapter((ListAdapter) this.kuJ);
        this.kno.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.kuT != null) {
                        m.this.kuT.setVisibility(0);
                    }
                } else if (m.this.kuT != null) {
                    m.this.kuT.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.kuM = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.kuT = membersActivity.findViewById(R.id.bottom_divider_line);
        this.kuN = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.kuO = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.kuP = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.kuQ = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.kuR = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.kuS = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        Ek(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cXh() {
        return this.kuN;
    }

    public void onChangeSkinType(int i) {
        this.kur.getLayoutMode().setNightMode(i == 1);
        this.kur.getLayoutMode().onModeChanged(this.mRootView);
        this.kur.getLayoutMode().onModeChanged(this.kuU);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kuS.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.kuJ != null) {
            this.kuJ.notifyDataSetChanged();
        }
    }

    public TextView cXi() {
        return this.kuQ;
    }

    public TextView cXj() {
        return this.kuR;
    }

    public void Ek(int i) {
        this.kuR.setText(this.kur.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kno.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.kur.getPageContext().getPageActivity(), R.dimen.ds150);
            this.kuM.setVisibility(0);
            this.kuO.setVisibility(0);
            this.kuP.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.kuM.setVisibility(8);
        }
        this.kno.requestLayout();
    }

    public void sB(boolean z) {
        if (z) {
            this.kuO.setVisibility(8);
            this.kuP.setVisibility(0);
            return;
        }
        this.kuO.setVisibility(0);
        this.kuP.setVisibility(8);
    }

    public void cJL() {
        this.kno.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cXk() {
        return this.kuL;
    }

    public l cXl() {
        return this.kuJ;
    }

    public void cXm() {
        this.kuJ.notifyDataSetChanged();
    }

    public TextView cXn() {
        return this.kuK;
    }

    public void sC(boolean z) {
        this.kuK.setEnabled(z);
    }

    public BdListView cUj() {
        return this.kno;
    }
}
