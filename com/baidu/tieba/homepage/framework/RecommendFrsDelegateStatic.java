package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView cRD;
    private CustomMessageListener cRE;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EW() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aHG = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aHH = d.l.home_recommend;
        cVar.aHI = d.g.s_tabbar_icon_one_bg;
        cVar.aHM = com.baidu.tbadk.mainTab.c.aHJ;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c EX;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (EX = recommendFrsDelegateStatic.EX()) != null) {
                        EX.aHG.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EV() {
        this.cRE = new CustomMessageListener(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    FragmentTabIndicator.a gx = RecommendFrsDelegateStatic.this.aHt.gx("godFeed");
                    if (gx != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.cRD.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.cRD.setVisibility(0);
                        gx.dt(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.cRE);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aT(Context context) {
        this.aHt = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.cRD = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aHF = this.aHt;
        aVar.ww = k.dip2px(context, 12.0f);
        aVar.view = this.cRD;
        aVar.aHD = d.g.icon_news_down_bar_one;
        this.cRD.setVisibility(8);
        this.aHt.a("godFeed", aVar);
        return this.aHt;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cM() {
        super.cM();
        MessageManager.getInstance().unRegisterListener(this.cRE);
    }
}
