package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes7.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData hwl;
    RequestCreateGroupActivityMessage hwm;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hwl = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData bSP() {
        return this.hwl;
    }

    public void nr(boolean z) {
        if (this.hwl != null) {
            this.hwm = new RequestCreateGroupActivityMessage();
            this.hwm.setCommitType(z ? 1 : 0);
            if (z) {
                this.hwm.setActivityId(this.hwl.getActivityId());
            }
            this.hwm.setgActivityArea(this.hwl.getgActivityArea());
            this.hwm.setgActivityContent(this.hwl.getgActivityContent());
            this.hwm.setgActivityTime(this.hwl.getgActivityTime());
            this.hwm.setgActivityTitle(this.hwl.getgActivityTitle());
            this.hwm.setGroupId(this.hwl.getGroupId());
            this.mActivity.sendMessage(this.hwm);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.hwm != null) {
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
