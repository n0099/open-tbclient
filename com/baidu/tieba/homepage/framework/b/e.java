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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private ImageView aWH;
    private ObservedChangeLinearLayout bpJ;
    private ImageView coU;
    private ImageView coV;
    private a coW;
    private com.baidu.tieba.d.c coX;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener coY = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener coZ = new g(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private View.OnTouchListener aJN = new h(this);
    private a.InterfaceC0057a aMk = new i(this);

    public a aiH() {
        return this.coW;
    }

    public View.OnTouchListener aiI() {
        return this.aJN;
    }

    public ObservedChangeLinearLayout SY() {
        return this.bpJ;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bpJ = observedChangeLinearLayout;
        ar(view);
        this.coW = new a(context, observedChangeLinearLayout, view2);
        this.coX = new com.baidu.tieba.d.c(context);
        this.coX.a(this.aMk);
        aiJ();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.coZ.setTag(bdUniqueId);
        this.coY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.coZ);
        MessageManager.getInstance().registerListener(this.coY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiJ() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                eX(true);
                long j = com.baidu.tbadk.core.sharedPref.b.tW().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.tW().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                eW(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            eX(false);
            eW(false);
            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("game_is_show_tip", false);
        }
    }

    public boolean aiK() {
        return this.coU != null && this.coU.getVisibility() == 0;
    }

    public void eW(boolean z) {
        if (z) {
            if (this.coV.getVisibility() != 0) {
                this.coV.setVisibility(0);
                eY(true);
                ar.c(this.coV, r.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eY(false);
        this.coV.setVisibility(8);
    }

    public void eX(boolean z) {
        if (this.coU != null) {
            if (z) {
                this.coU.setVisibility(0);
            } else {
                this.coU.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.coU.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds20);
            }
            this.coU.setLayoutParams(layoutParams);
        }
    }

    private void ar(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(r.g.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.game_tip_view, (View.OnClickListener) null);
        this.coU = (ImageView) addCustomView.findViewById(r.g.game_button_iv);
        this.coV = (ImageView) addCustomView.findViewById(r.g.game_tip_msg_iv);
        this.coU.setOnClickListener(new j(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds16), 0);
        this.aWH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_search, (View.OnClickListener) null);
        this.aWH.setLayoutParams(layoutParams);
        this.aWH.setOnClickListener(new k(this));
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
        ar.c(this.coV, r.f.icon_news_down_bar_one);
        ar.b(this.coU, r.f.icon_game_bg_s, r.f.icon_game_bg);
        ar.b(this.aWH, r.f.icon_search_bg_s, r.f.icon_search_bg);
        ar.a(this.mCenterIcon, r.f.icon_home_logo, r.f.s_icon_home_logo, r.f.icon_home_logo, i);
    }

    public void onDestroy() {
        if (this.coW != null) {
            this.coW.Up();
        }
    }
}
