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
    private static List<String> dpA = new ArrayList();
    final CustomMessageListener dpB = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.aqX()) {
                    d.aqY();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (a.dpA.contains(currentAccount)) {
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
    private b dpp;
    private ViewGroup dpq;
    private ImageView dpr;
    private TextView dps;
    private View dpt;
    private NoNetworkView dpu;
    private PluginErrorTipView dpv;
    private RelativeLayout dpw;
    private ImageView dpx;
    private ObservedChangeLinearLayout dpy;
    private RelativeLayout dpz;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout aqu() {
        return this.dpy;
    }

    private void bF(View view) {
        this.dpw = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        bG(view);
        this.dpu = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.dpv = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.dpy = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.dpp = new b(this);
        this.dpu.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.a.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                a.this.dpp.ft(z);
            }
        });
        this.dpw.addView(this.dpp.getView(), 0);
    }

    private void aqv() {
        if (this.dpz == null) {
            ((ViewStub) this.dpw.findViewById(d.g.activity_prize_stub)).inflate();
            this.dpz = (RelativeLayout) this.dpw.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dpz.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.dpz.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.dpz);
            this.dpq = (ViewGroup) this.dpz.findViewById(d.g.activity_root_view);
            this.dpr = (ImageView) this.dpz.findViewById(d.g.activity_close_view);
            this.dps = (TextView) this.dpz.findViewById(d.g.activity_tip_view);
            this.dpr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12596"));
                    a.dpA.add(TbadkCoreApplication.getCurrentAccount());
                    a.this.e(false, null);
                }
            });
            this.dpq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.3
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
        aj.t(this.mNavigationBar, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.dpx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.a.4
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dpx.getLayoutParams();
        layoutParams.setMargins(0, 0, l.t(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.dpx.setLayoutParams(layoutParams);
    }

    public void aqw() {
        aqy();
        if (this.dpp != null) {
            this.dpp.Wt();
            if (this.dpp.aqI()) {
                this.dpp.aqH();
            }
        }
    }

    public boolean aqx() {
        if (this.dpp != null) {
            return this.dpp.aqI();
        }
        return false;
    }

    private void aqy() {
        if (this.dpp != null) {
            this.dpp.fv(true);
        }
    }

    public void aqz() {
        if (!aqx()) {
            aj.a(this.dpx, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            aj.a(this.dpx, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aqw();
            if (this.dpp != null) {
                refreshImage(this.dpp.getView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.t(this.dpw, d.C0140d.cp_bg_line_d);
        if (this.dpp != null) {
            this.dpp.onChangeSkinType(i);
        }
        if (this.dpu != null) {
            this.dpu.onChangeSkinType(getPageContext(), i);
        }
        if (this.dpv != null) {
            this.dpv.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            aj.t(this.mNavigationBar, d.C0140d.cp_bg_line_d);
        }
        if (this.dpz != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.dpz);
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
        this.dpB.setPriority(101);
        registerListener(this.dpB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dpp != null) {
            this.dpp.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dpp != null) {
            this.dpp.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dpu != null && this.dpu.getVisibility() == 0 && j.oJ()) {
            this.dpu.bt(false);
        }
    }

    public RelativeLayout aqA() {
        return this.dpw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (z) {
            if (this.dpz == null) {
                aqv();
            }
            if (this.dpt == null) {
                this.dpt = this.dpp.aqD();
            }
            this.dpq.setVisibility(0);
            this.dps.setText(str);
            return;
        }
        if (this.dpz != null) {
            this.dpq.setVisibility(8);
        }
        if (this.dpt != null) {
            this.dpp.bH(this.dpt);
            this.dpt = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
