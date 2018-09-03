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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private MessageRedDotView dVM;
    private CustomMessageListener dVN;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Jn() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aRI = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aRJ = f.j.home_recommend;
        cVar.aRK = f.C0146f.s_tabbar_icon_one_bg;
        cVar.jU = f.C0146f.tabbar_home_anim;
        cVar.aRQ = com.baidu.tbadk.mainTab.c.aRO;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c Jo;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (Jo = recommendFrsDelegateStatic.Jo()) != null) {
                        Jo.aRI.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Jm() {
        this.dVN = new CustomMessageListener(2016325) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    TbFragmentTabIndicator.a hl = RecommendFrsDelegateStatic.this.aRu.hl("godFeed");
                    if (hl != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.dVM.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.dVM.refresh(0);
                        RecommendFrsDelegateStatic.this.dVM.setVisibility(0);
                        hl.dF(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dVN);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRu = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(f.h.maintab_bottom_indicator, (ViewGroup) null);
        this.dVM = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.aSf = this.aRu;
        aVar.yX = l.dip2px(context, 12.0f);
        aVar.view = this.dVM;
        this.dVM.setVisibility(8);
        this.aRu.b("godFeed", aVar);
        return this.aRu;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void eX() {
        super.eX();
        MessageManager.getInstance().unRegisterListener(this.dVN);
    }
}
