package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.QueryUserInfosResIdl;
/* loaded from: classes.dex */
public class ResponseQueryUserInfoMessage extends SocketResponsedMessage {
    private DataRes resData;

    public ResponseQueryUserInfoMessage() {
        super(CmdConfigSocket.CMD_QUERY_USER_INFO);
        this.resData = null;
    }

    public DataRes getResData() {
        return this.resData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryUserInfosResIdl queryUserInfosResIdl = (QueryUserInfosResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryUserInfosResIdl.class);
        setError(queryUserInfosResIdl.error.errorno.intValue());
        setErrorString(queryUserInfosResIdl.error.usermsg);
        if (getError() == 0) {
            this.resData = queryUserInfosResIdl.data;
        }
    }
}
