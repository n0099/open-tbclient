package com.baidu.tieba.im.model;

import android.content.Context;
import com.baidu.adp.base.e;
import com.baidu.tieba.im.message.RequestSearchGroupsMessage;
/* loaded from: classes.dex */
public class SearchGroupModel extends e {
    public SearchGroupModel(Context context) {
        super(context);
    }

    public void sendMessage(int i) {
        RequestSearchGroupsMessage requestSearchGroupsMessage = new RequestSearchGroupsMessage();
        requestSearchGroupsMessage.setGroupId(i);
        super.sendMessage(requestSearchGroupsMessage);
    }

    public void sendCacheMessage() {
        super.sendMessage(new RequestSearchGroupsMessage());
    }

    public void sendClearMessage() {
        super.sendMessage(new RequestSearchGroupsMessage());
    }

    public void sendUpdateMessage(int i) {
        RequestSearchGroupsMessage requestSearchGroupsMessage = new RequestSearchGroupsMessage();
        requestSearchGroupsMessage.setGroupId(i);
        super.sendMessage(requestSearchGroupsMessage);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
