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
    private MembersActivity hCC;
    private l hCV;
    private TextView hCW;
    private NoDataView hCX;
    private ViewGroup hCY;
    private ViewGroup hCZ;
    private RelativeLayout hDa;
    private ViewGroup hDb;
    private TextView hDc;
    private TextView hDd;
    private TextView hDe;
    private View hDf;
    private View hDg;
    private BdListView hwS;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.hCC = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.hCC.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.hCC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hCC.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.hCC.finish();
            }
        });
        this.hDg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.hCW = (TextView) this.hDg.findViewById(R.id.right_textview);
        this.hCW.setText(this.hCC.getResources().getString(R.string.members_order));
        this.hCW.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.hwS = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.hCX = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.hCV = new l(this.hCC);
        this.hwS.setAdapter((ListAdapter) this.hCV);
        this.hwS.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.hDf != null) {
                        m.this.hDf.setVisibility(0);
                    }
                } else if (m.this.hDf != null) {
                    m.this.hDf.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.hCY = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.hDf = membersActivity.findViewById(R.id.bottom_divider_line);
        this.hCZ = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.hDa = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.hDb = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.hDc = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.hDd = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.hDe = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        wD(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bVG() {
        return this.hCZ;
    }

    public void onChangeSkinType(int i) {
        this.hCC.getLayoutMode().setNightMode(i == 1);
        this.hCC.getLayoutMode().onModeChanged(this.mRootView);
        this.hCC.getLayoutMode().onModeChanged(this.hDg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hDe.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.hCV != null) {
            this.hCV.notifyDataSetChanged();
        }
    }

    public TextView bVH() {
        return this.hDc;
    }

    public TextView bVI() {
        return this.hDd;
    }

    public void wD(int i) {
        this.hDd.setText(this.hCC.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hwS.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.hCC.getPageContext().getPageActivity(), R.dimen.ds150);
            this.hCY.setVisibility(0);
            this.hDa.setVisibility(0);
            this.hDb.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.hCY.setVisibility(8);
        }
        this.hwS.requestLayout();
    }

    public void nI(boolean z) {
        if (z) {
            this.hDa.setVisibility(8);
            this.hDb.setVisibility(0);
            return;
        }
        this.hDa.setVisibility(0);
        this.hDb.setVisibility(8);
    }

    public void bKb() {
        this.hwS.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bVJ() {
        return this.hCX;
    }

    public l bVK() {
        return this.hCV;
    }

    public void bVL() {
        this.hCV.notifyDataSetChanged();
    }

    public TextView bVM() {
        return this.hCW;
    }

    public void nJ(boolean z) {
        this.hCW.setEnabled(z);
    }

    public BdListView bTa() {
        return this.hwS;
    }
}
