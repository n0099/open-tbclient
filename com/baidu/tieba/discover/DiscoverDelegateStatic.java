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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class DiscoverDelegateStatic extends b {
    private static boolean bsR = false;

    static {
        new CustomMessageListener(2007002) { // from class: com.baidu.tieba.discover.DiscoverDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c Jo;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    DiscoverDelegateStatic discoverDelegateStatic = new DiscoverDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(discoverDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (Jo = discoverDelegateStatic.Jo()) != null) {
                        Jo.aRI.setArguments(new Bundle());
                    }
                }
            }
        };
        if (!bsR) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007013));
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Jn() {
        c cVar = new c();
        cVar.aRI = new DiscoverFragment();
        cVar.type = 10;
        cVar.aRJ = f.j.home_discover;
        cVar.aRK = f.C0146f.s_icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRu = (FragmentTabIndicator) LayoutInflater.from(context).inflate(f.h.fragmenttabindicator, (ViewGroup) null);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.aSf = this.aRu;
        aVar.yX = l.dip2px(context, 3.0f);
        aVar.aSd = f.C0146f.icon_news_down_bar_one;
        this.aRu.a("emotion", aVar);
        return this.aRu;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Jm() {
        bsR = true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void eX() {
    }
}
