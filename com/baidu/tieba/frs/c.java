package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.aUK = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            this.aUK.a(getMyPostHttpResponseMessage.getError(), StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString()) ? this.aUK.getResources().getString(i.h.neterror) : getMyPostHttpResponseMessage.getErrorString(), getMyPostHttpResponseMessage.getResponseData());
        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            this.aUK.a(getMyPostSocketResponseMessage.getError(), StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString()) ? this.aUK.getResources().getString(i.h.neterror) : getMyPostSocketResponseMessage.getErrorString(), getMyPostSocketResponseMessage.getResponseData());
        }
    }
}
