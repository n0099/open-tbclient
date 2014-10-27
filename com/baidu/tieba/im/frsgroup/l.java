package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.mvc.core.d {
    private View HS;
    private FrsGroupActivity aWI;
    private int aWU;
    private LinearLayout aWV;
    private RadioGroup aWW;
    private RadioButton aWX;
    private RadioButton aWY;
    private RadioButton aWZ;
    private ViewGroup aXa;
    private ViewGroup aXb;
    private ViewGroup aXc;
    private ViewGroup[] aXd;
    private RadioButton[] aXe;
    private boolean aXf;
    private ViewGroup aXg;
    private NoNetworkView aoJ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public l(FrsGroupActivity frsGroupActivity) {
        super(frsGroupActivity);
        this.aWU = -1;
        this.aWI = frsGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void c(Bundle bundle) {
        super.c(bundle);
        this.aXf = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.SHOW_RECOMMEND, true);
        Nu();
        if (bundle.containsKey("card_type")) {
            this.aWU = bundle.getInt("card_type");
        } else {
            this.aWU = this.aXf ? 1 : 2;
            this.aWU--;
        }
        fH(this.aWU);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("card_type", this.aWU);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.e.a
    public boolean dg(int i) {
        super.dg(i);
        com.baidu.tbadk.e.b.u(this.HS);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.aoJ != null) {
            this.aoJ.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void tg() {
        Ns();
        Nt();
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int th() {
        return com.baidu.tieba.w.im_frsgroup_activity;
    }

    private void Ns() {
        this.HS = getView().findViewById(com.baidu.tieba.v.view_root);
        this.mNavigationBar = (NavigationBar) getView().findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.frsgroup_title));
        this.aWV = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_create_group_btn, this.Xf);
        this.aoJ = (NoNetworkView) getView().findViewById(com.baidu.tieba.v.view_no_network);
        this.aXg = (ViewGroup) getView().findViewById(com.baidu.tieba.v.fragment);
    }

    private void Nt() {
        this.aWW = (RadioGroup) getView().findViewById(com.baidu.tieba.v.raidos_change);
        this.aWW.setOnCheckedChangeListener(this.aWI);
        this.aWX = (RadioButton) getView().findViewById(com.baidu.tieba.v.radio_recommend);
        this.aWX.setChecked(true);
        this.aWY = (RadioButton) getView().findViewById(com.baidu.tieba.v.radio_hot);
        this.aWZ = (RadioButton) getView().findViewById(com.baidu.tieba.v.radio_official);
        this.aXa = (ViewGroup) getView().findViewById(com.baidu.tieba.v.radio_recommend_line);
        this.aXb = (ViewGroup) getView().findViewById(com.baidu.tieba.v.radio_hot_line);
        this.aXc = (ViewGroup) getView().findViewById(com.baidu.tieba.v.radio_official_line);
        this.mProgressBar = (ProgressBar) getView().findViewById(com.baidu.tieba.v.progress_loading);
        this.aXd = new ViewGroup[3];
        this.aXd[0] = this.aXa;
        this.aXd[1] = this.aXb;
        this.aXd[2] = this.aXc;
        this.aXe = new RadioButton[3];
        this.aXe[0] = this.aWX;
        this.aXe[1] = this.aWY;
        this.aXe[2] = this.aWZ;
    }

    public void fH(int i) {
        this.aWU = i;
        for (int i2 = this.aXf ? 0 : 1; i2 < 3; i2++) {
            if (i == i2) {
                this.aXd[i2].setVisibility(0);
                this.aWW.check(this.aXe[i2].getId());
                a(i2, this.aXg, (ViewGroup.LayoutParams) null);
            } else {
                this.aXd[i2].setVisibility(4);
                h(i2, true);
            }
        }
    }

    private void Nu() {
        if (this.aXf) {
            this.aWX.setVisibility(0);
            this.aXa.setVisibility(0);
            return;
        }
        this.aWX.setVisibility(8);
        this.aXa.setVisibility(8);
    }

    public void cW(boolean z) {
        this.aWV.setEnabled(z);
    }

    public void cX(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public LinearLayout Nv() {
        return this.aWV;
    }
}
