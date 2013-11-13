package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<String, Integer, com.baidu.tieba.data.d> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1089a;
    private com.baidu.tieba.util.ap b = null;
    private String c;
    private String d;

    public s(l lVar, String str, String str2) {
        this.f1089a = lVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        this.f1089a.l = null;
        progressBar = this.f1089a.q;
        progressBar.setVisibility(8);
        button = this.f1089a.o;
        button.setEnabled(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.d dVar) {
        ProgressBar progressBar;
        Button button;
        AccountData accountData;
        com.baidu.tieba.j jVar;
        q qVar;
        q qVar2;
        AccountData accountData2;
        super.a((s) dVar);
        this.f1089a.l = null;
        progressBar = this.f1089a.q;
        progressBar.setVisibility(8);
        button = this.f1089a.o;
        button.setEnabled(true);
        if (dVar == null) {
            this.f1089a.b(this.b.g());
        } else if (dVar.a().getName() == null) {
            this.f1089a.b(this.b.g());
            this.f1089a.a(dVar.b());
        } else {
            this.f1089a.e();
            accountData = this.f1089a.t;
            jVar = this.f1089a.j;
            TiebaApplication.a(accountData, jVar);
            a.a().b();
            qVar = this.f1089a.u;
            if (qVar != null) {
                qVar2 = this.f1089a.u;
                accountData2 = this.f1089a.t;
                qVar2.a(accountData2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f1089a.q;
        progressBar.setVisibility(0);
        button = this.f1089a.o;
        button.setEnabled(false);
        this.f1089a.b((String) null);
        this.f1089a.d();
        super.b();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x003e */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.tieba.data.d */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: com.baidu.tieba.data.d */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.data.d */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.data.d] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.d a(String... strArr) {
        com.baidu.tieba.data.d dVar;
        Exception e;
        AccountData accountData;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        AccountData accountData5;
        AccountData accountData6;
        try {
            this.b = new com.baidu.tieba.util.ap(this.c);
            this.b.a("un", this.d);
            com.baidu.tieba.util.ap apVar = this.b;
            accountData = this.f1089a.t;
            apVar.a("BDUSS", accountData.getBDUSS());
            this.b.c(false);
            String j = this.b.j();
            if (this.b.d()) {
                dVar = this.b.e();
                try {
                    if (dVar == 0) {
                        com.baidu.tieba.data.d dVar2 = new com.baidu.tieba.data.d();
                        dVar2.a(j);
                        String name = dVar2.a().getName();
                        String bduss = dVar2.a().getBDUSS();
                        dVar = dVar2;
                        dVar = dVar2;
                        if (name != null && bduss != null) {
                            accountData2 = this.f1089a.t;
                            dVar = dVar2;
                            if (accountData2 != null) {
                                accountData3 = this.f1089a.t;
                                accountData3.setAccount(name);
                                accountData4 = this.f1089a.t;
                                accountData4.setBDUSS(bduss);
                                accountData5 = this.f1089a.t;
                                accountData5.setPortrait(dVar2.a().getPortrait());
                                accountData6 = this.f1089a.t;
                                DatabaseService.a(accountData6);
                                dVar = dVar2;
                            }
                        }
                    } else if (this.b.e() == 36) {
                        com.baidu.tieba.data.d dVar3 = new com.baidu.tieba.data.d();
                        dVar3.a(j);
                        dVar = dVar3;
                    } else if (this.b.e() == 1) {
                        this.f1089a.e();
                    }
                    return dVar;
                } catch (Exception e2) {
                    e = e2;
                    bg.b(getClass().getName(), "doInBackground", e.getMessage());
                    return dVar;
                }
            }
            return null;
        } catch (Exception e3) {
            dVar = 0;
            e = e3;
        }
    }
}
