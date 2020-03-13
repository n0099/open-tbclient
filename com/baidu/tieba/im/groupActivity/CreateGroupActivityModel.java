package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes10.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData hCb;
    RequestCreateGroupActivityMessage hCc;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hCb = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData bVC() {
        return this.hCb;
    }

    public void nF(boolean z) {
        if (this.hCb != null) {
            this.hCc = new RequestCreateGroupActivityMessage();
            this.hCc.setCommitType(z ? 1 : 0);
            if (z) {
                this.hCc.setActivityId(this.hCb.getActivityId());
            }
            this.hCc.setgActivityArea(this.hCb.getgActivityArea());
            this.hCc.setgActivityContent(this.hCb.getgActivityContent());
            this.hCc.setgActivityTime(this.hCb.getgActivityTime());
            this.hCc.setgActivityTitle(this.hCb.getgActivityTitle());
            this.hCc.setGroupId(this.hCb.getGroupId());
            this.mActivity.sendMessage(this.hCc);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.hCc != null) {
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
