package com.baidu.tieba.account;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask<String, Integer, AccountData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f897a;
    private volatile com.baidu.tieba.util.z b = null;
    private String c;
    private String d;

    public an(ReLoginActivity reLoginActivity, String str, String str2) {
        this.f897a = reLoginActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f897a.m = null;
        this.f897a.p = null;
        this.f897a.o = System.currentTimeMillis();
        this.f897a.a(0, this.f897a.getIntent().getStringExtra("uname"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AccountData a(String... strArr) {
        String n;
        this.b = new com.baidu.tieba.util.z();
        if (this.d != null) {
            com.baidu.tieba.util.z zVar = this.b;
            String str = this.c;
            StringBuilder append = new StringBuilder(String.valueOf(this.d)).append('|');
            n = this.f897a.n();
            return com.baidu.tieba.f.a(zVar, str, append.append(n).toString());
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
        super.a((an) accountData);
        this.f897a.m = accountData;
        if (this.b != null) {
            this.f897a.p = this.b.g();
        }
        str = this.f897a.p;
        if (str == null) {
            this.f897a.p = this.f897a.getString(R.string.data_load_error);
        }
        this.b = null;
        this.f897a.c = null;
        long currentTimeMillis = 1000 - System.currentTimeMillis();
        j = this.f897a.o;
        long j2 = currentTimeMillis + j;
        if (j2 <= 0) {
            j2 = 0;
        }
        handler = this.f897a.q;
        runnable = this.f897a.r;
        handler.removeCallbacks(runnable);
        handler2 = this.f897a.q;
        runnable2 = this.f897a.r;
        handler2.postDelayed(runnable2, j2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f897a.c = null;
    }
}
