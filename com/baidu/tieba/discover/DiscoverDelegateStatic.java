package com.baidu.tieba.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView a;

    static {
        e eVar = new e(2007002);
        eVar.a(5);
        com.baidu.adp.framework.c.a().a(eVar);
        f fVar = new f(2007004);
        fVar.a(5);
        com.baidu.adp.framework.c.a().a(fVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new a();
        dVar.c = 5;
        dVar.b = com.baidu.tieba.a.k.discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.fragmenttabindicator, (ViewGroup) null);
        a = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.h = this.mIndicator;
        cVar.c = com.baidu.adp.lib.util.i.a(context, 3.0f);
        cVar.a = a;
        cVar.d = com.baidu.tieba.a.g.icon_news_down_bar_one;
        cVar.e = com.baidu.tieba.a.g.icon_news_down_bar_one_1;
        this.mIndicator.a("emotion", cVar);
        return this.mIndicator;
    }
}
