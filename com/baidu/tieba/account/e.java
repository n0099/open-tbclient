package com.baidu.tieba.account;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        l lVar3;
        i iVar;
        i iVar2;
        lVar = this.a.b;
        if (lVar.getItemId(i) >= 0) {
            lVar2 = this.a.b;
            if (!lVar2.a()) {
                lVar3 = this.a.b;
                AccountData accountData = (AccountData) lVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    this.a.h = new i(this.a, accountData);
                    iVar = this.a.h;
                    iVar.setPriority(3);
                    iVar2 = this.a.h;
                    iVar2.execute(new Object[0]);
                    return;
                }
                return;
            }
            return;
        }
        LoginActivity.a(this.a);
    }
}
