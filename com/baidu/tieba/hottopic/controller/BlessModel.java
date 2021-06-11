package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes4.dex */
public class BlessModel extends BdBaseModel<BaseActivity<?>> {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f16817e;

    public BlessModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.f16817e = baseActivity;
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

    public void w(long j, long j2, int i2, int i3, int i4, long j3) {
        x(j, j2, i2, i3, i4, j3);
    }

    public final void x(long j, long j2, int i2, int i3, int i4, long j3) {
        RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
        requestBlessMessage.setPkId(Long.valueOf(j));
        requestBlessMessage.setTopicId(Long.valueOf(j2));
        requestBlessMessage.setPkIndex(i2);
        requestBlessMessage.setClickType(i3);
        requestBlessMessage.setPkType(i4);
        requestBlessMessage.setUserPkId(j3);
        sendMessage(requestBlessMessage);
    }
}
