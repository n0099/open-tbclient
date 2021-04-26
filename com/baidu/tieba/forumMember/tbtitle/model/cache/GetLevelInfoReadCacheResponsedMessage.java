package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetLevelInfo.DataRes;
import tbclient.GetLevelInfo.GetLevelInfoResIdl;
/* loaded from: classes4.dex */
public class GetLevelInfoReadCacheResponsedMessage extends CustomResponsedMessage<Object> {
    public DataRes mResult;

    public GetLevelInfoReadCacheResponsedMessage() {
        super(2003007);
    }

    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        GetLevelInfoResIdl getLevelInfoResIdl = (GetLevelInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLevelInfoResIdl.class);
        Error error = getLevelInfoResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getLevelInfoResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = getLevelInfoResIdl.data) != null) {
            this.mResult = dataRes;
        }
    }

    public DataRes getResult() {
        return this.mResult;
    }
}
