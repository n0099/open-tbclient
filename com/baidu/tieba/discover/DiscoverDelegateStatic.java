package com.baidu.tieba.discover;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView asX;

    static {
        n nVar = new n(2007002);
        nVar.setPriority(7);
        MessageManager.getInstance().registerListener(nVar);
        o oVar = new o(2007004);
        oVar.setPriority(7);
        MessageManager.getInstance().registerListener(oVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d wd() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.acb = new a();
        dVar.type = 6;
        dVar.acc = z.discover;
        dVar.abS = com.baidu.tieba.v.icon_tabbar_discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator W(Context context) {
        this.abP = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.fragmenttabindicator, null);
        asX = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aca = this.abP;
        cVar.jM = com.baidu.adp.lib.util.l.dip2px(context, 3.0f);
        cVar.view = asX;
        cVar.abY = com.baidu.tieba.v.icon_news_down_bar_one;
        asX.setVisibility(8);
        this.abP.a("emotion", cVar);
        return this.abP;
    }
}
