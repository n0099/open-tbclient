package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bSO;
    private GroupActivityData eFu;
    RequestCreateGroupActivityMessage eFv;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eFu = new GroupActivityData();
        this.bSO = baseActivity;
    }

    public GroupActivityData aJr() {
        return this.eFu;
    }

    public void hF(boolean z) {
        if (this.eFu != null) {
            this.eFv = new RequestCreateGroupActivityMessage();
            this.eFv.setCommitType(z ? 1 : 0);
            if (z) {
                this.eFv.setActivityId(this.eFu.getActivityId());
            }
            this.eFv.setgActivityArea(this.eFu.getgActivityArea());
            this.eFv.setgActivityContent(this.eFu.getgActivityContent());
            this.eFv.setgActivityTime(this.eFu.getgActivityTime());
            this.eFv.setgActivityTitle(this.eFu.getgActivityTitle());
            this.eFv.setGroupId(this.eFu.getGroupId());
            this.bSO.sendMessage(this.eFv);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eFv != null) {
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
