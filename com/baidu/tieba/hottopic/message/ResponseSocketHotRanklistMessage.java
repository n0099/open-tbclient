package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.hottopic.data.j;
import com.squareup.wire.Wire;
import tbclient.TopicList.TopicListResIdl;
/* loaded from: classes20.dex */
public class ResponseSocketHotRanklistMessage extends SocketResponsedMessage {
    private j ranklistData;

    public ResponseSocketHotRanklistMessage() {
        super(CmdConfigSocket.CMD_HOT_TOPIC_RANKLIST);
    }

    public j getHotRanklistData() {
        return this.ranklistData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        TopicListResIdl topicListResIdl = (TopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, TopicListResIdl.class);
        if (topicListResIdl != null) {
            setError(topicListResIdl.error.errorno.intValue());
            setErrorString(topicListResIdl.error.usermsg);
            if (getError() == 0) {
                this.ranklistData = new j();
                this.ranklistData.a(topicListResIdl.data);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
    }
}
