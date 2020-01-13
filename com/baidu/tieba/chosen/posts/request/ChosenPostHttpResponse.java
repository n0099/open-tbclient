package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.HotThread.HotThreadResIdl;
/* loaded from: classes8.dex */
public class ChosenPostHttpResponse extends MvcProtobufHttpResponsedMessage<b, HotThreadResIdl> {
    public ChosenPostHttpResponse(int i) {
        super(1003005);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<HotThreadResIdl> getProtobufResponseIdlClass() {
        return HotThreadResIdl.class;
    }
}
