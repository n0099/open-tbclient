package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes23.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData jOL;
    RequestCreateGroupActivityMessage jOM;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jOL = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cMV() {
        return this.jOL;
    }

    public void ry(boolean z) {
        if (this.jOL != null) {
            this.jOM = new RequestCreateGroupActivityMessage();
            this.jOM.setCommitType(z ? 1 : 0);
            if (z) {
                this.jOM.setActivityId(this.jOL.getActivityId());
            }
            this.jOM.setgActivityArea(this.jOL.getgActivityArea());
            this.jOM.setgActivityContent(this.jOL.getgActivityContent());
            this.jOM.setgActivityTime(this.jOL.getgActivityTime());
            this.jOM.setgActivityTitle(this.jOL.getgActivityTitle());
            this.jOM.setGroupId(this.jOL.getGroupId());
            this.mActivity.sendMessage(this.jOM);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.jOM != null) {
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
