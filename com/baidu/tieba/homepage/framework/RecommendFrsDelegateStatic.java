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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private MessageRedDotView ghF;
    private CustomMessageListener ghG;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c auf() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.cyG = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.bXX = R.string.home_recommend;
        cVar.kE = R.raw.index;
        cVar.cyM = com.baidu.tbadk.mainTab.c.cyK;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c aug;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (aug = recommendFrsDelegateStatic.aug()) != null && !aug.cyG.isAdded()) {
                        aug.cyG.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void aue() {
        this.ghG = new CustomMessageListener(2016325) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    TbFragmentTabIndicator.a ra = RecommendFrsDelegateStatic.this.cys.ra("godFeed");
                    if (ra != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.ghF.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.ghF.refresh(0);
                        RecommendFrsDelegateStatic.this.ghF.setVisibility(0);
                        ra.jg(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cP(Context context) {
        this.cys = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.ghF = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.czd = this.cys;
        aVar.zQ = l.dip2px(context, 12.0f);
        aVar.view = this.ghF;
        this.ghF.setVisibility(8);
        this.cys.b("godFeed", aVar);
        return this.cys;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void fv() {
        super.fv();
    }
}
