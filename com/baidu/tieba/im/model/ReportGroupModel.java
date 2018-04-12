package com.baidu.tieba.im.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.im.chat.GroupSettingActivity;
import com.baidu.tieba.im.message.RequestReportGroupMessage;
/* loaded from: classes3.dex */
public class ReportGroupModel extends BdBaseModel<GroupSettingActivity> {
    private long mGroupId;
    private int mReportType;
    private RequestReportGroupMessage sentMsg;

    public ReportGroupModel(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
    }

    public void setGroupId(long j) {
        this.mGroupId = j;
    }

    public void setReportType(int i) {
        this.mReportType = i;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private RequestReportGroupMessage createMessage() {
        RequestReportGroupMessage requestReportGroupMessage = new RequestReportGroupMessage();
        requestReportGroupMessage.setGroupId(this.mGroupId);
        requestReportGroupMessage.setReportType(this.mReportType);
        return requestReportGroupMessage;
    }

    public void sendMessage() {
        this.sentMsg = createMessage();
        super.sendMessage(this.sentMsg);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.sentMsg = null;
    }
}
