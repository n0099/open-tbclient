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
/* loaded from: classes8.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView htf;
    private MembersActivity hyP;
    private l hzi;
    private TextView hzj;
    private NoDataView hzk;
    private ViewGroup hzl;
    private ViewGroup hzm;
    private RelativeLayout hzn;
    private ViewGroup hzo;
    private TextView hzp;
    private TextView hzq;
    private TextView hzr;
    private View hzs;
    private View hzt;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.hyP = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.hyP.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.hyP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hyP.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.hyP.finish();
            }
        });
        this.hzt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.hzj = (TextView) this.hzt.findViewById(R.id.right_textview);
        this.hzj.setText(this.hyP.getResources().getString(R.string.members_order));
        this.hzj.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.htf = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.hzk = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.hzi = new l(this.hyP);
        this.htf.setAdapter((ListAdapter) this.hzi);
        this.htf.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.hzs != null) {
                        m.this.hzs.setVisibility(0);
                    }
                } else if (m.this.hzs != null) {
                    m.this.hzs.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.hzl = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.hzs = membersActivity.findViewById(R.id.bottom_divider_line);
        this.hzm = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.hzn = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.hzo = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.hzp = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.hzq = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.hzr = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        wp(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup bTK() {
        return this.hzm;
    }

    public void onChangeSkinType(int i) {
        this.hyP.getLayoutMode().setNightMode(i == 1);
        this.hyP.getLayoutMode().onModeChanged(this.mRootView);
        this.hyP.getLayoutMode().onModeChanged(this.hzt);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hzr.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.hzi != null) {
            this.hzi.notifyDataSetChanged();
        }
    }

    public TextView bTL() {
        return this.hzp;
    }

    public TextView bTM() {
        return this.hzq;
    }

    public void wp(int i) {
        this.hzq.setText(this.hyP.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.htf.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.hyP.getPageContext().getPageActivity(), R.dimen.ds150);
            this.hzl.setVisibility(0);
            this.hzn.setVisibility(0);
            this.hzo.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.hzl.setVisibility(8);
        }
        this.htf.requestLayout();
    }

    public void nA(boolean z) {
        if (z) {
            this.hzn.setVisibility(8);
            this.hzo.setVisibility(0);
            return;
        }
        this.hzn.setVisibility(0);
        this.hzo.setVisibility(8);
    }

    public void bIj() {
        this.htf.completePullRefreshPostDelayed(0L);
    }

    public NoDataView bTN() {
        return this.hzk;
    }

    public l bTO() {
        return this.hzi;
    }

    public void bTP() {
        this.hzi.notifyDataSetChanged();
    }

    public TextView bTQ() {
        return this.hzj;
    }

    public void nB(boolean z) {
        this.hzj.setEnabled(z);
    }

    public BdListView bRe() {
        return this.htf;
    }
}
