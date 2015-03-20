package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.HotThread.HotThreadResIdl;
/* loaded from: classes.dex */
public class ChosenPostSocketResponse extends MvcSocketResponsedMessage<d, HotThreadResIdl> {
    public ChosenPostSocketResponse() {
        super(307008);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<HotThreadResIdl> getProtobufResponseIdlClass() {
        return HotThreadResIdl.class;
    }
}
