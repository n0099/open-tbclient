package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import d.b.j0.y.a.d.b;
import tbclient.HotThread.HotThreadResIdl;
/* loaded from: classes4.dex */
public class ChosenPostHttpResponse extends MvcProtobufHttpResponsedMessage<b, HotThreadResIdl> {
    public ChosenPostHttpResponse(int i) {
        super(CmdConfigHttp.CMD_GET_HOT_THREAD);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public Class<HotThreadResIdl> getProtobufResponseIdlClass() {
        return HotThreadResIdl.class;
    }
}
