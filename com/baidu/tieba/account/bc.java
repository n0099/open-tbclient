package com.baidu.tieba.account;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends BdAsyncTask<String, Integer, AccountData> {
    final /* synthetic */ ReLoginActivity a;
    private volatile com.baidu.tieba.util.an b = null;
    private String c;
    private String d;

    public bc(ReLoginActivity reLoginActivity, String str, String str2) {
        this.a = reLoginActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.a.i = null;
        this.a.l = null;
        this.a.k = System.currentTimeMillis();
        this.a.a(0, this.a.getIntent().getStringExtra("uname"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AccountData a(String... strArr) {
        String f;
        this.b = new com.baidu.tieba.util.an();
        if (this.d != null) {
            com.baidu.tieba.util.an anVar = this.b;
            String str = this.c;
            StringBuilder append = new StringBuilder().append(this.d).append('|');
            f = this.a.f();
            return com.baidu.tieba.f.a(anVar, str, append.append(f).toString());
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
        super.a((bc) accountData);
        this.a.i = accountData;
        if (this.b != null) {
            this.a.l = this.b.i();
        }
        str = this.a.l;
        if (str == null) {
            this.a.l = this.a.getString(R.string.data_load_error);
        }
        this.b = null;
        this.a.b = null;
        long currentTimeMillis = 1000 - System.currentTimeMillis();
        j = this.a.k;
        long j2 = currentTimeMillis + j;
        if (j2 <= 0) {
            j2 = 0;
        }
        handler = this.a.n;
        runnable = this.a.o;
        handler.removeCallbacks(runnable);
        handler2 = this.a.n;
        runnable2 = this.a.o;
        handler2.postDelayed(runnable2, j2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.a.b = null;
    }
}
