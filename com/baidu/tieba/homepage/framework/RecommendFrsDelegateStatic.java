package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView cHX;
    private CustomMessageListener cHY;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EJ() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aAd = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aAe = r.j.home_recommend;
        cVar.aAf = r.f.s_tabbar_icon_one_bg;
        return cVar;
    }

    static {
        u uVar = new u(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        uVar.setPriority(1);
        MessageManager.getInstance().registerListener(uVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EI() {
        this.cHY = new v(this, CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW);
        MessageManager.getInstance().registerListener(this.cHY);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ap(Context context) {
        this.azQ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(r.h.fragmenttabindicator, (ViewGroup) null);
        this.cHX = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aAc = this.azQ;
        aVar.nC = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.cHX;
        aVar.aAa = r.f.icon_news_down_bar_one;
        this.cHX.setVisibility(8);
        this.azQ.a("godFeed", aVar);
        return this.azQ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.cHY);
    }
}
