package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.RedNotify.RedNotifyResIdl;
/* loaded from: classes16.dex */
public class CheckRedNotifySocketResMessage extends SocketResponsedMessage {
    private boolean isShowRedNotify;

    public CheckRedNotifySocketResMessage() {
        super(CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY);
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
