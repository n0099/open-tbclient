package com.baidu.tieba.im.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class EnterGroupDelegateStatic extends com.baidu.tbadk.mainTab.b {
    public boolean c() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d a() {
        if (c()) {
            com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
            dVar.a = new b();
            dVar.c = 2;
            dVar.b = y.groups;
            return dVar;
        }
        return null;
    }

    static {
        a aVar = new a(2009002);
        aVar.setPriority(3);
        MessageManager.getInstance().registerListener(aVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator a(Context context) {
        this.b = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.fragmenttabindicator, (ViewGroup) null);
        return this.b;
    }
}
