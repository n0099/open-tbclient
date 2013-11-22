package com.baidu.tieba.account;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask<String, Integer, AccountData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1041a;
    private volatile com.baidu.tieba.util.ap b = null;
    private String c;
    private String d;

    public ao(ReLoginActivity reLoginActivity, String str, String str2) {
        this.f1041a = reLoginActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1041a.i = null;
        this.f1041a.l = null;
        this.f1041a.k = System.currentTimeMillis();
        this.f1041a.a(0, this.f1041a.getIntent().getStringExtra("uname"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AccountData a(String... strArr) {
        String f;
        this.b = new com.baidu.tieba.util.ap();
        if (this.d != null) {
            com.baidu.tieba.util.ap apVar = this.b;
            String str = this.c;
            StringBuilder append = new StringBuilder().append(this.d).append('|');
            f = this.f1041a.f();
            return com.baidu.tieba.f.a(apVar, str, append.append(f).toString());
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
        this.f1041a.i = accountData;
        if (this.b != null) {
            this.f1041a.l = this.b.i();
        }
        str = this.f1041a.l;
        if (str == null) {
            this.f1041a.l = this.f1041a.getString(R.string.data_load_error);
        }
        this.b = null;
        this.f1041a.b = null;
        long currentTimeMillis = 1000 - System.currentTimeMillis();
        j = this.f1041a.k;
        long j2 = currentTimeMillis + j;
        if (j2 <= 0) {
            j2 = 0;
        }
        handler = this.f1041a.n;
        runnable = this.f1041a.o;
        handler.removeCallbacks(runnable);
        handler2 = this.f1041a.n;
        runnable2 = this.f1041a.o;
        handler2.postDelayed(runnable2, j2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.f1041a.b = null;
    }
}
