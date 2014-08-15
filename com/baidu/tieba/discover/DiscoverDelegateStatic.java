package com.baidu.tieba.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class DiscoverDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static ImageView c;

    static {
        i iVar = new i(2007002);
        iVar.setPriority(7);
        MessageManager.getInstance().registerListener(iVar);
        j jVar = new j(2007004);
        jVar.setPriority(7);
        MessageManager.getInstance().registerListener(jVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d a() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new a();
        dVar.c = 6;
        dVar.b = x.discover;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.v.fragmenttabindicator, (ViewGroup) null);
        c = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.h = this.b;
        cVar.c = com.baidu.adp.lib.util.j.a(context, 3.0f);
        cVar.a = c;
        cVar.d = com.baidu.tieba.t.icon_news_down_bar_one;
        cVar.e = com.baidu.tieba.t.icon_news_down_bar_one_1;
        c.setVisibility(8);
        this.b.a("emotion", cVar);
        return this.b;
    }
}
