package com.baidu.tieba.discover;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView anD;

    static {
        i iVar = new i(2007002);
        iVar.setPriority(7);
        MessageManager.getInstance().registerListener(iVar);
        j jVar = new j(2007004);
        jVar.setPriority(7);
        MessageManager.getInstance().registerListener(jVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d sC() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.VU = new a();
        dVar.type = 6;
        dVar.VV = y.discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator z(Context context) {
        this.VM = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.fragmenttabindicator, null);
        anD = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.VT = this.VM;
        cVar.jI = com.baidu.adp.lib.util.m.dip2px(context, 3.0f);
        cVar.view = anD;
        cVar.VR = com.baidu.tieba.u.icon_news_down_bar_one;
        anD.setVisibility(8);
        this.VM.a("emotion", cVar);
        return this.VM;
    }
}
