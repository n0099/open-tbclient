package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bsQ;
    private GroupActivityData eBy;
    RequestCreateGroupActivityMessage eBz;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eBy = new GroupActivityData();
        this.bsQ = baseActivity;
    }

    public GroupActivityData aNb() {
        return this.eBy;
    }

    public void ic(boolean z) {
        if (this.eBy != null) {
            this.eBz = new RequestCreateGroupActivityMessage();
            this.eBz.setCommitType(z ? 1 : 0);
            if (z) {
                this.eBz.setActivityId(this.eBy.getActivityId());
            }
            this.eBz.setgActivityArea(this.eBy.getgActivityArea());
            this.eBz.setgActivityContent(this.eBy.getgActivityContent());
            this.eBz.setgActivityTime(this.eBy.getgActivityTime());
            this.eBz.setgActivityTitle(this.eBy.getgActivityTitle());
            this.eBz.setGroupId(this.eBy.getGroupId());
            this.bsQ.sendMessage(this.eBz);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eBz != null) {
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
