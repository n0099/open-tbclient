package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class j extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ BdSwitchView.SwitchState a;
    final /* synthetic */ PersonalTalkSettingActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalTalkSettingActivity personalTalkSettingActivity, BdSwitchView.SwitchState switchState) {
        this.b = personalTalkSettingActivity;
        this.a = switchState;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        long j;
        long j2;
        long j3;
        if (this.a == BdSwitchView.SwitchState.OFF) {
            String B = TiebaApplication.B();
            j3 = this.b.c;
            a.a(B, String.valueOf(j3), false);
        } else {
            String B2 = TiebaApplication.B();
            j = this.b.c;
            a.a(B2, String.valueOf(j), true);
        }
        com.baidu.tieba.im.c.a h = com.baidu.tieba.im.c.a.h();
        j2 = this.b.c;
        h.a(String.valueOf(j2));
        return null;
    }
}
