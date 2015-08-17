package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.model.d<c, d, ChosenPostActivity> {
    public b(TbPageContext<ChosenPostActivity> tbPageContext, c cVar) {
        super(tbPageContext, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends ChosenPostHttpResponse> oY() {
        return ChosenPostHttpResponse.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends ChosenPostSocketResponse> oX() {
        return ChosenPostSocketResponse.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oU() {
        return CmdConfigHttp.CMD_GET_HOT_THREAD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String oV() {
        return "c/f/choiceness/hotthread";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<d> getResponseDataClass() {
        return d.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oW() {
        return 307008;
    }
}
