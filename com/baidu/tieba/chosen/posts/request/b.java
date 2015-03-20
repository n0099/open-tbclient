package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.e;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
/* loaded from: classes.dex */
public class b extends e<c, d, ChosenPostActivity> {
    public b(TbPageContext<ChosenPostActivity> tbPageContext, c cVar) {
        super(tbPageContext, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends ChosenPostHttpResponse> oB() {
        return ChosenPostHttpResponse.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends ChosenPostSocketResponse> oA() {
        return ChosenPostSocketResponse.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int ox() {
        return CmdConfigHttp.CMD_GET_HOT_THREAD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String oy() {
        return "c/f/choiceness/hotthread";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<d> getResponseDataClass() {
        return d.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oz() {
        return 307008;
    }
}
