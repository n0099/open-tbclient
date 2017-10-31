package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c EF() {
        c cVar = new c();
        cVar.aGS = new a();
        cVar.type = 1;
        cVar.aGT = d.j.enter_forum;
        cVar.aGU = d.f.s_tabbar_icon_two_bg;
        cVar.aHa = c.aGZ;
        cVar.aGW = d.f.tabbar_enterforum_anim;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c EG;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(enterForumDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (EG = enterForumDelegateStatic.EG()) != null) {
                        EG.aGS.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(2);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aY(Context context) {
        this.aGJ = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.h.maintab_bottom_indicator, (ViewGroup) null);
        return this.aGJ;
    }
}
