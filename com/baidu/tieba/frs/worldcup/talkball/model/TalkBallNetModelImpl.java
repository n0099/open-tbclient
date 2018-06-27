package com.baidu.tieba.frs.worldcup.talkball.model;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes2.dex */
public class TalkBallNetModelImpl<T> extends NetAutoModel<TalkBallRequestData, c, T> {
    public TalkBallNetModelImpl(TbPageContext<T> tbPageContext, TalkBallRequestData talkBallRequestData) {
        super(tbPageContext, talkBallRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int JS() {
        return CmdConfigHttp.CMD_FRS_TALK_BALL;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String JU() {
        return TbConfig.FRS_TALK_BALL;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int JT() {
        return 309605;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<c> getResponseDataClass() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> JQ() {
        return TalkBallHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> JR() {
        return TalkBallSocketResponseMessage.class;
    }
}
