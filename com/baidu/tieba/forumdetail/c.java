package com.baidu.tieba.forumdetail;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.az;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Object, ForumDetailData> {
    private String agf;
    private WeakReference<d> agj;
    private String axh;

    public c(String str, String str2, d dVar) {
        this.agf = str;
        this.axh = str2;
        this.agj = new WeakReference<>(dVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: v */
    public ForumDetailData doInBackground(String... strArr) {
        String str;
        str = b.axg;
        ac acVar = new ac(str);
        acVar.k("forum_id", this.agf);
        acVar.k("need_good_thread", this.axh);
        String lA = acVar.lA();
        if (acVar.mc().nb().jq()) {
            try {
                return (ForumDetailData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, ForumDetailData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForumDetailData forumDetailData = new ForumDetailData();
                forumDetailData.errno = -1000;
                forumDetailData.errmsg = "网络异常";
                return forumDetailData;
            }
        }
        ForumDetailData forumDetailData2 = new ForumDetailData();
        forumDetailData2.errno = acVar.mg();
        forumDetailData2.errmsg = acVar.getErrorString();
        return forumDetailData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForumDetailData forumDetailData) {
        super.onPostExecute(forumDetailData);
        d dVar = this.agj.get();
        if (dVar != null) {
            if (az.aA(forumDetailData.errmsg)) {
                dVar.a(forumDetailData);
            } else {
                dVar.b(forumDetailData);
            }
        }
    }
}
