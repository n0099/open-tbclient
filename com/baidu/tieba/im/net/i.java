package com.baidu.tieba.im.net;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Void, Boolean> {
    Process a;
    final /* synthetic */ h b;

    private i(h hVar) {
        this.b = hVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(h hVar, i iVar) {
        this(hVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [115=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        boolean z = false;
        if (strArr != null && strArr.length >= 1) {
            try {
                try {
                    this.a = Runtime.getRuntime().exec(strArr[0]);
                    boolean z2 = this.a.waitFor() == 0;
                    this.a.destroy();
                    z = z2;
                } catch (IOException e) {
                    e.printStackTrace();
                    this.a.destroy();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    this.a.destroy();
                }
            } catch (Throwable th) {
                this.a.destroy();
                throw th;
            }
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        j jVar;
        k kVar;
        k kVar2;
        j jVar2;
        jVar = this.b.b;
        if (jVar != null) {
            jVar2 = this.b.b;
            jVar2.a(bool.booleanValue());
        }
        kVar = this.b.a;
        if (kVar != null) {
            kVar2 = this.b.a;
            kVar2.removeMessages(0);
        }
    }
}
