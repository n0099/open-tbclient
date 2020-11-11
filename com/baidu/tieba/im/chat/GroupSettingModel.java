package com.baidu.tieba.im.chat;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.message.RequestDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes23.dex */
public class GroupSettingModel extends BdBaseModel<GroupSettingActivity> {
    private int flag;
    private String groupId;
    private String groupName;
    private RequestRemoveMembersMessage jVj;
    private RequestDismissGroupMessage jVk;
    private GroupSettingActivity jVl;

    public GroupSettingModel(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.jVl = null;
        this.jVl = groupSettingActivity;
    }

    public void r(String str, String str2, int i) {
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
        if (this.jVj != null) {
            this.jVj = null;
        }
    }

    public void rq(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.im.settingcache.b.cVe().A(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId(), z);
                return null;
            }
        }.execute(new Void[0]);
    }

    public void b(m<Boolean> mVar) {
        ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ad
            public Boolean doInBackground() {
                return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.cVe().ft(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId()));
            }
        }, mVar);
    }

    public void rr(boolean z) {
        RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
        requestUpdateMaskMessage.setSettingMask(true);
        requestUpdateMaskMessage.setGids(this.groupId);
        requestUpdateMaskMessage.setIsAdd(z);
        sendMessage(requestUpdateMaskMessage);
    }

    public void fY(long j) {
        this.jVj = new RequestRemoveMembersMessage();
        this.jVj.setGroupId(j);
        this.jVj.setUserIds(TbadkApplication.getCurrentAccountObj().getID());
        if (this.jVl != null) {
            this.jVl.sendMessage(this.jVj);
        } else {
            sendMessage(this.jVj);
        }
    }

    public void fZ(long j) {
        this.jVk = new RequestDismissGroupMessage();
        this.jVk.setGroupId(j);
        if (this.jVl != null) {
            this.jVl.sendMessage(this.jVk);
        } else {
            sendMessage(this.jVk);
        }
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long cOt() {
        return com.baidu.adp.lib.f.b.toLong(this.groupId, 0L);
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
