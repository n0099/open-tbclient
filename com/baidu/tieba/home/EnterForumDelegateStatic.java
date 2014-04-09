package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public final com.baidu.tbadk.mainTab.d a() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new e();
        dVar.c = 1;
        dVar.b = com.baidu.tieba.a.k.home;
        return dVar;
    }

    static {
        n nVar = new n(2007002);
        nVar.a(2);
        com.baidu.adp.framework.c.a().a(nVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public final FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.fragmenttabindicator, (ViewGroup) null);
        return this.b;
    }
}
