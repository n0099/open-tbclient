package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes10.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData iCQ;
    RequestCreateGroupActivityMessage iCR;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.iCQ = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cna() {
        return this.iCQ;
    }

    public void pl(boolean z) {
        if (this.iCQ != null) {
            this.iCR = new RequestCreateGroupActivityMessage();
            this.iCR.setCommitType(z ? 1 : 0);
            if (z) {
                this.iCR.setActivityId(this.iCQ.getActivityId());
            }
            this.iCR.setgActivityArea(this.iCQ.getgActivityArea());
            this.iCR.setgActivityContent(this.iCQ.getgActivityContent());
            this.iCR.setgActivityTime(this.iCQ.getgActivityTime());
            this.iCR.setgActivityTitle(this.iCQ.getgActivityTitle());
            this.iCR.setGroupId(this.iCQ.getGroupId());
            this.mActivity.sendMessage(this.iCR);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.iCR != null) {
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
