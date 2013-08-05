package com.baidu.tieba.account;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f862a;
    private volatile com.baidu.tieba.util.u b = null;
    private String c;
    private String d;

    public an(ReLoginActivity reLoginActivity, String str, String str2) {
        this.f862a = reLoginActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f862a.m = null;
        this.f862a.p = null;
        this.f862a.o = System.currentTimeMillis();
        this.f862a.a(0, this.f862a.getIntent().getStringExtra("uname"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AccountData a(String... strArr) {
        String m;
        this.b = new com.baidu.tieba.util.u();
        if (this.d != null) {
            com.baidu.tieba.util.u uVar = this.b;
            String str = this.c;
            StringBuilder append = new StringBuilder(String.valueOf(this.d)).append('|');
            m = this.f862a.m();
            return com.baidu.tieba.c.a(uVar, str, append.append(m).toString());
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
        this.f862a.m = accountData;
        if (this.b != null) {
            this.f862a.p = this.b.h();
        }
        str = this.f862a.p;
        if (str == null) {
            this.f862a.p = this.f862a.getString(R.string.data_load_error);
        }
        this.b = null;
        this.f862a.c = null;
        long currentTimeMillis = 1000 - System.currentTimeMillis();
        j = this.f862a.o;
        long j2 = currentTimeMillis + j;
        if (j2 <= 0) {
            j2 = 0;
        }
        handler = this.f862a.q;
        runnable = this.f862a.r;
        handler.removeCallbacks(runnable);
        handler2 = this.f862a.q;
        runnable2 = this.f862a.r;
        handler2.postDelayed(runnable2, j2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
        }
        this.f862a.c = null;
    }
}
