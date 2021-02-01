package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public int hMK;
    public String hML;
    public int hMM;
    public String hMN;
    public int hMO;
    public int hMP;
    public String hMQ;
    public int hMR;
    public String hMS;
    public int hMT;
    public int hMU;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hMU = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hMK = optJSONObject.optInt("isok");
                this.hML = optJSONObject.optString("content");
                this.hMM = optJSONObject.optInt("type");
                this.hMN = optJSONObject.optString("h5url");
                this.hMO = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hMP = optJSONObject2.optInt("isok");
                this.hMQ = optJSONObject2.optString("content");
                this.hMR = optJSONObject2.optInt("type");
                this.hMS = optJSONObject2.optString("h5url");
                this.hMT = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
