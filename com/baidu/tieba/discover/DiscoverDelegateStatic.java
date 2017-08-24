package com.baidu.tieba.discover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static boolean isAdded = false;

    static {
        new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.discover.DiscoverDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c EX;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    DiscoverDelegateStatic discoverDelegateStatic = new DiscoverDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(discoverDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (EX = discoverDelegateStatic.EX()) != null) {
                        EX.aHI.setArguments(new Bundle());
                    }
                }
            }
        };
        if (!isAdded) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS));
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c EW() {
        c cVar = new c();
        cVar.aHI = new a();
        cVar.type = 10;
        cVar.aHJ = d.l.home_discover;
        cVar.aHK = d.g.s_icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aT(Context context) {
        this.aHv = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aHH = this.aHv;
        aVar.wy = k.dip2px(context, 3.0f);
        aVar.aHF = d.g.icon_news_down_bar_one;
        this.aHv.a("emotion", aVar);
        return this.aHv;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EV() {
        isAdded = true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cM() {
    }
}
