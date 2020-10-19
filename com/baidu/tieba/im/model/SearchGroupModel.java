package com.baidu.tieba.im.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.im.message.RequestSearchGroupsMessage;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
/* loaded from: classes26.dex */
public class SearchGroupModel extends BdBaseModel<AddGroupActivity> {
    public SearchGroupModel(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
    }

    public void sendMessage(long j) {
        RequestSearchGroupsMessage requestSearchGroupsMessage = new RequestSearchGroupsMessage();
        requestSearchGroupsMessage.setGroupId(j);
        super.sendMessage(requestSearchGroupsMessage);
    }

    public void sendCacheMessage() {
        super.sendMessage(new RequestSearchGroupsMessage());
    }

    public void sendClearMessage() {
        super.sendMessage(new RequestSearchGroupsMessage());
    }

    public void sendUpdateMessage(long j) {
        RequestSearchGroupsMessage requestSearchGroupsMessage = new RequestSearchGroupsMessage();
        requestSearchGroupsMessage.setGroupId(j);
        super.sendMessage(requestSearchGroupsMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
