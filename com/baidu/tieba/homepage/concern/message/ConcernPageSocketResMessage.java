package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.UserlikeResIdl;
/* loaded from: classes6.dex */
public class ConcernPageSocketResMessage extends SocketResponsedMessage {
    private DataRes resultData;

    public ConcernPageSocketResMessage() {
        super(CmdConfigSocket.CMD_CONCERN_PAGE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UserlikeResIdl userlikeResIdl = (UserlikeResIdl) new Wire(new Class[0]).parseFrom(bArr, UserlikeResIdl.class);
        if (userlikeResIdl != null) {
            if (userlikeResIdl.error != null) {
                setError(userlikeResIdl.error.errorno.intValue());
                setErrorString(userlikeResIdl.error.errmsg);
            }
            if (userlikeResIdl.data != null) {
                this.resultData = userlikeResIdl.data;
            }
        }
    }

    public DataRes getResultData() {
        return this.resultData;
    }
}
