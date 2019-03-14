package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity cNa;
    private GroupActivityData glc;
    RequestCreateGroupActivityMessage gld;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.glc = new GroupActivityData();
        this.cNa = baseActivity;
    }

    public GroupActivityData btx() {
        return this.glc;
    }

    public void lj(boolean z) {
        if (this.glc != null) {
            this.gld = new RequestCreateGroupActivityMessage();
            this.gld.setCommitType(z ? 1 : 0);
            if (z) {
                this.gld.setActivityId(this.glc.getActivityId());
            }
            this.gld.setgActivityArea(this.glc.getgActivityArea());
            this.gld.setgActivityContent(this.glc.getgActivityContent());
            this.gld.setgActivityTime(this.glc.getgActivityTime());
            this.gld.setgActivityTitle(this.glc.getgActivityTitle());
            this.gld.setGroupId(this.glc.getGroupId());
            this.cNa.sendMessage(this.gld);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gld != null) {
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
