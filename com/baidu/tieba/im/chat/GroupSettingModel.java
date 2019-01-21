package com.baidu.tieba.im.chat;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.im.message.RequestDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes3.dex */
public class GroupSettingModel extends BdBaseModel<GroupSettingActivity> {
    private RequestRemoveMembersMessage eKY;
    private RequestDismissGroupMessage eKZ;
    private GroupSettingActivity eLa;
    private int flag;
    private String groupId;
    private String groupName;

    public GroupSettingModel(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.eLa = null;
        this.eLa = groupSettingActivity;
    }

    public void j(String str, String str2, int i) {
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
        if (this.eKY != null) {
            this.eKY = null;
        }
    }

    public void ib(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.im.settingcache.b.aVv().i(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId(), z);
                return null;
            }
        }.execute(new Void[0]);
    }

    public void b(com.baidu.tbadk.util.h<Boolean> hVar) {
        y.b(new x<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.x
            public Boolean doInBackground() {
                return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.aVv().bT(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId()));
            }
        }, hVar);
    }

    public void ic(boolean z) {
        RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
        requestUpdateMaskMessage.setSettingMask(true);
        requestUpdateMaskMessage.setGids(this.groupId);
        requestUpdateMaskMessage.setIsAdd(z);
        sendMessage(requestUpdateMaskMessage);
    }

    public void cm(long j) {
        this.eKY = new RequestRemoveMembersMessage();
        this.eKY.setGroupId(j);
        this.eKY.setUserIds(TbadkApplication.getCurrentAccountObj().getID());
        if (this.eLa != null) {
            this.eLa.sendMessage(this.eKY);
        } else {
            sendMessage(this.eKY);
        }
    }

    public void cn(long j) {
        this.eKZ = new RequestDismissGroupMessage();
        this.eKZ.setGroupId(j);
        if (this.eLa != null) {
            this.eLa.sendMessage(this.eKZ);
        } else {
            sendMessage(this.eKZ);
        }
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long aPe() {
        return com.baidu.adp.lib.g.b.d(this.groupId, 0L);
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
