package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d a() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.a = new e();
        dVar.c = 1;
        dVar.b = y.home;
        return dVar;
    }

    static {
        p pVar = new p(2009002);
        pVar.setPriority(2);
        MessageManager.getInstance().registerListener(pVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.fragmenttabindicator, (ViewGroup) null);
        return this.b;
    }
}
