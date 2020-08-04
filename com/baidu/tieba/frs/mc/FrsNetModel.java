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
    private boolean iaX;
    private ResponsedMessage iaY;
    private Message iaZ;
    private MvcNetMessage iba;

    public FrsNetModel(TbPageContext<T> tbPageContext, FrsRequestData frsRequestData) {
        super(tbPageContext, frsRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> NK() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> NM() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.tbadkCore.m> getResponseDataClass() {
        return com.baidu.tieba.tbadkCore.m.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int NH() {
        return 1001703;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int NG() {
        return CmdConfigSocket.CMD_FRS_PAGE;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String NA() {
        return TbConfig.FRS_ADDRESS;
    }

    public void a(FrsRequestData frsRequestData) {
        this.byw = frsRequestData;
    }

    public FrsRequestData chz() {
        return (FrsRequestData) this.byw;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean loadData() {
        this.iaX = super.loadData();
        return this.iaX;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.iaY = mvcHttpResponsedMessage;
        this.iaZ = mvcHttpMessage;
        this.iba = mvcNetMessage;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.iaY = mvcSocketResponsedMessage;
        this.iaZ = mvcSocketMessage;
        this.iba = mvcNetMessage;
    }

    public boolean chA() {
        return this.iaX;
    }

    public ResponsedMessage chB() {
        return this.iaY;
    }

    public Message chC() {
        return this.iaZ;
    }

    public MvcNetMessage chD() {
        return this.iba;
    }
}
