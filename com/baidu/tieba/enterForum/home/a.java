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
    private static List<String> ctl = new ArrayList();
    private b cta;
    private ViewGroup ctb;
    private ImageView ctc;
    private TextView ctd;
    private View cte;
    private NoNetworkView ctf;
    private PluginErrorTipView ctg;
    private RelativeLayout cth;
    private ImageView cti;
    private ObservedChangeLinearLayout ctj;
    private RelativeLayout ctk;
    final CustomMessageListener ctm = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.ahz()) {
                    d.ahA();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.ctl.contains(currentAccount)) {
                        a.this.e(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.xv()) {
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

    public ObservedChangeLinearLayout agW() {
        return this.ctj;
    }

    private void aq(View view) {
        this.cth = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        ar(view);
        this.ctf = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.ctg = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.ctj = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.cta = new b(this);
        this.ctf.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                a.this.cta.ez(z);
            }
        });
        this.cth.addView(this.cta.getView(), 0);
    }

    private void agX() {
        if (this.ctk == null) {
            ((ViewStub) this.cth.findViewById(d.g.activity_prize_stub)).inflate();
            this.ctk = (RelativeLayout) this.cth.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ctk.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.ctk.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.ctk);
            this.ctb = (ViewGroup) this.ctk.findViewById(d.g.activity_root_view);
            this.ctc = (ImageView) this.ctk.findViewById(d.g.activity_close_view);
            this.ctd = (TextView) this.ctk.findViewById(d.g.activity_tip_view);
            this.ctc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.ctl.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.ctb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String xy = TbadkCoreApplication.getInst().getActivityPrizeData().xy();
                    if (!StringUtils.isNull(xy)) {
                        TiebaStatic.log(new ak("c12595"));
                        av.vI().a(a.this.getPageContext(), new String[]{xy}, true);
                    }
                }
            });
        }
    }

    private void ar(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        aj.k(this.mNavigationBar, d.C0096d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.cti = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.agZ()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.aR(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cti.getLayoutParams();
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.cti.setLayoutParams(layoutParams);
    }

    public void agY() {
        aha();
        if (this.cta != null) {
            this.cta.Om();
            if (this.cta.ahk()) {
                this.cta.ahj();
            }
        }
    }

    public boolean agZ() {
        if (this.cta != null) {
            return this.cta.ahk();
        }
        return false;
    }

    private void aha() {
        if (this.cta != null) {
            this.cta.eB(true);
        }
    }

    public void ahb() {
        if (!agZ()) {
            aj.a(this.cti, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.cti, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            agY();
            if (this.cta != null) {
                refreshImage(this.cta.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.cth, d.C0096d.cp_bg_line_d);
        if (this.cta != null) {
            this.cta.onChangeSkinType(i);
        }
        if (this.ctf != null) {
            this.ctf.onChangeSkinType(getPageContext(), i);
        }
        if (this.ctg != null) {
            this.ctg.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.k(this.mNavigationBar, d.C0096d.cp_bg_line_d);
        }
        if (this.ctk != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.ctk);
        }
        ahb();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_enter_forum, viewGroup, false);
        aq(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctm.setPriority(101);
        registerListener(this.ctm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cta != null) {
            this.cta.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cta != null) {
            this.cta.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ctf != null && this.ctf.getVisibility() == 0 && j.hh()) {
            this.ctf.aI(false);
        }
    }

    public RelativeLayout ahc() {
        return this.cth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.ctk == null) {
                agX();
            }
            if (this.cte == null) {
                this.cte = this.cta.ahf();
            }
            this.ctb.setVisibility(0);
            this.ctd.setText(str);
            return;
        }
        if (this.ctk != null) {
            this.ctb.setVisibility(8);
        }
        if (this.cte != null) {
            this.cta.as(this.cte);
            this.cte = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
