package com.baidu.tieba.account;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends BdAsyncTask<Object, Integer, AccountData> {
    final /* synthetic */ AccountActivity a;
    private AccountData b;
    private int c = 0;
    private boolean d;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ AccountData a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(AccountData accountData) {
        ArrayList arrayList;
        l lVar;
        AccountData accountData2 = accountData;
        if (this.b != null) {
            new h(this.a, this.b.getBDUSS()).start();
        }
        this.a.closeLoadingDialog();
        if (this.c != 0) {
            TbadkApplication.a((AccountData) null, this.a);
            com.baidu.tbadk.core.a.l.a().b(this.b.getAccount());
            com.baidu.tbadk.core.a.l.a().a(this.b.getBDUSS());
        }
        switch (this.c) {
            case 0:
                this.a.showToast(this.a.getString(com.baidu.tieba.a.k.success));
                arrayList = this.a.a;
                arrayList.remove(this.b);
                this.b = null;
                lVar = this.a.b;
                lVar.notifyDataSetChanged();
                break;
            case 1:
                if (accountData2 != null) {
                    new k(this.a, accountData2.getBDUSS()).start();
                }
                TbadkApplication.a(accountData2, this.a);
                TbadkApplication.j();
                TbadkApplication.M();
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
                com.baidu.tbadk.core.d.b.a(this.a, 1, false);
                break;
            case 2:
                TbadkApplication.j();
                TbadkApplication.M();
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
                com.baidu.tbadk.core.d.b.a(this.a, 11, false);
                break;
        }
        this.a.i = null;
    }

    public f(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.a = accountActivity;
        this.d = false;
        this.b = accountData;
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.a.k.deleting), new g(this));
    }

    private AccountData a() {
        ArrayList arrayList;
        ArrayList arrayList2;
        try {
            Thread.sleep(1000L);
            if (this.d) {
                com.baidu.adp.framework.c.a().b(new CustomResponsedMessage(2008015, this.b.getID()));
            }
            com.baidu.tieba.util.k.h(this.b.getID());
            if (this.b.getID().equals(TbadkApplication.E())) {
                arrayList = this.a.a;
                if (arrayList.size() >= 2) {
                    this.c = 1;
                    arrayList2 = this.a.a;
                    AccountData accountData = (AccountData) arrayList2.get(1);
                    accountData.setIsActive(1);
                    com.baidu.tbadk.core.a.o.a(accountData);
                    return accountData;
                }
                this.c = 2;
            } else {
                this.c = 0;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return null;
    }
}
