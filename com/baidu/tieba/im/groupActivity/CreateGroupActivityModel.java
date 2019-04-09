package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity cNd;
    private GroupActivityData gkQ;
    RequestCreateGroupActivityMessage gkR;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gkQ = new GroupActivityData();
        this.cNd = baseActivity;
    }

    public GroupActivityData btu() {
        return this.gkQ;
    }

    public void lj(boolean z) {
        if (this.gkQ != null) {
            this.gkR = new RequestCreateGroupActivityMessage();
            this.gkR.setCommitType(z ? 1 : 0);
            if (z) {
                this.gkR.setActivityId(this.gkQ.getActivityId());
            }
            this.gkR.setgActivityArea(this.gkQ.getgActivityArea());
            this.gkR.setgActivityContent(this.gkQ.getgActivityContent());
            this.gkR.setgActivityTime(this.gkQ.getgActivityTime());
            this.gkR.setgActivityTitle(this.gkQ.getgActivityTitle());
            this.gkR.setGroupId(this.gkQ.getGroupId());
            this.cNd.sendMessage(this.gkR);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gkR != null) {
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
