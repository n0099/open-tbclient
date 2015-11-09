package com.baidu.tieba.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView aJD;
    private Boolean aJE = false;
    private CustomMessageListener aJF;

    static {
        s sVar = new s(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        sVar.setPriority(7);
        MessageManager.getInstance().registerListener(sVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.DISCOVER_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.atN = new a();
        cVar.type = 6;
        cVar.atO = i.h.discover;
        cVar.atP = i.e.s_icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(i.g.fragmenttabindicator, (ViewGroup) null);
        this.aJD = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.atM = this.mIndicator;
        aVar.uo = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aJD;
        aVar.atK = i.e.icon_news_down_bar_one;
        if (this.aJE.booleanValue()) {
            this.aJD.setVisibility(0);
        } else {
            this.aJD.setVisibility(8);
        }
        this.mIndicator.a("emotion", aVar);
        return this.mIndicator;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.aJF = new t(this, CmdConfigCustom.MAINTAB_TAB_EMOTION);
        this.aJF.setPriority(7);
        MessageManager.getInstance().registerListener(this.aJF);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        MessageManager.getInstance().unRegisterListener(this.aJF);
    }
}
