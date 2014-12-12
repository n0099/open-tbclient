package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class n extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ PersonalTalkSettingActivity aTQ;
    private final /* synthetic */ BdSwitchView.SwitchState aTS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PersonalTalkSettingActivity personalTalkSettingActivity, BdSwitchView.SwitchState switchState) {
        this.aTQ = personalTalkSettingActivity;
        this.aTS = switchState;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (this.aTS == BdSwitchView.SwitchState.OFF) {
            com.baidu.tieba.im.settingcache.j SY = com.baidu.tieba.im.settingcache.j.SY();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.aTQ.userId;
            SY.f(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j SY2 = com.baidu.tieba.im.settingcache.j.SY();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.aTQ.userId;
        SY2.f(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
