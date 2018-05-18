package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bcK;
    private GroupActivityData ebh;
    RequestCreateGroupActivityMessage ebi;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ebh = new GroupActivityData();
        this.bcK = baseActivity;
    }

    public GroupActivityData aEm() {
        return this.ebh;
    }

    public void hl(boolean z) {
        if (this.ebh != null) {
            this.ebi = new RequestCreateGroupActivityMessage();
            this.ebi.setCommitType(z ? 1 : 0);
            if (z) {
                this.ebi.setActivityId(this.ebh.getActivityId());
            }
            this.ebi.setgActivityArea(this.ebh.getgActivityArea());
            this.ebi.setgActivityContent(this.ebh.getgActivityContent());
            this.ebi.setgActivityTime(this.ebh.getgActivityTime());
            this.ebi.setgActivityTitle(this.ebh.getgActivityTitle());
            this.ebi.setGroupId(this.ebh.getGroupId());
            this.bcK.sendMessage(this.ebi);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.ebi != null) {
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
