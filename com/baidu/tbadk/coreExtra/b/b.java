package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.a.h;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.message.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ a a;
    private ak b;
    private boolean c;
    private String d;
    private String e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(Integer... numArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        super.a((b) str);
        this.a.a = null;
        if (this.b != null) {
            d dVar = new d();
            dVar.a = this.b.a().b().b();
            dVar.b = this.b.f();
            dVar.d = this.c;
            dVar.c = this.e;
            com.baidu.adp.framework.c.a().b(new UpdateAttentionMessage(dVar));
        }
    }

    private b(a aVar) {
        this.a = aVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void a2(String str) {
        this.d = str;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    private String a() {
        try {
            if (this.d != null) {
                this.b = new ak();
                if (this.c) {
                    this.b.a(String.valueOf(n.a) + "c/c/user/follow");
                } else {
                    this.b.a(String.valueOf(n.a) + "c/c/user/unfollow");
                }
                this.b.a("portrait", this.d);
                this.b.a().a().a = true;
                this.b.i();
                return null;
            }
            return null;
        } catch (Exception e) {
            f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        h hVar;
        h hVar2;
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.a = null;
        hVar = this.a.b;
        if (hVar != null) {
            hVar2 = this.a.b;
            hVar2.a(false);
        }
    }
}
