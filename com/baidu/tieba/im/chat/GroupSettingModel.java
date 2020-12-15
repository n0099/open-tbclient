package com.baidu.tieba.im.chat;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.message.RequestDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes23.dex */
public class GroupSettingModel extends BdBaseModel<GroupSettingActivity> {
    private int flag;
    private String groupId;
    private String groupName;
    private RequestRemoveMembersMessage kjA;
    private RequestDismissGroupMessage kjB;
    private GroupSettingActivity kjC;

    public GroupSettingModel(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.kjC = null;
        this.kjC = groupSettingActivity;
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
        if (this.kjA != null) {
            this.kjA = null;
        }
    }

    public void rV(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.im.settingcache.b.cZX().B(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId(), z);
                return null;
            }
        }.execute(new Void[0]);
    }

    public void b(m<Boolean> mVar) {
        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ac
            public Boolean doInBackground() {
                return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.cZX().fy(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId()));
            }
        }, mVar);
    }

    public void rW(boolean z) {
        RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
        requestUpdateMaskMessage.setSettingMask(true);
        requestUpdateMaskMessage.setGids(this.groupId);
        requestUpdateMaskMessage.setIsAdd(z);
        sendMessage(requestUpdateMaskMessage);
    }

    public void gG(long j) {
        this.kjA = new RequestRemoveMembersMessage();
        this.kjA.setGroupId(j);
        this.kjA.setUserIds(TbadkApplication.getCurrentAccountObj().getID());
        if (this.kjC != null) {
            this.kjC.sendMessage(this.kjA);
        } else {
            sendMessage(this.kjA);
        }
    }

    public void gH(long j) {
        this.kjB = new RequestDismissGroupMessage();
        this.kjB.setGroupId(j);
        if (this.kjC != null) {
            this.kjC.sendMessage(this.kjB);
        } else {
            sendMessage(this.kjB);
        }
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long cTo() {
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
