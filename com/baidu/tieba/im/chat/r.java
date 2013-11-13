package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1560a;

    public r(GroupSettingActivity groupSettingActivity) {
        this.f1560a = groupSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (message != null && message.getCmd() == 103103) {
            if (!(message instanceof ResponseReportGroupMessage)) {
                this.f1560a.showToast(R.string.group_report_fail);
                return;
            }
            ResponseReportGroupMessage responseReportGroupMessage = (ResponseReportGroupMessage) message;
            if (responseReportGroupMessage.hasError()) {
                this.f1560a.a(responseReportGroupMessage.getErrMsg(), responseReportGroupMessage.getErrNo());
            } else {
                this.f1560a.showToast(R.string.group_report_success);
            }
        }
    }
}
