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
    private BdListView jiX;
    private l jqB;
    private TextView jqC;
    private NoDataView jqD;
    private ViewGroup jqE;
    private ViewGroup jqF;
    private RelativeLayout jqG;
    private ViewGroup jqH;
    private TextView jqI;
    private TextView jqJ;
    private TextView jqK;
    private View jqL;
    private View jqM;
    private MembersActivity jqi;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public m(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
        this.jqi = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.jqi.findViewById(R.id.rootView);
        this.mNavigationBar = (NavigationBar) this.jqi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jqi.getPageContext().getString(R.string.group_info_member));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.jqi.finish();
            }
        });
        this.jqM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_member_navi_right_button, (View.OnClickListener) null);
        this.jqC = (TextView) this.jqM.findViewById(R.id.right_textview);
        this.jqC.setText(this.jqi.getResources().getString(R.string.members_order));
        this.jqC.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.jiX = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.jqD = NoDataViewFactory.a(getPageContext().getPageActivity(), (FrameLayout) membersActivity.findViewById(R.id.content_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.jqB = new l(this.jqi);
        this.jiX.setAdapter((ListAdapter) this.jqB);
        this.jiX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.frsgroup.m.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (m.this.jqL != null) {
                        m.this.jqL.setVisibility(0);
                    }
                } else if (m.this.jqL != null) {
                    m.this.jqL.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void i(MembersActivity membersActivity) {
        this.jqE = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.jqL = membersActivity.findViewById(R.id.bottom_divider_line);
        this.jqF = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.jqG = (RelativeLayout) membersActivity.findViewById(R.id.edit_lay);
        this.jqH = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.jqI = (TextView) membersActivity.findViewById(R.id.edit_cancel);
        this.jqJ = (TextView) membersActivity.findViewById(R.id.edit_num);
        this.jqK = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        Bk(0);
    }

    public void showProgressBar(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup cFr() {
        return this.jqF;
    }

    public void onChangeSkinType(int i) {
        this.jqi.getLayoutMode().setNightMode(i == 1);
        this.jqi.getLayoutMode().onModeChanged(this.mRootView);
        this.jqi.getLayoutMode().onModeChanged(this.jqM);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jqK.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.jqB != null) {
            this.jqB.notifyDataSetChanged();
        }
    }

    public TextView cFs() {
        return this.jqI;
    }

    public TextView cFt() {
        return this.jqJ;
    }

    public void Bk(int i) {
        this.jqJ.setText(this.jqi.getPageContext().getPageActivity().getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jiX.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.jqi.getPageContext().getPageActivity(), R.dimen.ds150);
            this.jqE.setVisibility(0);
            this.jqG.setVisibility(0);
            this.jqH.setVisibility(8);
        } else {
            layoutParams.bottomMargin = 0;
            this.jqE.setVisibility(8);
        }
        this.jiX.requestLayout();
    }

    public void qF(boolean z) {
        if (z) {
            this.jqG.setVisibility(8);
            this.jqH.setVisibility(0);
            return;
        }
        this.jqG.setVisibility(0);
        this.jqH.setVisibility(8);
    }

    public void csy() {
        this.jiX.completePullRefreshPostDelayed(0L);
    }

    public NoDataView cFu() {
        return this.jqD;
    }

    public l cFv() {
        return this.jqB;
    }

    public void cFw() {
        this.jqB.notifyDataSetChanged();
    }

    public TextView cFx() {
        return this.jqC;
    }

    public void qG(boolean z) {
        this.jqC.setEnabled(z);
    }

    public BdListView cCr() {
        return this.jiX;
    }
}
