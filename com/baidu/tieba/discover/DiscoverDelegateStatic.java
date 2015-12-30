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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView aRW;
    private Boolean aRX = false;
    private CustomMessageListener aRY;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.DISCOVER_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.axv = new a();
        cVar.type = 6;
        cVar.axw = n.j.discover;
        cVar.axx = n.f.s_icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(n.h.fragmenttabindicator, (ViewGroup) null);
        this.aRW = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.axu = this.mIndicator;
        aVar.uw = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aRW;
        aVar.axs = n.f.icon_news_down_bar_one;
        if (this.aRX.booleanValue()) {
            this.aRW.setVisibility(0);
        } else {
            this.aRW.setVisibility(8);
        }
        this.mIndicator.a("emotion", aVar);
        return this.mIndicator;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.aRY = new s(this, CmdConfigCustom.MAINTAB_TAB_EMOTION);
        this.aRY.setPriority(7);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        MessageManager.getInstance().unRegisterListener(this.aRY);
    }
}
