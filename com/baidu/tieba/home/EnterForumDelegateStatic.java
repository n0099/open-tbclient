package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d a() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new e();
        dVar.c = 1;
        dVar.b = x.home;
        return dVar;
    }

    static {
        o oVar = new o(2007002);
        oVar.setPriority(2);
        MessageManager.getInstance().registerListener(oVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(v.fragmenttabindicator, (ViewGroup) null);
        return this.b;
    }
}
