package com.baidu.tieba.discover;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends BdAsyncTask<String, Object, n> {
    private WeakReference<l> a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ n a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(n nVar) {
        n nVar2 = nVar;
        super.a((k) nVar2);
        l lVar = this.a.get();
        if (lVar != null) {
            if (bc.c(nVar2.b)) {
                lVar.a(nVar2);
            } else {
                lVar.a();
            }
        }
    }

    public k(l lVar) {
        this.a = new WeakReference<>(lVar);
        setPriority(3);
    }

    private static n a() {
        String str;
        str = j.a;
        ak akVar = new ak(str);
        String i = akVar.i();
        if (akVar.a().b().b()) {
            try {
                return DiscoverResponsedMessage.b(new JSONObject(i));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DicoverModel", "doInBackground", e.getMessage());
                n nVar = new n();
                nVar.a = -1000;
                nVar.b = "网络异常";
                return nVar;
            }
        }
        n nVar2 = new n();
        nVar2.a = akVar.d();
        nVar2.b = akVar.f();
        return nVar2;
    }
}
