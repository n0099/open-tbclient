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
import com.baidu.tieba.R;
import d.a.m0.e0.b;
import d.a.m0.e0.c;
import d.a.n0.r0.j0;
/* loaded from: classes4.dex */
public class FrsGameStrategyFragmentDelegateStatic extends b {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c fragmentTabStructure;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001616 || customResponsedMessage.getData() == null) {
                return;
            }
            j0 j0Var = (j0) customResponsedMessage.getData();
            FrsGameStrategyFragmentDelegateStatic frsGameStrategyFragmentDelegateStatic = new FrsGameStrategyFragmentDelegateStatic();
            j0Var.a(frsGameStrategyFragmentDelegateStatic);
            if (j0Var.b() == null || (fragmentTabStructure = frsGameStrategyFragmentDelegateStatic.getFragmentTabStructure()) == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("name", j0Var.e());
            bundle.putString("from", "game_frs");
            bundle.putBoolean("back_special", false);
            bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
            fragmentTabStructure.f53008a.setArguments(bundle);
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a(2001616));
    }

    @Override // d.a.m0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f53008a = new FrsGameStrategyMainFragment();
        cVar.f53012e = 3;
        cVar.f53016i = c.k;
        return cVar;
    }

    @Override // d.a.m0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator = fragmentTabIndicator;
        fragmentTabIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    @Override // d.a.m0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
