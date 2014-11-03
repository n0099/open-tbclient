package com.baidu.tieba.im.groupActivity;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private GroupActivityData aYO;
    RequestCreateGroupActivityMessage aYP;
    private BaseFragmentActivity mActivity;

    public d(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity);
        this.aYO = new GroupActivityData();
        this.mActivity = baseFragmentActivity;
    }

    public GroupActivityData Ob() {
        return this.aYO;
    }

    public void bK(boolean z) {
        if (this.aYO != null) {
            this.aYP = new RequestCreateGroupActivityMessage();
            this.aYP.setCommitType(z ? 1 : 0);
            if (z) {
                this.aYP.setActivityId(this.aYO.getActivityId());
            }
            this.aYP.setgActivityArea(this.aYO.getgActivityArea());
            this.aYP.setgActivityContent(this.aYO.getgActivityContent());
            this.aYP.setgActivityTime(this.aYO.getgActivityTime());
            this.aYP.setgActivityTitle(this.aYO.getgActivityTitle());
            this.aYP.setGroupId(this.aYO.getGroupId());
            this.mActivity.sendMessage(this.aYP);
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
