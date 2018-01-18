package com.baidu.tieba.enterForum.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseFragment {
    private static List<String> dmo = new ArrayList();
    private b dmd;
    private ViewGroup dme;
    private ImageView dmf;
    private TextView dmg;
    private View dmh;
    private NoNetworkView dmi;
    private PluginErrorTipView dmj;
    private RelativeLayout dmk;
    private ImageView dml;
    private ObservedChangeLinearLayout dmm;
    private RelativeLayout dmn;
    final CustomMessageListener dmp = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.aqc()) {
                    d.aqd();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.dmo.contains(currentAccount)) {
                        a.this.e(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.EL()) {
                        a.this.e(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.ES())) {
                        TiebaStatic.log(new ak("c12594"));
                        a.this.e(true, activityPrizeData.ES());
                        return;
                    } else {
                        return;
                    }
                }
                a.this.e(false, null);
            }
        }
    };
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout apz() {
        return this.dmm;
    }

    private void bG(View view) {
        this.dmk = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        bH(view);
        this.dmi = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.dmj = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.dmm = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.dmd = new b(this);
        this.dmi.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bp(boolean z) {
                a.this.dmd.fk(z);
            }
        });
        this.dmk.addView(this.dmd.getView(), 0);
    }

    private void apA() {
        if (this.dmn == null) {
            ((ViewStub) this.dmk.findViewById(d.g.activity_prize_stub)).inflate();
            this.dmn = (RelativeLayout) this.dmk.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dmn.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.dmn.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.dmn);
            this.dme = (ViewGroup) this.dmn.findViewById(d.g.activity_root_view);
            this.dmf = (ImageView) this.dmn.findViewById(d.g.activity_close_view);
            this.dmg = (TextView) this.dmn.findViewById(d.g.activity_tip_view);
            this.dmf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.dmo.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.dme.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String EO = TbadkCoreApplication.getInst().getActivityPrizeData().EO();
                    if (!StringUtils.isNull(EO)) {
                        TiebaStatic.log(new ak("c12595"));
                        av.CZ().a(a.this.getPageContext(), new String[]{EO}, true);
                    }
                }
            });
        }
    }

    private void bH(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        aj.t(this.mNavigationBar, d.C0107d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.dml = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.apC()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.bd(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dml.getLayoutParams();
        layoutParams.setMargins(0, 0, l.s(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.dml.setLayoutParams(layoutParams);
    }

    public void apB() {
        apD();
        if (this.dmd != null) {
            this.dmd.Vz();
            if (this.dmd.apN()) {
                this.dmd.apM();
            }
        }
    }

    public boolean apC() {
        if (this.dmd != null) {
            return this.dmd.apN();
        }
        return false;
    }

    private void apD() {
        if (this.dmd != null) {
            this.dmd.fm(true);
        }
    }

    public void apE() {
        if (!apC()) {
            aj.a(this.dml, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.dml, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            apB();
            if (this.dmd != null) {
                refreshImage(this.dmd.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.dmk, d.C0107d.cp_bg_line_d);
        if (this.dmd != null) {
            this.dmd.onChangeSkinType(i);
        }
        if (this.dmi != null) {
            this.dmi.onChangeSkinType(getPageContext(), i);
        }
        if (this.dmj != null) {
            this.dmj.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.t(this.mNavigationBar, d.C0107d.cp_bg_line_d);
        }
        if (this.dmn != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.dmn);
        }
        apE();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_enter_forum, viewGroup, false);
        bG(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dmp.setPriority(101);
        registerListener(this.dmp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dmd != null) {
            this.dmd.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dmd != null) {
            this.dmd.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmi != null && this.dmi.getVisibility() == 0 && j.oI()) {
            this.dmi.bo(false);
        }
    }

    public RelativeLayout apF() {
        return this.dmk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.dmn == null) {
                apA();
            }
            if (this.dmh == null) {
                this.dmh = this.dmd.apI();
            }
            this.dme.setVisibility(0);
            this.dmg.setText(str);
            return;
        }
        if (this.dmn != null) {
            this.dme.setVisibility(8);
        }
        if (this.dmh != null) {
            this.dmd.bI(this.dmh);
            this.dmh = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
