package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.az;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Object, AppealData> {
    private String agf;
    private String agg;
    private String agh;
    private String agi;
    private WeakReference<h> agj;

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.agf = str;
        this.agg = str2;
        this.agh = str3;
        this.agi = str4;
        this.agj = new WeakReference<>(hVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public AppealData doInBackground(String... strArr) {
        String str;
        str = f.age;
        ac acVar = new ac(str);
        acVar.k("forum_id", this.agf);
        acVar.k(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.agg);
        acVar.k(com.baidu.tbadk.core.frameworkData.a.USER_NAME, this.agh);
        acVar.k("content", this.agi);
        String lA = acVar.lA();
        if (acVar.mc().nb().jq()) {
            try {
                return (AppealData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, AppealData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                AppealData appealData = new AppealData();
                appealData.errNo = -1000;
                return appealData;
            }
        }
        AppealData appealData2 = new AppealData();
        appealData2.errNo = acVar.mg();
        appealData2.errMsg = acVar.getErrorString();
        return appealData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(AppealData appealData) {
        super.onPostExecute(appealData);
        h hVar = this.agj.get();
        if (hVar != null) {
            if (appealData.errNo == 0 && az.aA(appealData.errMsg)) {
                hVar.a(appealData);
            } else {
                hVar.b(appealData);
            }
        }
    }
}
