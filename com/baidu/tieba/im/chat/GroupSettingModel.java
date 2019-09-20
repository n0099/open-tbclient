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
    private RequestRemoveMembersMessage gBa;
    private RequestDismissGroupMessage gBb;
    private GroupSettingActivity gBc;
    private String groupId;
    private String groupName;

    public GroupSettingModel(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gBc = null;
        this.gBc = groupSettingActivity;
    }

    public void q(String str, String str2, int i) {
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
        if (this.gBa != null) {
            this.gBa = null;
        }
    }

    public void lI(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.im.settingcache.b.bHs().x(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId(), z);
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
                return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.bHs().dr(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId()));
            }
        }, jVar);
    }

    public void lJ(boolean z) {
        RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
        requestUpdateMaskMessage.setSettingMask(true);
        requestUpdateMaskMessage.setGids(this.groupId);
        requestUpdateMaskMessage.setIsAdd(z);
        sendMessage(requestUpdateMaskMessage);
    }

    public void dB(long j) {
        this.gBa = new RequestRemoveMembersMessage();
        this.gBa.setGroupId(j);
        this.gBa.setUserIds(TbadkApplication.getCurrentAccountObj().getID());
        if (this.gBc != null) {
            this.gBc.sendMessage(this.gBa);
        } else {
            sendMessage(this.gBa);
        }
    }

    public void dC(long j) {
        this.gBb = new RequestDismissGroupMessage();
        this.gBb.setGroupId(j);
        if (this.gBc != null) {
            this.gBc.sendMessage(this.gBb);
        } else {
            sendMessage(this.gBb);
        }
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long bBc() {
        return com.baidu.adp.lib.g.b.e(this.groupId, 0L);
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
