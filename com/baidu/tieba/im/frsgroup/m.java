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
    private BdListView jTd;
    private l kaF;
    private TextView kaG;
    private NoDataView kaH;
    private ViewGroup kaI;
    private ViewGroup kaJ;
    private RelativeLayout kaK;
    private ViewGroup kaL;
    private TextView kaM;
    private TextView kaN;
    private TextView kaO;
    private View kaP;
    private View kaQ;
    private MembersActivity kal;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.kal = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.kal.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.kal.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kal.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.kal.finish();
            }
        });
        this.kaQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.kaG = (TextView) this.kaQ.findViewById(R.id.right_textview);
        this.kaG.setText(this.kal.getResources().getString(R.string.members_order));
        this.kaG.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.jTd = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.kaH = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.kaF = new l(this.kal);
        this.jTd.setAdapter((ListAdapter) this.kaF);
        this.jTd.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.kaP != null) {
                        m.this.kaP.setVisibility(0);
                    }
                } else if (m.this.kaP != null) {
                    m.this.kaP.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.kaI = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.kaP = membersActivity.findViewById(R.id.bottom_divider_line);
        this.kaJ = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.kaK = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.kaL = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.kaM = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.kaN = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.kaO = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        CK(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cPO() {
        return this.kaJ;
    }

    public void onChangeSkinType(int i) {
        this.kal.getLayoutMode().setNightMode(i == 1);
        this.kal.getLayoutMode().onModeChanged(this.mRootView);
        this.kal.getLayoutMode().onModeChanged(this.kaQ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kaO.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.kaF != null) {
            this.kaF.notifyDataSetChanged();
        }
    }

    public TextView cPP() {
        return this.kaM;
    }

    public TextView cPQ() {
        return this.kaN;
    }

    public void CK(int i) {
        this.kaN.setText(this.kal.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jTd.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.kal.getPageContext().getPageActivity(), R.dimen.ds150);
            this.kaI.setVisibility(0);
            this.kaK.setVisibility(0);
            this.kaL.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.kaI.setVisibility(8);
        }
        this.jTd.requestLayout();
    }

    public void rN(boolean z) {
        if (z) {
            this.kaK.setVisibility(8);
            this.kaL.setVisibility(0);
            return;
        }
        this.kaK.setVisibility(0);
        this.kaL.setVisibility(8);
    }

    public void cCs() {
        this.jTd.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cPR() {
        return this.kaH;
    }

    public l cPS() {
        return this.kaF;
    }

    public void cPT() {
        this.kaF.notifyDataSetChanged();
    }

    public TextView cPU() {
        return this.kaG;
    }

    public void rO(boolean z) {
        this.kaG.setEnabled(z);
    }

    public BdListView cMO() {
        return this.jTd;
    }
}
