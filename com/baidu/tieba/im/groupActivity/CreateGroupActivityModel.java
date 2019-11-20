package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes5.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData gIh;
    RequestCreateGroupActivityMessage gIi;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gIh = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData bBC() {
        return this.gIh;
    }

    public void me(boolean z) {
        if (this.gIh != null) {
            this.gIi = new RequestCreateGroupActivityMessage();
            this.gIi.setCommitType(z ? 1 : 0);
            if (z) {
                this.gIi.setActivityId(this.gIh.getActivityId());
            }
            this.gIi.setgActivityArea(this.gIh.getgActivityArea());
            this.gIi.setgActivityContent(this.gIh.getgActivityContent());
            this.gIi.setgActivityTime(this.gIh.getgActivityTime());
            this.gIi.setgActivityTitle(this.gIh.getgActivityTitle());
            this.gIi.setGroupId(this.gIh.getGroupId());
            this.mActivity.sendMessage(this.gIi);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.gIi != null) {
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
