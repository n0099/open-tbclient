package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bBV;
    private GroupActivityData eUU;
    RequestCreateGroupActivityMessage eUV;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eUU = new GroupActivityData();
        this.bBV = baseActivity;
    }

    public GroupActivityData aSS() {
        return this.eUU;
    }

    public void iJ(boolean z) {
        if (this.eUU != null) {
            this.eUV = new RequestCreateGroupActivityMessage();
            this.eUV.setCommitType(z ? 1 : 0);
            if (z) {
                this.eUV.setActivityId(this.eUU.getActivityId());
            }
            this.eUV.setgActivityArea(this.eUU.getgActivityArea());
            this.eUV.setgActivityContent(this.eUU.getgActivityContent());
            this.eUV.setgActivityTime(this.eUU.getgActivityTime());
            this.eUV.setgActivityTitle(this.eUU.getgActivityTitle());
            this.eUV.setGroupId(this.eUU.getGroupId());
            this.bBV.sendMessage(this.eUV);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eUV != null) {
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
