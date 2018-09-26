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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> cYs = new ArrayList();
    final CustomMessageListener cOD = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.ara()) {
                    d.arb();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.cYs.contains(currentAccount)) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.CO()) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.CV())) {
                        TiebaStatic.log(new am("c12594"));
                        EnterForumFragment.this.g(true, activityPrizeData.CV());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.g(false, null);
            }
        }
    };
    private a cYh;
    private ViewGroup cYi;
    private ImageView cYj;
    private TextView cYk;
    private View cYl;
    private NoNetworkView cYm;
    private PluginErrorTipView cYn;
    private RelativeLayout cYo;
    private ImageView cYp;
    private ObservedChangeLinearLayout cYq;
    private RelativeLayout cYr;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout aqu() {
        return this.cYq;
    }

    private void aD(View view) {
        this.cYo = (RelativeLayout) view.findViewById(e.g.enter_root_layout);
        aE(view);
        this.cYm = (NoNetworkView) view.findViewById(e.g.view_no_network);
        this.cYn = (PluginErrorTipView) view.findViewById(e.g.view_plugin_error_tip);
        this.cYq = (ObservedChangeLinearLayout) view.findViewById(e.g.tab_layout);
        this.cYh = new a(this);
        this.cYh.setPageUniqueId(getUniqueId());
        this.cYm.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bd(boolean z) {
                EnterForumFragment.this.cYh.fv(z);
            }
        });
        this.cYo.addView(this.cYh.getView(), 0);
    }

    private void aqv() {
        if (this.cYr == null) {
            ((ViewStub) this.cYo.findViewById(e.g.activity_prize_stub)).inflate();
            this.cYr = (RelativeLayout) this.cYo.findViewById(e.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYr.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.cYr.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.cYr);
            this.cYi = (ViewGroup) this.cYr.findViewById(e.g.activity_root_view);
            this.cYj = (ImageView) this.cYr.findViewById(e.g.activity_close_view);
            this.cYk = (TextView) this.cYr.findViewById(e.g.activity_tip_view);
            this.cYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12596"));
                    EnterForumFragment.cYs.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.g(false, null);
                }
            });
            this.cYi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String CR = TbadkCoreApplication.getInst().getActivityPrizeData().CR();
                    if (!StringUtils.isNull(CR)) {
                        TiebaStatic.log(new am("c12595"));
                        ay.AN().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{CR}, true);
                    }
                }
            });
        }
    }

    private void aE(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.enter_forum_navigation_bar);
        al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.cYp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.aqx()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ba.bz(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYp.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), e.C0141e.tbds44), 0);
        this.cYp.setLayoutParams(layoutParams);
    }

    public void aqw() {
        aqy();
        if (this.cYh != null) {
            this.cYh.loadData();
            if (this.cYh.aqI()) {
                this.cYh.aqH();
            }
        }
    }

    public boolean aqx() {
        if (this.cYh != null) {
            return this.cYh.aqI();
        }
        return false;
    }

    private void aqy() {
        if (this.cYh != null) {
            this.cYh.fx(true);
        }
    }

    public void aqz() {
        if (!aqx()) {
            al.a(this.cYp, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
        } else {
            al.a(this.cYp, e.f.icon_topbar_sign_s, e.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aqw();
            if (this.cYh != null) {
                refreshImage(this.cYh.getView());
            }
            if (this.cYh != null) {
                this.cYh.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.cYo, e.d.cp_bg_line_d);
        if (this.cYh != null) {
            this.cYh.onChangeSkinType(i);
        }
        if (this.cYm != null) {
            this.cYm.onChangeSkinType(getPageContext(), i);
        }
        if (this.cYn != null) {
            this.cYn.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        }
        if (this.cYr != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.cYr);
        }
        aqz();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.fragment_enter_forum, viewGroup, false);
        aD(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cOD.setPriority(101);
        registerListener(this.cOD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cYh != null) {
            this.cYh.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cYh != null) {
            this.cYh.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cYm != null && this.cYm.getVisibility() == 0 && j.kK()) {
            this.cYm.bc(false);
        }
    }

    public RelativeLayout aqA() {
        return this.cYo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        if (z) {
            if (this.cYr == null) {
                aqv();
            }
            if (this.cYl == null) {
                this.cYl = this.cYh.aqD();
            }
            this.cYi.setVisibility(0);
            this.cYk.setText(str);
            return;
        }
        if (this.cYr != null) {
            this.cYi.setVisibility(8);
        }
        if (this.cYl != null) {
            this.cYh.aF(this.cYl);
            this.cYl = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
