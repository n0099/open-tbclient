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
    private l gBA;
    private TextView gBB;
    private NoDataView gBC;
    private ViewGroup gBD;
    private ViewGroup gBE;
    private RelativeLayout gBF;
    private ViewGroup gBG;
    private TextView gBH;
    private TextView gBI;
    private TextView gBJ;
    private View gBK;
    private View gBL;
    private MembersActivity gBh;
    private BdListView gvu;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gBh = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gBh.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.gBh.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gBh.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gBh.finish();
            }
        });
        this.gBL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.gBB = (TextView) this.gBL.findViewById(R.id.right_textview);
        this.gBB.setText(this.gBh.getResources().getString(R.string.members_order));
        this.gBB.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gvu = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.gBC = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gBA = new l(this.gBh);
        this.gvu.setAdapter((ListAdapter) this.gBA);
        this.gvu.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gBK != null) {
                        m.this.gBK.setVisibility(0);
                    }
                } else if (m.this.gBK != null) {
                    m.this.gBK.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gBD = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.gBK = membersActivity.findViewById(R.id.bottom_divider_line);
        this.gBE = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.gBF = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.gBG = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.gBH = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.gBI = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.gBJ = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        uW(0);
    }

    public void lV(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bAW() {
        return this.gBE;
    }

    public void onChangeSkinType(int i) {
        this.gBh.getLayoutMode().setNightMode(i == 1);
        this.gBh.getLayoutMode().onModeChanged(this.mRootView);
        this.gBh.getLayoutMode().onModeChanged(this.gBL);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gBJ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gBA != null) {
            this.gBA.notifyDataSetChanged();
        }
    }

    public TextView bAX() {
        return this.gBH;
    }

    public TextView bAY() {
        return this.gBI;
    }

    public void uW(int i) {
        this.gBI.setText(this.gBh.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gvu.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.g(this.gBh.getPageContext().getPageActivity(), R.dimen.ds150);
            this.gBD.setVisibility(0);
            this.gBF.setVisibility(0);
            this.gBG.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gBD.setVisibility(8);
        }
        this.gvu.requestLayout();
    }

    public void lW(boolean z) {
        if (z) {
            this.gBF.setVisibility(8);
            this.gBG.setVisibility(0);
            return;
        }
        this.gBF.setVisibility(0);
        this.gBG.setVisibility(8);
    }

    public void bpI() {
        this.gvu.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bAZ() {
        return this.gBC;
    }

    public l bBa() {
        return this.gBA;
    }

    public void bBb() {
        this.gBA.notifyDataSetChanged();
    }

    public TextView bBc() {
        return this.gBB;
    }

    public void lX(boolean z) {
        this.gBB.setEnabled(z);
    }

    public BdListView byp() {
        return this.gvu;
    }
}
