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
    private static List<String> drl = new ArrayList();
    final CustomMessageListener dhC = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.awv()) {
                    d.aww();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.drl.contains(currentAccount)) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.Gi()) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.Gp())) {
                        TiebaStatic.log(new am("c12594"));
                        EnterForumFragment.this.g(true, activityPrizeData.Gp());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.g(false, null);
            }
        }
    };
    private a dra;
    private ViewGroup drb;
    private ImageView drc;
    private TextView drd;
    private View dre;
    private NoNetworkView drf;
    private PluginErrorTipView drg;
    private RelativeLayout drh;
    private ImageView dri;
    private ObservedChangeLinearLayout drj;
    private RelativeLayout drk;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout avR() {
        return this.drj;
    }

    private void aI(View view) {
        this.drh = (RelativeLayout) view.findViewById(e.g.enter_root_layout);
        aJ(view);
        this.drf = (NoNetworkView) view.findViewById(e.g.view_no_network);
        this.drg = (PluginErrorTipView) view.findViewById(e.g.view_plugin_error_tip);
        this.drj = (ObservedChangeLinearLayout) view.findViewById(e.g.tab_layout);
        this.dra = new a(this);
        this.dra.setPageUniqueId(getUniqueId());
        this.drf.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bF(boolean z) {
                EnterForumFragment.this.dra.ga(z);
            }
        });
        this.drh.addView(this.dra.getView(), 0);
    }

    private void avS() {
        if (this.drk == null) {
            ((ViewStub) this.drh.findViewById(e.g.activity_prize_stub)).inflate();
            this.drk = (RelativeLayout) this.drh.findViewById(e.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.drk.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.drk.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.drk);
            this.drb = (ViewGroup) this.drk.findViewById(e.g.activity_root_view);
            this.drc = (ImageView) this.drk.findViewById(e.g.activity_close_view);
            this.drd = (TextView) this.drk.findViewById(e.g.activity_tip_view);
            this.drc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12596"));
                    EnterForumFragment.drl.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.g(false, null);
                }
            });
            this.drb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String Gl = TbadkCoreApplication.getInst().getActivityPrizeData().Gl();
                    if (!StringUtils.isNull(Gl)) {
                        TiebaStatic.log(new am("c12595"));
                        ay.Ef().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{Gl}, true);
                    }
                }
            });
        }
    }

    private void aJ(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.enter_forum_navigation_bar);
        al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.dri = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.avU()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ba.bI(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dri.getLayoutParams();
        layoutParams.setMargins(0, 0, l.h(getPageContext().getPageActivity(), e.C0210e.tbds44), 0);
        this.dri.setLayoutParams(layoutParams);
    }

    public void avT() {
        avV();
        if (this.dra != null) {
            this.dra.loadData();
            if (this.dra.awf()) {
                this.dra.awe();
            }
        }
    }

    public boolean avU() {
        if (this.dra != null) {
            return this.dra.awf();
        }
        return false;
    }

    private void avV() {
        if (this.dra != null) {
            this.dra.gc(true);
        }
    }

    public void avW() {
        if (!avU()) {
            al.a(this.dri, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
        } else {
            al.a(this.dri, e.f.icon_topbar_sign_s, e.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            avT();
            if (this.dra != null) {
                refreshImage(this.dra.getView());
            }
            if (this.dra != null) {
                this.dra.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.drh, e.d.cp_bg_line_d);
        if (this.dra != null) {
            this.dra.onChangeSkinType(i);
        }
        if (this.drf != null) {
            this.drf.onChangeSkinType(getPageContext(), i);
        }
        if (this.drg != null) {
            this.drg.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            al.j(this.mNavigationBar, e.d.cp_bg_line_d);
        }
        if (this.drk != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.drk);
        }
        avW();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.fragment_enter_forum, viewGroup, false);
        aI(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dhC.setPriority(101);
        registerListener(this.dhC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dra != null) {
            this.dra.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dra != null) {
            this.dra.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.drf != null && this.drf.getVisibility() == 0 && j.kV()) {
            this.drf.bE(false);
        }
    }

    public RelativeLayout avX() {
        return this.drh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        if (z) {
            if (this.drk == null) {
                avS();
            }
            if (this.dre == null) {
                this.dre = this.dra.awa();
            }
            this.drb.setVisibility(0);
            this.drd.setText(str);
            return;
        }
        if (this.drk != null) {
            this.drb.setVisibility(8);
        }
        if (this.dre != null) {
            this.dra.aK(this.dre);
            this.dre = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
