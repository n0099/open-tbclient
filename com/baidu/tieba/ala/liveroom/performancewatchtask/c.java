package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public int hOH;
    public String hOI;
    public int hOJ;
    public String hOK;
    public int hOL;
    public int hOM;
    public String hON;
    public int hOO;
    public String hOP;
    public int hOQ;
    public int hOR;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hOR = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hOH = optJSONObject.optInt("isok");
                this.hOI = optJSONObject.optString("content");
                this.hOJ = optJSONObject.optInt("type");
                this.hOK = optJSONObject.optString("h5url");
                this.hOL = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hOM = optJSONObject2.optInt("isok");
                this.hON = optJSONObject2.optString("content");
                this.hOO = optJSONObject2.optInt("type");
                this.hOP = optJSONObject2.optString("h5url");
                this.hOQ = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
