package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ a XB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.XB = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (getCmd() != 2001121 || !(customResponsedMessage instanceof NetWorkChangeMessage) || customResponsedMessage.hasError()) {
            return;
        }
        switch (((NetWorkChangeMessage) customResponsedMessage).mState) {
            case -1:
            case 0:
                this.XB.aF(false);
                return;
            case 1:
            case 2:
                this.XB.aF(true);
                return;
            default:
                return;
        }
    }
}
