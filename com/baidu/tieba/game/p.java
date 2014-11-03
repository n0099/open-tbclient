package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ GameDetailActivity aHn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(GameDetailActivity gameDetailActivity, int i) {
        super(i);
        this.aHn = gameDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        if (customResponsedMessage.getCmd() == 2001121 && (customResponsedMessage instanceof NetWorkChangeMessage) && ((NetWorkChangeMessage) customResponsedMessage).mState == 2) {
            yVar = this.aHn.aHi;
            yVar.Hp();
        }
    }
}
