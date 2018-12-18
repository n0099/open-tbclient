package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bBf;
    private GroupActivityData eRq;
    RequestCreateGroupActivityMessage eRr;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eRq = new GroupActivityData();
        this.bBf = baseActivity;
    }

    public GroupActivityData aRE() {
        return this.eRq;
    }

    public void iG(boolean z) {
        if (this.eRq != null) {
            this.eRr = new RequestCreateGroupActivityMessage();
            this.eRr.setCommitType(z ? 1 : 0);
            if (z) {
                this.eRr.setActivityId(this.eRq.getActivityId());
            }
            this.eRr.setgActivityArea(this.eRq.getgActivityArea());
            this.eRr.setgActivityContent(this.eRq.getgActivityContent());
            this.eRr.setgActivityTime(this.eRq.getgActivityTime());
            this.eRr.setgActivityTitle(this.eRq.getgActivityTitle());
            this.eRr.setGroupId(this.eRq.getGroupId());
            this.bBf.sendMessage(this.eRr);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eRr != null) {
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
