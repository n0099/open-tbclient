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
    private NoNetworkView bIw;
    private b cbY;
    private PluginErrorTipView cbZ;
    private RelativeLayout cca;
    private ImageView ccb;
    private ObservedChangeLinearLayout ccc;
    final CustomMessageListener ccd = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && d.adq()) {
                d.adr();
            }
        }
    };
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout acO() {
        return this.ccc;
    }

    private void am(View view) {
        this.cca = (RelativeLayout) view.findViewById(d.h.enter_root_layout);
        an(view);
        this.bIw = (NoNetworkView) view.findViewById(d.h.view_no_network);
        this.cbZ = (PluginErrorTipView) view.findViewById(d.h.view_plugin_error_tip);
        this.ccc = (ObservedChangeLinearLayout) view.findViewById(d.h.tab_layout);
        this.cbY = new b(this);
        this.bIw.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                a.this.cbY.el(z);
            }
        });
        this.cca.addView(this.cbY.getView(), 0);
    }

    private void an(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.h.enter_forum_navigation_bar);
        aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.l.enter_forum));
        this.ccb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.acQ()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.aS(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, k.g(getPageContext().getPageActivity(), d.f.ds28), 0);
        this.ccb.setLayoutParams(layoutParams);
    }

    public void acP() {
        acR();
        if (this.cbY != null) {
            this.cbY.PN();
            if (this.cbY.ada()) {
                this.cbY.acZ();
            }
        }
    }

    public boolean acQ() {
        if (this.cbY != null) {
            return this.cbY.ada();
        }
        return false;
    }

    private void acR() {
        if (this.cbY != null) {
            this.cbY.en(true);
        }
    }

    public void acS() {
        if (!acQ()) {
            aj.a(this.ccb, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
        } else {
            aj.a(this.ccb, d.g.icon_sign_s, d.g.icon_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            acP();
            if (this.cbY != null) {
                refreshImage(this.cbY.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.cca, d.e.cp_bg_line_d);
        if (this.cbY != null) {
            this.cbY.onChangeSkinType(i);
        }
        if (this.bIw != null) {
            this.bIw.onChangeSkinType(getPageContext(), i);
        }
        if (this.cbZ != null) {
            this.cbZ.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.k(this.mNavigationBar, d.e.cp_bg_line_d);
        }
        acS();
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
        this.ccd.setPriority(101);
        registerListener(this.ccd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cbY != null) {
            this.cbY.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cbY != null) {
            this.cbY.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bIw != null && this.bIw.getVisibility() == 0 && i.hi()) {
            this.bIw.aL(false);
        }
    }

    public RelativeLayout acT() {
        return this.cca;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
