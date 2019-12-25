package com.baidu.tieba.frs.dynamic;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes6.dex */
public class FrsDynamicModel<T> extends NetAutoModel<FrsDynamicRequestData, a, T> {
    public FrsDynamicModel(TbPageContext<T> tbPageContext, FrsDynamicRequestData frsDynamicRequestData) {
        super(tbPageContext, frsDynamicRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<a> getResponseDataClass() {
        return a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int aNO() {
        return 1003398;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int aNP() {
        return CmdConfigSocket.CMD_FRS_DYNAMIC;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String aNQ() {
        return TbConfig.FRS_DYNAMIC_ADDRESS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> aNM() {
        return FrsDynamicHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> aNN() {
        return FrsDynamicSocketResponsedMessage.class;
    }
}
