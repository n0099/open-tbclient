package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseUploadClientLogMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c cSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c cVar, int i) {
        super(i);
        this.cSz = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        List list;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseUploadClientLogMessage)) {
            this.cSz.cSt = false;
            if (socketResponsedMessage.getError() == 0) {
                list = this.cSz.cSq;
                list.clear();
            }
        }
    }
}
