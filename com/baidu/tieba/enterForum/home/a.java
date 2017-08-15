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
    private NoNetworkView bFB;
    private b bZa;
    private PluginErrorTipView bZb;
    private RelativeLayout bZc;
    private ImageView bZd;
    private ObservedChangeLinearLayout bZe;
    final CustomMessageListener bZf = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && d.acu()) {
                d.acv();
            }
        }
    };
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout abQ() {
        return this.bZe;
    }

    private void af(View view) {
        this.bZc = (RelativeLayout) view.findViewById(d.h.enter_root_layout);
        ag(view);
        this.bFB = (NoNetworkView) view.findViewById(d.h.view_no_network);
        this.bZb = (PluginErrorTipView) view.findViewById(d.h.view_plugin_error_tip);
        this.bZe = (ObservedChangeLinearLayout) view.findViewById(d.h.tab_layout);
        this.bZa = new b(this);
        this.bFB.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                a.this.bZa.ei(z);
            }
        });
        this.bZc.addView(this.bZa.getView(), 0);
    }

    private void ag(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.h.enter_forum_navigation_bar);
        ai.k(this.mNavigationBar, d.e.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.l.enter_forum));
        this.bZd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.abS()) {
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
        this.bZd.setLayoutParams(layoutParams);
    }

    public void abR() {
        abT();
        if (this.bZa != null) {
            this.bZa.Py();
            if (this.bZa.acd()) {
                this.bZa.acc();
            }
        }
    }

    public boolean abS() {
        if (this.bZa != null) {
            return this.bZa.acd();
        }
        return false;
    }

    private void abT() {
        if (this.bZa != null) {
            this.bZa.ek(true);
        }
    }

    public void abU() {
        if (!abS()) {
            ai.b(this.bZd, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
        } else {
            ai.b(this.bZd, d.g.icon_sign_s, d.g.icon_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            abR();
            if (this.bZa != null) {
                refreshImage(this.bZa.getView());
            }
        } else if (!isPrimary() && this.bZa != null) {
            this.bZa.ace();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ai.k(this.bZc, d.e.cp_bg_line_d);
        if (this.bZa != null) {
            this.bZa.onChangeSkinType(i);
        }
        if (this.bFB != null) {
            this.bFB.onChangeSkinType(getPageContext(), i);
        }
        if (this.bZb != null) {
            this.bZb.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            ai.k(this.mNavigationBar, d.e.cp_bg_line_d);
        }
        abU();
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
        this.bZf.setPriority(101);
        registerListener(this.bZf);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bZa != null) {
            this.bZa.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.bZa != null) {
            this.bZa.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bFB != null && this.bFB.getVisibility() == 0 && i.hr()) {
            this.bFB.aL(false);
        }
    }

    public RelativeLayout abV() {
        return this.bZc;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
