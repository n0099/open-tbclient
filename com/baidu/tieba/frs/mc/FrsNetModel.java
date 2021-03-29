package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import d.b.i0.c3.m;
/* loaded from: classes4.dex */
public class FrsNetModel<T> extends NetAutoModel<FrsRequestData, m, T> implements NetModel.k<FrsRequestData, m> {
    public boolean r;
    public ResponsedMessage s;
    public Message t;
    public MvcNetMessage u;

    public FrsNetModel(TbPageContext<T> tbPageContext, FrsRequestData frsRequestData) {
        super(tbPageContext, frsRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int F() {
        return CmdConfigHttp.FRS_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcProtobufHttpResponsedMessage> H() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String I() {
        return TbConfig.FRS_ADDRESS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int J() {
        return 301001;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcSocketResponsedMessage> K() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean N() {
        boolean N = super.N();
        this.r = N;
        return N;
    }

    public Message W() {
        return this.t;
    }

    public MvcNetMessage X() {
        return this.u;
    }

    public FrsRequestData Y() {
        return (FrsRequestData) this.f13970g;
    }

    public boolean Z() {
        return this.r;
    }

    public void a0(FrsRequestData frsRequestData) {
        this.f13970g = frsRequestData;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void f(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        this.s = mvcHttpResponsedMessage;
        this.t = mvcHttpMessage;
        this.u = mvcNetMessage;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<m> getResponseDataClass() {
        return m.class;
    }

    public ResponsedMessage getResponsedMessage() {
        return this.s;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        this.s = mvcSocketResponsedMessage;
        this.t = mvcSocketMessage;
        this.u = mvcNetMessage;
    }
}
