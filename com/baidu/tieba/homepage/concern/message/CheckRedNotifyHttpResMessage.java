package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.RedNotify.RedNotifyResIdl;
/* loaded from: classes22.dex */
public class CheckRedNotifyHttpResMessage extends HttpResponsedMessage {
    private boolean isShowRedNotify;

    public CheckRedNotifyHttpResMessage() {
        super(1003344);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RedNotifyResIdl redNotifyResIdl = (RedNotifyResIdl) new Wire(new Class[0]).parseFrom(bArr, RedNotifyResIdl.class);
        if (redNotifyResIdl != null) {
            if (redNotifyResIdl.error != null) {
                setError(redNotifyResIdl.error.errorno.intValue());
                setErrorString(redNotifyResIdl.error.errmsg);
            }
            if (redNotifyResIdl.data != null && redNotifyResIdl.data.notify_data != null) {
                this.isShowRedNotify = redNotifyResIdl.data.notify_data.notify_status.intValue() == 1;
            }
        }
    }

    public boolean isShowRedNotify() {
        return this.isShowRedNotify;
    }
}
