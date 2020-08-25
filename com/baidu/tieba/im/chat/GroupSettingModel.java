package com.baidu.tieba.im.chat;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.message.RequestDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes17.dex */
public class GroupSettingModel extends BdBaseModel<GroupSettingActivity> {
    private int flag;
    private String groupId;
    private String groupName;
    private RequestRemoveMembersMessage jfe;
    private RequestDismissGroupMessage jff;
    private GroupSettingActivity jfg;

    public GroupSettingModel(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.jfg = null;
        this.jfg = groupSettingActivity;
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
        if (this.jfe != null) {
            this.jfe = null;
        }
    }

    public void pZ(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.im.settingcache.b.cIh().z(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId(), z);
                return null;
            }
        }.execute(new Void[0]);
    }

    public void b(l<Boolean> lVar) {
        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.chat.GroupSettingModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ac
            public Boolean doInBackground() {
                return Boolean.valueOf(com.baidu.tieba.im.settingcache.b.cIh().eT(TbadkApplication.getCurrentAccount(), GroupSettingModel.this.getGroupId()));
            }
        }, lVar);
    }

    public void qa(boolean z) {
        RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
        requestUpdateMaskMessage.setSettingMask(true);
        requestUpdateMaskMessage.setGids(this.groupId);
        requestUpdateMaskMessage.setIsAdd(z);
        sendMessage(requestUpdateMaskMessage);
    }

    public void eV(long j) {
        this.jfe = new RequestRemoveMembersMessage();
        this.jfe.setGroupId(j);
        this.jfe.setUserIds(TbadkApplication.getCurrentAccountObj().getID());
        if (this.jfg != null) {
            this.jfg.sendMessage(this.jfe);
        } else {
            sendMessage(this.jfe);
        }
    }

    public void eW(long j) {
        this.jff = new RequestDismissGroupMessage();
        this.jff.setGroupId(j);
        if (this.jfg != null) {
            this.jfg.sendMessage(this.jff);
        } else {
            sendMessage(this.jff);
        }
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long cBu() {
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
