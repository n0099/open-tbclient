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
/* loaded from: classes5.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView gCo;
    private MembersActivity gHZ;
    private TextView gIA;
    private TextView gIB;
    private View gIC;
    private View gID;
    private l gIs;
    private TextView gIt;
    private NoDataView gIu;
    private ViewGroup gIv;
    private ViewGroup gIw;
    private RelativeLayout gIx;
    private ViewGroup gIy;
    private TextView gIz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gHZ = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gHZ.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.gHZ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gHZ.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gHZ.finish();
            }
        });
        this.gID = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.gIt = (TextView) this.gID.findViewById(R.id.right_textview);
        this.gIt.setText(this.gHZ.getResources().getString(R.string.members_order));
        this.gIt.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gCo = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.gIu = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gIs = new l(this.gHZ);
        this.gCo.setAdapter((ListAdapter) this.gIs);
        this.gCo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gIC != null) {
                        m.this.gIC.setVisibility(0);
                    }
                } else if (m.this.gIC != null) {
                    m.this.gIC.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gIv = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.gIC = membersActivity.findViewById(R.id.bottom_divider_line);
        this.gIw = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.gIx = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.gIy = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.gIz = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.gIA = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.gIB = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        uj(0);
    }

    public void ma(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bBq() {
        return this.gIw;
    }

    public void onChangeSkinType(int i) {
        this.gHZ.getLayoutMode().setNightMode(i == 1);
        this.gHZ.getLayoutMode().onModeChanged(this.mRootView);
        this.gHZ.getLayoutMode().onModeChanged(this.gID);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gIB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gIs != null) {
            this.gIs.notifyDataSetChanged();
        }
    }

    public TextView bBr() {
        return this.gIz;
    }

    public TextView bBs() {
        return this.gIA;
    }

    public void uj(int i) {
        this.gIA.setText(this.gHZ.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gCo.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.gHZ.getPageContext().getPageActivity(), R.dimen.ds150);
            this.gIv.setVisibility(0);
            this.gIx.setVisibility(0);
            this.gIy.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gIv.setVisibility(8);
        }
        this.gCo.requestLayout();
    }

    public void mb(boolean z) {
        if (z) {
            this.gIx.setVisibility(8);
            this.gIy.setVisibility(0);
            return;
        }
        this.gIx.setVisibility(0);
        this.gIy.setVisibility(8);
    }

    public void bpN() {
        this.gCo.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bBt() {
        return this.gIu;
    }

    public l bBu() {
        return this.gIs;
    }

    public void bBv() {
        this.gIs.notifyDataSetChanged();
    }

    public TextView bBw() {
        return this.gIt;
    }

    public void mc(boolean z) {
        this.gIt.setEnabled(z);
    }

    public BdListView byG() {
        return this.gCo;
    }
}
