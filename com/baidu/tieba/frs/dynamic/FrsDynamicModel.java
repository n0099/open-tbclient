package com.baidu.tieba.frs.dynamic;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes2.dex */
public class FrsDynamicModel<T> extends NetAutoModel<FrsDynamicRequestData, b, T> {
    public FrsDynamicModel(TbPageContext<T> tbPageContext, FrsDynamicRequestData frsDynamicRequestData) {
        super(tbPageContext, frsDynamicRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<b> getResponseDataClass() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int JR() {
        return CmdConfigHttp.CMD_FRS_DYNAMIC;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int JS() {
        return 309602;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String JT() {
        return TbConfig.FRS_DYNAMIC_ADDRESS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> JP() {
        return FrsDynamicHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> JQ() {
        return FrsDynamicSocketResponsedMessage.class;
    }

    public void a(FrsDynamicRequestData frsDynamicRequestData) {
        this.aSw = frsDynamicRequestData;
    }
}
