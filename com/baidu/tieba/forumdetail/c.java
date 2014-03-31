package com.baidu.tieba.forumdetail;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<String, Object, ForumDetailData> {
    private String a;
    private String b;
    private WeakReference<d> c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ ForumDetailData a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ForumDetailData forumDetailData) {
        ForumDetailData forumDetailData2 = forumDetailData;
        super.a((c) forumDetailData2);
        d dVar = this.c.get();
        if (dVar != null) {
            if (bc.c(forumDetailData2.errorMsg)) {
                dVar.a(forumDetailData2);
            } else {
                dVar.b(forumDetailData2);
            }
        }
    }

    public c(String str, String str2, d dVar) {
        this.a = str;
        this.b = str2;
        this.c = new WeakReference<>(dVar);
        setPriority(3);
    }

    private ForumDetailData a() {
        String str;
        str = b.a;
        ak akVar = new ak(str);
        akVar.a("forum_id", this.a);
        akVar.a("need_good_thread", this.b);
        String i = akVar.i();
        if (akVar.a().b().b()) {
            try {
                return (ForumDetailData) new GsonBuilder().create().fromJson(i, (Class<Object>) ForumDetailData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("ForumDetailModel", "doInBackground", e.getMessage());
                ForumDetailData forumDetailData = new ForumDetailData();
                forumDetailData.errorNo = -1000;
                forumDetailData.errorMsg = "网络异常";
                return forumDetailData;
            }
        }
        ForumDetailData forumDetailData2 = new ForumDetailData();
        forumDetailData2.errorNo = akVar.d();
        forumDetailData2.errorMsg = akVar.f();
        return forumDetailData2;
    }
}
