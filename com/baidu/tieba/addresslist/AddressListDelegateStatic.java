package com.baidu.tieba.addresslist;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class AddressListDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView agB;

    static {
        a aVar = new a(2007002);
        aVar.setPriority(6);
        MessageManager.getInstance().registerListener(aVar);
        b bVar = new b(2001180);
        bVar.setPriority(6);
        MessageManager.getInstance().registerListener(bVar);
        c cVar = new c(2001189);
        cVar.setPriority(6);
        MessageManager.getInstance().registerListener(cVar);
    }

    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d sE() {
        if (isAvailable()) {
            com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
            dVar.VY = new d();
            dVar.type = 4;
            dVar.VZ = y.contacts;
            return dVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator z(Context context) {
        this.VQ = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, w.fragmenttabindicator, null);
        agB = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.VX = this.VQ;
        cVar.jI = com.baidu.adp.lib.util.m.dip2px(context, 7.0f);
        cVar.view = agB;
        cVar.VV = u.icon_news_down_bar_one;
        agB.setVisibility(8);
        this.VQ.a("addresslist", cVar);
        return this.VQ;
    }
}
