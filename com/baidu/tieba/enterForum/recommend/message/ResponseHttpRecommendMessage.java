package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.enterForum.recommend.b.a;
import com.squareup.wire.Wire;
import tbclient.Recommforum.RecommforumResIdl;
/* loaded from: classes4.dex */
public class ResponseHttpRecommendMessage extends TbHttpResponsedMessage {
    private a mRecommendData;

    public ResponseHttpRecommendMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FORUM);
    }

    public a getRecommendData() {
        return this.mRecommendData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RecommforumResIdl recommforumResIdl = (RecommforumResIdl) new Wire(new Class[0]).parseFrom(bArr, RecommforumResIdl.class);
        if (recommforumResIdl != null) {
            setError(recommforumResIdl.error.errorno.intValue());
            setErrorString(recommforumResIdl.error.usermsg);
            if (getError() == 0 && recommforumResIdl.data != null) {
                this.mRecommendData = new a();
                this.mRecommendData.a(recommforumResIdl.data);
            }
        }
    }
}
