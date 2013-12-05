package com.baidu.tieba.forumdetail;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.bd;
import com.tencent.mm.sdk.platformtools.LBSManager;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Object, ForumDetailData> {

    /* renamed from: a  reason: collision with root package name */
    private String f1327a;
    private String b;
    private WeakReference<d> c;

    public c(String str, String str2, d dVar) {
        this.f1327a = str;
        this.b = str2;
        this.c = new WeakReference<>(dVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumDetailData a(String... strArr) {
        String str;
        str = b.f1326a;
        am amVar = new am(str);
        amVar.a("forum_id", this.f1327a);
        amVar.a("need_good_thread", this.b);
        String l = amVar.l();
        if (amVar.c()) {
            try {
                return (ForumDetailData) new GsonBuilder().create().fromJson(l, (Class<Object>) ForumDetailData.class);
            } catch (Exception e) {
                bd.b("ForumDetailModel", "doInBackground", e.getMessage());
                ForumDetailData forumDetailData = new ForumDetailData();
                forumDetailData.errorNo = LBSManager.INVALID_ACC;
                forumDetailData.errorMsg = "网络异常";
                return forumDetailData;
            }
        }
        ForumDetailData forumDetailData2 = new ForumDetailData();
        forumDetailData2.errorNo = amVar.e();
        forumDetailData2.errorMsg = amVar.i();
        return forumDetailData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumDetailData forumDetailData) {
        super.a((c) forumDetailData);
        d dVar = this.c.get();
        if (dVar != null) {
            if (bb.c(forumDetailData.errorMsg)) {
                dVar.a(forumDetailData);
            } else {
                dVar.b(forumDetailData);
            }
        }
    }
}
