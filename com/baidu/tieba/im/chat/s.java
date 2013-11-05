package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1469a;

    public s(GroupSettingActivity groupSettingActivity) {
        this.f1469a = groupSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (message != null && message.getCmd() == 103103) {
            if (!(message instanceof ResponseReportGroupMessage)) {
                this.f1469a.b(R.string.group_report_fail);
                return;
            }
            ResponseReportGroupMessage responseReportGroupMessage = (ResponseReportGroupMessage) message;
            if (responseReportGroupMessage.hasError()) {
                this.f1469a.c(responseReportGroupMessage.getErrMsg());
            } else {
                this.f1469a.b(R.string.group_report_success);
            }
        }
    }
}
