package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
/* loaded from: classes.dex */
class bg extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ GroupSettingActivity aOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(GroupSettingActivity groupSettingActivity, int i) {
        super(i);
        this.aOC = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103103) {
            if (!(socketResponsedMessage instanceof ResponseReportGroupMessage)) {
                this.aOC.showToast(com.baidu.tieba.y.group_report_fail);
                return;
            }
            ResponseReportGroupMessage responseReportGroupMessage = (ResponseReportGroupMessage) socketResponsedMessage;
            if (responseReportGroupMessage.getError() != 0) {
                this.aOC.t(responseReportGroupMessage.getErrorString(), responseReportGroupMessage.getError());
            } else {
                this.aOC.showToast(com.baidu.tieba.y.group_report_success);
            }
        }
    }
}
