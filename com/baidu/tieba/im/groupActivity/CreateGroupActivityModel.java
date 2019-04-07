package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity cNc;
    private GroupActivityData gkP;
    RequestCreateGroupActivityMessage gkQ;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gkP = new GroupActivityData();
        this.cNc = baseActivity;
    }

    public GroupActivityData btu() {
        return this.gkP;
    }

    public void lj(boolean z) {
        if (this.gkP != null) {
            this.gkQ = new RequestCreateGroupActivityMessage();
            this.gkQ.setCommitType(z ? 1 : 0);
            if (z) {
                this.gkQ.setActivityId(this.gkP.getActivityId());
            }
            this.gkQ.setgActivityArea(this.gkP.getgActivityArea());
            this.gkQ.setgActivityContent(this.gkP.getgActivityContent());
            this.gkQ.setgActivityTime(this.gkP.getgActivityTime());
            this.gkQ.setgActivityTitle(this.gkP.getgActivityTitle());
            this.gkQ.setGroupId(this.gkP.getGroupId());
            this.cNc.sendMessage(this.gkQ);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gkQ != null) {
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
