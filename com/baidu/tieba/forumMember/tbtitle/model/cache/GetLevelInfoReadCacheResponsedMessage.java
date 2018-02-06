package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetLevelInfo.DataRes;
import tbclient.GetLevelInfo.GetLevelInfoResIdl;
/* loaded from: classes3.dex */
public class GetLevelInfoReadCacheResponsedMessage extends CustomResponsedMessage<Object> {
    private DataRes mResult;

    public GetLevelInfoReadCacheResponsedMessage() {
        super(2003007);
    }

    public DataRes getResult() {
        return this.mResult;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetLevelInfoResIdl getLevelInfoResIdl = (GetLevelInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLevelInfoResIdl.class);
        if (getLevelInfoResIdl.error != null) {
            setError(getLevelInfoResIdl.error.errorno.intValue());
            setErrorString(getLevelInfoResIdl.error.usermsg);
        }
        if (getError() == 0 && getLevelInfoResIdl.data != null) {
            this.mResult = getLevelInfoResIdl.data;
        }
    }
}
