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
    private com.baidu.tbadk.core.view.o aWM;
    private MembersActivity aXR;
    private ad aYd;
    private TextView aYe;
    private ViewGroup aYf;
    private ViewGroup aYg;
    private ViewGroup aYh;
    private TextView aYi;
    private TextView aYj;
    private TextView aYk;
    private BdListView azz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public ah(MembersActivity membersActivity) {
        super(membersActivity);
        this.aXR = membersActivity;
        membersActivity.setContentView(com.baidu.tieba.w.im_members_activity);
        g(membersActivity);
        h(membersActivity);
        i(membersActivity);
    }

    private void g(MembersActivity membersActivity) {
        this.mRootView = (ViewGroup) this.aXR.findViewById(com.baidu.tieba.v.rootView);
        this.mNavigationBar = (NavigationBar) this.aXR.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aXR.getString(com.baidu.tieba.y.members_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ai(this));
        this.aYe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.aXR.getString(com.baidu.tieba.y.members_order));
        this.aYe.setOnClickListener(membersActivity);
    }

    private void h(MembersActivity membersActivity) {
        this.azz = (BdListView) membersActivity.findViewById(com.baidu.tieba.v.members_list);
        this.aWM = NoDataViewFactory.a(getContext(), (FrameLayout) membersActivity.findViewById(com.baidu.tieba.v.content_layout), com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.aYd = new ad(this.aXR);
        this.azz.setAdapter((ListAdapter) this.aYd);
    }

    private void i(MembersActivity membersActivity) {
        this.aYf = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.v.bottom_manager);
        this.aYg = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.v.bottom_edit);
        this.aYh = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.v.bottom_send_edit);
        this.aYi = (TextView) membersActivity.findViewById(com.baidu.tieba.v.edit_cancel);
        this.aYj = (TextView) membersActivity.findViewById(com.baidu.tieba.v.edit_num);
        this.aYk = (TextView) membersActivity.findViewById(com.baidu.tieba.v.members_edit);
        this.mProgressBar = (ProgressBar) membersActivity.findViewById(com.baidu.tieba.v.progress_loading);
        fJ(0);
    }

    public void da(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public ViewGroup NK() {
        return this.aYg;
    }

    public void onChangeSkinType(int i) {
        this.aXR.getLayoutMode().L(i == 1);
        this.aXR.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(i);
        this.aYk.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public TextView NL() {
        return this.aYi;
    }

    public TextView NM() {
        return this.aYj;
    }

    public void fJ(int i) {
        this.aYj.setText(this.aXR.getString(com.baidu.tieba.y.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void setController(boolean z) {
        if (z) {
            this.aYf.setVisibility(0);
            this.aYg.setVisibility(0);
            this.aYh.setVisibility(8);
            return;
        }
        this.aYf.setVisibility(8);
    }

    public void db(boolean z) {
        if (z) {
            this.aYg.setVisibility(8);
            this.aYh.setVisibility(0);
            return;
        }
        this.aYg.setVisibility(0);
        this.aYh.setVisibility(8);
    }

    public void hideProgress() {
        this.azz.hN();
    }

    public com.baidu.tbadk.core.view.o NN() {
        return this.aWM;
    }

    public ad NO() {
        return this.aYd;
    }

    public void NP() {
        this.aYd.notifyDataSetChanged();
    }

    public TextView NQ() {
        return this.aYe;
    }

    public void dc(boolean z) {
        this.aYe.setEnabled(z);
    }

    public void fK(int i) {
        this.aYe.setText(this.aXR.getResources().getStringArray(com.baidu.tieba.q.members_order_by_short)[i]);
    }

    public BdListView ER() {
        return this.azz;
    }
}
