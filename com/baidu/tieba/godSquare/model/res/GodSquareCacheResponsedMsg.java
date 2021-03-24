package com.baidu.tieba.godSquare.model.res;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetHotGod.DataRes;
import tbclient.GetHotGod.GetHotGodResIdl;
/* loaded from: classes4.dex */
public class GodSquareCacheResponsedMsg extends CustomResponsedMessage<Object> {
    public DataRes mResult;

    public GodSquareCacheResponsedMsg() {
        super(2016446);
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        GetHotGodResIdl getHotGodResIdl = (GetHotGodResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHotGodResIdl.class);
        Error error = getHotGodResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getHotGodResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = getHotGodResIdl.data) != null) {
            this.mResult = dataRes;
        }
    }

    public DataRes getResult() {
        return this.mResult;
    }
}
