package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public int hMY;
    public String hMZ;
    public int hNa;
    public String hNb;
    public int hNc;
    public int hNd;
    public String hNe;
    public int hNf;
    public String hNg;
    public int hNh;
    public int hNi;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hNi = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hMY = optJSONObject.optInt("isok");
                this.hMZ = optJSONObject.optString("content");
                this.hNa = optJSONObject.optInt("type");
                this.hNb = optJSONObject.optString("h5url");
                this.hNc = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hNd = optJSONObject2.optInt("isok");
                this.hNe = optJSONObject2.optString("content");
                this.hNf = optJSONObject2.optInt("type");
                this.hNg = optJSONObject2.optString("h5url");
                this.hNh = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
