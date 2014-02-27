package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
final class k extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity a;
    private final /* synthetic */ BdSwitchView.SwitchState b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalTalkSettingActivity personalTalkSettingActivity, BdSwitchView.SwitchState switchState) {
        this.a = personalTalkSettingActivity;
        this.b = switchState;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Void a(Void... voidArr) {
        long j;
        long j2;
        long j3;
        if (this.b == BdSwitchView.SwitchState.OFF) {
            String v = TiebaApplication.v();
            j3 = this.a.c;
            a.a(v, String.valueOf(j3), false);
        } else {
            String v2 = TiebaApplication.v();
            j = this.a.c;
            a.a(v2, String.valueOf(j), true);
        }
        com.baidu.tieba.im.c.a d = com.baidu.tieba.im.c.a.d();
        j2 = this.a.c;
        d.a(String.valueOf(j2));
        return null;
    }
}
