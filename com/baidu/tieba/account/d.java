package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class d implements c.b {
    final /* synthetic */ c aHZ;
    private final /* synthetic */ View val$v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view) {
        this.aHZ = cVar;
        this.val$v = view;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.val$v != null) {
            AccountData accountData = (AccountData) this.val$v.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.aHZ.aHY;
                        accountActivity2.a(false, accountData);
                        break;
                    }
                    break;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.aHZ.aHY;
                        accountActivity.a(true, accountData);
                        break;
                    }
                    break;
            }
            cVar.dismiss();
        }
    }
}
