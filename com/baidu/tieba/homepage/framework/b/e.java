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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    private ImageView aYs;
    private TbPageContext<?> ajF;
    private ObservedChangeLinearLayout bEB;
    private ImageView cxv;
    private ImageView cxw;
    private a cxx;
    private com.baidu.tieba.e.c cxy;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener cxz = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cxA = new g(this, CmdConfigCustom.CMD_GAME_CENTER_INIT);
    private View.OnTouchListener aNR = new h(this);
    private a.InterfaceC0056a aQW = new i(this);

    public a ajb() {
        return this.cxx;
    }

    public View.OnTouchListener ajc() {
        return this.aNR;
    }

    public ObservedChangeLinearLayout Vr() {
        return this.bEB;
    }

    public e(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.bEB = observedChangeLinearLayout;
        au(view);
        this.cxx = new a(context, observedChangeLinearLayout, view2);
        this.cxy = new com.baidu.tieba.e.c(context);
        this.cxy.a(this.aQW);
        ajd();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cxA.setTag(bdUniqueId);
        this.cxz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cxA);
        MessageManager.getInstance().registerListener(this.cxz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajd() {
        if (com.baidu.adp.lib.b.e.eT().ab("android_game_enter_switch") == 1 && p.aec) {
            eS(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        eS(false);
        eR(false);
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("game_is_show_tip", false);
    }

    public boolean aje() {
        return this.cxv != null && this.cxv.getVisibility() == 0;
    }

    public void eR(boolean z) {
        if (z) {
            if (this.cxw.getVisibility() != 0) {
                this.cxw.setVisibility(0);
                eT(true);
                aq.c(this.cxw, w.g.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eT(false);
        this.cxw.setVisibility(8);
    }

    public void eS(boolean z) {
        if (this.cxv != null) {
            if (z) {
                this.cxv.setVisibility(0);
            } else {
                this.cxv.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cxv.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds20);
            }
            this.cxv.setLayoutParams(layoutParams);
        }
    }

    private void au(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(w.h.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.game_tip_view, (View.OnClickListener) null);
        this.cxv = (ImageView) addCustomView.findViewById(w.h.game_button_iv);
        this.cxw = (ImageView) addCustomView.findViewById(w.h.game_tip_msg_iv);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16), 0);
        this.aYs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
        this.aYs.setLayoutParams(layoutParams);
        this.aYs.setOnClickListener(new j(this));
        this.mNavigationBar.setLoginClickListener(new k(this));
        this.mNavigationBar.setRegisterClickListener(new l(this));
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.adp.base.g<?> aa = com.baidu.adp.base.k.aa(this.mContext);
        if (aa != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(aa, i);
        }
        aq.c(this.cxw, w.g.icon_news_down_bar_one);
        aq.b(this.cxv, w.g.icon_game_bg_s, w.g.icon_game_bg);
        aq.b(this.aYs, w.g.icon_search_bg_s, w.g.icon_search_bg);
        aq.a(this.mCenterIcon, w.g.icon_home_logo, w.g.s_icon_home_logo, w.g.icon_home_logo, i);
    }

    public void onDestroy() {
        if (this.cxx != null) {
            this.cxx.WI();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.ajF = tbPageContext;
        if (this.cxv != null) {
            this.cxv.setOnClickListener(new m(this));
        }
    }
}
