package com.baidu.tieba.discover;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Object, p> {
    private final WeakReference<n> a;

    public m(n nVar) {
        this.a = new WeakReference<>(nVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public p doInBackground(String... strArr) {
        String str;
        str = l.a;
        ae aeVar = new ae(str);
        String h = aeVar.h();
        if (aeVar.a().b().b()) {
            try {
                return DiscoverResponsedMessage.parseJson(new JSONObject(h));
            } catch (Exception e) {
                BdLog.detailException(e);
                p pVar = new p();
                pVar.a = -1000;
                pVar.b = "网络异常";
                return pVar;
            }
        }
        p pVar2 = new p();
        pVar2.a = aeVar.c();
        pVar2.b = aeVar.e();
        return pVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(p pVar) {
        super.onPostExecute(pVar);
        n nVar = this.a.get();
        if (nVar != null) {
            if (ba.c(pVar.b)) {
                nVar.a(pVar);
            } else {
                nVar.b(pVar);
            }
        }
    }
}
