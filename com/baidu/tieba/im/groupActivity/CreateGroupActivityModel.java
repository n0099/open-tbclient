package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity cVp;
    private GroupActivityData gCe;
    RequestCreateGroupActivityMessage gCf;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gCe = new GroupActivityData();
        this.cVp = baseActivity;
    }

    public GroupActivityData bBj() {
        return this.gCe;
    }

    public void lY(boolean z) {
        if (this.gCe != null) {
            this.gCf = new RequestCreateGroupActivityMessage();
            this.gCf.setCommitType(z ? 1 : 0);
            if (z) {
                this.gCf.setActivityId(this.gCe.getActivityId());
            }
            this.gCf.setgActivityArea(this.gCe.getgActivityArea());
            this.gCf.setgActivityContent(this.gCe.getgActivityContent());
            this.gCf.setgActivityTime(this.gCe.getgActivityTime());
            this.gCf.setgActivityTitle(this.gCe.getgActivityTitle());
            this.gCf.setGroupId(this.gCe.getGroupId());
            this.cVp.sendMessage(this.gCf);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gCf != null) {
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
