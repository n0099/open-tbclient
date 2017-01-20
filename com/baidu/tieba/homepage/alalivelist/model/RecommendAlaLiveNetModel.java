package com.baidu.tieba.homepage.alalivelist.model;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tieba.homepage.alalivelist.data.RecommendAlaLiveHttpResponseMessage;
import com.baidu.tieba.homepage.alalivelist.data.RecommendAlaLiveSocketResponseMessage;
import com.baidu.tieba.homepage.recommendfrs.data.c;
/* loaded from: classes.dex */
public class RecommendAlaLiveNetModel extends NetAutoModel<h, c, BaseFragmentActivity> {
    public RecommendAlaLiveNetModel(TbPageContext<BaseFragmentActivity> tbPageContext, h hVar) {
        super(tbPageContext, hVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage<com.baidu.tieba.homepage.alalivelist.data.c, ?>> lS() {
        return RecommendAlaLiveHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage<com.baidu.tieba.homepage.alalivelist.data.c, ?>> lR() {
        return RecommendAlaLiveSocketResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int lO() {
        return CmdConfigHttp.CMD_ALA_LIVE_LIST;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String lP() {
        return TbConfig.ALA_GET_LIVE_LIST_URL;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class getResponseDataClass() {
        return com.baidu.tieba.homepage.alalivelist.data.c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int lQ() {
        return 309431;
    }
}
