package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Object, ForbidTplData> {
    private WeakReference<n> anA;
    private String anw;
    private String anx;

    public m(String str, String str2, n nVar) {
        this.anw = str;
        this.anx = str2;
        this.anA = new WeakReference<>(nVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: u */
    public ForbidTplData doInBackground(String... strArr) {
        String str;
        str = l.anR;
        ad adVar = new ad(str);
        adVar.o("forum_id", this.anw);
        adVar.o("user_id", this.anx);
        String ov = adVar.ov();
        if (adVar.oW().pW().ma()) {
            try {
                return (ForbidTplData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(ov, ForbidTplData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidTplData forbidTplData = new ForbidTplData();
                forbidTplData.error.errno = -1000;
                return forbidTplData;
            }
        }
        ForbidTplData forbidTplData2 = new ForbidTplData();
        forbidTplData2.error.errno = adVar.pa();
        forbidTplData2.error.errMsg = adVar.getErrorString();
        return forbidTplData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidTplData forbidTplData) {
        super.onPostExecute(forbidTplData);
        n nVar = this.anA.get();
        if (nVar != null) {
            if (forbidTplData.error.errno == 0 && ba.isEmpty(forbidTplData.error.errMsg)) {
                nVar.a(forbidTplData);
            } else {
                nVar.b(forbidTplData);
            }
        }
    }
}
