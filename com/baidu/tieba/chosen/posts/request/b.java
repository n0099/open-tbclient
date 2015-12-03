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
    protected Class<? extends ChosenPostHttpResponse> pd() {
        return ChosenPostHttpResponse.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends ChosenPostSocketResponse> pc() {
        return ChosenPostSocketResponse.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oZ() {
        return CmdConfigHttp.CMD_GET_HOT_THREAD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String pa() {
        return "c/f/choiceness/hotthread";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<d> getResponseDataClass() {
        return d.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int pb() {
        return 307008;
    }
}
