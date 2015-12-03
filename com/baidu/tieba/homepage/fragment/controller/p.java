package com.baidu.tieba.homepage.fragment.controller;

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
public class p extends com.baidu.tbadk.mainTab.b {
    private ImageView aOe;
    private CustomMessageListener aOg;
    private boolean auC;

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.avR = new a();
        cVar.type = 7;
        cVar.avS = n.i.home_page_title;
        cVar.avT = n.e.s_icon_tabbar_homepage;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(n.g.fragmenttabindicator, (ViewGroup) null);
        this.aOe = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.avQ = this.mIndicator;
        aVar.uu = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aOe;
        aVar.avO = n.e.icon_news_down_bar_one;
        this.aOe.setVisibility(8);
        this.mIndicator.a("emotion", aVar);
        return this.mIndicator;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.HOME_PAGE_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.aOg = new q(this, CmdConfigCustom.MAINTAB_TAB_EMOTION);
        this.aOg.setPriority(8);
        MessageManager.getInstance().registerListener(this.aOg);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        MessageManager.getInstance().unRegisterListener(this.aOg);
    }
}
