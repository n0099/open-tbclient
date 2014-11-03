package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.f {
    private com.baidu.tbadk.core.view.o aXa;
    private MembersActivity aYf;
    private ad aYr;
    private TextView aYs;
    private ViewGroup aYt;
    private ViewGroup aYu;
    private ViewGroup aYv;
    private TextView aYw;
    private TextView aYx;
    private TextView aYy;
    private BdListView azI;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public ah(MembersActivity membersActivity) {
        super(membersActivity);
        this.aYf = membersActivity;
        membersActivity.setContentView(com.baidu.tieba.w.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.aYf.findViewById(com.baidu.tieba.v.rootView);
        this.mNavigationBar = (NavigationBar) this.aYf.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aYf.getString(com.baidu.tieba.y.members_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ai(this));
        this.aYs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.aYf.getString(com.baidu.tieba.y.members_order));
        this.aYs.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.azI = (BdListView) membersActivity.findViewById(com.baidu.tieba.v.members_list);
        this.aXa = NoDataViewFactory.a(getContext(), (FrameLayout) membersActivity.findViewById(com.baidu.tieba.v.content_layout), com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.aYr = new ad(this.aYf);
        this.azI.setAdapter((ListAdapter) this.aYr);
    }

    private void i(MembersActivity membersActivity) {
        this.aYt = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.v.bottom_manager);
        this.aYu = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.v.bottom_edit);
        this.aYv = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.v.bottom_send_edit);
        this.aYw = (TextView) membersActivity.findViewById(com.baidu.tieba.v.edit_cancel);
        this.aYx = (TextView) membersActivity.findViewById(com.baidu.tieba.v.edit_num);
        this.aYy = (TextView) membersActivity.findViewById(com.baidu.tieba.v.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(com.baidu.tieba.v.progress_loading);
        fJ(0);
    }

    public void da(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup NO() {
        return this.aYu;
    }

    public void onChangeSkinType(int i) {
        this.aYf.getLayoutMode().L(i == 1);
        this.aYf.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(i);
        this.aYy.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public TextView NP() {
        return this.aYw;
    }

    public TextView NQ() {
        return this.aYx;
    }

    public void fJ(int i) {
        this.aYx.setText(this.aYf.getString(com.baidu.tieba.y.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        if (z) {
            this.aYt.setVisibility(0);
            this.aYu.setVisibility(0);
            this.aYv.setVisibility(8);
            return;
        }
        this.aYt.setVisibility(8);
    }

    public void db(boolean z) {
        if (z) {
            this.aYu.setVisibility(8);
            this.aYv.setVisibility(0);
            return;
        }
        this.aYu.setVisibility(0);
        this.aYv.setVisibility(8);
    }

    public void hideProgress() {
        this.azI.hN();
    }

    public com.baidu.tbadk.core.view.o NR() {
        return this.aXa;
    }

    public ad NS() {
        return this.aYr;
    }

    public void NT() {
        this.aYr.notifyDataSetChanged();
    }

    public TextView NU() {
        return this.aYs;
    }

    public void dc(boolean z) {
        this.aYs.setEnabled(z);
    }

    public void fK(int i) {
        this.aYs.setText(this.aYf.getResources().getStringArray(com.baidu.tieba.q.members_order_by_short)[i]);
    }

    public BdListView ET() {
        return this.azI;
    }
}
