package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Object, AppealData> {
    private WeakReference<h> anA;
    private String anw;
    private String anx;
    private String any;
    private String anz;

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.anw = str;
        this.anx = str2;
        this.any = str3;
        this.anz = str4;
        this.anA = new WeakReference<>(hVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: r */
    public AppealData doInBackground(String... strArr) {
        String str;
        str = f.anv;
        ad adVar = new ad(str);
        adVar.o("forum_id", this.anw);
        adVar.o("user_id", this.anx);
        adVar.o("user_name", this.any);
        adVar.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.anz);
        String ov = adVar.ov();
        if (adVar.oW().pW().ma()) {
            try {
                return (AppealData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(ov, AppealData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                AppealData appealData = new AppealData();
                appealData.errNo = -1000;
                return appealData;
            }
        }
        AppealData appealData2 = new AppealData();
        appealData2.errNo = adVar.pa();
        appealData2.errMsg = adVar.getErrorString();
        return appealData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(AppealData appealData) {
        super.onPostExecute(appealData);
        h hVar = this.anA.get();
        if (hVar != null) {
            if (appealData.errNo == 0 && ba.isEmpty(appealData.errMsg)) {
                hVar.a(appealData);
            } else {
                hVar.b(appealData);
            }
        }
    }
}
