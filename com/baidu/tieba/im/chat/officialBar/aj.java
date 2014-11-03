package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class aj extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ OfficialBarInfoActivity aRJ;
    private final /* synthetic */ BdSwitchView.SwitchState aRK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(OfficialBarInfoActivity officialBarInfoActivity, BdSwitchView.SwitchState switchState) {
        this.aRJ = officialBarInfoActivity;
        this.aRK = switchState;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        int i;
        int i2;
        if (this.aRK == BdSwitchView.SwitchState.OFF) {
            ax KE = ax.KE();
            String currentAccount = TbadkApplication.getCurrentAccount();
            i2 = this.aRJ.mForumId;
            KE.e(currentAccount, String.valueOf(i2), false);
            return null;
        }
        ax KE2 = ax.KE();
        String currentAccount2 = TbadkApplication.getCurrentAccount();
        i = this.aRJ.mForumId;
        KE2.e(currentAccount2, String.valueOf(i), true);
        return null;
    }
}
