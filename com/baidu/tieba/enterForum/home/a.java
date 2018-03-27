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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
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
    private static List<String> dpr = new ArrayList();
    private b dpg;
    private ViewGroup dph;
    private ImageView dpi;
    private TextView dpj;
    private View dpk;
    private NoNetworkView dpl;
    private PluginErrorTipView dpm;
    private RelativeLayout dpn;
    private ImageView dpo;
    private ObservedChangeLinearLayout dpp;
    private RelativeLayout dpq;
    final CustomMessageListener dps = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.aqX()) {
                    d.aqY();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.dpr.contains(currentAccount)) {
                        a.this.e(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.Fi()) {
                        a.this.e(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.Fp())) {
                        TiebaStatic.log(new ak("c12594"));
                        a.this.e(true, activityPrizeData.Fp());
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

    public ObservedChangeLinearLayout aqu() {
        return this.dpp;
    }

    private void bF(View view) {
        this.dpn = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        bG(view);
        this.dpl = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.dpm = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.dpp = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.dpg = new b(this);
        this.dpl.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                a.this.dpg.ft(z);
            }
        });
        this.dpn.addView(this.dpg.getView(), 0);
    }

    private void aqv() {
        if (this.dpq == null) {
            ((ViewStub) this.dpn.findViewById(d.g.activity_prize_stub)).inflate();
            this.dpq = (RelativeLayout) this.dpn.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dpq.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.dpq.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.dpq);
            this.dph = (ViewGroup) this.dpq.findViewById(d.g.activity_root_view);
            this.dpi = (ImageView) this.dpq.findViewById(d.g.activity_close_view);
            this.dpj = (TextView) this.dpq.findViewById(d.g.activity_tip_view);
            this.dpi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.dpr.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.dph.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String Fl = TbadkCoreApplication.getInst().getActivityPrizeData().Fl();
                    if (!StringUtils.isNull(Fl)) {
                        TiebaStatic.log(new ak("c12595"));
                        aw.Du().a(a.this.getPageContext(), new String[]{Fl}, true);
                    }
                }
            });
        }
    }

    private void bG(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        aj.t(this.mNavigationBar, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.dpo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.aqx()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ay.aZ(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dpo.getLayoutParams();
        layoutParams.setMargins(0, 0, l.t(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.dpo.setLayoutParams(layoutParams);
    }

    public void aqw() {
        aqy();
        if (this.dpg != null) {
            this.dpg.Wt();
            if (this.dpg.aqI()) {
                this.dpg.aqH();
            }
        }
    }

    public boolean aqx() {
        if (this.dpg != null) {
            return this.dpg.aqI();
        }
        return false;
    }

    private void aqy() {
        if (this.dpg != null) {
            this.dpg.fv(true);
        }
    }

    public void aqz() {
        if (!aqx()) {
            aj.a(this.dpo, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.dpo, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aqw();
            if (this.dpg != null) {
                refreshImage(this.dpg.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.dpn, d.C0141d.cp_bg_line_d);
        if (this.dpg != null) {
            this.dpg.onChangeSkinType(i);
        }
        if (this.dpl != null) {
            this.dpl.onChangeSkinType(getPageContext(), i);
        }
        if (this.dpm != null) {
            this.dpm.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.t(this.mNavigationBar, d.C0141d.cp_bg_line_d);
        }
        if (this.dpq != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.dpq);
        }
        aqz();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_enter_forum, viewGroup, false);
        bF(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dps.setPriority(101);
        registerListener(this.dps);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dpg != null) {
            this.dpg.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dpg != null) {
            this.dpg.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dpl != null && this.dpl.getVisibility() == 0 && j.oJ()) {
            this.dpl.bt(false);
        }
    }

    public RelativeLayout aqA() {
        return this.dpn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.dpq == null) {
                aqv();
            }
            if (this.dpk == null) {
                this.dpk = this.dpg.aqD();
            }
            this.dph.setVisibility(0);
            this.dpj.setText(str);
            return;
        }
        if (this.dpq != null) {
            this.dph.setVisibility(8);
        }
        if (this.dpk != null) {
            this.dpg.bH(this.dpk);
            this.dpk = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
