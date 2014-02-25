package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class av implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupSettingActivity a;

    public av(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.w() == 103103) {
            if (!(sVar instanceof com.baidu.tieba.im.message.cq)) {
                this.a.showToast(R.string.group_report_fail);
                return;
            }
            com.baidu.tieba.im.message.cq cqVar = (com.baidu.tieba.im.message.cq) sVar;
            if (cqVar.l()) {
                this.a.a(cqVar.n(), cqVar.m());
            } else {
                this.a.showToast(R.string.group_report_success);
            }
        }
    }
}
