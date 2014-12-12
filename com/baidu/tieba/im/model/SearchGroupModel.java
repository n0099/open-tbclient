package com.baidu.tieba.im.model;

import com.baidu.adp.base.f;
import com.baidu.tieba.im.message.RequestSearchGroupsMessage;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
/* loaded from: classes.dex */
public class SearchGroupModel extends f<AddGroupActivity> {
    public SearchGroupModel(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
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

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}
