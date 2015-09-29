package com.baidu.tieba.hottopic.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.hottopic.data.b;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Hottopic.HotThread;
import tbclient.Hottopic.HottopicResIdl;
import tbclient.Hottopic.MagicPost;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes.dex */
public class ResponseHttpHotTopicMessage extends TbHttpResponsedMessage {
    private HotThread hot_thread;
    private MagicPost magic_post;
    private List<RelateForum> relate_forum;
    private b topicData;
    private TopicInfo topic_info;

    public ResponseHttpHotTopicMessage() {
        super(CmdConfigHttp.CMD_HOT_TOPIC);
        this.topicData = null;
    }

    public List<RelateForum> getRelateForum() {
        return this.relate_forum;
    }

    public MagicPost getMagicPost() {
        return this.magic_post;
    }

    public HotThread getHotThread() {
        return this.hot_thread;
    }

    public TopicInfo getTopicInfo() {
        return this.topic_info;
    }

    public b getHotTopicData() {
        return this.topicData;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        HottopicResIdl hottopicResIdl = (HottopicResIdl) new Wire(new Class[0]).parseFrom(bArr, HottopicResIdl.class);
        if (hottopicResIdl != null) {
            setError(hottopicResIdl.error.errorno.intValue());
            setErrorString(hottopicResIdl.error.usermsg);
            if (getError() == 0) {
                this.relate_forum = hottopicResIdl.data.relate_forum;
                this.magic_post = hottopicResIdl.data.magic_post;
                this.hot_thread = hottopicResIdl.data.hot_thread;
                this.topic_info = hottopicResIdl.data.topic_info;
                this.topicData = new b();
                this.topicData.a(hottopicResIdl.data);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
    }
}
