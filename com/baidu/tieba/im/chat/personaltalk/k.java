package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class k extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity a;
    private final /* synthetic */ BdSwitchView.SwitchState b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalTalkSettingActivity personalTalkSettingActivity, BdSwitchView.SwitchState switchState) {
        this.a = personalTalkSettingActivity;
        this.b = switchState;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (this.b == BdSwitchView.SwitchState.OFF) {
            a a = a.a();
            String currentAccount = TbadkApplication.getCurrentAccount();
            j2 = this.a.c;
            a.a(currentAccount, String.valueOf(j2), false);
            return null;
        }
        a a2 = a.a();
        String currentAccount2 = TbadkApplication.getCurrentAccount();
        j = this.a.c;
        a2.a(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
