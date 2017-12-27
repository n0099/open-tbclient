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
    private static List<String> dhN = new ArrayList();
    private b dhC;
    private ViewGroup dhD;
    private ImageView dhE;
    private TextView dhF;
    private View dhG;
    private NoNetworkView dhH;
    private PluginErrorTipView dhI;
    private RelativeLayout dhJ;
    private ImageView dhK;
    private ObservedChangeLinearLayout dhL;
    private RelativeLayout dhM;
    final CustomMessageListener dhO = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.aoZ()) {
                    d.apa();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.dhN.contains(currentAccount)) {
                        a.this.e(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.EU()) {
                        a.this.e(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.Fb())) {
                        TiebaStatic.log(new ak("c12594"));
                        a.this.e(true, activityPrizeData.Fb());
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

    public ObservedChangeLinearLayout aow() {
        return this.dhL;
    }

    private void bE(View view) {
        this.dhJ = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        bF(view);
        this.dhH = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.dhI = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.dhL = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.dhC = new b(this);
        this.dhH.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bp(boolean z) {
                a.this.dhC.fg(z);
            }
        });
        this.dhJ.addView(this.dhC.getView(), 0);
    }

    private void aox() {
        if (this.dhM == null) {
            ((ViewStub) this.dhJ.findViewById(d.g.activity_prize_stub)).inflate();
            this.dhM = (RelativeLayout) this.dhJ.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dhM.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.dhM.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.dhM);
            this.dhD = (ViewGroup) this.dhM.findViewById(d.g.activity_root_view);
            this.dhE = (ImageView) this.dhM.findViewById(d.g.activity_close_view);
            this.dhF = (TextView) this.dhM.findViewById(d.g.activity_tip_view);
            this.dhE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.dhN.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.dhD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String EX = TbadkCoreApplication.getInst().getActivityPrizeData().EX();
                    if (!StringUtils.isNull(EX)) {
                        TiebaStatic.log(new ak("c12595"));
                        av.Di().a(a.this.getPageContext(), new String[]{EX}, true);
                    }
                }
            });
        }
    }

    private void bF(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        aj.t(this.mNavigationBar, d.C0108d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.dhK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.aoz()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.bd(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhK.getLayoutParams();
        layoutParams.setMargins(0, 0, l.s(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.dhK.setLayoutParams(layoutParams);
    }

    public void aoy() {
        aoA();
        if (this.dhC != null) {
            this.dhC.VL();
            if (this.dhC.aoK()) {
                this.dhC.aoJ();
            }
        }
    }

    public boolean aoz() {
        if (this.dhC != null) {
            return this.dhC.aoK();
        }
        return false;
    }

    private void aoA() {
        if (this.dhC != null) {
            this.dhC.fi(true);
        }
    }

    public void aoB() {
        if (!aoz()) {
            aj.a(this.dhK, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.dhK, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aoy();
            if (this.dhC != null) {
                refreshImage(this.dhC.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.dhJ, d.C0108d.cp_bg_line_d);
        if (this.dhC != null) {
            this.dhC.onChangeSkinType(i);
        }
        if (this.dhH != null) {
            this.dhH.onChangeSkinType(getPageContext(), i);
        }
        if (this.dhI != null) {
            this.dhI.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.t(this.mNavigationBar, d.C0108d.cp_bg_line_d);
        }
        if (this.dhM != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.dhM);
        }
        aoB();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_enter_forum, viewGroup, false);
        bE(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dhO.setPriority(101);
        registerListener(this.dhO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dhC != null) {
            this.dhC.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dhC != null) {
            this.dhC.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dhH != null && this.dhH.getVisibility() == 0 && j.oI()) {
            this.dhH.bo(false);
        }
    }

    public RelativeLayout aoC() {
        return this.dhJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.dhM == null) {
                aox();
            }
            if (this.dhG == null) {
                this.dhG = this.dhC.aoF();
            }
            this.dhD.setVisibility(0);
            this.dhF.setText(str);
            return;
        }
        if (this.dhM != null) {
            this.dhD.setVisibility(8);
        }
        if (this.dhG != null) {
            this.dhC.bG(this.dhG);
            this.dhG = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
