package com.baidu.tieba.homepage.mygod;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.d;
import com.baidu.tieba.homepage.mygod.data.RecommendGodHttpResponsedMessage;
import com.baidu.tieba.homepage.mygod.data.RecommendGodSocketResponsedMessage;
import com.baidu.tieba.homepage.recommendfrs.data.c;
/* loaded from: classes.dex */
public class b extends d<h, c, BaseFragmentActivity> {
    public b(TbPageContext<BaseFragmentActivity> tbPageContext, h hVar) {
        super(tbPageContext, hVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage<c, ?>> lg() {
        return RecommendGodHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage<c, ?>> lf() {
        return RecommendGodSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int lc() {
        return CmdConfigHttp.CMD_RECOMMEND_FRS_GOD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String ld() {
        return TbConfig.RECOMMEND_FRS_GOD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class getResponseDataClass() {
        return com.baidu.tieba.homepage.mygod.data.c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int le() {
        return 309281;
    }
}
