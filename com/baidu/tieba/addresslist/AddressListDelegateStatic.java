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
    private static ImageView agt;

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
    public com.baidu.tbadk.mainTab.d sC() {
        if (isAvailable()) {
            com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
            dVar.VU = new d();
            dVar.type = 4;
            dVar.VV = y.contacts;
            return dVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator z(Context context) {
        this.VM = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, w.fragmenttabindicator, null);
        agt = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.VT = this.VM;
        cVar.jI = com.baidu.adp.lib.util.m.dip2px(context, 7.0f);
        cVar.view = agt;
        cVar.VR = u.icon_news_down_bar_one;
        agt.setVisibility(8);
        this.VM.a("addresslist", cVar);
        return this.VM;
    }
}
