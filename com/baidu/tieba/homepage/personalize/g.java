package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e cIE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i, int i2) {
        super(i, i2);
        this.cIE = eVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            this.cIE.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            this.cIE.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
        }
    }
}
