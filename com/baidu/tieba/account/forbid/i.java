package com.baidu.tieba.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.pluginArch.PluginLogger;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Object, ForbidResultData> {
    private WeakReference<j> agj;
    private String agz;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private String mUserName;
    private String pT;

    public i(String str, String str2, String str3, String str4, String str5, String str6, j jVar) {
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mUserName = str4;
        this.agz = str5;
        this.pT = str6;
        this.agj = new WeakReference<>(jVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public ForbidResultData doInBackground(String... strArr) {
        String str;
        str = h.agy;
        ac acVar = new ac(str);
        acVar.k("day", this.agz);
        acVar.k("un", this.mUserName);
        acVar.k(ImageViewerConfig.FORUM_ID, this.mForumId);
        acVar.k("word", this.mForumName);
        acVar.k("z", this.mThreadId);
        acVar.k(PluginLogger.KEY_REASON, this.pT);
        acVar.k("ntn", "banid");
        acVar.mc().na().mIsNeedTbs = true;
        String lA = acVar.lA();
        if (acVar.mc().nb().jq()) {
            try {
                return (ForbidResultData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, ForbidResultData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.error_code = -1000;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.error_code = acVar.mg();
        forbidResultData2.error_msg = acVar.getErrorString();
        return forbidResultData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidResultData forbidResultData) {
        super.onPostExecute(forbidResultData);
        j jVar = this.agj.get();
        if (jVar != null) {
            if (forbidResultData.error_code == 0 && az.aA(forbidResultData.error_msg)) {
                jVar.a(forbidResultData);
            } else {
                jVar.b(forbidResultData);
            }
        }
    }
}
