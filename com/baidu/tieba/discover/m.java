package com.baidu.tieba.discover;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.az;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Object, p> {
    private final WeakReference<n> agj;

    public m(n nVar) {
        this.agj = new WeakReference<>(nVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: s */
    public p doInBackground(String... strArr) {
        String str;
        str = l.aob;
        ac acVar = new ac(str);
        String lA = acVar.lA();
        if (acVar.mc().nb().jq()) {
            try {
                return DiscoverResponsedMessage.parseJson(new JSONObject(lA));
            } catch (Exception e) {
                BdLog.detailException(e);
                p pVar = new p();
                pVar.afd = -1000;
                pVar.mErrMsg = "网络异常";
                return pVar;
            }
        }
        p pVar2 = new p();
        pVar2.afd = acVar.mg();
        pVar2.mErrMsg = acVar.getErrorString();
        return pVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(p pVar) {
        super.onPostExecute(pVar);
        n nVar = this.agj.get();
        if (nVar != null) {
            if (az.aA(pVar.mErrMsg)) {
                nVar.a(pVar);
            } else {
                nVar.b(pVar);
            }
        }
    }
}
