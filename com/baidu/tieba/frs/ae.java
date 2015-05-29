package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ae extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.aLX = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            this.aLX.a(getMyPostHttpResponseMessage.getError(), StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString()) ? this.aLX.getResources().getString(com.baidu.tieba.t.neterror) : getMyPostHttpResponseMessage.getErrorString(), getMyPostHttpResponseMessage.getResponseData());
        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            this.aLX.a(getMyPostSocketResponseMessage.getError(), StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString()) ? this.aLX.getResources().getString(com.baidu.tieba.t.neterror) : getMyPostSocketResponseMessage.getErrorString(), getMyPostSocketResponseMessage.getResponseData());
        }
    }
}
