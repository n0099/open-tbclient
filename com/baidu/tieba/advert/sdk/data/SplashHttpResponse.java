package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class SplashHttpResponse extends JsonHttpResponsedMessage {
    private AdInfo adInfo;
    private int errno;
    private String mResultMessage;

    public SplashHttpResponse(int i) {
        super(i);
        this.errno = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.errno = jSONObject.optInt("errno");
            this.mResultMessage = jSONObject.toString();
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error >= 0 && jSONObject != null) {
                this.adInfo = new AdInfo();
                this.adInfo.parseFromJson(jSONObject);
            }
            if (this.adInfo.isVideoUrlValide()) {
                dealVideoAd();
                return;
            }
            this.adInfo.videoLocalPath = "";
            com.baidu.tieba.advert.sdk.c.a.c(this.adInfo);
        }
    }

    private void dealVideoAd() {
        if (m.checkSD()) {
            b xA = b.xA(com.baidu.tieba.advert.sdk.c.a.aZq());
            if (!this.adInfo.shouldDownloadVideo()) {
                this.adInfo.videoLocalPath = xA.videoLocalPath;
                com.baidu.tieba.advert.sdk.c.a.c(this.adInfo);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                com.baidu.tieba.advert.sdk.b.a searchTask = searchTask(this.adInfo.adVideoUrl);
                if (searchTask == null || searchTask.getStatus() == BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                    com.baidu.tieba.advert.sdk.c.a.c(this.adInfo);
                    com.baidu.tieba.advert.sdk.b.a aVar = new com.baidu.tieba.advert.sdk.b.a();
                    aVar.b(this.adInfo);
                    aVar.setKey(this.adInfo.adVideoUrl);
                    aVar.execute(new Void[0]);
                }
            } else {
                com.baidu.tieba.advert.sdk.c.a.c(this.adInfo);
            }
        }
    }

    private com.baidu.tieba.advert.sdk.b.a searchTask(String str) {
        BdAsyncTask<?, ?, ?> searchTask;
        if (!TextUtils.isEmpty(str) && (searchTask = BdAsyncTask.searchTask(str)) != null && (searchTask instanceof com.baidu.tieba.advert.sdk.b.a)) {
            try {
                return (com.baidu.tieba.advert.sdk.b.a) searchTask;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public int getErrno() {
        return this.errno;
    }

    public String getResultMsg() {
        return this.mResultMessage;
    }
}
