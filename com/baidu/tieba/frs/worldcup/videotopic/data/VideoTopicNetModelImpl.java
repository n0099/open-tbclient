package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes3.dex */
public class VideoTopicNetModelImpl<T> extends NetAutoModel<VideoTopicRequestData, c, T> {
    public VideoTopicNetModelImpl(TbPageContext<T> tbPageContext, VideoTopicRequestData videoTopicRequestData) {
        super(tbPageContext, videoTopicRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<c> getResponseDataClass() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Nf() {
        return CmdConfigHttp.CMD_FRS_VIDEO_TOPIC;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Ng() {
        return 309607;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Nh() {
        return TbConfig.FRS_VIDEO_TOPIC;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> Nd() {
        return VideoTopicHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> Ne() {
        return VideoTopicSocketResponseMessage.class;
    }
}
