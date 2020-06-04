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
    private MembersActivity iBR;
    private l iCk;
    private TextView iCl;
    private NoDataView iCm;
    private ViewGroup iCn;
    private ViewGroup iCo;
    private RelativeLayout iCp;
    private ViewGroup iCq;
    private TextView iCr;
    private TextView iCs;
    private TextView iCt;
    private View iCu;
    private View iCv;
    private BdListView iwh;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.iBR = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.iBR.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.iBR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iBR.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.iBR.finish();
            }
        });
        this.iCv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.iCl = (TextView) this.iCv.findViewById(R.id.right_textview);
        this.iCl.setText(this.iBR.getResources().getString(R.string.members_order));
        this.iCl.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.iwh = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.iCm = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.iCk = new l(this.iBR);
        this.iwh.setAdapter((ListAdapter) this.iCk);
        this.iwh.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.iCu != null) {
                        m.this.iCu.setVisibility(0);
                    }
                } else if (m.this.iCu != null) {
                    m.this.iCu.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.iCn = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.iCu = membersActivity.findViewById(R.id.bottom_divider_line);
        this.iCo = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.iCp = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.iCq = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.iCr = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.iCs = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.iCt = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        xJ(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cmM() {
        return this.iCo;
    }

    public void onChangeSkinType(int i) {
        this.iBR.getLayoutMode().setNightMode(i == 1);
        this.iBR.getLayoutMode().onModeChanged(this.mRootView);
        this.iBR.getLayoutMode().onModeChanged(this.iCv);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iCt.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.iCk != null) {
            this.iCk.notifyDataSetChanged();
        }
    }

    public TextView cmN() {
        return this.iCr;
    }

    public TextView cmO() {
        return this.iCs;
    }

    public void xJ(int i) {
        this.iCs.setText(this.iBR.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iwh.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.iBR.getPageContext().getPageActivity(), R.dimen.ds150);
            this.iCn.setVisibility(0);
            this.iCp.setVisibility(0);
            this.iCq.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.iCn.setVisibility(8);
        }
        this.iwh.requestLayout();
    }

    public void pi(boolean z) {
        if (z) {
            this.iCp.setVisibility(8);
            this.iCq.setVisibility(0);
            return;
        }
        this.iCp.setVisibility(0);
        this.iCq.setVisibility(8);
    }

    public void cbc() {
        this.iwh.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cmP() {
        return this.iCm;
    }

    public l cmQ() {
        return this.iCk;
    }

    public void cmR() {
        this.iCk.notifyDataSetChanged();
    }

    public TextView cmS() {
        return this.iCl;
    }

    public void pj(boolean z) {
        this.iCl.setEnabled(z);
    }

    public BdListView ckg() {
        return this.iwh;
    }
}
