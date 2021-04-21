package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.squareup.wire.Wire;
import d.b.c.j.e.n;
import d.b.j0.a1.j.a.c.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicThread.DataRes;
import tbclient.NewTopicThread.NewTopicThreadResIdl;
import tbclient.NewTopicThread.TopicThread;
/* loaded from: classes4.dex */
public class ResponseSocketGetTopicThreadMessage extends SocketResponsedMessage {
    public boolean hasMore;
    public List<n> mDataList;

    public ResponseSocketGetTopicThreadMessage() {
        super(309631);
        this.hasMore = false;
    }

    public List<n> getDataList() {
        return this.mDataList;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
                cVar.j(topicThread);
                this.mDataList.add(cVar);
            }
        }
    }
}
