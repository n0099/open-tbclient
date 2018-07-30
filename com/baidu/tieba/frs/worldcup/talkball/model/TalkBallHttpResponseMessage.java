package com.baidu.tieba.frs.worldcup.talkball.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.TalkBall.TalkBallResIdl;
/* loaded from: classes3.dex */
public class TalkBallHttpResponseMessage extends MvcProtobufHttpResponsedMessage<c, TalkBallResIdl> {
    public TalkBallHttpResponseMessage() {
        super(CmdConfigHttp.CMD_FRS_TALK_BALL);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Class' to match base method */
    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<TalkBallResIdl> getProtobufResponseIdlClass() {
        return TalkBallResIdl.class;
    }
}
