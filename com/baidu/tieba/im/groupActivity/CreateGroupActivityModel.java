package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes23.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData kbk;
    RequestCreateGroupActivityMessage kbl;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kbk = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cQc() {
        return this.kbk;
    }

    public void rQ(boolean z) {
        if (this.kbk != null) {
            this.kbl = new RequestCreateGroupActivityMessage();
            this.kbl.setCommitType(z ? 1 : 0);
            if (z) {
                this.kbl.setActivityId(this.kbk.getActivityId());
            }
            this.kbl.setgActivityArea(this.kbk.getgActivityArea());
            this.kbl.setgActivityContent(this.kbk.getgActivityContent());
            this.kbl.setgActivityTime(this.kbk.getgActivityTime());
            this.kbl.setgActivityTitle(this.kbk.getgActivityTitle());
            this.kbl.setGroupId(this.kbk.getGroupId());
            this.mActivity.sendMessage(this.kbl);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.kbl != null) {
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
