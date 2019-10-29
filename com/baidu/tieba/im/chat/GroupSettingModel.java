package com.baidu.tieba.im.chat;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.message.RequestDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes5.dex */
public class GroupSettingModel extends BdBaseModel<GroupSettingActivity> {
    private int flag;
    private String groupId;
    private String groupName;
    private RequestRemoveMembersMessage gyY;
    private RequestDismissGroupMessage gyZ;
    private GroupSettingActivity gza;

    public GroupSettingModel(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gza = null;
        this.gza = groupSettingActivity;
    }

    public void o(String str, String str2, int i) {
        setGroupId(str);
        setGroupName(str2);
        setFlag(i);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gyY != null) {
            this.gyY = null;
        }
    }

    public void lw(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.im.settingcache.b.bEd().x(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId(), z);
                return null;
            }
        }.execute(new Void[0]);
    }

    public void b(com.baidu.tbadk.util.j<Boolean> jVar) {
        z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.y
            public Boolean doInBackground() {
                return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.bEd().dc(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId()));
            }
        }, jVar);
    }

    public void lx(boolean z) {
        RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
        requestUpdateMaskMessage.setSettingMask(true);
        requestUpdateMaskMessage.setGids(this.groupId);
        requestUpdateMaskMessage.setIsAdd(z);
        sendMessage(requestUpdateMaskMessage);
    }

    public void cY(long j) {
        this.gyY = new RequestRemoveMembersMessage();
        this.gyY.setGroupId(j);
        this.gyY.setUserIds(TbadkApplication.getCurrentAccountObj().getID());
        if (this.gza != null) {
            this.gza.sendMessage(this.gyY);
        } else {
            sendMessage(this.gyY);
        }
    }

    public void cZ(long j) {
        this.gyZ = new RequestDismissGroupMessage();
        this.gyZ.setGroupId(j);
        if (this.gza != null) {
            this.gza.sendMessage(this.gyZ);
        } else {
            sendMessage(this.gyZ);
        }
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long bxN() {
        return com.baidu.adp.lib.g.b.toLong(this.groupId, 0L);
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }
}
