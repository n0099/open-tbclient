package com.baidu.tieba.account;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {
    final /* synthetic */ c amG;
    private final /* synthetic */ View amH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view) {
        this.amG = cVar;
        this.amH = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.amH != null) {
            AccountData accountData = (AccountData) this.amH.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.amG.amF;
                        accountActivity2.a(false, accountData);
                    }
                    dialogInterface.cancel();
                    return;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.amG.amF;
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
