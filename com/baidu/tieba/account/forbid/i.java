package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bf;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Object, ForbidResultData> {
    private String aoI;
    private WeakReference<j> aos;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;
    private String mUserName;
    private String pU;

    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7, j jVar) {
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mUserName = str4;
        this.aoI = str6;
        this.pU = str7;
        this.mPostId = str5;
        this.aos = new WeakReference<>(jVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: t */
    public ForbidResultData doInBackground(String... strArr) {
        String str;
        str = h.aoH;
        ad adVar = new ad(str);
        adVar.o("day", this.aoI);
        adVar.o("un", this.mUserName);
        adVar.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        adVar.o("word", this.mForumName);
        adVar.o("z", this.mThreadId);
        adVar.o("reason", this.pU);
        adVar.o("ntn", "banid");
        adVar.o("post_id", this.mPostId);
        adVar.oS().pZ().mIsNeedTbs = true;
        String or = adVar.or();
        if (adVar.oS().qa().lT()) {
            try {
                return (ForbidResultData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(or, ForbidResultData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.error_code = -1000;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.error_code = adVar.oW();
        forbidResultData2.error_msg = adVar.getErrorString();
        return forbidResultData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidResultData forbidResultData) {
        super.onPostExecute(forbidResultData);
        j jVar = this.aos.get();
        if (jVar != null) {
            if (forbidResultData.error_code == 0 && bf.isEmpty(forbidResultData.error_msg)) {
                jVar.a(forbidResultData);
            } else {
                jVar.b(forbidResultData);
            }
        }
    }
}
