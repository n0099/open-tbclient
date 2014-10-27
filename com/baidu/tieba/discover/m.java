package com.baidu.tieba.discover;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ay;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Object, p> {
    private final WeakReference<n> agb;

    public m(n nVar) {
        this.agb = new WeakReference<>(nVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: s */
    public p doInBackground(String... strArr) {
        String str;
        str = l.anS;
        ac acVar = new ac(str);
        String lA = acVar.lA();
        if (acVar.mc().nb().jq()) {
            try {
                return DiscoverResponsedMessage.parseJson(new JSONObject(lA));
            } catch (Exception e) {
                BdLog.detailException(e);
                p pVar = new p();
                pVar.aeV = -1000;
                pVar.mErrMsg = "网络异常";
                return pVar;
            }
        }
        p pVar2 = new p();
        pVar2.aeV = acVar.mg();
        pVar2.mErrMsg = acVar.getErrorString();
        return pVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(p pVar) {
        super.onPostExecute(pVar);
        n nVar = this.agb.get();
        if (nVar != null) {
            if (ay.aA(pVar.mErrMsg)) {
                nVar.a(pVar);
            } else {
                nVar.b(pVar);
            }
        }
    }
}
