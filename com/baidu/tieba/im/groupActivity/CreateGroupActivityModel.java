package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes17.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData jce;
    RequestCreateGroupActivityMessage jcf;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jce = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cuO() {
        return this.jce;
    }

    public void qc(boolean z) {
        if (this.jce != null) {
            this.jcf = new RequestCreateGroupActivityMessage();
            this.jcf.setCommitType(z ? 1 : 0);
            if (z) {
                this.jcf.setActivityId(this.jce.getActivityId());
            }
            this.jcf.setgActivityArea(this.jce.getgActivityArea());
            this.jcf.setgActivityContent(this.jce.getgActivityContent());
            this.jcf.setgActivityTime(this.jce.getgActivityTime());
            this.jcf.setgActivityTitle(this.jce.getgActivityTitle());
            this.jcf.setGroupId(this.jce.getGroupId());
            this.mActivity.sendMessage(this.jcf);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.jcf != null) {
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
