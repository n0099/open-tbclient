package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bcJ;
    private GroupActivityData eaa;
    RequestCreateGroupActivityMessage eab;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eaa = new GroupActivityData();
        this.bcJ = baseActivity;
    }

    public GroupActivityData aEo() {
        return this.eaa;
    }

    public void hk(boolean z) {
        if (this.eaa != null) {
            this.eab = new RequestCreateGroupActivityMessage();
            this.eab.setCommitType(z ? 1 : 0);
            if (z) {
                this.eab.setActivityId(this.eaa.getActivityId());
            }
            this.eab.setgActivityArea(this.eaa.getgActivityArea());
            this.eab.setgActivityContent(this.eaa.getgActivityContent());
            this.eab.setgActivityTime(this.eaa.getgActivityTime());
            this.eab.setgActivityTitle(this.eaa.getgActivityTitle());
            this.eab.setGroupId(this.eaa.getGroupId());
            this.bcJ.sendMessage(this.eab);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eab != null) {
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
