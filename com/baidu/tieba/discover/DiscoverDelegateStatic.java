package com.baidu.tieba.discover;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView aBM;
    private static Boolean aBN = false;

    static {
        n nVar = new n(2007002);
        nVar.setPriority(7);
        MessageManager.getInstance().registerListener(nVar);
        o oVar = new o(2007004);
        oVar.setPriority(7);
        MessageManager.getInstance().registerListener(oVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d zK() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.alV = new a();
        dVar.type = 6;
        dVar.alW = y.discover;
        dVar.alM = com.baidu.tieba.u.icon_tabbar_discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator af(Context context) {
        this.alJ = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hH().inflate(context, w.fragmenttabindicator, null);
        aBM = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.alU = this.alJ;
        cVar.vf = com.baidu.adp.lib.util.n.dip2px(context, 3.0f);
        cVar.view = aBM;
        cVar.alS = com.baidu.tieba.u.icon_news_down_bar_one;
        if (aBN.booleanValue()) {
            aBM.setVisibility(0);
        } else {
            aBM.setVisibility(8);
        }
        this.alJ.a("emotion", cVar);
        return this.alJ;
    }
}
