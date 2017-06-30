package com.baidu.tieba.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static boolean isAdded = false;

    static {
        new a(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        if (!isAdded) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS));
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ey() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aFj = new b();
        cVar.type = 10;
        cVar.aFk = w.l.home_discover;
        cVar.aFl = w.g.s_icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aEW = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aFi = this.aEW;
        aVar.uS = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.aFg = w.g.icon_news_down_bar_one;
        this.aEW.a("emotion", aVar);
        return this.aEW;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Ex() {
        isAdded = true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
    }
}
