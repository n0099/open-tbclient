package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class d implements c.b {
    final /* synthetic */ c aIR;
    private final /* synthetic */ View aIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view) {
        this.aIR = cVar;
        this.aIS = view;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.aIS != null) {
            AccountData accountData = (AccountData) this.aIS.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.aIR.aIQ;
                        accountActivity2.a(false, accountData);
                        break;
                    }
                    break;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.aIR.aIQ;
                        accountActivity.a(true, accountData);
                        break;
                    }
                    break;
            }
            cVar.dismiss();
        }
    }
}
