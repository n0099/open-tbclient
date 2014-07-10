package com.baidu.tieba.discover;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bm;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Object, n> {
    private WeakReference<l> a;

    public k(l lVar) {
        this.a = new WeakReference<>(lVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public n doInBackground(String... strArr) {
        String str;
        str = j.a;
        aq aqVar = new aq(str);
        String i = aqVar.i();
        if (aqVar.a().b().b()) {
            try {
                return DiscoverResponsedMessage.parseJson(new JSONObject(i));
            } catch (Exception e) {
                BdLog.detailException(e);
                n nVar = new n();
                nVar.a = -1000;
                nVar.b = "网络异常";
                return nVar;
            }
        }
        n nVar2 = new n();
        nVar2.a = aqVar.d();
        nVar2.b = aqVar.f();
        return nVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(n nVar) {
        super.onPostExecute(nVar);
        l lVar = this.a.get();
        if (lVar != null) {
            if (bm.c(nVar.b)) {
                lVar.a(nVar);
            } else {
                lVar.b(nVar);
            }
        }
    }
}
