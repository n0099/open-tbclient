package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af extends BdAsyncTask<String, Integer, com.baidu.tieba.data.e> {
    final /* synthetic */ y a;
    private com.baidu.tieba.util.ba b = null;
    private String c;
    private String d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.e a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.e eVar) {
        ProgressBar progressBar;
        Button button;
        AccountData accountData;
        com.baidu.tieba.f fVar;
        ad adVar;
        ad adVar2;
        AccountData accountData2;
        com.baidu.tieba.data.e eVar2 = eVar;
        super.a((af) eVar2);
        this.a.l = null;
        progressBar = this.a.q;
        progressBar.setVisibility(8);
        button = this.a.o;
        button.setEnabled(true);
        if (eVar2 == null) {
            this.a.b(this.b.i());
        } else if (eVar2.a().getUserName() != null) {
            this.a.e();
            accountData = this.a.t;
            fVar = this.a.j;
            TiebaApplication.a(accountData, fVar);
            adVar = this.a.u;
            if (adVar != null) {
                adVar2 = this.a.u;
                accountData2 = this.a.t;
                adVar2.a(accountData2);
            }
        } else {
            this.a.b(this.b.i());
            this.a.a(eVar2.b());
        }
    }

    public af(y yVar, String str, String str2) {
        this.a = yVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        Button button;
        this.a.l = null;
        progressBar = this.a.q;
        progressBar.setVisibility(8);
        button = this.a.o;
        button.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.q;
        progressBar.setVisibility(0);
        button = this.a.o;
        button.setEnabled(false);
        this.a.b((String) null);
        this.a.d();
        super.b();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0001 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0090 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.data.e] */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.baidu.tieba.data.AccountData] */
    private com.baidu.tieba.data.e d() {
        String str;
        Exception e;
        AccountData accountData;
        String l;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        AccountData accountData5;
        ?? r1;
        String str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        try {
            this.b = new com.baidu.tieba.util.ba(this.c);
            this.b.a("un", this.d);
            com.baidu.tieba.util.ba baVar = this.b;
            accountData = this.a.t;
            baVar.a("BDUSS", accountData.getBDUSS());
            this.b.c(false);
            l = this.b.l();
        } catch (Exception e2) {
            str = str2;
            e = e2;
        }
        if (this.b.d()) {
            str = this.b.e();
            try {
                if (str == 0) {
                    com.baidu.tieba.data.e eVar = new com.baidu.tieba.data.e();
                    eVar.a(l);
                    String userName = eVar.a().getUserName();
                    String bduss = eVar.a().getBDUSS();
                    str = eVar;
                    str = eVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        accountData2 = this.a.t;
                        str = eVar;
                        str2 = userName;
                        if (accountData2 != null) {
                            accountData3 = this.a.t;
                            accountData3.setAccount(userName);
                            accountData4 = this.a.t;
                            accountData4.setBDUSS(bduss);
                            accountData5 = this.a.t;
                            accountData5.setPortrait(eVar.a().getPortrait());
                            r1 = this.a.t;
                            DatabaseService.a((AccountData) r1);
                            str = eVar;
                            str2 = r1;
                        }
                    }
                } else if (this.b.e() == 36) {
                    com.baidu.tieba.data.e eVar2 = new com.baidu.tieba.data.e();
                    eVar2.a(l);
                    str = eVar2;
                } else if (this.b.e() == 1) {
                    this.a.e();
                    str = 0;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }
}
