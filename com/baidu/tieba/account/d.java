package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class d implements c.b {
    final /* synthetic */ c aLO;
    private final /* synthetic */ View aLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view) {
        this.aLO = cVar;
        this.aLP = view;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.aLP != null) {
            AccountData accountData = (AccountData) this.aLP.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.aLO.aLN;
                        accountActivity2.a(false, accountData);
                        break;
                    }
                    break;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.aLO.aLN;
                        accountActivity.a(true, accountData);
                        break;
                    }
                    break;
            }
            cVar.dismiss();
        }
    }
}
