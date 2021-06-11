package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.c.k.e.n;
import d.a.n0.b1.k.a.c.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicThread.DataRes;
import tbclient.NewTopicThread.NewTopicThreadResIdl;
import tbclient.NewTopicThread.TopicThread;
/* loaded from: classes4.dex */
public class ResponseHttpGetTopicThreadMessage extends TbHttpResponsedMessage {
    public boolean hasMore;
    public List<n> mDataList;

    public ResponseHttpGetTopicThreadMessage() {
        super(CmdConfigHttp.CMD_TOPIC_THREAD);
        this.hasMore = false;
    }

    public List<n> getDataList() {
        return this.mDataList;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        NewTopicThreadResIdl newTopicThreadResIdl = (NewTopicThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicThreadResIdl.class);
        if (newTopicThreadResIdl == null) {
            return;
        }
        setError(newTopicThreadResIdl.error.errorno.intValue());
        setErrorString(newTopicThreadResIdl.error.usermsg);
        if (getError() != 0 || (dataRes = newTopicThreadResIdl.data) == null || ListUtils.isEmpty(dataRes.thread_list)) {
            return;
        }
        if (newTopicThreadResIdl.data.has_more.intValue() == 1) {
            this.hasMore = true;
        }
        this.mDataList = new ArrayList();
        for (TopicThread topicThread : newTopicThreadResIdl.data.thread_list) {
            if (topicThread != null) {
                c cVar = new c();
                cVar.g(topicThread);
                this.mDataList.add(cVar);
            }
        }
    }
}
