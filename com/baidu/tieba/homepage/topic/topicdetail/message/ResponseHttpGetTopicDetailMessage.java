package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.a1.j.a.c.a;
import tbclient.NewHottopic.NewHottopicResIdl;
/* loaded from: classes4.dex */
public class ResponseHttpGetTopicDetailMessage extends TbHttpResponsedMessage {
    public a mTopicDetailData;

    public ResponseHttpGetTopicDetailMessage() {
        super(CmdConfigHttp.CMD_TOPIC_DETAIL);
    }

    public a getTopicDetailData() {
        return this.mTopicDetailData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
