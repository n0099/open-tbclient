package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes10.dex */
public class CreateGroupActivityModel extends BdBaseModel<BaseActivity> {
    private GroupActivityData inx;
    RequestCreateGroupActivityMessage iny;
    private BaseActivity mActivity;

    public CreateGroupActivityModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.inx = new GroupActivityData();
        this.mActivity = baseActivity;
    }

    public GroupActivityData cgu() {
        return this.inx;
    }

    public void oP(boolean z) {
        if (this.inx != null) {
            this.iny = new RequestCreateGroupActivityMessage();
            this.iny.setCommitType(z ? 1 : 0);
            if (z) {
                this.iny.setActivityId(this.inx.getActivityId());
            }
            this.iny.setgActivityArea(this.inx.getgActivityArea());
            this.iny.setgActivityContent(this.inx.getgActivityContent());
            this.iny.setgActivityTime(this.inx.getgActivityTime());
            this.iny.setgActivityTitle(this.inx.getgActivityTitle());
            this.iny.setGroupId(this.inx.getGroupId());
            this.mActivity.sendMessage(this.iny);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        if (this.iny != null) {
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
