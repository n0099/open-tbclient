package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.homepage.topic.topicdetail.b.c;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicThread.NewTopicThreadResIdl;
import tbclient.NewTopicThread.TopicThread;
/* loaded from: classes9.dex */
public class ResponseSocketGetTopicThreadMessage extends SocketResponsedMessage {
    private boolean hasMore;
    private List<m> mDataList;

    public ResponseSocketGetTopicThreadMessage() {
        super(309631);
        this.hasMore = false;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        NewTopicThreadResIdl newTopicThreadResIdl = (NewTopicThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicThreadResIdl.class);
        if (newTopicThreadResIdl != null) {
            setError(newTopicThreadResIdl.error.errorno.intValue());
            setErrorString(newTopicThreadResIdl.error.usermsg);
            if (getError() == 0 && newTopicThreadResIdl.data != null && !v.isEmpty(newTopicThreadResIdl.data.thread_list)) {
                if (newTopicThreadResIdl.data.has_more.intValue() == 1) {
                    this.hasMore = true;
                }
                this.mDataList = new ArrayList();
                for (TopicThread topicThread : newTopicThreadResIdl.data.thread_list) {
                    if (topicThread != null) {
                        c cVar = new c();
                        cVar.a(topicThread);
                        this.mDataList.add(cVar);
                    }
                }
            }
        }
    }
}
