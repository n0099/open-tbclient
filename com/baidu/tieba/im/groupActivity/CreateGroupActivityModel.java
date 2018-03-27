package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bSF;
    private GroupActivityData eFy;
    RequestCreateGroupActivityMessage eFz;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eFy = new GroupActivityData();
        this.bSF = baseActivity;
    }

    public GroupActivityData aJr() {
        return this.eFy;
    }

    public void hK(boolean z) {
        if (this.eFy != null) {
            this.eFz = new RequestCreateGroupActivityMessage();
            this.eFz.setCommitType(z ? 1 : 0);
            if (z) {
                this.eFz.setActivityId(this.eFy.getActivityId());
            }
            this.eFz.setgActivityArea(this.eFy.getgActivityArea());
            this.eFz.setgActivityContent(this.eFy.getgActivityContent());
            this.eFz.setgActivityTime(this.eFy.getgActivityTime());
            this.eFz.setgActivityTitle(this.eFy.getgActivityTitle());
            this.eFz.setGroupId(this.eFy.getGroupId());
            this.bSF.sendMessage(this.eFz);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eFz != null) {
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
