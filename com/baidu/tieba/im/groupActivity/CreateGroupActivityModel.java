package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bwX;
    private GroupActivityData eJi;
    RequestCreateGroupActivityMessage eJj;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eJi = new GroupActivityData();
        this.bwX = baseActivity;
    }

    public GroupActivityData aQq() {
        return this.eJi;
    }

    public void iu(boolean z) {
        if (this.eJi != null) {
            this.eJj = new RequestCreateGroupActivityMessage();
            this.eJj.setCommitType(z ? 1 : 0);
            if (z) {
                this.eJj.setActivityId(this.eJi.getActivityId());
            }
            this.eJj.setgActivityArea(this.eJi.getgActivityArea());
            this.eJj.setgActivityContent(this.eJi.getgActivityContent());
            this.eJj.setgActivityTime(this.eJi.getgActivityTime());
            this.eJj.setgActivityTitle(this.eJi.getgActivityTitle());
            this.eJj.setGroupId(this.eJi.getGroupId());
            this.bwX.sendMessage(this.eJj);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eJj != null) {
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
