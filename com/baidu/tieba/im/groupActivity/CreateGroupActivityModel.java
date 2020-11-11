package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes23.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData khh;
    RequestCreateGroupActivityMessage khi;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.khh = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cSD() {
        return this.khh;
    }

    public void rZ(boolean z) {
        if (this.khh != null) {
            this.khi = new RequestCreateGroupActivityMessage();
            this.khi.setCommitType(z ? 1 : 0);
            if (z) {
                this.khi.setActivityId(this.khh.getActivityId());
            }
            this.khi.setgActivityArea(this.khh.getgActivityArea());
            this.khi.setgActivityContent(this.khh.getgActivityContent());
            this.khi.setgActivityTime(this.khh.getgActivityTime());
            this.khi.setgActivityTitle(this.khh.getgActivityTitle());
            this.khi.setGroupId(this.khh.getGroupId());
            this.mActivity.sendMessage(this.khi);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.khi != null) {
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
