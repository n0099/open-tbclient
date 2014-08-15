package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
/* loaded from: classes.dex */
class bg extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(GroupSettingActivity groupSettingActivity, int i) {
        super(i);
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103103) {
            if (!(socketResponsedMessage instanceof ResponseReportGroupMessage)) {
                this.a.showToast(com.baidu.tieba.x.group_report_fail);
                return;
            }
            ResponseReportGroupMessage responseReportGroupMessage = (ResponseReportGroupMessage) socketResponsedMessage;
            if (responseReportGroupMessage.getError() != 0) {
                this.a.a(responseReportGroupMessage.getErrorString(), responseReportGroupMessage.getError());
            } else {
                this.a.showToast(com.baidu.tieba.x.group_report_success);
            }
        }
    }
}
