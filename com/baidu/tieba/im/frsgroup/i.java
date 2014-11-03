package com.baidu.tieba.im.frsgroup;

import android.content.Context;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public class i extends NetModel<j, k> {
    public i(Context context, j jVar) {
        super(context, jVar, NetModel.NetModelType.TYPE_SOCKET);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<k> getResponseDataClass() {
        return k.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int tK() {
        return 0;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int tL() {
        return 103002;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String tM() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> tR() {
        return FrsGroupResponseMessage.class;
    }
}
