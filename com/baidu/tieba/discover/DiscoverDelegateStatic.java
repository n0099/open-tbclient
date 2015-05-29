package com.baidu.tieba.discover;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView aDV;
    private static Boolean aDW = false;

    static {
        s sVar = new s(2007002);
        sVar.setPriority(7);
        MessageManager.getInstance().registerListener(sVar);
        t tVar = new t(2007004);
        tVar.setPriority(7);
        MessageManager.getInstance().registerListener(tVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.DISCOVER_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d AC() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.anf = new a();
        dVar.type = 6;
        dVar.ang = com.baidu.tieba.t.discover;
        dVar.anh = com.baidu.tieba.p.icon_tabbar_discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aj(Context context) {
        this.amS = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.fragmenttabindicator, null);
        aDV = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.ane = this.amS;
        cVar.ur = com.baidu.adp.lib.util.n.dip2px(context, 3.0f);
        cVar.view = aDV;
        cVar.anc = com.baidu.tieba.p.icon_news_down_bar_one;
        if (aDW.booleanValue()) {
            aDV.setVisibility(0);
        } else {
            aDV.setVisibility(8);
        }
        this.amS.a("emotion", cVar);
        return this.amS;
    }
}
