package com.baidu.tieba.forumdetail;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.an;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Object, ForumDetailData> {
    private String a;
    private String b;
    private WeakReference<d> c;

    public c(String str, String str2, d dVar) {
        this.a = str;
        this.b = str2;
        this.c = new WeakReference<>(dVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumDetailData a(String... strArr) {
        String str;
        str = b.a;
        an anVar = new an(str);
        anVar.a("forum_id", this.a);
        anVar.a("need_good_thread", this.b);
        String l = anVar.l();
        if (anVar.c()) {
            try {
                return (ForumDetailData) new GsonBuilder().create().fromJson(l, (Class<Object>) ForumDetailData.class);
            } catch (Exception e) {
                be.b("ForumDetailModel", "doInBackground", e.getMessage());
                ForumDetailData forumDetailData = new ForumDetailData();
                forumDetailData.errorNo = -1000;
                forumDetailData.errorMsg = "网络异常";
                return forumDetailData;
            }
        }
        ForumDetailData forumDetailData2 = new ForumDetailData();
        forumDetailData2.errorNo = anVar.e();
        forumDetailData2.errorMsg = anVar.i();
        return forumDetailData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumDetailData forumDetailData) {
        super.a((c) forumDetailData);
        d dVar = this.c.get();
        if (dVar != null) {
            if (bc.c(forumDetailData.errorMsg)) {
                dVar.a(forumDetailData);
            } else {
                dVar.b(forumDetailData);
            }
        }
    }
}
