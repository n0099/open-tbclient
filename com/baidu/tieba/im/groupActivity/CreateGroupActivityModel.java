package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bcJ;
    private GroupActivityData ead;
    RequestCreateGroupActivityMessage eae;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ead = new GroupActivityData();
        this.bcJ = baseActivity;
    }

    public GroupActivityData aEo() {
        return this.ead;
    }

    public void hk(boolean z) {
        if (this.ead != null) {
            this.eae = new RequestCreateGroupActivityMessage();
            this.eae.setCommitType(z ? 1 : 0);
            if (z) {
                this.eae.setActivityId(this.ead.getActivityId());
            }
            this.eae.setgActivityArea(this.ead.getgActivityArea());
            this.eae.setgActivityContent(this.ead.getgActivityContent());
            this.eae.setgActivityTime(this.ead.getgActivityTime());
            this.eae.setgActivityTitle(this.ead.getgActivityTitle());
            this.eae.setGroupId(this.ead.getGroupId());
            this.bcJ.sendMessage(this.eae);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eae != null) {
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
