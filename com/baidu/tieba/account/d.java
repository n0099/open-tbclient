package com.baidu.tieba.account;

import android.view.View;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ c awg;
    private final /* synthetic */ View awh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view) {
        this.awg = cVar;
        this.awh = view;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        if (this.awh != null) {
            AccountData accountData = (AccountData) this.awh.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity2 = this.awg.awf;
                        accountActivity2.a(false, accountData);
                        break;
                    }
                    break;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.awg.awf;
                        accountActivity.a(true, accountData);
                        break;
                    }
                    break;
            }
            eVar.dismiss();
        }
    }
}
