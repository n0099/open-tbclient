package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends BdAsyncTask<String, Object, AppealData> {
    private String a;
    private String b;
    private String c;
    private String d;
    private WeakReference<h> e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ AppealData a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(AppealData appealData) {
        AppealData appealData2 = appealData;
        super.a((g) appealData2);
        h hVar = this.e.get();
        if (hVar != null) {
            if (appealData2.errNo == 0 && bc.c(appealData2.errMsg)) {
                hVar.a();
            } else {
                hVar.a(appealData2);
            }
        }
    }

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = new WeakReference<>(hVar);
        setPriority(3);
    }

    private AppealData a() {
        String str;
        str = f.a;
        ak akVar = new ak(str);
        akVar.a("forum_id", this.a);
        akVar.a("user_id", this.b);
        akVar.a("user_name", this.c);
        akVar.a("content", this.d);
        String i = akVar.i();
        if (akVar.a().b().b()) {
            try {
                return (AppealData) new GsonBuilder().create().fromJson(i, (Class<Object>) AppealData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("AppealModel", "doInBackground", e.getMessage());
                AppealData appealData = new AppealData();
                appealData.errNo = -1000;
                return appealData;
            }
        }
        AppealData appealData2 = new AppealData();
        appealData2.errNo = akVar.d();
        appealData2.errMsg = akVar.f();
        return appealData2;
    }
}
