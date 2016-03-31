package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.blk = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            this.blk.a(getMyPostHttpResponseMessage.getError(), StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString()) ? this.blk.getResources().getString(t.j.neterror) : getMyPostHttpResponseMessage.getErrorString(), getMyPostHttpResponseMessage.getResponseData());
        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            this.blk.a(getMyPostSocketResponseMessage.getError(), StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString()) ? this.blk.getResources().getString(t.j.neterror) : getMyPostSocketResponseMessage.getErrorString(), getMyPostSocketResponseMessage.getResponseData());
        }
    }
}
