package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private MessageRedDotView ghd;
    private CustomMessageListener ghe;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c avy() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.frag = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.textResId = R.string.home_recommend;
        cVar.animationResId = R.raw.index;
        cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWBOTH;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c avz;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (avz = recommendFrsDelegateStatic.avz()) != null && !avz.frag.isAdded()) {
                        avz.frag.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.ghe = new CustomMessageListener(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    TbFragmentTabIndicator.a qa = RecommendFrsDelegateStatic.this.cKb.qa("godFeed");
                    if (qa != null) {
                        if (intValue <= 0) {
                            RecommendFrsDelegateStatic.this.ghd.setVisibility(8);
                            return;
                        }
                        RecommendFrsDelegateStatic.this.ghd.refresh(0);
                        RecommendFrsDelegateStatic.this.ghd.setVisibility(0);
                        qa.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                    }
                }
            }
        };
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cKb = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.ghd = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.cKv = this.cKb;
        aVar.offsetX = l.dip2px(context, 12.0f);
        aVar.view = this.ghd;
        this.ghd.setVisibility(8);
        this.cKb.b("godFeed", aVar);
        return this.cKb;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
    }
}
