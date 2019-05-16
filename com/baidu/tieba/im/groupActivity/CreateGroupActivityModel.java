package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity cVo;
    private GroupActivityData gCd;
    RequestCreateGroupActivityMessage gCe;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gCd = new GroupActivityData();
        this.cVo = baseActivity;
    }

    public GroupActivityData bBg() {
        return this.gCd;
    }

    public void lY(boolean z) {
        if (this.gCd != null) {
            this.gCe = new RequestCreateGroupActivityMessage();
            this.gCe.setCommitType(z ? 1 : 0);
            if (z) {
                this.gCe.setActivityId(this.gCd.getActivityId());
            }
            this.gCe.setgActivityArea(this.gCd.getgActivityArea());
            this.gCe.setgActivityContent(this.gCd.getgActivityContent());
            this.gCe.setgActivityTime(this.gCd.getgActivityTime());
            this.gCe.setgActivityTitle(this.gCd.getgActivityTitle());
            this.gCe.setGroupId(this.gCd.getGroupId());
            this.cVo.sendMessage(this.gCe);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gCe != null) {
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
