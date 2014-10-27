package com.baidu.tieba.im.groupActivity;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private GroupActivityData aYB;
    RequestCreateGroupActivityMessage aYC;
    private BaseFragmentActivity mActivity;

    public d(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity);
        this.aYB = new GroupActivityData();
        this.mActivity = baseFragmentActivity;
    }

    public GroupActivityData NY() {
        return this.aYB;
    }

    public void bK(boolean z) {
        if (this.aYB != null) {
            this.aYC = new RequestCreateGroupActivityMessage();
            this.aYC.setCommitType(z ? 1 : 0);
            if (z) {
                this.aYC.setActivityId(this.aYB.getActivityId());
            }
            this.aYC.setgActivityArea(this.aYB.getgActivityArea());
            this.aYC.setgActivityContent(this.aYB.getgActivityContent());
            this.aYC.setgActivityTime(this.aYB.getgActivityTime());
            this.aYC.setgActivityTitle(this.aYB.getgActivityTitle());
            this.aYC.setGroupId(this.aYB.getGroupId());
            this.mActivity.sendMessage(this.aYC);
        }
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
