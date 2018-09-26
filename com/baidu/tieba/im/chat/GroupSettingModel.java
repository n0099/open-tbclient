package com.baidu.tieba.im.chat;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.message.RequestDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes3.dex */
public class GroupSettingModel extends BdBaseModel<GroupSettingActivity> {
    private RequestRemoveMembersMessage erv;
    private RequestDismissGroupMessage erw;
    private GroupSettingActivity erx;
    private int flag;
    private String groupId;
    private String groupName;

    public GroupSettingModel(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.erx = null;
        this.erx = groupSettingActivity;
    }

    public void i(String str, String str2, int i) {
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
        if (this.erv != null) {
            this.erv = null;
        }
    }

    public void hu(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.im.settingcache.b.aPF().h(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId(), z);
                return null;
            }
        }.execute(new Void[0]);
    }

    public void b(com.baidu.tbadk.util.h<Boolean> hVar) {
        x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.w
            public Boolean doInBackground() {
                return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.aPF().bB(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId()));
            }
        }, hVar);
    }

    public void hv(boolean z) {
        RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
        requestUpdateMaskMessage.setSettingMask(true);
        requestUpdateMaskMessage.setGids(this.groupId);
        requestUpdateMaskMessage.setIsAdd(z);
        sendMessage(requestUpdateMaskMessage);
    }

    public void bY(long j) {
        this.erv = new RequestRemoveMembersMessage();
        this.erv.setGroupId(j);
        this.erv.setUserIds(TbadkApplication.getCurrentAccountObj().getID());
        if (this.erx != null) {
            this.erx.sendMessage(this.erv);
        } else {
            sendMessage(this.erv);
        }
    }

    public void bZ(long j) {
        this.erw = new RequestDismissGroupMessage();
        this.erw.setGroupId(j);
        if (this.erx != null) {
            this.erx.sendMessage(this.erw);
        } else {
            sendMessage(this.erw);
        }
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long aJk() {
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
