package com.baidu.tieba.homepage.gamevideo.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.RecomVerticalResIdl;
/* loaded from: classes9.dex */
public class GameVideoHttpResMessage extends HttpResponsedMessage {
    public DataRes mResultData;

    public GameVideoHttpResMessage() {
        super(CmdConfigHttp.CMD_GAME_VIDEO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RecomVerticalResIdl recomVerticalResIdl = (RecomVerticalResIdl) new Wire(new Class[0]).parseFrom(bArr, RecomVerticalResIdl.class);
        if (recomVerticalResIdl != null) {
            if (recomVerticalResIdl.error != null) {
                setError(recomVerticalResIdl.error.errorno.intValue());
                setErrorString(recomVerticalResIdl.error.errmsg);
            }
            this.mResultData = recomVerticalResIdl.data;
        }
    }
}
