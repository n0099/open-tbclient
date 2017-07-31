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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.model.d;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private NoNetworkView bES;
    private b bYo;
    private PluginErrorTipView bYp;
    private RelativeLayout bYq;
    private ImageView bYr;
    private ObservedChangeLinearLayout bYs;
    final CustomMessageListener bYt = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && d.abZ()) {
                d.aca();
            }
        }
    };
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout abv() {
        return this.bYs;
    }

    private void af(View view) {
        this.bYq = (RelativeLayout) view.findViewById(d.h.enter_root_layout);
        ag(view);
        this.bES = (NoNetworkView) view.findViewById(d.h.view_no_network);
        this.bYp = (PluginErrorTipView) view.findViewById(d.h.view_plugin_error_tip);
        this.bYs = (ObservedChangeLinearLayout) view.findViewById(d.h.tab_layout);
        this.bYo = new b(this);
        this.bES.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                a.this.bYo.eh(z);
            }
        });
        this.bYq.addView(this.bYo.getView(), 0);
    }

    private void ag(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.h.enter_forum_navigation_bar);
        ai.k(this.mNavigationBar, d.e.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.l.enter_forum));
        this.bYr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.abx()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        aw.aN(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, k.g(getPageContext().getPageActivity(), d.f.ds28), 0);
        this.bYr.setLayoutParams(layoutParams);
    }

    public void abw() {
        aby();
        if (this.bYo != null) {
            this.bYo.Pr();
            if (this.bYo.abI()) {
                this.bYo.abH();
            }
        }
    }

    public boolean abx() {
        if (this.bYo != null) {
            return this.bYo.abI();
        }
        return false;
    }

    private void aby() {
        if (this.bYo != null) {
            this.bYo.ej(true);
        }
    }

    public void abz() {
        if (!abx()) {
            ai.b(this.bYr, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
        } else {
            ai.b(this.bYr, d.g.icon_sign_s, d.g.icon_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            abw();
            if (this.bYo != null) {
                refreshImage(this.bYo.getView());
            }
        } else if (!isPrimary() && this.bYo != null) {
            this.bYo.abJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ai.k(this.bYq, d.e.cp_bg_line_d);
        if (this.bYo != null) {
            this.bYo.onChangeSkinType(i);
        }
        if (this.bES != null) {
            this.bES.onChangeSkinType(getPageContext(), i);
        }
        if (this.bYp != null) {
            this.bYp.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            ai.k(this.mNavigationBar, d.e.cp_bg_line_d);
        }
        abz();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.j.fragment_enter_forum, viewGroup, false);
        af(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bYt.setPriority(101);
        registerListener(this.bYt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bYo != null) {
            this.bYo.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bYo != null) {
            this.bYo.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bES != null && this.bES.getVisibility() == 0 && i.hr()) {
            this.bES.aL(false);
        }
    }

    public RelativeLayout abA() {
        return this.bYq;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
