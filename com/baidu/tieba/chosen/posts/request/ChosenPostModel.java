package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
import d.a.j0.y.a.d.a;
import d.a.j0.y.a.d.b;
/* loaded from: classes4.dex */
public class ChosenPostModel extends NetAutoModel<a, b, ChosenPostActivity> {
    public ChosenPostModel(TbPageContext<ChosenPostActivity> tbPageContext, a aVar) {
        super(tbPageContext, aVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int F() {
        return CmdConfigHttp.CMD_GET_HOT_THREAD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends ChosenPostHttpResponse> H() {
        return ChosenPostHttpResponse.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String I() {
        return "c/f/choiceness/hotthread";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int J() {
        return 307008;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends ChosenPostSocketResponse> K() {
        return ChosenPostSocketResponse.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<b> getResponseDataClass() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return true;
    }
}
