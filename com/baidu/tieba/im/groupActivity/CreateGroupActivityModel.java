package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes23.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData kvq;
    RequestCreateGroupActivityMessage kvr;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kvq = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cXw() {
        return this.kvq;
    }

    public void sE(boolean z) {
        if (this.kvq != null) {
            this.kvr = new RequestCreateGroupActivityMessage();
            this.kvr.setCommitType(z ? 1 : 0);
            if (z) {
                this.kvr.setActivityId(this.kvq.getActivityId());
            }
            this.kvr.setgActivityArea(this.kvq.getgActivityArea());
            this.kvr.setgActivityContent(this.kvq.getgActivityContent());
            this.kvr.setgActivityTime(this.kvq.getgActivityTime());
            this.kvr.setgActivityTitle(this.kvq.getgActivityTitle());
            this.kvr.setGroupId(this.kvq.getGroupId());
            this.mActivity.sendMessage(this.kvr);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.kvr != null) {
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
