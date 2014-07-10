package com.baidu.tieba.addresslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
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
            dVar.b = y.contacts;
            return dVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.fragmenttabindicator, (ViewGroup) null);
        c = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.h = this.b;
        cVar.c = com.baidu.adp.lib.util.j.a(context, 7.0f);
        cVar.a = c;
        cVar.d = u.icon_news_down_bar_one;
        cVar.e = u.icon_news_down_bar_one_1;
        c.setVisibility(8);
        this.b.a("addresslist", cVar);
        return this.b;
    }
}
