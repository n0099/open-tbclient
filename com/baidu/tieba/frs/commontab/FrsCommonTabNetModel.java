package com.baidu.tieba.frs.commontab;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import d.a.k0.q0.l1.d;
/* loaded from: classes4.dex */
public class FrsCommonTabNetModel<T> extends NetAutoModel<FrsCommonTabRequestData, d, T> {
    public FrsCommonTabNetModel(TbPageContext tbPageContext, FrsCommonTabRequestData frsCommonTabRequestData) {
        super(tbPageContext, frsCommonTabRequestData);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int F() {
        return CmdConfigHttp.CMD_FRS_COMMON_TAB;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcProtobufHttpResponsedMessage> H() {
        return FrsCommonTabHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String I() {
        return TbConfig.FRS_COMMON_TAB;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int J() {
        return 309622;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcSocketResponsedMessage> K() {
        return FrsCommonTabSocketResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class getResponseDataClass() {
        return d.class;
    }
}
