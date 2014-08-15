package com.baidu.tieba.forumdetail;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ba;
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
    /* renamed from: a */
    public ForumDetailData doInBackground(String... strArr) {
        String str;
        str = b.a;
        ae aeVar = new ae(str);
        aeVar.a(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, this.a);
        aeVar.a("need_good_thread", this.b);
        String h = aeVar.h();
        if (aeVar.a().b().b()) {
            try {
                return (ForumDetailData) new GsonBuilder().create().fromJson(h, (Class<Object>) ForumDetailData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForumDetailData forumDetailData = new ForumDetailData();
                forumDetailData.errorNo = -1000;
                forumDetailData.errorMsg = "网络异常";
                return forumDetailData;
            }
        }
        ForumDetailData forumDetailData2 = new ForumDetailData();
        forumDetailData2.errorNo = aeVar.c();
        forumDetailData2.errorMsg = aeVar.e();
        return forumDetailData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ForumDetailData forumDetailData) {
        super.onPostExecute(forumDetailData);
        d dVar = this.c.get();
        if (dVar != null) {
            if (ba.c(forumDetailData.errorMsg)) {
                dVar.a(forumDetailData);
            } else {
                dVar.b(forumDetailData);
            }
        }
    }
}
