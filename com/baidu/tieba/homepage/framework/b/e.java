package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.e.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    private ObservedChangeLinearLayout bGA;
    private ImageView cDH;
    private ImageView cDI;
    private ImageView cDJ;
    private a cDK;
    private com.baidu.tieba.e.c cDL;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener cDM = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cDN = new g(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private View.OnTouchListener aKe = new h(this);
    private a.InterfaceC0055a aQg = new i(this);

    public a alY() {
        return this.cDK;
    }

    public View.OnTouchListener alZ() {
        return this.aKe;
    }

    public ObservedChangeLinearLayout Xr() {
        return this.bGA;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bGA = observedChangeLinearLayout;
        as(view);
        this.cDK = new a(context, observedChangeLinearLayout, view2);
        this.cDL = new com.baidu.tieba.e.c(context);
        this.cDL.a(this.aQg);
        ama();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cDN.setTag(bdUniqueId);
        this.cDM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cDN);
        MessageManager.getInstance().registerListener(this.cDM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ama() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                eW(true);
                long j = com.baidu.tbadk.core.sharedPref.b.tS().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.tS().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                eV(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            eW(false);
            eV(false);
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("game_is_show_tip", false);
        }
    }

    public boolean amb() {
        return this.cDH != null && this.cDH.getVisibility() == 0;
    }

    public void eV(boolean z) {
        if (z) {
            if (this.cDI.getVisibility() != 0) {
                this.cDI.setVisibility(0);
                eX(true);
                av.c(this.cDI, t.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eX(false);
        this.cDI.setVisibility(8);
    }

    public void eW(boolean z) {
        if (this.cDH != null) {
            if (z) {
                this.cDH.setVisibility(0);
            } else {
                this.cDH.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cDH.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds20);
            }
            this.cDH.setLayoutParams(layoutParams);
        }
    }

    private void as(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(t.g.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.game_tip_view, (View.OnClickListener) null);
        this.cDH = (ImageView) addCustomView.findViewById(t.g.game_button_iv);
        this.cDI = (ImageView) addCustomView.findViewById(t.g.game_tip_msg_iv);
        this.cDH.setOnClickListener(new j(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds16), 0);
        this.cDJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_search, (View.OnClickListener) null);
        this.cDJ.setLayoutParams(layoutParams);
        this.cDJ.setOnClickListener(new k(this));
        this.mNavigationBar.setLoginClickListener(new l(this));
        this.mNavigationBar.setRegisterClickListener(new m(this));
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
        if (C != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(C, i);
        }
        av.c(this.cDI, t.f.icon_news_down_bar_one);
        av.b(this.cDH, t.f.icon_game_bg_s, t.f.icon_game_bg);
        av.b(this.cDJ, t.f.icon_search_bg_s, t.f.icon_search_bg);
        av.a(this.mCenterIcon, t.f.icon_home_logo, t.f.s_icon_home_logo, t.f.icon_home_logo, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onDestroy() {
        if (this.cDK != null) {
            this.cDK.aco();
        }
    }
}
