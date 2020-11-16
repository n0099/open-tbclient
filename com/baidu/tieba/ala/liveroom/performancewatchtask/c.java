package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public int hrm;
    public String hrn;
    public int hro;
    public String hrp;
    public int hrq;
    public int hrr;
    public String hrs;
    public int hrt;
    public String hru;
    public int hrv;
    public int hrw;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hrw = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hrm = optJSONObject.optInt("isok");
                this.hrn = optJSONObject.optString("content");
                this.hro = optJSONObject.optInt("type");
                this.hrp = optJSONObject.optString("h5url");
                this.hrq = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hrr = optJSONObject2.optInt("isok");
                this.hrs = optJSONObject2.optString("content");
                this.hrt = optJSONObject2.optInt("type");
                this.hru = optJSONObject2.optString("h5url");
                this.hrv = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
