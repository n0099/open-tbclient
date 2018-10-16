package com.baidu.tieba.frs;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SetCommonForumState.SetCommonForumStateResIdl;
/* loaded from: classes6.dex */
public class ResponseSetCommForumStateHttpMessage extends TbHttpResponsedMessage {
    private SetCommonForumStateResIdl mResponseData;

    public ResponseSetCommForumStateHttpMessage() {
        super(CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        this.mResponseData = (SetCommonForumStateResIdl) new Wire(new Class[0]).parseFrom(bArr, SetCommonForumStateResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
