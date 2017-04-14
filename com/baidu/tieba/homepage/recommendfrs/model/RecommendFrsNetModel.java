package com.baidu.tieba.homepage.recommendfrs.model;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tieba.homepage.recommendfrs.data.RecommendFrsHttpResponsedMessage;
import com.baidu.tieba.homepage.recommendfrs.data.RecommendFrsSocketResponsedMessage;
import com.baidu.tieba.homepage.recommendfrs.data.c;
/* loaded from: classes.dex */
public class RecommendFrsNetModel extends NetAutoModel<h, c, BaseFragmentActivity> {
    public RecommendFrsNetModel(TbPageContext<BaseFragmentActivity> tbPageContext, h hVar) {
        super(tbPageContext, hVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage<c, ?>> FE() {
        return RecommendFrsHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage<c, ?>> FG() {
        return RecommendFrsSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fy() {
        return CmdConfigHttp.CMD_RECOMMEND_FRS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String FA() {
        return TbConfig.RECOMMEND_FRS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<c> getResponseDataClass() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fz() {
        return 309092;
    }
}
