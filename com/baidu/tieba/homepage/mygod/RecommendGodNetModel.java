package com.baidu.tieba.homepage.mygod;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tieba.homepage.mygod.data.RecommendGodHttpResponsedMessage;
import com.baidu.tieba.homepage.mygod.data.RecommendGodSocketResponsedMessage;
import com.baidu.tieba.homepage.mygod.data.d;
import com.baidu.tieba.homepage.recommendfrs.data.c;
/* loaded from: classes.dex */
public class RecommendGodNetModel extends NetAutoModel<h, c, BaseFragmentActivity> {
    public RecommendGodNetModel(TbPageContext<BaseFragmentActivity> tbPageContext, h hVar) {
        super(tbPageContext, hVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage<c, ?>> Fg() {
        return RecommendGodHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage<c, ?>> Fi() {
        return RecommendGodSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fa() {
        return CmdConfigHttp.CMD_RECOMMEND_FRS_GOD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Fc() {
        return TbConfig.RECOMMEND_FRS_GOD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class getResponseDataClass() {
        return d.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fb() {
        return 309281;
    }
}
