package com.baidu.tieba.frs.profession.permission;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import d.b.i0.q0.f2.a.a;
import d.b.i0.q0.f2.a.b;
/* loaded from: classes4.dex */
public class FrsProfessionPermissionModel<T> extends NetAutoModel<a, b, T> {
    public FrsProfessionPermissionModel(TbPageContext<T> tbPageContext, a aVar) {
        super(tbPageContext, aVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int F() {
        return CmdConfigHttp.CMD_PROFESSION_PERMISSION;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcProtobufHttpResponsedMessage> H() {
        return ProPermissionHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String I() {
        return TbConfig.URL_PROFESSION_PERMISSION;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int J() {
        return 309636;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcSocketResponsedMessage> K() {
        return ProPermissionSocketResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<b> getResponseDataClass() {
        return b.class;
    }
}
