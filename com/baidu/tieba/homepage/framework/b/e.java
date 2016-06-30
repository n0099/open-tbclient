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
import com.baidu.tieba.d.c;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e {
    private ObservedChangeLinearLayout bsY;
    private ImageView cpU;
    private ImageView cpV;
    private ImageView cpW;
    private a cpX;
    private com.baidu.tieba.d.c cpY;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener cpZ = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cqa = new g(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private View.OnTouchListener aGb = new h(this);
    private c.InterfaceC0054c aYC = new i(this);

    public a agH() {
        return this.cpX;
    }

    public View.OnTouchListener agI() {
        return this.aGb;
    }

    public ObservedChangeLinearLayout RX() {
        return this.bsY;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bsY = observedChangeLinearLayout;
        au(view);
        this.cpX = new a(context, observedChangeLinearLayout, view2);
        this.cpY = new com.baidu.tieba.d.c(context);
        this.cpY.a(this.aYC);
        agJ();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cqa.setTag(bdUniqueId);
        this.cpZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cqa);
        MessageManager.getInstance().registerListener(this.cpZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agJ() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                ez(true);
                long j = com.baidu.tbadk.core.sharedPref.b.sO().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.sO().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                ey(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            ez(false);
            ey(false);
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("game_is_show_tip", false);
        }
    }

    public boolean agK() {
        return this.cpU != null && this.cpU.getVisibility() == 0;
    }

    public void ey(boolean z) {
        if (z) {
            if (this.cpV.getVisibility() != 0) {
                this.cpV.setVisibility(0);
                eA(true);
                av.c(this.cpV, u.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eA(false);
        this.cpV.setVisibility(8);
    }

    public void ez(boolean z) {
        if (this.cpU != null) {
            if (z) {
                this.cpU.setVisibility(0);
            } else {
                this.cpU.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cpU.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds20);
            }
            this.cpU.setLayoutParams(layoutParams);
        }
    }

    private void au(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(u.g.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.game_tip_view, (View.OnClickListener) null);
        this.cpU = (ImageView) addCustomView.findViewById(u.g.game_button_iv);
        this.cpV = (ImageView) addCustomView.findViewById(u.g.game_tip_msg_iv);
        this.cpU.setOnClickListener(new j(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds16), 0);
        this.cpW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_search, (View.OnClickListener) null);
        this.cpW.setLayoutParams(layoutParams);
        this.cpW.setOnClickListener(new k(this));
        this.mNavigationBar.setLoginClickListener(new l(this));
        this.mNavigationBar.setRegisterClickListener(new m(this));
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.mContext);
        if (s != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(s, i);
        }
        av.c(this.cpV, u.f.icon_news_down_bar_one);
        av.a(this.cpU, u.f.icon_game_bg_s, u.f.icon_game_bg);
        av.a(this.cpW, u.f.icon_search_bg_s, u.f.icon_search_bg);
        av.a(this.mCenterIcon, u.f.icon_home_logo, u.f.s_icon_home_logo, u.f.icon_home_logo, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onDestroy() {
        if (this.cpX != null) {
            this.cpX.Xh();
        }
    }
}
