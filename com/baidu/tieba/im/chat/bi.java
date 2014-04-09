package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
/* loaded from: classes.dex */
final class bi extends com.baidu.adp.framework.c.g {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(GroupSettingActivity groupSettingActivity, int i) {
        super(0);
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null || socketResponsedMessage2.g() != 103103) {
            return;
        }
        if (!(socketResponsedMessage2 instanceof ResponseReportGroupMessage)) {
            this.a.showToast(com.baidu.tieba.im.j.group_report_fail);
            return;
        }
        ResponseReportGroupMessage responseReportGroupMessage = (ResponseReportGroupMessage) socketResponsedMessage2;
        if (responseReportGroupMessage.e() != 0) {
            GroupSettingActivity.a(this.a, responseReportGroupMessage.f(), responseReportGroupMessage.e());
        } else {
            this.a.showToast(com.baidu.tieba.im.j.group_report_success);
        }
    }
}
