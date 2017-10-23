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
/* loaded from: classes.dex */
public class FrsNetModel<T> extends NetAutoModel<FrsRequestData, com.baidu.tieba.tbadkCore.g, T> {
    public FrsNetModel(TbPageContext<T> tbPageContext, FrsRequestData frsRequestData) {
        super(tbPageContext, frsRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> EV() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> EX() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.tbadkCore.g> getResponseDataClass() {
        return com.baidu.tieba.tbadkCore.g.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int EP() {
        return CmdConfigHttp.FRS_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int EQ() {
        return 301001;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String ER() {
        return TbConfig.FRS_ADDRESS;
    }

    public void a(FrsRequestData frsRequestData) {
        this.aGX = frsRequestData;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }
}
