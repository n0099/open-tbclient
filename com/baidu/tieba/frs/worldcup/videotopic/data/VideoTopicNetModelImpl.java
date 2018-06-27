package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes2.dex */
public class VideoTopicNetModelImpl<T> extends NetAutoModel<VideoTopicRequestData, c, T> {
    public VideoTopicNetModelImpl(TbPageContext<T> tbPageContext, VideoTopicRequestData videoTopicRequestData) {
        super(tbPageContext, videoTopicRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<c> getResponseDataClass() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int JS() {
        return CmdConfigHttp.CMD_FRS_VIDEO_TOPIC;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int JT() {
        return 309607;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String JU() {
        return TbConfig.FRS_VIDEO_TOPIC;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> JQ() {
        return VideoTopicHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> JR() {
        return VideoTopicSocketResponseMessage.class;
    }
}
