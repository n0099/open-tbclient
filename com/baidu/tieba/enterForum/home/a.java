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
    private static List<String> ctp = new ArrayList();
    private b cte;
    private ViewGroup ctf;
    private ImageView ctg;
    private TextView cth;
    private View cti;
    private NoNetworkView ctj;
    private PluginErrorTipView ctk;
    private RelativeLayout ctl;
    private ImageView ctm;
    private ObservedChangeLinearLayout ctn;
    private RelativeLayout cto;
    final CustomMessageListener ctq = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.ahy()) {
                    d.ahz();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.ctp.contains(currentAccount)) {
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

    public ObservedChangeLinearLayout agV() {
        return this.ctn;
    }

    private void ar(View view) {
        this.ctl = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        as(view);
        this.ctj = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.ctk = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.ctn = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.cte = new b(this);
        this.ctj.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                a.this.cte.ez(z);
            }
        });
        this.ctl.addView(this.cte.getView(), 0);
    }

    private void agW() {
        if (this.cto == null) {
            ((ViewStub) this.ctl.findViewById(d.g.activity_prize_stub)).inflate();
            this.cto = (RelativeLayout) this.ctl.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cto.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.cto.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.cto);
            this.ctf = (ViewGroup) this.cto.findViewById(d.g.activity_root_view);
            this.ctg = (ImageView) this.cto.findViewById(d.g.activity_close_view);
            this.cth = (TextView) this.cto.findViewById(d.g.activity_tip_view);
            this.ctg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.ctp.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.ctf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
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

    private void as(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        aj.k(this.mNavigationBar, d.C0095d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.ctm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.agY()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.aR(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ctm.getLayoutParams();
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.ctm.setLayoutParams(layoutParams);
    }

    public void agX() {
        agZ();
        if (this.cte != null) {
            this.cte.Om();
            if (this.cte.ahj()) {
                this.cte.ahi();
            }
        }
    }

    public boolean agY() {
        if (this.cte != null) {
            return this.cte.ahj();
        }
        return false;
    }

    private void agZ() {
        if (this.cte != null) {
            this.cte.eB(true);
        }
    }

    public void aha() {
        if (!agY()) {
            aj.a(this.ctm, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.ctm, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            agX();
            if (this.cte != null) {
                refreshImage(this.cte.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.ctl, d.C0095d.cp_bg_line_d);
        if (this.cte != null) {
            this.cte.onChangeSkinType(i);
        }
        if (this.ctj != null) {
            this.ctj.onChangeSkinType(getPageContext(), i);
        }
        if (this.ctk != null) {
            this.ctk.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.k(this.mNavigationBar, d.C0095d.cp_bg_line_d);
        }
        if (this.cto != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.cto);
        }
        aha();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_enter_forum, viewGroup, false);
        ar(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctq.setPriority(101);
        registerListener(this.ctq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cte != null) {
            this.cte.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cte != null) {
            this.cte.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ctj != null && this.ctj.getVisibility() == 0 && j.hh()) {
            this.ctj.aI(false);
        }
    }

    public RelativeLayout ahb() {
        return this.ctl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.cto == null) {
                agW();
            }
            if (this.cti == null) {
                this.cti = this.cte.ahe();
            }
            this.ctf.setVisibility(0);
            this.cth.setText(str);
            return;
        }
        if (this.cto != null) {
            this.ctf.setVisibility(8);
        }
        if (this.cti != null) {
            this.cte.at(this.cti);
            this.cti = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
