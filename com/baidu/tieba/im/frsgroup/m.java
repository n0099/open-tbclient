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
    private BdListView gBx;
    private l gHB;
    private TextView gHC;
    private NoDataView gHD;
    private ViewGroup gHE;
    private ViewGroup gHF;
    private RelativeLayout gHG;
    private ViewGroup gHH;
    private TextView gHI;
    private TextView gHJ;
    private TextView gHK;
    private View gHL;
    private View gHM;
    private MembersActivity gHi;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.gHi = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.gHi.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.gHi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gHi.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gHi.finish();
            }
        });
        this.gHM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.gHC = (TextView) this.gHM.findViewById(R.id.right_textview);
        this.gHC.setText(this.gHi.getResources().getString(R.string.members_order));
        this.gHC.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.gBx = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.gHD = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.gHB = new l(this.gHi);
        this.gBx.setAdapter((ListAdapter) this.gHB);
        this.gBx.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.gHL != null) {
                        m.this.gHL.setVisibility(0);
                    }
                } else if (m.this.gHL != null) {
                    m.this.gHL.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.gHE = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.gHL = membersActivity.findViewById(R.id.bottom_divider_line);
        this.gHF = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.gHG = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.gHH = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.gHI = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.gHJ = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.gHK = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        ui(0);
    }

    public void ma(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bBo() {
        return this.gHF;
    }

    public void onChangeSkinType(int i) {
        this.gHi.getLayoutMode().setNightMode(i == 1);
        this.gHi.getLayoutMode().onModeChanged(this.mRootView);
        this.gHi.getLayoutMode().onModeChanged(this.gHM);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gHK.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gHB != null) {
            this.gHB.notifyDataSetChanged();
        }
    }

    public TextView bBp() {
        return this.gHI;
    }

    public TextView bBq() {
        return this.gHJ;
    }

    public void ui(int i) {
        this.gHJ.setText(this.gHi.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBx.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.gHi.getPageContext().getPageActivity(), R.dimen.ds150);
            this.gHE.setVisibility(0);
            this.gHG.setVisibility(0);
            this.gHH.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.gHE.setVisibility(8);
        }
        this.gBx.requestLayout();
    }

    public void mb(boolean z) {
        if (z) {
            this.gHG.setVisibility(8);
            this.gHH.setVisibility(0);
            return;
        }
        this.gHG.setVisibility(0);
        this.gHH.setVisibility(8);
    }

    public void bpL() {
        this.gBx.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bBr() {
        return this.gHD;
    }

    public l bBs() {
        return this.gHB;
    }

    public void bBt() {
        this.gHB.notifyDataSetChanged();
    }

    public TextView bBu() {
        return this.gHC;
    }

    public void mc(boolean z) {
        this.gHC.setEnabled(z);
    }

    public BdListView byE() {
        return this.gBx;
    }
}
