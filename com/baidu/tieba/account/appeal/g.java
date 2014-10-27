package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ay;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Object, AppealData> {
    private String afX;
    private String afY;
    private String afZ;
    private String aga;
    private WeakReference<h> agb;

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.afX = str;
        this.afY = str2;
        this.afZ = str3;
        this.aga = str4;
        this.agb = new WeakReference<>(hVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public AppealData doInBackground(String... strArr) {
        String str;
        str = f.afW;
        ac acVar = new ac(str);
        acVar.k("forum_id", this.afX);
        acVar.k(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.afY);
        acVar.k(com.baidu.tbadk.core.frameworkData.a.USER_NAME, this.afZ);
        acVar.k("content", this.aga);
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
        h hVar = this.agb.get();
        if (hVar != null) {
            if (appealData.errNo == 0 && ay.aA(appealData.errMsg)) {
                hVar.a(appealData);
            } else {
                hVar.b(appealData);
            }
        }
    }
}
