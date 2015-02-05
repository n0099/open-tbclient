package com.baidu.tieba.discover;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView aub;

    static {
        n nVar = new n(2007002);
        nVar.setPriority(7);
        MessageManager.getInstance().registerListener(nVar);
        o oVar = new o(2007004);
        oVar.setPriority(7);
        MessageManager.getInstance().registerListener(oVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d wp() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.acw = new a();
        dVar.type = 6;
        dVar.acx = com.baidu.tieba.z.discover;
        dVar.acm = v.icon_tabbar_discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator W(Context context) {
        this.acj = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ei().inflate(context, x.fragmenttabindicator, null);
        aub = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.acv = this.acj;
        cVar.jO = com.baidu.adp.lib.util.l.dip2px(context, 3.0f);
        cVar.view = aub;
        cVar.acs = v.icon_news_down_bar_one;
        aub.setVisibility(8);
        this.acj.a("emotion", cVar);
        return this.acj;
    }
}
