package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Object, ForbidResultData> {
    private WeakReference<j> anA;
    private String anQ;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private String mUserName;
    private String pP;

    public i(String str, String str2, String str3, String str4, String str5, String str6, j jVar) {
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mUserName = str4;
        this.anQ = str5;
        this.pP = str6;
        this.anA = new WeakReference<>(jVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: t */
    public ForbidResultData doInBackground(String... strArr) {
        String str;
        str = h.anP;
        ad adVar = new ad(str);
        adVar.o("day", this.anQ);
        adVar.o("un", this.mUserName);
        adVar.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        adVar.o("word", this.mForumName);
        adVar.o("z", this.mThreadId);
        adVar.o("reason", this.pP);
        adVar.o("ntn", "banid");
        adVar.oW().pV().mIsNeedTbs = true;
        String ov = adVar.ov();
        if (adVar.oW().pW().ma()) {
            try {
                return (ForbidResultData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(ov, ForbidResultData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.error_code = -1000;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.error_code = adVar.pa();
        forbidResultData2.error_msg = adVar.getErrorString();
        return forbidResultData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidResultData forbidResultData) {
        super.onPostExecute(forbidResultData);
        j jVar = this.anA.get();
        if (jVar != null) {
            if (forbidResultData.error_code == 0 && ba.isEmpty(forbidResultData.error_msg)) {
                jVar.a(forbidResultData);
            } else {
                jVar.b(forbidResultData);
            }
        }
    }
}
