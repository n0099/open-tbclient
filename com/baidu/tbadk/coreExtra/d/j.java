package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends BdAsyncTask<String, Void, Boolean> {
    Process a;
    final /* synthetic */ i b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        k kVar;
        l lVar;
        l lVar2;
        k kVar2;
        Boolean bool2 = bool;
        kVar = this.b.b;
        if (kVar != null) {
            kVar2 = this.b.b;
            kVar2.a(bool2 == null ? false : bool2.booleanValue());
        }
        lVar = this.b.a;
        if (lVar != null) {
            lVar2 = this.b.a;
            lVar2.removeMessages(0);
        }
    }

    private j(i iVar) {
        this.b = iVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(i iVar, byte b) {
        this(iVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=4] */
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
    public final void d() {
        k kVar;
        l lVar;
        l lVar2;
        k kVar2;
        super.d();
        if (this.a != null) {
            try {
                this.a.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        kVar = this.b.b;
        if (kVar != null) {
            kVar2 = this.b.b;
            kVar2.a(false);
        }
        lVar = this.b.a;
        if (lVar != null) {
            lVar2 = this.b.a;
            lVar2.removeMessages(0);
        }
    }
}
