package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bSC;
    private GroupActivityData eFi;
    RequestCreateGroupActivityMessage eFj;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eFi = new GroupActivityData();
        this.bSC = baseActivity;
    }

    public GroupActivityData aJq() {
        return this.eFi;
    }

    public void hF(boolean z) {
        if (this.eFi != null) {
            this.eFj = new RequestCreateGroupActivityMessage();
            this.eFj.setCommitType(z ? 1 : 0);
            if (z) {
                this.eFj.setActivityId(this.eFi.getActivityId());
            }
            this.eFj.setgActivityArea(this.eFi.getgActivityArea());
            this.eFj.setgActivityContent(this.eFi.getgActivityContent());
            this.eFj.setgActivityTime(this.eFi.getgActivityTime());
            this.eFj.setgActivityTitle(this.eFi.getgActivityTitle());
            this.eFj.setGroupId(this.eFi.getGroupId());
            this.bSC.sendMessage(this.eFj);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eFj != null) {
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
