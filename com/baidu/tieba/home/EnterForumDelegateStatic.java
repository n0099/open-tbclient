package com.baidu.tieba.home;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d wd() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.acb = new f();
        dVar.type = 1;
        dVar.acc = z.home;
        dVar.abS = com.baidu.tieba.v.icon_tabbar_enterforum;
        return dVar;
    }

    static {
        r rVar = new r(2007002);
        rVar.setPriority(2);
        MessageManager.getInstance().registerListener(rVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator W(Context context) {
        this.abP = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.fragmenttabindicator, null);
        return this.abP;
    }
}
