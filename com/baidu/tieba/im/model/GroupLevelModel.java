package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.message.RequestGroupLevelMessage;
/* loaded from: classes17.dex */
public class GroupLevelModel extends BdBaseModel<GroupLevelActivity> {
    public static final String GROUP_ID = "group_id";
    public static final String IS_MEM = "is_mem";
    private boolean isMem;
    private long mGroupId;

    public GroupLevelModel(GroupLevelActivity groupLevelActivity) {
        super(groupLevelActivity.getPageContext());
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public boolean isMem() {
        return this.isMem;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.mGroupId = intent.getLongExtra("group_id", 0L);
            this.isMem = intent.getBooleanExtra("is_mem", false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.mGroupId = bundle.getLong("group_id");
            this.isMem = bundle.getBoolean("is_mem");
        }
    }

    private RequestGroupLevelMessage createMessage(long j) {
        RequestGroupLevelMessage requestGroupLevelMessage = new RequestGroupLevelMessage();
        requestGroupLevelMessage.setGroupId(j);
        return requestGroupLevelMessage;
    }

    public void sendMessage(long j, BdUniqueId bdUniqueId) {
        RequestGroupLevelMessage createMessage = createMessage(j);
        if (createMessage.getTag() == null) {
            createMessage.setTag(bdUniqueId);
        }
        super.sendMessage(createMessage);
    }

    public void saveInstance(Bundle bundle) {
        if (bundle != null) {
            bundle.putLong("group_id", this.mGroupId);
            bundle.putBoolean("is_mem", this.isMem);
        }
    }
}
