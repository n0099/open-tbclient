package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.IUpdatesModel;
import com.baidu.tieba.im.model.UpdatesModel;
/* loaded from: classes.dex */
class r implements IUpdatesModel {
    @Override // com.baidu.tieba.im.model.IUpdatesModel
    public UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo) {
        return UpdatesModel.convertToUpdatesItem(groupNewsPojo);
    }
}
