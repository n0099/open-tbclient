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
/* loaded from: classes7.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView hpC;
    private l hvF;
    private TextView hvG;
    private NoDataView hvH;
    private ViewGroup hvI;
    private ViewGroup hvJ;
    private RelativeLayout hvK;
    private ViewGroup hvL;
    private TextView hvM;
    private TextView hvN;
    private TextView hvO;
    private View hvP;
    private View hvQ;
    private MembersActivity hvm;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.hvm = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.hvm.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.hvm.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hvm.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.hvm.finish();
            }
        });
        this.hvQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.hvG = (TextView) this.hvQ.findViewById(R.id.right_textview);
        this.hvG.setText(this.hvm.getResources().getString(R.string.members_order));
        this.hvG.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.hpC = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.hvH = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.hvF = new l(this.hvm);
        this.hpC.setAdapter((ListAdapter) this.hvF);
        this.hpC.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.hvP != null) {
                        m.this.hvP.setVisibility(0);
                    }
                } else if (m.this.hvP != null) {
                    m.this.hvP.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.hvI = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.hvP = membersActivity.findViewById(R.id.bottom_divider_line);
        this.hvJ = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.hvK = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.hvL = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.hvM = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.hvN = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.hvO = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        wk(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bSB() {
        return this.hvJ;
    }

    public void onChangeSkinType(int i) {
        this.hvm.getLayoutMode().setNightMode(i == 1);
        this.hvm.getLayoutMode().onModeChanged(this.mRootView);
        this.hvm.getLayoutMode().onModeChanged(this.hvQ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hvO.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.hvF != null) {
            this.hvF.notifyDataSetChanged();
        }
    }

    public TextView bSC() {
        return this.hvM;
    }

    public TextView bSD() {
        return this.hvN;
    }

    public void wk(int i) {
        this.hvN.setText(this.hvm.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hpC.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.hvm.getPageContext().getPageActivity(), R.dimen.ds150);
            this.hvI.setVisibility(0);
            this.hvK.setVisibility(0);
            this.hvL.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.hvI.setVisibility(8);
        }
        this.hpC.requestLayout();
    }

    public void no(boolean z) {
        if (z) {
            this.hvK.setVisibility(8);
            this.hvL.setVisibility(0);
            return;
        }
        this.hvK.setVisibility(0);
        this.hvL.setVisibility(8);
    }

    public void bHh() {
        this.hpC.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bSE() {
        return this.hvH;
    }

    public l bSF() {
        return this.hvF;
    }

    public void bSG() {
        this.hvF.notifyDataSetChanged();
    }

    public TextView bSH() {
        return this.hvG;
    }

    public void np(boolean z) {
        this.hvG.setEnabled(z);
    }

    public BdListView bPV() {
        return this.hpC;
    }
}
