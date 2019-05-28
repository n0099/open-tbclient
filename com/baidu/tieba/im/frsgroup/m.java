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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private NoDataView gBA;
    private ViewGroup gBB;
    private ViewGroup gBC;
    private RelativeLayout gBD;
    private ViewGroup gBE;
    private TextView gBF;
    private TextView gBG;
    private TextView gBH;
    private View gBI;
    private View gBJ;
    private MembersActivity gBf;
    private l gBy;
    private TextView gBz;
    private BdListView gvs;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gBf = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gBf.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.gBf.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gBf.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gBf.finish();
            }
        });
        this.gBJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.gBz = (TextView) this.gBJ.findViewById(R.id.right_textview);
        this.gBz.setText(this.gBf.getResources().getString(R.string.members_order));
        this.gBz.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gvs = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.gBA = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gBy = new l(this.gBf);
        this.gvs.setAdapter((ListAdapter) this.gBy);
        this.gvs.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gBI != null) {
                        m.this.gBI.setVisibility(0);
                    }
                } else if (m.this.gBI != null) {
                    m.this.gBI.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gBB = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.gBI = membersActivity.findViewById(R.id.bottom_divider_line);
        this.gBC = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.gBD = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.gBE = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.gBF = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.gBG = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.gBH = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        uW(0);
    }

    public void lU(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bAV() {
        return this.gBC;
    }

    public void onChangeSkinType(int i) {
        this.gBf.getLayoutMode().setNightMode(i == 1);
        this.gBf.getLayoutMode().onModeChanged(this.mRootView);
        this.gBf.getLayoutMode().onModeChanged(this.gBJ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gBH.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gBy != null) {
            this.gBy.notifyDataSetChanged();
        }
    }

    public TextView bAW() {
        return this.gBF;
    }

    public TextView bAX() {
        return this.gBG;
    }

    public void uW(int i) {
        this.gBG.setText(this.gBf.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvs.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.g(this.gBf.getPageContext().getPageActivity(), R.dimen.ds150);
            this.gBB.setVisibility(0);
            this.gBD.setVisibility(0);
            this.gBE.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gBB.setVisibility(8);
        }
        this.gvs.requestLayout();
    }

    public void lV(boolean z) {
        if (z) {
            this.gBD.setVisibility(8);
            this.gBE.setVisibility(0);
            return;
        }
        this.gBD.setVisibility(0);
        this.gBE.setVisibility(8);
    }

    public void bpG() {
        this.gvs.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bAY() {
        return this.gBA;
    }

    public l bAZ() {
        return this.gBy;
    }

    public void bBa() {
        this.gBy.notifyDataSetChanged();
    }

    public TextView bBb() {
        return this.gBz;
    }

    public void lW(boolean z) {
        this.gBz.setEnabled(z);
    }

    public BdListView byo() {
        return this.gvs;
    }
}
