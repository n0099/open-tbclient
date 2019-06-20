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
    private MessageRedDotView gaa;
    private CustomMessageListener gab;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c asJ() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.cwo = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.bVW = R.string.home_recommend;
        cVar.kF = R.raw.index;
        cVar.cwu = com.baidu.tbadk.mainTab.c.cws;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c asK;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (asK = recommendFrsDelegateStatic.asK()) != null && !asK.cwo.isAdded()) {
                        asK.cwo.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void asI() {
        this.gab = new CustomMessageListener(2016325) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    TbFragmentTabIndicator.a qy = RecommendFrsDelegateStatic.this.cwa.qy("godFeed");
                    if (qy != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.gaa.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.gaa.refresh(0);
                        RecommendFrsDelegateStatic.this.gaa.setVisibility(0);
                        qy.iW(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cO(Context context) {
        this.cwa = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.gaa = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.cwL = this.cwa;
        aVar.zK = l.dip2px(context, 12.0f);
        aVar.view = this.gaa;
        this.gaa.setVisibility(8);
        this.cwa.b("godFeed", aVar);
        return this.cwa;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void fn() {
        super.fn();
    }
}
