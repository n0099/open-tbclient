package com.baidu.tieba.account.forbid;

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
public class m extends BdAsyncTask<String, Object, ForbidTplData> {

    /* renamed from: a  reason: collision with root package name */
    private String f1080a;
    private String b;
    private WeakReference<n> c;

    public m(String str, String str2, n nVar) {
        this.f1080a = str;
        this.b = str2;
        this.c = new WeakReference<>(nVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForbidTplData a(String... strArr) {
        String str;
        str = l.f1079a;
        ap apVar = new ap(str);
        apVar.a("forum_id", this.f1080a);
        apVar.a(PushConstants.EXTRA_USER_ID, this.b);
        String j = apVar.j();
        if (apVar.c()) {
            try {
                return (ForbidTplData) new GsonBuilder().create().fromJson(j, (Class<Object>) ForbidTplData.class);
            } catch (Exception e) {
                bg.b("ForbidTplModel", "doInBackground", e.getMessage());
                ForbidTplData forbidTplData = new ForbidTplData();
                forbidTplData.error.f1078a = LBSManager.INVALID_ACC;
                return forbidTplData;
            }
        }
        ForbidTplData forbidTplData2 = new ForbidTplData();
        forbidTplData2.error.f1078a = apVar.e();
        forbidTplData2.error.b = apVar.g();
        return forbidTplData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForbidTplData forbidTplData) {
        super.a((m) forbidTplData);
        n nVar = this.c.get();
        if (nVar != null) {
            if (forbidTplData.error.f1078a == 0 && be.c(forbidTplData.error.b)) {
                nVar.a(forbidTplData);
            } else {
                nVar.b(forbidTplData);
            }
        }
    }
}
