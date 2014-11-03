package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, Boolean> {
    private final String aAe;
    private final d aAf;
    final /* synthetic */ b aAg;
    private final String mForumId;
    private final String mForumName;
    private com.baidu.tbadk.core.util.ac yV;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public Boolean doInBackground(String... strArr) {
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(strArr[0]);
            this.yV.k(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.yV.k("kw", this.mForumName);
            this.yV.k("is_like", this.aAe);
            this.yV.mc().na().mIsNeedTbs = true;
            String lA = this.yV.lA();
            if (this.yV.mf()) {
                if (this.aAe.equals("0")) {
                    try {
                        JSONObject jSONObject = new JSONObject(lA);
                        JSONObject optJSONObject = jSONObject.optJSONObject("like_data");
                        if (optJSONObject.optInt("is_success", 0) == 1) {
                            this.aAf.level = optJSONObject.optInt("level_id", 0);
                            this.aAf.aAk = optJSONObject.optString("level_name", "");
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_perm");
                            if (optJSONObject2 != null) {
                                this.aAf.cur_score = optJSONObject2.optInt("cur_score", 0);
                                this.aAf.levelup_score = optJSONObject2.optInt("levelup_score", 0);
                            }
                            this.aAf.aAi = true;
                        }
                        this.aAg.a(this.aAf);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                }
                if (this.yV.mc().nb().jq()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(lA);
                        this.aAf.aAj = jSONObject2.optInt("num");
                        this.aAf.aAh = true;
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            BdLog.e(e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.yV != null) {
            this.yV.dM();
        }
        this.aAg.azX = null;
        this.aAg.bR(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        dc dcVar;
        dc dcVar2;
        this.aAg.azX = null;
        this.aAg.bR(false);
        if (this.yV != null) {
            e eVar = new e();
            eVar.errorMsg = this.yV.getErrorString();
            eVar.errorCode = this.yV.mg();
            dcVar = this.aAg.azU;
            if (dcVar != null) {
                dcVar2 = this.aAg.azU;
                dcVar2.a(this.aAf, eVar);
            }
        }
    }
}
