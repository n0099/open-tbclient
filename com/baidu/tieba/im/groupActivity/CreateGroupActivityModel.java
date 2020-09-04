package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes17.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData jrm;
    RequestCreateGroupActivityMessage jrn;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jrm = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cFG() {
        return this.jrm;
    }

    public void qK(boolean z) {
        if (this.jrm != null) {
            this.jrn = new RequestCreateGroupActivityMessage();
            this.jrn.setCommitType(z ? 1 : 0);
            if (z) {
                this.jrn.setActivityId(this.jrm.getActivityId());
            }
            this.jrn.setgActivityArea(this.jrm.getgActivityArea());
            this.jrn.setgActivityContent(this.jrm.getgActivityContent());
            this.jrn.setgActivityTime(this.jrm.getgActivityTime());
            this.jrn.setgActivityTitle(this.jrm.getgActivityTitle());
            this.jrn.setGroupId(this.jrm.getGroupId());
            this.mActivity.sendMessage(this.jrn);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.jrn != null) {
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
