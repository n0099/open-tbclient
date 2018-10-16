package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private MessageRedDotView ekX;
    private CustomMessageListener ekY;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c MB() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aZz = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aBc = e.j.home_recommend;
        cVar.aBd = e.f.s_tabbar_icon_one_bg;
        cVar.nk = e.f.tabbar_home_anim;
        cVar.aZF = com.baidu.tbadk.mainTab.c.aZD;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c MC;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (MC = recommendFrsDelegateStatic.MC()) != null) {
                        MC.aZz.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void MA() {
        this.ekY = new CustomMessageListener(2016325) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    TbFragmentTabIndicator.a hV = RecommendFrsDelegateStatic.this.aZl.hV("godFeed");
                    if (hV != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.ekX.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.ekX.refresh(0);
                        RecommendFrsDelegateStatic.this.ekX.setVisibility(0);
                        hV.ea(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ekY);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.aZl = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(e.h.maintab_bottom_indicator, (ViewGroup) null);
        this.ekX = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.aZT = this.aZl;
        aVar.Ca = l.dip2px(context, 12.0f);
        aVar.view = this.ekX;
        this.ekX.setVisibility(8);
        this.aZl.b("godFeed", aVar);
        return this.aZl;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void gy() {
        super.gy();
        MessageManager.getInstance().unRegisterListener(this.ekY);
    }
}
