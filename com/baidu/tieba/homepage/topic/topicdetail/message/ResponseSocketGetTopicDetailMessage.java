package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.z0.j.a.c.a;
import tbclient.NewHottopic.NewHottopicResIdl;
/* loaded from: classes3.dex */
public class ResponseSocketGetTopicDetailMessage extends SocketResponsedMessage {
    public a mTopicDetailData;

    public ResponseSocketGetTopicDetailMessage() {
        super(309629);
    }

    public a getTopicDetailData() {
        return this.mTopicDetailData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        NewHottopicResIdl newHottopicResIdl = (NewHottopicResIdl) new Wire(new Class[0]).parseFrom(bArr, NewHottopicResIdl.class);
        if (newHottopicResIdl == null) {
            return;
        }
        setError(newHottopicResIdl.error.errorno.intValue());
        setErrorString(newHottopicResIdl.error.usermsg);
        if (getError() != 0 || newHottopicResIdl.data == null) {
            return;
        }
        a aVar = new a();
        this.mTopicDetailData = aVar;
        aVar.b(newHottopicResIdl.data);
    }
}
