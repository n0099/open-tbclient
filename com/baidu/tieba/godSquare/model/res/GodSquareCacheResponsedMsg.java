package com.baidu.tieba.godSquare.model.res;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.squareup.wire.Wire;
import tbclient.GetHotGod.DataRes;
import tbclient.GetHotGod.GetHotGodResIdl;
/* loaded from: classes8.dex */
public class GodSquareCacheResponsedMsg extends CustomResponsedMessage<Object> {
    private DataRes mResult;

    public DataRes getResult() {
        return this.mResult;
    }

    public GodSquareCacheResponsedMsg() {
        super(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE);
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetHotGodResIdl getHotGodResIdl = (GetHotGodResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHotGodResIdl.class);
        if (getHotGodResIdl.error != null) {
            setError(getHotGodResIdl.error.errorno.intValue());
            setErrorString(getHotGodResIdl.error.usermsg);
        }
        if (getError() == 0 && getHotGodResIdl.data != null) {
            this.mResult = getHotGodResIdl.data;
        }
    }
}
