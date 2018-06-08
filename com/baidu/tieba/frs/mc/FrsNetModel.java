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
/* loaded from: classes2.dex */
public class FrsNetModel<T> extends NetAutoModel<FrsRequestData, com.baidu.tieba.tbadkCore.i, T> {
    public FrsNetModel(TbPageContext<T> tbPageContext, FrsRequestData frsRequestData) {
        super(tbPageContext, frsRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> Jy() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> Jz() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.tbadkCore.i> getResponseDataClass() {
        return com.baidu.tieba.tbadkCore.i.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int JA() {
        return CmdConfigHttp.FRS_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int JB() {
        return 301001;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String JC() {
        return TbConfig.FRS_ADDRESS;
    }

    public void a(FrsRequestData frsRequestData) {
        this.aRA = frsRequestData;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }
}
