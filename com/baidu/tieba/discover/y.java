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
public class y extends com.baidu.tbadk.mvc.model.e<com.baidu.tieba.discover.data.b, com.baidu.tieba.discover.data.a, BaseFragmentActivity> {
    public y(TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.discover.data.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> oR() {
        return FoundNewHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> oQ() {
        return FoundNewSocketResponsedMessage.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int oN() {
        return CmdConfigHttp.CMD_FOUND_NEW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String oO() {
        return TbConfig.FOUND_NEW_ADDRESS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<com.baidu.tieba.discover.data.a> getResponseDataClass() {
        return com.baidu.tieba.discover.data.a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oP() {
        return 303023;
    }
}
