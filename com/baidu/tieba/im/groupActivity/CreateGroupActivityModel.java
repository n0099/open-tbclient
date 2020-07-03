package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes10.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData iTU;
    RequestCreateGroupActivityMessage iTV;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.iTU = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cqP() {
        return this.iTU;
    }

    public void pv(boolean z) {
        if (this.iTU != null) {
            this.iTV = new RequestCreateGroupActivityMessage();
            this.iTV.setCommitType(z ? 1 : 0);
            if (z) {
                this.iTV.setActivityId(this.iTU.getActivityId());
            }
            this.iTV.setgActivityArea(this.iTU.getgActivityArea());
            this.iTV.setgActivityContent(this.iTU.getgActivityContent());
            this.iTV.setgActivityTime(this.iTU.getgActivityTime());
            this.iTV.setgActivityTitle(this.iTU.getgActivityTitle());
            this.iTV.setGroupId(this.iTU.getGroupId());
            this.mActivity.sendMessage(this.iTV);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.iTV != null) {
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
