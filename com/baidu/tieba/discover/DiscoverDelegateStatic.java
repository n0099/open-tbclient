package com.baidu.tieba.discover;

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
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView c;

    static {
        f fVar = new f(2009002);
        fVar.setPriority(5);
        MessageManager.getInstance().registerListener(fVar);
        g gVar = new g(2009004);
        gVar.setPriority(5);
        MessageManager.getInstance().registerListener(gVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d a() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new a();
        dVar.c = 5;
        dVar.b = y.discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.fragmenttabindicator, (ViewGroup) null);
        c = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.h = this.b;
        cVar.c = com.baidu.adp.lib.util.k.a(context, 3.0f);
        cVar.a = c;
        cVar.d = u.icon_news_down_bar_one;
        cVar.e = u.icon_news_down_bar_one_1;
        c.setVisibility(8);
        this.b.a("emotion", cVar);
        return this.b;
    }
}
