package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bBW;
    private GroupActivityData eUV;
    RequestCreateGroupActivityMessage eUW;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eUV = new GroupActivityData();
        this.bBW = baseActivity;
    }

    public GroupActivityData aSS() {
        return this.eUV;
    }

    public void iJ(boolean z) {
        if (this.eUV != null) {
            this.eUW = new RequestCreateGroupActivityMessage();
            this.eUW.setCommitType(z ? 1 : 0);
            if (z) {
                this.eUW.setActivityId(this.eUV.getActivityId());
            }
            this.eUW.setgActivityArea(this.eUV.getgActivityArea());
            this.eUW.setgActivityContent(this.eUV.getgActivityContent());
            this.eUW.setgActivityTime(this.eUV.getgActivityTime());
            this.eUW.setgActivityTitle(this.eUV.getgActivityTitle());
            this.eUW.setGroupId(this.eUV.getGroupId());
            this.bBW.sendMessage(this.eUW);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eUW != null) {
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
