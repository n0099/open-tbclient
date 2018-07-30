package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.VideoTopicList.VideoTopicListResIdl;
/* loaded from: classes3.dex */
public class VideoTopicHttpResponseMessage extends MvcProtobufHttpResponsedMessage<c, VideoTopicListResIdl> {
    public VideoTopicHttpResponseMessage() {
        super(CmdConfigHttp.CMD_FRS_VIDEO_TOPIC);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<VideoTopicListResIdl> getProtobufResponseIdlClass() {
        return VideoTopicListResIdl.class;
    }
}
