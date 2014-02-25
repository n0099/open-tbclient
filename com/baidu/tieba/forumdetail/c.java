package com.baidu.tieba.forumdetail;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
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
        ba baVar = new ba(str);
        baVar.a("forum_id", this.a);
        baVar.a("need_good_thread", this.b);
        String m = baVar.m();
        if (baVar.d()) {
            try {
                return (ForumDetailData) new GsonBuilder().create().fromJson(m, (Class<Object>) ForumDetailData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("ForumDetailModel", "doInBackground", e.getMessage());
                ForumDetailData forumDetailData = new ForumDetailData();
                forumDetailData.errorNo = -1000;
                forumDetailData.errorMsg = "网络异常";
                return forumDetailData;
            }
        }
        ForumDetailData forumDetailData2 = new ForumDetailData();
        forumDetailData2.errorNo = baVar.f();
        forumDetailData2.errorMsg = baVar.j();
        return forumDetailData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumDetailData forumDetailData) {
        super.a((c) forumDetailData);
        d dVar = this.c.get();
        if (dVar != null) {
            if (bs.c(forumDetailData.errorMsg)) {
                dVar.a(forumDetailData);
            } else {
                dVar.b(forumDetailData);
            }
        }
    }
}
