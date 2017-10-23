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
    private ImageView cXo;
    private CustomMessageListener cXp;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Et() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aGi = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aGj = d.l.home_recommend;
        cVar.aGk = d.g.s_tabbar_icon_one_bg;
        cVar.aGm = d.g.tabbar_home_anim;
        cVar.aGq = com.baidu.tbadk.mainTab.c.aGp;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c Eu;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (Eu = recommendFrsDelegateStatic.Eu()) != null) {
                        Eu.aGi.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Es() {
        this.cXp = new CustomMessageListener(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    e.a gr = RecommendFrsDelegateStatic.this.aFZ.gr("godFeed");
                    if (gr != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.cXo.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.cXo.setVisibility(0);
                        gr.dD(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.cXp);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.e aY(Context context) {
        this.aFZ = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.j.maintab_bottom_indicator, (ViewGroup) null);
        this.cXo = new ImageView(context);
        e.a aVar = new e.a();
        aVar.aGD = this.aFZ;
        aVar.ur = l.dip2px(context, 12.0f);
        aVar.view = this.cXo;
        aVar.aGB = d.g.icon_news_down_bar_one;
        this.cXo.setVisibility(8);
        this.aFZ.a("godFeed", aVar);
        return this.aFZ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.cXp);
    }
}
