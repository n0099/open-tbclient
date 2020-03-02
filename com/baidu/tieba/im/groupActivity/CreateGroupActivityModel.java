package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes10.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData hBP;
    RequestCreateGroupActivityMessage hBQ;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hBP = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData bVB() {
        return this.hBP;
    }

    public void nF(boolean z) {
        if (this.hBP != null) {
            this.hBQ = new RequestCreateGroupActivityMessage();
            this.hBQ.setCommitType(z ? 1 : 0);
            if (z) {
                this.hBQ.setActivityId(this.hBP.getActivityId());
            }
            this.hBQ.setgActivityArea(this.hBP.getgActivityArea());
            this.hBQ.setgActivityContent(this.hBP.getgActivityContent());
            this.hBQ.setgActivityTime(this.hBP.getgActivityTime());
            this.hBQ.setgActivityTitle(this.hBP.getgActivityTitle());
            this.hBQ.setGroupId(this.hBP.getGroupId());
            this.mActivity.sendMessage(this.hBQ);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.hBQ != null) {
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
