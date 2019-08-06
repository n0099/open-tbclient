package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity cWT;
    private GroupActivityData gJi;
    RequestCreateGroupActivityMessage gJj;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gJi = new GroupActivityData();
        this.cWT = baseActivity;
    }

    public GroupActivityData bEf() {
        return this.gJi;
    }

    public void mn(boolean z) {
        if (this.gJi != null) {
            this.gJj = new RequestCreateGroupActivityMessage();
            this.gJj.setCommitType(z ? 1 : 0);
            if (z) {
                this.gJj.setActivityId(this.gJi.getActivityId());
            }
            this.gJj.setgActivityArea(this.gJi.getgActivityArea());
            this.gJj.setgActivityContent(this.gJi.getgActivityContent());
            this.gJj.setgActivityTime(this.gJi.getgActivityTime());
            this.gJj.setgActivityTitle(this.gJi.getgActivityTitle());
            this.gJj.setGroupId(this.gJi.getGroupId());
            this.cWT.sendMessage(this.gJj);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gJj != null) {
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
