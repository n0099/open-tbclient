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
    private ImageView aLt;
    private Boolean aLu = false;
    private CustomMessageListener aLv;

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
    public com.baidu.tbadk.mainTab.c Cz() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.auR = new a();
        cVar.type = 6;
        cVar.auS = i.C0057i.discover;
        cVar.auT = i.e.icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator an(Context context) {
        this.auE = (FragmentTabIndicator) LayoutInflater.from(context).inflate(i.g.fragmenttabindicator, (ViewGroup) null);
        this.aLt = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.auQ = this.auE;
        aVar.uq = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aLt;
        aVar.auO = i.e.icon_news_down_bar_one;
        if (this.aLu.booleanValue()) {
            this.aLt.setVisibility(0);
        } else {
            this.aLt.setVisibility(8);
        }
        this.auE.a("emotion", aVar);
        return this.auE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Cy() {
        this.aLv = new t(this, CmdConfigCustom.MAINTAB_TAB_EMOTION);
        this.aLv.setPriority(7);
        MessageManager.getInstance().registerListener(this.aLv);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ef() {
        MessageManager.getInstance().unRegisterListener(this.aLv);
    }
}
