package com.baidu.tieba.im.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class EnterGroupDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d createFragmentTabStructure() {
        if (isAvailable()) {
            com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
            dVar.a = new b();
            dVar.c = 2;
            dVar.b = com.baidu.tieba.im.j.groups;
            return dVar;
        }
        return null;
    }

    static {
        a aVar = new a(2007002);
        aVar.a(3);
        com.baidu.adp.framework.c.a().a(aVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.im.i.fragmenttabindicator, (ViewGroup) null);
        return this.mIndicator;
    }
}
