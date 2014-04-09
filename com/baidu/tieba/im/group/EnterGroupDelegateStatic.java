package com.baidu.tieba.im.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class EnterGroupDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public final com.baidu.tbadk.mainTab.d a() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new b();
        dVar.c = 2;
        dVar.b = com.baidu.tieba.im.j.groups;
        return dVar;
    }

    static {
        a aVar = new a(2007002);
        aVar.a(3);
        com.baidu.adp.framework.c.a().a(aVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public final FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.im.i.fragmenttabindicator, (ViewGroup) null);
        return this.b;
    }
}
