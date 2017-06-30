package com.baidu.tieba.bigv;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.bigv.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bym;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bym = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        long j;
        a.InterfaceC0060a interfaceC0060a;
        a.InterfaceC0060a interfaceC0060a2;
        long j2;
        long j3;
        this.bym.mIsLoading = false;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            Message<?> orginalMessage = responsedMessage.getOrginalMessage();
            if (orginalMessage.getExtra() instanceof BigVCheckRequestMessage) {
                BigVCheckRequestMessage bigVCheckRequestMessage = (BigVCheckRequestMessage) orginalMessage.getExtra();
                if (!responsedMessage.hasError()) {
                    j3 = this.bym.mUserId;
                    if (j3 != bigVCheckRequestMessage.getUserId()) {
                        return;
                    }
                }
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                boolean isBigV = responsedMessage instanceof BigVCheckSocketResponseMessage ? ((BigVCheckSocketResponseMessage) responsedMessage).isBigV() : responsedMessage instanceof BigVCheckHttpResponseMessage ? ((BigVCheckHttpResponseMessage) responsedMessage).isBigV() : false;
                long c = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                j = this.bym.mUserId;
                if (c == j && TbadkCoreApplication.getCurrentAccountObj() != null) {
                    TbadkCoreApplication.getCurrentAccountObj().setIsBigV(isBigV);
                }
                interfaceC0060a = this.bym.byl;
                if (interfaceC0060a != null) {
                    interfaceC0060a2 = this.bym.byl;
                    j2 = this.bym.mUserId;
                    interfaceC0060a2.a(error, errorString, j2, isBigV);
                }
            }
        }
    }
}
