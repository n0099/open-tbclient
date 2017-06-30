package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ey() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aFj = new e();
        cVar.type = 1;
        cVar.aFk = w.l.home;
        cVar.aFl = w.g.s_tabbar_icon_two_bg;
        return cVar;
    }

    static {
        d dVar = new d(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        dVar.setPriority(2);
        MessageManager.getInstance().registerListener(dVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aEW = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        return this.aEW;
    }
}
