package com.baidu.tieba.account;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    final /* synthetic */ b aex;
    private final /* synthetic */ View aey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.aex = bVar;
        this.aey = view;
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
        if (this.aey != null) {
            AccountData accountData = (AccountData) this.aey.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity5 = this.aex.aew;
                        accountActivity6 = this.aex.aew;
                        accountActivity5.aev = new f(accountActivity6, false, accountData);
                        accountActivity7 = this.aex.aew;
                        fVar3 = accountActivity7.aev;
                        fVar3.setPriority(3);
                        accountActivity8 = this.aex.aew;
                        fVar4 = accountActivity8.aev;
                        fVar4.execute(new Object[0]);
                    }
                    dialogInterface.cancel();
                    return;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.aex.aew;
                        accountActivity2 = this.aex.aew;
                        accountActivity.aev = new f(accountActivity2, true, accountData);
                        accountActivity3 = this.aex.aew;
                        fVar = accountActivity3.aev;
                        fVar.setPriority(3);
                        accountActivity4 = this.aex.aew;
                        fVar2 = accountActivity4.aev;
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
