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
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class DiscoverDelegateStatic extends b {
    private static boolean isAdded = false;

    static {
        new CustomMessageListener(2007002) { // from class: com.baidu.tieba.discover.DiscoverDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c anH;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    DiscoverDelegateStatic discoverDelegateStatic = new DiscoverDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(discoverDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (anH = discoverDelegateStatic.anH()) != null) {
                        anH.cog.setArguments(new Bundle());
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
    public c anG() {
        c cVar = new c();
        cVar.cog = new DiscoverFragment();
        cVar.type = 10;
        cVar.bOh = d.j.home_discover;
        cVar.bOi = d.f.s_icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator di(Context context) {
        this.cnS = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.coD = this.cnS;
        aVar.Cc = l.dip2px(context, 3.0f);
        aVar.coB = d.f.icon_news_down_bar_one;
        this.cnS.a("emotion", aVar);
        return this.cnS;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void anF() {
        isAdded = true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void gv() {
    }
}
