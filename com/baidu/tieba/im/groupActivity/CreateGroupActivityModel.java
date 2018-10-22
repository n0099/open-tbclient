package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bwX;
    private GroupActivityData eJj;
    RequestCreateGroupActivityMessage eJk;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eJj = new GroupActivityData();
        this.bwX = baseActivity;
    }

    public GroupActivityData aQq() {
        return this.eJj;
    }

    public void iu(boolean z) {
        if (this.eJj != null) {
            this.eJk = new RequestCreateGroupActivityMessage();
            this.eJk.setCommitType(z ? 1 : 0);
            if (z) {
                this.eJk.setActivityId(this.eJj.getActivityId());
            }
            this.eJk.setgActivityArea(this.eJj.getgActivityArea());
            this.eJk.setgActivityContent(this.eJj.getgActivityContent());
            this.eJk.setgActivityTime(this.eJj.getgActivityTime());
            this.eJk.setgActivityTitle(this.eJj.getgActivityTitle());
            this.eJk.setGroupId(this.eJj.getGroupId());
            this.bwX.sendMessage(this.eJk);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eJk != null) {
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
