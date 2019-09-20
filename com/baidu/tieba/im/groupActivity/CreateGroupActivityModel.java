package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity cXM;
    private GroupActivityData gLa;
    RequestCreateGroupActivityMessage gLb;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gLa = new GroupActivityData();
        this.cXM = baseActivity;
    }

    public GroupActivityData bET() {
        return this.gLa;
    }

    public void mq(boolean z) {
        if (this.gLa != null) {
            this.gLb = new RequestCreateGroupActivityMessage();
            this.gLb.setCommitType(z ? 1 : 0);
            if (z) {
                this.gLb.setActivityId(this.gLa.getActivityId());
            }
            this.gLb.setgActivityArea(this.gLa.getgActivityArea());
            this.gLb.setgActivityContent(this.gLa.getgActivityContent());
            this.gLb.setgActivityTime(this.gLa.getgActivityTime());
            this.gLb.setgActivityTitle(this.gLa.getgActivityTitle());
            this.gLb.setGroupId(this.gLa.getGroupId());
            this.cXM.sendMessage(this.gLb);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gLb != null) {
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
