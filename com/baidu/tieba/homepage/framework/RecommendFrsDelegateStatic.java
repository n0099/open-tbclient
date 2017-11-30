package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView doG;
    private CustomMessageListener doH;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EY() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aHC = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aHD = d.j.home_recommend;
        cVar.aHE = d.f.s_tabbar_icon_one_bg;
        cVar.aHG = d.f.tabbar_home_anim;
        cVar.aHK = com.baidu.tbadk.mainTab.c.aHJ;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c EZ;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (EZ = recommendFrsDelegateStatic.EZ()) != null) {
                        EZ.aHC.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EX() {
        this.doH = new CustomMessageListener(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    e.a gD = RecommendFrsDelegateStatic.this.aHt.gD("godFeed");
                    if (gD != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.doG.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.doG.setVisibility(0);
                        gD.dE(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.doH);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.e bd(Context context) {
        this.aHt = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.h.maintab_bottom_indicator, (ViewGroup) null);
        this.doG = new ImageView(context);
        e.a aVar = new e.a();
        aVar.aHX = this.aHt;
        aVar.ur = l.dip2px(context, 12.0f);
        aVar.view = this.doG;
        aVar.aHV = d.f.icon_news_down_bar_one;
        this.doG.setVisibility(8);
        this.aHt.a("godFeed", aVar);
        return this.aHt;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.doH);
    }
}
