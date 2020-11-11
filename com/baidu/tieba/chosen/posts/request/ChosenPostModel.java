package com.baidu.tieba.chosen.posts.request;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
/* loaded from: classes23.dex */
public class ChosenPostModel extends NetAutoModel<a, b, ChosenPostActivity> {
    public ChosenPostModel(TbPageContext<ChosenPostActivity> tbPageContext, a aVar) {
        super(tbPageContext, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public boolean isNeedCache() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends ChosenPostHttpResponse> aaB() {
        return ChosenPostHttpResponse.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends ChosenPostSocketResponse> aaD() {
        return ChosenPostSocketResponse.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int aay() {
        return 1003005;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String aar() {
        return "c/f/choiceness/hotthread";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<b> getResponseDataClass() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int aax() {
        return CmdConfigSocket.CMD_GET_HOT_THREAD;
    }
}
