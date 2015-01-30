package com.baidu.tieba.discover;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView aue;

    static {
        n nVar = new n(2007002);
        nVar.setPriority(7);
        MessageManager.getInstance().registerListener(nVar);
        o oVar = new o(2007004);
        oVar.setPriority(7);
        MessageManager.getInstance().registerListener(oVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d wv() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.acz = new a();
        dVar.type = 6;
        dVar.acA = com.baidu.tieba.z.discover;
        dVar.acp = v.icon_tabbar_discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator W(Context context) {
        this.acm = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ei().inflate(context, x.fragmenttabindicator, null);
        aue = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.acy = this.acm;
        cVar.jO = com.baidu.adp.lib.util.l.dip2px(context, 3.0f);
        cVar.view = aue;
        cVar.acw = v.icon_news_down_bar_one;
        aue.setVisibility(8);
        this.acm.a("emotion", cVar);
        return this.acm;
    }
}
