package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bed = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            this.bed.a(getMyPostHttpResponseMessage.getError(), StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString()) ? this.bed.getResources().getString(n.j.neterror) : getMyPostHttpResponseMessage.getErrorString(), getMyPostHttpResponseMessage.getResponseData());
        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            this.bed.a(getMyPostSocketResponseMessage.getError(), StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString()) ? this.bed.getResources().getString(n.j.neterror) : getMyPostSocketResponseMessage.getErrorString(), getMyPostSocketResponseMessage.getResponseData());
        }
    }
}
