package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes22.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData khR;
    RequestCreateGroupActivityMessage khS;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.khR = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cSj() {
        return this.khR;
    }

    public void sc(boolean z) {
        if (this.khR != null) {
            this.khS = new RequestCreateGroupActivityMessage();
            this.khS.setCommitType(z ? 1 : 0);
            if (z) {
                this.khS.setActivityId(this.khR.getActivityId());
            }
            this.khS.setgActivityArea(this.khR.getgActivityArea());
            this.khS.setgActivityContent(this.khR.getgActivityContent());
            this.khS.setgActivityTime(this.khR.getgActivityTime());
            this.khS.setgActivityTitle(this.khR.getgActivityTitle());
            this.khS.setGroupId(this.khR.getGroupId());
            this.mActivity.sendMessage(this.khS);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.khS != null) {
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
