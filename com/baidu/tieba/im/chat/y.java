package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class y implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupSettingActivity a;

    public y(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null && oVar.u() == 103103) {
            if (!(oVar instanceof com.baidu.tieba.im.message.bv)) {
                this.a.showToast(R.string.group_report_fail);
                return;
            }
            com.baidu.tieba.im.message.bv bvVar = (com.baidu.tieba.im.message.bv) oVar;
            if (bvVar.i()) {
                this.a.a(bvVar.k(), bvVar.j());
            } else {
                this.a.showToast(R.string.group_report_success);
            }
        }
    }
}
