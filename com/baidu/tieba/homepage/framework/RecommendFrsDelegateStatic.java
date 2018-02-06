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
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView ehR;
    private CustomMessageListener ehS;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c MU() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.bxZ = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.bya = d.j.home_recommend;
        cVar.byb = d.f.s_tabbar_icon_one_bg;
        cVar.byd = d.f.tabbar_home_anim;
        cVar.byh = com.baidu.tbadk.mainTab.c.byg;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c MV;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (MV = recommendFrsDelegateStatic.MV()) != null) {
                        MV.bxZ.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void MT() {
        this.ehS = new CustomMessageListener(2016325) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    e.a gX = RecommendFrsDelegateStatic.this.bxQ.gX("godFeed");
                    if (gX != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.ehR.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.ehR.setVisibility(0);
                        gX.gB(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ehS);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.e bi(Context context) {
        this.bxQ = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.h.maintab_bottom_indicator, (ViewGroup) null);
        this.ehR = new ImageView(context);
        e.a aVar = new e.a();
        aVar.byu = this.bxQ;
        aVar.aiE = l.dip2px(context, 12.0f);
        aVar.view = this.ehR;
        aVar.bys = d.f.icon_news_down_bar_one;
        this.ehR.setVisibility(8);
        this.bxQ.b("godFeed", aVar);
        return this.bxQ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void kg() {
        super.kg();
        MessageManager.getInstance().unRegisterListener(this.ehS);
    }
}
