package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes.dex */
public class FrsNetModel<T> extends NetAutoModel<FrsRequestData, com.baidu.tieba.tbadkCore.m, T> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m> {
    private MvcNetMessage jFA;
    private boolean jFy;
    private Message jFz;
    private ResponsedMessage mResponsedMessage;

    public FrsNetModel(TbPageContext<T> tbPageContext, FrsRequestData frsRequestData) {
        super(tbPageContext, frsRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> acS() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> acU() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.tbadkCore.m> getResponseDataClass() {
        return com.baidu.tieba.tbadkCore.m.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int acP() {
        return 1001703;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int acO() {
        return CmdConfigSocket.CMD_FRS_PAGE;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String acI() {
        return TbConfig.FRS_ADDRESS;
    }

    public void a(FrsRequestData frsRequestData) {
        this.cmr = frsRequestData;
    }

    public FrsRequestData cJN() {
        return (FrsRequestData) this.cmr;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean loadData() {
        this.jFy = super.loadData();
        return this.jFy;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.mResponsedMessage = mvcHttpResponsedMessage;
        this.jFz = mvcHttpMessage;
        this.jFA = mvcNetMessage;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.mResponsedMessage = mvcSocketResponsedMessage;
        this.jFz = mvcSocketMessage;
        this.jFA = mvcNetMessage;
    }

    public boolean cJO() {
        return this.jFy;
    }

    public ResponsedMessage getResponsedMessage() {
        return this.mResponsedMessage;
    }

    public Message cJP() {
        return this.jFz;
    }

    public MvcNetMessage cJQ() {
        return this.jFA;
    }
}
