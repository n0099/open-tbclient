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
    private ImageView cwK;
    private CustomMessageListener cwL;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Fd() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aEh = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aEi = w.l.home_recommend;
        cVar.aEj = w.g.s_tabbar_icon_one_bg;
        return cVar;
    }

    static {
        u uVar = new u(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        uVar.setPriority(1);
        MessageManager.getInstance().registerListener(uVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Fc() {
        this.cwL = new v(this, CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW);
        MessageManager.getInstance().registerListener(this.cwL);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aP(Context context) {
        this.aDU = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.cwK = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aEg = this.aDU;
        aVar.uS = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.cwK;
        aVar.aEe = w.g.icon_news_down_bar_one;
        this.cwK.setVisibility(8);
        this.aDU.a("godFeed", aVar);
        return this.aDU;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.cwL);
    }
}
