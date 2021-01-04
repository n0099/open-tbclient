package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public int hMS;
    public String hMT;
    public int hMU;
    public String hMV;
    public int hMW;
    public int hMX;
    public String hMY;
    public int hMZ;
    public String hNa;
    public int hNb;
    public int hNc;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hNc = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hMS = optJSONObject.optInt("isok");
                this.hMT = optJSONObject.optString("content");
                this.hMU = optJSONObject.optInt("type");
                this.hMV = optJSONObject.optString("h5url");
                this.hMW = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hMX = optJSONObject2.optInt("isok");
                this.hMY = optJSONObject2.optString("content");
                this.hMZ = optJSONObject2.optInt("type");
                this.hNa = optJSONObject2.optString("h5url");
                this.hNb = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
