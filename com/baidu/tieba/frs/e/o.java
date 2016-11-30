package com.baidu.tieba.frs.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
public class o<T> extends com.baidu.tbadk.mvc.model.d<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n, T> {
    public o(TbPageContext<T> tbPageContext, com.baidu.tieba.tbadkCore.m mVar) {
        super(tbPageContext, mVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> ma() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> lZ() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.tbadkCore.n> getResponseDataClass() {
        return com.baidu.tieba.tbadkCore.n.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int lW() {
        return CmdConfigHttp.FRS_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int lY() {
        return 301001;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String lX() {
        return TbConfig.FRS_ADDRESS;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        this.aAA = mVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }
}
