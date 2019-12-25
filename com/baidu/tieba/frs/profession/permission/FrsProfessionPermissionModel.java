package com.baidu.tieba.frs.profession.permission;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes.dex */
public class FrsProfessionPermissionModel<T> extends NetAutoModel<a, b, T> {
    public FrsProfessionPermissionModel(TbPageContext<T> tbPageContext, a aVar) {
        super(tbPageContext, aVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<b> getResponseDataClass() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int aNO() {
        return CmdConfigHttp.CMD_PROFESSION_PERMISSION;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int aNP() {
        return 309636;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String aNQ() {
        return TbConfig.URL_PROFESSION_PERMISSION;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> aNM() {
        return ProPermissionHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> aNN() {
        return ProPermissionSocketResponseMessage.class;
    }
}
