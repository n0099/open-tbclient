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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ab;
/* loaded from: classes3.dex */
public class FrsGameStrategyFragmentDelegateStatic extends b {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyFragmentDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c Jb;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616 && customResponsedMessage.getData() != null) {
                    ab abVar = (ab) customResponsedMessage.getData();
                    FrsGameStrategyFragmentDelegateStatic frsGameStrategyFragmentDelegateStatic = new FrsGameStrategyFragmentDelegateStatic();
                    abVar.b(frsGameStrategyFragmentDelegateStatic);
                    if (abVar.getContext() != null && (Jb = frsGameStrategyFragmentDelegateStatic.Jb()) != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("name", abVar.getForumName());
                        bundle.putString("from", "game_frs");
                        bundle.putBoolean("back_special", false);
                        bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                        Jb.aQP.setArguments(bundle);
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
    public c Ja() {
        c cVar = new c();
        cVar.aQP = new FrsGameStrategyMainFragment();
        cVar.type = 3;
        cVar.aQW = c.aQU;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aQB = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        this.aQB.setTextSize(2.0f);
        return this.aQB;
    }
}
