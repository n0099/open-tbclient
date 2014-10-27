package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class aj extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ OfficialBarInfoActivity aRv;
    private final /* synthetic */ BdSwitchView.SwitchState aRw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(OfficialBarInfoActivity officialBarInfoActivity, BdSwitchView.SwitchState switchState) {
        this.aRv = officialBarInfoActivity;
        this.aRw = switchState;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        int i;
        int i2;
        if (this.aRw == BdSwitchView.SwitchState.OFF) {
            ax KA = ax.KA();
            String currentAccount = TbadkApplication.getCurrentAccount();
            i2 = this.aRv.mForumId;
            KA.e(currentAccount, String.valueOf(i2), false);
            return null;
        }
        ax KA2 = ax.KA();
        String currentAccount2 = TbadkApplication.getCurrentAccount();
        i = this.aRv.mForumId;
        KA2.e(currentAccount2, String.valueOf(i), true);
        return null;
    }
}
