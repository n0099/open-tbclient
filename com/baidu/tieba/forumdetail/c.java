package com.baidu.tieba.forumdetail;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import com.google.gson.GsonBuilder;
import com.tencent.mm.sdk.platformtools.LBSManager;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Object, ForumDetailData> {

    /* renamed from: a  reason: collision with root package name */
    private String f1280a;
    private String b;
    private WeakReference<d> c;

    public c(String str, String str2, d dVar) {
        this.f1280a = str;
        this.b = str2;
        this.c = new WeakReference<>(dVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumDetailData a(String... strArr) {
        String str;
        str = b.f1279a;
        ap apVar = new ap(str);
        apVar.a("forum_id", this.f1280a);
        apVar.a("need_good_thread", this.b);
        String l = apVar.l();
        if (apVar.c()) {
            try {
                return (ForumDetailData) new GsonBuilder().create().fromJson(l, (Class<Object>) ForumDetailData.class);
            } catch (Exception e) {
                bg.b("ForumDetailModel", "doInBackground", e.getMessage());
                ForumDetailData forumDetailData = new ForumDetailData();
                forumDetailData.errorNo = LBSManager.INVALID_ACC;
                forumDetailData.errorMsg = "网络异常";
                return forumDetailData;
            }
        }
        ForumDetailData forumDetailData2 = new ForumDetailData();
        forumDetailData2.errorNo = apVar.e();
        forumDetailData2.errorMsg = apVar.i();
        return forumDetailData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumDetailData forumDetailData) {
        super.a((c) forumDetailData);
        d dVar = this.c.get();
        if (dVar != null) {
            if (be.c(forumDetailData.errorMsg)) {
                dVar.a(forumDetailData);
            } else {
                dVar.b(forumDetailData);
            }
        }
    }
}
