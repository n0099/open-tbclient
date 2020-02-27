package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes10.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData hBN;
    RequestCreateGroupActivityMessage hBO;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hBN = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData bVz() {
        return this.hBN;
    }

    public void nF(boolean z) {
        if (this.hBN != null) {
            this.hBO = new RequestCreateGroupActivityMessage();
            this.hBO.setCommitType(z ? 1 : 0);
            if (z) {
                this.hBO.setActivityId(this.hBN.getActivityId());
            }
            this.hBO.setgActivityArea(this.hBN.getgActivityArea());
            this.hBO.setgActivityContent(this.hBN.getgActivityContent());
            this.hBO.setgActivityTime(this.hBN.getgActivityTime());
            this.hBO.setgActivityTitle(this.hBN.getgActivityTitle());
            this.hBO.setGroupId(this.hBN.getGroupId());
            this.mActivity.sendMessage(this.hBO);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.hBO != null) {
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
