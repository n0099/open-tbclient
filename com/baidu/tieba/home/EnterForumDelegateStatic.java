package com.baidu.tieba.home;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d sC() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.VU = new f();
        dVar.type = 1;
        dVar.VV = y.home;
        return dVar;
    }

    static {
        q qVar = new q(2007002);
        qVar.setPriority(2);
        MessageManager.getInstance().registerListener(qVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator z(Context context) {
        this.VM = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.fragmenttabindicator, null);
        return this.VM;
    }
}
