package com.baidu.tieba.home;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d wp() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.acw = new f();
        dVar.type = 1;
        dVar.acx = z.home;
        dVar.acm = com.baidu.tieba.v.icon_tabbar_enterforum;
        return dVar;
    }

    static {
        q qVar = new q(2007002);
        qVar.setPriority(2);
        MessageManager.getInstance().registerListener(qVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator W(Context context) {
        this.acj = (FragmentTabIndicator) com.baidu.adp.lib.g.b.ei().inflate(context, x.fragmenttabindicator, null);
        return this.acj;
    }
}
