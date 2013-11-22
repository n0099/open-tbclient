package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import com.google.gson.GsonBuilder;
import com.tencent.mm.sdk.platformtools.LBSManager;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Object, AppealData> {

    /* renamed from: a  reason: collision with root package name */
    private String f1050a;
    private String b;
    private String c;
    private String d;
    private WeakReference<h> e;

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.f1050a = str;
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
        str = f.f1049a;
        ap apVar = new ap(str);
        apVar.a("forum_id", this.f1050a);
        apVar.a(PushConstants.EXTRA_USER_ID, this.b);
        apVar.a("user_name", this.c);
        apVar.a("content", this.d);
        String l = apVar.l();
        if (apVar.c()) {
            try {
                return (AppealData) new GsonBuilder().create().fromJson(l, (Class<Object>) AppealData.class);
            } catch (Exception e) {
                bg.b("AppealModel", "doInBackground", e.getMessage());
                AppealData appealData = new AppealData();
                appealData.errNo = LBSManager.INVALID_ACC;
                return appealData;
            }
        }
        AppealData appealData2 = new AppealData();
        appealData2.errNo = apVar.e();
        appealData2.errMsg = apVar.i();
        return appealData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AppealData appealData) {
        super.a((g) appealData);
        h hVar = this.e.get();
        if (hVar != null) {
            if (appealData.errNo == 0 && be.c(appealData.errMsg)) {
                hVar.a(appealData);
            } else {
                hVar.b(appealData);
            }
        }
    }
}
