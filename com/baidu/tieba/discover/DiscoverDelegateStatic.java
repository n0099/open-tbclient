package com.baidu.tieba.discover;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView aBU;
    private static Boolean aBV = false;

    static {
        n nVar = new n(2007002);
        nVar.setPriority(7);
        MessageManager.getInstance().registerListener(nVar);
        o oVar = new o(2007004);
        oVar.setPriority(7);
        MessageManager.getInstance().registerListener(oVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d zQ() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.amd = new a();
        dVar.type = 6;
        dVar.ame = y.discover;
        dVar.alU = com.baidu.tieba.u.icon_tabbar_discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator af(Context context) {
        this.alR = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hH().inflate(context, w.fragmenttabindicator, null);
        aBU = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.amc = this.alR;
        cVar.vf = com.baidu.adp.lib.util.n.dip2px(context, 3.0f);
        cVar.view = aBU;
        cVar.ama = com.baidu.tieba.u.icon_news_down_bar_one;
        if (aBV.booleanValue()) {
            aBU.setVisibility(0);
        } else {
            aBU.setVisibility(8);
        }
        this.alR.a("emotion", cVar);
        return this.alR;
    }
}
