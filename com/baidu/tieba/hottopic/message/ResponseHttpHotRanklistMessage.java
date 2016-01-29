package com.baidu.tieba.hottopic.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.hottopic.data.i;
import com.squareup.wire.Wire;
import tbclient.HottopicRanklist.TopicListResIdl;
/* loaded from: classes.dex */
public class ResponseHttpHotRanklistMessage extends TbHttpResponsedMessage {
    private i ranklistData;

    public ResponseHttpHotRanklistMessage() {
        super(CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST);
    }

    public i getHotRanklistData() {
        return this.ranklistData;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        TopicListResIdl topicListResIdl = (TopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, TopicListResIdl.class);
        if (topicListResIdl != null) {
            setError(topicListResIdl.error.errorno.intValue());
            setErrorString(topicListResIdl.error.usermsg);
            if (getError() == 0) {
                this.ranklistData = new i();
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
