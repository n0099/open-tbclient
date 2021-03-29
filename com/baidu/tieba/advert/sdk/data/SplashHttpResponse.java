package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.b.e.p.j;
import d.b.i0.r.a.e.b;
import d.b.i0.r.a.i.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SplashHttpResponse extends JsonHttpResponsedMessage {
    public AdInfo adInfo;
    public int errno;
    public String mResultMessage;

    public SplashHttpResponse(int i) {
        super(i);
        this.errno = -1;
    }

    private void dealVideoAd() {
        if (FileHelper.checkSD()) {
            b b2 = b.b(a.g());
            if (!this.adInfo.shouldDownloadVideo()) {
                AdInfo adInfo = this.adInfo;
                adInfo.videoLocalPath = b2.f59667d;
                a.j(adInfo);
            } else if (j.z() && j.H()) {
                d.b.i0.r.a.h.a searchTask = searchTask(this.adInfo.adVideoUrl);
                if (searchTask == null || searchTask.getStatus() == BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                    a.j(this.adInfo);
                    d.b.i0.r.a.h.a aVar = new d.b.i0.r.a.h.a();
                    aVar.c(this.adInfo);
                    aVar.setKey(this.adInfo.adVideoUrl);
                    aVar.execute(new Void[0]);
                }
            } else {
                a.j(this.adInfo);
            }
        }
    }

    private d.b.i0.r.a.h.a searchTask(String str) {
        BdAsyncTask<?, ?, ?> searchTask;
        if (TextUtils.isEmpty(str) || (searchTask = BdAsyncTask.searchTask(str)) == null || !(searchTask instanceof d.b.i0.r.a.h.a)) {
            return null;
        }
        try {
            return (d.b.i0.r.a.h.a) searchTask;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        super.decodeLogicInBackGround(i, jSONObject);
        this.errno = jSONObject.optInt("errno");
        this.mResultMessage = jSONObject.toString();
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            AdInfo adInfo = new AdInfo();
            this.adInfo = adInfo;
            adInfo.parseFromJson(jSONObject);
        }
        if (this.adInfo.isVideoUrlValide()) {
            dealVideoAd();
            return;
        }
        AdInfo adInfo2 = this.adInfo;
        adInfo2.videoLocalPath = "";
        a.j(adInfo2);
    }

    public int getErrno() {
        return this.errno;
    }

    public String getResultMsg() {
        return this.mResultMessage;
    }
}
