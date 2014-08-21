package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class aj extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ OfficialBarInfoActivity a;
    private final /* synthetic */ BdSwitchView.SwitchState b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(OfficialBarInfoActivity officialBarInfoActivity, BdSwitchView.SwitchState switchState) {
        this.a = officialBarInfoActivity;
        this.b = switchState;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        int i;
        int i2;
        if (this.b == BdSwitchView.SwitchState.OFF) {
            az a = az.a();
            String currentAccount = TbadkApplication.getCurrentAccount();
            i2 = this.a.c;
            a.a(currentAccount, String.valueOf(i2), false);
            return null;
        }
        az a2 = az.a();
        String currentAccount2 = TbadkApplication.getCurrentAccount();
        i = this.a.c;
        a2.a(currentAccount2, String.valueOf(i), true);
        return null;
    }
}
