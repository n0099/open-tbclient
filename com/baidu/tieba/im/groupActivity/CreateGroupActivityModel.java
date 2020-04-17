package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes10.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData inq;
    RequestCreateGroupActivityMessage inr;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.inq = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cgv() {
        return this.inq;
    }

    public void oP(boolean z) {
        if (this.inq != null) {
            this.inr = new RequestCreateGroupActivityMessage();
            this.inr.setCommitType(z ? 1 : 0);
            if (z) {
                this.inr.setActivityId(this.inq.getActivityId());
            }
            this.inr.setgActivityArea(this.inq.getgActivityArea());
            this.inr.setgActivityContent(this.inq.getgActivityContent());
            this.inr.setgActivityTime(this.inq.getgActivityTime());
            this.inr.setgActivityTitle(this.inq.getgActivityTitle());
            this.inr.setGroupId(this.inq.getGroupId());
            this.mActivity.sendMessage(this.inr);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.inr != null) {
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
