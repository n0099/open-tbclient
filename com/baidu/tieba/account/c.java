package com.baidu.tieba.account;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    final /* synthetic */ b a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.a = bVar;
        this.b = view;
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
        if (this.b != null) {
            AccountData accountData = (AccountData) this.b.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity5 = this.a.a;
                        accountActivity6 = this.a.a;
                        accountActivity5.i = new f(accountActivity6, false, accountData);
                        accountActivity7 = this.a.a;
                        fVar3 = accountActivity7.i;
                        fVar3.setPriority(3);
                        accountActivity8 = this.a.a;
                        fVar4 = accountActivity8.i;
                        fVar4.execute(new Object[0]);
                    }
                    dialogInterface.cancel();
                    return;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.a.a;
                        accountActivity2 = this.a.a;
                        accountActivity.i = new f(accountActivity2, true, accountData);
                        accountActivity3 = this.a.a;
                        fVar = accountActivity3.i;
                        fVar.setPriority(3);
                        accountActivity4 = this.a.a;
                        fVar2 = accountActivity4.i;
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
