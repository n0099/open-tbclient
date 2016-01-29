package com.baidu.tieba.adkiller;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.KillAd.KillAdResIdl;
/* loaded from: classes.dex */
public class SubmitCloseHttpResponseMessage extends TbHttpResponsedMessage {
    public SubmitCloseHttpResponseMessage(int i) {
        super(CmdConfigHttp.CMD_SUBMIT_CLOSE_ADKILLER);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        KillAdResIdl killAdResIdl = (KillAdResIdl) new Wire(new Class[0]).parseFrom(bArr, KillAdResIdl.class);
        if (killAdResIdl != null) {
            setError(killAdResIdl.error.errorno.intValue());
            setErrorString(killAdResIdl.error.usermsg);
        }
        if (getError() != 0) {
        }
    }
}
