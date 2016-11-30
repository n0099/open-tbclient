package com.baidu.tieba.frs.acrossForum.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Acrossaward.AcrossawardResIdl;
import tbclient.Acrossaward.DataRes;
/* loaded from: classes.dex */
public class AcrossAwardHttpResMsg extends HttpResponsedMessage {
    public DataRes result;

    public AcrossAwardHttpResMsg(int i) {
        super(CmdConfigHttp.CMD_ACROSS_AWARD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AcrossawardResIdl acrossawardResIdl = (AcrossawardResIdl) new Wire(new Class[0]).parseFrom(bArr, AcrossawardResIdl.class);
        if (acrossawardResIdl != null) {
            if (acrossawardResIdl.error != null) {
                setError(acrossawardResIdl.error.errorno.intValue());
                setErrorString(acrossawardResIdl.error.usermsg);
            }
            if (getError() == 0) {
                this.result = acrossawardResIdl.data;
            }
        }
    }
}
