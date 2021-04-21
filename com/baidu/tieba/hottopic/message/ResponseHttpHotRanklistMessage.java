package com.baidu.tieba.hottopic.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.j0.c1.c.j;
import tbclient.TopicList.TopicListResIdl;
/* loaded from: classes4.dex */
public class ResponseHttpHotRanklistMessage extends TbHttpResponsedMessage {
    public j ranklistData;

    public ResponseHttpHotRanklistMessage() {
        super(CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST);
    }

    public j getHotRanklistData() {
        return this.ranklistData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
