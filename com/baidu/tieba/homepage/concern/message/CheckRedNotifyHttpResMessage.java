package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.RedNotify.DataRes;
import tbclient.RedNotify.RedNotify;
import tbclient.RedNotify.RedNotifyResIdl;
/* loaded from: classes4.dex */
public class CheckRedNotifyHttpResMessage extends HttpResponsedMessage {
    public boolean isShowRedNotify;

    public CheckRedNotifyHttpResMessage() {
        super(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY);
    }

    public boolean isShowRedNotify() {
        return this.isShowRedNotify;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RedNotify redNotify;
        RedNotifyResIdl redNotifyResIdl = (RedNotifyResIdl) new Wire(new Class[0]).parseFrom(bArr, RedNotifyResIdl.class);
        if (redNotifyResIdl != null) {
            Error error = redNotifyResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(redNotifyResIdl.error.errmsg);
            }
            DataRes dataRes = redNotifyResIdl.data;
            if (dataRes == null || (redNotify = dataRes.notify_data) == null) {
                return;
            }
            this.isShowRedNotify = redNotify.notify_status.intValue() == 1;
        }
    }
}
