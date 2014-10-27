package com.baidu.tieba.account;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    final /* synthetic */ b aep;
    private final /* synthetic */ View aeq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.aep = bVar;
        this.aeq = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        AccountActivity accountActivity3;
        f fVar;
        AccountActivity accountActivity4;
        f fVar2;
        AccountActivity accountActivity5;
        AccountActivity accountActivity6;
        AccountActivity accountActivity7;
        f fVar3;
        AccountActivity accountActivity8;
        f fVar4;
        if (this.aeq != null) {
            AccountData accountData = (AccountData) this.aeq.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity5 = this.aep.aeo;
                        accountActivity6 = this.aep.aeo;
                        accountActivity5.aen = new f(accountActivity6, false, accountData);
                        accountActivity7 = this.aep.aeo;
                        fVar3 = accountActivity7.aen;
                        fVar3.setPriority(3);
                        accountActivity8 = this.aep.aeo;
                        fVar4 = accountActivity8.aen;
                        fVar4.execute(new Object[0]);
                    }
                    dialogInterface.cancel();
                    return;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.aep.aeo;
                        accountActivity2 = this.aep.aeo;
                        accountActivity.aen = new f(accountActivity2, true, accountData);
                        accountActivity3 = this.aep.aeo;
                        fVar = accountActivity3.aen;
                        fVar.setPriority(3);
                        accountActivity4 = this.aep.aeo;
                        fVar2 = accountActivity4.aen;
                        fVar2.execute(new Object[0]);
                    }
                    dialogInterface.cancel();
                    return;
                case 2:
                    dialogInterface.cancel();
                    return;
                default:
                    dialogInterface.cancel();
                    return;
            }
        }
    }
}
