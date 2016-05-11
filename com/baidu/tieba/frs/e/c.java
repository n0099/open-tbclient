package com.baidu.tieba.frs.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.d;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes.dex */
public class c<T> extends d<l, m, T> {
    public c(TbPageContext<T> tbPageContext, l lVar) {
        super(tbPageContext, lVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> lc() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> lb() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<m> getResponseDataClass() {
        return m.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int kY() {
        return CmdConfigHttp.FRS_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int la() {
        return 301001;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String kZ() {
        return TbConfig.FRS_ADDRESS;
    }

    public void a(l lVar) {
        this.avt = lVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }
}
