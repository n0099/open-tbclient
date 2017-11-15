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
    private static List<String> cky = new ArrayList();
    private b ckn;
    private ViewGroup cko;
    private ImageView ckp;
    private TextView ckq;
    private View ckr;
    private NoNetworkView cks;
    private PluginErrorTipView ckt;
    private RelativeLayout cku;
    private ImageView ckv;
    private ObservedChangeLinearLayout ckw;
    private RelativeLayout ckx;
    final CustomMessageListener ckz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.afF()) {
                    d.afG();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.cky.contains(currentAccount)) {
                        a.this.e(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.xv()) {
                        a.this.e(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.xB())) {
                        TiebaStatic.log(new ak("c12594"));
                        a.this.e(true, activityPrizeData.xB());
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

    public ObservedChangeLinearLayout afc() {
        return this.ckw;
    }

    private void ao(View view) {
        this.cku = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        ap(view);
        this.cks = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.ckt = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.ckw = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.ckn = new b(this);
        this.cks.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                a.this.ckn.eh(z);
            }
        });
        this.cku.addView(this.ckn.getView(), 0);
    }

    private void afd() {
        if (this.ckx == null) {
            ((ViewStub) this.cku.findViewById(d.g.activity_prize_stub)).inflate();
            this.ckx = (RelativeLayout) this.cku.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ckx.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.ckx.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.ckx);
            this.cko = (ViewGroup) this.ckx.findViewById(d.g.activity_root_view);
            this.ckp = (ImageView) this.ckx.findViewById(d.g.activity_close_view);
            this.ckq = (TextView) this.ckx.findViewById(d.g.activity_tip_view);
            this.ckp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.cky.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.cko.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String xx = TbadkCoreApplication.getInst().getActivityPrizeData().xx();
                    if (!StringUtils.isNull(xx)) {
                        TiebaStatic.log(new ak("c12595"));
                        av.vI().a(a.this.getPageContext(), new String[]{xx}, true);
                    }
                }
            });
        }
    }

    private void ap(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        aj.k(this.mNavigationBar, d.C0080d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.ckv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.aff()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ax.aS(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ckv.getLayoutParams();
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), d.e.ds34), 0);
        this.ckv.setLayoutParams(layoutParams);
    }

    public void afe() {
        afg();
        if (this.ckn != null) {
            this.ckn.RG();
            if (this.ckn.afq()) {
                this.ckn.afp();
            }
        }
    }

    public boolean aff() {
        if (this.ckn != null) {
            return this.ckn.afq();
        }
        return false;
    }

    private void afg() {
        if (this.ckn != null) {
            this.ckn.ej(true);
        }
    }

    public void afh() {
        if (!aff()) {
            aj.a(this.ckv, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.ckv, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            afe();
            if (this.ckn != null) {
                refreshImage(this.ckn.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.cku, d.C0080d.cp_bg_line_d);
        if (this.ckn != null) {
            this.ckn.onChangeSkinType(i);
        }
        if (this.cks != null) {
            this.cks.onChangeSkinType(getPageContext(), i);
        }
        if (this.ckt != null) {
            this.ckt.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.k(this.mNavigationBar, d.C0080d.cp_bg_line_d);
        }
        if (this.ckx != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.ckx);
        }
        afh();
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
        this.ckz.setPriority(101);
        registerListener(this.ckz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ckn != null) {
            this.ckn.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ckn != null) {
            this.ckn.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cks != null && this.cks.getVisibility() == 0 && j.hh()) {
            this.cks.aI(false);
        }
    }

    public RelativeLayout afi() {
        return this.cku;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.ckx == null) {
                afd();
            }
            this.ckr = this.ckn.afl();
            this.cko.setVisibility(0);
            this.ckq.setText(str);
            return;
        }
        if (this.ckx != null) {
            this.cko.setVisibility(8);
        }
        if (this.ckr != null) {
            this.ckn.aq(this.ckr);
            this.ckr = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
