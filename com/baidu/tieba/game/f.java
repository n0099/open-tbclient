package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ GameCenterHomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GameCenterHomeActivity gameCenterHomeActivity, int i) {
        super(i);
        this.a = gameCenterHomeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        n nVar;
        if (customResponsedMessage.getCmd() == 2001121 && (customResponsedMessage instanceof NetWorkChangeMessage) && ((NetWorkChangeMessage) customResponsedMessage).mState == 2) {
            nVar = this.a.a;
            nVar.f();
        }
    }
}
