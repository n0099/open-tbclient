package com.baidu.tieba.discover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class DiscoverDelegateStatic extends b {
    private static boolean isAdded = false;

    static {
        new CustomMessageListener(2007002) { // from class: com.baidu.tieba.discover.DiscoverDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c ML;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    DiscoverDelegateStatic discoverDelegateStatic = new DiscoverDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(discoverDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (ML = discoverDelegateStatic.ML()) != null) {
                        ML.bam.setArguments(new Bundle());
                    }
                }
            }
        };
        if (!isAdded) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007013));
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c MK() {
        c cVar = new c();
        cVar.bam = new DiscoverFragment();
        cVar.type = 10;
        cVar.aBR = e.j.home_discover;
        cVar.aBS = e.f.s_icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bO(Context context) {
        this.aZY = (FragmentTabIndicator) LayoutInflater.from(context).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.baH = this.aZY;
        aVar.Cd = l.dip2px(context, 3.0f);
        aVar.baF = e.f.icon_news_down_bar_one;
        this.aZY.a("emotion", aVar);
        return this.aZY;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void MJ() {
        isAdded = true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void gy() {
    }
}
