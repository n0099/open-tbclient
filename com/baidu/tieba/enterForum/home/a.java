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
    private static List<String> dpo = new ArrayList();
    private b dpd;
    private ViewGroup dpe;
    private ImageView dpf;
    private TextView dpg;
    private View dph;
    private NoNetworkView dpi;
    private PluginErrorTipView dpj;
    private RelativeLayout dpk;
    private ImageView dpl;
    private ObservedChangeLinearLayout dpm;
    private RelativeLayout dpn;
    final CustomMessageListener dpp = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.aqW()) {
                    d.aqX();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.dpo.contains(currentAccount)) {
                        a.this.e(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.Fh()) {
                        a.this.e(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.Fo())) {
                        TiebaStatic.log(new ak("c12594"));
                        a.this.e(true, activityPrizeData.Fo());
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

    public ObservedChangeLinearLayout aqt() {
        return this.dpm;
    }

    private void bF(View view) {
        this.dpk = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        bG(view);
        this.dpi = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.dpj = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.dpm = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.dpd = new b(this);
        this.dpi.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                a.this.dpd.ft(z);
            }
        });
        this.dpk.addView(this.dpd.getView(), 0);
    }

    private void aqu() {
        if (this.dpn == null) {
            ((ViewStub) this.dpk.findViewById(d.g.activity_prize_stub)).inflate();
            this.dpn = (RelativeLayout) this.dpk.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dpn.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.dpn.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.dpn);
            this.dpe = (ViewGroup) this.dpn.findViewById(d.g.activity_root_view);
            this.dpf = (ImageView) this.dpn.findViewById(d.g.activity_close_view);
            this.dpg = (TextView) this.dpn.findViewById(d.g.activity_tip_view);
            this.dpf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.dpo.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.dpe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String Fk = TbadkCoreApplication.getInst().getActivityPrizeData().Fk();
                    if (!StringUtils.isNull(Fk)) {
                        TiebaStatic.log(new ak("c12595"));
                        aw.Dt().a(a.this.getPageContext(), new String[]{Fk}, true);
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
        this.dpl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!a.this.aqw()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ay.aZ(a.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        a.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(a.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dpl.getLayoutParams();
        layoutParams.setMargins(0, 0, l.t(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.dpl.setLayoutParams(layoutParams);
    }

    public void aqv() {
        aqx();
        if (this.dpd != null) {
            this.dpd.Ws();
            if (this.dpd.aqH()) {
                this.dpd.aqG();
            }
        }
    }

    public boolean aqw() {
        if (this.dpd != null) {
            return this.dpd.aqH();
        }
        return false;
    }

    private void aqx() {
        if (this.dpd != null) {
            this.dpd.fv(true);
        }
    }

    public void aqy() {
        if (!aqw()) {
            aj.a(this.dpl, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.dpl, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aqv();
            if (this.dpd != null) {
                refreshImage(this.dpd.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.dpk, d.C0141d.cp_bg_line_d);
        if (this.dpd != null) {
            this.dpd.onChangeSkinType(i);
        }
        if (this.dpi != null) {
            this.dpi.onChangeSkinType(getPageContext(), i);
        }
        if (this.dpj != null) {
            this.dpj.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.t(this.mNavigationBar, d.C0141d.cp_bg_line_d);
        }
        if (this.dpn != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.dpn);
        }
        aqy();
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
        this.dpp.setPriority(101);
        registerListener(this.dpp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dpd != null) {
            this.dpd.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dpd != null) {
            this.dpd.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dpi != null && this.dpi.getVisibility() == 0 && j.oJ()) {
            this.dpi.bt(false);
        }
    }

    public RelativeLayout aqz() {
        return this.dpk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.dpn == null) {
                aqu();
            }
            if (this.dph == null) {
                this.dph = this.dpd.aqC();
            }
            this.dpe.setVisibility(0);
            this.dpg.setText(str);
            return;
        }
        if (this.dpn != null) {
            this.dpe.setVisibility(8);
        }
        if (this.dph != null) {
            this.dpd.bH(this.dph);
            this.dph = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
