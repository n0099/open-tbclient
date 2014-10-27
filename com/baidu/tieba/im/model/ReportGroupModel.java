package com.baidu.tieba.im.model;

import android.content.Context;
import com.baidu.adp.base.e;
import com.baidu.tieba.im.message.RequestReportGroupMessage;
/* loaded from: classes.dex */
public class ReportGroupModel extends e {
    private int mGroupId;
    private int mReportType;
    private RequestReportGroupMessage sentMsg;

    public ReportGroupModel(Context context) {
        super(context);
    }

    public void setGroupId(int i) {
        this.mGroupId = i;
    }

    public void setReportType(int i) {
        this.mReportType = i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
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

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        super.cancelMessage();
        this.sentMsg = null;
    }
}
