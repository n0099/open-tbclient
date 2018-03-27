package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c MU() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.bxP = new a();
        cVar.type = 1;
        cVar.bxQ = d.j.enter_forum;
        cVar.bxR = d.f.s_tabbar_icon_two_bg;
        cVar.bxX = com.baidu.tbadk.mainTab.c.bxW;
        cVar.bxT = d.f.tabbar_enterforum_anim;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c MV;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(enterForumDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (MV = enterForumDelegateStatic.MV()) != null) {
                        MV.bxP.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(2);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bi(Context context) {
        this.bxG = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.h.maintab_bottom_indicator, (ViewGroup) null);
        return this.bxG;
    }
}
