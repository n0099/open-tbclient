package com.baidu.tieba.account;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    final /* synthetic */ b alP;
    private final /* synthetic */ View alQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.alP = bVar;
        this.alQ = view;
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
        if (this.alQ != null) {
            AccountData accountData = (AccountData) this.alQ.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity5 = this.alP.alO;
                        accountActivity6 = this.alP.alO;
                        accountActivity5.alN = new f(accountActivity6, false, accountData);
                        accountActivity7 = this.alP.alO;
                        fVar3 = accountActivity7.alN;
                        fVar3.setPriority(3);
                        accountActivity8 = this.alP.alO;
                        fVar4 = accountActivity8.alN;
                        fVar4.execute(new Object[0]);
                    }
                    dialogInterface.cancel();
                    return;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.alP.alO;
                        accountActivity2 = this.alP.alO;
                        accountActivity.alN = new f(accountActivity2, true, accountData);
                        accountActivity3 = this.alP.alO;
                        fVar = accountActivity3.alN;
                        fVar.setPriority(3);
                        accountActivity4 = this.alP.alO;
                        fVar2 = accountActivity4.alN;
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
