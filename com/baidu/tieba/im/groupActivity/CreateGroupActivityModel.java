package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes22.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData jzO;
    RequestCreateGroupActivityMessage jzP;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jzO = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cJm() {
        return this.jzO;
    }

    public void qS(boolean z) {
        if (this.jzO != null) {
            this.jzP = new RequestCreateGroupActivityMessage();
            this.jzP.setCommitType(z ? 1 : 0);
            if (z) {
                this.jzP.setActivityId(this.jzO.getActivityId());
            }
            this.jzP.setgActivityArea(this.jzO.getgActivityArea());
            this.jzP.setgActivityContent(this.jzO.getgActivityContent());
            this.jzP.setgActivityTime(this.jzO.getgActivityTime());
            this.jzP.setgActivityTitle(this.jzO.getgActivityTitle());
            this.jzP.setGroupId(this.jzO.getGroupId());
            this.mActivity.sendMessage(this.jzP);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.jzP != null) {
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
