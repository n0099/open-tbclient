package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1551a;

    public r(GroupSettingActivity groupSettingActivity) {
        this.f1551a = groupSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (message != null && message.getCmd() == 103103) {
            if (!(message instanceof ResponseReportGroupMessage)) {
                this.f1551a.showToast(R.string.group_report_fail);
                return;
            }
            ResponseReportGroupMessage responseReportGroupMessage = (ResponseReportGroupMessage) message;
            if (responseReportGroupMessage.hasError()) {
                this.f1551a.a(responseReportGroupMessage.getErrMsg(), responseReportGroupMessage.getErrNo());
            } else {
                this.f1551a.showToast(R.string.group_report_success);
            }
        }
    }
}
