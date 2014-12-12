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
public class t extends com.baidu.tbadk.mvc.model.e<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a, BaseFragmentActivity> {
    public t(TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.discover.data.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> kP() {
        return FoundNewHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> kO() {
        return FoundNewSocketResponsedMessage.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int kL() {
        return CmdConfigHttp.CMD_FOUND_NEW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String kM() {
        return TbConfig.FOUND_NEW_ADDRESS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<com.baidu.tieba.discover.data.a> getResponseDataClass() {
        return com.baidu.tieba.discover.data.a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int kN() {
        return 303023;
    }
}
