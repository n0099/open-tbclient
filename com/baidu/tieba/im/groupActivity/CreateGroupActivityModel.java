package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes17.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData jcg;
    RequestCreateGroupActivityMessage jch;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jcg = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cuO() {
        return this.jcg;
    }

    public void qc(boolean z) {
        if (this.jcg != null) {
            this.jch = new RequestCreateGroupActivityMessage();
            this.jch.setCommitType(z ? 1 : 0);
            if (z) {
                this.jch.setActivityId(this.jcg.getActivityId());
            }
            this.jch.setgActivityArea(this.jcg.getgActivityArea());
            this.jch.setgActivityContent(this.jcg.getgActivityContent());
            this.jch.setgActivityTime(this.jcg.getgActivityTime());
            this.jch.setgActivityTitle(this.jcg.getgActivityTitle());
            this.jch.setGroupId(this.jcg.getGroupId());
            this.mActivity.sendMessage(this.jch);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.jch != null) {
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
