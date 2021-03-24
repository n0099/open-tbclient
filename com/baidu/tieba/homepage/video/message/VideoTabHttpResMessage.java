package com.baidu.tieba.homepage.video.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.RecomVideo.DataRes;
import tbclient.RecomVideo.RecomVideoResIdl;
/* loaded from: classes4.dex */
public class VideoTabHttpResMessage extends HttpResponsedMessage {
    public DataRes mResultData;

    public VideoTabHttpResMessage() {
        super(CmdConfigHttp.CMD_VIDEO_TAB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RecomVideoResIdl recomVideoResIdl = (RecomVideoResIdl) new Wire(new Class[0]).parseFrom(bArr, RecomVideoResIdl.class);
        if (recomVideoResIdl != null) {
            Error error = recomVideoResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(recomVideoResIdl.error.errmsg);
            }
            this.mResultData = recomVideoResIdl.data;
        }
    }
}
