package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public int hAS;
    public String hAT;
    public int hAU;
    public String hAV;
    public int hAW;
    public int hAX;
    public String hAY;
    public int hAZ;
    public String hBa;
    public int hBb;
    public int hBc;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hBc = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hAS = optJSONObject.optInt("isok");
                this.hAT = optJSONObject.optString("content");
                this.hAU = optJSONObject.optInt("type");
                this.hAV = optJSONObject.optString("h5url");
                this.hAW = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hAX = optJSONObject2.optInt("isok");
                this.hAY = optJSONObject2.optString("content");
                this.hAZ = optJSONObject2.optInt("type");
                this.hBa = optJSONObject2.optString("h5url");
                this.hBb = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
