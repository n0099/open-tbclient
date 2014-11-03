package com.baidu.tieba.discover;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView anM;

    static {
        i iVar = new i(2007002);
        iVar.setPriority(7);
        MessageManager.getInstance().registerListener(iVar);
        j jVar = new j(2007004);
        jVar.setPriority(7);
        MessageManager.getInstance().registerListener(jVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d sE() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.VY = new a();
        dVar.type = 6;
        dVar.VZ = y.discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator z(Context context) {
        this.VQ = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.fragmenttabindicator, null);
        anM = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.VX = this.VQ;
        cVar.jI = com.baidu.adp.lib.util.m.dip2px(context, 3.0f);
        cVar.view = anM;
        cVar.VV = com.baidu.tieba.u.icon_news_down_bar_one;
        anM.setVisibility(8);
        this.VQ.a("emotion", cVar);
        return this.VQ;
    }
}
