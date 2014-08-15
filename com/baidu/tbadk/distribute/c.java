package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseDistributeMessage) && socketResponsedMessage.getCmd() == 303101) {
            Message<?> orginalMessage = socketResponsedMessage.getOrginalMessage();
            if (!socketResponsedMessage.hasError() || !(orginalMessage instanceof RequestDistributeMessage)) {
                return;
            }
            this.a.a(((RequestDistributeMessage) orginalMessage).getAdReqList());
        }
    }
}
