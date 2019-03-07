package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.homepage.topic.topicdetail.b.a;
import com.squareup.wire.Wire;
import tbclient.NewHottopic.NewHottopicResIdl;
/* loaded from: classes4.dex */
public class ResponseHttpGetTopicDetailMessage extends TbHttpResponsedMessage {
    private a mTopicDetailData;

    public ResponseHttpGetTopicDetailMessage() {
        super(CmdConfigHttp.CMD_TOPIC_DETAIL);
    }

    public a getTopicDetailData() {
        return this.mTopicDetailData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        NewHottopicResIdl newHottopicResIdl = (NewHottopicResIdl) new Wire(new Class[0]).parseFrom(bArr, NewHottopicResIdl.class);
        if (newHottopicResIdl != null) {
            setError(newHottopicResIdl.error.errorno.intValue());
            setErrorString(newHottopicResIdl.error.usermsg);
            if (getError() == 0 && newHottopicResIdl.data != null) {
                this.mTopicDetailData = new a();
                this.mTopicDetailData.a(newHottopicResIdl.data);
            }
        }
    }
}
