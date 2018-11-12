package com.baidu.tieba.frs.game.strategy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ad;
/* loaded from: classes3.dex */
public class FrsGameStrategyFragmentDelegateStatic extends b {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyFragmentDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c ML;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616 && customResponsedMessage.getData() != null) {
                    ad adVar = (ad) customResponsedMessage.getData();
                    FrsGameStrategyFragmentDelegateStatic frsGameStrategyFragmentDelegateStatic = new FrsGameStrategyFragmentDelegateStatic();
                    adVar.b(frsGameStrategyFragmentDelegateStatic);
                    if (adVar.getContext() != null && (ML = frsGameStrategyFragmentDelegateStatic.ML()) != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("name", adVar.getForumName());
                        bundle.putString("from", "game_frs");
                        bundle.putBoolean("back_special", false);
                        bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                        ML.bam.setArguments(bundle);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c MK() {
        c cVar = new c();
        cVar.bam = new FrsGameStrategyMainFragment();
        cVar.type = 3;
        cVar.bat = c.bap;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bO(Context context) {
        this.aZY = (FragmentTabIndicator) LayoutInflater.from(context).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        this.aZY.setTextSize(2.0f);
        return this.aZY;
    }
}
