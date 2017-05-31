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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private i bMt;
    private PluginErrorTipView bMu;
    private RelativeLayout bMv;
    private ImageView bMw;
    private ObservedChangeLinearLayout bMx;
    final CustomMessageListener bMy = new f(this, CmdConfigCustom.CMD_SYNC_FINISH);
    private NoNetworkView byr;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout Xh() {
        return this.bMx;
    }

    private void Z(View view) {
        this.bMv = (RelativeLayout) view.findViewById(w.h.enter_root_layout);
        aa(view);
        this.byr = (NoNetworkView) view.findViewById(w.h.view_no_network);
        this.bMu = (PluginErrorTipView) view.findViewById(w.h.view_plugin_error_tip);
        this.bMx = (ObservedChangeLinearLayout) view.findViewById(w.h.tab_layout);
        this.bMt = new i(this);
        this.byr.a(new g(this));
        this.bMv.addView(this.bMt.getView(), 0);
    }

    private void aa(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(w.h.enter_forum_navigation_bar);
        aq.k(this.mNavigationBar, w.e.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(w.l.enter_forum));
        this.bMw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_signall, new h(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds28), 0);
        this.bMw.setLayoutParams(layoutParams);
    }

    public void Xi() {
        Xk();
        if (this.bMt != null) {
            this.bMt.NJ();
            if (this.bMt.Xu()) {
                this.bMt.Xt();
            }
        }
    }

    public boolean Xj() {
        if (this.bMt != null) {
            return this.bMt.Xu();
        }
        return false;
    }

    private void Xk() {
        if (this.bMt != null) {
            this.bMt.dL(true);
        }
    }

    public void Xl() {
        if (!Xj()) {
            aq.b(this.bMw, w.g.icon_sign_bg_s, w.g.icon_sign_bg);
        } else {
            aq.b(this.bMw, w.g.icon_sign_s, w.g.icon_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            Xi();
            if (this.bMt != null) {
                refreshImage(this.bMt.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.k(this.bMv, w.e.cp_bg_line_d);
        if (this.bMt != null) {
            this.bMt.onChangeSkinType(i);
        }
        if (this.byr != null) {
            this.byr.onChangeSkinType(getPageContext(), i);
        }
        if (this.bMu != null) {
            this.bMu.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aq.k(this.mNavigationBar, w.e.cp_bg_line_d);
        }
        Xl();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(w.j.fragment_enter_forum, viewGroup, false);
        Z(inflate);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bMy.setPriority(101);
        registerListener(this.bMy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bMt != null) {
            this.bMt.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bMt != null) {
            this.bMt.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.byr != null && this.byr.getVisibility() == 0 && com.baidu.adp.lib.util.i.hk()) {
            this.byr.aJ(false);
        }
    }

    public RelativeLayout Xm() {
        return this.bMv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
