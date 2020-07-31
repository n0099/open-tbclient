package com.baidu.tieba.chosen.posts.request;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.HotThread.HotThreadResIdl;
/* loaded from: classes17.dex */
public class ChosenPostSocketResponse extends MvcSocketResponsedMessage<b, HotThreadResIdl> {
    public ChosenPostSocketResponse() {
        super(CmdConfigSocket.CMD_GET_HOT_THREAD);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<HotThreadResIdl> getProtobufResponseIdlClass() {
        return HotThreadResIdl.class;
    }
}
