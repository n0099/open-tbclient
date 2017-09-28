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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
    private b ccQ;
    private NoNetworkView ccR;
    private PluginErrorTipView ccS;
    private RelativeLayout ccT;
    private ImageView ccU;
    private ObservedChangeLinearLayout ccV;
    final CustomMessageListener ccW = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && d.ado()) {
                d.adp();
            }
        }
    };
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout acM() {
        return this.ccV;
    }

    private void al(View view) {
        this.ccT = (RelativeLayout) view.findViewById(d.h.enter_root_layout);
        am(view);
        this.ccR = (NoNetworkView) view.findViewById(d.h.view_no_network);
        this.ccS = (PluginErrorTipView) view.findViewById(d.h.view_plugin_error_tip);
        this.ccV = (ObservedChangeLinearLayout) view.findViewById(d.h.tab_layout);
        this.ccQ = new b(this);
        this.ccR.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                a.this.ccQ.ef(z);
            }
        });
        this.ccT.addView(this.ccQ.getView(), 0);
    }

    private void am(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.h.enter_forum_navigation_bar);
        aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.l.enter_forum));
        this.ccU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.acO()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.aT(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), d.f.ds28), 0);
        this.ccU.setLayoutParams(layoutParams);
    }

    public void acN() {
        acP();
        if (this.ccQ != null) {
            this.ccQ.Qj();
            if (this.ccQ.acY()) {
                this.ccQ.acX();
            }
        }
    }

    public boolean acO() {
        if (this.ccQ != null) {
            return this.ccQ.acY();
        }
        return false;
    }

    private void acP() {
        if (this.ccQ != null) {
            this.ccQ.eh(true);
        }
    }

    public void acQ() {
        if (!acO()) {
            aj.a(this.ccU, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
        } else {
            aj.a(this.ccU, d.g.icon_sign_s, d.g.icon_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            acN();
            if (this.ccQ != null) {
                refreshImage(this.ccQ.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.ccT, d.e.cp_bg_line_d);
        if (this.ccQ != null) {
            this.ccQ.onChangeSkinType(i);
        }
        if (this.ccR != null) {
            this.ccR.onChangeSkinType(getPageContext(), i);
        }
        if (this.ccS != null) {
            this.ccS.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
        }
        acQ();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.j.fragment_enter_forum, viewGroup, false);
        al(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ccW.setPriority(101);
        registerListener(this.ccW);
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
        if (this.ccR != null && this.ccR.getVisibility() == 0 && j.hh()) {
            this.ccR.aL(false);
        }
    }

    public RelativeLayout acR() {
        return this.ccT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
