package com.baidu.tieba.discover;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.discover.data.FoundNewHttpResponsedMessage;
import com.baidu.tieba.discover.data.FoundNewSocketResponsedMessage;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.model.d<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a, BaseFragmentActivity> {
    public w(TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.discover.data.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> oB() {
        return FoundNewHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> oA() {
        return FoundNewSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int ox() {
        return CmdConfigHttp.CMD_FOUND_NEW;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String oy() {
        return TbConfig.FOUND_NEW_ADDRESS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.discover.data.a> getResponseDataClass() {
        return com.baidu.tieba.discover.data.a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oz() {
        return 303023;
    }
}
