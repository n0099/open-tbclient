package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(NetModel netModel, int i) {
        super(i);
        this.this$0 = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage.getCmd() == 2001121 && (customResponsedMessage instanceof NetWorkChangeMessage)) {
            NetWorkChangeMessage netWorkChangeMessage = (NetWorkChangeMessage) customResponsedMessage;
            if (netWorkChangeMessage.mState == 0) {
                this.this$0.aeg = false;
            } else if (netWorkChangeMessage.mState == -1) {
                this.this$0.aeg = false;
            } else {
                this.this$0.aeg = true;
            }
        }
    }
}
