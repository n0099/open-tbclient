package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import com.google.gson.GsonBuilder;
import com.tencent.mm.sdk.platformtools.LBSManager;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Object, ForbidResultData> {

    /* renamed from: a  reason: collision with root package name */
    private String f1077a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private WeakReference<j> g;

    public i(String str, String str2, String str3, String str4, String str5, String str6, j jVar) {
        this.f1077a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = new WeakReference<>(jVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForbidResultData a(String... strArr) {
        String str;
        str = h.f1076a;
        ap apVar = new ap(str);
        apVar.a("day", this.e);
        apVar.a("un", this.d);
        apVar.a("fid", this.f1077a);
        apVar.a("word", this.b);
        apVar.a("z", this.c);
        apVar.a("reason", this.f);
        apVar.a("ntn", "banid");
        apVar.e(true);
        String l = apVar.l();
        if (apVar.c()) {
            try {
                return (ForbidResultData) new GsonBuilder().create().fromJson(l, (Class<Object>) ForbidResultData.class);
            } catch (Exception e) {
                bg.b("ForbidPostModel", "doInBackground", e.getMessage());
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.errNo = LBSManager.INVALID_ACC;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.errNo = apVar.e();
        forbidResultData2.errMsg = apVar.i();
        return forbidResultData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForbidResultData forbidResultData) {
        super.a((i) forbidResultData);
        j jVar = this.g.get();
        if (jVar != null) {
            if (forbidResultData.errNo == 0 && be.c(forbidResultData.errMsg)) {
                jVar.a(forbidResultData);
            } else {
                jVar.b(forbidResultData);
            }
        }
    }
}
