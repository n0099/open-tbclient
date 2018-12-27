package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bBi;
    private GroupActivityData eUh;
    RequestCreateGroupActivityMessage eUi;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eUh = new GroupActivityData();
        this.bBi = baseActivity;
    }

    public GroupActivityData aSs() {
        return this.eUh;
    }

    public void iJ(boolean z) {
        if (this.eUh != null) {
            this.eUi = new RequestCreateGroupActivityMessage();
            this.eUi.setCommitType(z ? 1 : 0);
            if (z) {
                this.eUi.setActivityId(this.eUh.getActivityId());
            }
            this.eUi.setgActivityArea(this.eUh.getgActivityArea());
            this.eUi.setgActivityContent(this.eUh.getgActivityContent());
            this.eUi.setgActivityTime(this.eUh.getgActivityTime());
            this.eUi.setgActivityTitle(this.eUh.getgActivityTitle());
            this.eUi.setGroupId(this.eUh.getGroupId());
            this.bBi.sendMessage(this.eUi);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eUi != null) {
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
