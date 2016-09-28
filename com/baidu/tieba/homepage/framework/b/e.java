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
import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private ObservedChangeLinearLayout bGL;
    private ImageView cEl;
    private ImageView cEm;
    private ImageView cEn;
    private a cEo;
    private com.baidu.tieba.d.c cEp;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener cEq = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cEr = new g(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private View.OnTouchListener aJD = new h(this);
    private a.InterfaceC0058a aMy = new i(this);

    public a amm() {
        return this.cEo;
    }

    public View.OnTouchListener amn() {
        return this.aJD;
    }

    public ObservedChangeLinearLayout XL() {
        return this.bGL;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bGL = observedChangeLinearLayout;
        ar(view);
        this.cEo = new a(context, observedChangeLinearLayout, view2);
        this.cEp = new com.baidu.tieba.d.c(context);
        this.cEp.a(this.aMy);
        amo();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cEr.setTag(bdUniqueId);
        this.cEq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cEr);
        MessageManager.getInstance().registerListener(this.cEq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amo() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                eX(true);
                long j = com.baidu.tbadk.core.sharedPref.b.uh().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.uh().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                eW(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            eX(false);
            eW(false);
            com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("game_is_show_tip", false);
        }
    }

    public boolean amp() {
        return this.cEl != null && this.cEl.getVisibility() == 0;
    }

    public void eW(boolean z) {
        if (z) {
            if (this.cEm.getVisibility() != 0) {
                this.cEm.setVisibility(0);
                eY(true);
                av.c(this.cEm, r.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eY(false);
        this.cEm.setVisibility(8);
    }

    public void eX(boolean z) {
        if (this.cEl != null) {
            if (z) {
                this.cEl.setVisibility(0);
            } else {
                this.cEl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cEl.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds20);
            }
            this.cEl.setLayoutParams(layoutParams);
        }
    }

    private void ar(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(r.g.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.game_tip_view, (View.OnClickListener) null);
        this.cEl = (ImageView) addCustomView.findViewById(r.g.game_button_iv);
        this.cEm = (ImageView) addCustomView.findViewById(r.g.game_tip_msg_iv);
        this.cEl.setOnClickListener(new j(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds16), 0);
        this.cEn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_search, (View.OnClickListener) null);
        this.cEn.setLayoutParams(layoutParams);
        this.cEn.setOnClickListener(new k(this));
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
        av.c(this.cEm, r.f.icon_news_down_bar_one);
        av.b(this.cEl, r.f.icon_game_bg_s, r.f.icon_game_bg);
        av.b(this.cEn, r.f.icon_search_bg_s, r.f.icon_search_bg);
        av.a(this.mCenterIcon, r.f.icon_home_logo, r.f.s_icon_home_logo, r.f.icon_home_logo, i);
    }

    public void onDestroy() {
        if (this.cEo != null) {
            this.cEo.Za();
        }
    }
}
