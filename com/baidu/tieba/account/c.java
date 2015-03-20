package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ b auv;
    private final /* synthetic */ View auw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.auv = bVar;
        this.auw = view;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.auw != null) {
            AccountData accountData = (AccountData) this.auw.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.auv.auu;
                        accountActivity2.a(false, accountData);
                        break;
                    }
                    break;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.auv.auu;
                        accountActivity.a(true, accountData);
                        break;
                    }
                    break;
            }
            eVar.dismiss();
        }
    }
}
