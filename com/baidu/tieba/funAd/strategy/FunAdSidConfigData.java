package com.baidu.tieba.funAd.strategy;

import com.baidu.adp.lib.util.BdLog;
import d.a.m0.r.q.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FunAdSidConfigData extends o implements Serializable {
    public List<String> mBearSidList = new ArrayList();
    public long mExpiryTime;
    public int mForce;
    public int mRecordNum;
    public long mSpace;
    public int mThreshold;

    public List<String> getBearSidList() {
        return this.mBearSidList;
    }

    public long getExpiryTime() {
        return this.mExpiryTime;
    }

    public int getForce() {
        return this.mForce;
    }

    public int getRecordNum() {
        return this.mRecordNum;
    }

    public long getSpace() {
        return this.mSpace;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    @Override // d.a.m0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("bear_sid_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.mBearSidList.add(optJSONArray.getString(i2));
                }
            }
            this.mThreshold = jSONObject.optInt("threshold", 0);
            this.mExpiryTime = jSONObject.optLong("expiry_time", 0L);
            this.mRecordNum = jSONObject.optInt("record_num", 0);
            this.mSpace = jSONObject.optLong("space", 0L);
            this.mForce = jSONObject.optInt("force", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void setBearSidList(List<String> list) {
        this.mBearSidList = list;
    }

    public void setExpiryTime(long j) {
        this.mExpiryTime = j;
    }

    public void setForce(int i2) {
        this.mForce = i2;
    }

    public void setRecordNum(int i2) {
        this.mRecordNum = i2;
    }

    public void setSpace(long j) {
        this.mSpace = j;
    }

    public void setThreshold(int i2) {
        this.mThreshold = i2;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String str : this.mBearSidList) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put("bear_sid_list", jSONArray);
            jSONObject.put("threshold", this.mThreshold);
            jSONObject.put("expiry_time", this.mExpiryTime);
            jSONObject.put("record_num", this.mRecordNum);
            jSONObject.put("space", this.mSpace);
            jSONObject.put("force", this.mForce);
        } catch (JSONException e2) {
            BdLog.detailException(e2);
        }
        return jSONObject;
    }
}
