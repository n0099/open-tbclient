package com.baidu.tieba.enterForum.multiConcern;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ MultiConcernModel bTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MultiConcernModel multiConcernModel, int i, int i2) {
        super(i, i2);
        this.bTP = multiConcernModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        MultiConcernModel.a aVar;
        MultiConcernModel.a aVar2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof MultiConcernSocketResponseMessage) || (responsedMessage instanceof MultiConcernHttpResponseMessage)) {
                aVar = this.bTP.bTO;
                if (aVar != null) {
                    aVar2 = this.bTP.bTO;
                    aVar2.z(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }
}
