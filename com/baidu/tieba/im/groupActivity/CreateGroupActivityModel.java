package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData gIY;
    RequestCreateGroupActivityMessage gIZ;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gIY = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData bBE() {
        return this.gIY;
    }

    public void me(boolean z) {
        if (this.gIY != null) {
            this.gIZ = new RequestCreateGroupActivityMessage();
            this.gIZ.setCommitType(z ? 1 : 0);
            if (z) {
                this.gIZ.setActivityId(this.gIY.getActivityId());
            }
            this.gIZ.setgActivityArea(this.gIY.getgActivityArea());
            this.gIZ.setgActivityContent(this.gIY.getgActivityContent());
            this.gIZ.setgActivityTime(this.gIY.getgActivityTime());
            this.gIZ.setgActivityTitle(this.gIY.getgActivityTitle());
            this.gIZ.setGroupId(this.gIY.getGroupId());
            this.mActivity.sendMessage(this.gIZ);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gIZ != null) {
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
