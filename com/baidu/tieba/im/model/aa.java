package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestSearchGroupsMessage;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.a.d {
    public void a(long j) {
        RequestSearchGroupsMessage requestSearchGroupsMessage = new RequestSearchGroupsMessage();
        requestSearchGroupsMessage.setGroupId(j);
        com.baidu.tieba.im.messageCenter.e.a().a(requestSearchGroupsMessage);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }
}
