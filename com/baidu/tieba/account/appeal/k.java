package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import java.lang.ref.WeakReference;
import org.apache.commons.io.IOUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends BdAsyncTask<String, Object, ForbidReasonData> {
    private String a;
    private String b;
    private WeakReference<l> c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ ForbidReasonData a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ForbidReasonData forbidReasonData) {
        ForbidReasonData forbidReasonData2 = forbidReasonData;
        super.a((k) forbidReasonData2);
        l lVar = this.c.get();
        if (lVar != null) {
            if (forbidReasonData2.error.a == 0 && bc.c(forbidReasonData2.error.b)) {
                lVar.a(forbidReasonData2);
            } else {
                lVar.b(forbidReasonData2);
            }
        }
    }

    public k(String str, String str2, l lVar) {
        this.a = str;
        this.b = str2;
        this.c = new WeakReference<>(lVar);
        setPriority(3);
    }

    private ForbidReasonData a() {
        String str;
        str = j.a;
        ak akVar = new ak(str);
        akVar.a("forum_id", this.a);
        akVar.a("user_id", this.b);
        String i = akVar.i();
        if (akVar.a().b().b()) {
            try {
                ForbidReasonData forbidReasonData = (ForbidReasonData) new GsonBuilder().create().fromJson(i, (Class<Object>) ForbidReasonData.class);
                forbidReasonData.reason = forbidReasonData.reason.replaceAll("\\\\n", IOUtils.LINE_SEPARATOR_UNIX);
                return forbidReasonData;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("ForbidReasonModel", "doInBackground", e.getMessage());
                ForbidReasonData forbidReasonData2 = new ForbidReasonData();
                forbidReasonData2.error.a = -1000;
                return forbidReasonData2;
            }
        }
        ForbidReasonData forbidReasonData3 = new ForbidReasonData();
        forbidReasonData3.error.a = akVar.d();
        forbidReasonData3.error.b = akVar.f();
        return forbidReasonData3;
    }
}
