package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.frs.GetMyPostHttpResponseMessage;
import com.baidu.tieba.frs.GetMyPostSocketResponseMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ k bZK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, int i, int i2) {
        super(i, i2);
        this.bZK = kVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String errorString;
        String errorString2;
        if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
            if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                errorString2 = this.bZK.bTf.getResources().getString(w.l.neterror);
            } else {
                errorString2 = getMyPostHttpResponseMessage.getErrorString();
            }
            this.bZK.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
            if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                errorString = this.bZK.bTf.getResources().getString(w.l.neterror);
            } else {
                errorString = getMyPostSocketResponseMessage.getErrorString();
            }
            this.bZK.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
        }
    }
}
