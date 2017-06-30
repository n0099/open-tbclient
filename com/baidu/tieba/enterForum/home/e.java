package com.baidu.tieba.enterForum.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private i bSU;
    private PluginErrorTipView bSV;
    private RelativeLayout bSW;
    private ImageView bSX;
    private ObservedChangeLinearLayout bSY;
    final CustomMessageListener bSZ = new f(this, CmdConfigCustom.CMD_SYNC_FINISH);
    private NoNetworkView bzB;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout aaE() {
        return this.bSY;
    }

    private void aa(View view) {
        this.bSW = (RelativeLayout) view.findViewById(w.h.enter_root_layout);
        ab(view);
        this.bzB = (NoNetworkView) view.findViewById(w.h.view_no_network);
        this.bSV = (PluginErrorTipView) view.findViewById(w.h.view_plugin_error_tip);
        this.bSY = (ObservedChangeLinearLayout) view.findViewById(w.h.tab_layout);
        this.bSU = new i(this);
        this.bzB.a(new g(this));
        this.bSW.addView(this.bSU.getView(), 0);
    }

    private void ab(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(w.h.enter_forum_navigation_bar);
        as.k(this.mNavigationBar, w.e.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(w.l.enter_forum));
        this.bSX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_signall, new h(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds28), 0);
        this.bSX.setLayoutParams(layoutParams);
    }

    public void aaF() {
        aaH();
        if (this.bSU != null) {
            this.bSU.OZ();
            if (this.bSU.aaR()) {
                this.bSU.aaQ();
            }
        }
    }

    public boolean aaG() {
        if (this.bSU != null) {
            return this.bSU.aaR();
        }
        return false;
    }

    private void aaH() {
        if (this.bSU != null) {
            this.bSU.ea(true);
        }
    }

    public void aaI() {
        if (!aaG()) {
            as.b(this.bSX, w.g.icon_sign_bg_s, w.g.icon_sign_bg);
        } else {
            as.b(this.bSX, w.g.icon_sign_s, w.g.icon_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aaF();
            if (this.bSU != null) {
                refreshImage(this.bSU.getView());
            }
        } else if (!isPrimary() && this.bSU != null) {
            this.bSU.aaS();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.k(this.bSW, w.e.cp_bg_line_d);
        if (this.bSU != null) {
            this.bSU.onChangeSkinType(i);
        }
        if (this.bzB != null) {
            this.bzB.onChangeSkinType(getPageContext(), i);
        }
        if (this.bSV != null) {
            this.bSV.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            as.k(this.mNavigationBar, w.e.cp_bg_line_d);
        }
        aaI();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(w.j.fragment_enter_forum, viewGroup, false);
        aa(inflate);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bSZ.setPriority(101);
        registerListener(this.bSZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bSU != null) {
            this.bSU.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bSU != null) {
            this.bSU.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bzB != null && this.bzB.getVisibility() == 0 && com.baidu.adp.lib.util.i.hj()) {
            this.bzB.aK(false);
        }
    }

    public RelativeLayout aaJ() {
        return this.bSW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
