package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class m extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ BdSwitchView.SwitchState aRw;
    final /* synthetic */ PersonalTalkSettingActivity aSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PersonalTalkSettingActivity personalTalkSettingActivity, BdSwitchView.SwitchState switchState) {
        this.aSq = personalTalkSettingActivity;
        this.aRw = switchState;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (this.aRw == BdSwitchView.SwitchState.OFF) {
            c KF = c.KF();
            String currentAccount = TbadkApplication.getCurrentAccount();
            j2 = this.aSq.userId;
            KF.e(currentAccount, String.valueOf(j2), false);
            return null;
        }
        c KF2 = c.KF();
        String currentAccount2 = TbadkApplication.getCurrentAccount();
        j = this.aSq.userId;
        KF2.e(currentAccount2, String.valueOf(j), true);
        return null;
    }
}
