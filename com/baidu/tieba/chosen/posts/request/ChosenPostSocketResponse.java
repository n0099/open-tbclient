package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import d.b.j0.y.a.d.b;
import tbclient.HotThread.HotThreadResIdl;
/* loaded from: classes4.dex */
public class ChosenPostSocketResponse extends MvcSocketResponsedMessage<b, HotThreadResIdl> {
    public ChosenPostSocketResponse() {
        super(307008);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<HotThreadResIdl> getProtobufResponseIdlClass() {
        return HotThreadResIdl.class;
    }
}
