package com.baidu.tieba.homepage.fragment.model;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.HomePage.HomePageResIdl;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.model.d<com.baidu.tieba.homepage.fragment.data.c, com.baidu.tieba.homepage.fragment.data.b, BaseFragmentActivity> {
    public e(TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.homepage.fragment.data.c cVar) {
        super(tbPageContext, cVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage<com.baidu.tieba.homepage.fragment.data.b, HomePageResIdl>> pd() {
        return ResponseHomePageHttpMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage<com.baidu.tieba.homepage.fragment.data.b, HomePageResIdl>> pc() {
        return ResponseHomePageSocketMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oZ() {
        return CmdConfigHttp.CMD_HOME_PAGE;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String pa() {
        return TbConfig.URL_GET_HOME_PAGE_DATA;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.homepage.fragment.data.b> getResponseDataClass() {
        return com.baidu.tieba.homepage.fragment.data.b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int pb() {
        return 309086;
    }
}
