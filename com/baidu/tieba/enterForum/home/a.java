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
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private static List<String> ctc = new ArrayList();
    private b csR;
    private ViewGroup csS;
    private ImageView csT;
    private TextView csU;
    private View csV;
    private NoNetworkView csW;
    private PluginErrorTipView csX;
    private RelativeLayout csY;
    private ImageView csZ;
    private ObservedChangeLinearLayout cta;
    private RelativeLayout ctb;
    final CustomMessageListener ctd = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.ahr()) {
                    d.ahs();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.ctc.contains(currentAccount)) {
                        a.this.e(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.xw()) {
                        a.this.e(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.xC())) {
                        TiebaStatic.log(new ak("c12594"));
                        a.this.e(true, activityPrizeData.xC());
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

    public ObservedChangeLinearLayout agO() {
        return this.cta;
    }

    private void ap(View view) {
        this.csY = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        aq(view);
        this.csW = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.csX = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.cta = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.csR = new b(this);
        this.csW.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                a.this.csR.ey(z);
            }
        });
        this.csY.addView(this.csR.getView(), 0);
    }

    private void agP() {
        if (this.ctb == null) {
            ((ViewStub) this.csY.findViewById(d.g.activity_prize_stub)).inflate();
            this.ctb = (RelativeLayout) this.csY.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ctb.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.ctb.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.ctb);
            this.csS = (ViewGroup) this.ctb.findViewById(d.g.activity_root_view);
            this.csT = (ImageView) this.ctb.findViewById(d.g.activity_close_view);
            this.csU = (TextView) this.ctb.findViewById(d.g.activity_tip_view);
            this.csT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.ctc.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.csS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String xy = TbadkCoreApplication.getInst().getActivityPrizeData().xy();
                    if (!StringUtils.isNull(xy)) {
                        TiebaStatic.log(new ak("c12595"));
                        av.vL().a(a.this.getPageContext(), new String[]{xy}, true);
                    }
                }
            });
        }
    }

    private void aq(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        aj.k(this.mNavigationBar, d.C0082d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.csZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.agR()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.aU(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csZ.getLayoutParams();
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.csZ.setLayoutParams(layoutParams);
    }

    public void agQ() {
        agS();
        if (this.csR != null) {
            this.csR.Om();
            if (this.csR.ahc()) {
                this.csR.ahb();
            }
        }
    }

    public boolean agR() {
        if (this.csR != null) {
            return this.csR.ahc();
        }
        return false;
    }

    private void agS() {
        if (this.csR != null) {
            this.csR.eA(true);
        }
    }

    public void agT() {
        if (!agR()) {
            aj.a(this.csZ, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.csZ, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            agQ();
            if (this.csR != null) {
                refreshImage(this.csR.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.csY, d.C0082d.cp_bg_line_d);
        if (this.csR != null) {
            this.csR.onChangeSkinType(i);
        }
        if (this.csW != null) {
            this.csW.onChangeSkinType(getPageContext(), i);
        }
        if (this.csX != null) {
            this.csX.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.k(this.mNavigationBar, d.C0082d.cp_bg_line_d);
        }
        if (this.ctb != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.ctb);
        }
        agT();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_enter_forum, viewGroup, false);
        ap(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctd.setPriority(101);
        registerListener(this.ctd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.csR != null) {
            this.csR.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.csR != null) {
            this.csR.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.csW != null && this.csW.getVisibility() == 0 && j.hh()) {
            this.csW.aI(false);
        }
    }

    public RelativeLayout agU() {
        return this.csY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.ctb == null) {
                agP();
            }
            this.csV = this.csR.agX();
            this.csS.setVisibility(0);
            this.csU.setText(str);
            return;
        }
        if (this.ctb != null) {
            this.csS.setVisibility(8);
        }
        if (this.csV != null) {
            this.csR.ar(this.csV);
            this.csV = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
