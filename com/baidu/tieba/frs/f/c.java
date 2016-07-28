package com.baidu.tieba.frs.f;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.d;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.n;
/* loaded from: classes.dex */
public class c<T> extends d<m, n, T> {
    public c(TbPageContext<T> tbPageContext, m mVar) {
        super(tbPageContext, mVar);
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
    protected Class<n> getResponseDataClass() {
        return n.class;
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

    public void a(m mVar) {
        this.awY = mVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }
}
