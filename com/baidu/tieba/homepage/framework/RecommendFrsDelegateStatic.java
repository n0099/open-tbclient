package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView cvT;
    private CustomMessageListener cvU;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EF() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aDP = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aDQ = w.l.home_recommend;
        cVar.aDR = w.g.s_tabbar_icon_one_bg;
        return cVar;
    }

    static {
        u uVar = new u(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        uVar.setPriority(1);
        MessageManager.getInstance().registerListener(uVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EE() {
        this.cvU = new v(this, CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW);
        MessageManager.getInstance().registerListener(this.cvU);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aN(Context context) {
        this.aDC = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.cvT = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aDO = this.aDC;
        aVar.vk = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.cvT;
        aVar.aDM = w.g.icon_news_down_bar_one;
        this.cvT.setVisibility(8);
        this.aDC.a("godFeed", aVar);
        return this.aDC;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cC() {
        super.cC();
        MessageManager.getInstance().unRegisterListener(this.cvU);
    }
}
