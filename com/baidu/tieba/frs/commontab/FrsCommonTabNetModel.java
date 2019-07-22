package com.baidu.tieba.frs.commontab;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes4.dex */
public class FrsCommonTabNetModel<T> extends NetAutoModel<FrsCommonTabRequestData, d, T> {
    public FrsCommonTabNetModel(TbPageContext tbPageContext, FrsCommonTabRequestData frsCommonTabRequestData) {
        super(tbPageContext, frsCommonTabRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class getResponseDataClass() {
        return d.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int auz() {
        return CmdConfigHttp.CMD_FRS_COMMON_TAB;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int auA() {
        return 309622;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String auB() {
        return TbConfig.FRS_COMMON_TAB;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> aux() {
        return FrsCommonTabHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> auy() {
        return FrsCommonTabSocketResponseMessage.class;
    }
}
