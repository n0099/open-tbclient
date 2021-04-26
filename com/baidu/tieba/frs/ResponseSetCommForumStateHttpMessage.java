package com.baidu.tieba.frs;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SetCommonForumState.SetCommonForumStateResIdl;
/* loaded from: classes4.dex */
public class ResponseSetCommForumStateHttpMessage extends TbHttpResponsedMessage {
    public SetCommonForumStateResIdl mResponseData;

    public ResponseSetCommForumStateHttpMessage() {
        super(CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        super.decodeInBackGround(i2, bArr);
        SetCommonForumStateResIdl setCommonForumStateResIdl = (SetCommonForumStateResIdl) new Wire(new Class[0]).parseFrom(bArr, SetCommonForumStateResIdl.class);
        this.mResponseData = setCommonForumStateResIdl;
        Error error = setCommonForumStateResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
