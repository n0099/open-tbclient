package com.baidu.tieba.homepage.fragment.model;

import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.HomePage.HomePageResIdl;
/* loaded from: classes.dex */
public class ResponseHomePageHttpMessage extends MvcProtobufHttpResponsedMessage<com.baidu.tieba.homepage.fragment.data.b, HomePageResIdl> {
    public ResponseHomePageHttpMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<HomePageResIdl> getProtobufResponseIdlClass() {
        return HomePageResIdl.class;
    }
}
