package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bkU;
    private GroupActivityData emu;
    RequestCreateGroupActivityMessage emv;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.emu = new GroupActivityData();
        this.bkU = baseActivity;
    }

    public GroupActivityData aJh() {
        return this.emu;
    }

    public void hr(boolean z) {
        if (this.emu != null) {
            this.emv = new RequestCreateGroupActivityMessage();
            this.emv.setCommitType(z ? 1 : 0);
            if (z) {
                this.emv.setActivityId(this.emu.getActivityId());
            }
            this.emv.setgActivityArea(this.emu.getgActivityArea());
            this.emv.setgActivityContent(this.emu.getgActivityContent());
            this.emv.setgActivityTime(this.emu.getgActivityTime());
            this.emv.setgActivityTitle(this.emu.getgActivityTitle());
            this.emv.setGroupId(this.emu.getGroupId());
            this.bkU.sendMessage(this.emv);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.emv != null) {
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
