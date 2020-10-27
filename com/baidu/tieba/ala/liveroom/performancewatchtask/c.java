package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public int hlH;
    public String hlI;
    public int hlJ;
    public String hlK;
    public int hlL;
    public int hlM;
    public String hlN;
    public int hlO;
    public String hlP;
    public int hlQ;
    public int hlR;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hlR = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hlH = optJSONObject.optInt("isok");
                this.hlI = optJSONObject.optString("content");
                this.hlJ = optJSONObject.optInt("type");
                this.hlK = optJSONObject.optString("h5url");
                this.hlL = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hlM = optJSONObject2.optInt("isok");
                this.hlN = optJSONObject2.optString("content");
                this.hlO = optJSONObject2.optInt("type");
                this.hlP = optJSONObject2.optString("h5url");
                this.hlQ = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
