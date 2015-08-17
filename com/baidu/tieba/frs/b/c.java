package com.baidu.tieba.frs.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.d;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes.dex */
public class c<T> extends d<k, l, T> {
    public c(TbPageContext<T> tbPageContext, k kVar) {
        super(tbPageContext, kVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> oY() {
        return FrsPageHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> oX() {
        return FRSPageSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<l> getResponseDataClass() {
        return l.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oU() {
        return CmdConfigHttp.FRS_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oW() {
        return 301001;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String oV() {
        return TbConfig.FRS_ADDRESS;
    }

    public void a(k kVar) {
        this.avn = kVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return super.isNeedCache();
    }
}
