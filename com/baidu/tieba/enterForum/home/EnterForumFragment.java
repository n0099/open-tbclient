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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> cPS = new ArrayList();
    final CustomMessageListener cGi = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.aoL()) {
                    d.aoM();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.cPS.contains(currentAccount)) {
                        EnterForumFragment.this.h(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.BL()) {
                        EnterForumFragment.this.h(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.BS())) {
                        TiebaStatic.log(new an("c12594"));
                        EnterForumFragment.this.h(true, activityPrizeData.BS());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.h(false, null);
            }
        }
    };
    private a cPH;
    private ViewGroup cPI;
    private ImageView cPJ;
    private TextView cPK;
    private View cPL;
    private NoNetworkView cPM;
    private PluginErrorTipView cPN;
    private RelativeLayout cPO;
    private ImageView cPP;
    private ObservedChangeLinearLayout cPQ;
    private RelativeLayout cPR;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout aof() {
        return this.cPQ;
    }

    private void am(View view) {
        this.cPO = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        an(view);
        this.cPM = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.cPN = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.cPQ = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.cPH = new a(this);
        this.cPM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aS(boolean z) {
                EnterForumFragment.this.cPH.fd(z);
            }
        });
        this.cPO.addView(this.cPH.getView(), 0);
    }

    private void aog() {
        if (this.cPR == null) {
            ((ViewStub) this.cPO.findViewById(d.g.activity_prize_stub)).inflate();
            this.cPR = (RelativeLayout) this.cPO.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cPR.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.cPR.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.cPR);
            this.cPI = (ViewGroup) this.cPR.findViewById(d.g.activity_root_view);
            this.cPJ = (ImageView) this.cPR.findViewById(d.g.activity_close_view);
            this.cPK = (TextView) this.cPR.findViewById(d.g.activity_tip_view);
            this.cPJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12596"));
                    EnterForumFragment.cPS.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.h(false, null);
                }
            });
            this.cPI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String BO = TbadkCoreApplication.getInst().getActivityPrizeData().BO();
                    if (!StringUtils.isNull(BO)) {
                        TiebaStatic.log(new an("c12595"));
                        az.zV().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{BO}, true);
                    }
                }
            });
        }
    }

    private void an(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        am.j(this.mNavigationBar, d.C0142d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.cPP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.aoi()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bb.aT(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPP.getLayoutParams();
        layoutParams.setMargins(0, 0, l.e(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.cPP.setLayoutParams(layoutParams);
    }

    public void aoh() {
        aoj();
        if (this.cPH != null) {
            this.cPH.SK();
            if (this.cPH.aot()) {
                this.cPH.aos();
            }
        }
    }

    public boolean aoi() {
        if (this.cPH != null) {
            return this.cPH.aot();
        }
        return false;
    }

    private void aoj() {
        if (this.cPH != null) {
            this.cPH.ff(true);
        }
    }

    public void aok() {
        if (!aoi()) {
            am.a(this.cPP, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            am.a(this.cPP, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aoh();
            if (this.cPH != null) {
                refreshImage(this.cPH.getView());
            }
            if (this.cPH != null) {
                this.cPH.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.j(this.cPO, d.C0142d.cp_bg_line_d);
        if (this.cPH != null) {
            this.cPH.onChangeSkinType(i);
        }
        if (this.cPM != null) {
            this.cPM.onChangeSkinType(getPageContext(), i);
        }
        if (this.cPN != null) {
            this.cPN.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            am.j(this.mNavigationBar, d.C0142d.cp_bg_line_d);
        }
        if (this.cPR != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.cPR);
        }
        aok();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.fragment_enter_forum, viewGroup, false);
        am(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cGi.setPriority(101);
        registerListener(this.cGi);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cPH != null) {
            this.cPH.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cPH != null) {
            this.cPH.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cPM != null && this.cPM.getVisibility() == 0 && j.jD()) {
            this.cPM.aR(false);
        }
    }

    public RelativeLayout aol() {
        return this.cPO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, String str) {
        if (z) {
            if (this.cPR == null) {
                aog();
            }
            if (this.cPL == null) {
                this.cPL = this.cPH.aoo();
            }
            this.cPI.setVisibility(0);
            this.cPK.setText(str);
            return;
        }
        if (this.cPR != null) {
            this.cPI.setVisibility(8);
        }
        if (this.cPL != null) {
            this.cPH.ao(this.cPL);
            this.cPL = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
