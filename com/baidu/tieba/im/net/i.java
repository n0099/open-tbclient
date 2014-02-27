package com.baidu.tieba.im.net;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<String, Void, Boolean> {
    Process a;
    final /* synthetic */ h b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        j jVar;
        k kVar;
        k kVar2;
        j jVar2;
        Boolean bool2 = bool;
        jVar = this.b.b;
        if (jVar != null) {
            jVar2 = this.b.b;
            jVar2.a(bool2 == null ? false : bool2.booleanValue());
        }
        kVar = this.b.a;
        if (kVar != null) {
            kVar2 = this.b.a;
            kVar2.removeMessages(0);
        }
    }

    private i(h hVar) {
        this.b = hVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(h hVar, byte b) {
        this(hVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [115=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                this.a = Runtime.getRuntime().exec(strArr[0]);
                r0 = this.a.waitFor() == 0;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            } finally {
                this.a.destroy();
            }
        }
        return Boolean.valueOf(r0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        j jVar;
        k kVar;
        k kVar2;
        j jVar2;
        super.c();
        if (this.a != null) {
            try {
                this.a.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        jVar = this.b.b;
        if (jVar != null) {
            jVar2 = this.b.b;
            jVar2.a(false);
        }
        kVar = this.b.a;
        if (kVar != null) {
            kVar2 = this.b.a;
            kVar2.removeMessages(0);
        }
    }
}
