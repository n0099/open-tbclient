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
import com.baidu.tieba.enterForum.model.d;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EnterForumFragment extends BaseFragment {
    private static List<String> cSB = new ArrayList();
    final CustomMessageListener cIM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (d.apm()) {
                    d.apn();
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    if (EnterForumFragment.cSB.contains(currentAccount)) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    }
                    com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (!activityPrizeData.BA()) {
                        EnterForumFragment.this.g(false, null);
                        return;
                    } else if (!StringUtils.isNull(activityPrizeData.BH())) {
                        TiebaStatic.log(new an("c12594"));
                        EnterForumFragment.this.g(true, activityPrizeData.BH());
                        return;
                    } else {
                        return;
                    }
                }
                EnterForumFragment.this.g(false, null);
            }
        }
    };
    private RelativeLayout cSA;
    private a cSq;
    private ViewGroup cSr;
    private ImageView cSs;
    private TextView cSt;
    private View cSu;
    private NoNetworkView cSv;
    private PluginErrorTipView cSw;
    private RelativeLayout cSx;
    private ImageView cSy;
    private ObservedChangeLinearLayout cSz;
    private NavigationBar mNavigationBar;

    public ObservedChangeLinearLayout aoF() {
        return this.cSz;
    }

    private void ap(View view) {
        this.cSx = (RelativeLayout) view.findViewById(f.g.enter_root_layout);
        aq(view);
        this.cSv = (NoNetworkView) view.findViewById(f.g.view_no_network);
        this.cSw = (PluginErrorTipView) view.findViewById(f.g.view_plugin_error_tip);
        this.cSz = (ObservedChangeLinearLayout) view.findViewById(f.g.tab_layout);
        this.cSq = new a(this);
        this.cSq.setPageUniqueId(getUniqueId());
        this.cSv.a(new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aR(boolean z) {
                EnterForumFragment.this.cSq.fe(z);
            }
        });
        this.cSx.addView(this.cSq.getView(), 0);
    }

    private void aoG() {
        if (this.cSA == null) {
            ((ViewStub) this.cSx.findViewById(f.g.activity_prize_stub)).inflate();
            this.cSA = (RelativeLayout) this.cSx.findViewById(f.g.activity_root_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cSA.getLayoutParams();
            layoutParams.topMargin = this.mNavigationBar.getFixedNavHeight();
            this.cSA.setLayoutParams(layoutParams);
            com.baidu.tbadk.o.a.a(getPageContext(), this.cSA);
            this.cSr = (ViewGroup) this.cSA.findViewById(f.g.activity_root_view);
            this.cSs = (ImageView) this.cSA.findViewById(f.g.activity_close_view);
            this.cSt = (TextView) this.cSA.findViewById(f.g.activity_tip_view);
            this.cSs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12596"));
                    EnterForumFragment.cSB.add(TbadkCoreApplication.getCurrentAccount());
                    EnterForumFragment.this.g(false, null);
                }
            });
            this.cSr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String BD = TbadkCoreApplication.getInst().getActivityPrizeData().BD();
                    if (!StringUtils.isNull(BD)) {
                        TiebaStatic.log(new an("c12595"));
                        az.zI().a((TbPageContext<?>) EnterForumFragment.this.getPageContext(), new String[]{BD}, true);
                    }
                }
            });
        }
    }

    private void aq(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(f.g.enter_forum_navigation_bar);
        am.j(this.mNavigationBar, f.d.cp_bg_line_d);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(f.j.enter_forum));
        this.mNavigationBar.showBottomLine();
        this.cSy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.widget_nb_item_signall, new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!EnterForumFragment.this.aoI()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bb.aT(EnterForumFragment.this.getPageContext().getPageActivity());
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        EnterForumFragment.this.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(EnterForumFragment.this.getPageContext().getPageActivity())));
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cSy.getLayoutParams();
        layoutParams.setMargins(0, 0, l.f(getPageContext().getPageActivity(), f.e.tbds44), 0);
        this.cSy.setLayoutParams(layoutParams);
    }

    public void aoH() {
        aoJ();
        if (this.cSq != null) {
            this.cSq.loadData();
            if (this.cSq.aoT()) {
                this.cSq.aoS();
            }
        }
    }

    public boolean aoI() {
        if (this.cSq != null) {
            return this.cSq.aoT();
        }
        return false;
    }

    private void aoJ() {
        if (this.cSq != null) {
            this.cSq.fg(true);
        }
    }

    public void aoK() {
        if (!aoI()) {
            am.a(this.cSy, f.C0146f.icon_sign_bg_s, f.C0146f.icon_sign_bg);
        } else {
            am.a(this.cSy, f.C0146f.icon_topbar_sign_s, f.C0146f.icon_topbar_sign_s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aoH();
            if (this.cSq != null) {
                refreshImage(this.cSq.getView());
            }
            if (this.cSq != null) {
                this.cSq.onPrimary();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.j(this.cSx, f.d.cp_bg_line_d);
        if (this.cSq != null) {
            this.cSq.onChangeSkinType(i);
        }
        if (this.cSv != null) {
            this.cSv.onChangeSkinType(getPageContext(), i);
        }
        if (this.cSw != null) {
            this.cSw.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            am.j(this.mNavigationBar, f.d.cp_bg_line_d);
        }
        if (this.cSA != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.cSA);
        }
        aoK();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(f.h.fragment_enter_forum, viewGroup, false);
        ap(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cIM.setPriority(101);
        registerListener(this.cIM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cSq != null) {
            this.cSq.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.cSq != null) {
            this.cSq.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cSv != null && this.cSv.getVisibility() == 0 && j.jE()) {
            this.cSv.aQ(false);
        }
    }

    public RelativeLayout aoL() {
        return this.cSx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        if (z) {
            if (this.cSA == null) {
                aoG();
            }
            if (this.cSu == null) {
                this.cSu = this.cSq.aoO();
            }
            this.cSr.setVisibility(0);
            this.cSt.setText(str);
            return;
        }
        if (this.cSA != null) {
            this.cSr.setVisibility(8);
        }
        if (this.cSu != null) {
            this.cSq.ar(this.cSu);
            this.cSu = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a025";
    }
}
