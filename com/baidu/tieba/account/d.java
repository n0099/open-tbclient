package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class d implements c.b {
    final /* synthetic */ c aVk;
    private final /* synthetic */ View val$v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view) {
        this.aVk = cVar;
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
                        accountActivity2 = this.aVk.aVj;
                        accountActivity2.a(false, accountData);
                        break;
                    }
                    break;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.aVk.aVj;
                        accountActivity.a(true, accountData);
                        break;
                    }
                    break;
            }
            cVar.dismiss();
        }
    }
}
