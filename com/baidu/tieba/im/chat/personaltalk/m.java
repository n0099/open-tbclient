package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class m extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ BdSwitchView.SwitchState aRK;
    final /* synthetic */ PersonalTalkSettingActivity aSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PersonalTalkSettingActivity personalTalkSettingActivity, BdSwitchView.SwitchState switchState) {
        this.aSE = personalTalkSettingActivity;
        this.aRK = switchState;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (this.aRK == BdSwitchView.SwitchState.OFF) {
            c KJ = c.KJ();
            String currentAccount = TbadkApplication.getCurrentAccount();
            j2 = this.aSE.userId;
            KJ.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        c KJ2 = c.KJ();
        String currentAccount2 = TbadkApplication.getCurrentAccount();
        j = this.aSE.userId;
        KJ2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
