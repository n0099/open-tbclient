package com.baidu.tieba.enterForum.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.model.d;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private NoNetworkView bJn;
    private b ccQ;
    private PluginErrorTipView ccR;
    private RelativeLayout ccS;
    private ImageView ccT;
    private ObservedChangeLinearLayout ccU;
    final CustomMessageListener ccV = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && d.adB()) {
                d.adC();
            }
        }
    };
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout acZ() {
        return this.ccU;
    }

    private void am(View view) {
        this.ccS = (RelativeLayout) view.findViewById(d.h.enter_root_layout);
        an(view);
        this.bJn = (NoNetworkView) view.findViewById(d.h.view_no_network);
        this.ccR = (PluginErrorTipView) view.findViewById(d.h.view_plugin_error_tip);
        this.ccU = (ObservedChangeLinearLayout) view.findViewById(d.h.tab_layout);
        this.ccQ = new b(this);
        this.bJn.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                a.this.ccQ.em(z);
            }
        });
        this.ccS.addView(this.ccQ.getView(), 0);
    }

    private void an(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.h.enter_forum_navigation_bar);
        aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.l.enter_forum));
        this.ccT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.adb()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.aT(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, k.f(getPageContext().getPageActivity(), d.f.ds28), 0);
        this.ccT.setLayoutParams(layoutParams);
    }

    public void ada() {
        adc();
        if (this.ccQ != null) {
            this.ccQ.PP();
            if (this.ccQ.adl()) {
                this.ccQ.adk();
            }
        }
    }

    public boolean adb() {
        if (this.ccQ != null) {
            return this.ccQ.adl();
        }
        return false;
    }

    private void adc() {
        if (this.ccQ != null) {
            this.ccQ.eo(true);
        }
    }

    public void add() {
        if (!adb()) {
            aj.a(this.ccT, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
        } else {
            aj.a(this.ccT, d.g.icon_sign_s, d.g.icon_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            ada();
            if (this.ccQ != null) {
                refreshImage(this.ccQ.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.ccS, d.e.cp_bg_line_d);
        if (this.ccQ != null) {
            this.ccQ.onChangeSkinType(i);
        }
        if (this.bJn != null) {
            this.bJn.onChangeSkinType(getPageContext(), i);
        }
        if (this.ccR != null) {
            this.ccR.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
        }
        add();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.j.fragment_enter_forum, viewGroup, false);
        am(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ccV.setPriority(101);
        registerListener(this.ccV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ccQ != null) {
            this.ccQ.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ccQ != null) {
            this.ccQ.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bJn != null && this.bJn.getVisibility() == 0 && i.hi()) {
            this.bJn.aL(false);
        }
    }

    public RelativeLayout ade() {
        return this.ccS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
