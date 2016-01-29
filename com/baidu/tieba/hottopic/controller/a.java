package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.hottopic.message.RequestBlessMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<BaseActivity<?>> {
    private BaseActivity<?> bdK;

    public a(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.bdK = baseActivity;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void a(long j, long j2, int i, int i2, int i3, long j3) {
        b(j, j2, i, i2, i3, j3);
    }

    private void b(long j, long j2, int i, int i2, int i3, long j3) {
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
