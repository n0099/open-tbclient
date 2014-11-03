package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.az;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Object, ForbidTplData> {
    private String agf;
    private String agg;
    private WeakReference<n> agj;

    public m(String str, String str2, n nVar) {
        this.agf = str;
        this.agg = str2;
        this.agj = new WeakReference<>(nVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: r */
    public ForbidTplData doInBackground(String... strArr) {
        String str;
        str = l.agA;
        ac acVar = new ac(str);
        acVar.k("forum_id", this.agf);
        acVar.k(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.agg);
        String lA = acVar.lA();
        if (acVar.mc().nb().jq()) {
            try {
                return (ForbidTplData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, ForbidTplData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidTplData forbidTplData = new ForbidTplData();
                forbidTplData.error.errno = -1000;
                return forbidTplData;
            }
        }
        ForbidTplData forbidTplData2 = new ForbidTplData();
        forbidTplData2.error.errno = acVar.mg();
        forbidTplData2.error.errMsg = acVar.getErrorString();
        return forbidTplData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidTplData forbidTplData) {
        super.onPostExecute(forbidTplData);
        n nVar = this.agj.get();
        if (nVar != null) {
            if (forbidTplData.error.errno == 0 && az.aA(forbidTplData.error.errMsg)) {
                nVar.a(forbidTplData);
            } else {
                nVar.b(forbidTplData);
            }
        }
    }
}
