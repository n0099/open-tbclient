package com.baidu.tieba.enterForum.home;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d AC() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.anf = new a();
        dVar.type = 1;
        dVar.ang = t.home;
        dVar.anh = com.baidu.tieba.p.icon_tabbar_enterforum;
        return dVar;
    }

    static {
        s sVar = new s(2007002);
        sVar.setPriority(2);
        MessageManager.getInstance().registerListener(sVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aj(Context context) {
        this.amS = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.fragmenttabindicator, null);
        return this.amS;
    }
}
