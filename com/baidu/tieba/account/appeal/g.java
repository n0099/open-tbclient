package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bf;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Object, AppealData> {
    private String aoo;
    private String aop;
    private String aoq;
    private String aor;
    private WeakReference<h> aos;

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.aoo = str;
        this.aop = str2;
        this.aoq = str3;
        this.aor = str4;
        this.aos = new WeakReference<>(hVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: r */
    public AppealData doInBackground(String... strArr) {
        String str;
        str = f.aon;
        ad adVar = new ad(str);
        adVar.o("forum_id", this.aoo);
        adVar.o("user_id", this.aop);
        adVar.o("user_name", this.aoq);
        adVar.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.aor);
        String or = adVar.or();
        if (adVar.oS().qa().lT()) {
            try {
                return (AppealData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(or, AppealData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                AppealData appealData = new AppealData();
                appealData.errNo = -1000;
                return appealData;
            }
        }
        AppealData appealData2 = new AppealData();
        appealData2.errNo = adVar.oW();
        appealData2.errMsg = adVar.getErrorString();
        return appealData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(AppealData appealData) {
        super.onPostExecute(appealData);
        h hVar = this.aos.get();
        if (hVar != null) {
            if (appealData.errNo == 0 && bf.isEmpty(appealData.errMsg)) {
                hVar.a(appealData);
            } else {
                hVar.b(appealData);
            }
        }
    }
}
