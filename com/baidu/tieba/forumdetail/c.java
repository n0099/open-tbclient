package com.baidu.tieba.forumdetail;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.z;
import com.google.gson.GsonBuilder;
import com.tencent.mm.sdk.platformtools.LBSManager;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Object, ForumDetailData> {

    /* renamed from: a  reason: collision with root package name */
    private String f1086a;
    private String b;
    private WeakReference<d> c;

    public c(String str, String str2, d dVar) {
        this.f1086a = str;
        this.b = str2;
        this.c = new WeakReference<>(dVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumDetailData a(String... strArr) {
        String str;
        str = b.f1085a;
        z zVar = new z(str);
        zVar.a("forum_id", this.f1086a);
        zVar.a("need_good_thread", this.b);
        String j = zVar.j();
        if (zVar.c()) {
            try {
                return (ForumDetailData) new GsonBuilder().create().fromJson(j, (Class<Object>) ForumDetailData.class);
            } catch (Exception e) {
                av.b("ForumDetailModel", "doInBackground", e.getMessage());
                ForumDetailData forumDetailData = new ForumDetailData();
                forumDetailData.errorNo = LBSManager.INVALID_ACC;
                forumDetailData.errorMsg = "网络异常";
                return forumDetailData;
            }
        }
        ForumDetailData forumDetailData2 = new ForumDetailData();
        forumDetailData2.errorNo = zVar.e();
        forumDetailData2.errorMsg = zVar.g();
        return forumDetailData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumDetailData forumDetailData) {
        super.a((c) forumDetailData);
        d dVar = this.c.get();
        if (dVar != null) {
            if (at.c(forumDetailData.errorMsg)) {
                dVar.a(forumDetailData);
            } else {
                dVar.b(forumDetailData);
            }
        }
    }
}
