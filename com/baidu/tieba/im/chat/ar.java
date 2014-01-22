package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ar implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupSettingActivity a;

    public ar(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null && qVar.w() == 103103) {
            if (!(qVar instanceof com.baidu.tieba.im.message.ch)) {
                this.a.showToast(R.string.group_report_fail);
                return;
            }
            com.baidu.tieba.im.message.ch chVar = (com.baidu.tieba.im.message.ch) qVar;
            if (chVar.k()) {
                this.a.a(chVar.m(), chVar.l());
            } else {
                this.a.showToast(R.string.group_report_success);
            }
        }
    }
}
