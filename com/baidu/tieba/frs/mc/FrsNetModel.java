package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes4.dex */
public class FrsNetModel<T> extends NetAutoModel<FrsRequestData, com.baidu.tieba.tbadkCore.j, T> {
    public FrsNetModel(TbPageContext<T> tbPageContext, FrsRequestData frsRequestData) {
        super(tbPageContext, frsRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> atp() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> atq() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.tbadkCore.j> getResponseDataClass() {
        return com.baidu.tieba.tbadkCore.j.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int atr() {
        return CmdConfigHttp.FRS_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int ats() {
        return 301001;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String att() {
        return TbConfig.FRS_ADDRESS;
    }

    public void a(FrsRequestData frsRequestData) {
        this.cxf = frsRequestData;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }
}
