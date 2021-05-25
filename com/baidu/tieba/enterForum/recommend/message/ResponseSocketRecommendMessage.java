package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.n0.j0.k.c.a;
import tbclient.Recommforum.RecommforumResIdl;
/* loaded from: classes4.dex */
public class ResponseSocketRecommendMessage extends SocketResponsedMessage {
    public a mRecommendData;

    public ResponseSocketRecommendMessage() {
        super(309630);
    }

    public a getRecommendData() {
        return this.mRecommendData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
