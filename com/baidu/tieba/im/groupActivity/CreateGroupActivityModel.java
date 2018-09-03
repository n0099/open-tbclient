package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes3.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private BaseActivity bnc;
    private GroupActivityData euf;
    RequestCreateGroupActivityMessage eug;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.euf = new GroupActivityData();
        this.bnc = baseActivity;
    }

    public GroupActivityData aKM() {
        return this.euf;
    }

    public void hE(boolean z) {
        if (this.euf != null) {
            this.eug = new RequestCreateGroupActivityMessage();
            this.eug.setCommitType(z ? 1 : 0);
            if (z) {
                this.eug.setActivityId(this.euf.getActivityId());
            }
            this.eug.setgActivityArea(this.euf.getgActivityArea());
            this.eug.setgActivityContent(this.euf.getgActivityContent());
            this.eug.setgActivityTime(this.euf.getgActivityTime());
            this.eug.setgActivityTitle(this.euf.getgActivityTitle());
            this.eug.setGroupId(this.euf.getGroupId());
            this.bnc.sendMessage(this.eug);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.eug != null) {
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
