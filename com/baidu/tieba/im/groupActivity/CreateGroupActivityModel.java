package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bmt;
    private GroupActivityData eqq;
    RequestCreateGroupActivityMessage eqr;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eqq = new GroupActivityData();
        this.bmt = baseActivity;
    }

    public GroupActivityData aJO() {
        return this.eqq;
    }

    public void hB(boolean z) {
        if (this.eqq != null) {
            this.eqr = new RequestCreateGroupActivityMessage();
            this.eqr.setCommitType(z ? 1 : 0);
            if (z) {
                this.eqr.setActivityId(this.eqq.getActivityId());
            }
            this.eqr.setgActivityArea(this.eqq.getgActivityArea());
            this.eqr.setgActivityContent(this.eqq.getgActivityContent());
            this.eqr.setgActivityTime(this.eqq.getgActivityTime());
            this.eqr.setgActivityTitle(this.eqq.getgActivityTitle());
            this.eqr.setGroupId(this.eqq.getGroupId());
            this.bmt.sendMessage(this.eqr);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eqr != null) {
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
