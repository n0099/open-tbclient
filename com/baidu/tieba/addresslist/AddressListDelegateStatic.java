package com.baidu.tieba.addresslist;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class AddressListDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView anS;

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
    public com.baidu.tbadk.mainTab.d wd() {
        if (isAvailable()) {
            com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
            dVar.acb = new d();
            dVar.type = 4;
            dVar.acc = z.contacts;
            dVar.abS = v.icon_tabbar_contact;
            return dVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator W(Context context) {
        this.abP = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, x.fragmenttabindicator, null);
        anS = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aca = this.abP;
        cVar.jM = com.baidu.adp.lib.util.l.dip2px(context, 7.0f);
        cVar.view = anS;
        cVar.abY = v.icon_news_down_bar_one;
        anS.setVisibility(8);
        this.abP.a("addresslist", cVar);
        return this.abP;
    }
}
