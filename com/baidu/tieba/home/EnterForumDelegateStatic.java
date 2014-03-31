package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new e();
        dVar.c = 1;
        dVar.b = com.baidu.tieba.a.k.home;
        return dVar;
    }

    static {
        m mVar = new m(2007002);
        mVar.a(2);
        com.baidu.adp.framework.c.a().a(mVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.fragmenttabindicator, (ViewGroup) null);
        return this.mIndicator;
    }
}
