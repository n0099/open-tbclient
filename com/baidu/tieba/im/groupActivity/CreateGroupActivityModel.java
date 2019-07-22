package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity cWM;
    private GroupActivityData gIq;
    RequestCreateGroupActivityMessage gIr;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gIq = new GroupActivityData();
        this.cWM = baseActivity;
    }

    public GroupActivityData bDR() {
        return this.gIq;
    }

    public void mn(boolean z) {
        if (this.gIq != null) {
            this.gIr = new RequestCreateGroupActivityMessage();
            this.gIr.setCommitType(z ? 1 : 0);
            if (z) {
                this.gIr.setActivityId(this.gIq.getActivityId());
            }
            this.gIr.setgActivityArea(this.gIq.getgActivityArea());
            this.gIr.setgActivityContent(this.gIq.getgActivityContent());
            this.gIr.setgActivityTime(this.gIq.getgActivityTime());
            this.gIr.setgActivityTitle(this.gIq.getgActivityTitle());
            this.gIr.setGroupId(this.gIq.getGroupId());
            this.cWM.sendMessage(this.gIr);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gIr != null) {
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
