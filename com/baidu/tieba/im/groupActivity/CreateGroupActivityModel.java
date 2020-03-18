package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes10.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData hDB;
    RequestCreateGroupActivityMessage hDC;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hDB = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData bVU() {
        return this.hDB;
    }

    public void nL(boolean z) {
        if (this.hDB != null) {
            this.hDC = new RequestCreateGroupActivityMessage();
            this.hDC.setCommitType(z ? 1 : 0);
            if (z) {
                this.hDC.setActivityId(this.hDB.getActivityId());
            }
            this.hDC.setgActivityArea(this.hDB.getgActivityArea());
            this.hDC.setgActivityContent(this.hDB.getgActivityContent());
            this.hDC.setgActivityTime(this.hDB.getgActivityTime());
            this.hDC.setgActivityTitle(this.hDB.getgActivityTitle());
            this.hDC.setGroupId(this.hDB.getGroupId());
            this.mActivity.sendMessage(this.hDC);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.hDC != null) {
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
