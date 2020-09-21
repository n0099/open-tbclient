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
/* loaded from: classes22.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView jrH;
    private MembersActivity jyQ;
    private l jzj;
    private TextView jzk;
    private NoDataView jzl;
    private ViewGroup jzm;
    private ViewGroup jzn;
    private RelativeLayout jzo;
    private ViewGroup jzp;
    private TextView jzq;
    private TextView jzr;
    private TextView jzs;
    private View jzt;
    private View jzu;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.jyQ = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.jyQ.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.jyQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jyQ.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.jyQ.finish();
            }
        });
        this.jzu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.jzk = (TextView) this.jzu.findViewById(R.id.right_textview);
        this.jzk.setText(this.jyQ.getResources().getString(R.string.members_order));
        this.jzk.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.jrH = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.jzl = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.jzj = new l(this.jyQ);
        this.jrH.setAdapter((ListAdapter) this.jzj);
        this.jrH.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.jzt != null) {
                        m.this.jzt.setVisibility(0);
                    }
                } else if (m.this.jzt != null) {
                    m.this.jzt.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.jzm = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.jzt = membersActivity.findViewById(R.id.bottom_divider_line);
        this.jzn = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.jzo = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.jzp = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.jzq = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.jzr = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.jzs = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        BL(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cIY() {
        return this.jzn;
    }

    public void onChangeSkinType(int i) {
        this.jyQ.getLayoutMode().setNightMode(i == 1);
        this.jyQ.getLayoutMode().onModeChanged(this.mRootView);
        this.jyQ.getLayoutMode().onModeChanged(this.jzu);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jzs.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.jzj != null) {
            this.jzj.notifyDataSetChanged();
        }
    }

    public TextView cIZ() {
        return this.jzq;
    }

    public TextView cJa() {
        return this.jzr;
    }

    public void BL(int i) {
        this.jzr.setText(this.jyQ.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jrH.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.jyQ.getPageContext().getPageActivity(), R.dimen.ds150);
            this.jzm.setVisibility(0);
            this.jzo.setVisibility(0);
            this.jzp.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.jzm.setVisibility(8);
        }
        this.jrH.requestLayout();
    }

    public void qP(boolean z) {
        if (z) {
            this.jzo.setVisibility(8);
            this.jzp.setVisibility(0);
            return;
        }
        this.jzo.setVisibility(0);
        this.jzp.setVisibility(8);
    }

    public void cvO() {
        this.jrH.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cJb() {
        return this.jzl;
    }

    public l cJc() {
        return this.jzj;
    }

    public void cJd() {
        this.jzj.notifyDataSetChanged();
    }

    public TextView cJe() {
        return this.jzk;
    }

    public void qQ(boolean z) {
        this.jzk.setEnabled(z);
    }

    public BdListView cFY() {
        return this.jrH;
    }
}
