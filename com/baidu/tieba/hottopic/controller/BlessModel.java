package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes4.dex */
public class BlessModel extends BdBaseModel<BaseActivity<?>> {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f17215e;

    public BlessModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.f17215e = baseActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void s(long j, long j2, int i, int i2, int i3, long j3) {
        t(j, j2, i, i2, i3, j3);
    }

    public final void t(long j, long j2, int i, int i2, int i3, long j3) {
        RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
        requestBlessMessage.setPkId(Long.valueOf(j));
        requestBlessMessage.setTopicId(Long.valueOf(j2));
        requestBlessMessage.setPkIndex(i);
        requestBlessMessage.setClickType(i2);
        requestBlessMessage.setPkType(i3);
        requestBlessMessage.setUserPkId(j3);
        sendMessage(requestBlessMessage);
    }
}
