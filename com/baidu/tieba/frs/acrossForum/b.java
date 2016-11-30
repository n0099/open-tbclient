package com.baidu.tieba.frs.acrossForum;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.acrossForum.message.AcrossAwardHttpResMsg;
import com.baidu.tieba.frs.acrossForum.message.AcrossAwardSocketMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bWC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bWC = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage instanceof AcrossAwardHttpResMsg) {
                this.bWC.a(((AcrossAwardHttpResMsg) responsedMessage).result);
            }
            if (!(responsedMessage instanceof AcrossAwardSocketMsg)) {
                return;
            }
            this.bWC.a(((AcrossAwardSocketMsg) responsedMessage).result);
        }
    }
}
