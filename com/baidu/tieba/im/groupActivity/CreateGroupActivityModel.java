package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes10.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData iCd;
    RequestCreateGroupActivityMessage iCe;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.iCd = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cmR() {
        return this.iCd;
    }

    public void pl(boolean z) {
        if (this.iCd != null) {
            this.iCe = new RequestCreateGroupActivityMessage();
            this.iCe.setCommitType(z ? 1 : 0);
            if (z) {
                this.iCe.setActivityId(this.iCd.getActivityId());
            }
            this.iCe.setgActivityArea(this.iCd.getgActivityArea());
            this.iCe.setgActivityContent(this.iCd.getgActivityContent());
            this.iCe.setgActivityTime(this.iCd.getgActivityTime());
            this.iCe.setgActivityTitle(this.iCd.getgActivityTitle());
            this.iCe.setGroupId(this.iCd.getGroupId());
            this.mActivity.sendMessage(this.iCe);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.iCe != null) {
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
