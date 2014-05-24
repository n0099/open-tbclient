package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestSearchGroupsMessage;
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.base.b {
    public void a(int i) {
        RequestSearchGroupsMessage requestSearchGroupsMessage = new RequestSearchGroupsMessage();
        requestSearchGroupsMessage.setGroupId(i);
        super.sendMessage(requestSearchGroupsMessage);
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }
}
