package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class z implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupSettingActivity a;

    public z(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar != null && nVar.t() == 103103) {
            if (!(nVar instanceof com.baidu.tieba.im.message.bs)) {
                this.a.showToast(R.string.group_report_fail);
                return;
            }
            com.baidu.tieba.im.message.bs bsVar = (com.baidu.tieba.im.message.bs) nVar;
            if (bsVar.i()) {
                this.a.a(bsVar.k(), bsVar.j());
            } else {
                this.a.showToast(R.string.group_report_success);
            }
        }
    }
}
