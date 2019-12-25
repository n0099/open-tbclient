package com.baidu.tieba.barselect.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CommitCardInfo.CommitCardInfoResIdl;
/* loaded from: classes5.dex */
public class CommitCardInfoHttpResMsg extends TbHttpResponsedMessage {
    public CommitCardInfoHttpResMsg() {
        super(CmdConfigHttp.CMD_COMMIT_CARD_INFO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CommitCardInfoResIdl commitCardInfoResIdl = (CommitCardInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitCardInfoResIdl.class);
        if (commitCardInfoResIdl != null) {
            setError(commitCardInfoResIdl.error.errorno.intValue());
            setErrorString(commitCardInfoResIdl.error.usermsg);
        }
    }
}
