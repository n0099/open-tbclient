package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ c awh;
    private final /* synthetic */ View awi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view) {
        this.awh = cVar;
        this.awi = view;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.awi != null) {
            AccountData accountData = (AccountData) this.awi.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.awh.awg;
                        accountActivity2.a(false, accountData);
                        break;
                    }
                    break;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.awh.awg;
                        accountActivity.a(true, accountData);
                        break;
                    }
                    break;
            }
            eVar.dismiss();
        }
    }
}
