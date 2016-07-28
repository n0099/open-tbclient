package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Dk() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.awB = new e();
        cVar.type = 1;
        cVar.awC = u.j.home;
        cVar.awD = u.f.s_tabbar_icon_two_bg;
        return cVar;
    }

    static {
        d dVar = new d(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        dVar.setPriority(4);
        MessageManager.getInstance().registerListener(dVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ah(Context context) {
        this.awo = (FragmentTabIndicator) LayoutInflater.from(context).inflate(u.h.fragmenttabindicator, (ViewGroup) null);
        return this.awo;
    }
}
