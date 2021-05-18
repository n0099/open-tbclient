package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.k0.i0.k.c.a;
import tbclient.Recommforum.RecommforumResIdl;
/* loaded from: classes4.dex */
public class ResponseHttpRecommendMessage extends TbHttpResponsedMessage {
    public a mRecommendData;

    public ResponseHttpRecommendMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FORUM);
    }

    public a getRecommendData() {
        return this.mRecommendData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        RecommforumResIdl recommforumResIdl = (RecommforumResIdl) new Wire(new Class[0]).parseFrom(bArr, RecommforumResIdl.class);
        if (recommforumResIdl == null) {
            return;
        }
        setError(recommforumResIdl.error.errorno.intValue());
        setErrorString(recommforumResIdl.error.usermsg);
        if (getError() != 0 || recommforumResIdl.data == null) {
            return;
        }
        a aVar = new a();
        this.mRecommendData = aVar;
        aVar.h(recommforumResIdl.data);
    }
}
