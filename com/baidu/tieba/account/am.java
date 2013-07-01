package com.baidu.tieba.account;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f650a;
    private volatile com.baidu.tieba.util.r b = null;
    private String c;
    private String d;

    public am(ReLoginActivity reLoginActivity, String str, String str2) {
        this.f650a = reLoginActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f650a.m = null;
        this.f650a.p = null;
        this.f650a.o = System.currentTimeMillis();
        this.f650a.a(0, this.f650a.getIntent().getStringExtra("uname"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AccountData a(String... strArr) {
        String o;
        this.b = new com.baidu.tieba.util.r();
        if (this.d != null) {
            com.baidu.tieba.util.r rVar = this.b;
            String str = this.c;
            StringBuilder append = new StringBuilder(String.valueOf(this.d)).append('|');
            o = this.f650a.o();
            return com.baidu.tieba.c.a(rVar, str, append.append(o).toString());
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
        super.a((Object) accountData);
        this.f650a.m = accountData;
        if (this.b != null) {
            this.f650a.p = this.b.g();
        }
        str = this.f650a.p;
        if (str == null) {
            this.f650a.p = this.f650a.getString(R.string.data_load_error);
        }
        this.b = null;
        this.f650a.c = null;
        long currentTimeMillis = 1000 - System.currentTimeMillis();
        j = this.f650a.o;
        long j2 = currentTimeMillis + j;
        if (j2 <= 0) {
            j2 = 0;
        }
        handler = this.f650a.q;
        runnable = this.f650a.r;
        handler.removeCallbacks(runnable);
        handler2 = this.f650a.q;
        runnable2 = this.f650a.r;
        handler2.postDelayed(runnable2, j2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f650a.c = null;
    }
}
