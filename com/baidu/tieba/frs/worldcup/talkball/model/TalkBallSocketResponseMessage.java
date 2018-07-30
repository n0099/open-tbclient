package com.baidu.tieba.frs.worldcup.talkball.model;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.TalkBall.TalkBallResIdl;
/* loaded from: classes3.dex */
public class TalkBallSocketResponseMessage extends MvcSocketResponsedMessage<c, TalkBallResIdl> {
    public TalkBallSocketResponseMessage() {
        super(309605);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Class' to match base method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<TalkBallResIdl> getProtobufResponseIdlClass() {
        return TalkBallResIdl.class;
    }
}
