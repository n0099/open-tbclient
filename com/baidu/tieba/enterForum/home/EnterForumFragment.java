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
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> cRU = new ArrayList();
    final CustomMessageListener cIo = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.apr()) {
                    d.aps();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.cRU.contains(currentAccount)) {
                        EnterForumFragment.this.h(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.Bu()) {
                        EnterForumFragment.this.h(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.BB())) {
                        TiebaStatic.log(new am("c12594"));
                        EnterForumFragment.this.h(true, activityPrizeData.BB());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.h(false, null);
            }
        }
    };
    private a cRJ;
    private ViewGroup cRK;
    private ImageView cRL;
    private TextView cRM;
    private View cRN;
    private NoNetworkView cRO;
    private PluginErrorTipView cRP;
    private RelativeLayout cRQ;
    private ImageView cRR;
    private ObservedChangeLinearLayout cRS;
    private RelativeLayout cRT;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout aoK() {
        return this.cRS;
    }

    private void ak(View view) {
        this.cRQ = (RelativeLayout) view.findViewById(d.g.enter_root_layout);
        al(view);
        this.cRO = (NoNetworkView) view.findViewById(d.g.view_no_network);
        this.cRP = (PluginErrorTipView) view.findViewById(d.g.view_plugin_error_tip);
        this.cRS = (ObservedChangeLinearLayout) view.findViewById(d.g.tab_layout);
        this.cRJ = new a(this);
        this.cRO.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aQ(boolean z) {
                EnterForumFragment.this.cRJ.fd(z);
            }
        });
        this.cRQ.addView(this.cRJ.getView(), 0);
    }

    private void aoL() {
        if (this.cRT == null) {
            ((ViewStub) this.cRQ.findViewById(d.g.activity_prize_stub)).inflate();
            this.cRT = (RelativeLayout) this.cRQ.findViewById(d.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cRT.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.cRT.setLayoutParams(layoutParams);
            com.baidu.tbadk.n.a.a(getPageContext(), this.cRT);
            this.cRK = (ViewGroup) this.cRT.findViewById(d.g.activity_root_view);
            this.cRL = (ImageView) this.cRT.findViewById(d.g.activity_close_view);
            this.cRM = (TextView) this.cRT.findViewById(d.g.activity_tip_view);
            this.cRL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12596"));
                    EnterForumFragment.cRU.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.h(false, null);
                }
            });
            this.cRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String Bx = TbadkCoreApplication.getInst().getActivityPrizeData().Bx();
                    if (!StringUtils.isNull(Bx)) {
                        TiebaStatic.log(new am("c12595"));
                        ay.zG().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{Bx}, true);
                    }
                }
            });
        }
    }

    private void al(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.enter_forum_navigation_bar);
        al.j(this.mNavigationBar, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.cRR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.aoN()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ba.aT(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cRR.getLayoutParams();
        layoutParams.setMargins(0, 0, l.e(getPageContext().getPageActivity(), d.e.tbds44), 0);
        this.cRR.setLayoutParams(layoutParams);
    }

    public void aoM() {
        aoO();
        if (this.cRJ != null) {
            this.cRJ.So();
            if (this.cRJ.aoY()) {
                this.cRJ.aoX();
            }
        }
    }

    public boolean aoN() {
        if (this.cRJ != null) {
            return this.cRJ.aoY();
        }
        return false;
    }

    private void aoO() {
        if (this.cRJ != null) {
            this.cRJ.ff(true);
        }
    }

    public void aoP() {
        if (!aoN()) {
            al.a(this.cRR, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
        } else {
            al.a(this.cRR, d.f.icon_topbar_sign_s, d.f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aoM();
            if (this.cRJ != null) {
                refreshImage(this.cRJ.getView());
            }
            if (this.cRJ != null) {
                this.cRJ.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.cRQ, d.C0141d.cp_bg_line_d);
        if (this.cRJ != null) {
            this.cRJ.onChangeSkinType(i);
        }
        if (this.cRO != null) {
            this.cRO.onChangeSkinType(getPageContext(), i);
        }
        if (this.cRP != null) {
            this.cRP.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            al.j(this.mNavigationBar, d.C0141d.cp_bg_line_d);
        }
        if (this.cRT != null) {
            com.baidu.tbadk.n.a.a(getPageContext(), this.cRT);
        }
        aoP();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.fragment_enter_forum, viewGroup, false);
        ak(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cIo.setPriority(101);
        registerListener(this.cIo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cRJ != null) {
            this.cRJ.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cRJ != null) {
            this.cRJ.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cRO != null && this.cRO.getVisibility() == 0 && j.jD()) {
            this.cRO.aP(false);
        }
    }

    public RelativeLayout aoQ() {
        return this.cRQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, String str) {
        if (z) {
            if (this.cRT == null) {
                aoL();
            }
            if (this.cRN == null) {
                this.cRN = this.cRJ.aoT();
            }
            this.cRK.setVisibility(0);
            this.cRM.setText(str);
            return;
        }
        if (this.cRT != null) {
            this.cRK.setVisibility(8);
        }
        if (this.cRN != null) {
            this.cRJ.am(this.cRN);
            this.cRN = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
