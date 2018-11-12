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
/* loaded from: classes4.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> dhN = new ArrayList();
    final CustomMessageListener cYa = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.atV()) {
                    d.atW();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.dhN.contains(currentAccount)) {
                        EnterForumFragment.this.f(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.Fd()) {
                        EnterForumFragment.this.f(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.Fk())) {
                        TiebaStatic.log(new am("c12594"));
                        EnterForumFragment.this.f(true, activityPrizeData.Fk());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.f(false, null);
            }
        }
    };
    private a dhC;
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
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout atq() {
        return this.dhL;
    }

    private void aF(View view) {
        this.dhJ = (RelativeLayout) view.findViewById(e.g.enter_root_layout);
        aG(view);
        this.dhH = (NoNetworkView) view.findViewById(e.g.view_no_network);
        this.dhI = (PluginErrorTipView) view.findViewById(e.g.view_plugin_error_tip);
        this.dhL = (ObservedChangeLinearLayout) view.findViewById(e.g.tab_layout);
        this.dhC = new a(this);
        this.dhC.setPageUniqueId(getUniqueId());
        this.dhH.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bE(boolean z) {
                EnterForumFragment.this.dhC.fX(z);
            }
        });
        this.dhJ.addView(this.dhC.getView(), 0);
    }

    private void atr() {
        if (this.dhM == null) {
            ((ViewStub) this.dhJ.findViewById(e.g.activity_prize_stub)).inflate();
            this.dhM = (RelativeLayout) this.dhJ.findViewById(e.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dhM.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.dhM.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.dhM);
            this.dhD = (ViewGroup) this.dhM.findViewById(e.g.activity_root_view);
            this.dhE = (ImageView) this.dhM.findViewById(e.g.activity_close_view);
            this.dhF = (TextView) this.dhM.findViewById(e.g.activity_tip_view);
            this.dhE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12596"));
                    EnterForumFragment.dhN.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.f(false, null);
                }
            });
            this.dhD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String Fg = TbadkCoreApplication.getInst().getActivityPrizeData().Fg();
                    if (!StringUtils.isNull(Fg)) {
                        TiebaStatic.log(new am("c12595"));
                        ay.Db().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{Fg}, true);
                    }
                }
            });
        }
    }

    private void aG(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.enter_forum_navigation_bar);
        al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.dhK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.att()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ba.bF(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhK.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), e.C0200e.tbds44), 0);
        this.dhK.setLayoutParams(layoutParams);
    }

    public void ats() {
        atu();
        if (this.dhC != null) {
            this.dhC.loadData();
            if (this.dhC.atE()) {
                this.dhC.atD();
            }
        }
    }

    public boolean att() {
        if (this.dhC != null) {
            return this.dhC.atE();
        }
        return false;
    }

    private void atu() {
        if (this.dhC != null) {
            this.dhC.fZ(true);
        }
    }

    public void atv() {
        if (!att()) {
            al.a(this.dhK, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
        } else {
            al.a(this.dhK, e.f.icon_topbar_sign_s, e.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            ats();
            if (this.dhC != null) {
                refreshImage(this.dhC.getView());
            }
            if (this.dhC != null) {
                this.dhC.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.dhJ, e.d.cp_bg_line_d);
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
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        }
        if (this.dhM != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.dhM);
        }
        atv();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.fragment_enter_forum, viewGroup, false);
        aF(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cYa.setPriority(101);
        registerListener(this.cYa);
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
        if (this.dhH != null && this.dhH.getVisibility() == 0 && j.kV()) {
            this.dhH.bD(false);
        }
    }

    public RelativeLayout atw() {
        return this.dhJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        if (z) {
            if (this.dhM == null) {
                atr();
            }
            if (this.dhG == null) {
                this.dhG = this.dhC.atz();
            }
            this.dhD.setVisibility(0);
            this.dhF.setText(str);
            return;
        }
        if (this.dhM != null) {
            this.dhD.setVisibility(8);
        }
        if (this.dhG != null) {
            this.dhC.aH(this.dhG);
            this.dhG = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
