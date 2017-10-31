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
    private b cka;
    private NoNetworkView ckb;
    private PluginErrorTipView ckc;
    private RelativeLayout ckd;
    private ImageView cke;
    private ObservedChangeLinearLayout ckf;
    final CustomMessageListener ckg = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && d.afr()) {
                d.afs();
            }
        }
    };
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout aeQ() {
        return this.ckf;
    }

    private void ao(View view) {
        this.ckd = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        ap(view);
        this.ckb = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.ckc = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.ckf = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.cka = new b(this);
        this.ckb.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                a.this.cka.ec(z);
            }
        });
        this.ckd.addView(this.cka.getView(), 0);
    }

    private void ap(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        aj.k(this.mNavigationBar, d.C0080d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.cke = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.aeS()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.aS(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cke.getLayoutParams();
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), d.e.ds34), 0);
        this.cke.setLayoutParams(layoutParams);
    }

    public void aeR() {
        aeT();
        if (this.cka != null) {
            this.cka.Rx();
            if (this.cka.afc()) {
                this.cka.afb();
            }
        }
    }

    public boolean aeS() {
        if (this.cka != null) {
            return this.cka.afc();
        }
        return false;
    }

    private void aeT() {
        if (this.cka != null) {
            this.cka.ee(true);
        }
    }

    public void aeU() {
        if (!aeS()) {
            aj.a(this.cke, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.cke, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aeR();
            if (this.cka != null) {
                refreshImage(this.cka.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.ckd, d.C0080d.cp_bg_line_d);
        if (this.cka != null) {
            this.cka.onChangeSkinType(i);
        }
        if (this.ckb != null) {
            this.ckb.onChangeSkinType(getPageContext(), i);
        }
        if (this.ckc != null) {
            this.ckc.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.k(this.mNavigationBar, d.C0080d.cp_bg_line_d);
        }
        aeU();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_enter_forum, viewGroup, false);
        ao(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ckg.setPriority(101);
        registerListener(this.ckg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cka != null) {
            this.cka.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cka != null) {
            this.cka.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ckb != null && this.ckb.getVisibility() == 0 && j.hh()) {
            this.ckb.aI(false);
        }
    }

    public RelativeLayout aeV() {
        return this.ckd;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
