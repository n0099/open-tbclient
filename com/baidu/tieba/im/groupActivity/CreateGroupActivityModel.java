package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity cVq;
    private GroupActivityData gCg;
    RequestCreateGroupActivityMessage gCh;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gCg = new GroupActivityData();
        this.cVq = baseActivity;
    }

    public GroupActivityData bBk() {
        return this.gCg;
    }

    public void lZ(boolean z) {
        if (this.gCg != null) {
            this.gCh = new RequestCreateGroupActivityMessage();
            this.gCh.setCommitType(z ? 1 : 0);
            if (z) {
                this.gCh.setActivityId(this.gCg.getActivityId());
            }
            this.gCh.setgActivityArea(this.gCg.getgActivityArea());
            this.gCh.setgActivityContent(this.gCg.getgActivityContent());
            this.gCh.setgActivityTime(this.gCg.getgActivityTime());
            this.gCh.setgActivityTitle(this.gCg.getgActivityTitle());
            this.gCh.setGroupId(this.gCg.getGroupId());
            this.cVq.sendMessage(this.gCh);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gCh != null) {
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
