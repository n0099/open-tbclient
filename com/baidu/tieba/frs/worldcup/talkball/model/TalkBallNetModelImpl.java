package com.baidu.tieba.frs.worldcup.talkball.model;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes3.dex */
public class TalkBallNetModelImpl<T> extends NetAutoModel<TalkBallRequestData, c, T> {
    public TalkBallNetModelImpl(TbPageContext<T> tbPageContext, TalkBallRequestData talkBallRequestData) {
        super(tbPageContext, talkBallRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Lh() {
        return CmdConfigHttp.CMD_FRS_TALK_BALL;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Lj() {
        return TbConfig.FRS_TALK_BALL;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Li() {
        return 309605;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<c> getResponseDataClass() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> Lf() {
        return TalkBallHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> Lg() {
        return TalkBallSocketResponseMessage.class;
    }
}
