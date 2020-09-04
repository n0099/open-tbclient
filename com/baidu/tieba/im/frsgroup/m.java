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
/* loaded from: classes17.dex */
public class m extends com.baidu.adp.base.c<MembersActivity> {
    private BdListView jjd;
    private l jqH;
    private TextView jqI;
    private NoDataView jqJ;
    private ViewGroup jqK;
    private ViewGroup jqL;
    private RelativeLayout jqM;
    private ViewGroup jqN;
    private TextView jqO;
    private TextView jqP;
    private TextView jqQ;
    private View jqR;
    private View jqS;
    private MembersActivity jqo;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.jqo = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.jqo.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.jqo.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jqo.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.jqo.finish();
            }
        });
        this.jqS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.jqI = (TextView) this.jqS.findViewById(R.id.right_textview);
        this.jqI.setText(this.jqo.getResources().getString(R.string.members_order));
        this.jqI.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.jjd = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.jqJ = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.jqH = new l(this.jqo);
        this.jjd.setAdapter((ListAdapter) this.jqH);
        this.jjd.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.jqR != null) {
                        m.this.jqR.setVisibility(0);
                    }
                } else if (m.this.jqR != null) {
                    m.this.jqR.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.jqK = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.jqR = membersActivity.findViewById(R.id.bottom_divider_line);
        this.jqL = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.jqM = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.jqN = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.jqO = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.jqP = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.jqQ = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        Bk(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cFs() {
        return this.jqL;
    }

    public void onChangeSkinType(int i) {
        this.jqo.getLayoutMode().setNightMode(i == 1);
        this.jqo.getLayoutMode().onModeChanged(this.mRootView);
        this.jqo.getLayoutMode().onModeChanged(this.jqS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jqQ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.jqH != null) {
            this.jqH.notifyDataSetChanged();
        }
    }

    public TextView cFt() {
        return this.jqO;
    }

    public TextView cFu() {
        return this.jqP;
    }

    public void Bk(int i) {
        this.jqP.setText(this.jqo.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jjd.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.jqo.getPageContext().getPageActivity(), R.dimen.ds150);
            this.jqK.setVisibility(0);
            this.jqM.setVisibility(0);
            this.jqN.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.jqK.setVisibility(8);
        }
        this.jjd.requestLayout();
    }

    public void qH(boolean z) {
        if (z) {
            this.jqM.setVisibility(8);
            this.jqN.setVisibility(0);
            return;
        }
        this.jqM.setVisibility(0);
        this.jqN.setVisibility(8);
    }

    public void csz() {
        this.jjd.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cFv() {
        return this.jqJ;
    }

    public l cFw() {
        return this.jqH;
    }

    public void cFx() {
        this.jqH.notifyDataSetChanged();
    }

    public TextView cFy() {
        return this.jqI;
    }

    public void qI(boolean z) {
        this.jqI.setEnabled(z);
    }

    public BdListView cCs() {
        return this.jjd;
    }
}
