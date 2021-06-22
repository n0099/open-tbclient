package com.baidu.tieba.funAd.strategy;

import com.baidu.adp.lib.util.BdLog;
import d.a.n0.r.q.o;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FunAdHistoryData extends o implements Serializable {
    public String mFunAdKey;
    public long mShowTime;

    public String getFunAdKey() {
        return this.mFunAdKey;
    }

    public long getShowTime() {
        return this.mShowTime;
    }

    @Override // d.a.n0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.mShowTime = jSONObject.optLong("show_time", 0L);
            this.mFunAdKey = jSONObject.optString("fun_ad_key", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void setFunAdKey(String str) {
        this.mFunAdKey = str;
    }

    public void setShowTime(long j) {
        this.mShowTime = j;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("show_time", this.mShowTime);
            jSONObject.put("fun_ad_key", this.mFunAdKey);
        } catch (JSONException e2) {
            BdLog.detailException(e2);
        }
        return jSONObject;
    }
}
