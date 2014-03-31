package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class j extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity a;
    private final /* synthetic */ BdSwitchView.SwitchState b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalTalkSettingActivity personalTalkSettingActivity, BdSwitchView.SwitchState switchState) {
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
        if (this.b == BdSwitchView.SwitchState.OFF) {
            a a = a.a();
            String E = TbadkApplication.E();
            j2 = this.a.c;
            a.d(E, String.valueOf(j2), false);
            return null;
        }
        a a2 = a.a();
        String E2 = TbadkApplication.E();
        j = this.a.c;
        a2.d(E2, String.valueOf(j), true);
        return null;
    }
}
