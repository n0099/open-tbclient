package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Object, AppealData> {
    private String a;
    private String b;
    private String c;
    private String d;
    private WeakReference<h> e;

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = new WeakReference<>(hVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AppealData a(String... strArr) {
        String str;
        str = f.a;
        ba baVar = new ba(str);
        baVar.a("forum_id", this.a);
        baVar.a(PushConstants.EXTRA_USER_ID, this.b);
        baVar.a("user_name", this.c);
        baVar.a(PushConstants.EXTRA_CONTENT, this.d);
        String m = baVar.m();
        if (baVar.d()) {
            try {
                return (AppealData) new GsonBuilder().create().fromJson(m, (Class<Object>) AppealData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("AppealModel", "doInBackground", e.getMessage());
                AppealData appealData = new AppealData();
                appealData.errNo = -1000;
                return appealData;
            }
        }
        AppealData appealData2 = new AppealData();
        appealData2.errNo = baVar.f();
        appealData2.errMsg = baVar.j();
        return appealData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AppealData appealData) {
        super.a((g) appealData);
        h hVar = this.e.get();
        if (hVar != null) {
            if (appealData.errNo == 0 && bs.c(appealData.errMsg)) {
                hVar.a(appealData);
            } else {
                hVar.b(appealData);
            }
        }
    }
}
