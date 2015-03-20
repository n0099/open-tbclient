package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ae extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.aJG = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            this.aJG.a(getMyPostHttpResponseMessage.getError(), StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString()) ? this.aJG.getResources().getString(com.baidu.tieba.y.neterror) : getMyPostHttpResponseMessage.getErrorString(), getMyPostHttpResponseMessage.getResponseData());
        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            this.aJG.a(getMyPostSocketResponseMessage.getError(), StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString()) ? this.aJG.getResources().getString(com.baidu.tieba.y.neterror) : getMyPostSocketResponseMessage.getErrorString(), getMyPostSocketResponseMessage.getResponseData());
        }
    }
}
