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
    private View HT;
    private FrsGroupActivity aWW;
    private int aXi;
    private LinearLayout aXj;
    private RadioGroup aXk;
    private RadioButton aXl;
    private RadioButton aXm;
    private RadioButton aXn;
    private ViewGroup aXo;
    private ViewGroup aXp;
    private ViewGroup aXq;
    private ViewGroup[] aXr;
    private RadioButton[] aXs;
    private boolean aXt;
    private ViewGroup aXu;
    private NoNetworkView aoS;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public l(FrsGroupActivity frsGroupActivity) {
        super(frsGroupActivity);
        this.aXi = -1;
        this.aWW = frsGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void c(Bundle bundle) {
        super.c(bundle);
        this.aXt = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.SHOW_RECOMMEND, true);
        Ny();
        if (bundle.containsKey("card_type")) {
            this.aXi = bundle.getInt("card_type");
        } else {
            this.aXi = this.aXt ? 1 : 2;
            this.aXi--;
        }
        fH(this.aXi);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("card_type", this.aXi);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.e.a
    public boolean dg(int i) {
        super.dg(i);
        com.baidu.tbadk.e.b.u(this.HT);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.aoS != null) {
            this.aoS.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ti() {
        Nw();
        Nx();
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int tj() {
        return com.baidu.tieba.w.im_frsgroup_activity;
    }

    private void Nw() {
        this.HT = getView().findViewById(com.baidu.tieba.v.view_root);
        this.mNavigationBar = (NavigationBar) getView().findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.frsgroup_title));
        this.aXj = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_create_group_btn, this.Xj);
        this.aoS = (NoNetworkView) getView().findViewById(com.baidu.tieba.v.view_no_network);
        this.aXu = (ViewGroup) getView().findViewById(com.baidu.tieba.v.fragment);
    }

    private void Nx() {
        this.aXk = (RadioGroup) getView().findViewById(com.baidu.tieba.v.raidos_change);
        this.aXk.setOnCheckedChangeListener(this.aWW);
        this.aXl = (RadioButton) getView().findViewById(com.baidu.tieba.v.radio_recommend);
        this.aXl.setChecked(true);
        this.aXm = (RadioButton) getView().findViewById(com.baidu.tieba.v.radio_hot);
        this.aXn = (RadioButton) getView().findViewById(com.baidu.tieba.v.radio_official);
        this.aXo = (ViewGroup) getView().findViewById(com.baidu.tieba.v.radio_recommend_line);
        this.aXp = (ViewGroup) getView().findViewById(com.baidu.tieba.v.radio_hot_line);
        this.aXq = (ViewGroup) getView().findViewById(com.baidu.tieba.v.radio_official_line);
        this.mProgressBar = (ProgressBar) getView().findViewById(com.baidu.tieba.v.progress_loading);
        this.aXr = new ViewGroup[3];
        this.aXr[0] = this.aXo;
        this.aXr[1] = this.aXp;
        this.aXr[2] = this.aXq;
        this.aXs = new RadioButton[3];
        this.aXs[0] = this.aXl;
        this.aXs[1] = this.aXm;
        this.aXs[2] = this.aXn;
    }

    public void fH(int i) {
        this.aXi = i;
        for (int i2 = this.aXt ? 0 : 1; i2 < 3; i2++) {
            if (i == i2) {
                this.aXr[i2].setVisibility(0);
                this.aXk.check(this.aXs[i2].getId());
                a(i2, this.aXu, (ViewGroup.LayoutParams) null);
            } else {
                this.aXr[i2].setVisibility(4);
                h(i2, true);
            }
        }
    }

    private void Ny() {
        if (this.aXt) {
            this.aXl.setVisibility(0);
            this.aXo.setVisibility(0);
            return;
        }
        this.aXl.setVisibility(8);
        this.aXo.setVisibility(8);
    }

    public void cW(boolean z) {
        this.aXj.setEnabled(z);
    }

    public void cX(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public LinearLayout Nz() {
        return this.aXj;
    }
}
