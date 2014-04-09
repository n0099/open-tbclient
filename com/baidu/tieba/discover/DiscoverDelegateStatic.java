package com.baidu.tieba.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView c;

    static {
        f fVar = new f(2007002);
        fVar.a(5);
        com.baidu.adp.framework.c.a().a(fVar);
        g gVar = new g(2007004);
        gVar.a(5);
        com.baidu.adp.framework.c.a().a(gVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public final com.baidu.tbadk.mainTab.d a() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new a();
        dVar.c = 5;
        dVar.b = com.baidu.tieba.a.k.discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public final FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.fragmenttabindicator, (ViewGroup) null);
        c = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.h = this.b;
        cVar.c = com.baidu.adp.lib.util.i.a(context, 3.0f);
        cVar.a = c;
        cVar.d = com.baidu.tieba.a.g.icon_news_down_bar_one;
        cVar.e = com.baidu.tieba.a.g.icon_news_down_bar_one_1;
        c.setVisibility(8);
        this.b.a("emotion", cVar);
        return this.b;
    }
}
