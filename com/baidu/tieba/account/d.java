package com.baidu.tieba.account;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {
    final /* synthetic */ c amJ;
    private final /* synthetic */ View amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view) {
        this.amJ = cVar;
        this.amK = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.amK != null) {
            AccountData accountData = (AccountData) this.amK.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.amJ.amI;
                        accountActivity2.a(false, accountData);
                    }
                    dialogInterface.cancel();
                    return;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.amJ.amI;
                        accountActivity.a(true, accountData);
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
