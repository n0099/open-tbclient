package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.c.e.p.j;
import d.a.k0.r.a.f.b;
import d.a.k0.r.a.j.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SplashHttpResponse extends JsonHttpResponsedMessage {
    public AdInfo adInfo;
    public int errno;
    public String mResultMessage;

    public SplashHttpResponse(int i2) {
        super(i2);
        this.errno = -1;
    }

    private void dealVideoAd() {
        if (FileHelper.checkSD()) {
            b b2 = b.b(a.d());
            if (!this.adInfo.shouldDownloadVideo()) {
                AdInfo adInfo = this.adInfo;
                adInfo.videoLocalPath = b2.f60224d;
                a.f(adInfo);
            } else if (j.z() && j.H()) {
                d.a.k0.r.a.i.a searchTask = searchTask(this.adInfo.adVideoUrl);
                if (searchTask == null || searchTask.getStatus() == BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                    a.f(this.adInfo);
                    d.a.k0.r.a.i.a aVar = new d.a.k0.r.a.i.a();
                    aVar.c(this.adInfo);
                    aVar.setKey(this.adInfo.adVideoUrl);
                    aVar.execute(new Void[0]);
                }
            } else {
                a.f(this.adInfo);
            }
        }
    }

    private d.a.k0.r.a.i.a searchTask(String str) {
        BdAsyncTask<?, ?, ?> searchTask;
        if (TextUtils.isEmpty(str) || (searchTask = BdAsyncTask.searchTask(str)) == null || !(searchTask instanceof d.a.k0.r.a.i.a)) {
            return null;
        }
        try {
            return (d.a.k0.r.a.i.a) searchTask;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        super.decodeLogicInBackGround(i2, jSONObject);
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
        a.f(adInfo2);
    }

    public int getErrno() {
        return this.errno;
    }

    public String getResultMsg() {
        return this.mResultMessage;
    }
}
