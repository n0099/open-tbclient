package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m extends a {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bQp = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String errorString;
        String errorString2;
        if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                errorString2 = this.bQp.getResources().getString(t.j.neterror);
            } else {
                errorString2 = getMyPostHttpResponseMessage.getErrorString();
            }
            this.bQp.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                errorString = this.bQp.getResources().getString(t.j.neterror);
            } else {
                errorString = getMyPostSocketResponseMessage.getErrorString();
            }
            this.bQp.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
        }
    }
}
