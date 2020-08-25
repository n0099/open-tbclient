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
/* loaded from: classes2.dex */
public class FrsNetModel<T> extends NetAutoModel<FrsRequestData, com.baidu.tieba.tbadkCore.m, T> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m> {
    private boolean ipf;
    private Message ipg;
    private MvcNetMessage iph;
    private ResponsedMessage mResponsedMessage;

    public FrsNetModel(TbPageContext<T> tbPageContext, FrsRequestData frsRequestData) {
        super(tbPageContext, frsRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> TE() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> TG() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.tbadkCore.m> getResponseDataClass() {
        return com.baidu.tieba.tbadkCore.m.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int TB() {
        return 1001703;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int TA() {
        return CmdConfigSocket.CMD_FRS_PAGE;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Tu() {
        return TbConfig.FRS_ADDRESS;
    }

    public void a(FrsRequestData frsRequestData) {
        this.bEd = frsRequestData;
    }

    public FrsRequestData cse() {
        return (FrsRequestData) this.bEd;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean loadData() {
        this.ipf = super.loadData();
        return this.ipf;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.mResponsedMessage = mvcHttpResponsedMessage;
        this.ipg = mvcHttpMessage;
        this.iph = mvcNetMessage;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.mResponsedMessage = mvcSocketResponsedMessage;
        this.ipg = mvcSocketMessage;
        this.iph = mvcNetMessage;
    }

    public boolean csf() {
        return this.ipf;
    }

    public ResponsedMessage getResponsedMessage() {
        return this.mResponsedMessage;
    }

    public Message csg() {
        return this.ipg;
    }

    public MvcNetMessage csh() {
        return this.iph;
    }
}
