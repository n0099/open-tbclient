package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public int hAQ;
    public String hAR;
    public int hAS;
    public String hAT;
    public int hAU;
    public int hAV;
    public String hAW;
    public int hAX;
    public String hAY;
    public int hAZ;
    public int hBa;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hBa = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hAQ = optJSONObject.optInt("isok");
                this.hAR = optJSONObject.optString("content");
                this.hAS = optJSONObject.optInt("type");
                this.hAT = optJSONObject.optString("h5url");
                this.hAU = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hAV = optJSONObject2.optInt("isok");
                this.hAW = optJSONObject2.optString("content");
                this.hAX = optJSONObject2.optInt("type");
                this.hAY = optJSONObject2.optString("h5url");
                this.hAZ = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
