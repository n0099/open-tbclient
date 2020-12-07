package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes23.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData kvo;
    RequestCreateGroupActivityMessage kvp;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kvo = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cXv() {
        return this.kvo;
    }

    public void sE(boolean z) {
        if (this.kvo != null) {
            this.kvp = new RequestCreateGroupActivityMessage();
            this.kvp.setCommitType(z ? 1 : 0);
            if (z) {
                this.kvp.setActivityId(this.kvo.getActivityId());
            }
            this.kvp.setgActivityArea(this.kvo.getgActivityArea());
            this.kvp.setgActivityContent(this.kvo.getgActivityContent());
            this.kvp.setgActivityTime(this.kvo.getgActivityTime());
            this.kvp.setgActivityTitle(this.kvo.getgActivityTitle());
            this.kvp.setGroupId(this.kvo.getGroupId());
            this.mActivity.sendMessage(this.kvp);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.kvp != null) {
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
