package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bxI;
    private GroupActivityData eKB;
    RequestCreateGroupActivityMessage eKC;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eKB = new GroupActivityData();
        this.bxI = baseActivity;
    }

    public GroupActivityData aPN() {
        return this.eKB;
    }

    public void iD(boolean z) {
        if (this.eKB != null) {
            this.eKC = new RequestCreateGroupActivityMessage();
            this.eKC.setCommitType(z ? 1 : 0);
            if (z) {
                this.eKC.setActivityId(this.eKB.getActivityId());
            }
            this.eKC.setgActivityArea(this.eKB.getgActivityArea());
            this.eKC.setgActivityContent(this.eKB.getgActivityContent());
            this.eKC.setgActivityTime(this.eKB.getgActivityTime());
            this.eKC.setgActivityTitle(this.eKB.getgActivityTitle());
            this.eKC.setGroupId(this.eKB.getGroupId());
            this.bxI.sendMessage(this.eKC);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eKC != null) {
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
