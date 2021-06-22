package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.o0.d1.c.j;
import tbclient.TopicList.TopicListResIdl;
/* loaded from: classes4.dex */
public class ResponseSocketHotRanklistMessage extends SocketResponsedMessage {
    public j ranklistData;

    public ResponseSocketHotRanklistMessage() {
        super(309289);
    }

    public j getHotRanklistData() {
        return this.ranklistData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        super.afterDispatchInBackGround(i2, (int) bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        TopicListResIdl topicListResIdl = (TopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, TopicListResIdl.class);
        if (topicListResIdl != null) {
            setError(topicListResIdl.error.errorno.intValue());
            setErrorString(topicListResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            j jVar = new j();
            this.ranklistData = jVar;
            jVar.c(topicListResIdl.data);
        }
    }
}
