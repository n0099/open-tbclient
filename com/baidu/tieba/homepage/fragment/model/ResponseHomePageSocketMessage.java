package com.baidu.tieba.homepage.fragment.model;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.HomePage.HomePageResIdl;
/* loaded from: classes.dex */
public class ResponseHomePageSocketMessage extends MvcSocketResponsedMessage<com.baidu.tieba.homepage.fragment.data.b, HomePageResIdl> {
    public ResponseHomePageSocketMessage() {
        super(309086);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<HomePageResIdl> getProtobufResponseIdlClass() {
        return HomePageResIdl.class;
    }
}
