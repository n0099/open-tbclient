package com.baidu.tieba.frs.dynamic;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import d.b.i0.q0.m1.a;
/* loaded from: classes4.dex */
public class FrsDynamicModel<T> extends NetAutoModel<FrsDynamicRequestData, a, T> {
    public FrsDynamicModel(TbPageContext<T> tbPageContext, FrsDynamicRequestData frsDynamicRequestData) {
        super(tbPageContext, frsDynamicRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int F() {
        return CmdConfigHttp.CMD_FRS_DYNAMIC;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcProtobufHttpResponsedMessage> H() {
        return FrsDynamicHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String I() {
        return TbConfig.FRS_DYNAMIC_ADDRESS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int J() {
        return 309602;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcSocketResponsedMessage> K() {
        return FrsDynamicSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<a> getResponseDataClass() {
        return a.class;
    }
}
