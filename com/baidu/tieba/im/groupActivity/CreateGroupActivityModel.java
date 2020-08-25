package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes17.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData jrg;
    RequestCreateGroupActivityMessage jrh;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jrg = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cFF() {
        return this.jrg;
    }

    public void qI(boolean z) {
        if (this.jrg != null) {
            this.jrh = new RequestCreateGroupActivityMessage();
            this.jrh.setCommitType(z ? 1 : 0);
            if (z) {
                this.jrh.setActivityId(this.jrg.getActivityId());
            }
            this.jrh.setgActivityArea(this.jrg.getgActivityArea());
            this.jrh.setgActivityContent(this.jrg.getgActivityContent());
            this.jrh.setgActivityTime(this.jrg.getgActivityTime());
            this.jrh.setgActivityTitle(this.jrg.getgActivityTitle());
            this.jrh.setGroupId(this.jrg.getGroupId());
            this.mActivity.sendMessage(this.jrh);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.jrh != null) {
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
