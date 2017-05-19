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
    private i bGE;
    private NoNetworkView bGF;
    private PluginErrorTipView bGG;
    private RelativeLayout bGH;
    private ImageView bGI;
    private ObservedChangeLinearLayout bGJ;
    final CustomMessageListener bGK = new f(this, CmdConfigCustom.CMD_SYNC_FINISH);
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout We() {
        return this.bGJ;
    }

    private void Z(View view) {
        this.bGH = (RelativeLayout) view.findViewById(w.h.enter_root_layout);
        aa(view);
        this.bGF = (NoNetworkView) view.findViewById(w.h.view_no_network);
        this.bGG = (PluginErrorTipView) view.findViewById(w.h.view_plugin_error_tip);
        this.bGJ = (ObservedChangeLinearLayout) view.findViewById(w.h.tab_layout);
        this.bGE = new i(this);
        this.bGF.a(new g(this));
        this.bGH.addView(this.bGE.getView(), 0);
    }

    private void aa(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(w.h.enter_forum_navigation_bar);
        aq.k(this.mNavigationBar, w.e.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(w.l.enter_forum));
        this.bGI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_signall, new h(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds28), 0);
        this.bGI.setLayoutParams(layoutParams);
    }

    public void Wf() {
        Wh();
        if (this.bGE != null) {
            this.bGE.NA();
            if (this.bGE.Wr()) {
                this.bGE.Wq();
            }
        }
    }

    public boolean Wg() {
        if (this.bGE != null) {
            return this.bGE.Wr();
        }
        return false;
    }

    private void Wh() {
        if (this.bGE != null) {
            this.bGE.du(true);
        }
    }

    public void Wi() {
        if (!Wg()) {
            aq.b(this.bGI, w.g.icon_sign_bg_s, w.g.icon_sign_bg);
        } else {
            aq.b(this.bGI, w.g.icon_sign_s, w.g.icon_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            Wf();
            if (this.bGE != null) {
                refreshImage(this.bGE.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.k(this.bGH, w.e.cp_bg_line_d);
        if (this.bGE != null) {
            this.bGE.onChangeSkinType(i);
        }
        if (this.bGF != null) {
            this.bGF.onChangeSkinType(getPageContext(), i);
        }
        if (this.bGG != null) {
            this.bGG.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aq.k(this.mNavigationBar, w.e.cp_bg_line_d);
        }
        Wi();
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
        this.bGK.setPriority(101);
        registerListener(this.bGK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bGE != null) {
            this.bGE.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bGE != null) {
            this.bGE.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bGF != null && this.bGF.getVisibility() == 0 && com.baidu.adp.lib.util.i.hk()) {
            this.bGF.aK(false);
        }
    }

    public RelativeLayout Wj() {
        return this.bGH;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
