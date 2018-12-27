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
    private MessageRedDotView ewd;
    private CustomMessageListener ewe;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c NP() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.bdN = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aFs = e.j.home_recommend;
        cVar.aFt = e.f.s_tabbar_icon_one_bg;
        cVar.nk = e.f.tabbar_home_anim;
        cVar.bdT = com.baidu.tbadk.mainTab.c.bdR;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c NQ;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (NQ = recommendFrsDelegateStatic.NQ()) != null) {
                        NQ.bdN.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void NO() {
        this.ewe = new CustomMessageListener(2016325) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    TbFragmentTabIndicator.a ip = RecommendFrsDelegateStatic.this.bdz.ip("godFeed");
                    if (ip != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.ewd.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.ewd.refresh(0);
                        RecommendFrsDelegateStatic.this.ewd.setVisibility(0);
                        ip.eD(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ewe);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.bdz = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(e.h.maintab_bottom_indicator, (ViewGroup) null);
        this.ewd = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.bei = this.bdz;
        aVar.Cd = l.dip2px(context, 12.0f);
        aVar.view = this.ewd;
        this.ewd.setVisibility(8);
        this.bdz.b("godFeed", aVar);
        return this.bdz;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void gy() {
        super.gy();
        MessageManager.getInstance().unRegisterListener(this.ewe);
    }
}
