package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ b auD;
    private final /* synthetic */ View auE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.auD = bVar;
        this.auE = view;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.auE != null) {
            AccountData accountData = (AccountData) this.auE.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.auD.auC;
                        accountActivity2.a(false, accountData);
                        break;
                    }
                    break;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.auD.auC;
                        accountActivity.a(true, accountData);
                        break;
                    }
                    break;
            }
            eVar.dismiss();
        }
    }
}
