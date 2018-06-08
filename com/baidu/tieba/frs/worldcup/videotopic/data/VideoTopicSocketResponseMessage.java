package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.VideoTopicList.VideoTopicListResIdl;
/* loaded from: classes2.dex */
public class VideoTopicSocketResponseMessage extends MvcSocketResponsedMessage<c, VideoTopicListResIdl> {
    public VideoTopicSocketResponseMessage() {
        super(309607);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<VideoTopicListResIdl> getProtobufResponseIdlClass() {
        return VideoTopicListResIdl.class;
    }
}
