package com.baidu.tieba.forumdetail;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
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
    public final /* synthetic */ ForumDetailData a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ForumDetailData forumDetailData) {
        ForumDetailData forumDetailData2 = forumDetailData;
        super.a((c) forumDetailData2);
        d dVar = this.c.get();
        if (dVar != null) {
            if (bs.c(forumDetailData2.errorMsg)) {
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

    private ForumDetailData d() {
        String str;
        str = b.a;
        ba baVar = new ba(str);
        baVar.a("forum_id", this.a);
        baVar.a("need_good_thread", this.b);
        String l = baVar.l();
        if (baVar.c()) {
            try {
                return (ForumDetailData) new GsonBuilder().create().fromJson(l, (Class<Object>) ForumDetailData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("ForumDetailModel", "doInBackground", e.getMessage());
                ForumDetailData forumDetailData = new ForumDetailData();
                forumDetailData.errorNo = -1000;
                forumDetailData.errorMsg = "网络异常";
                return forumDetailData;
            }
        }
        ForumDetailData forumDetailData2 = new ForumDetailData();
        forumDetailData2.errorNo = baVar.e();
        forumDetailData2.errorMsg = baVar.i();
        return forumDetailData2;
    }
}
