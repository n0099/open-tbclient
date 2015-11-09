package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class c implements c.b {
    final /* synthetic */ b aDr;
    private final /* synthetic */ View aDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.aDr = bVar;
        this.aDs = view;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.aDs != null) {
            AccountData accountData = (AccountData) this.aDs.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.aDr.aDq;
                        accountActivity2.a(false, accountData);
                        break;
                    }
                    break;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.aDr.aDq;
                        accountActivity.a(true, accountData);
                        break;
                    }
                    break;
            }
            cVar.dismiss();
        }
    }
}
