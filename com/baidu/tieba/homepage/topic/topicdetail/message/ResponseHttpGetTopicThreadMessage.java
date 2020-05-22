package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.homepage.topic.topicdetail.b.c;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicThread.NewTopicThreadResIdl;
import tbclient.NewTopicThread.TopicThread;
/* loaded from: classes9.dex */
public class ResponseHttpGetTopicThreadMessage extends TbHttpResponsedMessage {
    private boolean hasMore;
    private List<o> mDataList;

    public ResponseHttpGetTopicThreadMessage() {
        super(CmdConfigHttp.CMD_TOPIC_THREAD);
        this.hasMore = false;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public List<o> getDataList() {
        return this.mDataList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
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
