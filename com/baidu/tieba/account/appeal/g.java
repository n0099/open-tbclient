package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bb;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<String, Object, AppealData> {
    private String ayf;
    private String ayg;
    private String ayh;
    private String ayi;
    private WeakReference<h> ayj;

    public g(String str, String str2, String str3, String str4, h hVar) {
        this.ayf = str;
        this.ayg = str2;
        this.ayh = str3;
        this.ayi = str4;
        this.ayj = new WeakReference<>(hVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public AppealData doInBackground(String... strArr) {
        String str;
        str = f.aye;
        aa aaVar = new aa(str);
        aaVar.o("forum_id", this.ayf);
        aaVar.o("user_id", this.ayg);
        aaVar.o("user_name", this.ayh);
        aaVar.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, this.ayi);
        String sw = aaVar.sw();
        if (aaVar.sX().tT().qa()) {
            try {
                return (AppealData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(sw, AppealData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                AppealData appealData = new AppealData();
                appealData.errNo = -1000;
                return appealData;
            }
        }
        AppealData appealData2 = new AppealData();
        appealData2.errNo = aaVar.tb();
        appealData2.errMsg = aaVar.getErrorString();
        return appealData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(AppealData appealData) {
        super.onPostExecute(appealData);
        h hVar = this.ayj.get();
        if (hVar != null) {
            if (appealData.errNo == 0 && bb.isEmpty(appealData.errMsg)) {
                hVar.a(appealData);
            } else {
                hVar.b(appealData);
            }
        }
    }
}
