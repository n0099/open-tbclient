package com.baidu.tieba.addresslist;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class AddressListDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView c;

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

    public boolean c() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d a() {
        if (c()) {
            com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
            dVar.a = new d();
            dVar.c = 4;
            dVar.b = x.contacts;
            return dVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) com.baidu.adp.lib.e.b.a().a(context, v.fragmenttabindicator, null);
        c = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.h = this.b;
        cVar.c = com.baidu.adp.lib.util.j.a(context, 7.0f);
        cVar.a = c;
        cVar.d = t.icon_news_down_bar_one;
        cVar.e = t.icon_news_down_bar_one_1;
        c.setVisibility(8);
        this.b.a("addresslist", cVar);
        return this.b;
    }
}
