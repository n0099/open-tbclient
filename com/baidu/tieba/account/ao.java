package com.baidu.tieba.account;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask<String, Integer, AccountData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1027a;
    private volatile com.baidu.tieba.util.ag b = null;
    private String c;
    private String d;

    public ao(ReLoginActivity reLoginActivity, String str, String str2) {
        this.f1027a = reLoginActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1027a.m = null;
        this.f1027a.p = null;
        this.f1027a.o = System.currentTimeMillis();
        this.f1027a.a(0, this.f1027a.getIntent().getStringExtra("uname"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AccountData a(String... strArr) {
        String n;
        this.b = new com.baidu.tieba.util.ag();
        if (this.d != null) {
            com.baidu.tieba.util.ag agVar = this.b;
            String str = this.c;
            StringBuilder append = new StringBuilder().append(this.d).append('|');
            n = this.f1027a.n();
            return com.baidu.tieba.f.a(agVar, str, append.append(n).toString());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AccountData accountData) {
        String str;
        long j;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        super.a((ao) accountData);
        this.f1027a.m = accountData;
        if (this.b != null) {
            this.f1027a.p = this.b.g();
        }
        str = this.f1027a.p;
        if (str == null) {
            this.f1027a.p = this.f1027a.getString(R.string.data_load_error);
        }
        this.b = null;
        this.f1027a.c = null;
        long currentTimeMillis = 1000 - System.currentTimeMillis();
        j = this.f1027a.o;
        long j2 = currentTimeMillis + j;
        if (j2 <= 0) {
            j2 = 0;
        }
        handler = this.f1027a.q;
        runnable = this.f1027a.r;
        handler.removeCallbacks(runnable);
        handler2 = this.f1027a.q;
        runnable2 = this.f1027a.r;
        handler2.postDelayed(runnable2, j2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f1027a.c = null;
    }
}
