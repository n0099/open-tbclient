package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bmZ;
    private GroupActivityData euj;
    RequestCreateGroupActivityMessage euk;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.euj = new GroupActivityData();
        this.bmZ = baseActivity;
    }

    public GroupActivityData aKP() {
        return this.euj;
    }

    public void hE(boolean z) {
        if (this.euj != null) {
            this.euk = new RequestCreateGroupActivityMessage();
            this.euk.setCommitType(z ? 1 : 0);
            if (z) {
                this.euk.setActivityId(this.euj.getActivityId());
            }
            this.euk.setgActivityArea(this.euj.getgActivityArea());
            this.euk.setgActivityContent(this.euj.getgActivityContent());
            this.euk.setgActivityTime(this.euj.getgActivityTime());
            this.euk.setgActivityTitle(this.euj.getgActivityTitle());
            this.euk.setGroupId(this.euj.getGroupId());
            this.bmZ.sendMessage(this.euk);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.euk != null) {
        }
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
