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
    private static List<String> dmJ = new ArrayList();
    private ImageView dmA;
    private TextView dmB;
    private View dmC;
    private NoNetworkView dmD;
    private PluginErrorTipView dmE;
    private RelativeLayout dmF;
    private ImageView dmG;
    private ObservedChangeLinearLayout dmH;
    private RelativeLayout dmI;
    final CustomMessageListener dmK = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.aqh()) {
                    d.aqi();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.dmJ.contains(currentAccount)) {
                        a.this.e(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.EN()) {
                        a.this.e(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.EU())) {
                        TiebaStatic.log(new ak("c12594"));
                        a.this.e(true, activityPrizeData.EU());
                        return;
                    } else {
                        return;
                    }
                }
                a.this.e(false, null);
            }
        }
    };
    private b dmy;
    private ViewGroup dmz;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout apE() {
        return this.dmH;
    }

    private void bG(View view) {
        this.dmF = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        bH(view);
        this.dmD = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.dmE = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.dmH = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.dmy = new b(this);
        this.dmD.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bq(boolean z) {
                a.this.dmy.fm(z);
            }
        });
        this.dmF.addView(this.dmy.getView(), 0);
    }

    private void apF() {
        if (this.dmI == null) {
            ((ViewStub) this.dmF.findViewById(d.g.activity_prize_stub)).inflate();
            this.dmI = (RelativeLayout) this.dmF.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dmI.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.dmI.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.dmI);
            this.dmz = (ViewGroup) this.dmI.findViewById(d.g.activity_root_view);
            this.dmA = (ImageView) this.dmI.findViewById(d.g.activity_close_view);
            this.dmB = (TextView) this.dmI.findViewById(d.g.activity_tip_view);
            this.dmA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.dmJ.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.dmz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String EQ = TbadkCoreApplication.getInst().getActivityPrizeData().EQ();
                    if (!StringUtils.isNull(EQ)) {
                        TiebaStatic.log(new ak("c12595"));
                        av.Da().a(a.this.getPageContext(), new String[]{EQ}, true);
                    }
                }
            });
        }
    }

    private void bH(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        aj.t(this.mNavigationBar, d.C0108d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.dmG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.apH()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.ba(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dmG.getLayoutParams();
        layoutParams.setMargins(0, 0, l.s(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.dmG.setLayoutParams(layoutParams);
    }

    public void apG() {
        apI();
        if (this.dmy != null) {
            this.dmy.VB();
            if (this.dmy.apS()) {
                this.dmy.apR();
            }
        }
    }

    public boolean apH() {
        if (this.dmy != null) {
            return this.dmy.apS();
        }
        return false;
    }

    private void apI() {
        if (this.dmy != null) {
            this.dmy.fo(true);
        }
    }

    public void apJ() {
        if (!apH()) {
            aj.a(this.dmG, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.dmG, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            apG();
            if (this.dmy != null) {
                refreshImage(this.dmy.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.dmF, d.C0108d.cp_bg_line_d);
        if (this.dmy != null) {
            this.dmy.onChangeSkinType(i);
        }
        if (this.dmD != null) {
            this.dmD.onChangeSkinType(getPageContext(), i);
        }
        if (this.dmE != null) {
            this.dmE.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.t(this.mNavigationBar, d.C0108d.cp_bg_line_d);
        }
        if (this.dmI != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.dmI);
        }
        apJ();
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
        this.dmK.setPriority(101);
        registerListener(this.dmK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dmy != null) {
            this.dmy.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dmy != null) {
            this.dmy.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmD != null && this.dmD.getVisibility() == 0 && j.oJ()) {
            this.dmD.bp(false);
        }
    }

    public RelativeLayout apK() {
        return this.dmF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.dmI == null) {
                apF();
            }
            if (this.dmC == null) {
                this.dmC = this.dmy.apN();
            }
            this.dmz.setVisibility(0);
            this.dmB.setText(str);
            return;
        }
        if (this.dmI != null) {
            this.dmz.setVisibility(8);
        }
        if (this.dmC != null) {
            this.dmy.bI(this.dmC);
            this.dmC = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
