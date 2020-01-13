package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes8.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData hzO;
    RequestCreateGroupActivityMessage hzP;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hzO = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData bTY() {
        return this.hzO;
    }

    public void nD(boolean z) {
        if (this.hzO != null) {
            this.hzP = new RequestCreateGroupActivityMessage();
            this.hzP.setCommitType(z ? 1 : 0);
            if (z) {
                this.hzP.setActivityId(this.hzO.getActivityId());
            }
            this.hzP.setgActivityArea(this.hzO.getgActivityArea());
            this.hzP.setgActivityContent(this.hzO.getgActivityContent());
            this.hzP.setgActivityTime(this.hzO.getgActivityTime());
            this.hzP.setgActivityTitle(this.hzO.getgActivityTitle());
            this.hzP.setGroupId(this.hzO.getGroupId());
            this.mActivity.sendMessage(this.hzP);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.hzP != null) {
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
